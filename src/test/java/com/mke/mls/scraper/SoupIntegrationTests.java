package com.mke.mls.scraper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mke.mls.scraper.domain.MlsListing;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.FileWriter;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class SoupIntegrationTests {

    private static File detailResponse;
    private static File pageResponse;

    private static final String LISTINGS_SITE = "http://mymobile.flexmls.com/donnaschoessow/contacts/20170324014231602695000000/newsfeeds/listings";

    private ObjectMapper objectMapper = new ObjectMapper();

    @BeforeClass
    public static void setupFiles() throws Exception {
        detailResponse = new ClassPathResource("html_response.html").getFile();
        pageResponse = new ClassPathResource("page_request.html").getFile();
    }

    @Test
    public void parsePage() throws Exception {
        List<MlsListing> listings = Jsoup.parse(pageResponse, "UTF-8")
                .select("li.photo-listing-card > div.photo-listing-card-wrapper > a.saveListingLink")
                .stream()
                .map((anchor) -> anchor.attr("data-listing"))
                .map((dataJson) -> {
                    try {
                        return objectMapper.readValue(dataJson, MlsListing.class);
                    } catch (Exception e) {
                        return null;
                    }
                })
                .filter((result) -> result != null)
                .collect(Collectors.toList());

        assertEquals(10, listings.size());
    }

    @Test
    public void parseDetailPage() throws Exception {
        Jsoup.parse(detailResponse, "UTF-8")
            ;
    }

}

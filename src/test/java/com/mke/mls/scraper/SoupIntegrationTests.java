package com.mke.mls.scraper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.CaseFormat;
import com.google.common.base.CharMatcher;
import com.mke.mls.scraper.domain.MlsListing;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.FileWriter;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class SoupIntegrationTests {

    private static File detailResponse;
    private static File pageResponse;

    private static final Log logger = LogFactory.getLog(SoupIntegrationTests.class);

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
        List<Map> listingDetailsMaps = Jsoup.parse(detailResponse, "UTF-8")
            .select(".detail-fields-group")
            .stream()
            .map((group) -> {
                final Map<String, Object> listingDetails = new HashMap<>();
                final String key = getLowerCaseKey(group.text());

                Map<String, String> detailEntries = group.nextElementSibling()
                        .select(".detail-field-wrapper")
                        .stream()
                        .filter((wrapper) -> wrapper.children().select(".detail-fields-key").first() != null)
                        .map((wrapper) -> {
                            String wrapperKey = getLowerCaseKey(wrapper
                                    .select(".detail-fields-key")
                                    .text());

                            String value = wrapper.children().select(".detail-fields-value").text();
                            return new AbstractMap.SimpleEntry<>(wrapperKey, value);
                        })
                        .collect(Collectors.toMap((e) -> e.getKey(), (e) -> e.getValue()));

                listingDetails.put(key, detailEntries);

                return listingDetails;
            })
            .collect(Collectors.toList());

        assertEquals(26, listingDetailsMaps.size());
    }

    private String getLowerCaseKey(String sequence) {
        String retVal = sequence.toLowerCase();

        retVal = CharMatcher
                .whitespace()
                .replaceFrom(retVal, "_");

        retVal = CharMatcher
                .javaLetterOrDigit()
                .or(CharMatcher.is('_'))
                .retainFrom(retVal);

        return retVal;
    }

    @Test
    public void testString() {
        String toJoin = "#Status Change Info".toLowerCase();

        toJoin = getLowerCaseKey(toJoin);

        assertEquals("status_change_info", toJoin);
    }

}

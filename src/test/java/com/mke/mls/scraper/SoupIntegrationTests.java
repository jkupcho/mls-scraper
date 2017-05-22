package com.mke.mls.scraper;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jsoup.Jsoup;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

public class SoupIntegrationTests {

    private final Log logger = LogFactory.getLog(getClass());

    public static final String LISTINGS_SITE = "http://mymobile.flexmls.com/donnaschoessow/contacts/20170324014231602695000000/newsfeeds/listings";

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void parsePage() throws Exception {

        List<String> dataListingJson = Jsoup.connect(LISTINGS_SITE)
                .header("X-Requested-With", "XMLHttpRequest")
                .get()
                .select("li.photo-listing-card > div.photo-listing-card-wrapper > a.saveListingLink")
                .stream()
                .map((anchor) -> anchor.attr("data-listing"))
                .collect(Collectors.toList());

//        logger.info(Arrays.toString(dataListingJson.toArray()));
    }

}

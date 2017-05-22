package com.mke.mls.scraper.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;

public class MlsListingTests {

    private ObjectMapper objectMapper = new ObjectMapper();

    private InputStream listingJsonInputStream;

    @Before
    public void setup() throws IOException {
        listingJsonInputStream = new ClassPathResource("listing.json").getInputStream();
    }

    @Test
    public void readValue_ProducesCorrectResult() throws IOException {
        MlsListing mlsListing = objectMapper.readValue(listingJsonInputStream, MlsListing.class);

        // Amenities
        assertEquals(2.0, mlsListing.getAmenities().getBaths(), 0.1f);
        assertEquals(3, mlsListing.getAmenities().getBeds());

        // Financial
        assertEquals(259000.0, mlsListing.getFinancial().getListPrice(), 0.1f);

        // MlsIdentity
        assertEquals("20010602000846355519000000", mlsListing.getMlsIdentity().getId());
        assertEquals("Active", mlsListing.getMlsIdentity().getStatus());
        assertEquals("1234", mlsListing.getMlsIdentity().getAgentId());
        assertEquals("1529680", mlsListing.getMlsIdentity().getListId());
        assertEquals("20170516184941000272000000", mlsListing.getMlsIdentity().getListKey());

        // Location
        assertEquals("New Berlin", mlsListing.getLocation().getAddress().getCity());
        assertEquals("53151-2316", mlsListing.getLocation().getAddress().getPostalCode());
        assertEquals("WI", mlsListing.getLocation().getAddress().getState());
        assertEquals("Dirt", mlsListing.getLocation().getAddress().getStreet().getAdditionalInfo());
        assertEquals("W", mlsListing.getLocation().getAddress().getStreet().getDirPrefix());
        assertEquals("N", mlsListing.getLocation().getAddress().getStreet().getDirSuffix());
        assertEquals("Honey Ln", mlsListing.getLocation().getAddress().getStreet().getName());
        assertEquals("14580", mlsListing.getLocation().getAddress().getStreet().getNumber());
        assertEquals("NW", mlsListing.getLocation().getAddress().getStreet().getSuffix());
    }

}

package com.mke.mls.scraper.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.mke.mls.scraper.domain.MlsListing;

import java.io.IOException;

public class MlsListingDeserializer extends JsonDeserializer<MlsListing> {

    @Override
    public MlsListing deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        return null;
    }

}

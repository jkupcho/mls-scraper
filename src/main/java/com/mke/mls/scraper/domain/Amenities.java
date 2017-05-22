package com.mke.mls.scraper.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Amenities {

    @JsonProperty("BathsTotal")
    private float baths;

    @JsonProperty("BedsTotal")
    private int beds;

    public float getBaths() {
        return baths;
    }

    public void setBaths(float baths) {
        this.baths = baths;
    }

    public int getBeds() {
        return beds;
    }

    public void setBeds(int beds) {
        this.beds = beds;
    }
}

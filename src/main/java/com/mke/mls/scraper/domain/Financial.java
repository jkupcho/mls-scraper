package com.mke.mls.scraper.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Financial {

    @JsonProperty("ListPrice")
    private float listPrice;

    public float getListPrice() {
        return listPrice;
    }

    public void setListPrice(float listPrice) {
        this.listPrice = listPrice;
    }
}

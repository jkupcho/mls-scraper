package com.mke.mls.scraper.domain;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

public class Location {

    @JsonUnwrapped
    private Address address;

    private float longitude;
    private float latitude;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }
}

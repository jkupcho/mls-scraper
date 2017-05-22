package com.mke.mls.scraper.domain;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

public class MlsListing {

    @JsonUnwrapped
    private MlsIdentity mlsIdentity;

    @JsonUnwrapped
    private Financial financial;

    @JsonUnwrapped
    private Amenities amenities;

    @JsonUnwrapped
    private Location location;

    public MlsIdentity getMlsIdentity() {
        return mlsIdentity;
    }

    public void setMlsIdentity(MlsIdentity mlsIdentity) {
        this.mlsIdentity = mlsIdentity;
    }

    public Financial getFinancial() {
        return financial;
    }

    public void setFinancial(Financial financial) {
        this.financial = financial;
    }

    public Amenities getAmenities() {
        return amenities;
    }

    public void setAmenities(Amenities amenities) {
        this.amenities = amenities;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

}

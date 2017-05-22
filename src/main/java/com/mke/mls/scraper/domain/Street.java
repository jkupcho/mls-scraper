package com.mke.mls.scraper.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Street {

    @JsonProperty("StreetAdditionalInfo")
    private String additionalInfo;

    @JsonProperty("StreetDirPrefix")
    private String dirPrefix;

    @JsonProperty("StreetDirSuffix")
    private String dirSuffix;

    @JsonProperty("StreetName")
    private String name;

    @JsonProperty("StreetNumber")
    private String number;

    @JsonProperty("StreetSuffix")
    private String suffix;

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public String getDirPrefix() {
        return dirPrefix;
    }

    public void setDirPrefix(String dirPrefix) {
        this.dirPrefix = dirPrefix;
    }

    public String getDirSuffix() {
        return dirSuffix;
    }

    public void setDirSuffix(String dirSuffix) {
        this.dirSuffix = dirSuffix;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
}

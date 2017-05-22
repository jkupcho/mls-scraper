package com.mke.mls.scraper.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MlsIdentity {

    @JsonProperty("MlsId")
    private String id;

    @JsonProperty("MlsStatus")
    private String status;

    @JsonProperty("ListAgentId")
    private String agentId;

    @JsonProperty("ListingId")
    private String listId;

    @JsonProperty("ListingKey")
    private String listKey;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }

    public String getListId() {
        return listId;
    }

    public void setListId(String listId) {
        this.listId = listId;
    }

    public String getListKey() {
        return listKey;
    }

    public void setListKey(String listKey) {
        this.listKey = listKey;
    }
}

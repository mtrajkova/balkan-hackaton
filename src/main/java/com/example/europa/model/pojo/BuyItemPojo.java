package com.example.europa.model.pojo;

public class BuyItemPojo {
    private String itemId;
    private String personalId;

    public BuyItemPojo() {
    }

    public BuyItemPojo(String itemId, String personalId) {
        this.itemId = itemId;
        this.personalId = personalId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getPersonalId() {
        return personalId;
    }

    public void setPersonalId(String personalId) {
        this.personalId = personalId;
    }
}

package com.coding2themax.outdoor.outdoorbatchservice.model.fees;

public record Pass(String category, String cost, String description, String exceptions, String id,
    String informationUrl, String payGovPurchaseUrl, String paymentDescription,
    String npsGovPurchaseUrl, String recGovPurchaseUrl) {

}

package com.coding2themax.outdoor.outdoorbatchservice.model.fees;

public record Fee(String cost, String description, FeeDate endDate, String entranceFeeType, String exceptions,
                String id, String informationUrl, String payGovPurchaseUrl, String paymentDescription,
                String purchaseUrl,
                String recGovPurchaseUrl, FeeDate startDate, String timedEntryLocation,
                String timedEntryShortDescription) {

}

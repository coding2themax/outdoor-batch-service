package com.coding2themax.outdoor.outdoorbatchservice.model.fees;

import java.util.List;

public record FeesPass(
                String cashless, String entranceFeeDescription,
                String entrancePassesDescription,
                List<Fee> fees, String feesAtWorkUrl, Boolean isFeeFreePark, Boolean isInteragencyPassAccepted,
                Boolean isParkingFeePossible,
                String parkCode,
                String parkingDetailsUrl, List<Pass> passes) {

}

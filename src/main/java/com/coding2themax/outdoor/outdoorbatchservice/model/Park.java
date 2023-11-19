package com.coding2themax.outdoor.outdoorbatchservice.model;

import java.util.List;

import com.coding2themax.outdoor.outdoorbatchservice.model.fees.FeesPass;

public record Park(String parkCode, String url, String fullname, String latitude,
                String longitude, String description, List<String> states, FeesPass feespasses) {

}

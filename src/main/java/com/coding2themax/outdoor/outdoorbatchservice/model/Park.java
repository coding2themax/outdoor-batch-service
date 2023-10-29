package com.coding2themax.outdoor.outdoorbatchservice.model;

import java.util.List;

public record Park(String parkCode, String url, String fullname, String latitude,
        String longitude, String ParkCode, List<String> states) {

}

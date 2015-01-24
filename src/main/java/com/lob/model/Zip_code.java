package com.lob.model;

import java.util.List;

public class Zip_code extends LobObject {
    String zip_code;
    List<Route> routes;
    String object;

    public String getZip_code() {
        return zip_code;
    }

    public List<Route> getRoutes() {
        return routes;
    }

    public String getObject() {
        return object;
    }

}

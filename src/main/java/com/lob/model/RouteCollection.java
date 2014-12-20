package com.lob.model;

import java.util.List;

public class RouteCollection extends LobObject {
    List<Zip_code> data;
    String object;
    
    public List<Zip_code> getData() {
        return data;
    }
    public String getObject() {
        return object;
    }
}

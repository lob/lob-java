package com.lob.model;

import java.util.List;

public class CountryCollection extends LobObject {
    List<Country> data;
    String object;

    public List<Country> getData() {
        return data;
    }
    public String getObject() {
        return object;
    }
}
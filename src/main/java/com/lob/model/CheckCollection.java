package com.lob.model;

import java.util.List;

public class CheckCollection extends LobObject {
    List<Check> data;
    String object;

    public List<Check> getData() {
        return data;
    }
    public String getObject() {
        return object;
    }
}
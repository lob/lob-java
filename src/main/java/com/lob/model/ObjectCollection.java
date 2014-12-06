package com.lob.model;

import java.util.List;

public class ObjectCollection extends LobObject {
    List<Object> data;
    String object;

    public List<Object> getData() {
        return data;
    }
    public String getObject() {
        return object;
    }
}
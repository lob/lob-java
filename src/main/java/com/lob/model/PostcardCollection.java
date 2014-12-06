package com.lob.model;

import java.util.List;

public class PostcardCollection extends LobObject {
    List<Postcard> data;
    String object;

    public List<Postcard> getData() {
        return data;
    }
    public String getObject() {
        return object;
    }
}
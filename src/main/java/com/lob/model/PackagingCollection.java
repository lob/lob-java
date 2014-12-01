package com.lob.model;

import java.util.List;

public class PackagingCollection extends LobObject {
    List<Packaging> data;
    String object;

    public List<Packaging> getData() {
        return data;
    }
    public String getObject() {
        return object;
    }
}
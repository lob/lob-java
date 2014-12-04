package com.lob.model;

import java.util.List;

public class AddressCollection extends LobObject {
    List<Address> data;
    String object;

    public List<Address> getData() {
        return data;
    }
    public String getObject() {
        return object;
    }
}

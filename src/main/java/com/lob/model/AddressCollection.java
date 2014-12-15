package com.lob.model;

import java.util.List;

public class AddressCollection extends LobObject {
    List<Address> data;
    String object;
    Integer count;
    String next_url;
    String previous_url;

    public List<Address> getData() {
        return data;
    }
    public String getObject() {
        return object;
    }
    public Integer getCount() {
        return count;
    }
    public String getNext_url() {
        return next_url;
    }
    public String getPrevious_url() {
        return previous_url;
    }
}
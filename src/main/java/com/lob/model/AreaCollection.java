package com.lob.model;

import java.util.List;

public class AreaCollection extends LobObject {
    List<Area> data;
    String object;
    Integer count;
    String next_url;
    String previous_url;

    public List<Area> getData() {
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
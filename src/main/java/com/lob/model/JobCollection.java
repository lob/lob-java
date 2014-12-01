package com.lob.model;

import java.util.List;

public class JobCollection extends LobObject {
    List<Job> data;
    Integer count;

    public List<Job> getData() {
        return data;
    }
    public Integer getCount() {
        return count;
    }
}
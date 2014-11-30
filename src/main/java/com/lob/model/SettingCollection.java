package com.lob.model;

import java.util.List;

public class SettingCollection extends LobObject {
    List<Setting> data;
    String object;
    
    public List<Setting> getData() {
        return data;
    }
    public String getObject() {
        return object;
    }
}
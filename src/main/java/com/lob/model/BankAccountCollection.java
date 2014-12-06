package com.lob.model;

import java.util.List;

public class BankAccountCollection extends LobObject {
    List<Bank_account> data;
    String object;

    public List<Bank_account> getData() {
        return data;
    }
    public String getObject() {
        return object;
    }
}
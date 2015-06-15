package com.lob.id;

import com.fasterxml.jackson.annotation.JsonCreator;

public class SettingId extends IntegerId {

    private SettingId(final int id) {
        super(id);
    }

    @JsonCreator
    public static SettingId parse(final String s) {
        return new SettingId(Integer.valueOf(s));
    }

    public static SettingId parse(final int settingId) {
        return new SettingId(settingId);
    }
}

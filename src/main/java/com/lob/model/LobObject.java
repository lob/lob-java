package com.lob.model;

import java.lang.reflect.Field;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public abstract class LobObject {

    public static final Gson prettyPrintGson = new GsonBuilder().
        setPrettyPrinting().
        serializeNulls().
        setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).
        create();

    @Override public String toString() {
        return String.format(
            "<%s@%s id=%s> JSON: %s",
            this.getClass().getName(),
            System.identityHashCode(this),
            this.getIdString(),
            prettyPrintGson.toJson(this));
    }

    private java.lang.Object getIdString() {
        try {
            Field idField = this.getClass().getDeclaredField("id");
            return idField.get(this);
        } catch (Exception e) {
            return "";
        }
    }
}
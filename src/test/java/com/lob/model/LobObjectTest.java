package com.lob.model;

import org.junit.Test;
import static org.fest.assertions.api.Assertions.assertThat;

public class LobObjectTest {

    @Test
    public void empty_lob_object() {
        LobObject lobObject = new LobObject() {};
        assertThat(lobObject.toString()).endsWith("id=> JSON: null");
    }

    @Test
    public void lob_object_with_id() {
        LobObject lobObject = new LobObject() {int id = 123;};
        assertThat(lobObject.toString()).endsWith("id=123> JSON: null");
    }

    @Test
    public void lob_object_with_private_id() {
        LobObject lobObject = new LobObject() {private int id = 123;};
        assertThat(lobObject.toString()).endsWith("id=> JSON: null");
    }

}

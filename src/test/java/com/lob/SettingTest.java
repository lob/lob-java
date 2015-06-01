package com.lob;

import com.lob.exception.LobException;
import com.lob.exception.APIException;
import com.lob.Lob;
import com.lob.model.Setting;
import com.lob.model.SettingCollection;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;

public class SettingTest {

    @BeforeClass
    public static void setUp() {
        Lob.apiKey = "test_0dc8d51e0acffcb1880e0f19c79b2f5b0cc";
    }

    @Test
    public void testSettingRetrieve() throws LobException {
        String id = "200";
        Setting setting = Setting.retrieve(id, Lob.apiKey);
        assertEquals("200", setting.getId());
        assertEquals("cards", setting.getType());
        assertEquals("4x6 color card", setting.getDescription());
        assertEquals("120lb gloss cover", setting.getPaper());
        assertEquals("6.000", setting.getWidth());
        assertEquals("4.000", setting.getLength());
        assertEquals("color", setting.getColor());
        assertEquals("includes envelope", setting.getNotes());
        assertEquals("setting", setting.getObject());
    }

    @Test
    public void testSettingRetrieveAll() throws LobException {
        SettingCollection settings = Setting.all(Lob.apiKey);
        assertEquals(12, settings.getData().size());
        assertEquals("list", settings.getObject());
    }
}

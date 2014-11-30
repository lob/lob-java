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
        String id = "100";
        Setting setting = Setting.retrieve(id, Lob.apiKey);
        assertEquals("100", setting.getId());
        assertEquals("documents", setting.getType());
        assertEquals("black and white document", setting.getDescription());
        assertEquals("20lb paper standard", setting.getPaper());
        assertEquals("8.500", setting.getWidth());
        assertEquals("11.000", setting.getLength());
        assertEquals("black and white", setting.getColor());
        assertEquals("12 cents per extra page", setting.getNotes());
        assertEquals("setting", setting.getObject());
    }

    @Test
    public void testSettingRetrieveAll() throws LobException {
        SettingCollection settings = Setting.all(Lob.apiKey);
        assertEquals(18, settings.getData().size());
        assertEquals("list", settings.getObject());
    }
}

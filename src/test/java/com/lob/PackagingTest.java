package com.lob;

import com.lob.exception.LobException;
import com.lob.exception.APIException;
import com.lob.Lob;
import com.lob.model.Packaging;
import com.lob.model.PackagingCollection;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.BeforeClass;
import org.junit.Test;

public class PackagingTest {

    @BeforeClass
    public static void setUp() {
        Lob.apiKey = "test_0dc8d51e0acffcb1880e0f19c79b2f5b0cc";
    }

    @Test
    public void testPackagingRetrieve() throws LobException {
        String id = "1";
        Packaging packaging = Packaging.retrieve(id, Lob.apiKey);
        assertEquals("1", packaging.getId());
        assertEquals("Smart Packaging", packaging.getName());
        assertTrue(packaging.getDescription().length() > 0);
        assertEquals("packaging", packaging.getObject());
    }

    @Test
    public void testPackagingRetrieveAll() throws LobException {
        PackagingCollection packagings = Packaging.all(Lob.apiKey);
        assertEquals("list", packagings.getObject());
        assertTrue(packagings.getData().size() > 0);
    }
}

package com.lob;

import org.junit.BeforeClass;

public class BaseTest {

    @BeforeClass
    public static void beforeClass() {
        Lob.init(System.getenv("LOB_API_KEY"));
    }

}

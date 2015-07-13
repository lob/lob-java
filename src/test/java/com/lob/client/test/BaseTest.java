package com.lob.client.test;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import com.lob.client.AsyncLobClient;
import com.lob.client.LobClient;
import org.junit.BeforeClass;
import org.slf4j.LoggerFactory;

public abstract class BaseTest {
    protected final static LobClient client = AsyncLobClient.createDefault("test_0dc8d51e0acffcb1880e0f19c79b2f5b0cc");

    @BeforeClass
    public static void beforeClass() {
        ((ch.qos.logback.classic.Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME)).setLevel(Level.INFO);
    }

}

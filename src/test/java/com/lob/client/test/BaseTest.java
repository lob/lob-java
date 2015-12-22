package com.lob.client.test;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import com.lob.client.AsyncLobClient;
import com.lob.client.LobClient;
import org.junit.BeforeClass;
import org.slf4j.LoggerFactory;

public abstract class BaseTest {
    protected final static LobClient client = AsyncLobClient.createDefault("test_7b1960d06d6dfe28d3862b98380b8b0dc93");

    @BeforeClass
    public static void beforeClass() {
        ((ch.qos.logback.classic.Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME)).setLevel(Level.INFO);
    }

}

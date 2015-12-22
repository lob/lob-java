package com.lob.examples;

import com.google.common.io.Files;
import com.google.common.io.Resources;

import java.io.File;
import java.io.IOException;

public abstract class BaseExample {

    protected static final String API_KEY = "test_7b1960d06d6dfe28d3862b98380b8b0dc93"; // Replace this API key with your own.

    public static void printResponse(final String name, final Object response) {
        System.out.println(name);
        System.out.println("=======================================================");
        System.out.println();
        System.out.println(response);
        System.out.println();
        System.out.println("=======================================================");
        System.out.println();
        System.out.println();
    }

    public static File fileFromResource(final String resource) throws IOException {
        final File file = File.createTempFile("/tmp", ".tmp");
        file.deleteOnExit();
        Resources.asByteSource(Resources.getResource(resource)).copyTo(Files.asByteSink(file));
        return file;
    }
}

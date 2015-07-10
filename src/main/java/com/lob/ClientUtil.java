package com.lob;

import com.google.common.io.Files;
import com.google.common.io.Resources;

import java.io.File;
import java.io.IOException;

public class ClientUtil {
    public static File fileFromResource(final String resource) throws IOException {
        final File file = File.createTempFile("/tmp", ".tmp");
        file.deleteOnExit();
        Resources.asByteSource(Resources.getResource(resource)).copyTo(Files.asByteSink(file));
        return file;
    }
}

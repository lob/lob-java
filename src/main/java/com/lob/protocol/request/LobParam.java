package com.lob.protocol.request;

import com.lob.Or;

import java.io.File;
import java.util.Arrays;
import java.util.Collection;

import static com.lob.Util.defensiveCopy;

public class LobParam {
    private final String name;
    private final Or<Collection<String>, File> param;

    private LobParam(final String name, final Or<Collection<String>, File> param) {
        this.name = name;
        this.param = param;
    }

    public static LobParam strings(final String name, final String... strings) {
        return new LobParam(name, Or.<Collection<String>, File>typeA(Arrays.asList(strings)));
    }

    public static LobParam strings(final String name, final Collection<String> strings) {
        return new LobParam(name, Or.<Collection<String>, File>typeA(defensiveCopy(strings)));
    }

    public static LobParam file(final String name, final File file) {
        return new LobParam(name, Or.<Collection<String>, File>typeB(file));
    }

    public LobParam cloneWithName(final String newName) {
        return new LobParam(newName, this.param);
    }

    public String getName() {
        return name;
    }

    public boolean isStringParam() {
        return this.param.isTypeA();
    }

    public boolean isFileParam() {
        return this.param.isTypeB();
    }

    public Collection<String> getStringParam() {
        return this.param.getTypeA();
    }

    public File getFileParam() {
        return this.param.getTypeB();
    }

    @Override
    public String toString() {
        return this.name + ": " + (isStringParam() ? this.param.getTypeA() : "@" + this.param.getTypeB().getAbsolutePath());
    }
}

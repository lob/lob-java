package com.lob.id;

import java.util.HashMap;
import java.util.Map;

public abstract class LobId implements StringValued {
    protected final String id;

    protected LobId(final Prefix prefix, final String id) {
        this.id = id;
    }

    @Override
    public String value() {
        return this.id;
    }

    @Override
    public String toString() {
        return this.id;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final LobId lobId = (LobId) o;

        return id.equals(lobId.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    protected static enum Prefix {
        ADDRESS("adr", "address"),
        AREA("area", "area"),
        BANK("bank", "bank"),
        CHECK("chk", "check"),
        JOB("job", "job"),
        LETTER("ltr", "letter"),
        OBJECT("obj", "object"),
        POSTCARD("psc", "postcard"),
        TRACKING("trk", "tracking");

        private final static Map<String, Prefix> stringPrefixMap = new HashMap<String, Prefix>();
        static {
            for (final Prefix prefix : Prefix.values()) {
                stringPrefixMap.put(prefix.prefix, prefix);
            }
        }

        private final String prefix;
        private final String name;

        private Prefix(final String prefix, final String name) {
            this.prefix = prefix;
            this.name = name;
        }

        private static Prefix fromString(final String s) {
            return stringPrefixMap.get(s);
        }
    }

}

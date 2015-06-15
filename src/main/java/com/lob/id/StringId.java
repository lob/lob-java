package com.lob.id;

import static com.lob.Util.checkNotNull;

public abstract class StringId implements StringValued {
    final String id;

    protected StringId(final String id) {
        this.id = checkNotNull(id);
    }

    @Override
    public String value() {
        return this.id;
    }

    @Override
    public String toString() {
        return value();
    }
}

package com.lob.id;

public abstract class LobId implements StringValued {
    protected final String id;

    protected LobId(final String id) {
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

}

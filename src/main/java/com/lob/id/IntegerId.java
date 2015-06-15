package com.lob.id;

public abstract class IntegerId implements StringValued {
    final int id;

    protected IntegerId(final int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String value() {
        return Integer.toString(this.id);
    }

    @Override
    public String toString() {
        return value();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final IntegerId integerId = (IntegerId) o;

        if (id != integerId.id) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return 31 * id;
    }
}

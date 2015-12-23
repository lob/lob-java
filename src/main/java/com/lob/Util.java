package com.lob;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class Util {
    public static <T> T checkNotNull(final T ref, final String message) {
        if (ref == null) {
            throw new NullPointerException(message);
        }

        return ref;
    }

    public static <T> T checkNotNull(final T ref) {
        return checkNotNull(ref, "");
    }

    public static String checkPresent(final String ref, final String message) {
        if (checkNotNull(ref, message).isEmpty()) {
            throw new IllegalArgumentException(message);
        }
        return ref;
    }

    public static <T1, T2> OrCollection<T1, T2> checkPresent(final OrCollection<T1, T2> ref, final String message) {
        checkNotNull(ref, message);
        if ((ref.isTypeA() && ref.getTypeA().isEmpty()) || (ref.isTypeB() && ref.getTypeB().isEmpty())) {
            throw new IllegalArgumentException(message);
        }
        return ref;
    }

    public static <T> List<T> defensiveCopy(final Collection<T> original) {
        if (original == null || original.isEmpty()) {
            return Collections.emptyList();
        }

        final List<T> copy = new ArrayList<T>(original.size());
        for (final T t : original) {
            copy.add(t);
        }
        return copy;
    }
}

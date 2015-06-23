package com.lob;

import com.lob.protocol.request.AddressRequest;
import com.lob.protocol.response.AddressResponse;

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

    final private static String hexRegex = "[a-fA-F0-9]+";

    public static String checkValidHex(final String s) {
        // handle the null and empty check right away
        if (checkNotNull(s).isEmpty()) {
            throw new IllegalArgumentException("string cannot be empty!");
        }

        if (!s.matches(hexRegex)) {
            throw new IllegalArgumentException("string " + s + " is not valid hex!");
        }

        return s;
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

    public static <T> T print(final T t) {
        System.out.println(t);
        return t;
    }
}

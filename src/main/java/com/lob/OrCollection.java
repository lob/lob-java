package com.lob;

import java.util.Collection;

import static com.lob.Util.defensiveCopy;

public class OrCollection<T1, T2> {
    private final Or<Collection<T1>, Collection<T2>> orCollection;

    private OrCollection(final Or<Collection<T1>, Collection<T2>> orCollection) {
        this.orCollection = orCollection;
    }

    public static <T1, T2> OrCollection<T1, T2> typeA(final Collection<T1> ref) {
        return new OrCollection<T1, T2>(Or.<Collection<T1>, Collection<T2>>typeA(ref));
    }

    public static <T1, T2> OrCollection<T1, T2> typeB(final Collection<T2> ref) {
        return new OrCollection<T1, T2>(Or.<Collection<T1>, Collection<T2>>typeB(ref));
    }

    public boolean isTypeA() {
        return orCollection.isTypeA();
    }

    public boolean isTypeB() {
        return orCollection.isTypeB();
    }

    public Collection<T1> getTypeA() {
        return defensiveCopy(orCollection.getTypeA());
    }

    public Collection<T2> getTypeB() {
        return defensiveCopy(orCollection.getTypeB());
    }
}

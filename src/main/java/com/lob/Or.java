package com.lob;

import static com.lob.Util.checkNotNull;

public class Or<T1, T2> {
    final T1 refA;
    final T2 refB;

    private Or(final T1 refA, final T2 refB) {
        // guaranteed not to be null because this is only accessed through the static methods,
        // which contain checkNotNull()s
        this.refA = refA;
        this.refB = refB;
    }

    public static <T1, T2> Or<T1, T2> typeA(final T1 ref) {
        return new Or<T1, T2>(checkNotNull(ref), null);
    }

    public static <T1, T2> Or<T1, T2> typeB(final T2 ref) {
        return new Or<T1, T2>(null, checkNotNull(ref));
    }

    public boolean isTypeA() {
        return this.refA != null;
    }

    public boolean isTypeB() {
        return this.refB != null;
    }

    public T1 getTypeA() {
        if (this.refA == null) {
            throw new IllegalStateException("called getTypeA on an Or of type B!");
        }
        return this.refA;
    }

    public T2 getTypeB() {
        if (this.refB == null) {
            throw new IllegalStateException("called getTypeB on an Or of type A!");
        }
        return this.refB;
    }

    @Override
    public String toString() {
        return "Or{" +
            "refA=" + refA +
            ", refB=" + refB +
            '}';
    }
}

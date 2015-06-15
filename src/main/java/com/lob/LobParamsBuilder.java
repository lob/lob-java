package com.lob;

import com.lob.id.StringValued;
import com.lob.protocol.request.HasLobParams;
import com.lob.protocol.request.LobParam;
import org.joda.money.Money;
import org.joda.money.format.MoneyAmountStyle;
import org.joda.money.format.MoneyFormatter;
import org.joda.money.format.MoneyFormatterBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import static com.lob.Util.defensiveCopy;

public class LobParamsBuilder {
    private final static MoneyFormatter MONEY_FORMAT = new MoneyFormatterBuilder()
        .appendAmount(MoneyAmountStyle.ASCII_DECIMAL_POINT_NO_GROUPING)
        .toFormatter();

    private final Collection<LobParam> internalParams = new ArrayList<LobParam>();

    public static LobParamsBuilder create() {
        return new LobParamsBuilder();
    }

    public LobParamsBuilder put(final String k, final String v) {
        if (v == null) {
            return this;
        }

        putAllStrings(k, Arrays.asList(v));
        return this;
    }

    public LobParamsBuilder put(final LobParam v) {
        if (v == null) {
            return this;
        }

        this.internalParams.add(v);
        return this;
    }

    public LobParamsBuilder put(final String k, final Integer v) {
        if (v == null) {
            return this;
        }

        return put(k, Integer.toString(v));
    }

    public LobParamsBuilder put(final String k, final Boolean v) {
        if (v == null) {
            return this;
        }

        return put(k, Boolean.toString(v));
    }

    public LobParamsBuilder put(final String k, final StringValued v) {
        if (v == null) {
            return this;
        }

        return put(k, v.value());
    }

    public LobParamsBuilder put(final String k, final Or<? extends StringValued, ? extends HasLobParams> v) {
        if (v == null) {
            return this;
        }

        return (v.isTypeA() ? put(k, v.getTypeA()) : putLobParams(k, v.getTypeB()));
    }

    public LobParamsBuilder put(final String k, final Money v) {
        if (v == null) {
            return this;
        }

        return put(k, MONEY_FORMAT.print(v));
    }

    public LobParamsBuilder putMap(final String prefix, final Map<String, String> theMap) {
        if (theMap == null) {
            return this;
        }

        for (final Map.Entry<String, String> entry : theMap.entrySet()) {
            this.internalParams.add(LobParam.strings(prefix + "[" + entry.getKey() + "]", entry.getValue()));
        }
        return this;
    }

    public LobParamsBuilder putLobParams(final String prefix, final HasLobParams hasLobParams) {
        if (hasLobParams == null) {
            return this;
        }

        for (final LobParam lobParam : hasLobParams.getLobParams()) {
            // XXX not sure how it's going to work if we get more than one level deep
            this.internalParams.add(lobParam.cloneWithName(prefix + "[" + lobParam.getName() + "]"));
        }
        return this;
    }

    public LobParamsBuilder putAllInts(final String k, final Collection<Integer> v) {
        if (v == null) {
            return this;
        }

        final List<String> list = new ArrayList<String>(v.size());
        for (final int i : v) {
            list.add(Integer.toString(i));
        }

        return putAllStrings(k, list);
    }

    public LobParamsBuilder putAllStringValued(final String k, final OrCollection<? extends StringValued, ? extends StringValued> v) {
        if (v == null) {
            return this;
        }

        return (v.isTypeA() ? putAllStringValued(k, v.getTypeA()) : putAllStringValued(k, v.getTypeB()));
    }

    public LobParamsBuilder putAllStringValued(final String k, final Collection<? extends StringValued> v) {
        if (v == null) {
            return this;
        }

        for (final StringValued s : v) {
            put(k, s.value());
        }
        return this;
    }

    public LobParamsBuilder putAllStrings(final String k, final Collection<String> v) {
        if (v == null || v.isEmpty()) {
            return this;
        }

        this.internalParams.add(LobParam.strings(k, v));
        return this;
    }

    public Collection<LobParam> build() {
        return defensiveCopy(this.internalParams);
    }
}

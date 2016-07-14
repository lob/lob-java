package com.lob;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

import java.io.IOException;

import static com.google.common.base.Preconditions.checkNotNull;

public class MoneyDeserializer extends JsonDeserializer<Money> {
    private final CurrencyUnit currency;

    public MoneyDeserializer(final CurrencyUnit currency) {
        this.currency = checkNotNull(currency);
    }

    @Override
    public Money deserialize(final JsonParser jsonParser, final DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        return Money.of(this.currency, Double.valueOf(jsonParser.getValueAsString()));
    }
}

package com.lob.protocol.request;

import com.lob.LobParamsBuilder;
import com.lob.id.BankAccountId;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class BankAccountVerifyRequest implements HasLobParams {
    private final BankAccountId id;
    private final List<Integer> amounts;

    private BankAccountVerifyRequest(final BankAccountId id, final List<Integer> amounts) {
        this.id = id;
        this.amounts = amounts;
    }

    @Override
    public Collection<LobParam> getLobParams() {
        return LobParamsBuilder.create().putAllInts("amounts", amounts).build();
    }

    public BankAccountId getId() {
        return id;
    }

    public List<Integer> getAmounts() {
        return amounts;
    }

    @Override
    public String toString() {
        return "BankAccountVerifyRequest{" +
            "bankAccountId=" + id +
            ", amounts=" + amounts +
            '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private BankAccountId id;
        private List<Integer> amounts;

        public Builder() {}

        public Builder id(final BankAccountId id) {
            this.id = id;
            return this;
        }

        public Builder amounts(final int amount1, final int amount2) {
            this.amounts = Arrays.asList(amount1, amount2);
            return this;
        }

        public BankAccountVerifyRequest build() {
            return new BankAccountVerifyRequest(id, amounts);
        }
    }
}

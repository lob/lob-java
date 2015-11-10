package com.lob.protocol.request;

import java.util.Collection;
import java.util.Map;

import static com.lob.Util.checkNotNull;
import static com.lob.Util.checkPresent;

public class BankAccountRequest extends AbstractLobRequest implements HasLobParams {
    private final String routingNumber;
    private final String accountNumber;
    private final String signatory;

    public BankAccountRequest(
            final String routingNumber,
            final String accountNumber,
            final String signatory,
            final Map<String, String> metadata,
            final String description) {
        super(metadata, description);
        this.routingNumber = checkNotNull(routingNumber, "routing number is required");
        this.accountNumber = checkNotNull(accountNumber, "account number is required");
        this.signatory = checkPresent(signatory, "signatory is required");
    }

    @Override
    public Collection<LobParam> getLobParams() {
        return super.beginParams()
            .put("routing_number", routingNumber)
            .put("account_number", accountNumber)
            .put("signatory", signatory)
            .build();
    }

    public String getRoutingNumber() {
        return routingNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getSignatory() {
        return signatory;
    }

    @Override
    public String toString() {
        return "BankAccountRequest{" +
            "routingNumber='" + routingNumber + '\'' +
            ", accountNumber='" + accountNumber + '\'' +
            ", signatory='" + signatory + '\'' +
            super.toString();
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder extends AbstractLobRequest.Builder<Builder> {
        private String routingNumber;
        private String accountNumber;
        private String signatory;

        private Builder() {
        }

        public Builder routingNumber(final String routingNumber) {
            this.routingNumber = routingNumber;
            return this;
        }

        public Builder accountNumber(final String accountNumber) {
            this.accountNumber = accountNumber;
            return this;
        }

        public Builder signatory(final String signatory) {
            this.signatory = signatory;
            return this;
        }

        public Builder butWith() {
            return new Builder()
                .routingNumber(routingNumber)
                .accountNumber(accountNumber)
                .signatory(signatory)
                .metadata(metadata)
                .description(description);
        }

        public BankAccountRequest build() {
            return new BankAccountRequest(routingNumber, accountNumber, signatory, metadata, description);
        }
    }
}

package com.lob.protocol.request;

import com.lob.LobParamsBuilder;
import com.lob.Or;
import com.lob.id.AddressId;
import com.lob.id.StringId;

import java.util.Collection;
import java.util.Map;

import static com.lob.Util.checkNotNull;
import static com.lob.Util.checkPresent;

public class BankAccountRequest extends AbstractLobRequest implements HasLobParams {
    private final String name;
    private final String routingNumber;
    private final String accountNumber;
    private final Or<AddressId, AddressRequest> bankAddress;
    private final Or<AddressId, AddressRequest> accountAddress;
    private final String signatory;

    public BankAccountRequest(
            final String name,
            final String routingNumber,
            final String accountNumber,
            final Or<AddressId, AddressRequest> bankAddress,
            final Or<AddressId, AddressRequest> accountAddress,
            final String signatory,
            final Map<String, String> metadata) {
        super(metadata);
        this.name = name;
        this.routingNumber = checkNotNull(routingNumber, "routing number is required");
        this.accountNumber = checkNotNull(accountNumber, "account number is required");
        this.bankAddress = checkNotNull(bankAddress, "bank address is required");
        this.accountAddress = checkNotNull(accountAddress, "account address is required");
        this.signatory = checkPresent(signatory, "signatory is required");
    }

    @Override
    public Collection<LobParam> getLobParams() {
        return super.beginParams()
            .put("name", name)
            .put("routing_number", routingNumber)
            .put("account_number", accountNumber)
            .put("bank_address", bankAddress)
            .put("account_address", accountAddress)
            .put("signatory", signatory)
            .build();
    }

    public String getName() {
        return name;
    }

    public String getRoutingNumber() {
        return routingNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public Or<AddressId, AddressRequest> getBankAddress() {
        return bankAddress;
    }

    public Or<AddressId, AddressRequest> getAccountAddress() {
        return accountAddress;
    }

    public String getSignatory() {
        return signatory;
    }

    @Override
    public String toString() {
        return "BankAccountRequest{" +
            "name='" + name + '\'' +
            ", routingNumber='" + routingNumber + '\'' +
            ", accountNumber='" + accountNumber + '\'' +
            ", bankAddress=" + bankAddress +
            ", accountAddress=" + accountAddress +
            ", signatory='" + signatory + '\'' +
            super.toString();
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String name;
        private String routingNumber;
        private String accountNumber;
        private Or<AddressId, AddressRequest> bankAddress;
        private Or<AddressId, AddressRequest> accountAddress;
        private String signatory;
        private Map<String, String> metadata;

        private Builder() {
        }

        public Builder name(final String name) {
            this.name = name;
            return this;
        }

        public Builder routingNumber(final String routingNumber) {
            this.routingNumber = routingNumber;
            return this;
        }

        public Builder accountNumber(final String accountNumber) {
            this.accountNumber = accountNumber;
            return this;
        }

        public Builder bankAddress(final AddressId bankAddress) {
            this.bankAddress = Or.typeA(bankAddress);
            return this;
        }

        public Builder bankAddress(final AddressRequest bankAddress) {
            this.bankAddress = Or.typeB(bankAddress);
            return this;
        }

        public Builder bankAddress(final Or<AddressId, AddressRequest> bankAddress) {
            this.bankAddress = bankAddress;
            return this;
        }

        public Builder accountAddress(final AddressId accountAddress) {
            this.accountAddress = Or.typeA(accountAddress);
            return this;
        }

        public Builder accountAddress(final AddressRequest accountAddress) {
            this.accountAddress = Or.typeB(accountAddress);
            return this;
        }

        public Builder accountAddress(final Or<AddressId, AddressRequest> accountAddress) {
            this.accountAddress = accountAddress;
            return this;
        }

        public Builder signatory(final String signatory) {
            this.signatory = signatory;
            return this;
        }

        public Builder metadata(final Map<String, String> metadata) {
            this.metadata = metadata;
            return this;
        }

        public Builder butWith() {
            return new Builder()
                .name(name)
                .routingNumber(routingNumber)
                .accountNumber(accountNumber)
                .bankAddress(bankAddress)
                .accountAddress(accountAddress)
                .signatory(signatory)
                .metadata(metadata);
        }

        public BankAccountRequest build() {
            return new BankAccountRequest(name, routingNumber, accountNumber, bankAddress, accountAddress, signatory, metadata);
        }
    }
}

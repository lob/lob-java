package com.lob.protocol.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.lob.id.BankAccountId;
import org.joda.time.DateTime;

import java.util.Map;

public class BankAccountResponse extends AbstractLobResponse {
    @JsonProperty private final BankAccountId id;
    @JsonProperty private final String name;
    @JsonProperty private final String routingNumber;
    @JsonProperty private final String accountNumber;
    @JsonProperty private final AddressResponse bankAddress;
    @JsonProperty private final boolean verified;
    @JsonProperty private final AddressResponse accountAddress;
    @JsonProperty private final String signatory;

    @JsonCreator
    public BankAccountResponse(
            @JsonProperty("id") final BankAccountId id,
            @JsonProperty("name") final String name,
            @JsonProperty("routing_number") final String routingNumber,
            @JsonProperty("account_number") final String accountNumber,
            @JsonProperty("bank_address") final AddressResponse bankAddress,
            @JsonProperty("account_address") final AddressResponse accountAddress,
            @JsonProperty("verified") final boolean verified,
            @JsonProperty("signatory") final String signatory,
            @JsonProperty("date_created") final DateTime dateCreated,
            @JsonProperty("date_modified") final DateTime dateModified,
            @JsonProperty("metadata") final Map<String, String> metadata,
            @JsonProperty("object") final String object) {
        super(dateCreated, dateModified, metadata, object);
        this.id = id;
        this.name = name;
        this.routingNumber = routingNumber;
        this.accountNumber = accountNumber;
        this.bankAddress = bankAddress;
        this.accountAddress = accountAddress;
        this.verified = verified;
        this.signatory = signatory;
    }

    public BankAccountId getId() {
        return id;
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

    public AddressResponse getBankAddress() {
        return bankAddress;
    }

    public AddressResponse getAccountAddress() {
        return accountAddress;
    }

    public boolean isVerified() {
        return verified;
    }

    public String getSignatory() {
        return signatory;
    }

    @Override
    public String toString() {
        return "BankAccountResponse{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", routingNumber='" + routingNumber + '\'' +
            ", accountNumber='" + accountNumber + '\'' +
            ", bankAddress=" + bankAddress +
            ", verified=" + verified +
            ", accountAddress=" + accountAddress +
            ", signatory='" + signatory + '\'' +
            super.toString();
    }
}

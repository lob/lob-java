package com.lob.protocol.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.lob.id.BankAccountId;
import org.joda.time.DateTime;

import java.util.Map;

public class BankAccountResponse extends AbstractLobResponse {
    @JsonProperty private final BankAccountId id;
    @JsonProperty private final String routingNumber;
    @JsonProperty private final String accountNumber;
    @JsonProperty private final String accountType;
    @JsonProperty private final boolean verified;
    @JsonProperty private final String signatory;

    @JsonCreator
    public BankAccountResponse(
            @JsonProperty("id") final BankAccountId id,
            @JsonProperty("routing_number") final String routingNumber,
            @JsonProperty("account_number") final String accountNumber,
            @JsonProperty("account_type") final String accountType,
            @JsonProperty("verified") final boolean verified,
            @JsonProperty("signatory") final String signatory,
            @JsonProperty("description") final String description,
            @JsonProperty("date_created") final DateTime dateCreated,
            @JsonProperty("date_modified") final DateTime dateModified,
            @JsonProperty("metadata") final Map<String, String> metadata,
            @JsonProperty("object") final String object) {
        super(description, dateCreated, dateModified, metadata, object);
        this.id = id;
        this.routingNumber = routingNumber;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.verified = verified;
        this.signatory = signatory;
    }

    public BankAccountId getId() {
        return id;
    }

    public String getRoutingNumber() {
        return routingNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountType() {
        return accountType;
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
            ", routingNumber='" + routingNumber + '\'' +
            ", accountNumber='" + accountNumber + '\'' +
            ", accountType='" + accountType + '\'' +
            ", verified=" + verified +
            ", signatory='" + signatory + '\'' +
            super.toString();
    }
}

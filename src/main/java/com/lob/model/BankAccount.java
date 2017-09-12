package com.lob.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.lob.exception.APIException;
import com.lob.exception.AuthenticationException;
import com.lob.exception.InvalidRequestException;
import com.lob.exception.RateLimitException;
import com.lob.net.APIResource;
import com.lob.net.LobResponse;
import com.lob.net.RequestOptions;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.joda.time.DateTime;

public class BankAccount extends APIResource {

    public static final String ENDPOINT = "bank_accounts";

    @JsonProperty private final String id;
    @JsonProperty private final String description;
    @JsonProperty private final String routingNumber;
    @JsonProperty private final String accountNumber;
    @JsonProperty private final String accountType;
    @JsonProperty private final String signatory;
    @JsonProperty private final String signatureUrl;
    @JsonProperty private final String bankName;
    @JsonProperty private final boolean verified;
    @JsonProperty private final Map<String, String> metadata;
    @JsonProperty private final DateTime dateCreated;
    @JsonProperty private final DateTime dateModified;
    @JsonProperty private final boolean deleted;
    @JsonProperty private final String object;

    @JsonCreator
    public BankAccount(
            @JsonProperty("id") final String id,
            @JsonProperty("description") final String description,
            @JsonProperty("routing_number") final String routingNumber,
            @JsonProperty("account_number") final String accountNumber,
            @JsonProperty("account_type") final String accountType,
            @JsonProperty("signatory") final String signatory,
            @JsonProperty("signature_url") final String signatureUrl,
            @JsonProperty("bank_name") final String bankName,
            @JsonProperty("verified") final boolean verified,
            @JsonProperty("metadata") final Map<String, String> metadata,
            @JsonProperty("date_created") final DateTime dateCreated,
            @JsonProperty("date_modified") final DateTime dateModified,
            @JsonProperty("deleted") final boolean deleted,
            @JsonProperty("object") final String object) {
        this.id = id;
        this.description = description;
        this.routingNumber = routingNumber;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.signatory = signatory;
        this.signatureUrl = signatureUrl;
        this.bankName = bankName;
        this.verified = verified;
        this.metadata = metadata;
        this.dateCreated = dateCreated;
        this.dateModified = dateModified;
        this.deleted = deleted;
        this.object = object;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
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

    public String getSignatory() {
        return signatory;
    }

    public String getSignatureUrl() {
        return signatureUrl;
    }

    public String getBankName() {
        return bankName;
    }

    public boolean getVerified() {
        return verified;
    }

    public Map<String, String> getMetadata() {
        return metadata;
    }

    public DateTime getDateCreated() {
        return dateCreated;
    }

    public DateTime getDateModified() {
        return dateModified;
    }

    public boolean getDeleted() { return deleted; }

    public String getObject() {
        return object;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", routingNumber='" + routingNumber + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", accountType='" + accountType + '\'' +
                ", signatory='" + signatory + '\'' +
                ", signatureUrl='" + signatureUrl + '\'' +
                ", bankName='" + bankName + '\'' +
                ", verified='" + verified + '\'' +
                ", metadata='" + metadata + '\'' +
                ", dateCreated=" + dateCreated +
                ", dateModified=" + dateModified +
                ", object=" + object +
                '}';
    }

    public static BankAccountCreator creator() {
        return new BankAccountCreator();
    }

    public static final class BankAccountCreator {
        private Map<String, Object> params = new HashMap<String, Object>();

        public BankAccountCreator() {
        }

        public BankAccountCreator setDescription(String description) {
            params.put("description", description);
            return this;
        }

        public BankAccountCreator setRoutingNumber(String routingNumber) {
            params.put("routing_number", routingNumber);
            return this;
        }

        public BankAccountCreator setAccountNumber(String accountNumber) {
            params.put("account_number", accountNumber);
            return this;
        }

        public BankAccountCreator setAccountType(String accountType) {
            params.put("account_type", accountType);
            return this;
        }

        public BankAccountCreator setSignatory(String signatory) {
            params.put("signatory", signatory);
            return this;
        }

        public BankAccountCreator setSignatureUrl(String signatureUrl) {
            params.put("signature_url", signatureUrl);
            return this;
        }

        public BankAccountCreator setBankName(String bankName) {
            params.put("bank_name", bankName);
            return this;
        }

        public BankAccountCreator setVerified(String verified) {
            params.put("verified", verified);
            return this;
        }

        public BankAccountCreator setMetadata(Map<String, String> metadata) {
            params.put("metadata", metadata);
            return this;
        }

        public Map<String, Object> build() {
            return params;
        }

        public LobResponse<BankAccount> create() throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
            return create(null);
        }

        public LobResponse<BankAccount> create(RequestOptions options) throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException  {
            return request(RequestMethod.POST, RequestType.NORMAL, ENDPOINT, params, BankAccount.class, options);
        }
    }

    public static LobResponse<BankAccount> retrieve(String id) throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
        return retrieve(id, null);
    }

    public static LobResponse<BankAccount> retrieve(String id, RequestOptions options) throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
        return request(RequestMethod.GET, RequestType.NORMAL, String.format("%s/%s", ENDPOINT, id), null, BankAccount.class, options);
    }

    public static LobResponse<BankAccount> verify(String id, List amounts, RequestOptions options) throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
        Map params = new HashMap();
        params.put("amounts", amounts);
        return request(RequestMethod.POST, RequestType.NORMAL, String.format("%s/%s/verify", ENDPOINT, id), params, BankAccount.class, options);
    }

    public static LobResponse<BankAccountCollection> list() throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
        return list(null, null);
    }

    public static LobResponse<BankAccountCollection> list(Map<String, Object> params) throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
        return list(params, null);
    }

    public static LobResponse<BankAccountCollection> list(RequestOptions options) throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
        return list(null, options);
    }

    public static LobResponse<BankAccountCollection> list(Map<String, Object> params, RequestOptions options) throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
        return request(RequestMethod.GET, RequestType.NORMAL, ENDPOINT, params, BankAccountCollection.class, options);
    }

    public static LobResponse<BankAccount> delete(String id) throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
        return delete(id, null);
    }

    public static LobResponse<BankAccount> delete(String id, RequestOptions options) throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
        return request(RequestMethod.DELETE, RequestType.NORMAL, String.format("%s/%s", ENDPOINT, id), null, BankAccount.class, options);
    }

}

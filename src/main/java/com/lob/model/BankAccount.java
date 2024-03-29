/*
 * Lob
 * The Lob API is organized around REST. Our API is designed to have predictable, resource-oriented URLs and uses HTTP response codes to indicate any API errors. <p> Looking for our [previous documentation](https://lob.github.io/legacy-docs/)? 
 *
 * The version of the OpenAPI document: 1.3.0
 * Contact: lob-openapi@lob.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.lob.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.openapitools.jackson.nullable.JsonNullable;

import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;
/**
 * BankAccount
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class BankAccount {
  public static final String SERIALIZED_NAME_DESCRIPTION = "description";

  @SerializedName(SERIALIZED_NAME_DESCRIPTION)
  

  private String description;
  /**
  * An internal description that identifies this resource. Must be no longer than 255 characters. 
  * @return description
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "An internal description that identifies this resource. Must be no longer than 255 characters. ")
  
  public String getDescription() {
      return description;
  }
  
  

  public static final String SERIALIZED_NAME_ROUTING_NUMBER = "routing_number";

  @SerializedName(SERIALIZED_NAME_ROUTING_NUMBER)
  

  private String routingNumber;
  /**
  * Must be a [valid US routing number](https://www.frbservices.org/index.html).
  * @return routingNumber
  **/
  
  @javax.annotation.Nonnull
  
  @ApiModelProperty(required = true, value = "Must be a [valid US routing number](https://www.frbservices.org/index.html).")
  
  public String getRoutingNumber() {
      return routingNumber;
  }
  
  

  public static final String SERIALIZED_NAME_ACCOUNT_NUMBER = "account_number";

  @SerializedName(SERIALIZED_NAME_ACCOUNT_NUMBER)
  

  private String accountNumber;
  /**
  * Get accountNumber
  * @return accountNumber
  **/
  
  @javax.annotation.Nonnull
  
  @ApiModelProperty(required = true, value = "")
  
  public String getAccountNumber() {
      return accountNumber;
  }
  
  

  /**
   * The type of entity that holds the account.
   */
  @JsonAdapter(AccountTypeEnum.Adapter.class)
  public enum AccountTypeEnum {
    COMPANY("company"),
    
    INDIVIDUAL("individual");

    private String value;

    AccountTypeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static AccountTypeEnum fromValue(String value) {
      for (AccountTypeEnum b : AccountTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<AccountTypeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final AccountTypeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public AccountTypeEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return AccountTypeEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_ACCOUNT_TYPE = "account_type";

  @SerializedName(SERIALIZED_NAME_ACCOUNT_TYPE)
  

  private AccountTypeEnum accountType;
  /**
  * The type of entity that holds the account.
  * @return accountType
  **/
  
  @javax.annotation.Nonnull
  
  @ApiModelProperty(required = true, value = "The type of entity that holds the account.")
  
  public AccountTypeEnum getAccountType() {
      return accountType;
  }
  
  

  public static final String SERIALIZED_NAME_SIGNATORY = "signatory";

  @SerializedName(SERIALIZED_NAME_SIGNATORY)
  

  private String signatory;
  /**
  * The signatory associated with your account. This name will be printed on checks created with this bank account. If you prefer to use a custom signature image on your checks instead, please create your bank account from the [Dashboard](https://dashboard.lob.com/#/login).
  * @return signatory
  **/
  
  @javax.annotation.Nonnull
  
  @ApiModelProperty(required = true, value = "The signatory associated with your account. This name will be printed on checks created with this bank account. If you prefer to use a custom signature image on your checks instead, please create your bank account from the [Dashboard](https://dashboard.lob.com/#/login).")
  
  public String getSignatory() {
      return signatory;
  }
  
  

  public static final String SERIALIZED_NAME_METADATA = "metadata";

  @SerializedName(SERIALIZED_NAME_METADATA)
  private Map<String, String> metadata = null;
  public Map<String, String> getMetadata() {
    if (this.metadata == null) {
      this.metadata = new HashMap<String,String>();
    }
    return this.metadata;
  }

  public static final String SERIALIZED_NAME_ID = "id";

  @SerializedName(SERIALIZED_NAME_ID)
  

  private String id;
  /**
  * Unique identifier prefixed with `bank_`.
  * @return id
  **/
  
  @javax.annotation.Nonnull
  
  public String getId() { return id; }

  public void setId (String id) throws IllegalArgumentException {
    if(!id.matches("^bank_[a-zA-Z0-9]+$")) {
      throw new IllegalArgumentException("Invalid id provided");
    }

    this.id = id;
  }
  
  

  public static final String SERIALIZED_NAME_SIGNATURE_URL = "signature_url";

  @SerializedName(SERIALIZED_NAME_SIGNATURE_URL)
  

  private String signatureUrl;
  /**
  * A signed link to the signature image. will be generated.
  * @return signatureUrl
  **/
  
  @javax.annotation.Nullable
  
  public String getSignatureUrl() { return signatureUrl; }

  public void setSignatureUrl (String signatureUrl) throws IllegalArgumentException {
    if(!signatureUrl.matches("^https://lob-assets\\.com/(letters|postcards|bank-accounts|checks|self-mailers|cards)/[a-z]{3,4}_[a-z0-9]{15,16}(\\.pdf|_thumb_[a-z]+_[0-9]+\\.png)\\?(version=[a-z0-9-]*&)?expires=[0-9]{10}&signature=[a-zA-Z0-9-_]+$")) {
      throw new IllegalArgumentException("Invalid signature_url provided");
    }

    this.signatureUrl = signatureUrl;
  }
  
  

  public static final String SERIALIZED_NAME_BANK_NAME = "bank_name";

  @SerializedName(SERIALIZED_NAME_BANK_NAME)
  

  private String bankName;
  /**
  * The name of the bank based on the provided routing number, e.g. `JPMORGAN CHASE BANK`.
  * @return bankName
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "The name of the bank based on the provided routing number, e.g. `JPMORGAN CHASE BANK`.")
  
  public String getBankName() {
      return bankName;
  }
  
  

  public static final String SERIALIZED_NAME_VERIFIED = "verified";

  @SerializedName(SERIALIZED_NAME_VERIFIED)
  

  private Boolean verified = false;
  /**
  * A bank account must be verified before a check can be created.
  * @return verified
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "A bank account must be verified before a check can be created.")
  
  public Boolean getVerified() {
      return verified;
  }
  
  

  public static final String SERIALIZED_NAME_DATE_CREATED = "date_created";

  @SerializedName(SERIALIZED_NAME_DATE_CREATED)
  

  private OffsetDateTime dateCreated;
  /**
  * A timestamp in ISO 8601 format of the date the resource was created.
  * @return dateCreated
  **/
  
  @javax.annotation.Nonnull
  
  @ApiModelProperty(required = true, value = "A timestamp in ISO 8601 format of the date the resource was created.")
  
  public OffsetDateTime getDateCreated() {
      return dateCreated;
  }
  
  

  public static final String SERIALIZED_NAME_DATE_MODIFIED = "date_modified";

  @SerializedName(SERIALIZED_NAME_DATE_MODIFIED)
  

  private OffsetDateTime dateModified;
  /**
  * A timestamp in ISO 8601 format of the date the resource was last modified.
  * @return dateModified
  **/
  
  @javax.annotation.Nonnull
  
  @ApiModelProperty(required = true, value = "A timestamp in ISO 8601 format of the date the resource was last modified.")
  
  public OffsetDateTime getDateModified() {
      return dateModified;
  }
  
  

  public static final String SERIALIZED_NAME_DELETED = "deleted";

  @SerializedName(SERIALIZED_NAME_DELETED)
  

  private Boolean deleted;
  /**
  * Only returned if the resource has been successfully deleted.
  * @return deleted
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "Only returned if the resource has been successfully deleted.")
  
  public Boolean getDeleted() {
      return deleted;
  }
  
  

  /**
   * Gets or Sets _object
   */
  @JsonAdapter(ObjectEnum.Adapter.class)
  public enum ObjectEnum {
    BANK_ACCOUNT("bank_account");

    private String value;

    ObjectEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static ObjectEnum fromValue(String value) {
      for (ObjectEnum b : ObjectEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<ObjectEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final ObjectEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public ObjectEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return ObjectEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_OBJECT = "object";

  @SerializedName(SERIALIZED_NAME_OBJECT)
  

  private ObjectEnum _object = ObjectEnum.BANK_ACCOUNT;
  /**
  * Get _object
  * @return _object
  **/
  
  @javax.annotation.Nonnull
  
  @ApiModelProperty(required = true, value = "")
  
  public ObjectEnum getObject() {
      return _object;
  }
  
  


  /*
  public BankAccount description(String description) {
    
    this.description = description;
    return this;
  }
  */


  public void setDescription(String description) {
    this.description = description;
  }



  /*
  public BankAccount routingNumber(String routingNumber) {
    
    this.routingNumber = routingNumber;
    return this;
  }
  */


  public void setRoutingNumber(String routingNumber) {
    this.routingNumber = routingNumber;
  }



  /*
  public BankAccount accountNumber(String accountNumber) {
    
    this.accountNumber = accountNumber;
    return this;
  }
  */


  public void setAccountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
  }



  /*
  public BankAccount accountType(AccountTypeEnum accountType) {
    
    this.accountType = accountType;
    return this;
  }
  */


  public void setAccountType(AccountTypeEnum accountType) {
    this.accountType = accountType;
  }



  /*
  public BankAccount signatory(String signatory) {
    
    this.signatory = signatory;
    return this;
  }
  */


  public void setSignatory(String signatory) {
    this.signatory = signatory;
  }



  /*
  public BankAccount metadata(Map<String, String> metadata) {
    
    this.metadata = metadata;
    return this;
  }
  */

  public BankAccount putMetadataItem(String key, String metadataItem) {
    if (this.metadata == null) {
      this.metadata = new HashMap<String,String>();
    }
    this.metadata.put(key, metadataItem);
    return this;
  }


  public void setMetadata(Map<String, String> metadata) {
    this.metadata = metadata;
  }



  /*
  public BankAccount id(String id) {
    
    this.id = id;
    return this;
  }
  */





  /*
  public BankAccount signatureUrl(String signatureUrl) {
    
    this.signatureUrl = signatureUrl;
    return this;
  }
  */





  /*
  public BankAccount bankName(String bankName) {
    
    this.bankName = bankName;
    return this;
  }
  */


  public void setBankName(String bankName) {
    this.bankName = bankName;
  }



  /*
  public BankAccount verified(Boolean verified) {
    
    this.verified = verified;
    return this;
  }
  */


  public void setVerified(Boolean verified) {
    this.verified = verified;
  }



  /*
  public BankAccount dateCreated(OffsetDateTime dateCreated) {
    
    this.dateCreated = dateCreated;
    return this;
  }
  */


  public void setDateCreated(OffsetDateTime dateCreated) {
    this.dateCreated = dateCreated;
  }



  /*
  public BankAccount dateModified(OffsetDateTime dateModified) {
    
    this.dateModified = dateModified;
    return this;
  }
  */


  public void setDateModified(OffsetDateTime dateModified) {
    this.dateModified = dateModified;
  }



  /*
  public BankAccount deleted(Boolean deleted) {
    
    this.deleted = deleted;
    return this;
  }
  */


  public void setDeleted(Boolean deleted) {
    this.deleted = deleted;
  }



  /*
  public BankAccount _object(ObjectEnum _object) {
    
    this._object = _object;
    return this;
  }
  */


  public void setObject(ObjectEnum _object) {
    this._object = _object;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BankAccount bankAccount = (BankAccount) o;
    return Objects.equals(this.description, bankAccount.description) &&
        Objects.equals(this.routingNumber, bankAccount.routingNumber) &&
        Objects.equals(this.accountNumber, bankAccount.accountNumber) &&
        Objects.equals(this.accountType, bankAccount.accountType) &&
        Objects.equals(this.signatory, bankAccount.signatory) &&
        Objects.equals(this.metadata, bankAccount.metadata) &&
        Objects.equals(this.id, bankAccount.id) &&
        Objects.equals(this.signatureUrl, bankAccount.signatureUrl) &&
        Objects.equals(this.bankName, bankAccount.bankName) &&
        Objects.equals(this.verified, bankAccount.verified) &&
        Objects.equals(this.dateCreated, bankAccount.dateCreated) &&
        Objects.equals(this.dateModified, bankAccount.dateModified) &&
        Objects.equals(this.deleted, bankAccount.deleted) &&
        Objects.equals(this._object, bankAccount._object);
  }

  private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
    return a == b || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(description, routingNumber, accountNumber, accountType, signatory, metadata, id, signatureUrl, bankName, verified, dateCreated, dateModified, deleted, _object);
  }

  private static <T> int hashCodeNullable(JsonNullable<T> a) {
    if (a == null) {
      return 1;
    }
    return a.isPresent() ? Arrays.deepHashCode(new Object[]{a.get()}) : 31;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    routingNumber: ").append(toIndentedString(routingNumber)).append("\n");
    sb.append("    accountNumber: ").append(toIndentedString(accountNumber)).append("\n");
    sb.append("    accountType: ").append(toIndentedString(accountType)).append("\n");
    sb.append("    signatory: ").append(toIndentedString(signatory)).append("\n");
    sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    signatureUrl: ").append(toIndentedString(signatureUrl)).append("\n");
    sb.append("    bankName: ").append(toIndentedString(bankName)).append("\n");
    sb.append("    verified: ").append(toIndentedString(verified)).append("\n");
    sb.append("    dateCreated: ").append(toIndentedString(dateCreated)).append("\n");
    sb.append("    dateModified: ").append(toIndentedString(dateModified)).append("\n");
    sb.append("    deleted: ").append(toIndentedString(deleted)).append("\n");
    sb.append("    _object: ").append(toIndentedString(_object)).append("\n");
    sb.append("}");
    return sb.toString();
  }

    public Map<String, Object> toMap() {
      Map<String, Object> localMap = new HashMap<String, Object>();
      localMap.put("description", description);
      localMap.put("routing_number", routingNumber);
      localMap.put("account_number", accountNumber);
      localMap.put("account_type", accountType);
      localMap.put("signatory", signatory);
      localMap.put("metadata", metadata);
      localMap.put("id", id);
      localMap.put("signature_url", signatureUrl);
      localMap.put("bank_name", bankName);
      localMap.put("verified", verified);
      localMap.put("date_created", dateCreated);
      localMap.put("date_modified", dateModified);
      localMap.put("deleted", deleted);
      localMap.put("object", _object);
      return localMap;
    }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}


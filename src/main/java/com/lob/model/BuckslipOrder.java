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
import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;
/**
 * BuckslipOrder
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class BuckslipOrder {
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
  
  

  public static final String SERIALIZED_NAME_OBJECT = "object";

  @SerializedName(SERIALIZED_NAME_OBJECT)
  

  private String _object;
  /**
  * Value is type of resource.
  * @return _object
  **/
  
  @javax.annotation.Nonnull
  
  @ApiModelProperty(required = true, value = "Value is type of resource.")
  
  public String getObject() {
      return _object;
  }
  
  

  public static final String SERIALIZED_NAME_ID = "id";

  @SerializedName(SERIALIZED_NAME_ID)
  

  private String id;
  /**
  * Unique identifier prefixed with `bo_`.
  * @return id
  **/
  
  @javax.annotation.Nullable
  
  public String getId() { return id; }

  public void setId (String id) throws IllegalArgumentException {
    if(!id.matches("^bo_[a-zA-Z0-9]+$")) {
      throw new IllegalArgumentException("Invalid id provided");
    }

    this.id = id;
  }
  
  

  public static final String SERIALIZED_NAME_BUCKSLIP_ID = "buckslip_id";

  @SerializedName(SERIALIZED_NAME_BUCKSLIP_ID)
  

  private String buckslipId;
  /**
  * Unique identifier prefixed with `bck_`.
  * @return buckslipId
  **/
  
  @javax.annotation.Nullable
  
  public String getBuckslipId() { return buckslipId; }

  public void setBuckslipId (String buckslipId) throws IllegalArgumentException {
    if(!buckslipId.matches("^bck_[a-zA-Z0-9]+$")) {
      throw new IllegalArgumentException("Invalid buckslip_id provided");
    }

    this.buckslipId = buckslipId;
  }
  
  

  /**
   * The status of the buckslip order.
   */
  @JsonAdapter(StatusEnum.Adapter.class)
  public enum StatusEnum {
    PENDING("pending"),
    
    PRINTING("printing"),
    
    AVAILABLE("available"),
    
    CANCELLED("cancelled"),
    
    DEPLETED("depleted");

    private String value;

    StatusEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static StatusEnum fromValue(String value) {
      for (StatusEnum b : StatusEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<StatusEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final StatusEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public StatusEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return StatusEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_STATUS = "status";

  @SerializedName(SERIALIZED_NAME_STATUS)
  

  private StatusEnum status;
  /**
  * The status of the buckslip order.
  * @return status
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "The status of the buckslip order.")
  
  public StatusEnum getStatus() {
      return status;
  }
  
  

  public static final String SERIALIZED_NAME_QUANTITY_ORDERED = "quantity_ordered";

  @SerializedName(SERIALIZED_NAME_QUANTITY_ORDERED)
  

  private BigDecimal quantityOrdered = new BigDecimal("0");
  /**
  * The quantity of buckslips ordered.
  * @return quantityOrdered
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "The quantity of buckslips ordered.")
  
  public BigDecimal getQuantityOrdered() {
      return quantityOrdered;
  }
  
  

  public static final String SERIALIZED_NAME_UNIT_PRICE = "unit_price";

  @SerializedName(SERIALIZED_NAME_UNIT_PRICE)
  

  private BigDecimal unitPrice = new BigDecimal("0");
  /**
  * The unit price for the buckslip order.
  * @return unitPrice
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "The unit price for the buckslip order.")
  
  public BigDecimal getUnitPrice() {
      return unitPrice;
  }
  
  

  public static final String SERIALIZED_NAME_INVENTORY = "inventory";

  @SerializedName(SERIALIZED_NAME_INVENTORY)
  

  private BigDecimal inventory = new BigDecimal("0");
  /**
  * The inventory of the buckslip order.
  * @return inventory
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "The inventory of the buckslip order.")
  
  public BigDecimal getInventory() {
      return inventory;
  }
  
  

  public static final String SERIALIZED_NAME_CANCELLED_REASON = "cancelled_reason";

  @SerializedName(SERIALIZED_NAME_CANCELLED_REASON)
  

  private String cancelledReason;
  /**
  * The reason for cancellation.
  * @return cancelledReason
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "The reason for cancellation.")
  
  public String getCancelledReason() {
      return cancelledReason;
  }
  
  

  public static final String SERIALIZED_NAME_AVAILABILITY_DATE = "availability_date";

  @SerializedName(SERIALIZED_NAME_AVAILABILITY_DATE)
  

  private OffsetDateTime availabilityDate;
  /**
  * A timestamp in ISO 8601 format of the date the resource was created.
  * @return availabilityDate
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "A timestamp in ISO 8601 format of the date the resource was created.")
  
  public OffsetDateTime getAvailabilityDate() {
      return availabilityDate;
  }
  
  

  public static final String SERIALIZED_NAME_EXPECTED_AVAILABILITY_DATE = "expected_availability_date";

  @SerializedName(SERIALIZED_NAME_EXPECTED_AVAILABILITY_DATE)
  

  private OffsetDateTime expectedAvailabilityDate;
  /**
  * The fixed deadline for the buckslips to be printed.
  * @return expectedAvailabilityDate
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "The fixed deadline for the buckslips to be printed.")
  
  public OffsetDateTime getExpectedAvailabilityDate() {
      return expectedAvailabilityDate;
  }
  
  


  /*
  public BuckslipOrder dateCreated(OffsetDateTime dateCreated) {
    
    this.dateCreated = dateCreated;
    return this;
  }
  */


  public void setDateCreated(OffsetDateTime dateCreated) {
    this.dateCreated = dateCreated;
  }



  /*
  public BuckslipOrder dateModified(OffsetDateTime dateModified) {
    
    this.dateModified = dateModified;
    return this;
  }
  */


  public void setDateModified(OffsetDateTime dateModified) {
    this.dateModified = dateModified;
  }



  /*
  public BuckslipOrder deleted(Boolean deleted) {
    
    this.deleted = deleted;
    return this;
  }
  */


  public void setDeleted(Boolean deleted) {
    this.deleted = deleted;
  }



  /*
  public BuckslipOrder _object(String _object) {
    
    this._object = _object;
    return this;
  }
  */


  public void setObject(String _object) {
    this._object = _object;
  }



  /*
  public BuckslipOrder id(String id) {
    
    this.id = id;
    return this;
  }
  */





  /*
  public BuckslipOrder buckslipId(String buckslipId) {
    
    this.buckslipId = buckslipId;
    return this;
  }
  */





  /*
  public BuckslipOrder status(StatusEnum status) {
    
    this.status = status;
    return this;
  }
  */


  public void setStatus(StatusEnum status) {
    this.status = status;
  }



  /*
  public BuckslipOrder quantityOrdered(BigDecimal quantityOrdered) {
    
    this.quantityOrdered = quantityOrdered;
    return this;
  }
  */


  public void setQuantityOrdered(BigDecimal quantityOrdered) {
    this.quantityOrdered = quantityOrdered;
  }



  /*
  public BuckslipOrder unitPrice(BigDecimal unitPrice) {
    
    this.unitPrice = unitPrice;
    return this;
  }
  */


  public void setUnitPrice(BigDecimal unitPrice) {
    this.unitPrice = unitPrice;
  }



  /*
  public BuckslipOrder inventory(BigDecimal inventory) {
    
    this.inventory = inventory;
    return this;
  }
  */


  public void setInventory(BigDecimal inventory) {
    this.inventory = inventory;
  }



  /*
  public BuckslipOrder cancelledReason(String cancelledReason) {
    
    this.cancelledReason = cancelledReason;
    return this;
  }
  */


  public void setCancelledReason(String cancelledReason) {
    this.cancelledReason = cancelledReason;
  }



  /*
  public BuckslipOrder availabilityDate(OffsetDateTime availabilityDate) {
    
    this.availabilityDate = availabilityDate;
    return this;
  }
  */


  public void setAvailabilityDate(OffsetDateTime availabilityDate) {
    this.availabilityDate = availabilityDate;
  }



  /*
  public BuckslipOrder expectedAvailabilityDate(OffsetDateTime expectedAvailabilityDate) {
    
    this.expectedAvailabilityDate = expectedAvailabilityDate;
    return this;
  }
  */


  public void setExpectedAvailabilityDate(OffsetDateTime expectedAvailabilityDate) {
    this.expectedAvailabilityDate = expectedAvailabilityDate;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BuckslipOrder buckslipOrder = (BuckslipOrder) o;
    return Objects.equals(this.dateCreated, buckslipOrder.dateCreated) &&
        Objects.equals(this.dateModified, buckslipOrder.dateModified) &&
        Objects.equals(this.deleted, buckslipOrder.deleted) &&
        Objects.equals(this._object, buckslipOrder._object) &&
        Objects.equals(this.id, buckslipOrder.id) &&
        Objects.equals(this.buckslipId, buckslipOrder.buckslipId) &&
        Objects.equals(this.status, buckslipOrder.status) &&
        Objects.equals(this.quantityOrdered, buckslipOrder.quantityOrdered) &&
        Objects.equals(this.unitPrice, buckslipOrder.unitPrice) &&
        Objects.equals(this.inventory, buckslipOrder.inventory) &&
        Objects.equals(this.cancelledReason, buckslipOrder.cancelledReason) &&
        Objects.equals(this.availabilityDate, buckslipOrder.availabilityDate) &&
        Objects.equals(this.expectedAvailabilityDate, buckslipOrder.expectedAvailabilityDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dateCreated, dateModified, deleted, _object, id, buckslipId, status, quantityOrdered, unitPrice, inventory, cancelledReason, availabilityDate, expectedAvailabilityDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{\n");
    sb.append("    dateCreated: ").append(toIndentedString(dateCreated)).append("\n");
    sb.append("    dateModified: ").append(toIndentedString(dateModified)).append("\n");
    sb.append("    deleted: ").append(toIndentedString(deleted)).append("\n");
    sb.append("    _object: ").append(toIndentedString(_object)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    buckslipId: ").append(toIndentedString(buckslipId)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    quantityOrdered: ").append(toIndentedString(quantityOrdered)).append("\n");
    sb.append("    unitPrice: ").append(toIndentedString(unitPrice)).append("\n");
    sb.append("    inventory: ").append(toIndentedString(inventory)).append("\n");
    sb.append("    cancelledReason: ").append(toIndentedString(cancelledReason)).append("\n");
    sb.append("    availabilityDate: ").append(toIndentedString(availabilityDate)).append("\n");
    sb.append("    expectedAvailabilityDate: ").append(toIndentedString(expectedAvailabilityDate)).append("\n");
    sb.append("}");
    return sb.toString();
  }

    public Map<String, Object> toMap() {
      Map<String, Object> localMap = new HashMap<String, Object>();
      localMap.put("date_created", dateCreated);
      localMap.put("date_modified", dateModified);
      localMap.put("deleted", deleted);
      localMap.put("object", _object);
      localMap.put("id", id);
      localMap.put("buckslip_id", buckslipId);
      localMap.put("status", status);
      localMap.put("quantity_ordered", quantityOrdered);
      localMap.put("unit_price", unitPrice);
      localMap.put("inventory", inventory);
      localMap.put("cancelled_reason", cancelledReason);
      localMap.put("availability_date", availabilityDate);
      localMap.put("expected_availability_date", expectedAvailabilityDate);
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


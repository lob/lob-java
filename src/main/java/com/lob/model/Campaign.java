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
import com.lob.model.CampaignCreative;
import com.lob.model.CmpScheduleType;
import com.lob.model.CmpUseType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.openapitools.jackson.nullable.JsonNullable;

import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;
/**
 * Campaign
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class Campaign {
  public static final String SERIALIZED_NAME_BILLING_GROUP_ID = "billing_group_id";

  @SerializedName(SERIALIZED_NAME_BILLING_GROUP_ID)
  

  private String billingGroupId;
  /**
  * Unique identifier prefixed with `bg_`.
  * @return billingGroupId
  **/
  
  @javax.annotation.Nullable
  
  public String getBillingGroupId() { return billingGroupId; }

  public void setBillingGroupId (String billingGroupId) throws IllegalArgumentException {
    if(!billingGroupId.matches("^bg_[a-zA-Z0-9]+$")) {
      throw new IllegalArgumentException("Invalid billing_group_id provided");
    }

    this.billingGroupId = billingGroupId;
  }
  
  

  public static final String SERIALIZED_NAME_NAME = "name";

  @SerializedName(SERIALIZED_NAME_NAME)
  

  private String name;
  /**
  * Name of the campaign.
  * @return name
  **/
  
  @javax.annotation.Nonnull
  
  @ApiModelProperty(required = true, value = "Name of the campaign.")
  
  public String getName() {
      return name;
  }
  
  

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
  
  

  public static final String SERIALIZED_NAME_SCHEDULE_TYPE = "schedule_type";

  @SerializedName(SERIALIZED_NAME_SCHEDULE_TYPE)
  

  private CmpScheduleType scheduleType;
  /**
  * Get scheduleType
  * @return scheduleType
  **/
  
  @javax.annotation.Nonnull
  
  @ApiModelProperty(required = true, value = "")
  
  public CmpScheduleType getScheduleType() {
      return scheduleType;
  }
  
  

  public static final String SERIALIZED_NAME_TARGET_DELIVERY_DATE = "target_delivery_date";

  @SerializedName(SERIALIZED_NAME_TARGET_DELIVERY_DATE)
  

  private Date targetDeliveryDate;
  /**
  * If `schedule_type` is `target_delivery_date`, provide a targeted delivery date for mail pieces in this campaign.
  * @return targetDeliveryDate
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "If `schedule_type` is `target_delivery_date`, provide a targeted delivery date for mail pieces in this campaign.")
  
  public Date getTargetDeliveryDate() {
      return targetDeliveryDate;
  }
  
  

  public static final String SERIALIZED_NAME_SEND_DATE = "send_date";

  @SerializedName(SERIALIZED_NAME_SEND_DATE)
  

  private Date sendDate;
  /**
  * If `schedule_type` is `scheduled_send_date`, provide a date to send this campaign.
  * @return sendDate
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "If `schedule_type` is `scheduled_send_date`, provide a date to send this campaign.")
  
  public Date getSendDate() {
      return sendDate;
  }
  
  

  public static final String SERIALIZED_NAME_CANCEL_WINDOW_CAMPAIGN_MINUTES = "cancel_window_campaign_minutes";

  @SerializedName(SERIALIZED_NAME_CANCEL_WINDOW_CAMPAIGN_MINUTES)
  

  private Integer cancelWindowCampaignMinutes;
  /**
  * A window, in minutes, within which the campaign can be canceled.
  * @return cancelWindowCampaignMinutes
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "A window, in minutes, within which the campaign can be canceled.")
  
  public Integer getCancelWindowCampaignMinutes() {
      return cancelWindowCampaignMinutes;
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

  public static final String SERIALIZED_NAME_USE_TYPE = "use_type";

  @SerializedName(SERIALIZED_NAME_USE_TYPE)
  

  private CmpUseType useType;
  /**
  * Get useType
  * @return useType
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(required = true, value = "")
  
  public CmpUseType getUseType() {
      return useType;
  }
  
  

  public static final String SERIALIZED_NAME_AUTO_CANCEL_IF_NCOA = "auto_cancel_if_ncoa";

  @SerializedName(SERIALIZED_NAME_AUTO_CANCEL_IF_NCOA)
  

  private Boolean autoCancelIfNcoa;
  /**
  * Whether or not a mail piece should be automatically canceled and not sent if the address is updated via NCOA.
  * @return autoCancelIfNcoa
  **/
  
  @javax.annotation.Nonnull
  
  @ApiModelProperty(required = true, value = "Whether or not a mail piece should be automatically canceled and not sent if the address is updated via NCOA.")
  
  public Boolean getAutoCancelIfNcoa() {
      return autoCancelIfNcoa;
  }
  
  

  public static final String SERIALIZED_NAME_ID = "id";

  @SerializedName(SERIALIZED_NAME_ID)
  

  private String id;
  /**
  * Unique identifier prefixed with `cmp_`.
  * @return id
  **/
  
  @javax.annotation.Nonnull
  
  public String getId() { return id; }

  public void setId (String id) throws IllegalArgumentException {
    if(!id.matches("^cmp_[a-zA-Z0-9]+$")) {
      throw new IllegalArgumentException("Invalid id provided");
    }

    this.id = id;
  }
  
  

  public static final String SERIALIZED_NAME_ACCOUNT_ID = "account_id";

  @SerializedName(SERIALIZED_NAME_ACCOUNT_ID)
  

  private String accountId;
  /**
  * Account ID that this campaign is associated with.
  * @return accountId
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "Account ID that this campaign is associated with.")
  
  public String getAccountId() {
      return accountId;
  }
  
  

  public static final String SERIALIZED_NAME_IS_DRAFT = "is_draft";

  @SerializedName(SERIALIZED_NAME_IS_DRAFT)
  

  private Boolean isDraft = true;
  /**
  * Whether or not the campaign is still a draft.
  * @return isDraft
  **/
  
  @javax.annotation.Nonnull
  
  @ApiModelProperty(required = true, value = "Whether or not the campaign is still a draft.")
  
  public Boolean getIsDraft() {
      return isDraft;
  }
  
  

  public static final String SERIALIZED_NAME_CREATIVES = "creatives";

  @SerializedName(SERIALIZED_NAME_CREATIVES)
  private List<CampaignCreative> creatives = new ArrayList<CampaignCreative>();

  public static final String SERIALIZED_NAME_DATE_CREATED = "date_created";

  @SerializedName(SERIALIZED_NAME_DATE_CREATED)
  

  private Date dateCreated;
  /**
  * A timestamp in ISO 8601 format of the date the resource was created.
  * @return dateCreated
  **/
  
  @javax.annotation.Nonnull
  
  @ApiModelProperty(required = true, value = "A timestamp in ISO 8601 format of the date the resource was created.")
  
  public Date getDateCreated() {
      return dateCreated;
  }
  
  

  public static final String SERIALIZED_NAME_DATE_MODIFIED = "date_modified";

  @SerializedName(SERIALIZED_NAME_DATE_MODIFIED)
  

  private Date dateModified;
  /**
  * A timestamp in ISO 8601 format of the date the resource was last modified.
  * @return dateModified
  **/
  
  @javax.annotation.Nonnull
  
  @ApiModelProperty(required = true, value = "A timestamp in ISO 8601 format of the date the resource was last modified.")
  
  public Date getDateModified() {
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
   * Value is resource type.
   */
  @JsonAdapter(ObjectEnum.Adapter.class)
  public enum ObjectEnum {
    CAMPAIGN("campaign");

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
  

  private ObjectEnum _object = ObjectEnum.CAMPAIGN;
  /**
  * Value is resource type.
  * @return _object
  **/
  
  @javax.annotation.Nonnull
  
  @ApiModelProperty(required = true, value = "Value is resource type.")
  
  public ObjectEnum getObject() {
      return _object;
  }
  
  


  /*
  public Campaign billingGroupId(String billingGroupId) {
    
    this.billingGroupId = billingGroupId;
    return this;
  }
  */





  /*
  public Campaign name(String name) {
    
    this.name = name;
    return this;
  }
  */


  public void setName(String name) {
    this.name = name;
  }



  /*
  public Campaign description(String description) {
    
    this.description = description;
    return this;
  }
  */


  public void setDescription(String description) {
    this.description = description;
  }



  /*
  public Campaign scheduleType(CmpScheduleType scheduleType) {
    
    this.scheduleType = scheduleType;
    return this;
  }
  */


  public void setScheduleType(CmpScheduleType scheduleType) {
    this.scheduleType = scheduleType;
  }



  /*
  public Campaign targetDeliveryDate(Date targetDeliveryDate) {
    
    this.targetDeliveryDate = targetDeliveryDate;
    return this;
  }
  */


  public void setTargetDeliveryDate(Date targetDeliveryDate) {
    this.targetDeliveryDate = targetDeliveryDate;
  }



  /*
  public Campaign sendDate(Date sendDate) {
    
    this.sendDate = sendDate;
    return this;
  }
  */


  public void setSendDate(Date sendDate) {
    this.sendDate = sendDate;
  }



  /*
  public Campaign cancelWindowCampaignMinutes(Integer cancelWindowCampaignMinutes) {
    
    this.cancelWindowCampaignMinutes = cancelWindowCampaignMinutes;
    return this;
  }
  */


  public void setCancelWindowCampaignMinutes(Integer cancelWindowCampaignMinutes) {
    this.cancelWindowCampaignMinutes = cancelWindowCampaignMinutes;
  }



  /*
  public Campaign metadata(Map<String, String> metadata) {
    
    this.metadata = metadata;
    return this;
  }
  */

  public Campaign putMetadataItem(String key, String metadataItem) {
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
  public Campaign useType(CmpUseType useType) {
    
    this.useType = useType;
    return this;
  }
  */


  public void setUseType(CmpUseType useType) {
    this.useType = useType;
  }



  /*
  public Campaign autoCancelIfNcoa(Boolean autoCancelIfNcoa) {
    
    this.autoCancelIfNcoa = autoCancelIfNcoa;
    return this;
  }
  */


  public void setAutoCancelIfNcoa(Boolean autoCancelIfNcoa) {
    this.autoCancelIfNcoa = autoCancelIfNcoa;
  }



  /*
  public Campaign id(String id) {
    
    this.id = id;
    return this;
  }
  */





  /*
  public Campaign accountId(String accountId) {
    
    this.accountId = accountId;
    return this;
  }
  */


  public void setAccountId(String accountId) {
    this.accountId = accountId;
  }



  /*
  public Campaign isDraft(Boolean isDraft) {
    
    this.isDraft = isDraft;
    return this;
  }
  */


  public void setIsDraft(Boolean isDraft) {
    this.isDraft = isDraft;
  }



  /*
  public Campaign creatives(List<CampaignCreative> creatives) {
    
    this.creatives = creatives;
    return this;
  }
  */

  public Campaign addCreativesItem(CampaignCreative creativesItem) {
    this.creatives.add(creativesItem);
    return this;
  }


  public void setCreatives(List<CampaignCreative> creatives) {
    this.creatives = creatives;
  }



  /*
  public Campaign dateCreated(Date dateCreated) {
    
    this.dateCreated = dateCreated;
    return this;
  }
  */


  public void setDateCreated(Date dateCreated) {
    this.dateCreated = dateCreated;
  }



  /*
  public Campaign dateModified(Date dateModified) {
    
    this.dateModified = dateModified;
    return this;
  }
  */


  public void setDateModified(Date dateModified) {
    this.dateModified = dateModified;
  }



  /*
  public Campaign deleted(Boolean deleted) {
    
    this.deleted = deleted;
    return this;
  }
  */


  public void setDeleted(Boolean deleted) {
    this.deleted = deleted;
  }



  /*
  public Campaign _object(ObjectEnum _object) {
    
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
    Campaign campaign = (Campaign) o;
    return Objects.equals(this.billingGroupId, campaign.billingGroupId) &&
        Objects.equals(this.name, campaign.name) &&
        Objects.equals(this.description, campaign.description) &&
        Objects.equals(this.scheduleType, campaign.scheduleType) &&
        Objects.equals(this.targetDeliveryDate, campaign.targetDeliveryDate) &&
        Objects.equals(this.sendDate, campaign.sendDate) &&
        Objects.equals(this.cancelWindowCampaignMinutes, campaign.cancelWindowCampaignMinutes) &&
        Objects.equals(this.metadata, campaign.metadata) &&
        Objects.equals(this.useType, campaign.useType) &&
        Objects.equals(this.autoCancelIfNcoa, campaign.autoCancelIfNcoa) &&
        Objects.equals(this.id, campaign.id) &&
        Objects.equals(this.accountId, campaign.accountId) &&
        Objects.equals(this.isDraft, campaign.isDraft) &&
        Objects.equals(this.creatives, campaign.creatives) &&
        Objects.equals(this.dateCreated, campaign.dateCreated) &&
        Objects.equals(this.dateModified, campaign.dateModified) &&
        Objects.equals(this.deleted, campaign.deleted) &&
        Objects.equals(this._object, campaign._object);
  }

  private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
    return a == b || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(billingGroupId, name, description, scheduleType, targetDeliveryDate, sendDate, cancelWindowCampaignMinutes, metadata, useType, autoCancelIfNcoa, id, accountId, isDraft, creatives, dateCreated, dateModified, deleted, _object);
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
    sb.append("    billingGroupId: ").append(toIndentedString(billingGroupId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    scheduleType: ").append(toIndentedString(scheduleType)).append("\n");
    sb.append("    targetDeliveryDate: ").append(toIndentedString(targetDeliveryDate)).append("\n");
    sb.append("    sendDate: ").append(toIndentedString(sendDate)).append("\n");
    sb.append("    cancelWindowCampaignMinutes: ").append(toIndentedString(cancelWindowCampaignMinutes)).append("\n");
    sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
    sb.append("    useType: ").append(toIndentedString(useType)).append("\n");
    sb.append("    autoCancelIfNcoa: ").append(toIndentedString(autoCancelIfNcoa)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    accountId: ").append(toIndentedString(accountId)).append("\n");
    sb.append("    isDraft: ").append(toIndentedString(isDraft)).append("\n");
    sb.append("    creatives: ").append(toIndentedString(creatives)).append("\n");
    sb.append("    dateCreated: ").append(toIndentedString(dateCreated)).append("\n");
    sb.append("    dateModified: ").append(toIndentedString(dateModified)).append("\n");
    sb.append("    deleted: ").append(toIndentedString(deleted)).append("\n");
    sb.append("    _object: ").append(toIndentedString(_object)).append("\n");
    sb.append("}");
    return sb.toString();
  }

    public Map<String, Object> toMap() {
      Map<String, Object> localMap = new HashMap<String, Object>();
      localMap.put("billing_group_id", billingGroupId);
      localMap.put("name", name);
      localMap.put("description", description);
      localMap.put("schedule_type", scheduleType);
      localMap.put("target_delivery_date", targetDeliveryDate);
      localMap.put("send_date", sendDate);
      localMap.put("cancel_window_campaign_minutes", cancelWindowCampaignMinutes);
      localMap.put("metadata", metadata);
      localMap.put("use_type", useType);
      localMap.put("auto_cancel_if_ncoa", autoCancelIfNcoa);
      localMap.put("id", id);
      localMap.put("account_id", accountId);
      localMap.put("is_draft", isDraft);
      localMap.put("creatives", creatives);
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


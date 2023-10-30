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
import com.lob.model.CmpScheduleType;
import com.lob.model.CmpUseType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.openapitools.jackson.nullable.JsonNullable;

import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;
/**
 * CampaignUpdatable
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class CampaignUpdatable {
  public static final String SERIALIZED_NAME_NAME = "name";

  @SerializedName(SERIALIZED_NAME_NAME)
  

  private String name;
  /**
  * Get name
  * @return name
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "")
  
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
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "")
  
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

  public static final String SERIALIZED_NAME_IS_DRAFT = "is_draft";

  @SerializedName(SERIALIZED_NAME_IS_DRAFT)
  

  private Boolean isDraft;
  /**
  * Whether or not the campaign is still a draft.
  * @return isDraft
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "Whether or not the campaign is still a draft.")
  
  public Boolean getIsDraft() {
      return isDraft;
  }
  
  

  public static final String SERIALIZED_NAME_USE_TYPE = "use_type";

  @SerializedName(SERIALIZED_NAME_USE_TYPE)
  

  private CmpUseType useType;
  /**
  * Get useType
  * @return useType
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "")
  
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
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "Whether or not a mail piece should be automatically canceled and not sent if the address is updated via NCOA.")
  
  public Boolean getAutoCancelIfNcoa() {
      return autoCancelIfNcoa;
  }
  
  


  /*
  public CampaignUpdatable name(String name) {
    
    this.name = name;
    return this;
  }
  */


  public void setName(String name) {
    this.name = name;
  }



  /*
  public CampaignUpdatable description(String description) {
    
    this.description = description;
    return this;
  }
  */


  public void setDescription(String description) {
    this.description = description;
  }



  /*
  public CampaignUpdatable scheduleType(CmpScheduleType scheduleType) {
    
    this.scheduleType = scheduleType;
    return this;
  }
  */


  public void setScheduleType(CmpScheduleType scheduleType) {
    this.scheduleType = scheduleType;
  }



  /*
  public CampaignUpdatable targetDeliveryDate(Date targetDeliveryDate) {
    
    this.targetDeliveryDate = targetDeliveryDate;
    return this;
  }
  */


  public void setTargetDeliveryDate(Date targetDeliveryDate) {
    this.targetDeliveryDate = targetDeliveryDate;
  }



  /*
  public CampaignUpdatable sendDate(Date sendDate) {
    
    this.sendDate = sendDate;
    return this;
  }
  */


  public void setSendDate(Date sendDate) {
    this.sendDate = sendDate;
  }



  /*
  public CampaignUpdatable cancelWindowCampaignMinutes(Integer cancelWindowCampaignMinutes) {
    
    this.cancelWindowCampaignMinutes = cancelWindowCampaignMinutes;
    return this;
  }
  */


  public void setCancelWindowCampaignMinutes(Integer cancelWindowCampaignMinutes) {
    this.cancelWindowCampaignMinutes = cancelWindowCampaignMinutes;
  }



  /*
  public CampaignUpdatable metadata(Map<String, String> metadata) {
    
    this.metadata = metadata;
    return this;
  }
  */

  public CampaignUpdatable putMetadataItem(String key, String metadataItem) {
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
  public CampaignUpdatable isDraft(Boolean isDraft) {
    
    this.isDraft = isDraft;
    return this;
  }
  */


  public void setIsDraft(Boolean isDraft) {
    this.isDraft = isDraft;
  }



  /*
  public CampaignUpdatable useType(CmpUseType useType) {
    
    this.useType = useType;
    return this;
  }
  */


  public void setUseType(CmpUseType useType) {
    this.useType = useType;
  }



  /*
  public CampaignUpdatable autoCancelIfNcoa(Boolean autoCancelIfNcoa) {
    
    this.autoCancelIfNcoa = autoCancelIfNcoa;
    return this;
  }
  */


  public void setAutoCancelIfNcoa(Boolean autoCancelIfNcoa) {
    this.autoCancelIfNcoa = autoCancelIfNcoa;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CampaignUpdatable campaignUpdatable = (CampaignUpdatable) o;
    return Objects.equals(this.name, campaignUpdatable.name) &&
        Objects.equals(this.description, campaignUpdatable.description) &&
        Objects.equals(this.scheduleType, campaignUpdatable.scheduleType) &&
        Objects.equals(this.targetDeliveryDate, campaignUpdatable.targetDeliveryDate) &&
        Objects.equals(this.sendDate, campaignUpdatable.sendDate) &&
        Objects.equals(this.cancelWindowCampaignMinutes, campaignUpdatable.cancelWindowCampaignMinutes) &&
        Objects.equals(this.metadata, campaignUpdatable.metadata) &&
        Objects.equals(this.isDraft, campaignUpdatable.isDraft) &&
        Objects.equals(this.useType, campaignUpdatable.useType) &&
        Objects.equals(this.autoCancelIfNcoa, campaignUpdatable.autoCancelIfNcoa);
  }

  private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
    return a == b || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, description, scheduleType, targetDeliveryDate, sendDate, cancelWindowCampaignMinutes, metadata, isDraft, useType, autoCancelIfNcoa);
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
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    scheduleType: ").append(toIndentedString(scheduleType)).append("\n");
    sb.append("    targetDeliveryDate: ").append(toIndentedString(targetDeliveryDate)).append("\n");
    sb.append("    sendDate: ").append(toIndentedString(sendDate)).append("\n");
    sb.append("    cancelWindowCampaignMinutes: ").append(toIndentedString(cancelWindowCampaignMinutes)).append("\n");
    sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
    sb.append("    isDraft: ").append(toIndentedString(isDraft)).append("\n");
    sb.append("    useType: ").append(toIndentedString(useType)).append("\n");
    sb.append("    autoCancelIfNcoa: ").append(toIndentedString(autoCancelIfNcoa)).append("\n");
    sb.append("}");
    return sb.toString();
  }

    public Map<String, Object> toMap() {
      Map<String, Object> localMap = new HashMap<String, Object>();
      localMap.put("name", name);
      localMap.put("description", description);
      localMap.put("schedule_type", scheduleType);
      localMap.put("target_delivery_date", targetDeliveryDate);
      localMap.put("send_date", sendDate);
      localMap.put("cancel_window_campaign_minutes", cancelWindowCampaignMinutes);
      localMap.put("metadata", metadata);
      localMap.put("is_draft", isDraft);
      localMap.put("use_type", useType);
      localMap.put("auto_cancel_if_ncoa", autoCancelIfNcoa);
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


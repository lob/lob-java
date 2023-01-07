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
import com.lob.model.OptionalAddressColumnMapping;
import com.lob.model.RequiredAddressColumnMapping;
import com.lob.model.UploadsMetadata;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import org.openapitools.jackson.nullable.JsonNullable;

import com.google.gson.Gson;
/**
 * UploadUpdatable
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class UploadUpdatable {
  public static final String SERIALIZED_NAME_ORIGINAL_FILENAME = "originalFilename";

  @SerializedName(SERIALIZED_NAME_ORIGINAL_FILENAME)
  

  private String originalFilename;
  /**
  * Original filename provided when the upload is created.
  * @return originalFilename
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "Original filename provided when the upload is created.")
  
  public String getOriginalFilename() {
      return originalFilename;
  }
  
  

  public static final String SERIALIZED_NAME_REQUIRED_ADDRESS_COLUMN_MAPPING = "requiredAddressColumnMapping";

  @SerializedName(SERIALIZED_NAME_REQUIRED_ADDRESS_COLUMN_MAPPING)
  

  private RequiredAddressColumnMapping requiredAddressColumnMapping;
  /**
  * Get requiredAddressColumnMapping
  * @return requiredAddressColumnMapping
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "")
  
  public RequiredAddressColumnMapping getRequiredAddressColumnMapping() {
      return requiredAddressColumnMapping;
  }
  
  

  public static final String SERIALIZED_NAME_OPTIONAL_ADDRESS_COLUMN_MAPPING = "optionalAddressColumnMapping";

  @SerializedName(SERIALIZED_NAME_OPTIONAL_ADDRESS_COLUMN_MAPPING)
  

  private OptionalAddressColumnMapping optionalAddressColumnMapping;
  /**
  * Get optionalAddressColumnMapping
  * @return optionalAddressColumnMapping
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "")
  
  public OptionalAddressColumnMapping getOptionalAddressColumnMapping() {
      return optionalAddressColumnMapping;
  }
  
  

  public static final String SERIALIZED_NAME_METADATA = "metadata";

  @SerializedName(SERIALIZED_NAME_METADATA)
  

  private UploadsMetadata metadata = {"columns":[]};
  /**
  * Get metadata
  * @return metadata
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "")
  
  public UploadsMetadata getMetadata() {
      return metadata;
  }
  
  

  public static final String SERIALIZED_NAME_MERGE_VARIABLE_COLUMN_MAPPING = "mergeVariableColumnMapping";

  @SerializedName(SERIALIZED_NAME_MERGE_VARIABLE_COLUMN_MAPPING)
  

  private Object mergeVariableColumnMapping;
  /**
  * The mapping of column headers in your file to the merge variables present in your creative. See our <a href=\"https://help.lob.com/print-and-mail/building-a-mail-strategy/campaign-or-triggered-sends/campaign-audience-guide#step-3-map-merge-variable-data-if-applicable-7\" target=\"_blank\">Campaign Audience Guide</a> for additional details. <br />If a merge variable has the same \"name\" as a \"key\" in the `requiredAddressColumnMapping` or `optionalAddressColumnMapping` objects, then they **CANNOT** have a different value in this object. If a different value is provided, then when the campaign is processing it will get overwritten with the mapped value present in the `requiredAddressColumnMapping` or `optionalAddressColumnMapping` objects.
  * @return mergeVariableColumnMapping
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(example = "{\"name\":\"recipient_name\",\"gift_code\":\"code\"}", value = "The mapping of column headers in your file to the merge variables present in your creative. See our <a href=\"https://help.lob.com/print-and-mail/building-a-mail-strategy/campaign-or-triggered-sends/campaign-audience-guide#step-3-map-merge-variable-data-if-applicable-7\" target=\"_blank\">Campaign Audience Guide</a> for additional details. <br />If a merge variable has the same \"name\" as a \"key\" in the `requiredAddressColumnMapping` or `optionalAddressColumnMapping` objects, then they **CANNOT** have a different value in this object. If a different value is provided, then when the campaign is processing it will get overwritten with the mapped value present in the `requiredAddressColumnMapping` or `optionalAddressColumnMapping` objects.")
  
  public Object getMergeVariableColumnMapping() {
      return mergeVariableColumnMapping;
  }
  
  


  /*
  public UploadUpdatable originalFilename(String originalFilename) {
    
    this.originalFilename = originalFilename;
    return this;
  }
  */


  public void setOriginalFilename(String originalFilename) {
    this.originalFilename = originalFilename;
  }



  /*
  public UploadUpdatable requiredAddressColumnMapping(RequiredAddressColumnMapping requiredAddressColumnMapping) {
    
    this.requiredAddressColumnMapping = requiredAddressColumnMapping;
    return this;
  }
  */


  public void setRequiredAddressColumnMapping(RequiredAddressColumnMapping requiredAddressColumnMapping) {
    this.requiredAddressColumnMapping = requiredAddressColumnMapping;
  }



  /*
  public UploadUpdatable optionalAddressColumnMapping(OptionalAddressColumnMapping optionalAddressColumnMapping) {
    
    this.optionalAddressColumnMapping = optionalAddressColumnMapping;
    return this;
  }
  */


  public void setOptionalAddressColumnMapping(OptionalAddressColumnMapping optionalAddressColumnMapping) {
    this.optionalAddressColumnMapping = optionalAddressColumnMapping;
  }



  /*
  public UploadUpdatable metadata(UploadsMetadata metadata) {
    
    this.metadata = metadata;
    return this;
  }
  */


  public void setMetadata(UploadsMetadata metadata) {
    this.metadata = metadata;
  }



  /*
  public UploadUpdatable mergeVariableColumnMapping(Object mergeVariableColumnMapping) {
    
    this.mergeVariableColumnMapping = mergeVariableColumnMapping;
    return this;
  }
  */


  public void setMergeVariableColumnMapping(Object mergeVariableColumnMapping) {
    this.mergeVariableColumnMapping = mergeVariableColumnMapping;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UploadUpdatable uploadUpdatable = (UploadUpdatable) o;
    return Objects.equals(this.originalFilename, uploadUpdatable.originalFilename) &&
        Objects.equals(this.requiredAddressColumnMapping, uploadUpdatable.requiredAddressColumnMapping) &&
        Objects.equals(this.optionalAddressColumnMapping, uploadUpdatable.optionalAddressColumnMapping) &&
        Objects.equals(this.metadata, uploadUpdatable.metadata) &&
        Objects.equals(this.mergeVariableColumnMapping, uploadUpdatable.mergeVariableColumnMapping);
  }

  private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
    return a == b || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(originalFilename, requiredAddressColumnMapping, optionalAddressColumnMapping, metadata, mergeVariableColumnMapping);
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
    sb.append("    originalFilename: ").append(toIndentedString(originalFilename)).append("\n");
    sb.append("    requiredAddressColumnMapping: ").append(toIndentedString(requiredAddressColumnMapping)).append("\n");
    sb.append("    optionalAddressColumnMapping: ").append(toIndentedString(optionalAddressColumnMapping)).append("\n");
    sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
    sb.append("    mergeVariableColumnMapping: ").append(toIndentedString(mergeVariableColumnMapping)).append("\n");
    sb.append("}");
    return sb.toString();
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


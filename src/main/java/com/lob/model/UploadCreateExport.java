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

import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;
/**
 * UploadCreateExport
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class UploadCreateExport {
  /**
   * Gets or Sets message
   */
  @JsonAdapter(MessageEnum.Adapter.class)
  public enum MessageEnum {
    EXPORT_IS_PROCESSING_("Export is processing.");

    private String value;

    MessageEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static MessageEnum fromValue(String value) {
      for (MessageEnum b : MessageEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<MessageEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final MessageEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public MessageEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return MessageEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_MESSAGE = "message";

  @SerializedName(SERIALIZED_NAME_MESSAGE)
  

  private MessageEnum message = MessageEnum.EXPORT_IS_PROCESSING_;
  /**
  * Get message
  * @return message
  **/
  
  @javax.annotation.Nonnull
  
  @ApiModelProperty(required = true, value = "")
  
  public MessageEnum getMessage() {
      return message;
  }
  
  

  public static final String SERIALIZED_NAME_EXPORT_ID = "exportId";

  @SerializedName(SERIALIZED_NAME_EXPORT_ID)
  

  private String exportId;
  /**
  * Get exportId
  * @return exportId
  **/
  
  @javax.annotation.Nonnull
  
  @ApiModelProperty(required = true, value = "")
  
  public String getExportId() {
      return exportId;
  }
  
  


  /*
  public UploadCreateExport message(MessageEnum message) {
    
    this.message = message;
    return this;
  }
  */


  public void setMessage(MessageEnum message) {
    this.message = message;
  }



  /*
  public UploadCreateExport exportId(String exportId) {
    
    this.exportId = exportId;
    return this;
  }
  */


  public void setExportId(String exportId) {
    this.exportId = exportId;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UploadCreateExport uploadCreateExport = (UploadCreateExport) o;
    return Objects.equals(this.message, uploadCreateExport.message) &&
        Objects.equals(this.exportId, uploadCreateExport.exportId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(message, exportId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    exportId: ").append(toIndentedString(exportId)).append("\n");
    sb.append("}");
    return sb.toString();
  }

    public Map<String, Object> toMap() {
      Map<String, Object> localMap = new HashMap<String, Object>();
      localMap.put("message", message);
      localMap.put("exportId", exportId);
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


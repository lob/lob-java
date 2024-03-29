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
 * Bulk error properties
 */
@ApiModel(description = "Bulk error properties")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class BulkErrorProperties {
  public static final String SERIALIZED_NAME_MESSAGE = "message";

  @SerializedName(SERIALIZED_NAME_MESSAGE)
  

  private String message;
  /**
  * A human-readable message with more details about the error
  * @return message
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "A human-readable message with more details about the error")
  
  public String getMessage() {
      return message;
  }
  
  

  /**
   * A conventional HTTP status code.
   */
  @JsonAdapter(StatusCodeEnum.Adapter.class)
  public enum StatusCodeEnum {
    NUMBER_401(401),
    
    NUMBER_403(403),
    
    NUMBER_404(404),
    
    NUMBER_413(413),
    
    NUMBER_422(422),
    
    NUMBER_429(429),
    
    NUMBER_500(500);

    private Integer value;

    StatusCodeEnum(Integer value) {
      this.value = value;
    }

    public Integer getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static StatusCodeEnum fromValue(Integer value) {
      for (StatusCodeEnum b : StatusCodeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<StatusCodeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final StatusCodeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public StatusCodeEnum read(final JsonReader jsonReader) throws IOException {
        Integer value =  jsonReader.nextInt();
        return StatusCodeEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_STATUS_CODE = "status_code";

  @SerializedName(SERIALIZED_NAME_STATUS_CODE)
  

  private StatusCodeEnum statusCode;
  /**
  * A conventional HTTP status code.
  * @return statusCode
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "A conventional HTTP status code.")
  
  public StatusCodeEnum getStatusCode() {
      return statusCode;
  }
  
  


  /*
  public BulkErrorProperties message(String message) {
    
    this.message = message;
    return this;
  }
  */


  public void setMessage(String message) {
    this.message = message;
  }



  /*
  public BulkErrorProperties statusCode(StatusCodeEnum statusCode) {
    
    this.statusCode = statusCode;
    return this;
  }
  */


  public void setStatusCode(StatusCodeEnum statusCode) {
    this.statusCode = statusCode;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BulkErrorProperties bulkErrorProperties = (BulkErrorProperties) o;
    return Objects.equals(this.message, bulkErrorProperties.message) &&
        Objects.equals(this.statusCode, bulkErrorProperties.statusCode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(message, statusCode);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    statusCode: ").append(toIndentedString(statusCode)).append("\n");
    sb.append("}");
    return sb.toString();
  }

    public Map<String, Object> toMap() {
      Map<String, Object> localMap = new HashMap<String, Object>();
      localMap.put("message", message);
      localMap.put("status_code", statusCode);
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


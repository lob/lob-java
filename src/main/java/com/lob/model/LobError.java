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
 * Lob uses RESTful HTTP response codes to indicate success or failure of an API request.
 */
@ApiModel(description = "Lob uses RESTful HTTP response codes to indicate success or failure of an API request.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class LobError {
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
  
  

  /**
   * A pre-defined string identifying an error.
   */
  @JsonAdapter(CodeEnum.Adapter.class)
  public enum CodeEnum {
    BAD_REQUEST("bad_request"),
    
    CONFLICT("conflict"),
    
    FEATURE_LIMIT_REACHED("feature_limit_reached"),
    
    INTERNAL_SERVER_ERROR("internal_server_error"),
    
    INVALID("invalid"),
    
    NOT_DELETABLE("not_deletable"),
    
    NOT_FOUND("not_found"),
    
    REQUEST_TIMEOUT("request_timeout"),
    
    SERVICE_UNAVAILABLE("service_unavailable"),
    
    UNRECOGNIZED_ENDPOINT("unrecognized_endpoint"),
    
    UNSUPPORTED_LOB_VERSION("unsupported_lob_version"),
    
    ADDRESS_LENGTH_EXCEEDS_LIMIT("address_length_exceeds_limit"),
    
    BANK_ACCOUNT_ALREADY_VERIFIED("bank_account_already_verified"),
    
    BANK_ERROR("bank_error"),
    
    CUSTOM_ENVELOPE_INVENTORY_DEPLETED("custom_envelope_inventory_depleted"),
    
    DELETED_BANK_ACCOUNT("deleted_bank_account"),
    
    FAILED_DELIVERABILITY_STRICTNESS("failed_deliverability_strictness"),
    
    FILE_PAGES_BELOW_MIN("file_pages_below_min"),
    
    FILE_PAGES_EXCEED_MAX("file_pages_exceed_max"),
    
    FILE_SIZE_EXCEEDS_LIMIT("file_size_exceeds_limit"),
    
    FOREIGN_RETURN_ADDRESS("foreign_return_address"),
    
    INCONSISTENT_PAGE_DIMENSIONS("inconsistent_page_dimensions"),
    
    INVALID_BANK_ACCOUNT("invalid_bank_account"),
    
    INVALID_BANK_ACCOUNT_VERIFICATION("invalid_bank_account_verification"),
    
    INVALID_CHECK_INTERNATIONAL("invalid_check_international"),
    
    INVALID_COUNTRY_COVID("invalid_country_covid"),
    
    INVALID_FILE("invalid_file"),
    
    INVALID_FILE_DIMENSIONS("invalid_file_dimensions"),
    
    INVALID_FILE_DOWNLOAD_TIME("invalid_file_download_time"),
    
    INVALID_FILE_URL("invalid_file_url"),
    
    INVALID_IMAGE_DPI("invalid_image_dpi"),
    
    INVALID_INTERNATIONAL_FEATURE("invalid_international_feature"),
    
    INVALID_PERFORATION_RETURN_ENVELOPE("invalid_perforation_return_envelope"),
    
    INVALID_TEMPLATE_HTML("invalid_template_html"),
    
    MERGE_VARIABLE_REQUIRED("merge_variable_required"),
    
    MERGE_VARIABLE_WHITESPACE("merge_variable_whitespace"),
    
    PAYMENT_METHOD_UNVERIFIED("payment_method_unverified"),
    
    PDF_ENCRYPTED("pdf_encrypted"),
    
    SPECIAL_CHARACTERS_RESTRICTED("special_characters_restricted"),
    
    UNEMBEDDED_FONTS("unembedded_fonts"),
    
    EMAIL_REQUIRED("email_required"),
    
    INVALID_API_KEY("invalid_api_key"),
    
    PUBLISHABLE_KEY_NOT_ALLOWED("publishable_key_not_allowed"),
    
    RATE_LIMIT_EXCEEDED("rate_limit_exceeded"),
    
    UNAUTHORIZED("unauthorized"),
    
    UNAUTHORIZED_TOKEN("unauthorized_token"),
    
    CARD_QUANTITY_BELOW_MIN("card_quantity_below_min");

    private String value;

    CodeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static CodeEnum fromValue(String value) {
      for (CodeEnum b : CodeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<CodeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final CodeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public CodeEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return CodeEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_CODE = "code";

  @SerializedName(SERIALIZED_NAME_CODE)
  

  private CodeEnum code;
  /**
  * A pre-defined string identifying an error.
  * @return code
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "A pre-defined string identifying an error.")
  
  public CodeEnum getCode() {
      return code;
  }
  
  


  /*
  public LobError message(String message) {
    
    this.message = message;
    return this;
  }
  */


  public void setMessage(String message) {
    this.message = message;
  }



  /*
  public LobError statusCode(StatusCodeEnum statusCode) {
    
    this.statusCode = statusCode;
    return this;
  }
  */


  public void setStatusCode(StatusCodeEnum statusCode) {
    this.statusCode = statusCode;
  }



  /*
  public LobError code(CodeEnum code) {
    
    this.code = code;
    return this;
  }
  */


  public void setCode(CodeEnum code) {
    this.code = code;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LobError lobError = (LobError) o;
    return Objects.equals(this.message, lobError.message) &&
        Objects.equals(this.statusCode, lobError.statusCode) &&
        Objects.equals(this.code, lobError.code);
  }

  @Override
  public int hashCode() {
    return Objects.hash(message, statusCode, code);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    statusCode: ").append(toIndentedString(statusCode)).append("\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("}");
    return sb.toString();
  }

    public Map<String, Object> toMap() {
      Map<String, Object> localMap = new HashMap<String, Object>();
      localMap.put("message", message);
      localMap.put("status_code", statusCode);
      localMap.put("code", code);
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


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
import com.lob.model.IntlComponents;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import org.openapitools.jackson.nullable.JsonNullable;

import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;
/**
 * IntlVerification
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class IntlVerification {
  public static final String SERIALIZED_NAME_ID = "id";

  @SerializedName(SERIALIZED_NAME_ID)
  

  private String id;
  /**
  * Unique identifier prefixed with `intl_ver_`.
  * @return id
  **/
  
  @javax.annotation.Nullable
  
  public String getId() { return id; }

  public void setId (String id) throws IllegalArgumentException {
    if(!id.matches("^intl_ver_[a-zA-Z0-9]+$")) {
      throw new IllegalArgumentException("Invalid id provided");
    }

    this.id = id;
  }
  
  

  public static final String SERIALIZED_NAME_RECIPIENT = "recipient";

  @SerializedName(SERIALIZED_NAME_RECIPIENT)
  

  private String recipient;
  /**
  * The intended recipient, typically a person's or firm's name.
  * @return recipient
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "The intended recipient, typically a person's or firm's name.")
  
  public String getRecipient() {
      return recipient;
  }
  
  

  public static final String SERIALIZED_NAME_PRIMARY_LINE = "primary_line";

  @SerializedName(SERIALIZED_NAME_PRIMARY_LINE)
  

  private String primaryLine;
  /**
  * The primary delivery line (usually the street address) of the address. 
  * @return primaryLine
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "The primary delivery line (usually the street address) of the address. ")
  
  public String getPrimaryLine() {
      return primaryLine;
  }
  
  

  public static final String SERIALIZED_NAME_SECONDARY_LINE = "secondary_line";

  @SerializedName(SERIALIZED_NAME_SECONDARY_LINE)
  

  private String secondaryLine;
  /**
  * The secondary delivery line of the address. This field is typically empty but may contain information if `primary_line` is too long. 
  * @return secondaryLine
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "The secondary delivery line of the address. This field is typically empty but may contain information if `primary_line` is too long. ")
  
  public String getSecondaryLine() {
      return secondaryLine;
  }
  
  

  public static final String SERIALIZED_NAME_LAST_LINE = "last_line";

  @SerializedName(SERIALIZED_NAME_LAST_LINE)
  

  private String lastLine;
  /**
  * Combination of the following applicable `components`: * `city` * `state` * `zip_code` * `zip_code_plus_4` 
  * @return lastLine
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "Combination of the following applicable `components`: * `city` * `state` * `zip_code` * `zip_code_plus_4` ")
  
  public String getLastLine() {
      return lastLine;
  }
  
  

  public static final String SERIALIZED_NAME_COUNTRY = "country";

  @SerializedName(SERIALIZED_NAME_COUNTRY)
  

  private String country;
  /**
  * The country of the address. Will be returned as a 2 letter country short-name code (ISO 3166).
  * @return country
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "The country of the address. Will be returned as a 2 letter country short-name code (ISO 3166).")
  
  public String getCountry() {
      return country;
  }
  
  

  /**
   * The coverage level for the country. This represents the maximum level of accuracy an input address can be verified to.  * &#x60;SUBBUILDING&#x60; - Coverage down to unit numbers. For example, in an apartment or a large building * &#x60;HOUSENUMBER/BUILDING&#x60; - Coverage down to house number. For example, the address where a house or building may be located * &#x60;STREET&#x60; - Coverage down to street. This means that we can verify that an street exists in a city, state, country * &#x60;LOCALITY&#x60; - Coverage down to city, state, or village or province. This means that we can verify that a city, village, province, or state exists in a country. Countries differ in how they define what is a province, state, city, village, etc. This attempts to group eveyrthing together. * &#x60;SPARSE&#x60; - Some addresses for this country exist in our databases 
   */
  @JsonAdapter(CoverageEnum.Adapter.class)
  public enum CoverageEnum {
    SUBBUILDING("SUBBUILDING"),
    
    HOUSENUMBER_BUILDING("HOUSENUMBER/BUILDING"),
    
    STREET("STREET"),
    
    LOCALITY("LOCALITY"),
    
    SPARSE("SPARSE");

    private String value;

    CoverageEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static CoverageEnum fromValue(String value) {
      for (CoverageEnum b : CoverageEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<CoverageEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final CoverageEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public CoverageEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return CoverageEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_COVERAGE = "coverage";

  @SerializedName(SERIALIZED_NAME_COVERAGE)
  

  private CoverageEnum coverage;
  /**
  * The coverage level for the country. This represents the maximum level of accuracy an input address can be verified to.  * `SUBBUILDING` - Coverage down to unit numbers. For example, in an apartment or a large building * `HOUSENUMBER/BUILDING` - Coverage down to house number. For example, the address where a house or building may be located * `STREET` - Coverage down to street. This means that we can verify that an street exists in a city, state, country * `LOCALITY` - Coverage down to city, state, or village or province. This means that we can verify that a city, village, province, or state exists in a country. Countries differ in how they define what is a province, state, city, village, etc. This attempts to group eveyrthing together. * `SPARSE` - Some addresses for this country exist in our databases 
  * @return coverage
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "The coverage level for the country. This represents the maximum level of accuracy an input address can be verified to.  * `SUBBUILDING` - Coverage down to unit numbers. For example, in an apartment or a large building * `HOUSENUMBER/BUILDING` - Coverage down to house number. For example, the address where a house or building may be located * `STREET` - Coverage down to street. This means that we can verify that an street exists in a city, state, country * `LOCALITY` - Coverage down to city, state, or village or province. This means that we can verify that a city, village, province, or state exists in a country. Countries differ in how they define what is a province, state, city, village, etc. This attempts to group eveyrthing together. * `SPARSE` - Some addresses for this country exist in our databases ")
  
  public CoverageEnum getCoverage() {
      return coverage;
  }
  
  

  /**
   * Summarizes the deliverability of the &#x60;intl_verification&#x60; object. Possible values are: * &#x60;deliverable&#x60; — The address is deliverable. * &#x60;deliverable_missing_info&#x60; — The address is missing some information, but is most likely deliverable. * &#x60;undeliverable&#x60; — The address is most likely not deliverable. Some components of the address (such as city or postal code) may have been found. * &#x60;no_match&#x60; — This address is not deliverable. No matching street could be found within the city or postal code. 
   */
  @JsonAdapter(DeliverabilityEnum.Adapter.class)
  public enum DeliverabilityEnum {
    DELIVERABLE("deliverable"),
    
    DELIVERABLE_MISSING_INFO("deliverable_missing_info"),
    
    UNDELIVERABLE("undeliverable"),
    
    NO_MATCH("no_match");

    private String value;

    DeliverabilityEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static DeliverabilityEnum fromValue(String value) {
      for (DeliverabilityEnum b : DeliverabilityEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<DeliverabilityEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final DeliverabilityEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public DeliverabilityEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return DeliverabilityEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_DELIVERABILITY = "deliverability";

  @SerializedName(SERIALIZED_NAME_DELIVERABILITY)
  

  private DeliverabilityEnum deliverability;
  /**
  * Summarizes the deliverability of the `intl_verification` object. Possible values are: * `deliverable` — The address is deliverable. * `deliverable_missing_info` — The address is missing some information, but is most likely deliverable. * `undeliverable` — The address is most likely not deliverable. Some components of the address (such as city or postal code) may have been found. * `no_match` — This address is not deliverable. No matching street could be found within the city or postal code. 
  * @return deliverability
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "Summarizes the deliverability of the `intl_verification` object. Possible values are: * `deliverable` — The address is deliverable. * `deliverable_missing_info` — The address is missing some information, but is most likely deliverable. * `undeliverable` — The address is most likely not deliverable. Some components of the address (such as city or postal code) may have been found. * `no_match` — This address is not deliverable. No matching street could be found within the city or postal code. ")
  
  public DeliverabilityEnum getDeliverability() {
      return deliverability;
  }
  
  

  /**
   * The status level for the country. This represents the maximum level of accuracy an input address can be verified to.  * &#x60;LV4&#x60; - Verified. The input data is correct. All input data was able to match in databases. * &#x60;LV3&#x60; - Verified. The input data is correct. All input data was able to match in databases &lt;em&gt;after&lt;/em&gt; some or all elements were standarized. The input data may also be using outdated city, state, or country names. * &#x60;LV2&#x60; - Verified. The input data is correct although some input data is unverifiable due to incomplete data. * &#x60;LV1&#x60; - Verified. The input data is acceptable but in an attempt to standarize user input, errors were introduced. * &#x60;LF4&#x60; - Fixed. The input data is matched and fixed. (Example: Brighon, UK -&gt; Brighton, UK) * &#x60;LF3&#x60; - Fixed. The input data is matched and fixed but some elements such as Subbuilding number and house number cannot be checked. * &#x60;LF2&#x60; - Fixed. The input data is matched but some elements such as Street cannot be checked. * &#x60;LF1&#x60; - Fixed. The input data is acceptable but in an attempt to standarize user input, errors were introduced. * &#x60;LM4&#x60; - Missing Info. The input data cannot be corrected completely. * &#x60;LM3&#x60; - Missing Info. The input data cannot be corrected completely and there were multiple matches found in databases. * &#x60;LM2&#x60; - Missing Info. The input data cannot be corrected completely and only some elements were found. * &#x60;LU1&#x60; - Unverified. The input data cannot be corrected or matched. 
   */
  @JsonAdapter(StatusEnum.Adapter.class)
  public enum StatusEnum {
    LV4("LV4"),
    
    LV3("LV3"),
    
    LV2("LV2"),
    
    LV1("LV1"),
    
    LF4("LF4"),
    
    LF3("LF3"),
    
    LF2("LF2"),
    
    LF1("LF1"),
    
    LM4("LM4"),
    
    LM3("LM3"),
    
    LM2("LM2"),
    
    LU1("LU1");

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
  * The status level for the country. This represents the maximum level of accuracy an input address can be verified to.  * `LV4` - Verified. The input data is correct. All input data was able to match in databases. * `LV3` - Verified. The input data is correct. All input data was able to match in databases <em>after</em> some or all elements were standarized. The input data may also be using outdated city, state, or country names. * `LV2` - Verified. The input data is correct although some input data is unverifiable due to incomplete data. * `LV1` - Verified. The input data is acceptable but in an attempt to standarize user input, errors were introduced. * `LF4` - Fixed. The input data is matched and fixed. (Example: Brighon, UK -> Brighton, UK) * `LF3` - Fixed. The input data is matched and fixed but some elements such as Subbuilding number and house number cannot be checked. * `LF2` - Fixed. The input data is matched but some elements such as Street cannot be checked. * `LF1` - Fixed. The input data is acceptable but in an attempt to standarize user input, errors were introduced. * `LM4` - Missing Info. The input data cannot be corrected completely. * `LM3` - Missing Info. The input data cannot be corrected completely and there were multiple matches found in databases. * `LM2` - Missing Info. The input data cannot be corrected completely and only some elements were found. * `LU1` - Unverified. The input data cannot be corrected or matched. 
  * @return status
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "The status level for the country. This represents the maximum level of accuracy an input address can be verified to.  * `LV4` - Verified. The input data is correct. All input data was able to match in databases. * `LV3` - Verified. The input data is correct. All input data was able to match in databases <em>after</em> some or all elements were standarized. The input data may also be using outdated city, state, or country names. * `LV2` - Verified. The input data is correct although some input data is unverifiable due to incomplete data. * `LV1` - Verified. The input data is acceptable but in an attempt to standarize user input, errors were introduced. * `LF4` - Fixed. The input data is matched and fixed. (Example: Brighon, UK -> Brighton, UK) * `LF3` - Fixed. The input data is matched and fixed but some elements such as Subbuilding number and house number cannot be checked. * `LF2` - Fixed. The input data is matched but some elements such as Street cannot be checked. * `LF1` - Fixed. The input data is acceptable but in an attempt to standarize user input, errors were introduced. * `LM4` - Missing Info. The input data cannot be corrected completely. * `LM3` - Missing Info. The input data cannot be corrected completely and there were multiple matches found in databases. * `LM2` - Missing Info. The input data cannot be corrected completely and only some elements were found. * `LU1` - Unverified. The input data cannot be corrected or matched. ")
  
  public StatusEnum getStatus() {
      return status;
  }
  
  

  public static final String SERIALIZED_NAME_COMPONENTS = "components";

  @SerializedName(SERIALIZED_NAME_COMPONENTS)
  

  private IntlComponents components;
  /**
  * Get components
  * @return components
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "")
  
  public IntlComponents getComponents() {
      return components;
  }
  
  

  /**
   * Value is resource type.
   */
  @JsonAdapter(ObjectEnum.Adapter.class)
  public enum ObjectEnum {
    INTL_VERIFICATION("intl_verification");

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
  

  private ObjectEnum _object = ObjectEnum.INTL_VERIFICATION;
  /**
  * Value is resource type.
  * @return _object
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "Value is resource type.")
  
  public ObjectEnum getObject() {
      return _object;
  }
  
  


  /*
  public IntlVerification id(String id) {
    
    this.id = id;
    return this;
  }
  */





  /*
  public IntlVerification recipient(String recipient) {
    
    this.recipient = recipient;
    return this;
  }
  */


  public void setRecipient(String recipient) {
    this.recipient = recipient;
  }



  /*
  public IntlVerification primaryLine(String primaryLine) {
    
    this.primaryLine = primaryLine;
    return this;
  }
  */


  public void setPrimaryLine(String primaryLine) {
    this.primaryLine = primaryLine;
  }



  /*
  public IntlVerification secondaryLine(String secondaryLine) {
    
    this.secondaryLine = secondaryLine;
    return this;
  }
  */


  public void setSecondaryLine(String secondaryLine) {
    this.secondaryLine = secondaryLine;
  }



  /*
  public IntlVerification lastLine(String lastLine) {
    
    this.lastLine = lastLine;
    return this;
  }
  */


  public void setLastLine(String lastLine) {
    this.lastLine = lastLine;
  }



  /*
  public IntlVerification country(String country) {
    
    this.country = country;
    return this;
  }
  */


  public void setCountry(String country) {
    this.country = country;
  }



  /*
  public IntlVerification coverage(CoverageEnum coverage) {
    
    this.coverage = coverage;
    return this;
  }
  */


  public void setCoverage(CoverageEnum coverage) {
    this.coverage = coverage;
  }



  /*
  public IntlVerification deliverability(DeliverabilityEnum deliverability) {
    
    this.deliverability = deliverability;
    return this;
  }
  */


  public void setDeliverability(DeliverabilityEnum deliverability) {
    this.deliverability = deliverability;
  }



  /*
  public IntlVerification status(StatusEnum status) {
    
    this.status = status;
    return this;
  }
  */


  public void setStatus(StatusEnum status) {
    this.status = status;
  }



  /*
  public IntlVerification components(IntlComponents components) {
    
    this.components = components;
    return this;
  }
  */


  public void setComponents(IntlComponents components) {
    this.components = components;
  }



  /*
  public IntlVerification _object(ObjectEnum _object) {
    
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
    IntlVerification intlVerification = (IntlVerification) o;
    return Objects.equals(this.id, intlVerification.id) &&
        Objects.equals(this.recipient, intlVerification.recipient) &&
        Objects.equals(this.primaryLine, intlVerification.primaryLine) &&
        Objects.equals(this.secondaryLine, intlVerification.secondaryLine) &&
        Objects.equals(this.lastLine, intlVerification.lastLine) &&
        Objects.equals(this.country, intlVerification.country) &&
        Objects.equals(this.coverage, intlVerification.coverage) &&
        Objects.equals(this.deliverability, intlVerification.deliverability) &&
        Objects.equals(this.status, intlVerification.status) &&
        Objects.equals(this.components, intlVerification.components) &&
        Objects.equals(this._object, intlVerification._object);
  }

  private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
    return a == b || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, recipient, primaryLine, secondaryLine, lastLine, country, coverage, deliverability, status, components, _object);
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
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    recipient: ").append(toIndentedString(recipient)).append("\n");
    sb.append("    primaryLine: ").append(toIndentedString(primaryLine)).append("\n");
    sb.append("    secondaryLine: ").append(toIndentedString(secondaryLine)).append("\n");
    sb.append("    lastLine: ").append(toIndentedString(lastLine)).append("\n");
    sb.append("    country: ").append(toIndentedString(country)).append("\n");
    sb.append("    coverage: ").append(toIndentedString(coverage)).append("\n");
    sb.append("    deliverability: ").append(toIndentedString(deliverability)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    components: ").append(toIndentedString(components)).append("\n");
    sb.append("    _object: ").append(toIndentedString(_object)).append("\n");
    sb.append("}");
    return sb.toString();
  }

    public Map<String, Object> toMap() {
      Map<String, Object> localMap = new HashMap<String, Object>();
      localMap.put("id", id);
      localMap.put("recipient", recipient);
      localMap.put("primary_line", primaryLine);
      localMap.put("secondary_line", secondaryLine);
      localMap.put("last_line", lastLine);
      localMap.put("country", country);
      localMap.put("coverage", coverage);
      localMap.put("deliverability", deliverability);
      localMap.put("status", status);
      localMap.put("components", components);
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


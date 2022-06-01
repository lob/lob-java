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
import com.lob.model.CountryExtended;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

import com.google.gson.Gson;
/**
 * IntlSuggestions
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class IntlSuggestions {
  public static final String SERIALIZED_NAME_PRIMARY_NUMBER_RANGE = "primary_number_range";

  @SerializedName(SERIALIZED_NAME_PRIMARY_NUMBER_RANGE)
  

  private String primaryNumberRange;
  /**
  * The primary number range of the address that identifies a building at street level. 
  * @return primaryNumberRange
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "The primary number range of the address that identifies a building at street level. ")
  
  public String getPrimaryNumberRange() {
      return primaryNumberRange;
  }
  
  

  public static final String SERIALIZED_NAME_PRIMARY_LINE = "primary_line";

  @SerializedName(SERIALIZED_NAME_PRIMARY_LINE)
  

  private String primaryLine;
  /**
  * The primary delivery line (usually the street address) of the address. Combination of the following applicable `components` (primary number & secondary information may be missing or inaccurate): * `primary_number` * `street_predirection` * `street_name` * `street_suffix` * `street_postdirection` * `secondary_designator` * `secondary_number` * `pmb_designator` * `pmb_number` 
  * @return primaryLine
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "The primary delivery line (usually the street address) of the address. Combination of the following applicable `components` (primary number & secondary information may be missing or inaccurate): * `primary_number` * `street_predirection` * `street_name` * `street_suffix` * `street_postdirection` * `secondary_designator` * `secondary_number` * `pmb_designator` * `pmb_number` ")
  
  public String getPrimaryLine() {
      return primaryLine;
  }
  
  

  public static final String SERIALIZED_NAME_CITY = "city";

  @SerializedName(SERIALIZED_NAME_CITY)
  

  private String city;
  /**
  * Get city
  * @return city
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "")
  
  public String getCity() {
      return city;
  }
  
  

  public static final String SERIALIZED_NAME_STATE = "state";

  @SerializedName(SERIALIZED_NAME_STATE)
  

  private String state;
  /**
  * The [ISO 3166-2](https://en.wikipedia.org/wiki/ISO_3166-2) two letter code for the state. 
  * @return state
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "The [ISO 3166-2](https://en.wikipedia.org/wiki/ISO_3166-2) two letter code for the state. ")
  
  public String getState() {
      return state;
  }
  
  

  public static final String SERIALIZED_NAME_COUNTRY = "country";

  @SerializedName(SERIALIZED_NAME_COUNTRY)
  

  private CountryExtended country;
  /**
  * Get country
  * @return country
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "")
  
  public CountryExtended getCountry() {
      return country;
  }
  
  

  public static final String SERIALIZED_NAME_ZIP_CODE = "zip_code";

  @SerializedName(SERIALIZED_NAME_ZIP_CODE)
  

  private String zipCode;
  /**
  * A 5-digit zip code. Left empty if a test key is used.
  * @return zipCode
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "A 5-digit zip code. Left empty if a test key is used.")
  
  public String getZipCode() {
      return zipCode;
  }
  
  

  /**
   * Value is resource type.
   */
  @JsonAdapter(ObjectEnum.Adapter.class)
  public enum ObjectEnum {
    INTL_AUTOCOMPLETION("intl_autocompletion");

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
  

  private ObjectEnum _object = ObjectEnum.INTL_AUTOCOMPLETION;
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
  public IntlSuggestions primaryNumberRange(String primaryNumberRange) {
    
    this.primaryNumberRange = primaryNumberRange;
    return this;
  }
  */


  public void setPrimaryNumberRange(String primaryNumberRange) {
    this.primaryNumberRange = primaryNumberRange;
  }



  /*
  public IntlSuggestions primaryLine(String primaryLine) {
    
    this.primaryLine = primaryLine;
    return this;
  }
  */


  public void setPrimaryLine(String primaryLine) {
    this.primaryLine = primaryLine;
  }



  /*
  public IntlSuggestions city(String city) {
    
    this.city = city;
    return this;
  }
  */


  public void setCity(String city) {
    this.city = city;
  }



  /*
  public IntlSuggestions state(String state) {
    
    this.state = state;
    return this;
  }
  */


  public void setState(String state) {
    this.state = state;
  }



  /*
  public IntlSuggestions country(CountryExtended country) {
    
    this.country = country;
    return this;
  }
  */


  public void setCountry(CountryExtended country) {
    this.country = country;
  }



  /*
  public IntlSuggestions zipCode(String zipCode) {
    
    this.zipCode = zipCode;
    return this;
  }
  */


  public void setZipCode(String zipCode) {
    this.zipCode = zipCode;
  }



  /*
  public IntlSuggestions _object(ObjectEnum _object) {
    
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
    IntlSuggestions intlSuggestions = (IntlSuggestions) o;
    return Objects.equals(this.primaryNumberRange, intlSuggestions.primaryNumberRange) &&
        Objects.equals(this.primaryLine, intlSuggestions.primaryLine) &&
        Objects.equals(this.city, intlSuggestions.city) &&
        Objects.equals(this.state, intlSuggestions.state) &&
        Objects.equals(this.country, intlSuggestions.country) &&
        Objects.equals(this.zipCode, intlSuggestions.zipCode) &&
        Objects.equals(this._object, intlSuggestions._object);
  }

  @Override
  public int hashCode() {
    return Objects.hash(primaryNumberRange, primaryLine, city, state, country, zipCode, _object);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{\n");
    sb.append("    primaryNumberRange: ").append(toIndentedString(primaryNumberRange)).append("\n");
    sb.append("    primaryLine: ").append(toIndentedString(primaryLine)).append("\n");
    sb.append("    city: ").append(toIndentedString(city)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    country: ").append(toIndentedString(country)).append("\n");
    sb.append("    zipCode: ").append(toIndentedString(zipCode)).append("\n");
    sb.append("    _object: ").append(toIndentedString(_object)).append("\n");
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

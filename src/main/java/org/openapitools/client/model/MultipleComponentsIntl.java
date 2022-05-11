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


package org.openapitools.client.model;

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
import org.openapitools.client.model.CountryExtended;
import org.openapitools.jackson.nullable.JsonNullable;

/**
 * MultipleComponentsIntl
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class MultipleComponentsIntl {
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
  * The name of the state.
  * @return state
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "The name of the state.")
  
  public String getState() {
      return state;
  }
  
  

  public static final String SERIALIZED_NAME_POSTAL_CODE = "postal_code";

  @SerializedName(SERIALIZED_NAME_POSTAL_CODE)
  

  private String postalCode;
  /**
  * The postal code.
  * @return postalCode
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "The postal code.")
  
  public String getPostalCode() {
      return postalCode;
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
  
  


  /*
  public MultipleComponentsIntl recipient(String recipient) {
    
    this.recipient = recipient;
    return this;
  }
  */


  public void setRecipient(String recipient) {
    this.recipient = recipient;
  }



  /*
  public MultipleComponentsIntl primaryLine(String primaryLine) {
    
    this.primaryLine = primaryLine;
    return this;
  }
  */


  public void setPrimaryLine(String primaryLine) {
    this.primaryLine = primaryLine;
  }



  /*
  public MultipleComponentsIntl secondaryLine(String secondaryLine) {
    
    this.secondaryLine = secondaryLine;
    return this;
  }
  */


  public void setSecondaryLine(String secondaryLine) {
    this.secondaryLine = secondaryLine;
  }



  /*
  public MultipleComponentsIntl city(String city) {
    
    this.city = city;
    return this;
  }
  */


  public void setCity(String city) {
    this.city = city;
  }



  /*
  public MultipleComponentsIntl state(String state) {
    
    this.state = state;
    return this;
  }
  */


  public void setState(String state) {
    this.state = state;
  }



  /*
  public MultipleComponentsIntl postalCode(String postalCode) {
    
    this.postalCode = postalCode;
    return this;
  }
  */


  public void setPostalCode(String postalCode) {
    this.postalCode = postalCode;
  }



  /*
  public MultipleComponentsIntl country(CountryExtended country) {
    
    this.country = country;
    return this;
  }
  */


  public void setCountry(CountryExtended country) {
    this.country = country;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MultipleComponentsIntl multipleComponentsIntl = (MultipleComponentsIntl) o;
    return Objects.equals(this.recipient, multipleComponentsIntl.recipient) &&
        Objects.equals(this.primaryLine, multipleComponentsIntl.primaryLine) &&
        Objects.equals(this.secondaryLine, multipleComponentsIntl.secondaryLine) &&
        Objects.equals(this.city, multipleComponentsIntl.city) &&
        Objects.equals(this.state, multipleComponentsIntl.state) &&
        Objects.equals(this.postalCode, multipleComponentsIntl.postalCode) &&
        Objects.equals(this.country, multipleComponentsIntl.country);
  }

  private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
    return a == b || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(recipient, primaryLine, secondaryLine, city, state, postalCode, country);
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
    sb.append("    recipient: ").append(toIndentedString(recipient)).append("\n");
    sb.append("    primaryLine: ").append(toIndentedString(primaryLine)).append("\n");
    sb.append("    secondaryLine: ").append(toIndentedString(secondaryLine)).append("\n");
    sb.append("    city: ").append(toIndentedString(city)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    postalCode: ").append(toIndentedString(postalCode)).append("\n");
    sb.append("    country: ").append(toIndentedString(country)).append("\n");
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


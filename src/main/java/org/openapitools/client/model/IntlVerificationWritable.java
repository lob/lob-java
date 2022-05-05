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
 * IntlVerificationWritable
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class IntlVerificationWritable {
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
  
  

  public static final String SERIALIZED_NAME_ADDRESS = "address";

  @SerializedName(SERIALIZED_NAME_ADDRESS)
  

  private String address;

  /**
  * The entire address in one string (e.g., \"370 Water St C1N 1C4\"). 
  * @return address
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "The entire address in one string (e.g., \"370 Water St C1N 1C4\"). ")
  
  public String getAddress() {
      return address;
  }
  
  


  /*
  public IntlVerificationWritable recipient(String recipient) {
    
    this.recipient = recipient;
    return this;
  }
  */


  public void setRecipient(String recipient) {
    this.recipient = recipient;
  }



  /*
  public IntlVerificationWritable primaryLine(String primaryLine) {
    
    this.primaryLine = primaryLine;
    return this;
  }
  */


  public void setPrimaryLine(String primaryLine) {
    this.primaryLine = primaryLine;
  }



  /*
  public IntlVerificationWritable secondaryLine(String secondaryLine) {
    
    this.secondaryLine = secondaryLine;
    return this;
  }
  */


  public void setSecondaryLine(String secondaryLine) {
    this.secondaryLine = secondaryLine;
  }



  /*
  public IntlVerificationWritable city(String city) {
    
    this.city = city;
    return this;
  }
  */


  public void setCity(String city) {
    this.city = city;
  }



  /*
  public IntlVerificationWritable state(String state) {
    
    this.state = state;
    return this;
  }
  */


  public void setState(String state) {
    this.state = state;
  }



  /*
  public IntlVerificationWritable postalCode(String postalCode) {
    
    this.postalCode = postalCode;
    return this;
  }
  */


  public void setPostalCode(String postalCode) {
    this.postalCode = postalCode;
  }



  /*
  public IntlVerificationWritable country(CountryExtended country) {
    
    this.country = country;
    return this;
  }
  */


  public void setCountry(CountryExtended country) {
    this.country = country;
  }



  /*
  public IntlVerificationWritable address(String address) {
    
    this.address = address;
    return this;
  }
  */


  public void setAddress(String address) {
    this.address = address;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IntlVerificationWritable intlVerificationWritable = (IntlVerificationWritable) o;
    return Objects.equals(this.recipient, intlVerificationWritable.recipient) &&
        Objects.equals(this.primaryLine, intlVerificationWritable.primaryLine) &&
        Objects.equals(this.secondaryLine, intlVerificationWritable.secondaryLine) &&
        Objects.equals(this.city, intlVerificationWritable.city) &&
        Objects.equals(this.state, intlVerificationWritable.state) &&
        Objects.equals(this.postalCode, intlVerificationWritable.postalCode) &&
        Objects.equals(this.country, intlVerificationWritable.country) &&
        Objects.equals(this.address, intlVerificationWritable.address);
  }

  private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
    return a == b || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(recipient, primaryLine, secondaryLine, city, state, postalCode, country, address);
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
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
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


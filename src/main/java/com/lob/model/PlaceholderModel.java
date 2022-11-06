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
import com.lob.model.AddressDomestic;
// import com.lob.model.LetterDetailsReturned;
import com.lob.model.LetterDetailsWritable;
import com.lob.model.PostcardDetailsReturned;
import com.lob.model.PostcardDetailsWritable;
import com.lob.model.ReturnEnvelope;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

import com.google.gson.Gson;
/**
 * PlaceholderModel
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class PlaceholderModel {
  public static final String SERIALIZED_NAME_RETURN_ENVELOPE = "return_envelope";

  @SerializedName(SERIALIZED_NAME_RETURN_ENVELOPE)
  

  private ReturnEnvelope returnEnvelope;
  /**
  * Get returnEnvelope
  * @return returnEnvelope
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "")
  
  public ReturnEnvelope getReturnEnvelope() {
      return returnEnvelope;
  }
  
  

  public static final String SERIALIZED_NAME_ADDRESS_DOMESTIC = "address_domestic";

  @SerializedName(SERIALIZED_NAME_ADDRESS_DOMESTIC)
  

  private AddressDomestic addressDomestic;
  /**
  * Get addressDomestic
  * @return addressDomestic
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "")
  
  public AddressDomestic getAddressDomestic() {
      return addressDomestic;
  }
  
  

  public static final String SERIALIZED_NAME_LETTER_DETAILS_WRITABLE = "letter_details_writable";

  @SerializedName(SERIALIZED_NAME_LETTER_DETAILS_WRITABLE)
  

  private LetterDetailsWritable letterDetailsWritable;
  /**
  * Get letterDetailsWritable
  * @return letterDetailsWritable
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "")
  
  public LetterDetailsWritable getLetterDetailsWritable() {
      return letterDetailsWritable;
  }
  
  

  public static final String SERIALIZED_NAME_POSTCARD_DETAILS_WRITABLE = "postcard_details_writable";

  @SerializedName(SERIALIZED_NAME_POSTCARD_DETAILS_WRITABLE)
  

  private PostcardDetailsWritable postcardDetailsWritable;
  /**
  * Get postcardDetailsWritable
  * @return postcardDetailsWritable
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "")
  
  public PostcardDetailsWritable getPostcardDetailsWritable() {
      return postcardDetailsWritable;
  }
  
  

  public static final String SERIALIZED_NAME_LETTER_DETAILS_RETURNED = "letter_details_returned";

  @SerializedName(SERIALIZED_NAME_LETTER_DETAILS_RETURNED)
  

  // private LetterDetailsReturned letterDetailsReturned;
  // /**
  // * Get letterDetailsReturned
  // * @return letterDetailsReturned
  // **/
  
  // @javax.annotation.Nullable
  
  // @ApiModelProperty(value = "")
  
  // public LetterDetailsReturned getLetterDetailsReturned() {
  //     return letterDetailsReturned;
  // }
  
  

  public static final String SERIALIZED_NAME_POSTCARD_DETAILS_RETURNED = "postcard_details_returned";

  @SerializedName(SERIALIZED_NAME_POSTCARD_DETAILS_RETURNED)
  

  private PostcardDetailsReturned postcardDetailsReturned;
  /**
  * Get postcardDetailsReturned
  * @return postcardDetailsReturned
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "")
  
  public PostcardDetailsReturned getPostcardDetailsReturned() {
      return postcardDetailsReturned;
  }
  
  


  /*
  public PlaceholderModel returnEnvelope(ReturnEnvelope returnEnvelope) {
    
    this.returnEnvelope = returnEnvelope;
    return this;
  }
  */


  public void setReturnEnvelope(ReturnEnvelope returnEnvelope) {
    this.returnEnvelope = returnEnvelope;
  }



  /*
  public PlaceholderModel addressDomestic(AddressDomestic addressDomestic) {
    
    this.addressDomestic = addressDomestic;
    return this;
  }
  */


  public void setAddressDomestic(AddressDomestic addressDomestic) {
    this.addressDomestic = addressDomestic;
  }



  /*
  public PlaceholderModel letterDetailsWritable(LetterDetailsWritable letterDetailsWritable) {
    
    this.letterDetailsWritable = letterDetailsWritable;
    return this;
  }
  */


  public void setLetterDetailsWritable(LetterDetailsWritable letterDetailsWritable) {
    this.letterDetailsWritable = letterDetailsWritable;
  }



  /*
  public PlaceholderModel postcardDetailsWritable(PostcardDetailsWritable postcardDetailsWritable) {
    
    this.postcardDetailsWritable = postcardDetailsWritable;
    return this;
  }
  */


  public void setPostcardDetailsWritable(PostcardDetailsWritable postcardDetailsWritable) {
    this.postcardDetailsWritable = postcardDetailsWritable;
  }



  /*
  public PlaceholderModel letterDetailsReturned(LetterDetailsReturned letterDetailsReturned) {
    
    this.letterDetailsReturned = letterDetailsReturned;
    return this;
  }
  */


  // public void setLetterDetailsReturned(LetterDetailsReturned letterDetailsReturned) {
  //   this.letterDetailsReturned = letterDetailsReturned;
  // }



  /*
  public PlaceholderModel postcardDetailsReturned(PostcardDetailsReturned postcardDetailsReturned) {
    
    this.postcardDetailsReturned = postcardDetailsReturned;
    return this;
  }
  */


  public void setPostcardDetailsReturned(PostcardDetailsReturned postcardDetailsReturned) {
    this.postcardDetailsReturned = postcardDetailsReturned;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PlaceholderModel placeholderModel = (PlaceholderModel) o;
    return Objects.equals(this.returnEnvelope, placeholderModel.returnEnvelope) &&
        Objects.equals(this.addressDomestic, placeholderModel.addressDomestic) &&
        Objects.equals(this.letterDetailsWritable, placeholderModel.letterDetailsWritable) &&
        Objects.equals(this.postcardDetailsWritable, placeholderModel.postcardDetailsWritable) &&
        // Objects.equals(this.letterDetailsReturned, placeholderModel.letterDetailsReturned) &&
        Objects.equals(this.postcardDetailsReturned, placeholderModel.postcardDetailsReturned);
  }

  @Override
  public int hashCode() {
    return Objects.hash(returnEnvelope, addressDomestic, letterDetailsWritable, postcardDetailsWritable, postcardDetailsReturned);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{\n");
    sb.append("    returnEnvelope: ").append(toIndentedString(returnEnvelope)).append("\n");
    sb.append("    addressDomestic: ").append(toIndentedString(addressDomestic)).append("\n");
    sb.append("    letterDetailsWritable: ").append(toIndentedString(letterDetailsWritable)).append("\n");
    sb.append("    postcardDetailsWritable: ").append(toIndentedString(postcardDetailsWritable)).append("\n");
    sb.append("    postcardDetailsReturned: ").append(toIndentedString(postcardDetailsReturned)).append("\n");
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


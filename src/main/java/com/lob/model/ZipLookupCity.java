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
 * ZipLookupCity
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class ZipLookupCity {
  public static final String SERIALIZED_NAME_CITY = "city";

  @SerializedName(SERIALIZED_NAME_CITY)
  

  private String city;
  /**
  * Get city
  * @return city
  **/
  
  @javax.annotation.Nonnull
  
  @ApiModelProperty(required = true, value = "")
  
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
  
  @javax.annotation.Nonnull
  
  @ApiModelProperty(required = true, value = "The [ISO 3166-2](https://en.wikipedia.org/wiki/ISO_3166-2) two letter code for the state. ")
  
  public String getState() {
      return state;
  }
  
  

  public static final String SERIALIZED_NAME_COUNTY = "county";

  @SerializedName(SERIALIZED_NAME_COUNTY)
  

  private String county;
  /**
  * County name of the address city.
  * @return county
  **/
  
  @javax.annotation.Nonnull
  
  @ApiModelProperty(required = true, value = "County name of the address city.")
  
  public String getCounty() {
      return county;
  }
  
  

  public static final String SERIALIZED_NAME_COUNTY_FIPS = "county_fips";

  @SerializedName(SERIALIZED_NAME_COUNTY_FIPS)
  

  private String countyFips;
  /**
  * A 5-digit [FIPS county code](https://en.wikipedia.org/wiki/FIPS_county_code) which uniquely identifies `components[county]`. It consists of a 2-digit state code and a 3-digit county code. 
  * @return countyFips
  **/
  
  @javax.annotation.Nonnull
  
  @ApiModelProperty(required = true, value = "A 5-digit [FIPS county code](https://en.wikipedia.org/wiki/FIPS_county_code) which uniquely identifies `components[county]`. It consists of a 2-digit state code and a 3-digit county code. ")
  
  public String getCountyFips() {
      return countyFips;
  }
  
  

  public static final String SERIALIZED_NAME_PREFERRED = "preferred";

  @SerializedName(SERIALIZED_NAME_PREFERRED)
  

  private Boolean preferred;
  /**
  * Indicates whether or not the city is the [USPS default city](https://en.wikipedia.org/wiki/ZIP_Code#ZIP_Codes_and_previous_zoning_lines) (preferred city) of a ZIP code. There is only one preferred city per ZIP code, which will always be in position 0 in the array of cities. 
  * @return preferred
  **/
  
  @javax.annotation.Nonnull
  
  @ApiModelProperty(required = true, value = "Indicates whether or not the city is the [USPS default city](https://en.wikipedia.org/wiki/ZIP_Code#ZIP_Codes_and_previous_zoning_lines) (preferred city) of a ZIP code. There is only one preferred city per ZIP code, which will always be in position 0 in the array of cities. ")
  
  public Boolean getPreferred() {
      return preferred;
  }
  
  


  /*
  public ZipLookupCity city(String city) {
    
    this.city = city;
    return this;
  }
  */


  public void setCity(String city) {
    this.city = city;
  }



  /*
  public ZipLookupCity state(String state) {
    
    this.state = state;
    return this;
  }
  */


  public void setState(String state) {
    this.state = state;
  }



  /*
  public ZipLookupCity county(String county) {
    
    this.county = county;
    return this;
  }
  */


  public void setCounty(String county) {
    this.county = county;
  }



  /*
  public ZipLookupCity countyFips(String countyFips) {
    
    this.countyFips = countyFips;
    return this;
  }
  */


  public void setCountyFips(String countyFips) {
    this.countyFips = countyFips;
  }



  /*
  public ZipLookupCity preferred(Boolean preferred) {
    
    this.preferred = preferred;
    return this;
  }
  */


  public void setPreferred(Boolean preferred) {
    this.preferred = preferred;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ZipLookupCity zipLookupCity = (ZipLookupCity) o;
    return Objects.equals(this.city, zipLookupCity.city) &&
        Objects.equals(this.state, zipLookupCity.state) &&
        Objects.equals(this.county, zipLookupCity.county) &&
        Objects.equals(this.countyFips, zipLookupCity.countyFips) &&
        Objects.equals(this.preferred, zipLookupCity.preferred);
  }

  @Override
  public int hashCode() {
    return Objects.hash(city, state, county, countyFips, preferred);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{\n");
    sb.append("    city: ").append(toIndentedString(city)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    county: ").append(toIndentedString(county)).append("\n");
    sb.append("    countyFips: ").append(toIndentedString(countyFips)).append("\n");
    sb.append("    preferred: ").append(toIndentedString(preferred)).append("\n");
    sb.append("}");
    return sb.toString();
  }

    public Map<String, Object> toMap() {
      Map<String, Object> localMap = new HashMap<String, Object>();
      localMap.put("city", city);
      localMap.put("state", state);
      localMap.put("county", county);
      localMap.put("county_fips", countyFips);
      localMap.put("preferred", preferred);
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


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
import com.lob.model.GeocodeComponents;
import com.lob.model.LocationAnalysis;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;
/**
 * GeocodeAddresses
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class GeocodeAddresses {
  public static final String SERIALIZED_NAME_COMPONENTS = "components";

  @SerializedName(SERIALIZED_NAME_COMPONENTS)
  

  private GeocodeComponents components;
  /**
  * Get components
  * @return components
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "")
  
  public GeocodeComponents getComponents() {
      return components;
  }
  
  

  public static final String SERIALIZED_NAME_LOCATION_ANALYSIS = "location_analysis";

  @SerializedName(SERIALIZED_NAME_LOCATION_ANALYSIS)
  

  private LocationAnalysis locationAnalysis;
  /**
  * Get locationAnalysis
  * @return locationAnalysis
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "")
  
  public LocationAnalysis getLocationAnalysis() {
      return locationAnalysis;
  }
  
  


  /*
  public GeocodeAddresses components(GeocodeComponents components) {
    
    this.components = components;
    return this;
  }
  */


  public void setComponents(GeocodeComponents components) {
    this.components = components;
  }



  /*
  public GeocodeAddresses locationAnalysis(LocationAnalysis locationAnalysis) {
    
    this.locationAnalysis = locationAnalysis;
    return this;
  }
  */


  public void setLocationAnalysis(LocationAnalysis locationAnalysis) {
    this.locationAnalysis = locationAnalysis;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GeocodeAddresses geocodeAddresses = (GeocodeAddresses) o;
    return Objects.equals(this.components, geocodeAddresses.components) &&
        Objects.equals(this.locationAnalysis, geocodeAddresses.locationAnalysis);
  }

  @Override
  public int hashCode() {
    return Objects.hash(components, locationAnalysis);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{\n");
    sb.append("    components: ").append(toIndentedString(components)).append("\n");
    sb.append("    locationAnalysis: ").append(toIndentedString(locationAnalysis)).append("\n");
    sb.append("}");
    return sb.toString();
  }

    public Map<String, Object> toMap() {
      Map<String, Object> localMap = new HashMap<String, Object>();
      localMap.put("components", components);
      localMap.put("location_analysis", locationAnalysis);
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


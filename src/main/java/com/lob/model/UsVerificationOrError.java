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
import com.lob.model.BulkError;
import com.lob.model.DeliverabilityAnalysis;
import com.lob.model.LobConfidenceScore;
import com.lob.model.UsComponents;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import org.openapitools.jackson.nullable.JsonNullable;

import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;
/**
 * A model used to represent an entry in a result list where the entry can either be a us_verification or an Error. The SDK will perform necessary casting into the correct corresponding type. 
 */
@ApiModel(description = "A model used to represent an entry in a result list where the entry can either be a us_verification or an Error. The SDK will perform necessary casting into the correct corresponding type. ")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class UsVerificationOrError {
  public static final String SERIALIZED_NAME_ID = "id";

  @SerializedName(SERIALIZED_NAME_ID)
  

  private String id;
  /**
  * Unique identifier prefixed with `us_ver_`.
  * @return id
  **/
  
  @javax.annotation.Nullable
  
  public String getId() { return id; }

  public void setId (String id) throws IllegalArgumentException {
    if(!id.matches("^us_ver_[a-zA-Z0-9_]+$")) {
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
  * The primary delivery line (usually the street address) of the address. Combination of the following applicable `components`: * `primary_number` * `street_predirection` * `street_name` * `street_suffix` * `street_postdirection` * `secondary_designator` * `secondary_number` * `pmb_designator` * `pmb_number` 
  * @return primaryLine
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "The primary delivery line (usually the street address) of the address. Combination of the following applicable `components`: * `primary_number` * `street_predirection` * `street_name` * `street_suffix` * `street_postdirection` * `secondary_designator` * `secondary_number` * `pmb_designator` * `pmb_number` ")
  
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
  
  

  public static final String SERIALIZED_NAME_URBANIZATION = "urbanization";

  @SerializedName(SERIALIZED_NAME_URBANIZATION)
  

  private String urbanization;
  /**
  * Only present for addresses in Puerto Rico. An urbanization refers to an area, sector, or development within a city. See [USPS documentation](https://pe.usps.com/text/pub28/28api_008.htm#:~:text=I51.,-4%20Urbanizations&text=In%20Puerto%20Rico%2C%20identical%20street,placed%20before%20the%20urbanization%20name.) for clarification. 
  * @return urbanization
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "Only present for addresses in Puerto Rico. An urbanization refers to an area, sector, or development within a city. See [USPS documentation](https://pe.usps.com/text/pub28/28api_008.htm#:~:text=I51.,-4%20Urbanizations&text=In%20Puerto%20Rico%2C%20identical%20street,placed%20before%20the%20urbanization%20name.) for clarification. ")
  
  public String getUrbanization() {
      return urbanization;
  }
  
  

  public static final String SERIALIZED_NAME_LAST_LINE = "last_line";

  @SerializedName(SERIALIZED_NAME_LAST_LINE)
  

  private String lastLine;
  /**
  * Get lastLine
  * @return lastLine
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "")
  
  public String getLastLine() {
      return lastLine;
  }
  
  

  /**
   * Gets or Sets deliverability
   */
  @JsonAdapter(DeliverabilityEnum.Adapter.class)
  public enum DeliverabilityEnum {
    DELIVERABLE("deliverable"),
    
    DELIVERABLE_UNNECESSARY_UNIT("deliverable_unnecessary_unit"),
    
    DELIVERABLE_INCORRECT_UNIT("deliverable_incorrect_unit"),
    
    DELIVERABLE_MISSING_UNIT("deliverable_missing_unit"),
    
    UNDELIVERABLE("undeliverable");

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
  * Get deliverability
  * @return deliverability
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "")
  
  public DeliverabilityEnum getDeliverability() {
      return deliverability;
  }
  
  

  public static final String SERIALIZED_NAME_COMPONENTS = "components";

  @SerializedName(SERIALIZED_NAME_COMPONENTS)
  

  private UsComponents components;
  /**
  * Get components
  * @return components
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "")
  
  public UsComponents getComponents() {
      return components;
  }
  
  

  public static final String SERIALIZED_NAME_DELIVERABILITY_ANALYSIS = "deliverability_analysis";

  @SerializedName(SERIALIZED_NAME_DELIVERABILITY_ANALYSIS)
  

  private DeliverabilityAnalysis deliverabilityAnalysis;
  /**
  * Get deliverabilityAnalysis
  * @return deliverabilityAnalysis
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "")
  
  public DeliverabilityAnalysis getDeliverabilityAnalysis() {
      return deliverabilityAnalysis;
  }
  
  

  public static final String SERIALIZED_NAME_LOB_CONFIDENCE_SCORE = "lob_confidence_score";

  @SerializedName(SERIALIZED_NAME_LOB_CONFIDENCE_SCORE)
  

  private LobConfidenceScore lobConfidenceScore;
  /**
  * Get lobConfidenceScore
  * @return lobConfidenceScore
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "")
  
  public LobConfidenceScore getLobConfidenceScore() {
      return lobConfidenceScore;
  }
  
  

  /**
   * Gets or Sets _object
   */
  @JsonAdapter(ObjectEnum.Adapter.class)
  public enum ObjectEnum {
    US_VERIFICATION("us_verification");

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
  

  private ObjectEnum _object = ObjectEnum.US_VERIFICATION;
  /**
  * Get _object
  * @return _object
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "")
  
  public ObjectEnum getObject() {
      return _object;
  }
  
  

  public static final String SERIALIZED_NAME_TRANSIENT_ID = "transient_id";

  @SerializedName(SERIALIZED_NAME_TRANSIENT_ID)
  

  private String transientId;
  /**
  * ID that is returned in the response body for the verification 
  * @return transientId
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "ID that is returned in the response body for the verification ")
  
  public String getTransientId() {
      return transientId;
  }
  
  

  public static final String SERIALIZED_NAME_ERROR = "error";

  @SerializedName(SERIALIZED_NAME_ERROR)
  

  private BulkError error;
  /**
  * Get error
  * @return error
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "")
  
  public BulkError getError() {
      return error;
  }
  
  


  /*
  public UsVerificationOrError id(String id) {
    
    this.id = id;
    return this;
  }
  */





  /*
  public UsVerificationOrError recipient(String recipient) {
    
    this.recipient = recipient;
    return this;
  }
  */


  public void setRecipient(String recipient) {
    this.recipient = recipient;
  }



  /*
  public UsVerificationOrError primaryLine(String primaryLine) {
    
    this.primaryLine = primaryLine;
    return this;
  }
  */


  public void setPrimaryLine(String primaryLine) {
    this.primaryLine = primaryLine;
  }



  /*
  public UsVerificationOrError secondaryLine(String secondaryLine) {
    
    this.secondaryLine = secondaryLine;
    return this;
  }
  */


  public void setSecondaryLine(String secondaryLine) {
    this.secondaryLine = secondaryLine;
  }



  /*
  public UsVerificationOrError urbanization(String urbanization) {
    
    this.urbanization = urbanization;
    return this;
  }
  */


  public void setUrbanization(String urbanization) {
    this.urbanization = urbanization;
  }



  /*
  public UsVerificationOrError lastLine(String lastLine) {
    
    this.lastLine = lastLine;
    return this;
  }
  */


  public void setLastLine(String lastLine) {
    this.lastLine = lastLine;
  }



  /*
  public UsVerificationOrError deliverability(DeliverabilityEnum deliverability) {
    
    this.deliverability = deliverability;
    return this;
  }
  */


  public void setDeliverability(DeliverabilityEnum deliverability) {
    this.deliverability = deliverability;
  }



  /*
  public UsVerificationOrError components(UsComponents components) {
    
    this.components = components;
    return this;
  }
  */


  public void setComponents(UsComponents components) {
    this.components = components;
  }



  /*
  public UsVerificationOrError deliverabilityAnalysis(DeliverabilityAnalysis deliverabilityAnalysis) {
    
    this.deliverabilityAnalysis = deliverabilityAnalysis;
    return this;
  }
  */


  public void setDeliverabilityAnalysis(DeliverabilityAnalysis deliverabilityAnalysis) {
    this.deliverabilityAnalysis = deliverabilityAnalysis;
  }



  /*
  public UsVerificationOrError lobConfidenceScore(LobConfidenceScore lobConfidenceScore) {
    
    this.lobConfidenceScore = lobConfidenceScore;
    return this;
  }
  */


  public void setLobConfidenceScore(LobConfidenceScore lobConfidenceScore) {
    this.lobConfidenceScore = lobConfidenceScore;
  }



  /*
  public UsVerificationOrError _object(ObjectEnum _object) {
    
    this._object = _object;
    return this;
  }
  */


  public void setObject(ObjectEnum _object) {
    this._object = _object;
  }



  /*
  public UsVerificationOrError transientId(String transientId) {
    
    this.transientId = transientId;
    return this;
  }
  */


  public void setTransientId(String transientId) {
    this.transientId = transientId;
  }



  /*
  public UsVerificationOrError error(BulkError error) {
    
    this.error = error;
    return this;
  }
  */


  public void setError(BulkError error) {
    this.error = error;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UsVerificationOrError usVerificationOrError = (UsVerificationOrError) o;
    return Objects.equals(this.id, usVerificationOrError.id) &&
        Objects.equals(this.recipient, usVerificationOrError.recipient) &&
        Objects.equals(this.primaryLine, usVerificationOrError.primaryLine) &&
        Objects.equals(this.secondaryLine, usVerificationOrError.secondaryLine) &&
        Objects.equals(this.urbanization, usVerificationOrError.urbanization) &&
        Objects.equals(this.lastLine, usVerificationOrError.lastLine) &&
        Objects.equals(this.deliverability, usVerificationOrError.deliverability) &&
        Objects.equals(this.components, usVerificationOrError.components) &&
        Objects.equals(this.deliverabilityAnalysis, usVerificationOrError.deliverabilityAnalysis) &&
        Objects.equals(this.lobConfidenceScore, usVerificationOrError.lobConfidenceScore) &&
        Objects.equals(this._object, usVerificationOrError._object) &&
        Objects.equals(this.transientId, usVerificationOrError.transientId) &&
        Objects.equals(this.error, usVerificationOrError.error);
  }

  private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
    return a == b || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, recipient, primaryLine, secondaryLine, urbanization, lastLine, deliverability, components, deliverabilityAnalysis, lobConfidenceScore, _object, transientId, error);
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
    sb.append("    urbanization: ").append(toIndentedString(urbanization)).append("\n");
    sb.append("    lastLine: ").append(toIndentedString(lastLine)).append("\n");
    sb.append("    deliverability: ").append(toIndentedString(deliverability)).append("\n");
    sb.append("    components: ").append(toIndentedString(components)).append("\n");
    sb.append("    deliverabilityAnalysis: ").append(toIndentedString(deliverabilityAnalysis)).append("\n");
    sb.append("    lobConfidenceScore: ").append(toIndentedString(lobConfidenceScore)).append("\n");
    sb.append("    _object: ").append(toIndentedString(_object)).append("\n");
    sb.append("    transientId: ").append(toIndentedString(transientId)).append("\n");
    sb.append("    error: ").append(toIndentedString(error)).append("\n");
    sb.append("}");
    return sb.toString();
  }

    public Map<String, Object> toMap() {
      Map<String, Object> localMap = new HashMap<String, Object>();
      localMap.put("id", id);
      localMap.put("recipient", recipient);
      localMap.put("primary_line", primaryLine);
      localMap.put("secondary_line", secondaryLine);
      localMap.put("urbanization", urbanization);
      localMap.put("last_line", lastLine);
      localMap.put("deliverability", deliverability);
      localMap.put("components", components);
      localMap.put("deliverability_analysis", deliverabilityAnalysis);
      localMap.put("lob_confidence_score", lobConfidenceScore);
      localMap.put("object", _object);
      localMap.put("transient_id", transientId);
      localMap.put("error", error);
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


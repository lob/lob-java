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

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import org.openapitools.jackson.nullable.JsonNullable;
import org.threeten.bp.OffsetDateTime;

import io.swagger.annotations.ApiModelProperty;

/**
 * Card
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class Card {
  public static final String SERIALIZED_NAME_ID = "id";

  @SerializedName(SERIALIZED_NAME_ID)
  

  private String id;
  /**
  * Unique identifier prefixed with `card_`.
  * @return id
  **/
  
  @javax.annotation.Nullable
  
  public String getId() { return id; }

  public void setId (String id) throws IllegalArgumentException {
    if(!id.matches("^card_[a-zA-Z0-9]+$")) {
      throw new IllegalArgumentException("Invalid id provided");
    }

    this.id = id;
  }
  
  

  public static final String SERIALIZED_NAME_URL = "url";

  @SerializedName(SERIALIZED_NAME_URL)
  

  private URI url;
  /**
  * The signed link for the card.
  * @return url
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "The signed link for the card.")
  
  public URI getUrl() {
      return url;
  }
  
  

  public static final String SERIALIZED_NAME_AUTO_REORDER = "auto_reorder";

  @SerializedName(SERIALIZED_NAME_AUTO_REORDER)
  

  private Boolean autoReorder = false;
  /**
  * True if the cards should be auto-reordered.
  * @return autoReorder
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "True if the cards should be auto-reordered.")
  
  public Boolean getAutoReorder() {
      return autoReorder;
  }
  
  

  public static final String SERIALIZED_NAME_REORDER_QUANTITY = "reorder_quantity";

  @SerializedName(SERIALIZED_NAME_REORDER_QUANTITY)
  

  private Integer reorderQuantity;
  /**
  * The number of cards to be reordered.
  * @return reorderQuantity
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "The number of cards to be reordered.")
  
  public Integer getReorderQuantity() {
      return reorderQuantity;
  }
  
  

  public static final String SERIALIZED_NAME_RAW_URL = "raw_url";

  @SerializedName(SERIALIZED_NAME_RAW_URL)
  

  private URI rawUrl;
  /**
  * The raw URL of the card.
  * @return rawUrl
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "The raw URL of the card.")
  
  public URI getRawUrl() {
      return rawUrl;
  }
  
  

  public static final String SERIALIZED_NAME_FRONT_ORIGINAL_URL = "front_original_url";

  @SerializedName(SERIALIZED_NAME_FRONT_ORIGINAL_URL)
  

  private URI frontOriginalUrl;
  /**
  * The original URL of the front template.
  * @return frontOriginalUrl
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "The original URL of the front template.")
  
  public URI getFrontOriginalUrl() {
      return frontOriginalUrl;
  }
  
  

  public static final String SERIALIZED_NAME_BACK_ORIGINAL_URL = "back_original_url";

  @SerializedName(SERIALIZED_NAME_BACK_ORIGINAL_URL)
  

  private URI backOriginalUrl;
  /**
  * The original URL of the back template.
  * @return backOriginalUrl
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "The original URL of the back template.")
  
  public URI getBackOriginalUrl() {
      return backOriginalUrl;
  }
  
  

  public static final String SERIALIZED_NAME_THUMBNAILS = "thumbnails";

  @SerializedName(SERIALIZED_NAME_THUMBNAILS)
  private List<Thumbnail> thumbnails = null;
  public List<Thumbnail> getThumbnails() {     
    if (this.thumbnails == null) {
      this.thumbnails = new ArrayList<Thumbnail>();
    }
    return this.thumbnails; 
  }

  public static final String SERIALIZED_NAME_AVAILABLE_QUANTITY = "available_quantity";

  @SerializedName(SERIALIZED_NAME_AVAILABLE_QUANTITY)
  

  private Integer availableQuantity = 0;
  /**
  * The available quantity of cards.
  * @return availableQuantity
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "The available quantity of cards.")
  
  public Integer getAvailableQuantity() {
      return availableQuantity;
  }
  
  

  public static final String SERIALIZED_NAME_PENDING_QUANTITY = "pending_quantity";

  @SerializedName(SERIALIZED_NAME_PENDING_QUANTITY)
  

  private Integer pendingQuantity = 0;
  /**
  * The pending quantity of cards.
  * @return pendingQuantity
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "The pending quantity of cards.")
  
  public Integer getPendingQuantity() {
      return pendingQuantity;
  }
  
  

  /**
   * Gets or Sets status
   */
  @JsonAdapter(StatusEnum.Adapter.class)
  public enum StatusEnum {
    PROCESSED("processed"),
    
    RENDERED("rendered");

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
  * Get status
  * @return status
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "")
  
  public StatusEnum getStatus() {
      return status;
  }
  
  

  /**
   * The orientation of the card.
   */
  @JsonAdapter(OrientationEnum.Adapter.class)
  public enum OrientationEnum {
    HORIZONTAL("horizontal"),
    
    VERTICAL("vertical");

    private String value;

    OrientationEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static OrientationEnum fromValue(String value) {
      for (OrientationEnum b : OrientationEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<OrientationEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final OrientationEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public OrientationEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return OrientationEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_ORIENTATION = "orientation";

  @SerializedName(SERIALIZED_NAME_ORIENTATION)
  

  private OrientationEnum orientation = OrientationEnum.HORIZONTAL;
  /**
  * The orientation of the card.
  * @return orientation
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "The orientation of the card.")
  
  public OrientationEnum getOrientation() {
      return orientation;
  }
  
  

  public static final String SERIALIZED_NAME_THRESHOLD_AMOUNT = "threshold_amount";

  @SerializedName(SERIALIZED_NAME_THRESHOLD_AMOUNT)
  

  private Integer thresholdAmount = 0;
  /**
  * The threshold amount of the card
  * @return thresholdAmount
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "The threshold amount of the card")
  
  public Integer getThresholdAmount() {
      return thresholdAmount;
  }
  
  

  public static final String SERIALIZED_NAME_DATE_CREATED = "date_created";

  @SerializedName(SERIALIZED_NAME_DATE_CREATED)
  

  private OffsetDateTime dateCreated;
  /**
  * A timestamp in ISO 8601 format of the date the resource was created.
  * @return dateCreated
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "A timestamp in ISO 8601 format of the date the resource was created.")
  
  public OffsetDateTime getDateCreated() {
      return dateCreated;
  }
  
  

  public static final String SERIALIZED_NAME_DATE_MODIFIED = "date_modified";

  @SerializedName(SERIALIZED_NAME_DATE_MODIFIED)
  

  private OffsetDateTime dateModified;
  /**
  * A timestamp in ISO 8601 format of the date the resource was last modified.
  * @return dateModified
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "A timestamp in ISO 8601 format of the date the resource was last modified.")
  
  public OffsetDateTime getDateModified() {
      return dateModified;
  }
  
  

  public static final String SERIALIZED_NAME_DELETED = "deleted";

  @SerializedName(SERIALIZED_NAME_DELETED)
  

  private Boolean deleted;
  /**
  * Only returned if the resource has been successfully deleted.
  * @return deleted
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "Only returned if the resource has been successfully deleted.")
  
  public Boolean getDeleted() {
      return deleted;
  }
  
  

  /**
   * object
   */
  @JsonAdapter(ObjectEnum.Adapter.class)
  public enum ObjectEnum {
    CARD("card");

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
  

  private ObjectEnum _object = ObjectEnum.CARD;
  /**
  * object
  * @return _object
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "object")
  
  public ObjectEnum getObject() {
      return _object;
  }
  
  

  public static final String SERIALIZED_NAME_DESCRIPTION = "description";

  @SerializedName(SERIALIZED_NAME_DESCRIPTION)
  

  private String description;
  /**
  * Description of the card.
  * @return description
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "Description of the card.")
  
  public String getDescription() {
      return description;
  }
  
  

  /**
   * The size of the card
   */
  @JsonAdapter(SizeEnum.Adapter.class)
  public enum SizeEnum {
    _3_375X2_125("3.375x2.125"),
    
    _2_125X3_375("2.125x3.375");

    private String value;

    SizeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static SizeEnum fromValue(String value) {
      for (SizeEnum b : SizeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<SizeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final SizeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public SizeEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return SizeEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_SIZE = "size";

  @SerializedName(SERIALIZED_NAME_SIZE)
  

  private SizeEnum size = SizeEnum._2_125X3_375;
  /**
  * The size of the card
  * @return size
  **/
  
  @javax.annotation.Nullable
  
  @ApiModelProperty(value = "The size of the card")
  
  public SizeEnum getSize() {
      return size;
  }
  
  


  /*
  public Card id(String id) {
    
    this.id = id;
    return this;
  }
  */





  /*
  public Card url(URI url) {
    
    this.url = url;
    return this;
  }
  */


  public void setUrl(URI url) {
    this.url = url;
  }



  /*
  public Card autoReorder(Boolean autoReorder) {
    
    this.autoReorder = autoReorder;
    return this;
  }
  */


  public void setAutoReorder(Boolean autoReorder) {
    this.autoReorder = autoReorder;
  }



  /*
  public Card reorderQuantity(Integer reorderQuantity) {
    
    this.reorderQuantity = reorderQuantity;
    return this;
  }
  */


  public void setReorderQuantity(Integer reorderQuantity) {
    this.reorderQuantity = reorderQuantity;
  }



  /*
  public Card rawUrl(URI rawUrl) {
    
    this.rawUrl = rawUrl;
    return this;
  }
  */


  public void setRawUrl(URI rawUrl) {
    this.rawUrl = rawUrl;
  }



  /*
  public Card frontOriginalUrl(URI frontOriginalUrl) {
    
    this.frontOriginalUrl = frontOriginalUrl;
    return this;
  }
  */


  public void setFrontOriginalUrl(URI frontOriginalUrl) {
    this.frontOriginalUrl = frontOriginalUrl;
  }



  /*
  public Card backOriginalUrl(URI backOriginalUrl) {
    
    this.backOriginalUrl = backOriginalUrl;
    return this;
  }
  */


  public void setBackOriginalUrl(URI backOriginalUrl) {
    this.backOriginalUrl = backOriginalUrl;
  }



  /*
  public Card thumbnails(List<Thumbnail> thumbnails) {
    
    this.thumbnails = thumbnails;
    return this;
  }
  */

  public Card addThumbnailsItem(Thumbnail thumbnailsItem) {
    if (this.thumbnails == null) {
      this.thumbnails = new ArrayList<Thumbnail>();
    }
    this.thumbnails.add(thumbnailsItem);
    return this;
  }


  public void setThumbnails(List<Thumbnail> thumbnails) {
    this.thumbnails = thumbnails;
  }



  /*
  public Card availableQuantity(Integer availableQuantity) {
    
    this.availableQuantity = availableQuantity;
    return this;
  }
  */


  public void setAvailableQuantity(Integer availableQuantity) {
    this.availableQuantity = availableQuantity;
  }



  /*
  public Card pendingQuantity(Integer pendingQuantity) {
    
    this.pendingQuantity = pendingQuantity;
    return this;
  }
  */


  public void setPendingQuantity(Integer pendingQuantity) {
    this.pendingQuantity = pendingQuantity;
  }



  /*
  public Card status(StatusEnum status) {
    
    this.status = status;
    return this;
  }
  */


  public void setStatus(StatusEnum status) {
    this.status = status;
  }



  /*
  public Card orientation(OrientationEnum orientation) {
    
    this.orientation = orientation;
    return this;
  }
  */


  public void setOrientation(OrientationEnum orientation) {
    this.orientation = orientation;
  }



  /*
  public Card thresholdAmount(Integer thresholdAmount) {
    
    this.thresholdAmount = thresholdAmount;
    return this;
  }
  */


  public void setThresholdAmount(Integer thresholdAmount) {
    this.thresholdAmount = thresholdAmount;
  }



  /*
  public Card dateCreated(OffsetDateTime dateCreated) {
    
    this.dateCreated = dateCreated;
    return this;
  }
  */


  public void setDateCreated(OffsetDateTime dateCreated) {
    this.dateCreated = dateCreated;
  }



  /*
  public Card dateModified(OffsetDateTime dateModified) {
    
    this.dateModified = dateModified;
    return this;
  }
  */


  public void setDateModified(OffsetDateTime dateModified) {
    this.dateModified = dateModified;
  }



  /*
  public Card deleted(Boolean deleted) {
    
    this.deleted = deleted;
    return this;
  }
  */


  public void setDeleted(Boolean deleted) {
    this.deleted = deleted;
  }



  /*
  public Card _object(ObjectEnum _object) {
    
    this._object = _object;
    return this;
  }
  */


  public void setObject(ObjectEnum _object) {
    this._object = _object;
  }



  /*
  public Card description(String description) {
    
    this.description = description;
    return this;
  }
  */


  public void setDescription(String description) {
    this.description = description;
  }



  /*
  public Card size(SizeEnum size) {
    
    this.size = size;
    return this;
  }
  */


  public void setSize(SizeEnum size) {
    this.size = size;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Card card = (Card) o;
    return Objects.equals(this.id, card.id) &&
        Objects.equals(this.url, card.url) &&
        Objects.equals(this.autoReorder, card.autoReorder) &&
        Objects.equals(this.reorderQuantity, card.reorderQuantity) &&
        Objects.equals(this.rawUrl, card.rawUrl) &&
        Objects.equals(this.frontOriginalUrl, card.frontOriginalUrl) &&
        Objects.equals(this.backOriginalUrl, card.backOriginalUrl) &&
        Objects.equals(this.thumbnails, card.thumbnails) &&
        Objects.equals(this.availableQuantity, card.availableQuantity) &&
        Objects.equals(this.pendingQuantity, card.pendingQuantity) &&
        Objects.equals(this.status, card.status) &&
        Objects.equals(this.orientation, card.orientation) &&
        Objects.equals(this.thresholdAmount, card.thresholdAmount) &&
        Objects.equals(this.dateCreated, card.dateCreated) &&
        Objects.equals(this.dateModified, card.dateModified) &&
        Objects.equals(this.deleted, card.deleted) &&
        Objects.equals(this._object, card._object) &&
        Objects.equals(this.description, card.description) &&
        Objects.equals(this.size, card.size);
  }

  private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
    return a == b || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, url, autoReorder, reorderQuantity, rawUrl, frontOriginalUrl, backOriginalUrl, thumbnails, availableQuantity, pendingQuantity, status, orientation, thresholdAmount, dateCreated, dateModified, deleted, _object, description, size);
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
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
    sb.append("    autoReorder: ").append(toIndentedString(autoReorder)).append("\n");
    sb.append("    reorderQuantity: ").append(toIndentedString(reorderQuantity)).append("\n");
    sb.append("    rawUrl: ").append(toIndentedString(rawUrl)).append("\n");
    sb.append("    frontOriginalUrl: ").append(toIndentedString(frontOriginalUrl)).append("\n");
    sb.append("    backOriginalUrl: ").append(toIndentedString(backOriginalUrl)).append("\n");
    sb.append("    thumbnails: ").append(toIndentedString(thumbnails)).append("\n");
    sb.append("    availableQuantity: ").append(toIndentedString(availableQuantity)).append("\n");
    sb.append("    pendingQuantity: ").append(toIndentedString(pendingQuantity)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    orientation: ").append(toIndentedString(orientation)).append("\n");
    sb.append("    thresholdAmount: ").append(toIndentedString(thresholdAmount)).append("\n");
    sb.append("    dateCreated: ").append(toIndentedString(dateCreated)).append("\n");
    sb.append("    dateModified: ").append(toIndentedString(dateModified)).append("\n");
    sb.append("    deleted: ").append(toIndentedString(deleted)).append("\n");
    sb.append("    _object: ").append(toIndentedString(_object)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    size: ").append(toIndentedString(size)).append("\n");
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




# UsComponents

A nested object containing a breakdown of each component of an address.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**primaryNumber** | **String** | The numeric or alphanumeric part of an address preceding the street name. Often the house, building, or PO Box number. | 
**streetPredirection** | [**StreetPredirectionEnum**](#StreetPredirectionEnum) | Geographic direction preceding a street name (&#x60;N&#x60;, &#x60;S&#x60;, &#x60;E&#x60;, &#x60;W&#x60;, &#x60;NE&#x60;, &#x60;SW&#x60;, &#x60;SE&#x60;, &#x60;NW&#x60;).  | 
**streetName** | **String** | The name of the street. | 
**streetSuffix** | **String** | The standard USPS abbreviation for the street suffix (&#x60;ST&#x60;, &#x60;AVE&#x60;, &#x60;BLVD&#x60;, etc).  | 
**streetPostdirection** | [**StreetPostdirectionEnum**](#StreetPostdirectionEnum) | Geographic direction following a street name (&#x60;N&#x60;, &#x60;S&#x60;, &#x60;E&#x60;, &#x60;W&#x60;, &#x60;NE&#x60;, &#x60;SW&#x60;, &#x60;SE&#x60;, &#x60;NW&#x60;).  | 
**secondaryDesignator** | **String** | The standard USPS abbreviation describing the &#x60;components[secondary_number]&#x60; (&#x60;STE&#x60;, &#x60;APT&#x60;, &#x60;BLDG&#x60;, etc).  | 
**secondaryNumber** | **String** | Number of the apartment/unit/etc.  | 
**pmbDesignator** | **String** | Designator of a [CMRA-authorized](https://en.wikipedia.org/wiki/Commercial_mail_receiving_agency) private mailbox.  | 
**pmbNumber** | **String** | Number of a [CMRA-authorized](https://en.wikipedia.org/wiki/Commercial_mail_receiving_agency) private mailbox.  | 
**extraSecondaryDesignator** | **String** | An extra (often unnecessary) secondary designator provided with the input address.  | 
**extraSecondaryNumber** | **String** | An extra (often unnecessary) secondary number provided with the input address.  | 
**city** | **String** |  | 
**state** | **String** | The [ISO 3166-2](https://en.wikipedia.org/wiki/ISO_3166-2) two letter code for the state.  | 
**zipCode** | **String** | The 5-digit ZIP code | 
**zipCodePlus4** | **String** |  | 
**zipCodeType** | **ZipCodeType** |  | 
**deliveryPointBarcode** | **String** | A 12-digit identifier that uniquely identifies a delivery point (location where mail can be sent and received). It consists of the 5-digit ZIP code (&#x60;zip_code&#x60;), 4-digit ZIP+4 add-on (&#x60;zip_code_plus_4&#x60;), 2-digit delivery point, and 1-digit delivery point check digit.  | 
**addressType** | [**AddressTypeEnum**](#AddressTypeEnum) | Uses USPS&#39;s [Residential Delivery Indicator (RDI)](https://www.usps.com/nationalpremieraccounts/rdi.htm) to identify whether an address is classified as residential or business. Possible values are: * &#x60;residential&#x60; –– The address is residential or a PO Box. * &#x60;commercial&#x60; –– The address is commercial. * &#x60;&#39;&#39;&#x60; –– Not enough information provided to be determined.  | 
**recordType** | [**RecordTypeEnum**](#RecordTypeEnum) | A description of the type of address. Populated if a DPV match is made (&#x60;deliverability_analysis[dpv_confirmation]&#x60; is &#x60;Y&#x60;, &#x60;S&#x60;, or &#x60;D&#x60;). For more detailed information about each record type, see [US Verification Details](#tag/US-Verification-Types).  | 
**defaultBuildingAddress** | **Boolean** | Designates whether or not the address is the default address for a building containing multiple delivery points.  | 
**county** | **String** | County name of the address city. | 
**countyFips** | **String** | A 5-digit [FIPS county code](https://en.wikipedia.org/wiki/FIPS_county_code) which uniquely identifies &#x60;components[county]&#x60;. It consists of a 2-digit state code and a 3-digit county code.  | 
**carrierRoute** | **String** | A 4-character code assigned to a mail delivery route within a ZIP code.  | 
**carrierRouteType** | [**CarrierRouteTypeEnum**](#CarrierRouteTypeEnum) | The type of &#x60;components[carrier_route]&#x60;. For more detailed information about each carrier route type, see [US Verification Details](#tag/US-Verification-Types).  | 
**poBoxOnlyFlag** | [**PoBoxOnlyFlagEnum**](#PoBoxOnlyFlagEnum) | Indicates the mailing facility for an address only supports PO Box deliveries and other forms of mail delivery are not available.  | 
**latitude** | **Float** | A positive or negative decimal indicating the geographic latitude of the address, specifying the north-to-south position of a location. This should be used with &#x60;longitude&#x60; to pinpoint locations on a map. Will not be returned for undeliverable addresses or military addresses (state is &#x60;AA&#x60;, &#x60;AE&#x60;, or &#x60;AP&#x60;).  |  [optional]
**longitude** | **Float** | A positive or negative decimal indicating the geographic longitude of the address, specifying the north-to-south position of a location. This should be used with &#x60;latitude&#x60; to pinpoint locations on a map. Will not be returned for undeliverable addresses or military addresses (state is &#x60;AA&#x60;, &#x60;AE&#x60;, or &#x60;AP&#x60;).  |  [optional]



## Enum: StreetPredirectionEnum

Name | Value
---- | -----
N | &quot;N&quot;
S | &quot;S&quot;
E | &quot;E&quot;
W | &quot;W&quot;
NE | &quot;NE&quot;
SW | &quot;SW&quot;
SE | &quot;SE&quot;
NW | &quot;NW&quot;
EMPTY | &quot;&quot;



## Enum: StreetPostdirectionEnum

Name | Value
---- | -----
N | &quot;N&quot;
S | &quot;S&quot;
E | &quot;E&quot;
W | &quot;W&quot;
NE | &quot;NE&quot;
SW | &quot;SW&quot;
SE | &quot;SE&quot;
NW | &quot;NW&quot;
EMPTY | &quot;&quot;



## Enum: AddressTypeEnum

Name | Value
---- | -----
RESIDENTIAL | &quot;residential&quot;
COMMERCIAL | &quot;commercial&quot;
EMPTY | &quot;&quot;



## Enum: RecordTypeEnum

Name | Value
---- | -----
STREET | &quot;street&quot;
HIGHRISE | &quot;highrise&quot;
FIRM | &quot;firm&quot;
PO_BOX | &quot;po_box&quot;
RURAL_ROUTE | &quot;rural_route&quot;
GENERAL_DELIVERY | &quot;general_delivery&quot;
EMPTY | &quot;&quot;



## Enum: CarrierRouteTypeEnum

Name | Value
---- | -----
CITY_DELIVERY | &quot;city_delivery&quot;
RURAL_ROUTE | &quot;rural_route&quot;
HIGHWAY_CONTRACT | &quot;highway_contract&quot;
PO_BOX | &quot;po_box&quot;
GENERAL_DELIVERY | &quot;general_delivery&quot;
EMPTY | &quot;&quot;



## Enum: PoBoxOnlyFlagEnum

Name | Value
---- | -----
Y | &quot;Y&quot;
N | &quot;N&quot;
EMPTY | &quot;&quot;




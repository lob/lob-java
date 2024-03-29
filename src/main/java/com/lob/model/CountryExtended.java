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
import io.swagger.annotations.ApiModel;
import com.google.gson.annotations.SerializedName;

import java.io.IOException;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

/**
 * Must be a 2 letter country short-name code (ISO 3166).
 */
@JsonAdapter(CountryExtended.Adapter.class)
public enum CountryExtended {
  
  EMPTY(""),
  
  AD("AD"),
  
  AE("AE"),
  
  AF("AF"),
  
  AG("AG"),
  
  AI("AI"),
  
  AL("AL"),
  
  AN("AN"),
  
  AO("AO"),
  
  AQ("AQ"),
  
  AR("AR"),
  
  AT("AT"),
  
  AU("AU"),
  
  AW("AW"),
  
  AZ("AZ"),
  
  BA("BA"),
  
  BB("BB"),
  
  BD("BD"),
  
  BE("BE"),
  
  BF("BF"),
  
  BG("BG"),
  
  BH("BH"),
  
  BI("BI"),
  
  BJ("BJ"),
  
  BM("BM"),
  
  BN("BN"),
  
  BO("BO"),
  
  BQ("BQ"),
  
  BR("BR"),
  
  BS("BS"),
  
  BT("BT"),
  
  BW("BW"),
  
  BY("BY"),
  
  BZ("BZ"),
  
  CA("CA"),
  
  CD("CD"),
  
  CG("CG"),
  
  CH("CH"),
  
  CI("CI"),
  
  CK("CK"),
  
  CL("CL"),
  
  CM("CM"),
  
  CN("CN"),
  
  CO("CO"),
  
  CR("CR"),
  
  CS("CS"),
  
  CU("CU"),
  
  CV("CV"),
  
  CW("CW"),
  
  CY("CY"),
  
  CZ("CZ"),
  
  DE("DE"),
  
  DJ("DJ"),
  
  DK("DK"),
  
  DM("DM"),
  
  DO("DO"),
  
  DZ("DZ"),
  
  EC("EC"),
  
  EE("EE"),
  
  EG("EG"),
  
  EH("EH"),
  
  ER("ER"),
  
  ES("ES"),
  
  ET("ET"),
  
  FI("FI"),
  
  FJ("FJ"),
  
  FK("FK"),
  
  FO("FO"),
  
  FR("FR"),
  
  GA("GA"),
  
  GB("GB"),
  
  GD("GD"),
  
  GE("GE"),
  
  GH("GH"),
  
  GI("GI"),
  
  GL("GL"),
  
  GM("GM"),
  
  GN("GN"),
  
  GQ("GQ"),
  
  GR("GR"),
  
  GS("GS"),
  
  GT("GT"),
  
  GW("GW"),
  
  GY("GY"),
  
  HK("HK"),
  
  HN("HN"),
  
  HR("HR"),
  
  HT("HT"),
  
  HU("HU"),
  
  ID("ID"),
  
  IE("IE"),
  
  IL("IL"),
  
  IN("IN"),
  
  IO("IO"),
  
  IQ("IQ"),
  
  IR("IR"),
  
  IS("IS"),
  
  IT("IT"),
  
  JM("JM"),
  
  JO("JO"),
  
  JP("JP"),
  
  KE("KE"),
  
  KG("KG"),
  
  KH("KH"),
  
  KI("KI"),
  
  KM("KM"),
  
  KN("KN"),
  
  KP("KP"),
  
  KR("KR"),
  
  KW("KW"),
  
  KY("KY"),
  
  KZ("KZ"),
  
  LA("LA"),
  
  LB("LB"),
  
  LC("LC"),
  
  LI("LI"),
  
  LK("LK"),
  
  LR("LR"),
  
  LS("LS"),
  
  LT("LT"),
  
  LU("LU"),
  
  LV("LV"),
  
  LY("LY"),
  
  MA("MA"),
  
  MC("MC"),
  
  MD("MD"),
  
  ME("ME"),
  
  MG("MG"),
  
  MK("MK"),
  
  ML("ML"),
  
  MM("MM"),
  
  MN("MN"),
  
  MO("MO"),
  
  MR("MR"),
  
  MS("MS"),
  
  MT("MT"),
  
  MU("MU"),
  
  MV("MV"),
  
  MW("MW"),
  
  MX("MX"),
  
  MY("MY"),
  
  MZ("MZ"),
  
  NA("NA"),
  
  NE("NE"),
  
  NF("NF"),
  
  NG("NG"),
  
  NI("NI"),
  
  NL("NL"),
  
  NO("NO"),
  
  NP("NP"),
  
  NR("NR"),
  
  NU("NU"),
  
  NZ("NZ"),
  
  OM("OM"),
  
  PA("PA"),
  
  PE("PE"),
  
  PG("PG"),
  
  PH("PH"),
  
  PK("PK"),
  
  PL("PL"),
  
  PN("PN"),
  
  PT("PT"),
  
  PY("PY"),
  
  QA("QA"),
  
  RO("RO"),
  
  RS("RS"),
  
  RU("RU"),
  
  RW("RW"),
  
  SA("SA"),
  
  SB("SB"),
  
  SC("SC"),
  
  SD("SD"),
  
  SE("SE"),
  
  SG("SG"),
  
  SH("SH"),
  
  SI("SI"),
  
  SK("SK"),
  
  SL("SL"),
  
  SM("SM"),
  
  SN("SN"),
  
  SO("SO"),
  
  SR("SR"),
  
  SS("SS"),
  
  ST("ST"),
  
  SV("SV"),
  
  SX("SX"),
  
  SY("SY"),
  
  SZ("SZ"),
  
  TC("TC"),
  
  TD("TD"),
  
  TG("TG"),
  
  TH("TH"),
  
  TJ("TJ"),
  
  TK("TK"),
  
  TL("TL"),
  
  TM("TM"),
  
  TN("TN"),
  
  TO("TO"),
  
  TR("TR"),
  
  TT("TT"),
  
  TV("TV"),
  
  TW("TW"),
  
  TZ("TZ"),
  
  UA("UA"),
  
  UG("UG"),
  
  US("US"),
  
  UY("UY"),
  
  UZ("UZ"),
  
  VA("VA"),
  
  VC("VC"),
  
  VE("VE"),
  
  VG("VG"),
  
  VN("VN"),
  
  VU("VU"),
  
  WS("WS"),
  
  YE("YE"),
  
  ZA("ZA"),
  
  ZM("ZM"),
  
  ZW("ZW");

  private String value;

  CountryExtended(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  public static CountryExtended fromValue(String value) {
    for (CountryExtended b : CountryExtended.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }

  public static class Adapter extends TypeAdapter<CountryExtended> {
    @Override
    public void write(final JsonWriter jsonWriter, final CountryExtended enumeration) throws IOException {
      jsonWriter.value(enumeration.getValue());
    }

    @Override
    public CountryExtended read(final JsonReader jsonReader) throws IOException {
      String value = jsonReader.nextString();
      return CountryExtended.fromValue(value);
    }
  }
}


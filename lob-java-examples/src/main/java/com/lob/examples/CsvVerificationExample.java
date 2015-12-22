package com.lob.examples;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.lob.LobApiException;
import com.lob.client.AsyncLobClient;
import com.lob.client.LobClient;
import com.lob.id.CountryCode;
import com.lob.protocol.request.VerifyAddressRequest;
import com.lob.protocol.response.VerifyAddressResponse;

public class CsvVerificationExample extends BaseExample {
    public static void main(final String[] args) throws Exception {
        final LobClient client = AsyncLobClient.createDefault(API_KEY);

        final CsvMapper mapper = new CsvMapper();

        final CsvSchema schema = mapper.schemaFor(CsvAddress.class).withHeader();
        final MappingIterator<CsvAddress> iterator = mapper.reader(CsvAddress.class).with(schema).readValues(fileFromResource("input.csv"));
        while (iterator.hasNext()) {
            final CsvAddress address = iterator.next();

            final VerifyAddressRequest addressRequest = VerifyAddressRequest.builder()
                .line1(address.address1)
                .line2(address.address2)
                .city(address.city)
                .state(address.state)
                .zip(address.postcode)
                .country(address.country)
                .build();

            try {
                final VerifyAddressResponse addressResponse = client.verifyAddress(addressRequest).get();
                printResponse("Verified Address", addressResponse);
            }
            catch (final Exception e) {
                printResponse("Failed Address", address);
            }
        }
    }

    @JsonPropertyOrder(value = {"address1", "address2", "city", "state", "postcode", "country"})
    private static class CsvAddress {
        @JsonProperty public String address1;
        @JsonProperty public String address2;
        @JsonProperty public String city;
        @JsonProperty public String state;
        @JsonProperty public String postcode;
        @JsonProperty public String country;

        @Override
        public String toString() {
            return "CsvAddress{" +
                "address1='" + address1 + '\'' +
                ", address2='" + address2 + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", postcode='" + postcode + '\'' +
                ", country='" + country + '\'' +
                '}';
        }
    }

}

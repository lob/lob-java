package com.lob.examples;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.lob.client.AsyncLobClient;
import com.lob.client.LobClient;
import com.lob.protocol.request.USVerificationRequest;
import com.lob.protocol.response.USVerificationResponse;

public class CsvUSVerificationExample extends BaseExample {
    public static void main(final String[] args) throws Exception {
        final LobClient client = AsyncLobClient.createDefault(API_KEY);

        final CsvMapper mapper = new CsvMapper();

        final CsvSchema schema = mapper.schemaFor(CsvAddress.class).withHeader();
        final MappingIterator<CsvAddress> iterator = mapper.reader(CsvAddress.class).with(schema).readValues(fileFromResource("addresses/input.csv"));
        while (iterator.hasNext()) {
            final CsvAddress address = iterator.next();

            final USVerificationRequest addressRequest = USVerificationRequest.builder()
                    .primary_line(address.primary_line)
                    .secondary_line(address.secondary_line)
                    .city(address.city)
                    .state(address.state)
                    .zipCode(address.zip_code)
                    .build();

            final USVerificationResponse addressResponse = client.verifyUSAddress(addressRequest).get();
            printResponse("Verified Address", addressResponse.getPrimaryLine());
        }

        System.exit(0);
    }

    @JsonPropertyOrder(value = {"primary_line", "secondary_line", "city", "state", "zip_code"})
    private static class CsvAddress {
        @JsonProperty public String primary_line;
        @JsonProperty public String secondary_line;
        @JsonProperty public String city;
        @JsonProperty public String state;
        @JsonProperty public String zip_code;

        @Override
        public String toString() {
            return "CsvAddress{" +
                    "primary_line='" + primary_line + '\'' +
                    ", secondary_line='" + secondary_line + '\'' +
                    ", city='" + city + '\'' +
                    ", state='" + state + '\'' +
                    ", zip_code='" + zip_code + '\'' +
                    '}';
        }
    }

}

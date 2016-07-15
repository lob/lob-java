package com.lob.examples;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.google.common.base.Charsets;
import com.google.common.io.Files;
import com.lob.ClientUtil;
import com.lob.client.AsyncLobClient;
import com.lob.client.LobClient;
import com.lob.protocol.request.AddressRequest;
import com.lob.protocol.request.PostcardRequest;
import com.lob.protocol.response.PostcardResponse;
import java.util.HashMap;
import java.util.Map;

public class CsvPostcardExample extends BaseExample {
    public static void main(final String[] args) throws Exception {
        final LobClient client = AsyncLobClient.createDefault(API_KEY);

        final String frontHTML = Files.toString(ClientUtil.fileFromResource("postcards/postcard_front.html"), Charsets.UTF_8);
        final String backHTML = Files.toString(ClientUtil.fileFromResource("postcards/postcard_back.html"), Charsets.UTF_8);


        final CsvMapper mapper = new CsvMapper();

        final CsvSchema schema = mapper.schemaFor(CsvPostcard.class).withHeader();
        final MappingIterator<CsvPostcard> iterator = mapper.reader(CsvPostcard.class).with(schema).readValues(fileFromResource("postcards/input.csv"));
        while (iterator.hasNext()) {
            final CsvPostcard postcard = iterator.next();

            final Map<String, String> data = new HashMap<String, String>();
            data.put("background_image", postcard.background_image);
            data.put("background_color", postcard.background_color);
            data.put("name", postcard.name);
            data.put("car", postcard.car);
            data.put("mileage", postcard.mileage);

            final PostcardRequest postcardRequest = PostcardRequest.builder()
                .to(
                    AddressRequest.builder()
                        .name(postcard.fullName)
                        .line1(postcard.address1)
                        .line2(postcard.address2)
                        .city(postcard.city)
                        .state(postcard.state)
                        .zip(postcard.postcode)
                        .country(postcard.country)
                        .build())
                .size("4x6")
                .front(frontHTML)
                .back(backHTML)
                .data(data)
                .build();

            try {
                final PostcardResponse postcardResponse = client.createPostcard(postcardRequest).get();
                printResponse("Postcard", postcardResponse);
            }
            catch (final Exception e) {
                printResponse("Failed Postcard", postcard);
            }
        }

        System.exit(0);
    }

    @JsonPropertyOrder(value = {"name", "background_image", "background_color", "car", "mileage", "fullName", "address1", "address2", "city", "state", "postcode", "country"})
    private static class CsvPostcard {
        @JsonProperty public String name;
        @JsonProperty public String background_image;
        @JsonProperty public String background_color;
        @JsonProperty public String car;
        @JsonProperty public String mileage;
        @JsonProperty public String fullName;
        @JsonProperty public String address1;
        @JsonProperty public String address2;
        @JsonProperty public String city;
        @JsonProperty public String state;
        @JsonProperty public String postcode;
        @JsonProperty public String country;

        @Override
        public String toString() {
            return "CsvPostcard{" +
                    "name='" + name + '\'' +
                    ", background_image='" + background_image + '\'' +
                    ", background_color='" + background_color + '\'' +
                    ", car='" + car + '\'' +
                    ", mileage='" + mileage + '\'' +
                    ", fullName='" + fullName + '\'' +
                    ", address1='" + address1 + '\'' +
                    ", address2='" + address2 + '\'' +
                    ", city='" + city + '\'' +
                    ", state='" + state + '\'' +
                    ", postcode='" + postcode + '\'' +
                    ", country='" + country + '\'' +
                    '}';
        }
    }

}

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
import com.lob.protocol.request.LetterRequest;
import com.lob.protocol.response.LetterResponse;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class CsvLetterExample extends BaseExample {
    public static void main(final String[] args) throws Exception {
        final LobClient client = AsyncLobClient.createDefault(API_KEY);

        final String letterTemplate = Files.toString(ClientUtil.fileFromResource("letters/letter_template.html"), Charsets.UTF_8);

        final AddressRequest companyAddress = AddressRequest.builder()
                .name("Deluxe Virgina Realty")
                .line1("185 Berry St.")
                .line2("Ste 6600")
                .city("San Francisco")
                .state("CA")
                .zip("94107")
                .country("US")
                .build();

        final String today = new SimpleDateFormat("MMMM d YYYY").format(new Date());

        final CsvMapper mapper = new CsvMapper();

        final CsvSchema schema = mapper.schemaFor(CsvLetter.class).withHeader();
        final MappingIterator<CsvLetter> iterator = mapper.reader(CsvLetter.class).with(schema).readValues(fileFromResource("letters/input.csv"));
        while (iterator.hasNext()) {
            final CsvLetter letter = iterator.next();

            final Map<String, String> data = new HashMap<String, String>();
            data.put("date", today);
            data.put("name", letter.name);
            data.put("amountDue", letter.amount);

            final LetterRequest letterRequest = LetterRequest.builder()
                    .to(
                            AddressRequest.builder()
                                    .name(letter.name)
                                    .line1(letter.address1)
                                    .line2(letter.address2)
                                    .city(letter.city)
                                    .state(letter.state)
                                    .zip(letter.zip)
                                    .country("US")
                                    .build())
                    .from(companyAddress)
                    .file(letterTemplate)
                    .color(true)
                    .data(data)
                    .build();

            try {
                final LetterResponse letterResponse = client.createLetter(letterRequest).get();
                printResponse("Letter", letterResponse);
            }
            catch (final Exception e) {
                printResponse("Failed Letter", letter);
            }
        }

        System.exit(0);
    }

    @JsonPropertyOrder(value = {"name", "amount", "address1", "address2", "city", "state", "zip"})
    private static class CsvLetter {
        @JsonProperty public String name;
        @JsonProperty public String amount;
        @JsonProperty public String address1;
        @JsonProperty public String address2;
        @JsonProperty public String city;
        @JsonProperty public String state;
        @JsonProperty public String zip;

        @Override
        public String toString() {
            return "CsvLetter{" +
                    "name='" + name + '\'' +
                    ", amount='" + amount + '\'' +
                    ", address1='" + address1 + '\'' +
                    ", address2='" + address2 + '\'' +
                    ", city='" + city + '\'' +
                    ", state='" + state + '\'' +
                    ", zip='" + zip + '\'' +
                    '}';
        }
    }

}

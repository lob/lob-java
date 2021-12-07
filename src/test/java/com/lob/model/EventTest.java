package com.lob.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class EventTest {

    ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());

    @Test
    public void deserializePostcardEventTest() throws Exception {
        String eventJSON = "{\"id\":\"evt_d95ff8ffd2b5cfb4\",\"body\":{\"id\":\"psc_d2d10a2e9cba991c\",\"description\":\"Test Postcard\",\"metadata\":{},\"to\":{\"id\":\"adr_8e783523dd7f0e70\",\"description\":\"Test Address\",\"name\":\"Harry Zhang\",\"address_line1\":\"123 Test St\",\"address_line2\":\"Unit 1\",\"address_city\":\"San Francisco\",\"address_state\":\"CA\",\"address_zip\":\"94107\",\"address_country\":\"United States\",\"metadata\":{},\"date_created\":\"2016-12-04T10:51:51.844Z\",\"date_modified\":\"2016-12-04T10:51:51.844Z\",\"object\":\"address\"},\"from\":{\"id\":\"adr_d2e26faf793ed422\",\"description\":\"Test Address\",\"name\":\"Harry Zhang\",\"address_line1\":\"123 Test St\",\"address_line2\":\"Unit 1\",\"address_city\":\"San Francisco\",\"address_state\":\"CA\",\"address_zip\":\"94107\",\"address_country\":\"United States\",\"metadata\":{},\"date_created\":\"2016-12-04T10:51:51.845Z\",\"date_modified\":\"2016-12-04T10:51:51.845Z\",\"object\":\"address\"},\"url\":\"https://lob-assets.com/postcards/psc_d2d10a2e9cba991c.pdf\",\"carrier\":\"USPS\",\"tracking_events\":[],\"thumbnails\":[{\"small\":\"https://lob-assets.com/postcards/psc_d2d10a2e9cba991c_thumb_small_1.png\",\"medium\":\"https://lob-assets.com/postcards/psc_d2d10a2e9cba991c_thumb_medium_1.png\",\"large\":\"https://lob-assets.com/postcards/psc_d2d10a2e9cba991c_thumb_large_1.png\"},{\"small\":\"https://lob-assets.com/postcards/psc_d2d10a2e9cba991c_thumb_small_2.png\",\"medium\":\"https://lob-assets.com/postcards/psc_d2d10a2e9cba991c_thumb_medium_2.png\",\"large\":\"https://lob-assets.com/postcards/psc_d2d10a2e9cba991c_thumb_large_2.png\"}],\"size\":\"4x6\",\"expected_delivery_date\":\"2016-12-09\",\"date_created\":\"2016-12-04T10:51:51.843Z\",\"date_modified\":\"2016-12-04T10:51:51.843Z\",\"object\":\"postcard\"},\"reference_id\":\"psc_d2d10a2e9cba991c\",\"event_type\":{\"id\":\"postcard.created\",\"enabled_for_test\":true,\"resource\":\"postcards\",\"object\":\"event_type\"},\"date_created\":\"2016-12-04T22:50:08.180Z\",\"object\":\"event\"}";

        Event event = mapper.readValue(eventJSON, Event.class);

        assertEquals("evt_d95ff8ffd2b5cfb4", event.getId());
        assertEquals(Postcard.class, event.getBody().getClass());
        assertEquals("psc_d2d10a2e9cba991c", event.getReferenceId());
        assertEquals("postcard.created", event.getEventType().getId());
        assertTrue(event.getEventType().isEnabledForTest());
        assertEquals("postcards", event.getEventType().getResource());
        assertEquals("event_type", event.getEventType().getObject());
        assertEquals("event", event.getObject());
    }

    @Test
    public void deserializeLetterEventTest() throws Exception {
        String eventJSON = "{\"event_type\": {\"resource\": \"letters\", \"enabled_for_test\": true, \"id\": \"letter.created\", \"object\": \"event_type\"}, \"reference_id\": \"ltr_1234567890\", \"date_created\": \"2019-07-17T23:13:48.303Z\", \"id\": \"evt_1234567890\", \"body\": {\"id\": \"ltr_1234567890\", \"description\": null, \"metadata\": {}, \"to\": {\"id\": \"adr_1234567890\", \"description\": null, \"name\": \"LARISSA LOBSTER\", \"company\": null, \"phone\": null, \"email\": null, \"address_line1\": \"185 BERRY ST STE 6100\", \"address_line2\": null, \"address_city\": \"SAN FRANCISCO\", \"address_state\": \"CA\", \"address_zip\": \"94107-1741\", \"address_country\": \"UNITED STATES\", \"metadata\": {}, \"date_created\": \"2019-07-17T23:13:48.058Z\", \"date_modified\": \"2019-07-17T23:13:48.058Z\", \"deleted\": true, \"object\": \"address\"}, \"from\": {\"id\": \"adr_1234567890\", \"description\": null, \"name\": \"LARRY LOBSTER\", \"company\": null, \"phone\": null, \"email\": null, \"address_line1\": \"185 BERRY ST STE 6100\", \"address_line2\": null, \"address_city\": \"SAN FRANCISCO\", \"address_state\": \"CA\", \"address_zip\": \"94107\", \"address_country\": \"UNITED STATES\", \"metadata\": {}, \"date_created\": \"2019-07-17T23:13:48.021Z\", \"date_modified\": \"2019-07-17T23:13:48.021Z\", \"deleted\": true, \"object\": \"address\"}, \"color\": true, \"double_sided\": true, \"address_placement\": \"top_first_page\", \"return_envelope\": { \"id\": \"no_9_single_window\", \"alias\": \"no_9_single_window\", \"url\": \"https://lob-assets.com/return_envelopes/no_9_single_window.pdf?version=v1&expires=1640985891&signature=bLC-atO_jkTEQQVOtu-52bz0y_mT0xH7g33i0fLs0RJThXFoU14V1XskSD_u_vBgxMUIJHNEQDhb-qySMK55Cg\", \"object\": \"return_envelope\" }, \"perforated_page\": null, \"custom_envelope\": null, \"extra_service\": null, \"mail_type\": \"usps_first_class\", \"url\": \"https://lob-assets.com/letters/ltr_1234567890.pdf\", \"merge_variables\": {}, \"template_id\": null, \"template_version_id\": null, \"carrier\": \"USPS\", \"tracking_number\": null, \"tracking_events\": [], \"thumbnails\": [{\"small\": \"https://lob-assets.com/letters/ltr_1234567890_thumb_small_1.png\", \"medium\": \"https://lob-assets.com/letters/ltr_1234567890_thumb_medium_1.png\", \"large\": \"https://lob-assets.com/letters/ltr_1234567890_thumb_large_1.png\"} ], \"expected_delivery_date\": \"2019-07-25\", \"date_created\": \"2019-07-17T23:13:48.255Z\", \"date_modified\": \"2019-07-17T23:13:48.255Z\", \"send_date\": \"2019-07-17T23:18:48.253Z\", \"object\": \"letter\"}, \"object\": \"event\"}";

        Event event = mapper.readValue(eventJSON, Event.class);

        assertEquals("evt_1234567890", event.getId());
        assertEquals(Letter.class, event.getBody().getClass());
        assertEquals("ltr_1234567890", event.getReferenceId());
        assertEquals("letter.created", event.getEventType().getId());
        assertTrue(event.getEventType().isEnabledForTest());
        assertEquals("letters", event.getEventType().getResource());
        assertEquals("event_type", event.getEventType().getObject());
        assertEquals("event", event.getObject());
    }

    @Test
    public void deserializeCheckEventTest() throws Exception {
        String eventJSON = "{\"event_type\": {\"resource\": \"checks\", \"enabled_for_test\": true, \"id\": \"check.created\", \"object\": \"event_type\"}, \"reference_id\": \"chk_1234567890\", \"date_created\": \"2019-07-09T18:46:43.697Z\", \"id\": \"evt_1234567890\", \"body\": {\"id\": \"chk_1234567890\", \"description\": null, \"metadata\": {}, \"check_number\": 10000, \"memo\": \"i am a memo\", \"amount\": 1000, \"url\": \"https://lob-assets.com/checks/chk_1234567890.pdf\", \"check_bottom_template_id\": null, \"attachment_template_id\": null, \"check_bottom_template_version_id\": null, \"attachment_template_version_id\": null, \"to\": {\"id\": \"adr_1234567890\", \"description\": null, \"name\": \"LARRY LOBSTER\", \"company\": null, \"phone\": null, \"email\": null, \"address_line1\": \"185 BERRY ST STE 6100\", \"address_line2\": null, \"address_city\": \"SAN FRANCISCO\", \"address_state\": \"CA\", \"address_zip\": \"94107-1741\", \"address_country\": \"UNITED STATES\", \"metadata\": {}, \"date_created\": \"2019-07-08T20:38:35.666Z\", \"date_modified\": \"2019-07-08T20:38:35.666Z\", \"object\": \"address\"}, \"from\": {\"id\": \"adr_1234567890\", \"description\": null, \"name\": \"LARRY LOBSTER\", \"company\": null, \"phone\": null, \"email\": null, \"address_line1\": \"185 BERRY ST STE 6100\", \"address_line2\": null, \"address_city\": \"SAN FRANCISCO\", \"address_state\": \"CA\", \"address_zip\": \"94107-1741\", \"address_country\": \"UNITED STATES\", \"metadata\": {}, \"date_created\": \"2019-07-08T20:38:35.666Z\", \"date_modified\": \"2019-07-08T20:38:35.666Z\", \"object\": \"address\"}, \"bank_account\": {\"id\": \"bank_1234567890\", \"description\": \"\", \"metadata\": {}, \"routing_number\": \"322271627\", \"account_number\": \"000123456789\", \"account_type\": \"company\", \"signatory\": \"Larry Lobster\", \"signature_url\": \"https://lob-assets.com/bank-accounts/bank_1234567890_signature.png\", \"bank_name\": \"J.P. MORGAN CHASE BANK, N.A.\", \"verified\": true, \"date_created\": \"2019-07-09T18:33:20.037Z\", \"date_modified\": \"2019-07-09T18:33:26.069Z\", \"object\": \"bank_account\"}, \"carrier\": \"USPS\", \"tracking_number\": null, \"tracking_events\": [], \"thumbnails\": [{\"small\": \"https://lob-assets.com/checks/chk_1234567890_thumb_small_1.png\", \"medium\": \"https://lob-assets.com/checks/chk_1234567890_thumb_medium_1.png\", \"large\": \"https://lob-assets.com/checks/chk_1234567890_thumb_large_1.pngQ\"}, {\"small\": \"https://lob-assets.com/checks/chk_1234567890_thumb_small_2.png\", \"medium\": \"https://lob-assets.com/checks/chk_1234567890_thumb_medium_2.png\", \"large\": \"https://lob-assets.com/checks/chk_1234567890_thumb_large_2.png\"} ], \"merge_variables\": {\"name\": \"Ami\"}, \"expected_delivery_date\": \"2019-07-17\", \"mail_type\": \"usps_first_class\", \"date_created\": \"2019-07-09T18:46:43.634Z\", \"date_modified\": \"2019-07-09T18:46:43.634Z\", \"send_date\": \"2019-07-09T19:06:43.634Z\", \"object\": \"check\"}, \"object\": \"event\"}";

        Event event = mapper.readValue(eventJSON, Event.class);

        assertEquals("evt_1234567890", event.getId());
        assertEquals(Check.class, event.getBody().getClass());
        assertEquals("chk_1234567890", event.getReferenceId());
        assertEquals("check.created", event.getEventType().getId());
        assertTrue(event.getEventType().isEnabledForTest());
        assertEquals("checks", event.getEventType().getResource());
        assertEquals("event_type", event.getEventType().getObject());
        assertEquals("event", event.getObject());
    }

    @Test
    public void deserializeAddressEventTest() throws Exception {
        String eventJSON = "{\"event_type\": {\"resource\": \"addresses\", \"enabled_for_test\": true, \"id\": \"address.created\", \"object\": \"event_type\"}, \"reference_id\": \"adr_1234567890\", \"date_created\": \"2019-07-08T20:38:35.678Z\", \"id\": \"evt_ee6b001e092a9d68\", \"body\": {\"id\": \"adr_1234567890\", \"description\": null, \"name\": \"LARRY LOBSTER\", \"company\": null, \"phone\": null, \"email\": null, \"address_line1\": \"185 BERRY ST STE 6100\", \"address_line2\": null, \"address_city\": \"SAN FRANCISCO\", \"address_state\": \"CA\", \"address_zip\": \"94107-1741\", \"address_country\": \"UNITED STATES\", \"metadata\": {}, \"date_created\": \"2019-07-08T20:38:35.666Z\", \"date_modified\": \"2019-07-08T20:38:35.666Z\", \"object\": \"address\"}, \"object\": \"event\"}";

        Event event = mapper.readValue(eventJSON, Event.class);

        assertEquals("evt_ee6b001e092a9d68", event.getId());
        assertEquals(Address.class, event.getBody().getClass());
        assertEquals("adr_1234567890", event.getReferenceId());
        assertEquals("address.created", event.getEventType().getId());
        assertTrue(event.getEventType().isEnabledForTest());
        assertEquals("addresses", event.getEventType().getResource());
        assertEquals("event_type", event.getEventType().getObject());
    }

    @Test
    public void deserializeBankAccountEventTest() throws Exception {
        String eventJSON = "{\"event_type\": {\"resource\": \"bank accounts\", \"enabled_for_test\": true, \"id\": \"bank_account.created\", \"object\": \"event_type\"}, \"reference_id\": \"bank_1234567890\", \"date_created\": \"2019-07-09T18:33:20.060Z\", \"id\": \"evt_1234567890\", \"body\": {\"id\": \"bank_1234567890\", \"description\": \"Larry Lobsters's Bank Account\", \"metadata\": {}, \"routing_number\": \"322271627\", \"account_number\": \"000123456789\", \"account_type\": \"company\", \"signatory\": \"Ami Wang\", \"signature_url\": \"https://lob-assets.com/bank-accounts/bank_1234567890_signature.png\", \"bank_name\": \"J.P. MORGAN CHASE BANK, N.A.\", \"verified\": false, \"date_created\": \"2019-07-09T18:33:20.037Z\", \"date_modified\": \"2019-07-09T18:33:20.037Z\", \"object\": \"bank_account\"}, \"object\": \"event\"}";

        Event event = mapper.readValue(eventJSON, Event.class);

        assertEquals("evt_1234567890", event.getId());
        assertEquals(BankAccount.class, event.getBody().getClass());
        assertEquals("bank_1234567890", event.getReferenceId());
        assertEquals("bank_account.created", event.getEventType().getId());
        assertTrue(event.getEventType().isEnabledForTest());
        assertEquals("bank accounts", event.getEventType().getResource());
        assertEquals("event_type", event.getEventType().getObject());
    }

}

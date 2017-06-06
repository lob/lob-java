package com.lob.client.test;

import com.lob.protocol.request.USVerificationRequest;
import com.lob.protocol.response.USVerificationResponse;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class USVerificationTest extends BaseTest {

    @Test
    public void testUSVerification() throws Exception {

        final USVerificationRequest request = USVerificationRequest.builder()
                .primary_line("185 BERRY ST")
                .secondary_line("STE 6600")
                .city("SAN FRANCISCO")
                .state("CA")
                .zipCode("94107")
                .build();

        USVerificationResponse response = client.verifyUSAddress(request).get();
        assertThat(response.getPrimaryLine(), is("185 BERRY ST STE 6600"));
        assertThat(response.getDeliverability(), is("deliverable"));
        assertThat(response.getComponents().getPrimaryNumber(), is("185"));
        assertThat(response.getDeliverabilityAnalysis().getDpvConfirmation(), is("Y"));
    }

}

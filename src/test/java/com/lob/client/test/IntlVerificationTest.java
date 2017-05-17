package com.lob.client.test;

import com.lob.LobApiException;
import com.lob.protocol.request.IntlVerificationRequest;
import com.lob.protocol.response.IntlVerificationResponse;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class IntlVerificationTest extends BaseTest {

    @Test
    public void testIntlVerification() throws Exception {
        final IntlVerificationRequest request = IntlVerificationRequest.builder()
                .line1("370 Water St")
                .city("SUMMERSIDE")
                .state("PE")
                .zip("C1N 1C4")
                .country("CA")
                .build();

        try {
            IntlVerificationResponse response = client.verifyIntlAddress(request).get();
        } catch (final Exception e) {
            LobApiException exception = (LobApiException) e.getCause();
            assertThat(exception.getStatusCode(), is(403));
        }

    }

}

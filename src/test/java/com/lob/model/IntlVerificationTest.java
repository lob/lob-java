package com.lob.model;

import com.lob.BaseTest;
import com.lob.exception.APIException;
import com.lob.net.LobResponse;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class IntlVerificationTest extends BaseTest {

    @Test
    public void testInternationalVerification() throws Exception {
        try {
            LobResponse<IntlVerification> response = new IntlVerification.RequestBuilder()
                    .setPrimaryLine("370 Water St")
                    .setCity("Summerside")
                    .setState("Prince Edward Island")
                    .setPostalCode("C1N 1C4")
                    .setCountry("CA")
                    .verify();

        } catch (final APIException e) {
            assertThat(e.getStatusCode(), is(403));
        }
    }

}

package com.lob.client.test;

import com.lob.id.CountryCode;
import com.lob.id.ZipCode;
import com.lob.protocol.request.VerifyAddressRequest;
import com.lob.protocol.response.*;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class VerifyAddressTest extends BaseTest {

    @Test
    public void testAddressVerification() throws Exception {
        final VerifyAddressRequest.Builder builder = VerifyAddressRequest.builder()
                .line1("220 William T Morrissey")
                .line2("Suite 1510")
                .city("Boston")
                .state("MA")
                .zip("02125")
                .country("US");

        final VerifyAddressRequest request = builder.build();
        assertNotNull(request.toString());
        final VerifyAddressResponse response = client.verifyAddress(request).get();
        assertThat(response.getLine1(), is("220 WILLIAM T MORRISSEY BLVD"));
        assertFalse(response.getLine2().isEmpty());
        assertFalse(response.getCity().isEmpty());
        assertFalse(response.getState().isEmpty());
        assertTrue(response.getZip() instanceof ZipCode);
        assertTrue(response.getCountry() instanceof CountryCode);
        assertThat(response.getObject(), is("address"));
        assertNull(response.getMessage());
        assertNotNull(response.toString());

        final VerifyAddressRequest otherRequest = builder.butWith()
                .zip(ZipCode.parse("02125"))
                .country(CountryCode.parse("US"))
                .build();

        final VerifyAddressResponse otherResponse = client.verifyAddress(otherRequest).get();
        assertThat(otherResponse.getLine1(), is("220 WILLIAM T MORRISSEY BLVD"));
        assertFalse(otherResponse.getLine2().isEmpty());
        assertFalse(otherResponse.getCity().isEmpty());
        assertFalse(otherResponse.getState().isEmpty());
        assertTrue(otherResponse.getZip() instanceof ZipCode);
        assertTrue(otherResponse.getCountry() instanceof CountryCode);
        assertThat(otherResponse.getObject(), is("address"));
        assertNull(otherResponse.getMessage());
        assertNotNull(otherResponse.toString());
    }

    @Test
    public void testAddressVerificationMessage() throws Exception {
        final VerifyAddressRequest.Builder builder = VerifyAddressRequest.builder()
                .line1("185 Berry St.")
                .city("San Francisco")
                .state("CA")
                .zip("94107")
                .country("US");

        final VerifyAddressResponse response = client.verifyAddress(builder.build()).get();
        assertNotNull(response.getMessage());
    }

}

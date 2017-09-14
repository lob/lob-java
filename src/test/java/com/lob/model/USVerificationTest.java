package com.lob.model;

import com.lob.BaseTest;
import com.lob.net.LobResponse;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class USVerificationTest extends BaseTest {
    @Test
    public void testUsVerification() throws Exception {
        LobResponse<USVerification> response = USVerification.creator()
                .setPrimaryLine("185 Berry St")
                .setSecondaryLine("Ste 6100")
                .setCity("San Francisco")
                .setState("CA")
                .setZipCode("94107")
                .verify();

        USVerification usVerification = response.getResponseBody();
        assertThat(usVerification.getPrimaryLine(), is("185 BERRY ST STE 6100"));
        assertNotNull(usVerification.getComponents());
        assertThat(usVerification.getLastLine(), is ("SAN FRANCISCO CA 94107-1234"));
    }
}
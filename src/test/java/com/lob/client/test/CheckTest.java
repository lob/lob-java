package com.lob.client.test;

import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import com.lob.ClientUtil;
import com.lob.LobApiException;
import com.lob.Or;
import com.lob.id.BankAccountId;
import com.lob.id.CheckId;
import com.lob.protocol.request.*;
import com.lob.protocol.response.AddressResponse;
import com.lob.protocol.response.BankAccountResponse;
import com.lob.protocol.response.CheckResponse;
import com.lob.protocol.response.CheckResponseList;
import com.lob.protocol.response.CheckDeleteResponse;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.joda.time.DateTime;
import org.junit.Test;

import java.io.File;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CheckTest extends BaseTest {
    private BankAccountResponse getAndVerifyBankAccount() throws Exception {

        final BankAccountRequest request = BankAccountRequest.builder()
                .routingNumber("122100024")
                .accountNumber("123456789")
                .accountType("company")
                .signatory("John Doe")
                .description("java test suite bank account")
                .build();

        final BankAccountResponse bankAccount = client.createBankAccount(request).get();

        client.verifyBankAccount(BankAccountVerifyRequest.builder().id(bankAccount.getId()).amounts(20, 40).build()).get();

        return bankAccount;
    }

    private AddressResponse getAddress() throws Exception {
        return Iterables.get(client.getAddresses(1).get(), 0);
    }

    @Test
    public void testListChecks() throws Exception {
        final CheckResponseList responseList = client.getChecks().get();
        assertEquals(200, responseList.getStatusCode());
        assertNotNull(responseList.getHeaders());
        assertEquals("application/json; charset=utf-8", responseList.getHeaders().getFirstValue("content-type"));

        final CheckResponse response = responseList.get(0);

        assertTrue(response instanceof CheckResponse);
        assertNotNull(response.getTrackingEvents());
        assertNull(response.getTrackingNumber());
        assertNotNull(response.getCarrier());
        assertThat(responseList.getObject(), is("list"));
        assertNotNull(responseList.toString());
        assertNotNull(response.toString());
    }

    @Test
    public void testListChecksLimit() throws Exception {
        final CheckResponseList responseList = client.getChecks(2).get();

        assertThat(responseList.getCount(), is(2));
        assertThat(responseList.getObject(), is("list"));

        assertThat(client.getChecks(1, 2).get().getCount(), is(1));
    }

    @Test
    public void testListChecksFail() throws Exception {
        try {
            client.getChecks(1000).get();
            fail();
        }
        catch (final ExecutionException e) {
            if (!(e.getCause() instanceof LobApiException)) {
                fail();
            }

            final LobApiException lobApiException = (LobApiException) e.getCause();
        }
    }


    @Test
    public void testCreateCheck() throws Exception {
        final String value0 = UUID.randomUUID().toString();
        final String value1 = UUID.randomUUID().toString();
        final Map<String, String> metadata = Maps.newHashMap();
        metadata.put("key0", value0);
        metadata.put("key1", value1);
        final AddressResponse address = getAddress();
        final BankAccountResponse bankAccount = getAndVerifyBankAccount();

        final CheckRequest.Builder builder = CheckRequest.builder()
            .bankAccount(bankAccount.getId())
            .description("check")
            .to(address.getId())
            .from(address.getId())
            .amount(1000)
            .message("test message")
            .checkNumber(100)
            .memo("Test Check")
            .metadata(metadata);

        final CheckRequest request = builder.build();
        assertNotNull(request.toString());
        final CheckResponse response = client.createCheck(request).get();
        assertTrue(response instanceof CheckResponse);
        assertThat(response.getBankAccount().getId(), is(bankAccount.getId()));
        assertThat(response.getTo().getId(), is(address.getId()));
        assertThat(response.getFrom().getId(), is(address.getId()));
        assertThat(response.getDescription(), is("check"));
        assertThat(response.getMetadata().get("key0"), is(value0));
        assertThat(response.getMetadata().get("key1"), is(value1));

        assertFalse(response.getMessage().isEmpty());
        assertFalse(response.getMemo().isEmpty());
        assertFalse(response.getUrl().isEmpty());
        assertTrue(response.getCheckNumber() > 0);
        assertTrue(response.getExpectedDeliveryDate() instanceof DateTime);
        assertTrue(response.getAmount() instanceof Money);
        assertFalse(response.getThumbnails().isEmpty());
        final CheckResponse metadataResponse = client.getChecks(Filters.ofMetadata(metadata)).get().get(0);
        assertThat(metadataResponse.getId(), is(response.getId()));
        assertEquals(200, response.getStatusCode());
        assertNotNull(response.getHeaders());
        assertEquals("application/json; charset=utf-8", response.getHeaders().getFirstValue("content-type"));

        final CheckResponse retrievedResponse = client.getCheck(response.getId()).get();
        assertThat(retrievedResponse.getId(), is(response.getId()));

        client.createCheck(builder.butWith().amount(Money.of(CurrencyUnit.USD, 1000)).build()).get();

        final File logo = ClientUtil.fileFromResource("lobCheckLogo.png");
        client.createCheck(builder.butWith().logo(logo).build()).get();

        final CheckRequest otherRequest = builder.butWith().logo("example.com/logo").build();
        assertFalse(otherRequest.getMessage().isEmpty());
        assertFalse(otherRequest.getMemo().isEmpty());
        assertTrue(otherRequest.getAmount() instanceof Money);
        assertTrue(otherRequest.getBankAccount() instanceof BankAccountId);
        assertTrue(otherRequest.getCheckNumber() instanceof Integer);
        assertTrue(otherRequest.getTo() instanceof Or);
        assertTrue(otherRequest.getFrom() instanceof Or);
        assertFalse(otherRequest.getLogo().getStringParam().isEmpty());
    }

    @Test
    public void testCreateCheckWithFile() throws Exception {
        final Map<String, String> data = Maps.newHashMap();
        data.put("name", "Donald");
        final AddressResponse address = getAddress();
        final BankAccountResponse bankAccount = getAndVerifyBankAccount();

        final CheckRequest.Builder builder = CheckRequest.builder()
                .bankAccount(bankAccount.getId())
                .description("check")
                .to(address.getId())
                .from(address.getId())
                .amount(10.50)
                .file("<h1 style='padding-top:4in;'>Demo Check for {{name}}</h1>")
                .checkNumber(100)
                .memo("Test Check")
                .data(data);

        final CheckRequest request = builder.build();
        assertNotNull(request.getFile());
        final CheckResponse response = client.createCheck(request).get();
        assertTrue(response instanceof CheckResponse);
        assertThat(response.getBankAccount().getId(), is(bankAccount.getId()));
        assertThat(response.getTo().getId(), is(address.getId()));
        assertThat(response.getFrom().getId(), is(address.getId()));
        assertThat(response.getDescription(), is("check"));
        assertNull(response.getMessage());
        assertFalse(response.getMemo().isEmpty());
        assertFalse(response.getUrl().isEmpty());
        assertTrue(response.getCheckNumber() > 0);
        assertTrue(response.getExpectedDeliveryDate() instanceof DateTime);
        assertTrue(response.getAmount() instanceof Money);
        assertFalse(response.getThumbnails().isEmpty());
    }

    @Test
    public void testCreateCheckWithLocalFile() throws Exception {
        final Map<String, String> data = Maps.newHashMap();
        data.put("name", "Donald");
        final AddressResponse address = getAddress();
        final BankAccountResponse bankAccount = getAndVerifyBankAccount();

        final CheckRequest.Builder builder = CheckRequest.builder()
                .bankAccount(bankAccount.getId())
                .description("check")
                .to(address.getId())
                .from(address.getId())
                .amount(10.50)
                .file(ClientUtil.fileFromResource("8.5x11.pdf"))
                .attachment(ClientUtil.fileFromResource("8.5x11.pdf"))
                .checkNumber(100)
                .memo("Test Check")
                .data(data);

        final CheckRequest request1 = builder.build();
        assertNotNull(request1.getFile());
        assertNotNull(request1.getAttachment());
        final CheckResponse response1 = client.createCheck(request1).get();
        assertTrue(response1 instanceof CheckResponse);
        assertThat(response1.getDescription(), is("check"));
        assertFalse(response1.getUrl().isEmpty());

        final CheckRequest request2 = builder
                .butWith()
                .file(LobParam.file("check_bottom", ClientUtil.fileFromResource("8.5x11.pdf")))
                .attachment(LobParam.file("attachment", ClientUtil.fileFromResource("8.5x11.pdf")))
                .build();
        final CheckResponse response2 = client.createCheck(request2).get();
        assertTrue(response2 instanceof CheckResponse);
        assertThat(response2.getDescription(), is("check"));
        assertFalse(response2.getUrl().isEmpty());
    }

    @Test
    public void testCreateCheckInline() throws Exception {
        final BankAccountResponse bankAccount = getAndVerifyBankAccount();

        final CheckRequest request = CheckRequest.builder()
            .bankAccount(bankAccount.getId())
            .to(AddressRequest.builder()
                .name("Lob To")
                .line1("185 Berry Street")
                .line2("Suite 1510")
                .city("San Francisco")
                .state("CA")
                .zip("94107")
                .country("US")
                .build())
            .from(AddressRequest.builder()
                .name("Lob From")
                .line1("185 Berry Street")
                .line2("Suite 1510")
                .city("San Francisco")
                .state("CA")
                .zip("94107")
                .country("US")
                .build())
            .amount(1000)
            .memo("Test Check")
            .checkBottom("<h1 style='padding-top:4in;'>Demo Check</h1>")
            .attachment("<h1 style='padding-top:4in;'>Demo Check</h1>")
            .build();

        final CheckResponse response = client.createCheck(request).get();
        assertTrue(response instanceof CheckResponse);
        assertThat(response.getBankAccount().getId(), is(bankAccount.getId()));
        assertThat(response.getTo().getName(), is("Lob To"));
        assertThat(response.getFrom().getName(), is("Lob From"));
    }

    @Test
    public void testCreateCustomMailType() throws Exception {
        final BankAccountResponse bankAccount = getAndVerifyBankAccount();
        final AddressResponse address = client.getAddresses(1).get().get(0);

        final CheckRequest request = CheckRequest.builder()
                .bankAccount(bankAccount.getId())
                .to(address.getId())
                .from(address.getId())
                .amount(1000)
                .memo("Test Check")
                .mailType("ups_next_day_air")
                .build();

        assertThat(request.getMailType(), is("ups_next_day_air"));

        final CheckResponse response = client.createCheck(request).get();

        assertThat(response.getMailType(), is("ups_next_day_air"));
    }

    @Test
    public void testCheckDelete() throws Exception {
        final AddressResponse address = getAddress();
        final BankAccountResponse bankAccount = getAndVerifyBankAccount();

        final CheckRequest.Builder builder = CheckRequest.builder()
                .bankAccount(bankAccount.getId())
                .to(address.getId())
                .from(address.getId())
                .amount(1000);

        final CheckRequest request = builder.build();

        final CheckId id = client.createCheck(request).get().getId();
        final CheckDeleteResponse response = client.deleteCheck(id).get();
        assertThat(response.getId(), is(id));
        assertTrue(response.isDeleted());
        assertNotNull(response.toString());
        assertEquals(200, response.getStatusCode());
        assertNotNull(response.getHeaders());
        assertEquals("application/json; charset=utf-8", response.getHeaders().getFirstValue("content-type"));
    }
}

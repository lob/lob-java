package com.lob.client.test;

import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import com.lob.ClientUtil;
import com.lob.LobApiException;
import com.lob.Or;
import com.lob.client.AsyncLobClient;
import com.lob.client.LobClient;
import com.lob.id.BankAccountId;
import com.lob.protocol.request.AddressRequest;
import com.lob.protocol.request.BankAccountVerifyRequest;
import com.lob.protocol.request.CheckRequest;
import com.lob.protocol.request.Filters;
import com.lob.protocol.response.AddressResponse;
import com.lob.protocol.response.BankAccountResponse;
import com.lob.protocol.response.CheckResponse;
import com.lob.protocol.response.CheckResponseList;
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
        final BankAccountResponse bankAccount = Iterables.get(client.getBankAccounts(1).get(), 0);
        if (!bankAccount.isVerified()) {
            client.verifyBankAccount(
                BankAccountVerifyRequest.builder().id(bankAccount.getId()).amounts(20, 40).build()).get();
        }
        return bankAccount;
    }

    private AddressResponse getAddress() throws Exception {
        return Iterables.get(client.getAddresses(1).get(), 0);
    }

    @Test
    public void testListChecks() throws Exception {
        final CheckResponseList responseList = client.getChecks().get();
        final CheckResponse response = responseList.get(0);

        assertTrue(response instanceof CheckResponse);
        assertNotNull(response.getTracking().toString());
        assertNotNull(response.getTracking().getEvents());
        assertNotNull(response.getTracking().getId());
        assertNotNull(response.getTracking().getTrackingNumber());
        assertNotNull(response.getTracking().getCarrier());
        assertNull(response.getTracking().getLink());
        assertThat(response.getTracking().getObject(), is("tracking"));
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
                .amount(1000)
            .message("test message")
            .checkNumber(100)
            .memo("Test Check")
            .metadata(metadata);

        final CheckResponse response = client.createCheck(builder.build()).get();
        assertTrue(response instanceof CheckResponse);
        assertThat(response.getBankAccount().getId(), is(bankAccount.getId()));
        assertThat(response.getTo().getId(), is(address.getId()));
        assertThat(response.getDescription(), is("check"));
        assertThat(response.getMetadata().get("key0"), is(value0));
        assertThat(response.getMetadata().get("key1"), is(value1));

        assertFalse(response.getMessage().isEmpty());
        assertFalse(response.getMemo().isEmpty());
        assertFalse(response.getUrl().isEmpty());
        assertTrue(response.getCheckNumber() > 0);
        assertTrue(response.getExpectedDeliveryDate() instanceof DateTime);
        assertTrue(response.getPrice() instanceof Money);
        assertTrue(response.getAmount() instanceof Money);
        assertFalse(response.getThumbnails().isEmpty());
        final CheckResponse metadataResponse = client.getChecks(Filters.ofMetadata(metadata)).get().get(0);
        assertThat(metadataResponse.getId(), is(response.getId()));

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
                .amount(1000)
                .file("<h1 style='padding-top:4in;'>Demo Check for {{name}}</h1>")
                .checkNumber(100)
                .memo("Test Check")
                .data(data);

        final CheckResponse response = client.createCheck(builder.build()).get();
        assertTrue(response instanceof CheckResponse);
        assertThat(response.getBankAccount().getId(), is(bankAccount.getId()));
        assertThat(response.getTo().getId(), is(address.getId()));
        assertThat(response.getDescription(), is("check"));

        assertNull(response.getMessage());
        assertFalse(response.getMemo().isEmpty());
        assertFalse(response.getUrl().isEmpty());
        assertTrue(response.getCheckNumber() > 0);
        assertTrue(response.getExpectedDeliveryDate() instanceof DateTime);
        assertTrue(response.getPrice() instanceof Money);
        assertTrue(response.getAmount() instanceof Money);
        assertFalse(response.getThumbnails().isEmpty());
    }


    @Test
    public void testCreateCheckInline() throws Exception {
        final BankAccountResponse bankAccount = getAndVerifyBankAccount();

        final CheckRequest request = CheckRequest.builder()
            .bankAccount(bankAccount.getId())
            .to(AddressRequest.builder()
                .name("Lob")
                .line1("185 Berry Street")
                .line2("Suite 1510")
                .city("San Francisco")
                .state("CA")
                .zip("94107")
                .country("US")
                .build())
            .amount(1000)
            .memo("Test Check")
            .build();

        final CheckResponse response = client.createCheck(request).get();
        assertTrue(response instanceof CheckResponse);
        assertThat(response.getBankAccount().getId(), is(bankAccount.getId()));
        assertThat(response.getTo().getName(), is("Lob"));
    }
}

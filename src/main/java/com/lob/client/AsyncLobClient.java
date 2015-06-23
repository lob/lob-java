package com.lob.client;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import com.google.common.base.Optional;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import com.lob.BooleanDeserializer;
import com.lob.Lob;
import com.lob.LobApiException;
import com.lob.MoneyDeserializer;
import com.lob.id.*;
import com.lob.protocol.request.*;
import com.lob.protocol.response.*;
import com.ning.http.client.AsyncCompletionHandler;
import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.AsyncHttpClient.BoundRequestBuilder;
import com.ning.http.client.AsyncHttpClientConfig;
import com.ning.http.client.AsyncHttpClientConfig.Builder;
import com.ning.http.client.FilePart;
import com.ning.http.client.FluentStringsMap;
import com.ning.http.client.Realm;
import com.ning.http.client.Realm.AuthScheme;
import com.ning.http.client.Response;
import com.ning.http.client.StringPart;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

import java.io.IOException;
import java.util.Collection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static com.google.common.base.Preconditions.*;

public class AsyncLobClient implements LobClient {
    private final static ObjectMapper MAPPER = new ObjectMapper()
        .registerModule(new JodaModule())
        .registerModule(new SimpleModule()
            .addDeserializer(Money.class, new MoneyDeserializer(CurrencyUnit.USD))
            .addDeserializer(Boolean.class, new BooleanDeserializer())
        )
        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    private final AsyncHttpClient httpClient;
    private final String baseUrl;

    private final ExecutorService callbackExecutorService;

    private AsyncLobClient(
            final AsyncHttpClient httpClient,
            final String baseUrl,
            final ExecutorService callbackExecutorService) {
        this.httpClient = httpClient;
        this.baseUrl = baseUrl;
        this.callbackExecutorService = callbackExecutorService;
    }

    private static AsyncHttpClientConfig commonSetup(final String apiKey, final AsyncHttpClientConfig.Builder configBuilder) {
        final Realm realm = new Realm.RealmBuilder()
            .setPrincipal(checkNotNull(apiKey))
            .setUsePreemptiveAuth(true)
            .setScheme(AuthScheme.BASIC)
            .build();

        configBuilder.setRealm(realm);
        return configBuilder.build();
    }

    public static LobClient createDefault(final String apiKey) {
        return new AsyncLobClient(
            new AsyncHttpClient(commonSetup(apiKey, new Builder())),
            Lob.getBaseUrl(),
            Executors.newCachedThreadPool());
    }

    public static LobClient create(final String apiKey, final AsyncHttpClientConfig config) {
        return new AsyncLobClient(
            new AsyncHttpClient(commonSetup(apiKey, new Builder(config))),
            Lob.getBaseUrl(),
            Executors.newCachedThreadPool());
    }

    @Override
    public ListenableFuture<JobResponse> createJob(final JobRequest jobRequest) {
        return execute(JobResponse.class, post(Router.JOBS, jobRequest), this.callbackExecutorService);
    }

    @Override
    public ListenableFuture<JobResponse> getJob(final JobId id) {
        return execute(JobResponse.class, get(Router.JOBS, id), this.callbackExecutorService);
    }

    @Override
    public ListenableFuture<JobResponseList> getJobs() {
        return execute(JobResponseList.class, get(Router.JOBS), this.callbackExecutorService);
    }

    @Override
    public ListenableFuture<JobResponseList> getJobs(final int count) {
        return execute(JobResponseList.class, get(Router.JOBS, count), this.callbackExecutorService);
    }

    @Override
    public ListenableFuture<JobResponseList> getJobs(final int count, final int offset) {
        return execute(JobResponseList.class, get(Router.JOBS, count, offset), this.callbackExecutorService);
    }

    @Override
    public ListenableFuture<AddressResponse> createAddress(final AddressRequest addressRequest) {
        return execute(AddressResponse.class, post(Router.ADDRESSES, addressRequest), this.callbackExecutorService);
    }

    @Override
    public ListenableFuture<AddressResponse> getAddress(final AddressId id) {
        return execute(AddressResponse.class, get(Router.ADDRESSES, id), this.callbackExecutorService);
    }

    @Override
    public ListenableFuture<AddressResponseList> getAddresses() {
        return execute(AddressResponseList.class, get(Router.ADDRESSES), this.callbackExecutorService);
    }

    @Override
    public ListenableFuture<AddressResponseList> getAddresses(final int count) {
        return execute(AddressResponseList.class, get(Router.ADDRESSES, count), this.callbackExecutorService);
    }

    @Override
    public ListenableFuture<AddressResponseList> getAddresses(final int count, final int offset) {
        return execute(AddressResponseList.class, get(Router.ADDRESSES, count, offset), this.callbackExecutorService);
    }

    @Override
    public ListenableFuture<AddressDeleteResponse> deleteAddress(final AddressId id) {
        return execute(AddressDeleteResponse.class, delete(Router.ADDRESSES, id), this.callbackExecutorService);
    }

    @Override
    public ListenableFuture<LobObjectResponse> createLobObject(final LobObjectRequest lobObjectRequest) {
        return execute(LobObjectResponse.class, post(Router.OBJECTS, lobObjectRequest), this.callbackExecutorService);
    }

    @Override
    public ListenableFuture<LobObjectResponse> getLobObject(final LobObjectId id) {
        return execute(LobObjectResponse.class, get(Router.OBJECTS, id), this.callbackExecutorService);
    }

    @Override
    public ListenableFuture<LobObjectResponseList> getLobObjects() {
        return execute(LobObjectResponseList.class, get(Router.OBJECTS), this.callbackExecutorService);
    }

    @Override
    public ListenableFuture<LobObjectResponseList> getLobObjects(final int count) {
        return execute(LobObjectResponseList.class, get(Router.OBJECTS, count), this.callbackExecutorService);
    }

    @Override
    public ListenableFuture<LobObjectDeleteResponse> deleteLobObject(final LobObjectId id) {
        return execute(LobObjectDeleteResponse.class, delete(Router.OBJECTS, id), this.callbackExecutorService);
    }

    @Override
    public ListenableFuture<LobObjectResponseList> getLobObjects(final int count, final int offset) {
        return execute(LobObjectResponseList.class, get(Router.OBJECTS, count, offset), this.callbackExecutorService);
    }

    @Override
    public ListenableFuture<SettingResponse> getSetting(final SettingId id) {
        return execute(SettingResponse.class, get(Router.SETTINGS, id), this.callbackExecutorService);
    }

    @Override
    public ListenableFuture<SettingResponseList> getSettings() {
        return execute(SettingResponseList.class, get(Router.SETTINGS), this.callbackExecutorService);
    }

    @Override
    public ListenableFuture<ServiceResponseList> getServices() {
        return execute(ServiceResponseList.class, get(Router.SERVICES), this.callbackExecutorService);
    }

    @Override
    public ListenableFuture<LetterResponse> createLetter(final LetterRequest letterRequest) {
        return execute(LetterResponse.class, post(Router.LETTERS, letterRequest), this.callbackExecutorService);
    }

    @Override
    public ListenableFuture<LetterResponse> getLetter(final LetterId id) {
        return execute(LetterResponse.class, get(Router.LETTERS, id), this.callbackExecutorService);
    }

    @Override
    public ListenableFuture<LetterResponseList> getLetters() {
        return execute(LetterResponseList.class, get(Router.LETTERS), this.callbackExecutorService);
    }

    @Override
    public ListenableFuture<LetterResponseList> getLetters(final int count) {
        return execute(LetterResponseList.class, get(Router.LETTERS, count), this.callbackExecutorService);
    }

    @Override
    public ListenableFuture<LetterResponseList> getLetters(final int count, final int offset) {
        return execute(LetterResponseList.class, get(Router.LETTERS, count, offset), this.callbackExecutorService);
    }

    @Override
    public ListenableFuture<PostcardResponse> createPostcard(final PostcardRequest postcardRequest) {
        return execute(PostcardResponse.class, post(Router.POSTCARDS, postcardRequest), this.callbackExecutorService);
    }

    @Override
    public ListenableFuture<PostcardResponse> getPostcard(final PostcardId id) {
        return execute(PostcardResponse.class, get(Router.POSTCARDS, id), this.callbackExecutorService);
    }

    @Override
    public ListenableFuture<PostcardResponseList> getPostcards() {
        return execute(PostcardResponseList.class, get(Router.POSTCARDS), this.callbackExecutorService);
    }

    @Override
    public ListenableFuture<PostcardResponseList> getPostcards(final int count) {
        return execute(PostcardResponseList.class, get(Router.POSTCARDS, count), this.callbackExecutorService);
    }

    @Override
    public ListenableFuture<PostcardResponseList> getPostcards(final int count, final int offset) {
        return execute(PostcardResponseList.class, get(Router.POSTCARDS, count, offset), this.callbackExecutorService);
    }

    @Override
    public ListenableFuture<CheckResponse> createCheck(final CheckRequest checkRequest) {
        return execute(CheckResponse.class, post(Router.CHECKS, checkRequest), this.callbackExecutorService);
    }

    @Override
    public ListenableFuture<CheckResponse> getCheck(final CheckId id) {
        return execute(CheckResponse.class, get(Router.CHECKS, id), this.callbackExecutorService);
    }

    @Override
    public ListenableFuture<CheckResponseList> getChecks() {
        return execute(CheckResponseList.class, get(Router.CHECKS), this.callbackExecutorService);
    }

    @Override
    public ListenableFuture<CheckResponseList> getChecks(final int count) {
        return execute(CheckResponseList.class, get(Router.CHECKS, count), this.callbackExecutorService);
    }

    @Override
    public ListenableFuture<CheckResponseList> getChecks(final int count, final int offset) {
        return execute(CheckResponseList.class, get(Router.CHECKS, count, offset), this.callbackExecutorService);
    }

    @Override
    public ListenableFuture<BankAccountResponse> createBankAccount(final BankAccountRequest bankAccountRequest) {
        return execute(BankAccountResponse.class, post(Router.BANK_ACCOUNTS, bankAccountRequest), this.callbackExecutorService);
    }

    @Override
    public ListenableFuture<BankAccountResponse> getBankAccount(final BankAccountId id) {
        return execute(BankAccountResponse.class, get(Router.BANK_ACCOUNTS, id), this.callbackExecutorService);
    }

    @Override
    public ListenableFuture<BankAccountResponseList> getBankAccounts() {
        return execute(BankAccountResponseList.class, get(Router.BANK_ACCOUNTS), this.callbackExecutorService);
    }

    @Override
    public ListenableFuture<BankAccountResponseList> getBankAccounts(final int count) {
        return execute(BankAccountResponseList.class, get(Router.BANK_ACCOUNTS, count), this.callbackExecutorService);
    }

    @Override
    public ListenableFuture<BankAccountResponseList> getBankAccounts(final int count, final int offset) {
        return execute(BankAccountResponseList.class, get(Router.BANK_ACCOUNTS, count, offset), this.callbackExecutorService);
    }

    @Override
    public ListenableFuture<BankAccountDeleteResponse> deleteBankAccount(final BankAccountId id) {
        return execute(BankAccountDeleteResponse.class, delete(Router.BANK_ACCOUNTS, id), this.callbackExecutorService);
    }

    @Override
    public ListenableFuture<BankAccountResponse> verifyBankAccount(final BankAccountVerifyRequest request) {
        return execute(
            BankAccountResponse.class,
            post(Router.BANK_ACCOUNTS + "/" + request.getId().value() + "/verify", request),
            this.callbackExecutorService);
    }

    @Override
    public ListenableFuture<AreaMailResponse> createAreaMail(final AreaMailRequest areaMailRequest) {
        return execute(AreaMailResponse.class, post(Router.AREA_MAIL, areaMailRequest), this.callbackExecutorService);
    }

    @Override
    public ListenableFuture<AreaMailResponse> getAreaMail(final AreaMailId id) {
        return execute(AreaMailResponse.class, get(Router.AREA_MAIL, id), this.callbackExecutorService);
    }

    @Override
    public ListenableFuture<AreaMailResponseList> getAreaMails() {
        return execute(AreaMailResponseList.class, get(Router.AREA_MAIL), this.callbackExecutorService);
    }

    @Override
    public ListenableFuture<AreaMailResponseList> getAreaMails(final int count) {
        return execute(AreaMailResponseList.class, get(Router.AREA_MAIL, count), this.callbackExecutorService);
    }

    @Override
    public ListenableFuture<AreaMailResponseList> getAreaMails(final int count, final int offset) {
        return execute(AreaMailResponseList.class, get(Router.AREA_MAIL, count, offset), this.callbackExecutorService);
    }

    @Override
    public ListenableFuture<ZipCodeRouteResponseList> getZipCodeRoutes(final ZipCodeRouteRequest request) {
        return execute(ZipCodeRouteResponseList.class, get(Router.ROUTES, request), this.callbackExecutorService);
    }

    @Override
    public ListenableFuture<VerifyAddressResponse> verifyAddress(final VerifyAddressRequest request) {
        return execute(VerifyAddressResponse.class, post(Router.VERIFY, request), this.callbackExecutorService);
    }

    @Override
    public ListenableFuture<CountryResponseList> getCountries() {
        return execute(CountryResponseList.class, get(Router.COUNTRIES), this.callbackExecutorService);
    }

    @Override
    public ListenableFuture<StateResponseList> getStates() {
        return execute(StateResponseList.class, get(Router.STATES), this.callbackExecutorService);
    }

    @Override
    public ListenableFuture<PackagingResponseList> getPackagings() {
        return execute(PackagingResponseList.class, get(Router.PACKAGINGS), this.callbackExecutorService);
    }

    private BoundRequestBuilder delete(final String resourceUrl, final LobId id) {
        return this.httpClient.prepareDelete(this.baseUrl + resourceUrl + "/" + id.value());
    }

    private BoundRequestBuilder get(final String resourceUrl) {
        return get(resourceUrl, new FluentStringsMap());
    }

    private BoundRequestBuilder get(final String resourceUrl, final HasLobParams request) {
        final FluentStringsMap map = new FluentStringsMap();
        for (final LobParam param : request.getLobParams()) {
            map.add(param.getName(), param.getStringParam());
        }
        return get(resourceUrl, new FluentStringsMap(map));
    }

    private BoundRequestBuilder get(final String resourceUrl, final LobId id) {
        return get(resourceUrl + "/" + id.value(), new FluentStringsMap());
    }

    private BoundRequestBuilder get(final String resourceUrl, final StringValued id) {
        return get(resourceUrl + "/" + id.value(), new FluentStringsMap());
    }

    private BoundRequestBuilder get(final String resourceUrl, final int count) {
        return get(resourceUrl, new FluentStringsMap().add("count", Integer.toString(count)));
    }

    private BoundRequestBuilder get(final String resourceUrl, final int count, final int offset) {
        return get(
            resourceUrl,
            new FluentStringsMap()
                .add("count", Integer.toString(count))
                .add("offset", Integer.toString(offset)));
    }

    private BoundRequestBuilder get(final String resourceUrl, final FluentStringsMap params) {
        return this.httpClient.prepareGet(this.baseUrl + resourceUrl).setQueryParameters(params);
    }

    private BoundRequestBuilder post(final String resourceUrl, final HasLobParams hasLobParams) {
        final BoundRequestBuilder builder = this.httpClient.preparePost(this.baseUrl + resourceUrl);
        final Collection<LobParam> params = hasLobParams.getLobParams();

        boolean isMultipart = false;
        for (final LobParam param : params) {
            if (param.isFileParam()) {
                isMultipart = true;
                break;
            }
        }

        if (isMultipart) {
            for (final LobParam param : params) {
                if (param.isStringParam()) {
                    for (final String s : param.getStringParam()) {
                        builder.addBodyPart(new StringPart(param.getName(), s));
                    }
                }
                else {
                    builder.addBodyPart(new FilePart(param.getName(), param.getFileParam(), null, null));
                }
            }
        }
        else {
            for (final LobParam param : params) {
                for (final String s : param.getStringParam()) {
                    builder.addParameter(param.getName(), s);
                }
            }
        }
        return builder;
    }

    private static <T> ListenableFuture<T> execute(
            final Class<T> clazz,
            final BoundRequestBuilder request,
            final ExecutorService callbackExecutorService) {
            final SettableFuture<T> guavaFut = SettableFuture.create();
        try {
            final Optional<String> apiVersionOpt = Lob.getApiVersion();
            if (apiVersionOpt.isPresent()) {
                request.addHeader(LobClient.LOB_VERSION_HEADER, apiVersionOpt.get());
            }

            request.execute(new GuavaFutureConverter<T>(clazz, guavaFut, callbackExecutorService));
        }
        catch (final IOException e) {
            guavaFut.setException(e);
        }
        return guavaFut;
    }

    private static class GuavaFutureConverter<T> extends AsyncCompletionHandler<T> {
        final Class<T> clazz;
        final SettableFuture<T> guavaFut;
        final ExecutorService callbackExecutorService;

        public GuavaFutureConverter(
                final Class<T> clazz,
                final SettableFuture<T> guavaFut,
                final ExecutorService callbackExecutorService) {
            this.clazz = clazz;
            this.guavaFut = guavaFut;
            this.callbackExecutorService = callbackExecutorService;
        }

        private static boolean isSuccess(final Response response) {
            final int statusCode = response.getStatusCode();
            return (statusCode > 199 && statusCode < 400);
        }

        @Override
        public void onThrowable(final Throwable t) {
            guavaFut.setException(t);
        }

        @Override
        public T onCompleted(final Response response) throws Exception {
            if (isSuccess(response)) {
                final T value = MAPPER.readValue(response.getResponseBody(), clazz);
                // Execute setting the guava future in a separate thread so any callbacks
                // executed on the guava future don't block the ning IO threads.
                this.callbackExecutorService.submit(
                    new Runnable() {
                        @Override
                        public void run() {
                            guavaFut.set(value);
                        }
                    });
                return value;
            }
            else {
                final ErrorResponse error = MAPPER.readValue(response.getResponseBody(), ErrorResponse.class);
                final LobApiException exception = new LobApiException(response.getUri(), error);

                this.callbackExecutorService.submit(
                    new Runnable() {
                        @Override
                        public void run() {
                            guavaFut.setException(exception);
                        }
                    });
                throw exception;
            }
        }
    }
}

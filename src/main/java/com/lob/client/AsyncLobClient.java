package com.lob.client;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import com.google.common.base.Optional;
import com.google.common.escape.Escaper;
import com.google.common.net.UrlEscapers;
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
import com.ning.http.client.multipart.FilePart;
import com.ning.http.client.FluentStringsMap;
import com.ning.http.client.Realm;
import com.ning.http.client.Realm.AuthScheme;
import com.ning.http.client.Response;
import com.ning.http.client.multipart.StringPart;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;
import java.util.Properties;

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

    private final static String JAVA_VERSION = System.getProperty("java.version");

    private AsyncLobClient(
            final AsyncHttpClient httpClient,
            final String baseUrl) {
        this.httpClient = httpClient;
        this.baseUrl = baseUrl;
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
            Lob.getBaseUrl());
    }

    public static LobClient create(final String apiKey, final AsyncHttpClientConfig config) {
        return new AsyncLobClient(
            new AsyncHttpClient(commonSetup(apiKey, new Builder(config))),
            Lob.getBaseUrl());
    }

    @Override
    public void close() {
        this.httpClient.close();
    }

    @Override
    public void closeAsynchronously() {
        this.httpClient.closeAsynchronously();
    }

    @Override
    public ListenableFuture<AddressResponse> createAddress(final AddressRequest addressRequest) {
        return execute(AddressResponse.class, post(Router.ADDRESSES, addressRequest));
    }

    @Override
    public ListenableFuture<AddressResponse> getAddress(final AddressId id) {
        return execute(AddressResponse.class, get(Router.ADDRESSES, id));
    }

    @Override
    public ListenableFuture<AddressResponseList> getAddresses() {
        return execute(AddressResponseList.class, get(Router.ADDRESSES));
    }

    @Override
    public ListenableFuture<AddressResponseList> getAddresses(final int count) {
        return execute(AddressResponseList.class, get(Router.ADDRESSES, count));
    }

    @Override
    public ListenableFuture<AddressResponseList> getAddresses(final int count, final int offset) {
        return execute(AddressResponseList.class, get(Router.ADDRESSES, count, offset));
    }

    @Override
    public ListenableFuture<AddressResponseList> getAddresses(final Filter filter) {
        return execute(AddressResponseList.class, get(Router.ADDRESSES, filter));
    }

    @Override
    public ListenableFuture<AddressDeleteResponse> deleteAddress(final AddressId id) {
        return execute(AddressDeleteResponse.class, delete(Router.ADDRESSES, id));
    }

    @Override
    public ListenableFuture<LetterResponse> createLetter(final LetterRequest letterRequest) {
        return execute(LetterResponse.class, post(Router.LETTERS, letterRequest));
    }

    @Override
    public ListenableFuture<LetterResponse> getLetter(final LetterId id) {
        return execute(LetterResponse.class, get(Router.LETTERS, id));
    }

    @Override
    public ListenableFuture<LetterResponseList> getLetters() {
        return execute(LetterResponseList.class, get(Router.LETTERS));
    }

    @Override
    public ListenableFuture<LetterResponseList> getLetters(final int count) {
        return execute(LetterResponseList.class, get(Router.LETTERS, count));
    }

    @Override
    public ListenableFuture<LetterResponseList> getLetters(final int count, final int offset) {
        return execute(LetterResponseList.class, get(Router.LETTERS, count, offset));
    }

    @Override
    public ListenableFuture<LetterResponseList> getLetters(final Filter filter) {
        return execute(LetterResponseList.class, get(Router.LETTERS, filter));
    }

    @Override
    public ListenableFuture<LetterDeleteResponse> deleteLetter(final LetterId id) {
        return execute(LetterDeleteResponse.class, delete(Router.LETTERS, id));
    }

    @Override
    public ListenableFuture<PostcardResponse> createPostcard(final PostcardRequest postcardRequest) {
        return execute(PostcardResponse.class, post(Router.POSTCARDS, postcardRequest));
    }

    @Override
    public ListenableFuture<PostcardResponse> getPostcard(final PostcardId id) {
        return execute(PostcardResponse.class, get(Router.POSTCARDS, id));
    }

    @Override
    public ListenableFuture<PostcardResponseList> getPostcards() {
        return execute(PostcardResponseList.class, get(Router.POSTCARDS));
    }

    @Override
    public ListenableFuture<PostcardResponseList> getPostcards(final int count) {
        return execute(PostcardResponseList.class, get(Router.POSTCARDS, count));
    }

    @Override
    public ListenableFuture<PostcardResponseList> getPostcards(final int count, final int offset) {
        return execute(PostcardResponseList.class, get(Router.POSTCARDS, count, offset));
    }

    @Override
    public ListenableFuture<PostcardResponseList> getPostcards(final Filter filter) {
        return execute(PostcardResponseList.class, get(Router.POSTCARDS, filter));
    }

    @Override
    public ListenableFuture<PostcardDeleteResponse> deletePostcard(final PostcardId id) {
        return execute(PostcardDeleteResponse.class, delete(Router.POSTCARDS, id));
    }

    @Override
    public ListenableFuture<CheckResponse> createCheck(final CheckRequest checkRequest) {
        return execute(CheckResponse.class, post(Router.CHECKS, checkRequest));
    }

    @Override
    public ListenableFuture<CheckResponse> getCheck(final CheckId id) {
        return execute(CheckResponse.class, get(Router.CHECKS, id));
    }

    @Override
    public ListenableFuture<CheckResponseList> getChecks() {
        return execute(CheckResponseList.class, get(Router.CHECKS));
    }

    @Override
    public ListenableFuture<CheckResponseList> getChecks(final int count) {
        return execute(CheckResponseList.class, get(Router.CHECKS, count));
    }

    @Override
    public ListenableFuture<CheckResponseList> getChecks(final int count, final int offset) {
        return execute(CheckResponseList.class, get(Router.CHECKS, count, offset));
    }

    @Override
    public ListenableFuture<CheckResponseList> getChecks(final Filter filter) {
        return execute(CheckResponseList.class, get(Router.CHECKS, filter));
    }

    @Override
    public ListenableFuture<CheckDeleteResponse> deleteCheck(final CheckId id) {
        return execute(CheckDeleteResponse.class, delete(Router.CHECKS, id));
    }

    @Override
    public ListenableFuture<BankAccountResponse> createBankAccount(final BankAccountRequest bankAccountRequest) {
        return execute(BankAccountResponse.class, post(Router.BANK_ACCOUNTS, bankAccountRequest));
    }

    @Override
    public ListenableFuture<BankAccountResponse> getBankAccount(final BankAccountId id) {
        return execute(BankAccountResponse.class, get(Router.BANK_ACCOUNTS, id));
    }

    @Override
    public ListenableFuture<BankAccountResponseList> getBankAccounts() {
        return execute(BankAccountResponseList.class, get(Router.BANK_ACCOUNTS));
    }

    @Override
    public ListenableFuture<BankAccountResponseList> getBankAccounts(final int count) {
        return execute(BankAccountResponseList.class, get(Router.BANK_ACCOUNTS, count));
    }

    @Override
    public ListenableFuture<BankAccountResponseList> getBankAccounts(final int count, final int offset) {
        return execute(BankAccountResponseList.class, get(Router.BANK_ACCOUNTS, count, offset));
    }

    @Override
    public ListenableFuture<BankAccountResponseList> getBankAccounts(final Filter filter) {
        return execute(BankAccountResponseList.class, get(Router.BANK_ACCOUNTS, filter));
    }

    @Override
    public ListenableFuture<BankAccountDeleteResponse> deleteBankAccount(final BankAccountId id) {
        return execute(BankAccountDeleteResponse.class, delete(Router.BANK_ACCOUNTS, id));
    }

    @Override
    public ListenableFuture<BankAccountResponse> verifyBankAccount(final BankAccountVerifyRequest request) {
        return execute(
            BankAccountResponse.class,
            post(Router.BANK_ACCOUNTS + "/" + request.getId().value() + "/verify", request));
    }

    @Override
    public ListenableFuture<AreaMailResponse> createAreaMail(final AreaMailRequest areaMailRequest) {
        return execute(AreaMailResponse.class, post(Router.AREA_MAIL, areaMailRequest));
    }

    @Override
    public ListenableFuture<AreaMailResponse> getAreaMail(final AreaMailId id) {
        return execute(AreaMailResponse.class, get(Router.AREA_MAIL, id));
    }

    @Override
    public ListenableFuture<AreaMailResponseList> getAreaMails() {
        return execute(AreaMailResponseList.class, get(Router.AREA_MAIL));
    }

    @Override
    public ListenableFuture<AreaMailResponseList> getAreaMails(final int count) {
        return execute(AreaMailResponseList.class, get(Router.AREA_MAIL, count));
    }

    @Override
    public ListenableFuture<AreaMailResponseList> getAreaMails(final int count, final int offset) {
        return execute(AreaMailResponseList.class, get(Router.AREA_MAIL, count, offset));
    }

    @Override
    public ListenableFuture<AreaMailResponseList> getAreaMails(final Filter filter) {
        return execute(AreaMailResponseList.class, get(Router.AREA_MAIL, filter));
    }

    @Override
    public ListenableFuture<ZipCodeRouteResponseList> getZipCodeRoutes(final ZipCodeRouteRequest request) {
        return execute(ZipCodeRouteResponseList.class, get(Router.ROUTES, request));
    }

    @Override
    public ListenableFuture<VerifyAddressResponse> verifyAddress(final VerifyAddressRequest request) {
        return execute(VerifyAddressResponse.class, post(Router.VERIFY, request));
    }

    @Override
    public ListenableFuture<CountryResponseList> getCountries() {
        return execute(CountryResponseList.class, get(Router.COUNTRIES));
    }

    @Override
    public ListenableFuture<StateResponseList> getStates() {
        return execute(StateResponseList.class, get(Router.STATES));
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

    private final static Escaper urlEscaper = UrlEscapers.urlFormParameterEscaper();

    private BoundRequestBuilder get(final String resourceUrl, final Filter filter) {
        final FluentStringsMap paramMap = new FluentStringsMap();
        final Integer limit = filter.getLimit();
        if (limit != null) {
            paramMap.add("limit", Integer.toString(limit));
        }

        final Integer offset = filter.getOffset();
        if (offset != null) {
            paramMap.add("offset", Integer.toString(offset));
        }

        final Map<String, String> metadata = filter.getMetadata();
        if (metadata != null) {
            for (final Map.Entry<String, String> e : metadata.entrySet()) {
                paramMap.add("metadata[" + urlEscaper.escape(e.getKey()) + "]", urlEscaper.escape(e.getValue()));
            }
        }

        return get(resourceUrl, paramMap);
    }

    private BoundRequestBuilder get(final String resourceUrl, final int count) {
        return get(resourceUrl, Filters.ofLimit(count));
    }

    private BoundRequestBuilder get(final String resourceUrl, final int count, final int offset) {
        return get(resourceUrl, Filters.ofLimit(count).withOffset(offset));
    }

    private BoundRequestBuilder get(final String resourceUrl, final FluentStringsMap params) {
        return this.httpClient.prepareGet(this.baseUrl + resourceUrl).setQueryParams(params);
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
                    builder.addFormParam(param.getName(), s);
                }
            }
        }
        return builder;
    }

    private static <T extends AbstractResponse> ListenableFuture<T> execute(
            final Class<T> clazz,
            final BoundRequestBuilder request) {
        final SettableFuture<T> guavaFut = SettableFuture.create();
        final Optional<String> apiVersionOpt = Lob.getApiVersion();
        String wrapperVersion;

        if (apiVersionOpt.isPresent()) {
            request.addHeader(LobClient.LOB_VERSION_HEADER, apiVersionOpt.get());
        }

        try {
            Properties prop = new Properties();
            prop.load(AsyncLobClient.class.getClassLoader().getResourceAsStream("project.properties"));
            wrapperVersion = prop.getProperty("version");
        } catch (IOException e) {
            wrapperVersion = "";
        }

        request.addHeader("user-agent", new StringBuilder().append("LobJava/").append(wrapperVersion).append(" JDK/").append(JAVA_VERSION).toString());

        request.execute(new GuavaFutureConverter<T>(clazz, guavaFut));

        return guavaFut;
    }

    private static class GuavaFutureConverter<T extends AbstractResponse> extends AsyncCompletionHandler<T> {
        final Class<T> clazz;
        final SettableFuture<T> guavaFut;

        public GuavaFutureConverter(
                final Class<T> clazz,
                final SettableFuture<T> guavaFut) {
            this.clazz = clazz;
            this.guavaFut = guavaFut;
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

                value.setStatusCode(response.getStatusCode());
                value.setHeaders(response.getHeaders());

                guavaFut.set(value);
                return value;
            }
            else {
                final ErrorResponse error = MAPPER.readValue(response.getResponseBody(), ErrorResponse.class);
                final LobApiException exception = new LobApiException(response.getUri(), error, response.getStatusCode(), response.getHeaders());
                guavaFut.setException(exception);
                throw exception;
            }
        }
    }
}

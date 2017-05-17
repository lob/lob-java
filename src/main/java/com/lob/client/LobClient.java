package com.lob.client;

import com.google.common.util.concurrent.ListenableFuture;
import com.lob.id.AddressId;
import com.lob.id.AreaMailId;
import com.lob.id.BankAccountId;
import com.lob.id.CheckId;
import com.lob.id.LetterId;
import com.lob.id.PostcardId;
import com.lob.protocol.request.*;
import com.lob.protocol.response.*;

public interface LobClient {
    public final static String LOB_VERSION_HEADER = "Lob-Version";

    public void close();

    public void closeAsynchronously();

    // Address methods
    public ListenableFuture<AddressResponse> createAddress(final AddressRequest addressRequest);

    public ListenableFuture<AddressResponse> getAddress(final AddressId id);

    public ListenableFuture<AddressResponseList> getAddresses();

    @Deprecated
    public ListenableFuture<AddressResponseList> getAddresses(final int count);

    @Deprecated
    public ListenableFuture<AddressResponseList> getAddresses(final int count, final int offset);

    public ListenableFuture<AddressResponseList> getAddresses(final Filter filter);

    public ListenableFuture<AddressDeleteResponse> deleteAddress(final AddressId id);

    // Letter methods
    public ListenableFuture<LetterResponse> createLetter(final LetterRequest letterRequest);

    public ListenableFuture<LetterResponse> getLetter(final LetterId id);

    public ListenableFuture<LetterResponseList> getLetters();

    @Deprecated
    public ListenableFuture<LetterResponseList> getLetters(final int count);

    @Deprecated
    public ListenableFuture<LetterResponseList> getLetters(final int count, final int offset);

    public ListenableFuture<LetterResponseList> getLetters(final Filter filter);

    public ListenableFuture<LetterDeleteResponse> deleteLetter(final LetterId id);

    // Postcard methods
    public ListenableFuture<PostcardResponse> createPostcard(final PostcardRequest postcardRequest);

    public ListenableFuture<PostcardResponse> getPostcard(final PostcardId id);

    public ListenableFuture<PostcardResponseList> getPostcards();

    @Deprecated
    public ListenableFuture<PostcardResponseList> getPostcards(final int count);

    @Deprecated
    public ListenableFuture<PostcardResponseList> getPostcards(final int count, final int offset);

    public ListenableFuture<PostcardResponseList> getPostcards(final Filter filter);

    public ListenableFuture<PostcardDeleteResponse> deletePostcard(final PostcardId id);

    // Check methods
    public ListenableFuture<CheckResponse> createCheck(final CheckRequest checkRequest);

    public ListenableFuture<CheckResponse> getCheck(final CheckId id);

    public ListenableFuture<CheckResponseList> getChecks();

    @Deprecated
    public ListenableFuture<CheckResponseList> getChecks(final int count);

    @Deprecated
    public ListenableFuture<CheckResponseList> getChecks(final int count, final int offset);

    public ListenableFuture<CheckResponseList> getChecks(final Filter filter);

    public ListenableFuture<CheckDeleteResponse> deleteCheck(final CheckId id);

    // Bank account methods
    public ListenableFuture<BankAccountResponse> createBankAccount(final BankAccountRequest bankAccountRequest);

    public ListenableFuture<BankAccountResponse> getBankAccount(final BankAccountId id);

    public ListenableFuture<BankAccountResponseList> getBankAccounts();

    @Deprecated
    public ListenableFuture<BankAccountResponseList> getBankAccounts(final int count);

    @Deprecated
    public ListenableFuture<BankAccountResponseList> getBankAccounts(final int count, final int offset);

    public ListenableFuture<BankAccountResponseList> getBankAccounts(final Filter filter);

    public ListenableFuture<BankAccountDeleteResponse> deleteBankAccount(final BankAccountId id);

    public ListenableFuture<BankAccountResponse> verifyBankAccount(final BankAccountVerifyRequest request);

    // Area mail methods
    public ListenableFuture<AreaMailResponse> createAreaMail(final AreaMailRequest areaMailRequest);

    public ListenableFuture<AreaMailResponse> getAreaMail(final AreaMailId id);

    public ListenableFuture<AreaMailResponseList> getAreaMails();

    @Deprecated
    public ListenableFuture<AreaMailResponseList> getAreaMails(final int count);

    @Deprecated
    public ListenableFuture<AreaMailResponseList> getAreaMails(final int count, final int offset);

    public ListenableFuture<AreaMailResponseList> getAreaMails(final Filter filter);

    public ListenableFuture<ZipCodeRouteResponseList> getZipCodeRoutes(final ZipCodeRouteRequest request);

    public ListenableFuture<USVerificationResponse> verifyUSAddress(final USVerificationRequest request);

    public ListenableFuture<IntlVerificationResponse> verifyIntlAddress(final IntlVerificationRequest request);

    // Resources
    public ListenableFuture<CountryResponseList> getCountries();

    public ListenableFuture<StateResponseList> getStates();

}

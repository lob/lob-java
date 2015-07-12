package com.lob.client;

import com.google.common.util.concurrent.ListenableFuture;
import com.lob.id.AddressId;
import com.lob.id.AreaMailId;
import com.lob.id.BankAccountId;
import com.lob.id.CheckId;
import com.lob.id.JobId;
import com.lob.id.LetterId;
import com.lob.id.LobObjectId;
import com.lob.id.PostcardId;
import com.lob.id.SettingId;
import com.lob.protocol.request.*;
import com.lob.protocol.response.*;

import java.util.Map;

public interface LobClient {
    public final static String LOB_VERSION_HEADER = "Lob-Version";

    // Job methods
    public ListenableFuture<JobResponse> createJob(final JobRequest jobRequest);

    public ListenableFuture<JobResponse> getJob(final JobId id);

    public ListenableFuture<JobResponseList> getJobs();

    @Deprecated
    public ListenableFuture<JobResponseList> getJobs(final int count);

    @Deprecated
    public ListenableFuture<JobResponseList> getJobs(final int count, final int offset);

    public ListenableFuture<JobResponseList> getJobs(final Filter filter);

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

    // Object methods
    public ListenableFuture<LobObjectResponse> createLobObject(final LobObjectRequest lobObjectRequest);

    public ListenableFuture<LobObjectResponse> getLobObject(final LobObjectId id);

    public ListenableFuture<LobObjectResponseList> getLobObjects();

    @Deprecated
    public ListenableFuture<LobObjectResponseList> getLobObjects(final int count);

    @Deprecated
    public ListenableFuture<LobObjectResponseList> getLobObjects(final int count, final int offset);

    public ListenableFuture<LobObjectResponseList> getLobObjects(final Filter filter);

    public ListenableFuture<LobObjectDeleteResponse> deleteLobObject(final LobObjectId id);

    // Setting methods
    public ListenableFuture<SettingResponse> getSetting(final SettingId id);

    public ListenableFuture<SettingResponseList> getSettings();

    // Service methods
    public ListenableFuture<ServiceResponseList> getServices();

    // Letter methods
    public ListenableFuture<LetterResponse> createLetter(final LetterRequest letterRequest);

    public ListenableFuture<LetterResponse> getLetter(final LetterId id);

    public ListenableFuture<LetterResponseList> getLetters();

    @Deprecated
    public ListenableFuture<LetterResponseList> getLetters(final int count);

    @Deprecated
    public ListenableFuture<LetterResponseList> getLetters(final int count, final int offset);

    public ListenableFuture<LetterResponseList> getLetters(final Filter filter);

    // Postcard methods
    public ListenableFuture<PostcardResponse> createPostcard(final PostcardRequest postcardRequest);

    public ListenableFuture<PostcardResponse> getPostcard(final PostcardId id);

    public ListenableFuture<PostcardResponseList> getPostcards();

    @Deprecated
    public ListenableFuture<PostcardResponseList> getPostcards(final int count);

    @Deprecated
    public ListenableFuture<PostcardResponseList> getPostcards(final int count, final int offset);

    public ListenableFuture<PostcardResponseList> getPostcards(final Filter filter);

    // Check methods
    public ListenableFuture<CheckResponse> createCheck(final CheckRequest checkRequest);

    public ListenableFuture<CheckResponse> getCheck(final CheckId id);

    public ListenableFuture<CheckResponseList> getChecks();

    @Deprecated
    public ListenableFuture<CheckResponseList> getChecks(final int count);

    @Deprecated
    public ListenableFuture<CheckResponseList> getChecks(final int count, final int offset);

    public ListenableFuture<CheckResponseList> getChecks(final Filter filter);

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

    // Address verification methods
    public ListenableFuture<VerifyAddressResponse> verifyAddress(final VerifyAddressRequest request);

    // Resources
    public ListenableFuture<CountryResponseList> getCountries();

    public ListenableFuture<StateResponseList> getStates();

}

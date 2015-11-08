package com.lob.protocol.request;

import com.lob.Or;
import com.lob.id.AddressId;
import com.lob.id.BankAccountId;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

import java.io.File;
import java.util.Collection;
import java.util.Map;

import static com.lob.Util.checkNotNull;

public class CheckRequest extends AbstractDataFieldRequest implements HasLobParams {
    public static final String LOGO = "logo";
    public static final String FILE = "file";

    private final Integer checkNumber; // optional parameter, needs to be null if not set
    private final BankAccountId bankAccount;
    private final Or<AddressId, AddressRequest> to;
    private final Or<AddressId, AddressRequest> from;
    private final Money amount;
    private final String message;
    private final String memo;
    private final LobParam logo;
    private final LobParam file;

    public CheckRequest(
            final Integer checkNumber,
            final BankAccountId bankAccount,
            final Or<AddressId, AddressRequest> to,
            final Or<AddressId, AddressRequest> from,
            final Money amount,
            final String message,
            final String memo,
            final LobParam logo,
            final LobParam file,
            final Map<String, String> metadata,
            final Map<String, String> data,
            final String description) {
        super(metadata, data, description);
        this.checkNumber = checkNumber;
        this.bankAccount = checkNotNull(bankAccount, "bank account is required");
        this.to = checkNotNull(to, "to is required");
        this.from = checkNotNull(from, "from is required");
        this.amount = checkNotNull(amount, "amount is required");
        this.message = message;
        this.memo = memo;
        this.logo = logo;
        this.file = file;
    }

    @Override
    public Collection<LobParam> getLobParams() {
        return super.beginParams()
            .put("check_number", checkNumber)
            .put("bank_account", bankAccount)
            .put("to", to)
            .put("from", from)
            .put("amount", amount)
            .put("message", message)
            .put("memo", memo)
            .put(logo)
            .put(file)
            .build();
    }

    public Integer getCheckNumber() {
        return checkNumber;
    }

    public BankAccountId getBankAccount() {
        return bankAccount;
    }

    public Or<AddressId, AddressRequest> getTo() {
        return to;
    }

    public Or<AddressId, AddressRequest> getFrom() {
        return from;
    }

    public Money getAmount() {
        return amount;
    }

    public String getMessage() {
        return message;
    }

    public String getMemo() {
        return memo;
    }

    public LobParam getLogo() {
        return logo;
    }

    public LobParam getFile() {
        return file;
    }

    @Override
    public String toString() {
        return "CheckRequest{" +
            "checkNumber=" + checkNumber +
            ", bankAccount=" + bankAccount +
            ", to=" + to +
            ", from=" + from +
            ", amount=" + amount +
            ", message='" + message + '\'' +
            ", memo='" + memo + '\'' +
            ", logo='" + logo + '\'' +
            ", file='" + file + '\'' +
            super.toString();
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder extends AbstractDataFieldRequest.Builder<Builder> {
        private Integer checkNumber;
        private BankAccountId bankAccount;
        private Or<AddressId, AddressRequest> to;
        private Or<AddressId, AddressRequest> from;
        private Money amount;
        private String message;
        private String memo;
        private LobParam logo;
        private LobParam file;

        private Builder() {}

        public Builder checkNumber(final Integer checkNumber) {
            this.checkNumber = checkNumber;
            return this;
        }

        public Builder bankAccount(final BankAccountId bankAccount) {
            this.bankAccount = bankAccount;
            return this;
        }

        public Builder to(final AddressId to) {
            this.to = Or.typeA(to);
            return this;
        }

        public Builder to(final AddressRequest to) {
            this.to = Or.typeB(to);
            return this;
        }

        public Builder to(final Or<AddressId, AddressRequest> to) {
            this.to = to;
            return this;
        }

        public Builder from(final AddressId from) {
            this.from = Or.typeA(from);
            return this;
        }

        public Builder from(final AddressRequest from) {
            this.from = Or.typeB(from);
            return this;
        }

        public Builder from(final Or<AddressId, AddressRequest> from) {
            this.from = from;
            return this;
        }

        public Builder amount(final long amount) {
            this.amount = Money.of(CurrencyUnit.USD, amount);
            return this;
        }

        public Builder amount(final double amount) {
            this.amount = Money.of(CurrencyUnit.USD, amount);
            return this;
        }

        public Builder amount(final Money amount) {
            this.amount = amount;
            return this;
        }

        public Builder message(final String message) {
            this.message = message;
            return this;
        }

        public Builder memo(final String memo) {
            this.memo = memo;
            return this;
        }

        public Builder logo(final String logo) {
            this.logo = LobParam.strings(LOGO, logo);
            return this;
        }

        public Builder logo(final File logo) {
            this.logo = LobParam.file(LOGO, logo);
            return this;
        }

        public Builder logo(final LobParam logo) {
            this.logo = logo;
            return this;
        }

        public Builder file(final String file) {
            this.file = LobParam.strings(FILE, file);
            return this;
        }

        public Builder file(final File file) {
            this.file = LobParam.file(FILE, file);
            return this;
        }

        public Builder file(final LobParam file) {
            this.file = file;
            return this;
        }

        public Builder butWith() {
            return new Builder()
                .checkNumber(checkNumber)
                .bankAccount(bankAccount)
                .to(to)
                .from(from)
                .amount(amount)
                .message(message)
                .memo(memo)
                .logo(logo)
                .file(file)
                .metadata(metadata)
                .data(data)
                .description(description);
        }

        public CheckRequest build() {
            return new CheckRequest(checkNumber, bankAccount, to, from, amount, message, memo, logo, file, metadata, data, description);
        }
    }
}

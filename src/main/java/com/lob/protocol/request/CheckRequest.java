package com.lob.protocol.request;

import com.lob.Or;
import com.lob.id.AddressId;
import com.lob.id.BankAccountId;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.joda.time.DateTime;
import org.joda.time.format.ISODateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.io.File;
import java.util.Collection;
import java.util.Map;

import static com.lob.Util.checkNotNull;

public class CheckRequest extends AbstractDataFieldRequest implements HasLobParams {
    public static final String LOGO = "logo";
    public static final String CHECK_BOTTOM = "check_bottom";
    public static final String ATTACHMENT = "attachment";

    private final Integer checkNumber; // optional parameter, needs to be null if not set
    private final BankAccountId bankAccount;
    private final Or<AddressId, AddressRequest> to;
    private final Or<AddressId, AddressRequest> from;
    private final Money amount;
    private final String message;
    private final String memo;
    private final LobParam logo;
    private final LobParam checkBottom;
    private final LobParam attachment;
    private final String mailType;
    private final String sendDate;

    public CheckRequest(
            final Integer checkNumber,
            final BankAccountId bankAccount,
            final Or<AddressId, AddressRequest> to,
            final Or<AddressId, AddressRequest> from,
            final Money amount,
            final String message,
            final String memo,
            final LobParam logo,
            final LobParam checkBottom,
            final LobParam attachment,
            final String sendDate,
            final String mailType,
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
        this.checkBottom = checkBottom;
        this.attachment = attachment;
        this.mailType = mailType;
        this.sendDate = sendDate;
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
            .put(checkBottom)
            .put(attachment)
            .put("mail_type", mailType)
            .put("send_date", sendDate)
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

    @Deprecated
    public LobParam getFile() {
        return getCheckBottom();
    }

    public LobParam getCheckBottom() {
        return checkBottom;
    }

    public LobParam getAttachment() {
        return attachment;
    }

    public String getMailType() {
        return mailType;
    }

    public String getSendDate() {
        return sendDate;
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
            ", checkBottom='" + checkBottom + '\'' +
            ", attachment='" + attachment + '\'' +
            ", mailType='" + mailType + '\'' +
            ", sendDate='" + sendDate + '\'' +
            super.toString();
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder extends AbstractDataFieldRequest.Builder<Builder> {
        private final static DateTimeFormatter DATE_FORMAT = ISODateTimeFormat.dateTime();

        private Integer checkNumber;
        private BankAccountId bankAccount;
        private Or<AddressId, AddressRequest> to;
        private Or<AddressId, AddressRequest> from;
        private Money amount;
        private String message;
        private String memo;
        private LobParam logo;
        private LobParam checkBottom;
        private LobParam attachment;
        private String mailType;
        private String sendDate;

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

        @Deprecated
        public Builder file(final String file) {
            return this.checkBottom(file);
        }

        @Deprecated
        public Builder file(final File file) {
            return this.checkBottom(file);
        }

        @Deprecated
        public Builder file(final LobParam file) {
            return this.checkBottom(file);
        }

        public Builder checkBottom(final String checkBottom) {
            this.checkBottom = LobParam.strings(CHECK_BOTTOM, checkBottom);
            return this;
        }

        public Builder checkBottom(final File checkBottom) {
            this.checkBottom = LobParam.file(CHECK_BOTTOM, checkBottom);
            return this;
        }

        public Builder checkBottom(final LobParam checkBottom) {
            this.checkBottom = checkBottom;
            return this;
        }

        public Builder attachment(final String attachment) {
            this.attachment = LobParam.strings(ATTACHMENT, attachment);
            return this;
        }

        public Builder attachment(final File attachment) {
            this.attachment = LobParam.file(ATTACHMENT, attachment);
            return this;
        }

        public Builder attachment(final LobParam attachment) {
            this.attachment = attachment;
            return this;
        }

        public Builder mailType(final String mailType) {
            this.mailType = mailType;
            return this;
        }

        public Builder sendDate(final DateTime sendDate) {
            this.sendDate = sendDate.toString(DATE_FORMAT);
            return this;
        }

        public Builder sendDate(final String sendDate) {
            this.sendDate = sendDate;
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
                .checkBottom(checkBottom)
                .attachment(attachment)
                .sendDate(sendDate)
                .mailType(mailType)
                .metadata(metadata)
                .data(data)
                .description(description);
        }

        public CheckRequest build() {
            return new CheckRequest(checkNumber, bankAccount, to, from, amount, message, memo, logo, checkBottom, attachment, sendDate, mailType, metadata, data, description);
        }
    }
}

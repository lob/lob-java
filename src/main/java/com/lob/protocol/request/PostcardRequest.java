package com.lob.protocol.request;

import com.lob.Or;
import com.lob.id.AddressId;
import org.joda.time.DateTime;
import org.joda.time.format.ISODateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.io.File;
import java.util.Collection;
import java.util.Map;

import static com.lob.Util.checkNotNull;

public class PostcardRequest extends AbstractDataFieldRequest implements HasLobParams {
    private final static String FRONT = "front";
    private final static String BACK = "back";

    private final Or<AddressId, AddressRequest> to;
    private final Or<AddressId, AddressRequest> from;
    private final String message;
    private final LobParam front;
    private final LobParam back;
    private final String size;
    private final String mailType;
    private final String sendDate;

    public PostcardRequest(
            final Or<AddressId, AddressRequest> to,
            final Or<AddressId, AddressRequest> from,
            final String message,
            final LobParam front,
            final LobParam back,
            final String size,
            final String mailType,
            final String sendDate,
            final Map<String, String> metadata,
            final Map<String, String> data,
            final String description) {

        super(metadata, data, description);
        this.to = checkNotNull(to, "to is required");
        this.from = from;
        this.message = message;
        this.front = checkNotNull(front, "front is required");
        this.back = back;
        this.size = size;
        this.mailType = mailType;
        this.sendDate = sendDate;
    }

    @Override
    public Collection<LobParam> getLobParams() {
        return super.beginParams()
            .put("to", to)
            .put("from", from)
            .put("message", message)
            .put("size", size)
            .put("mail_type", mailType)
            .put("send_date", sendDate)
            .put(front)
            .put(back)
            .build();
    }

    public Or<AddressId, AddressRequest> getTo() {
        return to;
    }

    public Or<AddressId, AddressRequest> getFrom() {
        return from;
    }

    public String getMessage() {
        return message;
    }

    public LobParam getFront() {
        return front;
    }

    public LobParam getBack() {
        return back;
    }

    public String getSize() {
      return size;
    }

    public String getMailType() {
        return mailType;
    }

    public String getSendDate() { return sendDate; }

    @Override
    public String toString() {
        return "PostcardRequest{" +
            "to=" + to +
            ", from=" + from +
            ", message='" + message + '\'' +
            ", front='" + front + '\'' +
            ", back='" + back + '\'' +
            ", size='" + size + '\'' +
            ", mailType='" + mailType + '\'' +
            ", sendDate='" + sendDate + '\'' +
            super.toString();
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder extends AbstractDataFieldRequest.Builder<Builder> {
        private final static DateTimeFormatter DATE_FORMAT = ISODateTimeFormat.dateTime();

        private Or<AddressId, AddressRequest> to;
        private Or<AddressId, AddressRequest> from;
        private String message;
        private LobParam front;
        private LobParam back;
        private String size;
        private String mailType;
        private String sendDate;

        private Builder() {}

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

        public Builder message(final String message) {
            this.message = message;
            return this;
        }

        public Builder front(final String front) {
            this.front = LobParam.strings(FRONT, front);
            return this;
        }

        public Builder front(final File front) {
            this.front = LobParam.file(FRONT, front);
            return this;
        }

        public Builder front(final LobParam front) {
            this.front = front;
            return this;
        }

        public Builder back(final String back) {
            this.back = LobParam.strings(BACK, back);
            return this;
        }

        public Builder back(final File back) {
            this.back = LobParam.file(BACK, back);
            return this;
        }

        public Builder back(final LobParam back) {
            this.back = back;
            return this;
        }

        public Builder size(final String size) {
            this.size = size;
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
                .to(to)
                .from(from)
                .message(message)
                .front(front)
                .back(back)
                .size(size)
                .sendDate(sendDate)
                .mailType(mailType)
                .metadata(metadata)
                .data(data)
                .description(description);
        }

        public PostcardRequest build() {
            return new PostcardRequest(to, from, message, front, back, size, mailType, sendDate, metadata, data, description);
        }
    }
}

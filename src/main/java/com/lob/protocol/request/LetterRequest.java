package com.lob.protocol.request;

import com.lob.Or;
import com.lob.id.AddressId;
import java.io.File;
import java.util.Collection;
import java.util.Map;
import org.joda.time.DateTime;
import org.joda.time.format.ISODateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import static com.lob.Util.checkNotNull;

public class LetterRequest extends AbstractDataFieldRequest implements HasLobParams {
    private final static String FILE = "file";

    private final Or<AddressId, AddressRequest> to;
    private final Or<AddressId, AddressRequest> from;
    private final LobParam file;
    private final Boolean color;
    private final Boolean doubleSided;
    private final String addressPlacement;
    private final String extraService;
    private final Boolean returnEnvelope;
    private final Integer perforatedPage;
    private final String mailType;
    private final String sendDate;

    public LetterRequest(
            final String description,
            final Or<AddressId, AddressRequest> to,
            final Or<AddressId, AddressRequest> from,
            final LobParam file,
            final Boolean color,
            final Boolean doubleSided,
            final String addressPlacement,
            final String extraService,
            final Boolean returnEnvelope,
            final Integer perforatedPage,
            final String sendDate,
            final String mailType,
            final Map<String, String> metadata,
            final Map<String, String> data) {

        super(metadata, data, description);
        this.to = checkNotNull(to, "to is required");
        this.from = checkNotNull(from, "from is required");
        this.file = checkNotNull(file, "file is required");
        this.color = checkNotNull(color, "color is required");
        this.doubleSided = doubleSided;
        this.addressPlacement = addressPlacement;
        this.extraService = extraService;
        this.returnEnvelope = returnEnvelope;
        this.perforatedPage = perforatedPage;
        this.mailType = mailType;
        this.sendDate = sendDate;
    }

    @Override
    public Collection<LobParam> getLobParams() {
        return super.beginParams()
            .put("to", to)
            .put("from", from)
            .put(file)
            .put("color", color)
            .put("double_sided", doubleSided)
            .put("address_placement", addressPlacement)
            .put("extra_service", extraService)
            .put("return_envelope", returnEnvelope)
            .put("perforated_page", perforatedPage)
            .put("mail_type", mailType)
            .put("send_date", sendDate)
            .build();
    }

    public Or<AddressId, AddressRequest> getTo() { return to; }

    public Or<AddressId, AddressRequest> getFrom() { return from; }

    public LobParam getFile() { return file; }

    public Boolean isColor() { return color; }

    public Boolean isDoubleSided() { return doubleSided; }

    public String getAddressPlacement() { return addressPlacement; }

    public String getExtraService() { return extraService; }

    public Boolean isReturnEnvelope() { return returnEnvelope; }

    public Integer getPerforatedPage() { return perforatedPage; }

    public String getMailType() { return mailType; }

    public String getSendDate() { return sendDate; }

    @Override
    public String toString() {
        return "LetterRequest{" +
            "to=" + to +
            ", from=" + from +
            ", file=" + file +
            ", color=" + color +
            ", doubleSided=" + doubleSided +
            ", addressPlacement=" + addressPlacement +
            ", extraService=" + extraService +
            ", returnEnvelope=" + returnEnvelope +
            ", perforatedPage=" + perforatedPage +
            ", mailType=" + mailType +
            ", sendDate='" + sendDate + '\'' +
            super.toString();
    }

    public static Builder builder() { return new Builder(); }

    public static class Builder extends AbstractDataFieldRequest.Builder<Builder> {
        private final static DateTimeFormatter DATE_FORMAT = ISODateTimeFormat.dateTime();

        private Or<AddressId, AddressRequest> to;
        private Or<AddressId, AddressRequest> from;
        private LobParam file;
        private Boolean color;
        private Boolean doubleSided;
        private String addressPlacement;
        private String extraService;
        private Boolean returnEnvelope;
        private Integer perforatedPage;
        private String mailType;
        private String sendDate;

        private Builder() {}

        public Builder description(final String description) {
            this.description = description;
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

        public Builder color(final Boolean color) {
            this.color = color;
            return this;
        }

        public Builder doubleSided(final Boolean doubleSided) {
            this.doubleSided = doubleSided;
            return this;
        }

        public Builder addressPlacement(final String addressPlacement) {
            this.addressPlacement = addressPlacement;
            return this;
        }

        public Builder extraService(final String extraService) {
            this.extraService = extraService;
            return this;
        }

        public Builder returnEnvelope(final Boolean returnEnvelope) {
            this.returnEnvelope = returnEnvelope;
            return this;
        }

        public Builder perforatedPage(final Integer perforatedPage) {
            this.perforatedPage = perforatedPage;
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
                .description(description)
                .to(to)
                .from(from)
                .file(file)
                .color(color)
                .doubleSided(doubleSided)
                .addressPlacement(addressPlacement)
                .extraService(extraService)
                .returnEnvelope(returnEnvelope)
                .perforatedPage(perforatedPage)
                .sendDate(sendDate)
                .mailType(mailType)
                .metadata(metadata)
                .data(data);
        }

        public LetterRequest build() {
            return new LetterRequest(description, to, from, file, color, doubleSided, addressPlacement, extraService, returnEnvelope, perforatedPage, sendDate, mailType, metadata, data);
        }
    }
}
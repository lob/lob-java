package com.lob.protocol.request;

import com.lob.LobParamsBuilder;
import com.lob.OrCollection;
import com.lob.id.StringId;
import com.lob.id.ZipCode;
import com.lob.id.ZipCodeRouteId;
import com.lob.protocol.response.ZipCodeRouteResponseList;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import static com.lob.Util.checkNotNull;
import static com.lob.Util.checkPresent;

public class AreaMailRequest extends AbstractDataFieldRequest implements HasLobParams {
    public static final String FRONT = "front";
    public static final String BACK = "back";
    private final String name;
    private final LobParam front;
    private final LobParam back;
    private final OrCollection<ZipCode, ZipCodeRouteId> routes;
    private final TargetType targetType;
    private final Boolean fullBleed;

    public AreaMailRequest(
            final String name,
            final LobParam front,
            final LobParam back,
            final OrCollection<ZipCode, ZipCodeRouteId> routes,
            final TargetType targetType,
            final Boolean fullBleed,
            final Map<String, String> metadata,
            final Map<String, String> data) {
        super(metadata, data);
        this.name = name;
        this.front = checkNotNull(front, "front is required");
        this.back = checkNotNull(back, "back is required");
        this.routes = checkPresent(routes, "routes is required");
        this.targetType = targetType;
        this.fullBleed = fullBleed;
    }

    @Override
    public Collection<LobParam> getLobParams() {
        return super.beginParams()
            .put("name", name)
            .putAllStringValued("routes", routes)
            .put("target_type", targetType)
            .put("full_bleed", fullBleed)
            .put(front)
            .put(back)
            .build();
    }

    public String getName() {
        return name;
    }

    public LobParam getFront() {
        return front;
    }

    public LobParam getBack() {
        return back;
    }

    public OrCollection<ZipCode, ZipCodeRouteId> getRoutes() {
        return routes;
    }

    public TargetType getTargetType() {
        return targetType;
    }

    public Boolean getFullBleed() {
        return fullBleed;
    }

    @Override
    public String toString() {
        return "AreaMailRequest{" +
            "name='" + name + '\'' +
            ", front='" + front + '\'' +
            ", back='" + back + '\'' +
            ", routes=" + routes +
            ", targetType=" + targetType +
            ", fullBleed=" + fullBleed +
            super.toString();
    }

    public static Builder builder() {
        return new Builder();
    }


    public static class Builder {
        private String name;
        private LobParam front;
        private LobParam back;
        private OrCollection<ZipCode, ZipCodeRouteId> routes;
        private TargetType targetType;
        private Boolean fullBleed;
        private Map<String, String> metadata;
        private Map<String, String> data;

        private Builder() {
        }

        public Builder name(final String name) {
            this.name = name;
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

        public Builder routesForZips(final String... zips) {
            return routesForStringZips(Arrays.asList(zips));
        }

        public Builder routesForStringZips(final Collection<String> zips) {
            final List<ZipCode> zipList = new ArrayList<ZipCode>(zips.size());
            for (final String zip : zips) {
                zipList.add(ZipCode.parse(zip));
            }
            this.routes = OrCollection.typeA(zipList);
            return this;
        }

        public Builder routesForZips(final ZipCode... zips) {
            this.routes = OrCollection.typeA(Arrays.asList(zips));
            return this;
        }

        public Builder routesForZips(final Collection<ZipCode> zips) {
            this.routes = OrCollection.typeA(zips);
            return this;
        }

        public Builder routesForIds(final ZipCodeRouteId... routes) {
            this.routes = OrCollection.typeB(Arrays.asList(routes));
            return this;
        }

        public Builder routesForIds(final Collection<ZipCodeRouteId> routes) {
            this.routes = OrCollection.typeB(routes);
            return this;
        }

        public Builder routes(final ZipCodeRouteResponseList zipCodeRoutes) {
            this.routes = OrCollection.typeB(zipCodeRoutes.toRequest());
            return this;
        }

        public Builder routes(final OrCollection<ZipCode, ZipCodeRouteId> routes) {
            this.routes = routes;
            return this;
        }

        public Builder targetType(final TargetType targetType) {
            this.targetType = targetType;
            return this;
        }

        public Builder fullBleed(final Boolean fullBleed) {
            this.fullBleed = fullBleed;
            return this;
        }

        public Builder metadata(final Map<String, String> metadata) {
            this.metadata = metadata;
            return this;
        }

        public Builder data(final Map<String, String> data) {
            this.data = data;
            return this;
        }

        public Builder butWith() {
            return new Builder()
                .name(name)
                .front(front)
                .back(back)
                .routes(routes)
                .targetType(targetType)
                .fullBleed(fullBleed)
                .metadata(metadata)
                .data(data);
        }

        public AreaMailRequest build() {
            return new AreaMailRequest(name, front, back, routes, targetType, fullBleed, metadata, data);
        }
    }
}

package com.lob;

import com.lob.exception.LobException;
import com.lob.exception.APIException;
import com.lob.Lob;
import com.lob.model.Area;
import com.lob.model.AreaCollection;
import java.util.HashMap;

import static org.fest.assertions.api.Assertions.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;

public class AreaTest {
    @BeforeClass
    public static void setUp() {
      Lob.apiKey = "test_0dc8d51e0acffcb1880e0f19c79b2f5b0cc";
    }

    @Test(expected=APIException.class)
    public void list_it_should_error_with_an_invalid_count_or_offset() throws LobException {
        AreaCollection areas = Area.list(1000, 0, Lob.apiKey);
    }

    @Test
    public void list_it_should_have_the_correct_defaults() throws LobException {
        AreaCollection areas = Area.list(null, null, Lob.apiKey);
        assertThat(areas.getObject()).isNotNull();
        assertThat(areas.getData()).isNotNull();
        assertThat(areas.getData().size()).isEqualTo(10);
        assertThat(areas.getCount()).isNotNull();
        assertThat(areas.getNext_url()).isNotNull();
        assertThat(areas.getNext_url()).isEqualTo("https://api.lob.com/" +
            "v1/areas?count=10&offset=10");
        assertThat(areas.getPrevious_url()).isNull();
        assertThat(areas.getObject()).isEqualTo("list");
        assertThat(areas.getCount()).isEqualTo(10);
    }

    @Test
    public void get_it_should_have_the_correct_defaults() throws LobException {
        Area area = Area.create(new HashMap<String, Object>() {{
            put("name", "Test Area");
            put("routes[0]", "94158-C001");
            put("routes[1]", "94107-C031");
            put("front", "https://s3-us-west-2.amazonaws.com/lob-assets/" +
                "areaback.pdf");
            put("back", "https://s3-us-west-2.amazonaws.com/lob-assets/" +
                "areaback.pdf");
        }}, Lob.apiKey);
        Area area2 = Area.retrieve(area.getId(), Lob.apiKey);
        assertThat(area2.getId()).isEqualTo(area.getId());
    }

    @Test
    public void create_it_should_succeed_using_address_and_remote_file() throws LobException {
        Area area = Area.create(new HashMap<String, Object>() {{
            put("name", "Test Area");
            put("routes[0]", "94158-C001");
            put("routes[1]", "94107-C031");
            put("front", "https://s3-us-west-2.amazonaws.com/lob-assets/" +
                "areaback.pdf");
            put("back", "https://s3-us-west-2.amazonaws.com/lob-assets/" +
                "areaback.pdf");
        }}, Lob.apiKey);
        assertThat(area.getName()).isEqualTo("Test Area");
        assertThat(area.getUrl()).startsWith("http://assets.lob.com/area_");
        assertThat(area.getStatus()).isEqualTo("processed");
        assertThat(area.getPrice()).isGreaterThan(0);
        assertThat(area.getTarget_type()).isEqualTo("all");
        assertThat(area.getAddresses()).isNull();
        assertThat(area.getZip_codes().get(0).getZip_code()).isEqualTo("94107");
        assertThat(area.getZip_codes().get(0).getObject()).isEqualTo("zip_code");
        assertThat(area.getZip_codes().get(0).getRoutes().get(0).getRoute()).isEqualTo("C031");
        assertThat(area.getZip_codes().get(0).getRoutes().get(0).getResidential()).isPositive();
        assertThat(area.getZip_codes().get(0).getRoutes().get(0).getBusiness()).isPositive();
        assertThat(area.getZip_codes().get(0).getRoutes().get(0).getObject()).isEqualTo("route");
        assertThat(area.getZip_codes().get(1).getZip_code()).isEqualTo("94158");
        assertThat(area.getDate_created()).isNotNull();
        assertThat(area.getDate_modified()).isNotNull();
        assertThat(area.getObject()).isEqualTo("area");
    }
}

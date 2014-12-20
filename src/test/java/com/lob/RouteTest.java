package com.lob;

import com.lob.exception.LobException;
import com.lob.exception.APIException;
import com.lob.Lob;
import com.lob.model.Route;
import com.lob.model.RouteCollection;
import java.util.Arrays;

import static org.fest.assertions.api.Assertions.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;

public class RouteTest {
    @BeforeClass
    public static void setUp() {
      Lob.apiKey = "test_0dc8d51e0acffcb1880e0f19c79b2f5b0cc";
    }

    @Test(expected=APIException.class)
    public void list_it_should_error_with_an_invalid_zip_code() throws LobException {
        Route.all(Arrays.asList("99999"), Lob.apiKey);
    }

    @Test
    public void list_it_should_have_the_correct_defaults() throws LobException {
        RouteCollection routes = Route.all(Arrays.asList("48168", "94158"), Lob.apiKey);
        assertThat(routes.getData()).isNotNull();
        assertThat(routes.getObject()).isEqualTo("list");
    }
}

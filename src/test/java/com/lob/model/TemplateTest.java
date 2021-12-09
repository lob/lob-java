package com.lob.model;

import com.lob.BaseTest;
import com.lob.exception.InvalidRequestException;
import com.lob.net.LobResponse;
import org.junit.Test;

import java.io.File;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.*;

public class TemplateTest extends BaseTest {

    @Test
    public void testCreateTemplate() throws Exception {
        LobResponse<Template> response = new Template.RequestBuilder()
                .setDescription("Test Template")
                .setHtml("<h1>Hello</h1>")
                .setEngine("handlebars")
                .create();

        Template template = response.getResponseBody();

        assertEquals(200, response.getResponseCode());
        assertNotNull(template.getId());
        assertNotNull(template.getPublishedVersion());
        Template.TemplateVersion published = template.getPublishedVersion();
        assertEquals(published.getHtml(), "<h1>Hello</h1>");
        assertEquals(published.getDescription(), "Test Template");
        assertEquals(published.getEngine(), "handlebars");
    }

    @Test
    public void testListTemplates() throws Exception {
        LobResponse<TemplateCollection> response = Template.list();

        assertEquals(200, response.getResponseCode());
        assertTrue(response.getResponseBody().getCount() > 0);
        assertThat(response.getResponseBody().getData().get(0), instanceOf(Template.class));
    }

    @Test
    public void testListTemplatesWithParams() throws Exception {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("limit", 1);

        LobResponse<TemplateCollection> response = Template.list(params);

        assertEquals(200, response.getResponseCode());
        assertEquals(1, response.getResponseBody().getCount());
        assertThat(response.getResponseBody().getData().get(0), instanceOf(Template.class));
    }

    @Test
    public void testRetrieveTemplate() throws Exception {
        Template testTemplate = Template.list().getResponseBody().getData().get(0);

        LobResponse<Template> response = Template.retrieve(testTemplate.getId());
        Template template = response.getResponseBody();

        assertEquals(testTemplate.getId(), template.getId());
    }
}

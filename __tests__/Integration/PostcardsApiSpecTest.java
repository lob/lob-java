package Integration;

import java.util.Map;
import java.util.List;

import com.google.gson.Gson;
import com.lob.api.ApiException;
import com.lob.api.Configuration;
import com.lob.api.client.PostcardsApi;
import com.lob.api.client.TemplatesApi;

import org.openapitools.client.model.Postcard;
import org.openapitools.client.model.PostcardList;
import org.openapitools.client.model.PostcardDeletion;
import org.openapitools.client.model.PostcardEditable;
import org.openapitools.client.model.Template;
import org.openapitools.client.model.TemplateWritable;
import org.openapitools.client.model.AddressEditable;
import org.openapitools.client.model.PostcardSize;
import org.openapitools.client.model.SendDate;
import org.openapitools.client.model.MailType;
import org.openapitools.client.model.SortBy5;

import org.testng.Assert;
import org.testng.annotations.*;

import Helper.*;

public class PostcardsApiSpecTest {
    private PostcardsApi validApi = new PostcardsApi(Configuration.getConfigForIntegration());
    private TestFixtures testFixtures = new TestFixtures();
    private PostcardEditable dummyPostcard = new PostcardEditable();;
    private List<AddressEditable> addressEditableList = testFixtures.get_ADDRESSES_EDITABLE();

    // values for postcardsList call
    private String nextUrl = "";
    private String previousUrl = "";

    private Integer limit = null;
    private String before = null;
    private String after = null;
    private List<String> include = null;
    private Map<String, String> dateCreated = null;
    private Map<String, String> metadata = null;
    private PostcardSize size = null;
    private Boolean scheduled = null;
    private Map<String, String> sendDate = null;
    private MailType mailType = null;
    private SortBy5 sortBy = null;

  // TODO:
  // all postcardCreate calls fail with JSON fails to deserialize the to attribute, failing with
  // `to address not found`
  // all postcardList calls fail because JSON fails to deserialize the send_date attribute, failing with
  // `Expected BEGIN_OBJECT but was STRING at line 70 column 27 path $.data[0].send_date`
  // suspect it's because SendDate is a bogus class

    @BeforeClass
    public void before_class() {
      Gson gson = new Gson();
        dummyPostcard.setTo(gson.toJson(addressEditableList.get(2)));
        dummyPostcard.setFrom(gson.toJson(addressEditableList.get(1)));
        dummyPostcard.setFront(testFixtures.get_FILE_LOCATION_4X6());
        dummyPostcard.setBack(testFixtures.get_FILE_LOCATION_4X6());
    }

    @Test(
        enabled=true,
        groups={"Integration", "Create", "Postcard", "Valid"}
    )
    public void postcardCreateRetrieveDeleteTest() throws ApiException {
        Postcard postcard = validApi.create(dummyPostcard, null);

        Assert.assertNotNull(postcard.getId());
        Assert.assertNotNull(postcard.getUrl());

        Postcard retrievedPostcard = validApi.get(postcard.getId());
        Assert.assertNotNull(retrievedPostcard);
        PostcardDeletion deletedPostcard = validApi.cancel(postcard.getId());
        Assert.assertTrue(deletedPostcard.getDeleted());
    }

    @Test(
        enabled=true,
        groups={"Integration", "Create", "Postcard", "Valid"}
    )
    public void postcardCreateTestWithTemplateId() throws ApiException {
        Gson gson = new Gson();
        TemplateWritable templateWrite = new TemplateWritable();
        templateWrite.setDescription("Newer Template");
        templateWrite.setHtml("<html>Updated HTML</html>");

        TemplatesApi templatesApi = new TemplatesApi(Configuration.getConfigForIntegration());
        Template createdTemplate = templatesApi.create(templateWrite);
        Assert.assertNotNull(createdTemplate.getId());

        PostcardEditable postcardWithTemplateIds = new PostcardEditable();
        postcardWithTemplateIds.setTo(gson.toJson(addressEditableList.get(2)));
        postcardWithTemplateIds.setFrom(gson.toJson(addressEditableList.get(1)));
        postcardWithTemplateIds.setFront(createdTemplate.getId());
        postcardWithTemplateIds.setBack(createdTemplate.getId());

        Postcard postcard = validApi.create(postcardWithTemplateIds, null);
        Assert.assertNotNull(postcard.getId());
        Assert.assertEquals(postcard.getFrontTemplateId(), createdTemplate.getId());
        Assert.assertEquals(postcard.getBackTemplateId(), createdTemplate.getId());
        Assert.assertNotNull(postcard.getUrl());

        // Clean up
        PostcardDeletion deletedPostcard = validApi.cancel(postcard.getId());
        Assert.assertTrue(deletedPostcard.getDeleted());

        templatesApi.delete(createdTemplate.getId());
    }

    @BeforeGroups("List")
    public void beforeListTests() throws ApiException {
        PostcardList response = validApi.list(limit, before, after, include, dateCreated, metadata, size, scheduled, sendDate, mailType, sortBy);
        nextUrl = response.getNextUrl().substring(response.getNextUrl().lastIndexOf("after=") + 6);

        PostcardList responseAfter = validApi.list(10, before, nextUrl, include, dateCreated, metadata, size, scheduled, sendDate, mailType, sortBy);
        previousUrl = responseAfter.getPreviousUrl().substring(
            responseAfter.getPreviousUrl().lastIndexOf("before=") + 7
        );
    }

    @Test(
        enabled=true,
        groups={"Integration", "List", "Postcard", "Valid"}
    )
    public void postcardListTest() throws ApiException {
        PostcardList response = validApi.list(limit, before, after, include, dateCreated, metadata, size, scheduled, sendDate, mailType, sortBy);

        Assert.assertNotNull(response.getData());

        List<Postcard> postcardList = response.getData();
        Assert.assertTrue(postcardList.size() > 0);
    }
}
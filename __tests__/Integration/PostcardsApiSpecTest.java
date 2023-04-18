package Integration;

import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.lob.api.ApiException;
import com.lob.api.Configuration;
import com.lob.api.client.PostcardsApi;
import com.lob.api.client.TemplatesApi;

import com.lob.model.AddressEditable;
import com.lob.model.MailType;
import com.lob.model.Postcard;
import com.lob.model.PostcardDeletion;
import com.lob.model.PostcardEditable;
import com.lob.model.PostcardList;
import com.lob.model.PostcardSize;
import com.lob.model.PscUseType;
import com.lob.model.SortBy3;
import com.lob.model.Template;
import com.lob.model.TemplateWritable;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

import Helper.TestFixtures;

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
    private SortBy3 sortBy = null;

    @BeforeClass
    public void before_class() {
      Gson gson = new Gson();
        dummyPostcard.setTo(addressEditableList.get(2));
        dummyPostcard.setFrom(gson.toJson(addressEditableList.get(1)));
        dummyPostcard.setFront(testFixtures.get_FILE_LOCATION_4X6());
        dummyPostcard.setUseType(PscUseType.MARKETING);
        dummyPostcard.setBack(testFixtures.get_FILE_LOCATION_4X6());
        dummyPostcard.setUseType(PscUseType.MARKETING);
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
        postcardWithTemplateIds.setUseType(PscUseType.MARKETING);

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
}
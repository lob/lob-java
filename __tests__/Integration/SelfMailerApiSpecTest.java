package Integration;

import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.lob.api.ApiException;
import com.lob.api.Configuration;
import com.lob.api.client.PostcardsApi;
import com.lob.api.client.SelfMailersApi;
import com.lob.api.client.TemplatesApi;

import com.lob.model.AddressEditable;
import com.lob.model.MailType;
import com.lob.model.Postcard;
import com.lob.model.PostcardDeletion;
import com.lob.model.PostcardEditable;
import com.lob.model.PostcardList;
import com.lob.model.PostcardSize;
import com.lob.model.SelfMailer;
import com.lob.model.SelfMailerDeletion;
import com.lob.model.SelfMailerEditable;
import com.lob.model.SfmUseType;
import com.lob.model.SortBy3;
import com.lob.model.Template;
import com.lob.model.TemplateWritable;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

import Helper.TestFixtures;

public class SelfMailerApiSpecTest {
    private SelfMailersApi validApi = new SelfMailersApi(Configuration.getConfigForIntegration());
    private TestFixtures testFixtures = new TestFixtures();
    private SelfMailerEditable dummySelfMailer = new SelfMailerEditable();;
    private List<AddressEditable> addressEditableList = testFixtures.get_ADDRESSES_EDITABLE();

    // // values for selfMailerList call
    // private String nextUrl = "";
    // private String previousUrl = "";

    // private Integer limit = null;
    // private String before = null;
    // private String after = null;
    // private List<String> include = null;
    // private Map<String, String> dateCreated = null;
    // private Map<String, String> metadata = null;
    // private PostcardSize size = null;
    // private Boolean scheduled = null;
    // private Map<String, String> sendDate = null;
    // private MailType mailType = null;
    // private SortBy3 sortBy = null;

    @BeforeClass
    public void before_class() {
      Gson gson = new Gson();
        dummySelfMailer.setTo(addressEditableList.get(2));
        dummySelfMailer.setFrom(gson.toJson(addressEditableList.get(1)));
        dummySelfMailer.setMailType(MailType.STANDARD);
        dummySelfMailer.setUseType(SfmUseType.MARKETING);
        dummySelfMailer.setOutside("outside fake");
        dummySelfMailer.setInside("inside fake");
    }

    @Test(
        enabled=true,
        groups={"Integration", "Create", "Postcard", "Valid"}
    )
    public void selfMailerCreateRetrieveDeleteTest() throws ApiException {
        Gson gson = new Gson();
        SelfMailer selfMailer = validApi.create(dummySelfMailer, null);

        Assert.assertNotNull(selfMailer.getId());
        Assert.assertNotNull(selfMailer.getUrl());

        SelfMailer retreieveSelfMailer = validApi.get(selfMailer.getId());
        Assert.assertNotNull(retreieveSelfMailer);
        SelfMailerDeletion deletedSelfMailer = validApi.delete(selfMailer.getId());
        Assert.assertTrue(deletedSelfMailer.getDeleted());
    }
}
package Integration;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.UnaryOperator;

import com.lob.api.ApiException;
import com.lob.api.Configuration;
import com.lob.api.client.CreativesApi;
import com.lob.api.client.CampaignsApi;
import com.lob.api.client.TemplatesApi;

import com.lob.model.CreativeResponse;
import com.lob.model.CreativeWritable;
import com.lob.model.Campaign;
import com.lob.model.CampaignWritable;
import com.lob.model.Template;
import com.lob.model.TemplateWritable;
import com.lob.model.Letter.AddressPlacementEnum;
import com.lob.model.CreativePatch;
import com.lob.model.CmpScheduleType;
import com.lob.model.CmpUseType;
import com.lob.model.AddressEditable;
import com.lob.model.PostcardDetailsWritable;
import com.lob.model.LetterDetailsWritable;
import com.lob.model.MailType;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeGroups;

public class CreativesApiSpecTest {

    private CreativesApi creativeApi;
    private CampaignsApi campaignApi;
    private TemplatesApi templateApi;
    private String cmpId;
    private String tmplId;
    private CreativeWritable pscCrvWritable;
    private CreativeWritable ltrCrvWritable;

    @BeforeClass
    public void before_class() throws Exception
    {
        creativeApi = new CreativesApi(Configuration.getConfigForIntegration());

        campaignApi = new CampaignsApi(Configuration.getConfigForIntegration());
        Date date = new Date();
      //This method returns the time in millis
        long timeMilli = date.getTime();
        CampaignWritable cmpWritable = new CampaignWritable();
        cmpWritable.setName("Campaign for Java Creative Test " + timeMilli);
        cmpWritable.setScheduleType(CmpScheduleType.IMMEDIATE);
        cmpWritable.setUseType(CmpUseType.MARKETING);

        Campaign campaign = new Campaign();
        campaign.setUseType(CmpUseType.MARKETING);
        try {
          campaign = campaignApi.create(cmpWritable, null);
        } catch (Exception e) {
          throw new Exception("Failed to create campaign: " + e.getMessage());
        }
        cmpId = campaign.getId();

        templateApi = new TemplatesApi(Configuration.getConfigForIntegration());

        TemplateWritable templateWritable = new TemplateWritable();
        templateWritable.setDescription("Test Template for Java Creative Test");
        templateWritable.setHtml("<html>Updated HTML</html>");

        Template template = new Template();
        try {
          template = templateApi.create(templateWritable);
        } catch (Exception e) {
          throw new Exception("Failed to create template: " + e.getMessage());
        }
        tmplId = template.getId();

        AddressEditable from = new AddressEditable();
        from.setName("FESTER");
        from.setAddressLine1("001 CEMETERY LN");
        from.setAddressLine2("SUITE 666");
        from.setAddressCity("WESTFIELD");
        from.setAddressState("NJ");
        from.setAddressZip("07000");

        pscCrvWritable = new CreativeWritable();
        pscCrvWritable.setFrom(from);
        pscCrvWritable.setCampaignId(cmpId);
        pscCrvWritable.setResourceType(CreativeWritable.ResourceTypeEnum.POSTCARD);
        pscCrvWritable.setDetails(new PostcardDetailsWritable());
        pscCrvWritable.setFront(tmplId);
        pscCrvWritable.setBack(tmplId);

        ltrCrvWritable = new CreativeWritable();
        ltrCrvWritable.setFrom(from);
        ltrCrvWritable.setCampaignId(cmpId);
        ltrCrvWritable.setResourceType(CreativeWritable.ResourceTypeEnum.LETTER);
        LetterDetailsWritable letterDetails = new LetterDetailsWritable();
        List<String> cards = new ArrayList<String>();
        cards.add("card_43767b6ea0e1efe");
        letterDetails.setCards(cards);
        letterDetails.setColor(false);
        // letterDetails.setAddressPlacement(LetterDetailsWritable.AddressPlacementEnum.BOTTOM_FIRST_PAGE);
        // letterDetails.setMailType(MailType.FIRST_CLASS);
        ltrCrvWritable.setDetails(letterDetails);
        System.out.println("hellp");
    }

    @AfterClass
    public void after_class()
    {
        try {
          campaignApi.delete(cmpId);
        } catch (Exception e) {
          Assert.fail("Deleting Campaign after has failed");
        }

        try {
          templateApi.delete(tmplId);
        } catch (Exception e) {
          Assert.fail("Deleting Template after has failed");
        }
    }

    // @Test(
    //     enabled=true,
    //     groups={"Integration", "Create", "Creative", "Valid"}
    // )
    // public void createPscCreativeTest() throws ApiException {
    //     CreativeResponse response = creativeApi.create(pscCrvWritable, null);

    //     Assert.assertNotNull(response.getId());
    // }

    @Test(
        enabled=true,
        groups={"Integration", "Create", "Creative", "Valid"}
    )
    public void createLtrCreativeTest() throws ApiException {
        CreativeResponse response = creativeApi.create(ltrCrvWritable, null);

        Assert.assertNotNull(response.getId());
    }

    // @Test(
    //     enabled=true,
    //     groups={"Integration", "Retrieve", "Creative", "Valid"}
    // )
    // public void creativeRetrieveTest() throws ApiException {
    //     CreativeResponse creative = creativeApi.create(pscCrvWritable, null);

    //     CreativeResponse response = creativeApi.get(creative.getId());

    //     Assert.assertNotNull(response.getId());
    //     Assert.assertEquals(response.getId(), creative.getId());
    // }

    @Test(
        enabled=false,
        groups={"Integration", "Update", "Creative", "Valid"}
    )
    public void CreativeUpdateTest() throws ApiException {
        CreativeResponse creative = creativeApi.create(pscCrvWritable, null);

        CreativePatch update = new CreativePatch();

        update.setDescription("Java Integration Test Updated Creative");

        CreativeResponse response = creativeApi.update(creative.getId(), update);
        Assert.assertNotNull(response);
        Assert.assertEquals(response.getDescription(), "Java Integration Test Updated Creative");
    }
}

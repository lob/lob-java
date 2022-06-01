package Integration;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

import com.lob.api.ApiException;
import com.lob.api.Configuration;
import com.lob.api.client.TemplatesApi;

import com.lob.model.Template;
import com.lob.model.TemplateDeletion;
import com.lob.model.TemplateWritable;
import com.lob.model.TemplateList;
import com.lob.model.TemplateUpdate;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Helper.TestFixtures;

public class TemplatesApiSpecTest {

private TemplatesApi validApi;
private List<TemplateWritable> TemplateWritableList;
private List<Template> createdTemplates = new ArrayList<Template>();
private String nextUrl;
private String previousUrl;

@BeforeClass
public void before_class()
{
    validApi = new TemplatesApi(Configuration.getConfigForIntegration()); 
   
    TemplateWritableList = new TestFixtures().get_TEMPLATES_WRITABLE();

    for (TemplateWritable tw: TemplateWritableList) {
        try {
            createdTemplates.add(validApi.create(tw));
        } catch (Exception e) {
            Assert.fail("Creating Templates before has failed");
        }
    }

    try {
        TemplateList response = validApi.list(null, null, null, null, null, null);
        Assert.assertNotNull(response);
        Assert.assertEquals(TemplateWritableList.size(), 3);
        Assert.assertNotNull(response.getNextUrl());
        nextUrl = response.getNextUrl().substring(response.getNextUrl().indexOf("after=") + 6);
        Assert.assertNotNull(nextUrl);
        TemplateList responseAfter = validApi.list(10, null, nextUrl, null, null, null);
        Assert.assertNotNull(responseAfter);
        Assert.assertNotNull(responseAfter.getPreviousUrl());
        previousUrl = responseAfter.getPreviousUrl().substring(responseAfter.getPreviousUrl().indexOf("before=") + 7);
        Assert.assertNotNull(previousUrl);
    } catch (ApiException e ) {
        Assert.fail("Listing Templates before has failed");
    }

}
@AfterClass
    public void after_class()
    {
        for (Template template: createdTemplates) {
            try {
                validApi.delete(template.getId());
            } catch (Exception e) {
                Assert.fail("Deleting Templates after has failed");
            }
        }
    }
    @Test(
        enabled=true,
        groups={"Integration", "Create", "Template", "Valid"}
    )
    public void createTemplateTest() throws ApiException {
        Template response = validApi.create(TemplateWritableList.get(0));

        Assert.assertNotNull(response.getId());
        createdTemplates.add(response);
    }

    @Test(
        enabled=true,
        groups={"Integration", "Retrieve", "Template", "Valid"}
    )
    public void templateRetrieveTest() throws ApiException {
        Template response = validApi.get(createdTemplates.get(0).getId());

        Assert.assertNotNull(response.getId());
        Assert.assertEquals(response.getId(), createdTemplates.get(0).getId());
        
    }

    @Test(
        enabled=true,
        groups={"Integration", "Update", "Template", "Valid"}
    )
    public void templateUpdateTest() throws ApiException {
        TemplateUpdate update = new TemplateUpdate();

        update.setDescription("update template");
        update.setPublishedVersion(createdTemplates.get(0).getPublishedVersion().getId());

        Template response = validApi.update(createdTemplates.get(0).getId(), update);
        Assert.assertNotNull(response);
        createdTemplates.add(response);
    }

    @Test(
        enabled=true,
        groups={"Integration", "Delete", "Template", "Valid"}
    )
    public void templateDeleteTest() throws ApiException {
       

        TemplateDeletion response = validApi.delete(createdTemplates.get(1).getId());

        Assert.assertNotNull(response);
        Assert.assertTrue(response.getDeleted());
        Assert.assertEquals(response.getId(), createdTemplates.get(1).getId());
    }

}

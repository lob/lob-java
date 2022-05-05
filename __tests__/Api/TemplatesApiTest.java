package Api;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.lob.api.ApiException;
import com.lob.api.client.TemplatesApi;

import org.openapitools.client.model.Template;
import org.openapitools.client.model.TemplateDeletion;
import org.openapitools.client.model.TemplateList;
import org.openapitools.client.model.TemplateUpdate;
import org.openapitools.client.model.TemplateWritable;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test(enabled=true, groups={"Unit", "PMAPI", "Template"})
public class TemplatesApiTest {
    @Test(enabled=true, groups={"Unit", "Create", "Template", "Valid"})
    public void createTemplateTest() throws ApiException {
        TemplatesApi templateApiMock=  mock(TemplatesApi.class);
        Template fakeTemplate = new Template();
        fakeTemplate.setId("tmpl_fakeId");
        TemplateWritable templateWritable = new TemplateWritable();

        when(templateApiMock.createTemplate(templateWritable)).thenReturn(fakeTemplate);
        Template response = templateApiMock.createTemplate(templateWritable);

        Assert.assertEquals(fakeTemplate.getId(), response.getId());
    }

    @Test(enabled=true, groups={"Unit", "Create", "Template", "Invalid"}, expectedExceptions = {ApiException.class}, expectedExceptionsMessageRegExp = "error reported by API")
    public void createTemplateTestCatchesException() throws ApiException {
        TemplatesApi templateApiMock = mock(TemplatesApi.class);
        ApiException error = new ApiException("error reported by API");

        when(templateApiMock.createTemplate(null)).thenThrow(error);
        templateApiMock.createTemplate(null);

        Assert.fail("This should not happen");
    }

    @Test(enabled=true, groups={"Unit", "Create", "Template", "Invalid"}, expectedExceptions = {ApiException.class})
    public void createTemplateTestCatchesExceptionWithResponseBody () throws ApiException {
        TemplatesApi templateApiMock = mock(TemplatesApi.class);
        ApiException error = new ApiException("error", null, 500, null, "error reported by API");
        when(templateApiMock.createTemplate(null)).thenThrow(error);

        templateApiMock.createTemplate(null);

        Assert.fail("This should not happen");   
    }   
    
    @Test(enabled=true, groups={"Unit", "Delete", "Template", "Valid"})
    public void templateDeleteTest() throws ApiException {
        TemplatesApi templateApiMock=  mock(TemplatesApi.class);
        TemplateDeletion fakeTemplate = new TemplateDeletion();
        fakeTemplate.setId("tmpl_fakeId");
       

        when(templateApiMock.templateDelete("tmpl_fakeId")).thenReturn(fakeTemplate);
        TemplateDeletion response = templateApiMock.templateDelete("tmpl_fakeId");

        Assert.assertEquals(fakeTemplate.getId(), response.getId());
    }

    @Test(enabled=true, groups={"Unit", "Delete", "Template", "Invalid"}, expectedExceptions = {ApiException.class}, expectedExceptionsMessageRegExp = "error reported by API")
    public void templateDeleteTestCatchesException() throws ApiException {
        TemplatesApi templateApiMock = mock(TemplatesApi.class);
        ApiException error = new ApiException("error reported by API");

        when(templateApiMock.templateDelete(null)).thenThrow(error);
        templateApiMock.templateDelete(null);

        Assert.fail("This should not happen");
    }

    @Test(enabled=true, groups={"Unit", "Delete", "Template", "Invalid"}, expectedExceptions = {ApiException.class})
    public void templateDeleteTestCatchesExceptionWithResponseBody () throws ApiException {
        TemplatesApi templateApiMock = mock(TemplatesApi.class);
        ApiException error = new ApiException("error", null, 500, null, "error reported by API");
        when(templateApiMock.templateDelete(null)).thenThrow(error);

        templateApiMock.templateDelete(null);

        Assert.fail("This should not happen");   
    }   
    
    @Test(enabled=true, groups={"Unit", "Retrieve", "Template", "Valid"})
    public void templateRetrieveTest() throws ApiException {
        TemplatesApi templateApiMock=  mock(TemplatesApi.class);
        Template fakeTemplate = new Template();
        fakeTemplate.setId("tmpl_fakeId");
       

        when(templateApiMock.templateRetrieve("tmpl_fakeId")).thenReturn(fakeTemplate);
        Template response = templateApiMock.templateRetrieve("tmpl_fakeId");

        Assert.assertEquals(fakeTemplate.getId(), response.getId());
    }

    @Test(enabled=true, groups={"Unit", "Retrieve", "Template", "Invalid"}, expectedExceptions = {ApiException.class}, expectedExceptionsMessageRegExp = "error reported by API")
    public void templateRetrieveTestCatchesException() throws ApiException {
        TemplatesApi templateApiMock = mock(TemplatesApi.class);
        ApiException error = new ApiException("error reported by API");

        when(templateApiMock.templateRetrieve(null)).thenThrow(error);
        templateApiMock.templateRetrieve(null);

        Assert.fail("This should not happen");
    }

    @Test(enabled=true, groups={"Unit", "Retrieve", "Template", "Invalid"}, expectedExceptions = {ApiException.class})
    public void templateRetrieveTestCatchesExceptionWithResponseBody () throws ApiException {
        TemplatesApi templateApiMock = mock(TemplatesApi.class);
        ApiException error = new ApiException("error", null, 500, null, "error reported by API");
        when(templateApiMock.templateRetrieve(null)).thenThrow(error);

        templateApiMock.templateRetrieve(null);

        Assert.fail("This should not happen");   
    }   
    
    @Test(enabled=true, groups={"Unit", "Update", "Template", "Valid"})
    public void templateUpdateTest() throws ApiException {
        TemplatesApi templateApiMock=  mock(TemplatesApi.class);
        Template fakeTemplate = new Template();
        TemplateUpdate templateUpdate = new TemplateUpdate();

        fakeTemplate.setId("tmpl_fakeId");
      
        when(templateApiMock.templateUpdate("tmpl_fakeId", templateUpdate)).thenReturn(fakeTemplate);
        Template response = templateApiMock.templateUpdate("tmpl_fakeId", templateUpdate);

        Assert.assertEquals(fakeTemplate.getId(), response.getId());
    }

    @Test(enabled=true, groups={"Unit", "Update", "Template", "Invalid"}, expectedExceptions = {ApiException.class}, expectedExceptionsMessageRegExp = "error reported by API")
    public void templateUpdateTestCatchesException() throws ApiException {
        TemplatesApi templateApiMock = mock(TemplatesApi.class);
        ApiException error = new ApiException("error reported by API");

        when(templateApiMock.templateUpdate(null, null)).thenThrow(error);
        templateApiMock.templateUpdate(null, null);

        Assert.fail("This should not happen");
    }

    @Test(enabled=true, groups={"Unit", "Update", "Template", "Invalid"}, expectedExceptions = {ApiException.class})
    public void templateUpdateTestCatchesExceptionWithResponseBody () throws ApiException {
        TemplatesApi templateApiMock = mock(TemplatesApi.class);
        ApiException error = new ApiException("error", null, 500, null, "error reported by API");
        when(templateApiMock.templateUpdate(null, null)).thenThrow(error);

        templateApiMock.templateUpdate(null, null);

        Assert.fail("This should not happen");   
    }   
    
    @Test(enabled=false, groups={"Unit", "List", "Template", "Valid"})
    public void templatesListTest() throws ApiException {
        Integer limit = null;
        String before = null;
        String after = null;
        List<String> include = null;
        Map<String, String> dateCreated = null;
        Map<String, String> metadata = null;
        TemplatesApi templateApiMock = mock(TemplatesApi.class);
        TemplateList fakeTemplateList = new TemplateList();
        List<Template> data = new ArrayList<Template>();
        Template data1 = new Template();
        Template data2 = new Template();

        data1.setId("tmpl_Id");
        data2.setId("tmpl_Id2");
        data.add(data1);
        data.add(data2);
        fakeTemplateList.setData(data);
        fakeTemplateList.setObject("list");
        fakeTemplateList.setCount(data.size());

        when(templateApiMock.templatesList(limit, before, after, include, dateCreated, metadata)).thenReturn(fakeTemplateList);
        TemplateList response = templateApiMock.templatesList(limit, before, after, include, dateCreated, metadata);

        Assert.assertEquals(fakeTemplateList.getCount(), response.getCount());
    }
    
    @Test(enabled=true, groups={"Unit", "List", "Template", "Invalid"}, expectedExceptions = {ApiException.class}, expectedExceptionsMessageRegExp = "error reported by API")
    public void templateListTestCatchesException() throws ApiException {
        TemplatesApi templateApiMock = mock(TemplatesApi.class);
        ApiException error = new ApiException("error reported by API");

        when(templateApiMock.templatesList(null, null, null, null, null, null)).thenThrow(error);
        templateApiMock.templatesList(null, null, null, null, null, null);

        Assert.fail("This should not happen");
    }

    @Test(enabled=true, groups={"Unit", "Create", "Template", "Invalid"}, expectedExceptions = {ApiException.class})
    public void templateListTestCatchesExceptionWithResponseBody () throws ApiException {
        TemplatesApi templateApiMock = mock(TemplatesApi.class);
        ApiException error = new ApiException("error", null, 500, null, "error reported by API");
        when(templateApiMock.templatesList(null, null, null, null, null, null)).thenThrow(error);

        templateApiMock.templatesList(null, null, null, null, null, null);

        Assert.fail("This should not happen");   
    }   
    
}

package Api;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.lob.api.ApiException;
import com.lob.api.client.TemplateVersionsApi;

import org.openapitools.client.model.TemplateVersion;
import org.openapitools.client.model.TemplateVersionDeletion;
import org.openapitools.client.model.TemplateVersionList;
import org.openapitools.client.model.TemplateVersionUpdatable;
import org.openapitools.client.model.TemplateVersionWritable;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test(enabled=true, groups={"Unit", "PMAPI", "Template Version"})
public class TemplateVersionsApiTest {
    @Test(enabled=true, groups={"Unit", "Create", "Template Version", "Valid"})
    public void createTemplateVersionTest() throws ApiException {
        TemplateVersionsApi templateVersionApiMock = mock(TemplateVersionsApi.class);
        TemplateVersion fakeTemplateVersion = new TemplateVersion();
        TemplateVersionWritable templateVersionWritable = new TemplateVersionWritable();

        fakeTemplateVersion.setId("vrsn_fakeId");
        
        when(templateVersionApiMock.createTemplateVersion("tmpl_fakeId", templateVersionWritable)).thenReturn(fakeTemplateVersion);
        TemplateVersion response = templateVersionApiMock.createTemplateVersion("tmpl_fakeId", templateVersionWritable);

        Assert.assertEquals(fakeTemplateVersion.getId(), response.getId());
    }

    @Test(enabled=true, groups={"Unit", "Create", "Template Version", "Invalid"}, expectedExceptions = {ApiException.class}, expectedExceptionsMessageRegExp = "error reported by API")
    public void createTemplateVersionTestCatchesException() throws ApiException {
        TemplateVersionsApi templateVersionApiMock = mock(TemplateVersionsApi.class);
        ApiException error = new ApiException("error reported by API");

        when(templateVersionApiMock.createTemplateVersion(null, null)).thenThrow(error);
        templateVersionApiMock.createTemplateVersion(null, null);

        Assert.fail("This should not happen");
    }

    @Test(enabled=true, groups={"Unit", "Create", "Template Version", "Invalid"}, expectedExceptions = {ApiException.class})
    public void createTemplateVersionTestCatchesExceptionWithResponseBody () throws ApiException {
        TemplateVersionsApi templateVersionApiMock = mock(TemplateVersionsApi.class);
        ApiException error = new ApiException("error", null, 500, null, "error reported by API");
        when(templateVersionApiMock.createTemplateVersion(null, null)).thenThrow(error);

        templateVersionApiMock.createTemplateVersion(null, null);

        Assert.fail("This should not happen");   
    }   
    
    @Test(enabled=true, groups={"Unit", "Delete", "Template Version", "Valid"})
    public void templateVersionDeleteTest() throws ApiException {
        TemplateVersionsApi templateVersionApiMock = mock(TemplateVersionsApi.class);
        TemplateVersionDeletion fakeTemplateVersion = new TemplateVersionDeletion();
        

        fakeTemplateVersion.setId("vrsn_fakeId");
        
        when(templateVersionApiMock.templateVersionDelete("tmpl_fakeId", "vrsn_fakeId")).thenReturn(fakeTemplateVersion);
        TemplateVersionDeletion response = templateVersionApiMock.templateVersionDelete("tmpl_fakeId", "vrsn_fakeId");

        Assert.assertEquals(fakeTemplateVersion.getId(), response.getId());
    }

    @Test(enabled=true, groups={"Unit", "Delete", "Template Version", "Invalid"}, expectedExceptions = {ApiException.class}, expectedExceptionsMessageRegExp = "error reported by API")
    public void templateVersionDeleteTestCatchesException() throws ApiException {
        TemplateVersionsApi templateVersionApiMock = mock(TemplateVersionsApi.class);
        ApiException error = new ApiException("error reported by API");

        when(templateVersionApiMock.templateVersionDelete(null, null)).thenThrow(error);
        templateVersionApiMock.templateVersionDelete(null, null);

        Assert.fail("This should not happen");
    }

    @Test(enabled=true, groups={"Unit", "Delete", "Template Version", "Invalid"}, expectedExceptions = {ApiException.class})
    public void templateVersionDeleteTestCatchesExceptionWithResponseBody () throws ApiException {
        TemplateVersionsApi templateVersionApiMock = mock(TemplateVersionsApi.class);
        ApiException error = new ApiException("error", null, 500, null, "error reported by API");
        when(templateVersionApiMock.templateVersionDelete(null, null)).thenThrow(error);

        templateVersionApiMock.templateVersionDelete(null, null);

        Assert.fail("This should not happen");   
    }   
    
    @Test(enabled=true, groups={"Unit", "Retrieve", "Template Version", "Valid"})
    public void templateVersionRetrieveTest() throws ApiException {
        TemplateVersionsApi templateVersionApiMock = mock(TemplateVersionsApi.class);
        TemplateVersion fakeTemplateVersion = new TemplateVersion();
        

        fakeTemplateVersion.setId("vrsn_fakeId");
        
        when(templateVersionApiMock.templateVersionRetrieve("tmpl_fakeId", "vrsn_fakeId")).thenReturn(fakeTemplateVersion);
        TemplateVersion response = templateVersionApiMock.templateVersionRetrieve("tmpl_fakeId", "vrsn_fakeId");

        Assert.assertEquals(fakeTemplateVersion.getId(), response.getId());
    }

    @Test(enabled=true, groups={"Unit", "Retrieve", "Template Version", "Invalid"}, expectedExceptions = {ApiException.class}, expectedExceptionsMessageRegExp = "error reported by API")
    public void templateVersionRetrieveTestCatchesException() throws ApiException {
        TemplateVersionsApi templateVersionApiMock = mock(TemplateVersionsApi.class);
        ApiException error = new ApiException("error reported by API");

        when(templateVersionApiMock.createTemplateVersion(null, null)).thenThrow(error);
        templateVersionApiMock.createTemplateVersion(null, null);

        Assert.fail("This should not happen");
    }

    @Test(enabled=true, groups={"Unit", "Retrieve", "Template Version", "Invalid"}, expectedExceptions = {ApiException.class})
    public void templateVersionRetrieveTestCatchesExceptionWithResponseBody () throws ApiException {
        TemplateVersionsApi templateVersionApiMock = mock(TemplateVersionsApi.class);
        ApiException error = new ApiException("error", null, 500, null, "error reported by API");
        when(templateVersionApiMock.templateVersionRetrieve(null, null)).thenThrow(error);

        templateVersionApiMock.templateVersionRetrieve(null, null);

        Assert.fail("This should not happen");   
    }   
    
    @Test(enabled=true, groups={"Unit", "Udpate", "Valid"})
    public void templateVersionUpdateTest() throws ApiException {
        TemplateVersionsApi templateVersionApiMock = mock(TemplateVersionsApi.class);
        TemplateVersion fakeTemplateVersion = new TemplateVersion();
        TemplateVersionUpdatable templateVersionUpdatable = new TemplateVersionUpdatable();
        

        fakeTemplateVersion.setId("vrsn_fakeId");
        
        when(templateVersionApiMock.templateVersionUpdate("tmpl_fakeId", "vrsn_fakeId", templateVersionUpdatable)).thenReturn(fakeTemplateVersion);
        TemplateVersion response = templateVersionApiMock.templateVersionUpdate("tmpl_fakeId", "vrsn_fakeId", templateVersionUpdatable);

        Assert.assertEquals(fakeTemplateVersion.getId(), response.getId());
    }

    @Test(enabled=true, groups={"Unit", "Update", "Template Version", "Invalid"}, expectedExceptions = {ApiException.class}, expectedExceptionsMessageRegExp = "error reported by API")
    public void templateVersionUpdateTestCatchesException() throws ApiException {
        TemplateVersionsApi templateVersionApiMock = mock(TemplateVersionsApi.class);
        ApiException error = new ApiException("error reported by API");

        when(templateVersionApiMock.templateVersionUpdate(null, null, null)).thenThrow(error);
        templateVersionApiMock.templateVersionUpdate(null, null, null);

        Assert.fail("This should not happen");
    }

    @Test(enabled=true, groups={"Unit", "Update", "Template Version", "Invalid"}, expectedExceptions = {ApiException.class})
    public void templateVersionUpdateTestCatchesExceptionWithResponseBody () throws ApiException {
        TemplateVersionsApi templateVersionApiMock = mock(TemplateVersionsApi.class);
        ApiException error = new ApiException("error", null, 500, null, "error reported by API");
        when(templateVersionApiMock.templateVersionUpdate(null, null, null)).thenThrow(error);

        templateVersionApiMock.templateVersionUpdate(null, null, null);

        Assert.fail("This should not happen");   
    }   
    
    @Test(enabled=true, groups={"Unit", "List", "Template Version", "Valid"})
    public void templateVersionsListTest() throws ApiException {
        String tmplId = null;
        Integer limit = null;
        String before = null;
        String after = null;
        List<String> include = null;
        Map<String, String> dateCreated = null;
        TemplateVersionsApi templateVersionApiMock = mock(TemplateVersionsApi.class);
        TemplateVersionList fakeTemplateVersionList = new TemplateVersionList();
        List<TemplateVersion> data = new ArrayList<TemplateVersion>();
        TemplateVersion data1 = new TemplateVersion();
        TemplateVersion data2 = new TemplateVersion();

        data1.setId("vrsn_Id");
        data2.setId("vrsn_Id2");
        data.add(data1);
        data.add(data2);
        fakeTemplateVersionList.setData(data);
        fakeTemplateVersionList.setObject("list");
        fakeTemplateVersionList.setCount(data.size());

        when(templateVersionApiMock.templateVersionsList(tmplId, limit, before, after, include, dateCreated)).thenReturn(fakeTemplateVersionList);
        TemplateVersionList response =templateVersionApiMock.templateVersionsList(tmplId, limit, before, after, include, dateCreated);
        
        Assert.assertEquals(fakeTemplateVersionList.getCount(), response.getCount());
    }

    @Test(enabled=true, groups={"Unit", "List", "Template Version", "Invalid"}, expectedExceptions = {ApiException.class}, expectedExceptionsMessageRegExp = "error reported by API")
    public void templateVersionsListTestCatchesException() throws ApiException {
        TemplateVersionsApi templateVersionApiMock = mock(TemplateVersionsApi.class);
        ApiException error = new ApiException("error reported by API");

        when(templateVersionApiMock.templateVersionsList(null, null, null, null, null, null)).thenThrow(error);
        templateVersionApiMock.templateVersionsList(null, null, null, null, null, null);

        Assert.fail("This should not happen");
    }

    @Test(enabled=true, groups={"Unit", "List", "Template Version", "Invalid"}, expectedExceptions = {ApiException.class})
    public void templateVersionsListTestCatchesExceptionWithResponseBody () throws ApiException {
        TemplateVersionsApi templateVersionApiMock = mock(TemplateVersionsApi.class);
        ApiException error = new ApiException("error", null, 500, null, "error reported by API");
        when(templateVersionApiMock.templateVersionsList(null, null, null, null, null, null)).thenThrow(error);

        templateVersionApiMock.templateVersionsList(null, null, null, null, null, null);

        Assert.fail("This should not happen");   
    }   

    
}

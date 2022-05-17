package Api;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.lob.api.ApiException;
import com.lob.api.client.SelfMailersApi;

import org.openapitools.client.model.MailType;
import org.openapitools.client.model.SelfMailer;
import org.openapitools.client.model.SelfMailerDeletion;
import org.openapitools.client.model.SelfMailerEditable;
import org.openapitools.client.model.SelfMailerList;
import org.openapitools.client.model.SelfMailerSize;
import org.threeten.bp.OffsetDateTime;
import org.openapitools.client.model.SortBy5;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test(enabled=true, groups={"Unit", "PMAPI", "Self Mailer"})
public class SelfMailersApiTest {
    @Test(enabled=true, groups={"Unit", "Create", "Self Mailer", "Valid"})
    public void selfMailerCreateTest() throws ApiException {
        SelfMailersApi selfMailersApiMock = mock (SelfMailersApi.class);
        SelfMailer fakeSelfMailer = new SelfMailer();
        SelfMailerEditable selfMailerEditable = new SelfMailerEditable();

        fakeSelfMailer.setId("sfm_fakeId");

        when(selfMailersApiMock.selfMailerCreate(selfMailerEditable, "fake_key")).thenReturn(fakeSelfMailer);
        SelfMailer response = selfMailersApiMock.selfMailerCreate(selfMailerEditable,"fake_key");

        Assert.assertEquals(fakeSelfMailer.getId(), response.getId());
    }

    @Test(enabled=true, groups={"Unit", "Create", "Self Mailer", "Invalid"}, expectedExceptions = {ApiException.class}, expectedExceptionsMessageRegExp = "error reported by API")
    public void  selfMailerCreateTestCatchesException() throws ApiException {
        SelfMailersApi selfMailerApiMock = mock(SelfMailersApi.class);
        ApiException error = new ApiException("error reported by API");

        when(selfMailerApiMock.selfMailerCreate(null, null)).thenThrow(error);
        selfMailerApiMock.selfMailerCreate(null, null);

        Assert.fail("This should not happen");
    }

    @Test(enabled=true, groups={"Unit", "Create", "Self Mailer", "Invalid"}, expectedExceptions = {ApiException.class})
    public void selfMailerCreateTestCatchesExceptionWithResponseBody () throws ApiException {
        SelfMailersApi selfMailerApiMock = mock(SelfMailersApi.class);
        ApiException error = new ApiException("error", null, 500, null, "error reported by API");
        when(selfMailerApiMock.selfMailerCreate(null, null)).thenThrow(error);

        selfMailerApiMock.selfMailerCreate(null, null);

        Assert.fail("This should not happen");   
    }   
    
    @Test(enabled=true, groups={"Unit", "Delete", "Self Mailer", "Valid"})
    public void selfMailerDeleteTest() throws ApiException {
        SelfMailersApi selfMailersApiMock = mock (SelfMailersApi.class);
        SelfMailerDeletion fakeSelfMailer = new SelfMailerDeletion();
        
        fakeSelfMailer.setId("sfm_fakeId");

        when(selfMailersApiMock.selfMailerDelete("smf_fakeId")).thenReturn(fakeSelfMailer);
        SelfMailerDeletion response = selfMailersApiMock.selfMailerDelete("smf_fakeId");

        Assert.assertEquals(fakeSelfMailer.getId(), response.getId());
    }

    @Test(enabled=true, groups={"Unit", "Delete", "Self Mailer", "Invalid"}, expectedExceptions = {ApiException.class}, expectedExceptionsMessageRegExp = "error reported by API")
    public void  selfMailerDeleteTestCatchesException() throws ApiException {
        SelfMailersApi selfMailerApiMock = mock(SelfMailersApi.class);
        ApiException error = new ApiException("error reported by API");

        when(selfMailerApiMock.selfMailerDelete(null)).thenThrow(error);
        selfMailerApiMock.selfMailerDelete(null);

        Assert.fail("This should not happen");
    }

    @Test(enabled=true, groups={"Unit", "Delete", "Self Mailer", "Invalid"}, expectedExceptions = {ApiException.class})
    public void selfMailerDeleteTestCatchesExceptionWithResponseBody () throws ApiException {
        SelfMailersApi selfMailerApiMock = mock(SelfMailersApi.class);
        ApiException error = new ApiException("error", null, 500, null, "error reported by API");
        when(selfMailerApiMock.selfMailerDelete(null)).thenThrow(error);

        selfMailerApiMock.selfMailerDelete(null);

        Assert.fail("This should not happen");  
    }
    
    @Test(enabled=true, groups={"Unit", "Retrieve", "Self Mailer", "Valid"})
    public void selfMailerRetrieveTest() throws ApiException {
        SelfMailersApi selfMailersApiMock = mock (SelfMailersApi.class);
        SelfMailer fakeSelfMailer = new SelfMailer();
        
        fakeSelfMailer.setId("sfm_fakeId");

        when(selfMailersApiMock.selfMailerRetrieve("sfm_fakeId")).thenReturn(fakeSelfMailer);
        SelfMailer response = selfMailersApiMock.selfMailerRetrieve("sfm_fakeId");

        Assert.assertEquals(fakeSelfMailer.getId(), response.getId());
    }

    @Test(enabled=true, groups={"Unit", "Retrieve", "Self Mailer", "Invalid"}, expectedExceptions = {ApiException.class}, expectedExceptionsMessageRegExp = "error reported by API")
    public void  selfMailerRetrieveTestCatchesException() throws ApiException {
        SelfMailersApi selfMailerApiMock = mock(SelfMailersApi.class);
        ApiException error = new ApiException("error reported by API");

        when(selfMailerApiMock.selfMailerRetrieve(null)).thenThrow(error);
        selfMailerApiMock.selfMailerRetrieve(null);

        Assert.fail("This should not happen");
    }

    @Test(enabled=true, groups={"Unit", "Retrieve", "Self Mailer", "Invalid"}, expectedExceptions = {ApiException.class})
    public void selfMailerRetrieveTestCatchesExceptionWithResponseBody () throws ApiException {
        SelfMailersApi selfMailerApiMock = mock(SelfMailersApi.class);
        ApiException error = new ApiException("error", null, 500, null, "error reported by API");
        when(selfMailerApiMock.selfMailerRetrieve(null)).thenThrow(error);

        selfMailerApiMock.selfMailerRetrieve(null);

        Assert.fail("This should not happen");  
    }
    
    @Test(enabled=true, groups={"Unit", "List", "Self Mailer", "Valid"})
    public void selfMailersListTest() throws ApiException {
        Integer limit = null;
        String before = null;
        String after = null;
        List<String> include = null;
        Map<String, String> dateCreated = null;
        Map<String, String> metadata = null;
        SelfMailerSize size = null;
        Boolean scheduled = null;
        Map<String, String>  sendDate = null;
        MailType mailType = null;
        SortBy5 sortBy = null;
        SelfMailersApi selfMailersApiMock = mock(SelfMailersApi.class);
        SelfMailerList fakeSelfMailerList = new SelfMailerList();
        List<SelfMailer> data = new ArrayList<SelfMailer>();
        SelfMailer data1 = new SelfMailer();
        SelfMailer data2 = new SelfMailer();

        data1.setId("sfm_id");
        data1.setId("sfm_id");
        data.add(data1);
        data.add(data2);
        fakeSelfMailerList.setData(data);
        fakeSelfMailerList.setObject("list");
        fakeSelfMailerList.setCount(data.size());

        when(selfMailersApiMock.selfMailersList(limit, before, after, include, dateCreated, metadata, size, scheduled, sendDate, mailType, sortBy)).thenReturn(fakeSelfMailerList);
        SelfMailerList response = selfMailersApiMock.selfMailersList(limit, before, after, include, dateCreated, metadata, size, scheduled, sendDate, mailType, sortBy);

        Assert.assertEquals(fakeSelfMailerList.getCount(), response.getCount());
    }

    @Test(enabled=true, groups={"Unit", "List", "Self Mailer", "Invalid"}, expectedExceptions = {ApiException.class}, expectedExceptionsMessageRegExp = "error reported by API")
    public void  selfMailersListTestCatchesException() throws ApiException {
        SelfMailersApi selfMailerApiMock = mock(SelfMailersApi.class);
        ApiException error = new ApiException("error reported by API");

        when(selfMailerApiMock.selfMailersList(null, null, null, null, null, null, null, null, null, null, null)).thenThrow(error);
        selfMailerApiMock.selfMailersList(null, null, null, null, null, null, null, null, null, null, null);

        Assert.fail("This should not happen");
    }

    @Test(enabled=true, groups={"Unit", "List", "Self Mailer", "Invalid"}, expectedExceptions = {ApiException.class})
    public void selfMailersListTestCatchesExceptionWithResponseBody () throws ApiException {
        SelfMailersApi selfMailerApiMock = mock(SelfMailersApi.class);
        ApiException error = new ApiException("error", null, 500, null, "error reported by API");
        when(selfMailerApiMock.selfMailersList(null, null, null, null, null, null, null, null, null, null, null)).thenThrow(error);

        selfMailerApiMock.selfMailersList(null, null, null, null, null, null, null, null, null, null, null);

        Assert.fail("This should not happen");  
    }

}

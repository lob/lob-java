package Api;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.lob.api.ApiException;
import com.lob.api.client.ChecksApi;

import com.lob.model.Check;
import com.lob.model.CheckDeletion;
import com.lob.model.CheckEditable;
import com.lob.model.CheckList;
import com.lob.model.MailType;
import com.lob.model.SortBy5;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test(enabled=true, groups={"Unit", "PMAPI", "Check"})
public class ChecksApiTest {
    @Test(enabled=true, groups={"Unit", "Cancel", "Check", "Valid"})
    public void checkCancelTest() throws ApiException {
        ChecksApi checkApiMock = mock(ChecksApi.class);
        CheckDeletion fakeCheck = new CheckDeletion();
        
        fakeCheck.setId("chk_fakeId");

        when(checkApiMock.cancel("chk_fakeId")).thenReturn(fakeCheck);
        CheckDeletion response = checkApiMock.cancel("chk_fakeId");

        Assert.assertEquals(fakeCheck.getId(), response.getId());
    }

    @Test(enabled=true, groups={"Unit", "Cancel", "Check", "Invalid"}, expectedExceptions = {ApiException.class}, expectedExceptionsMessageRegExp = "error reported by API")
    public void checkCancelTestCatchesException() throws ApiException {
        ChecksApi checkApiMock = mock(ChecksApi.class);
        ApiException error = new ApiException("error reported by API");

        when(checkApiMock.cancel(null)).thenThrow(error);
        checkApiMock.cancel(null);

        Assert.fail("This should not happen");
    }

    @Test(enabled=true, groups={"Unit", "Cancel", "Check", "Invalid"}, expectedExceptions = {ApiException.class})
    public void checkCancelTestCatchesExceptionWithResponseBody () throws ApiException {
        ChecksApi checkApiMock = mock(ChecksApi.class);
        ApiException error = new ApiException("error", null, 500, null, "error reported by API");
        when(checkApiMock.cancel(null)).thenThrow(error);

        checkApiMock.cancel(null);

        Assert.fail("This should not happen");   
    }   
    
    @Test(enabled=true, groups={"Unit", "Create", "Check", "Valid"})
    public void checkCreateTest() throws ApiException {
        ChecksApi checkApiMock = mock(ChecksApi.class);
        Check fakeCheck = new Check();
        CheckEditable checkEditable = new CheckEditable();
        
        fakeCheck.setId("chk_fakeId");

        when(checkApiMock.create(checkEditable, "fake_key")).thenReturn(fakeCheck);
        Check response = checkApiMock.create(checkEditable, "fake_key");

        Assert.assertEquals(fakeCheck.getId(), response.getId());
    }

    @Test(enabled=true, groups={"Unit", "Create", "Check", "Invalid"}, expectedExceptions = {ApiException.class}, expectedExceptionsMessageRegExp = "error reported by API")
    public void checkCreateTestCatchesException() throws ApiException {
        ChecksApi checkApiMock = mock(ChecksApi.class);
        ApiException error = new ApiException("error reported by API");

        when(checkApiMock.create(null, null)).thenThrow(error);
        checkApiMock.create(null, null);

        Assert.fail("This should not happen");
    }

    @Test(enabled=true, groups={"Unit", "Create", "Check", "Invalid"}, expectedExceptions = {ApiException.class})
    public void checkCreateTestCatchesExceptionWithResponseBody () throws ApiException {
        ChecksApi checkApiMock = mock(ChecksApi.class);
        ApiException error = new ApiException("error", null, 500, null, "error reported by API");
        when(checkApiMock.create(null, null)).thenThrow(error);

        checkApiMock.create(null, null);

        Assert.fail("This should not happen");   
    }   
    
    @Test(enabled=true, groups={"Unit", "Get", "Check", "Valid"})
    public void checkGetTest() throws ApiException {
        ChecksApi checkApiMock = mock(ChecksApi.class);
        Check fakeCheck = new Check();
        
        fakeCheck.setId("chk_fakeId");

        when(checkApiMock.get("chk_fakeId")).thenReturn(fakeCheck);
        Check response = checkApiMock.get("chk_fakeId");

        Assert.assertEquals(fakeCheck.getId(), response.getId());
    }
    
    @Test(enabled=true, groups={"Unit", "Get", "Check", "Invalid"}, expectedExceptions = {ApiException.class}, expectedExceptionsMessageRegExp = "error reported by API")
    public void checkGetTestCatchesException() throws ApiException {
        ChecksApi checkApiMock = mock(ChecksApi.class);
        ApiException error = new ApiException("error reported by API");

        when(checkApiMock.get(null)).thenThrow(error);
        checkApiMock.get(null);

        Assert.fail("This should not happen");
    }

    @Test(enabled=true, groups={"Unit", "Get", "Check", "Invalid"}, expectedExceptions = {ApiException.class})
    public void checkGetTestCatchesExceptionWithResponseBody () throws ApiException {
        ChecksApi checkApiMock = mock(ChecksApi.class);
        ApiException error = new ApiException("error", null, 500, null, "error reported by API");
        when(checkApiMock.get(null)).thenThrow(error);

        checkApiMock.get(null);

        Assert.fail("This should not happen");   
    }   
    
    @Test(enabled=false, groups={"Unit", "List", "Check", "Valid"})
    public void checksListTest() throws ApiException {
        Integer limit = null;
        String before = null;
        String after = null;
        List<String> include = null;
        Map<String, String> dateCreated = null;
        Map<String, String> metadata = null;
        Boolean scheduled = null;
        Map<String, String> sendDate = null;
        MailType mailType = null;
        SortBy5 sortBy = null;

        ChecksApi checkApiMock = new ChecksApi();
        CheckList fakeCheck = new CheckList();
        List<Check> data = new ArrayList<Check>();
        Check data1 = new Check();
        Check data2 = new Check();
        data1.setId("chk_Id");
        data2.setId("chk_Id2");
        data.add(data1);
        data.add(data2);
        fakeCheck.setData(data);
        fakeCheck.setObject("list");
        fakeCheck.setCount(data.size());

        when(checkApiMock.list(limit, before, after, include, dateCreated, metadata, scheduled, sendDate, mailType, sortBy)).thenReturn(fakeCheck);
        
        CheckList response = checkApiMock.list(limit, before, after, include, dateCreated, metadata, scheduled, sendDate, mailType, sortBy);
        Assert.assertEquals(fakeCheck.getCount(), response.getCount());
    }

    @Test(enabled=true, groups={"Unit", "List", "Check", "Invalid"}, expectedExceptions = {ApiException.class}, expectedExceptionsMessageRegExp = "error reported by API")
    public void checkListTestCatchesException() throws ApiException {
        ChecksApi checkApiMock = mock(ChecksApi.class);
        ApiException error = new ApiException("error reported by API");

        when(checkApiMock.list(null, null, null, null, null, null, null, null, null, null)).thenThrow(error);
        checkApiMock.list(null, null, null, null, null, null, null, null, null, null);

        Assert.fail("This should not happen");
    }

    @Test(enabled=true, groups={"Unit", "List", "Check", "Invalid"}, expectedExceptions = {ApiException.class})
    public void checkListTestCatchesExceptionWithResponseBody () throws ApiException {
        ChecksApi checkApiMock = mock(ChecksApi.class);
        ApiException error = new ApiException("error", null, 500, null, "error reported by API");
        when(checkApiMock.list(null, null, null, null, null, null, null, null, null, null)).thenThrow(error);

        checkApiMock.list(null, null, null, null, null, null, null, null, null, null);

        Assert.fail("This should not happen");   
    }   
}

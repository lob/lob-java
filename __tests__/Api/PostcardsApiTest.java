package Api;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.lob.api.ApiException;
import com.lob.api.client.PostcardsApi;

import com.lob.model.MailType;
import com.lob.model.Postcard;
import com.lob.model.PostcardDeletion;
import com.lob.model.PostcardEditable;
import com.lob.model.PostcardList;
import com.lob.model.PostcardSize;
import com.lob.model.SortBy5;
import org.testng.Assert;
import org.testng.annotations.Test;


@Test(enabled=true, groups={"Unit", "PMAPI", "Postcard"})
public class PostcardsApiTest {
    @Test(enabled=true, groups={"Unit", "Create", "Postcard", "Valid"})
    public void postcardCreateTest() throws ApiException {
        PostcardsApi postcardsApiMock = mock(PostcardsApi.class);
        Postcard fakePostcard = new Postcard();
        PostcardEditable postcardEditable = new PostcardEditable();
        
        fakePostcard.setId("psc_fakeId");
        
        when(postcardsApiMock.create(postcardEditable, "fake_key")).thenReturn(fakePostcard);
        Postcard response = postcardsApiMock.create(postcardEditable, "fake_key");

        Assert.assertEquals(fakePostcard.getId(), response.getId());
    }

    @Test(enabled=true, groups={"Unit", "Create", "Postcard", "Invalid"}, expectedExceptions = {ApiException.class}, expectedExceptionsMessageRegExp = "error reported by API")
    public void postcardCreateTestCatchesException() throws ApiException {
        PostcardsApi postcardApiMock = mock(PostcardsApi.class);
        ApiException error = new ApiException("error reported by API");

        when(postcardApiMock.create(null, null)).thenThrow(error);
        postcardApiMock.create(null, null);

        Assert.fail("This should not happen");
    }

    @Test(enabled=true, groups={"Unit", "Create", "Postcard", "Invalid"}, expectedExceptions = {ApiException.class})
    public void postcardCreateTestCatchesExceptionWithResponseBody () throws ApiException {
        PostcardsApi postcardApiMock = mock(PostcardsApi.class);
        ApiException error = new ApiException("error", null, 500, null, "error reported by API");
        when(postcardApiMock.create(null, null)).thenThrow(error);

        postcardApiMock.create(null, null);

        Assert.fail("This should not happen");   
    }   
    
    @Test(enabled=true, groups={"Unit", "Cancel", "Postcard", "Valid"})
    public void postcardCancelTest() throws ApiException {
        PostcardsApi postcardsApiMock = mock(PostcardsApi.class);
        PostcardDeletion fakePostcard = new PostcardDeletion();

        fakePostcard.setId("psc_fakeId");
        
        when(postcardsApiMock.cancel("psc_fakeId")).thenReturn(fakePostcard);
        PostcardDeletion response = postcardsApiMock.cancel("psc_fakeId");

        Assert.assertEquals(fakePostcard.getId(), response.getId());
    }

    @Test(enabled=true, groups={"Unit", "Cancel", "Postcard", "Invalid"}, expectedExceptions = {ApiException.class}, expectedExceptionsMessageRegExp = "error reported by API")
    public void postcardCancelTestCatchesException() throws ApiException {
        PostcardsApi postcardApiMock = mock(PostcardsApi.class);
        ApiException error = new ApiException("error reported by API");

        when(postcardApiMock.cancel(null)).thenThrow(error);
        postcardApiMock.cancel(null);

        Assert.fail("This should not happen");
    }

    @Test(enabled=true, groups={"Unit", "Cancel", "Postcard", "Invalid"}, expectedExceptions = {ApiException.class})
    public void postcardCancelTestCatchesExceptionWithResponseBody () throws ApiException {
        PostcardsApi postcardApiMock = mock(PostcardsApi.class);
        ApiException error = new ApiException("error", null, 500, null, "error reported by API");
        when(postcardApiMock.cancel(null)).thenThrow(error);

        postcardApiMock.cancel(null);

        Assert.fail("This should not happen");   
    }   
    
    @Test(enabled=true, groups={"Unit", "Get", "Postcard", "Valid"})
    public void postcardGetTest() throws ApiException {
        PostcardsApi postcardsApiMock = mock(PostcardsApi.class);
        Postcard fakePostcard = new Postcard();

        fakePostcard.setId("psc_fakeId");
        
        when(postcardsApiMock.get("psc_fakeId")).thenReturn(fakePostcard);
        Postcard response = postcardsApiMock.get("psc_fakeId");

        Assert.assertEquals(fakePostcard.getId(), response.getId());
    }
    
    @Test(enabled=true, groups={"Unit", "Get", "Postcard", "Invalid"}, expectedExceptions = {ApiException.class}, expectedExceptionsMessageRegExp = "error reported by API")
    public void postcardGetTestCatchesException() throws ApiException {
        PostcardsApi postcardApiMock = mock(PostcardsApi.class);
        ApiException error = new ApiException("error reported by API");

        when(postcardApiMock.get(null)).thenThrow(error);
        postcardApiMock.get(null);

        Assert.fail("This should not happen");
    }

    @Test(enabled=true, groups={"Unit", "Get", "Postcard", "Invalid"}, expectedExceptions = {ApiException.class})
    public void postcardRetrieveTestCatchesExceptionWithResponseBody () throws ApiException {
        PostcardsApi postcardApiMock = mock(PostcardsApi.class);
        ApiException error = new ApiException("error", null, 500, null, "error reported by API");
        when(postcardApiMock.get(null)).thenThrow(error);

        postcardApiMock.get(null);

        Assert.fail("This should not happen");   
    }   

    @Test(enabled=false, groups={"Unit", "List", "Postcard", "Valid"})
    public void postcardsListTest() throws ApiException {
        Integer limit = null;
        String before = null;
        String after = null;
        List<String> include = null;
        Map<String, String> dateCreated = null;
        Map<String, String> metadata = null;
        List<PostcardSize> size = null;
        Boolean scheduled = null;
        Map<String, String> sendDate = null;
        MailType mailType = null;
        SortBy5 sortBy = null;

        PostcardsApi postcardApiMock = mock(PostcardsApi.class);
        PostcardList fakePostcardList = new PostcardList();
        List<Postcard> data = new ArrayList<Postcard>();
        Postcard data1 = new Postcard();
        Postcard data2 = new Postcard();

        data1.setId("psc_Id");
        data2.setId("psc_Id");
        data.add(data1);
        data.add(data2);
        fakePostcardList.setData(data);
        fakePostcardList.setObject("list");
        fakePostcardList.setCount(data.size());

        when(postcardApiMock.list(limit, before, after, include, dateCreated, metadata, size, scheduled, sendDate, mailType, sortBy)).thenReturn(fakePostcardList);
        PostcardList response = postcardApiMock.list(limit, before, after, include, dateCreated, metadata, size, scheduled, sendDate, mailType, sortBy);

        Assert.assertEquals(fakePostcardList.getCount(), response.getCount());  
    }
    
}

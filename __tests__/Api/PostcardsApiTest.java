package Api;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.lob.api.ApiException;
import com.lob.api.client.PostcardsApi;

import org.openapitools.client.model.MailType;
import org.openapitools.client.model.Postcard;
import org.openapitools.client.model.PostcardDeletion;
import org.openapitools.client.model.PostcardEditable;
import org.openapitools.client.model.PostcardList;
import org.openapitools.client.model.PostcardSize;
import org.openapitools.client.model.SendDate;
import org.openapitools.client.model.SortBy5;
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
        
        when(postcardsApiMock.postcardCreate(postcardEditable, "fake_key")).thenReturn(fakePostcard);
        Postcard response = postcardsApiMock.postcardCreate(postcardEditable, "fake_key");

        Assert.assertEquals(fakePostcard.getId(), response.getId());
    }

    @Test(enabled=true, groups={"Unit", "Create", "Postcard", "Invalid"}, expectedExceptions = {ApiException.class}, expectedExceptionsMessageRegExp = "error reported by API")
    public void postcardCreateTestCatchesException() throws ApiException {
        PostcardsApi postcardApiMock = mock(PostcardsApi.class);
        ApiException error = new ApiException("error reported by API");

        when(postcardApiMock.postcardCreate(null, null)).thenThrow(error);
        postcardApiMock.postcardCreate(null, null);

        Assert.fail("This should not happen");
    }

    @Test(enabled=true, groups={"Unit", "Create", "Postcard", "Invalid"}, expectedExceptions = {ApiException.class})
    public void postcardCreateTestCatchesExceptionWithResponseBody () throws ApiException {
        PostcardsApi postcardApiMock = mock(PostcardsApi.class);
        ApiException error = new ApiException("error", null, 500, null, "error reported by API");
        when(postcardApiMock.postcardCreate(null, null)).thenThrow(error);

        postcardApiMock.postcardCreate(null, null);

        Assert.fail("This should not happen");   
    }   
    
    @Test(enabled=true, groups={"Unit", "Delete", "Postcard", "Valid"})
    public void postcardDeleteTest() throws ApiException {
        PostcardsApi postcardsApiMock = mock(PostcardsApi.class);
        PostcardDeletion fakePostcard = new PostcardDeletion();

        fakePostcard.setId("psc_fakeId");
        
        when(postcardsApiMock.postcardDelete("psc_fakeId")).thenReturn(fakePostcard);
        PostcardDeletion response = postcardsApiMock.postcardDelete("psc_fakeId");

        Assert.assertEquals(fakePostcard.getId(), response.getId());
    }

    @Test(enabled=true, groups={"Unit", "Delete", "Postcard", "Invalid"}, expectedExceptions = {ApiException.class}, expectedExceptionsMessageRegExp = "error reported by API")
    public void postcardDeleteTestCatchesException() throws ApiException {
        PostcardsApi postcardApiMock = mock(PostcardsApi.class);
        ApiException error = new ApiException("error reported by API");

        when(postcardApiMock.postcardDelete(null)).thenThrow(error);
        postcardApiMock.postcardDelete(null);

        Assert.fail("This should not happen");
    }

    @Test(enabled=true, groups={"Unit", "Delete", "Postcard", "Invalid"}, expectedExceptions = {ApiException.class})
    public void postcardDeleteTestCatchesExceptionWithResponseBody () throws ApiException {
        PostcardsApi postcardApiMock = mock(PostcardsApi.class);
        ApiException error = new ApiException("error", null, 500, null, "error reported by API");
        when(postcardApiMock.postcardDelete(null)).thenThrow(error);

        postcardApiMock.postcardDelete(null);

        Assert.fail("This should not happen");   
    }   
    
    @Test(enabled=true, groups={"Unit", "Retrieve", "Postcard", "Valid"})
    public void postcardRetrieveTest() throws ApiException {
        PostcardsApi postcardsApiMock = mock(PostcardsApi.class);
        Postcard fakePostcard = new Postcard();

        fakePostcard.setId("psc_fakeId");
        
        when(postcardsApiMock.postcardRetrieve("psc_fakeId")).thenReturn(fakePostcard);
        Postcard response = postcardsApiMock.postcardRetrieve("psc_fakeId");

        Assert.assertEquals(fakePostcard.getId(), response.getId());
    }
    
    @Test(enabled=true, groups={"Unit", "Retrieve", "Postcard", "Invalid"}, expectedExceptions = {ApiException.class}, expectedExceptionsMessageRegExp = "error reported by API")
    public void postcardRetrieveTestCatchesException() throws ApiException {
        PostcardsApi postcardApiMock = mock(PostcardsApi.class);
        ApiException error = new ApiException("error reported by API");

        when(postcardApiMock.postcardRetrieve(null)).thenThrow(error);
        postcardApiMock.postcardRetrieve(null);

        Assert.fail("This should not happen");
    }

    @Test(enabled=true, groups={"Unit", "Retrieve", "Postcard", "Invalid"}, expectedExceptions = {ApiException.class})
    public void postcardRetrieveTestCatchesExceptionWithResponseBody () throws ApiException {
        PostcardsApi postcardApiMock = mock(PostcardsApi.class);
        ApiException error = new ApiException("error", null, 500, null, "error reported by API");
        when(postcardApiMock.postcardCreate(null, null)).thenThrow(error);

        postcardApiMock.postcardCreate(null, null);

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
        PostcardSize size = null;
        Boolean scheduled = null;
        SendDate sendDate = null;
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

        when(postcardApiMock.postcardsList(limit, before, after, include, dateCreated, metadata, size, scheduled, sendDate, mailType, sortBy)).thenReturn(fakePostcardList);
        PostcardList response = postcardApiMock.postcardsList(limit, before, after, include, dateCreated, metadata, size, scheduled, sendDate, mailType, sortBy);

        Assert.assertEquals(fakePostcardList.getCount(), response.getCount());  
    }
    
}

package Api;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.lob.api.ApiException;
import com.lob.api.client.LettersApi;

import org.openapitools.client.model.Letter;
import org.openapitools.client.model.LetterDeletion;
import org.openapitools.client.model.LetterEditable;
import org.openapitools.client.model.LetterList;
import org.openapitools.client.model.MailType;
import org.threeten.bp.OffsetDateTime;
import org.openapitools.client.model.SortBy5;
import org.testng.Assert;
import org.testng.annotations.Test;


@Test(enabled=true, groups={"Unit", "PMAPI", "Letter"})
public class LettersApiTest {
    @Test(enabled=true, groups={"Unit", "Cancel", "Letter", "Valid"})
    public void letterCancelTest() throws ApiException {
        LettersApi lettersApiMock = mock(LettersApi.class);
        LetterDeletion fakeLetter = new  LetterDeletion();

        fakeLetter.setId("ltr_fakeId");

        when(lettersApiMock.letterCancel("ltr_fakeId")).thenReturn(fakeLetter);
        LetterDeletion response = lettersApiMock.letterCancel("ltr_fakeId");

        Assert.assertEquals(fakeLetter.getId(), response.getId());
    }

    @Test(enabled=true, groups={"Unit", "Cancel", "Letter", "Invalid"}, expectedExceptions = {ApiException.class}, expectedExceptionsMessageRegExp = "error reported by API")
    public void letterCancelTestCatchesException() throws ApiException {
        LettersApi letterApiMock = mock(LettersApi.class);
        ApiException error = new ApiException("error reported by API");

        when(letterApiMock.letterCancel(null)).thenThrow(error);
        letterApiMock.letterCancel(null);

        Assert.fail("This should not happen");
    }

    @Test(enabled=true, groups={"Unit", "Cancel", "Letter", "Invalid"}, expectedExceptions = {ApiException.class})
    public void letterCancelTestCatchesExceptionWithResponseBody() throws ApiException {
        LettersApi letterApiMock = mock(LettersApi.class);
        ApiException error = new ApiException("error", null, 500, null, "error reported by API");
        when(letterApiMock.letterCancel(null)).thenThrow(error);

        letterApiMock.letterCancel(null);

        Assert.fail("This should not happen");   
    }   
    
    @Test(enabled=true, groups={"Unit", "Create", "Letter", "Valid"})
    public void letterCreateTest() throws ApiException {
        LettersApi lettersApiMock = mock(LettersApi.class);
        Letter fakeLetter = new  Letter();
        LetterEditable letterEditable = new LetterEditable();

        fakeLetter.setId("ltr_fakeId");

        when(lettersApiMock.letterCreate(letterEditable, "fake_key")).thenReturn(fakeLetter);
        Letter response = lettersApiMock.letterCreate(letterEditable, "fake_key");

        Assert.assertEquals(fakeLetter.getId(), response.getId());
    }

    @Test(enabled=true, groups={"Unit", "Create", "Letter", "Invalid"}, expectedExceptions = {ApiException.class}, expectedExceptionsMessageRegExp = "error reported by API")
    public void letterCreateTestCatchesException() throws ApiException {
        LettersApi letterApiMock = mock(LettersApi.class);
        ApiException error = new ApiException("error reported by API");

        when(letterApiMock.letterCreate(null, null)).thenThrow(error);
        letterApiMock.letterCreate(null, null);

        Assert.fail("This should not happen");
    }

    @Test(enabled=true, groups={"Unit", "Create", "Letter", "Invalid"}, expectedExceptions = {ApiException.class})
    public void letterCreateTestCatchesExceptionWithResponseBody() throws ApiException {
        LettersApi letterApiMock = mock(LettersApi.class);
        ApiException error = new ApiException("error", null, 500, null, "error reported by API");
        when(letterApiMock.letterCreate(null, null)).thenThrow(error);

        letterApiMock.letterCreate(null, null);

        Assert.fail("This should not happen");   
    }   
    
    @Test(enabled=true, groups={"Unit", "Retrieve", "Letter", "Valid"})
    public void letterRetrieveTest() throws ApiException {
        LettersApi lettersApiMock = mock(LettersApi.class);
        Letter fakeLetter = new  Letter();
       

        fakeLetter.setId("ltr_fakeId");

        when(lettersApiMock.letterRetrieve("ltr_Id")).thenReturn(fakeLetter);
        Letter response = lettersApiMock.letterRetrieve("ltr_Id");

        Assert.assertEquals(fakeLetter.getId(), response.getId());
    }

    @Test(enabled=true, groups={"Unit", "Retrieve", "Letter", "Invalid"}, expectedExceptions = {ApiException.class}, expectedExceptionsMessageRegExp = "error reported by API")
    public void letterRetrieveTestCatchesException() throws ApiException {
        LettersApi letterApiMock = mock(LettersApi.class);
        ApiException error = new ApiException("error reported by API");

        when(letterApiMock.letterRetrieve(null)).thenThrow(error);
        letterApiMock.letterRetrieve(null);

        Assert.fail("This should not happen");
    }

    @Test(enabled=true, groups={"Unit", "Retrieve", "Letter", "Invalid"}, expectedExceptions = {ApiException.class})
    public void letterRetrieveTestCatchesExceptionWithResponseBody() throws ApiException {
        LettersApi letterApiMock = mock(LettersApi.class);
        ApiException error = new ApiException("error", null, 500, null, "error reported by API");
        when(letterApiMock.letterRetrieve(null)).thenThrow(error);

        letterApiMock.letterRetrieve(null);

        Assert.fail("This should not happen");   
    }   
    
    @Test(enabled=false, groups={"Unit", "List", "Letter", "Valid"})
    public void lettersListTest() throws ApiException {
        Integer limit = null;
        String before = null;
        String after = null;
        List<String> include = null;
        Map<String, String> dateCreated = null;
        Map<String, String> metadata = null;
        Boolean color = null;
        Boolean scheduled = null;
        Map<String, String> sendDate = null;
        MailType mailType = null;
        SortBy5 sortBy = null;

        LettersApi lettersApiMock = mock(LettersApi.class);
        LetterList fakeLetterList = new LetterList();
        List<Letter> data = new ArrayList<Letter>();
        Letter data1 = new Letter();
        Letter data2 = new Letter();

        data1.setId("ltr_Id");
        data2.setId("ltr_Id");
        data.add(data1);
        data.add(data2);
        fakeLetterList.setData(data);
        fakeLetterList.setObject("list");
        fakeLetterList.setCount(data.size());

        when(lettersApiMock.lettersList(limit, before, after, include, dateCreated, metadata, color, scheduled, sendDate, mailType, sortBy)).thenReturn(fakeLetterList);
        LetterList response = lettersApiMock.lettersList(limit, before, after, include, dateCreated, metadata, color, scheduled, sendDate, mailType, sortBy);

        Assert.assertEquals(fakeLetterList.getCount(), response.getCount());
    }

    @Test(enabled=true, groups={"Unit", "List", "Letter", "Invalid"}, expectedExceptions = {ApiException.class}, expectedExceptionsMessageRegExp = "error reported by API")
    public void letterListTestCatchesException() throws ApiException {
        LettersApi letterApiMock = mock(LettersApi.class);
        ApiException error = new ApiException("error reported by API");

        when(letterApiMock.lettersList(null, null, null, null, null, null, null, null, null, null, null)).thenThrow(error);
        letterApiMock.lettersList(null, null, null, null, null, null, null, null, null, null, null);

        Assert.fail("This should not happen");
    }

    @Test(enabled=true, groups={"Unit", "List", "Letter", "Invalid"}, expectedExceptions = {ApiException.class})
    public void letterListTestCatchesExceptionWithResponseBody() throws ApiException {
        LettersApi letterApiMock = mock(LettersApi.class);
        ApiException error = new ApiException("error", null, 500, null, "error reported by API");
        when(letterApiMock.lettersList(null, null, null, null, null, null, null, null, null, null, null)).thenThrow(error);

        letterApiMock.lettersList(null, null, null, null, null, null, null, null, null, null, null);

        Assert.fail("This should not happen");   
    }   
    
}

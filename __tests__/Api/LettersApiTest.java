package Api;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.lob.api.ApiException;
import com.lob.api.client.LettersApi;

import com.lob.model.Letter;
import com.lob.model.LetterDeletion;
import com.lob.model.LetterEditable;
import com.lob.model.LetterList;
import com.lob.model.MailType;
import org.threeten.bp.OffsetDateTime;
import com.lob.model.SortBy5;
import org.testng.Assert;
import org.testng.annotations.Test;


@Test(enabled=true, groups={"Unit", "PMAPI", "Letter"})
public class LettersApiTest {
    @Test(enabled=true, groups={"Unit", "Cancel", "Letter", "Valid"})
    public void letterCancelTest() throws ApiException {
        LettersApi lettersApiMock = mock(LettersApi.class);
        LetterDeletion fakeLetter = new  LetterDeletion();

        fakeLetter.setId("ltr_fakeId");

        when(lettersApiMock.cancel("ltr_fakeId")).thenReturn(fakeLetter);
        LetterDeletion response = lettersApiMock.cancel("ltr_fakeId");

        Assert.assertEquals(fakeLetter.getId(), response.getId());
    }

    @Test(enabled=true, groups={"Unit", "Cancel", "Letter", "Invalid"}, expectedExceptions = {ApiException.class}, expectedExceptionsMessageRegExp = "error reported by API")
    public void letterCancelTestCatchesException() throws ApiException {
        LettersApi letterApiMock = mock(LettersApi.class);
        ApiException error = new ApiException("error reported by API");

        when(letterApiMock.cancel(null)).thenThrow(error);
        letterApiMock.cancel(null);

        Assert.fail("This should not happen");
    }

    @Test(enabled=true, groups={"Unit", "Cancel", "Letter", "Invalid"}, expectedExceptions = {ApiException.class})
    public void letterCancelTestCatchesExceptionWithResponseBody() throws ApiException {
        LettersApi letterApiMock = mock(LettersApi.class);
        ApiException error = new ApiException("error", null, 500, null, "error reported by API");
        when(letterApiMock.cancel(null)).thenThrow(error);

        letterApiMock.cancel(null);

        Assert.fail("This should not happen");   
    }   
    
    @Test(enabled=true, groups={"Unit", "Create", "Letter", "Valid"})
    public void letterCreateTest() throws ApiException {
        LettersApi lettersApiMock = mock(LettersApi.class);
        Letter fakeLetter = new  Letter();
        LetterEditable letterEditable = new LetterEditable();

        fakeLetter.setId("ltr_fakeId");

        when(lettersApiMock.create(letterEditable, "fake_key")).thenReturn(fakeLetter);
        Letter response = lettersApiMock.create(letterEditable, "fake_key");

        Assert.assertEquals(fakeLetter.getId(), response.getId());
    }

    @Test(enabled=true, groups={"Unit", "Create", "Letter", "Invalid"}, expectedExceptions = {ApiException.class}, expectedExceptionsMessageRegExp = "error reported by API")
    public void letterCreateTestCatchesException() throws ApiException {
        LettersApi letterApiMock = mock(LettersApi.class);
        ApiException error = new ApiException("error reported by API");

        when(letterApiMock.create(null, null)).thenThrow(error);
        letterApiMock.create(null, null);

        Assert.fail("This should not happen");
    }

    @Test(enabled=true, groups={"Unit", "Create", "Letter", "Invalid"}, expectedExceptions = {ApiException.class})
    public void letterCreateTestCatchesExceptionWithResponseBody() throws ApiException {
        LettersApi letterApiMock = mock(LettersApi.class);
        ApiException error = new ApiException("error", null, 500, null, "error reported by API");
        when(letterApiMock.create(null, null)).thenThrow(error);

        letterApiMock.create(null, null);

        Assert.fail("This should not happen");   
    }   
    
    @Test(enabled=true, groups={"Unit", "Get", "Letter", "Valid"})
    public void letterGetTest() throws ApiException {
        LettersApi lettersApiMock = mock(LettersApi.class);
        Letter fakeLetter = new  Letter();
       

        fakeLetter.setId("ltr_fakeId");

        when(lettersApiMock.get("ltr_Id")).thenReturn(fakeLetter);
        Letter response = lettersApiMock.get("ltr_Id");

        Assert.assertEquals(fakeLetter.getId(), response.getId());
    }

    @Test(enabled=true, groups={"Unit", "Get", "Letter", "Invalid"}, expectedExceptions = {ApiException.class}, expectedExceptionsMessageRegExp = "error reported by API")
    public void letterGetTestCatchesException() throws ApiException {
        LettersApi letterApiMock = mock(LettersApi.class);
        ApiException error = new ApiException("error reported by API");

        when(letterApiMock.get(null)).thenThrow(error);
        letterApiMock.get(null);

        Assert.fail("This should not happen");
    }

    @Test(enabled=true, groups={"Unit", "Get", "Letter", "Invalid"}, expectedExceptions = {ApiException.class})
    public void letterGetTestCatchesExceptionWithResponseBody() throws ApiException {
        LettersApi letterApiMock = mock(LettersApi.class);
        ApiException error = new ApiException("error", null, 500, null, "error reported by API");
        when(letterApiMock.get(null)).thenThrow(error);

        letterApiMock.get(null);

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

        when(lettersApiMock.list(limit, before, after, include, dateCreated, metadata, color, scheduled, sendDate, mailType, sortBy)).thenReturn(fakeLetterList);
        LetterList response = lettersApiMock.list(limit, before, after, include, dateCreated, metadata, color, scheduled, sendDate, mailType, sortBy);

        Assert.assertEquals(fakeLetterList.getCount(), response.getCount());
    }

    @Test(enabled=true, groups={"Unit", "List", "Letter", "Invalid"}, expectedExceptions = {ApiException.class}, expectedExceptionsMessageRegExp = "error reported by API")
    public void letterListTestCatchesException() throws ApiException {
        LettersApi letterApiMock = mock(LettersApi.class);
        ApiException error = new ApiException("error reported by API");

        when(letterApiMock.list(null, null, null, null, null, null, null, null, null, null, null)).thenThrow(error);
        letterApiMock.list(null, null, null, null, null, null, null, null, null, null, null);

        Assert.fail("This should not happen");
    }

    @Test(enabled=true, groups={"Unit", "List", "Letter", "Invalid"}, expectedExceptions = {ApiException.class})
    public void letterListTestCatchesExceptionWithResponseBody() throws ApiException {
        LettersApi letterApiMock = mock(LettersApi.class);
        ApiException error = new ApiException("error", null, 500, null, "error reported by API");
        when(letterApiMock.list(null, null, null, null, null, null, null, null, null, null, null)).thenThrow(error);

        letterApiMock.list(null, null, null, null, null, null, null, null, null, null, null);

        Assert.fail("This should not happen");   
    }   
    
}

package Api;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.lob.api.ApiException;
import com.lob.api.client.UsAutocompletionsApi;

import org.openapitools.client.model.UsAutocompletions;
import org.openapitools.client.model.UsAutocompletionsWritable;
import org.testng.Assert;
import org.testng.annotations.Test;


@Test(enabled=true, groups={"Unit", "Atlas", "Us Autocompletion"})
public class UsAutocompletionsApiTest {
    @Test(enabled=true, groups={"Unit", "Us Autocompletion", "Valid"})
    public void autocompletionTest() throws ApiException {
        UsAutocompletionsApi usAutocompletionApiMock = mock(UsAutocompletionsApi.class);
        UsAutocompletions fakeUsAutocompletions = new UsAutocompletions();
        UsAutocompletionsWritable usAutocompletionsWritable = new UsAutocompletionsWritable();
        
        fakeUsAutocompletions.setId("us_auto_fakeId");
        
        when(usAutocompletionApiMock.autocomplete(usAutocompletionsWritable)).thenReturn(fakeUsAutocompletions);
        UsAutocompletions response = usAutocompletionApiMock.autocomplete(usAutocompletionsWritable);

        Assert.assertEquals(fakeUsAutocompletions.getId(), response.getId());
    }

    @Test(enabled=true, groups={"Unit", "Us Autocompletion", "Invalid"}, expectedExceptions = {ApiException.class}, expectedExceptionsMessageRegExp = "error reported by API")
    public void autoCompletionTestCatchesException() throws ApiException {
        UsAutocompletionsApi usAutocompletionApiMock = mock(UsAutocompletionsApi.class);
        ApiException error = new ApiException("error reported by API");

        when(usAutocompletionApiMock.autocomplete(null)).thenThrow(error);
        usAutocompletionApiMock.autocomplete(null);

        Assert.fail("This should not happen");
    }

    @Test(enabled=true, groups={"Unit", "Us Autocompletion", "Invalid"}, expectedExceptions = {ApiException.class})
    public void autoCompletionTestCatchesExceptionWithResponseBody () throws ApiException {
        UsAutocompletionsApi usAutocompletionApiMock = mock(UsAutocompletionsApi.class);
        ApiException error = new ApiException("error", null, 500, null, "error reported by API");
        when(usAutocompletionApiMock.autocomplete(null)).thenThrow(error);

        usAutocompletionApiMock.autocomplete(null);

        Assert.fail("This should not happen");   
    }   
    
}

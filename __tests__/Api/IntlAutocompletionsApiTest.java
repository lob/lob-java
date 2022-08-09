package Api;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.lob.api.ApiException;
import com.lob.api.client.IntlAutocompletionsApi;

import com.lob.model.IntlAutocompletions;
import com.lob.model.IntlAutocompletionsWritable;
import org.testng.Assert;
import org.testng.annotations.Test;


@Test(enabled=true, groups={"Unit", "Atlas", "Intl Autocompletion"})
public class IntlAutocompletionsApiTest {
    @Test(enabled=true, groups={"Unit", "Intl Autocompletion", "Valid"})
    public void autocompletionTest() throws ApiException {
        IntlAutocompletionsApi intlAutocompletionApiMock = mock(IntlAutocompletionsApi.class);
        IntlAutocompletions fakeIntlAutocompletions = new IntlAutocompletions();
        IntlAutocompletionsWritable intlAutocompletionsWritable = new IntlAutocompletionsWritable();

        fakeIntlAutocompletions.setId("intl_auto_fakeId");

        when(intlAutocompletionApiMock.autocomplete(intlAutocompletionsWritable, null)).thenReturn(fakeIntlAutocompletions);
        IntlAutocompletions response = intlAutocompletionApiMock.autocomplete(intlAutocompletionsWritable, null);

        Assert.assertEquals(fakeIntlAutocompletions.getId(), response.getId());
    }

    @Test(enabled=true, groups={"Unit", "Intl Autocompletion", "Valid"})
    public void autocompletionTestWithXLangOutput() throws ApiException {
        IntlAutocompletionsApi intlAutocompletionApiMock = mock(IntlAutocompletionsApi.class);
        IntlAutocompletions fakeIntlAutocompletions = new IntlAutocompletions();
        IntlAutocompletionsWritable intlAutocompletionsWritable = new IntlAutocompletionsWritable();

        fakeIntlAutocompletions.setId("intl_auto_fakeId");

        when(intlAutocompletionApiMock.autocomplete(intlAutocompletionsWritable, "match")).thenReturn(fakeIntlAutocompletions);
        IntlAutocompletions response = intlAutocompletionApiMock.autocomplete(intlAutocompletionsWritable, "match");

        Assert.assertEquals(fakeIntlAutocompletions.getId(), response.getId());
    }

    @Test(enabled=true, groups={"Unit", "Intl Autocompletion", "Invalid"}, expectedExceptions = {ApiException.class}, expectedExceptionsMessageRegExp = "error reported by API")
    public void autoCompletionTestCatchesException() throws ApiException {
        IntlAutocompletionsApi intlAutocompletionApiMock = mock(IntlAutocompletionsApi.class);
        ApiException error = new ApiException("error reported by API");

        when(intlAutocompletionApiMock.autocomplete(null, null)).thenThrow(error);
        intlAutocompletionApiMock.autocomplete(null, null);

        Assert.fail("This should not happen");
    }

    @Test(enabled=true, groups={"Unit", "Intl Autocompletion", "Invalid"}, expectedExceptions = {ApiException.class})
    public void autoCompletionTestCatchesExceptionWithResponseBody () throws ApiException {
        IntlAutocompletionsApi intlAutocompletionApiMock = mock(IntlAutocompletionsApi.class);
        ApiException error = new ApiException("error", null, 500, null, "error reported by API");
        when(intlAutocompletionApiMock.autocomplete(null, null)).thenThrow(error);

        intlAutocompletionApiMock.autocomplete(null, null);

        Assert.fail("This should not happen");
    }

}

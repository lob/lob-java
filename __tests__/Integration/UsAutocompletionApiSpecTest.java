package Integration;

import com.lob.api.ApiException;
import com.lob.api.Configuration;
import com.lob.api.client.UsAutocompletionsApi;

import org.openapitools.client.model.UsAutocompletions;
import org.openapitools.client.model.UsAutocompletionsWritable;

import org.testng.Assert;
import org.testng.annotations.Test;



public class UsAutocompletionApiSpecTest {
    private UsAutocompletionsApi validApi = new UsAutocompletionsApi(Configuration.getConfigForIntegration()); 


    @Test(
        enabled=true,
        groups={"Integration", "AutoComplete", "UsAutocompletion", "Valid"}
    )
    public void AutocompleteTest() throws ApiException {
        UsAutocompletionsWritable autocompletionInput = new UsAutocompletionsWritable();
        autocompletionInput.setAddressPrefix("1313");
        autocompletionInput.setCity("WestField");
        autocompletionInput.setState("NJ");
        autocompletionInput.setZipCode("07090");
        autocompletionInput.setGeoIpSort(false);

        UsAutocompletions response = validApi.autocomplete(autocompletionInput);

        Assert.assertNotNull(response);
        //getSuggestionItems method missing
    }
    
}

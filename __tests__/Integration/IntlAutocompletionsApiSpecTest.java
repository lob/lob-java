package Integration;

import com.lob.api.ApiException;
import com.lob.api.Configuration;
import com.lob.api.client.IntlAutocompletionsApi;

import com.lob.model.IntlAutocompletions;
import com.lob.model.IntlAutocompletionsWritable;
import com.lob.model.CountryExtended;

import org.testng.Assert;
import org.testng.annotations.Test;



public class IntlAutocompletionsApiSpecTest {
    private IntlAutocompletionsApi validApi = new IntlAutocompletionsApi(Configuration.getConfigForIntegration());


    @Test(
        enabled=true,
        groups={"Integration", "AutoComplete", "IntlAutocompletion", "Valid"}
    )
    public void AutocompleteTest() throws ApiException {
        IntlAutocompletionsWritable intlAutocompletionsWritable = new IntlAutocompletionsWritable();
        intlAutocompletionsWritable.setAddressPrefix("340 Wat");
        intlAutocompletionsWritable.setCity("Summerside");
        intlAutocompletionsWritable.setState("Prince Edward Island");
        intlAutocompletionsWritable.setZipCode("C1N 1C4");
        intlAutocompletionsWritable.setCountry(CountryExtended.CA);

        IntlAutocompletions response = validApi.autocomplete(intlAutocompletionsWritable, null);
        Assert.assertNotNull(response);
        Assert.assertTrue(response.getSuggestions().size() > 0);
    }

}

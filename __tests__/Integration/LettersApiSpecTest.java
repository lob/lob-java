package Integration;

import java.util.ArrayList;
import java.util.List;

import com.lob.api.ApiException;
import com.lob.api.Configuration;
import com.lob.api.client.LettersApi;

import org.openapitools.client.model.Letter;
import org.openapitools.client.model.LetterEditable;
import org.openapitools.client.model.LetterDeletion;
import org.openapitools.client.model.AddressEditable;

import org.testng.Assert;
import org.testng.annotations.*;

import Helper.*;

public class LettersApiSpecTest {
    private LettersApi validApi;
    private LettersApi invalidApi;
    private TestFixtures testFixtures = new TestFixtures();
    @BeforeClass
    public void before_class()
    {
        validApi = new LettersApi(Configuration.getConfigForIntegration());
        invalidApi = new LettersApi(Configuration.getBadConfigForIntegration());
    }

    @DataProvider (name = "letter-create-data-provider")
    public Object[][] letterCreateDpMethod() {
        return new Object[][] {
            {"certified", LetterEditable.ExtraServiceEnum.CERTIFIED},
            {"registered", LetterEditable.ExtraServiceEnum.REGISTERED},
            {"none", LetterEditable.ExtraServiceEnum.NULL},
        };
    }

    @Test(
        enabled=true,
        groups={"Integration", "Create", "Letter", "Valid"},
        dataProvider = "letter-create-data-provider"
    )
    public void letterCreateCertifiedTest(String prop, LetterEditable.ExtraServiceEnum val) throws ApiException {
        LetterEditable letterEditable = new LetterEditable();

        List<AddressEditable> addressEditableList = testFixtures.get_ADDRESSES_EDITABLE();

        letterEditable.setTo(addressEditableList.get(0));
        letterEditable.setFrom(addressEditableList.get(0));
        letterEditable.setColor(true);
        letterEditable.setExtraService(val);
        letterEditable.setFile(testFixtures.get_FILE_LOCATION_8X11());

        // TODO: fix oneOf bug
        // Letter letter = validApi.letterCreate(letterEditable, null);

        // Assert.assertNotNull(letter.getId());
        // Assert.assertEquals(letter.getExtraService(), letter.getExtraService());

        // Letter retrievedLetter = validApi.letterRetrieve(letter.getId());
        // Assert.assertEquals(retrievedLetter.getId(), letter.getId());

        // LetterDeletion cancelledLetter = validApi.letterCancel(letter.getId());
        // Assert.assertTrue(cancelledLetter.getDeleted());
    }
}
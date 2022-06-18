package Integration;

import java.util.ArrayList;
import java.util.List;

import com.lob.api.ApiException;
import com.lob.api.Configuration;
import com.lob.api.client.CardOrdersApi;
import com.lob.api.client.CardsApi;

import com.lob.model.Card;
import com.lob.model.CardEditable;
import com.lob.model.CardEditable.SizeEnum;
import com.lob.model.CardOrder;
import com.lob.model.CardOrderEditable;
import com.lob.model.CardOrderList;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Helper.TestFixtures;

public class CardOrderApiSpecTest {
    private CardOrdersApi validApi;
    private CardOrdersApi invalidApi;
    private CardsApi validCardsApi;
    private Card dummyCard;
    private List<CardOrderEditable> createdCardOrderEditables = new ArrayList<CardOrderEditable>();

    @BeforeClass
    public void before_class()
    {
        TestFixtures tf = new TestFixtures();
        validApi = new CardOrdersApi(Configuration.getConfigForIntegration());
        validCardsApi = new CardsApi(Configuration.getConfigForIntegration());
        invalidApi = new CardOrdersApi(Configuration.getBadConfigForIntegration());

        CardOrderEditable coe1 = new CardOrderEditable();
        CardOrderEditable coe2 = new CardOrderEditable();
        CardOrderEditable coe3 = new CardOrderEditable();

        coe1.setQuantity(10001);
        coe2.setQuantity(10002);
        coe3.setQuantity(10003);
        
        createdCardOrderEditables.add(coe1);
        createdCardOrderEditables.add(coe2);
        createdCardOrderEditables.add(coe3);

        CardEditable editableCard = new CardEditable();
        editableCard.setDescription("Test Card");
        editableCard.setFront(tf.get_FILE_LOCATION());
        editableCard.setBack(tf.get_FILE_LOCATION());
        editableCard.setSize(SizeEnum._2_125X3_375);

        try {
            dummyCard = validCardsApi.create(editableCard);
        } catch (ApiException e) {
            e.printStackTrace();
        }
    }

    @Test(
        enabled=true,
        groups={"Integration", "Create", "Card Order", "Valid"}
    )
    public void cardOrderCreateTest() throws ApiException {
       CardOrder response = validApi.create(dummyCard.getId(), createdCardOrderEditables.get(0));

        Assert.assertNotNull(response.getId());
    }

    @Test(
        enabled=true,
        expectedExceptions={ApiException.class},
        expectedExceptionsMessageRegExp=".*Missing the required parameter 'cardOrderEditable'.*",
        groups={"Integration", "Create", "Card Order", "Invalid"}
    )
    public void cardOrderCreateTestBadParameter() throws ApiException {
        validApi.create(dummyCard.getId(), null);
    }

    @Test(
        enabled=true,
        expectedExceptions={ApiException.class},
        expectedExceptionsMessageRegExp=".*Your API key is not valid. Please sign up on lob.com to get a valid api key..*",
        groups={"Integration", "Create", "Card Order", "Invalid"}
    )
    public void cardOrderCreateTestInvalidCredentials() throws ApiException {
        try {
            invalidApi.create(dummyCard.getId(), createdCardOrderEditables.get(1));
        }
        catch(ApiException e) {
            throw e;
        }
    }

    @Test(
        enabled=true,
        groups={"Integration", "Get", "Card Order", "Valid"}
    )
    public void cardOrderRetrieveTest() throws ApiException {
        CardOrderList response = validApi.get(dummyCard.getId(), 10, null);
 
         Assert.assertTrue(response.getCount() > 0);
     }

}
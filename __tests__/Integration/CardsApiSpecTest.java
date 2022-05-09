package Integration;

import java.util.ArrayList;
import java.util.List;

import com.lob.api.ApiException;
import com.lob.api.Configuration;
import com.lob.api.client.CardsApi;

import org.openapitools.client.model.Card;
import org.openapitools.client.model.CardDeletion;
import org.openapitools.client.model.CardEditable;
import org.openapitools.client.model.CardEditable.SizeEnum;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Helper.TestFixtures;

public class CardsApiSpecTest {
    private CardsApi validApi;
    private CardsApi invalidApi;
    private Card dummyCard;
    private List<CardEditable> createdCardEditables = new ArrayList<CardEditable>();

    @BeforeClass
    public void before_class()
    {
        TestFixtures tf = new TestFixtures();
        validApi = new CardsApi(Configuration.getConfigForIntegration());
        invalidApi = new CardsApi(Configuration.getBadConfigForIntegration());

        CardEditable editableCard1 = new CardEditable();
        editableCard1.setDescription("Test Card 1");
        editableCard1.setFront(tf.get_FILE_LOCATION());
        editableCard1.setBack(tf.get_FILE_LOCATION());
        editableCard1.setSize(SizeEnum._2_125X3_375);

        CardEditable editableCard2 = new CardEditable();
        editableCard1.setDescription("Test Card 2");
        editableCard1.setFront(tf.get_FILE_LOCATION());
        editableCard1.setBack(tf.get_FILE_LOCATION());
        editableCard1.setSize(SizeEnum._2_125X3_375);


        CardEditable editableCard3 = new CardEditable();
        editableCard1.setDescription("Test Card 3");
        editableCard1.setFront(tf.get_FILE_LOCATION());
        editableCard1.setBack(tf.get_FILE_LOCATION());
        editableCard1.setSize(SizeEnum._2_125X3_375);

        createdCardEditables.add(editableCard1);
        createdCardEditables.add(editableCard2);
        createdCardEditables.add(editableCard3);
    }

    @Test(
        enabled=true,
        groups={"Integration", "Create", "Card", "Valid"}
    )
    public void cardCreateTest() throws ApiException {
       dummyCard = validApi.cardCreate(createdCardEditables.get(0));

        Assert.assertNotNull(dummyCard.getId());
    }

    @Test(
        enabled=true,
        expectedExceptions={ApiException.class},
        expectedExceptionsMessageRegExp=".*Missing the required parameter 'cardEditable'.*",
        groups={"Integration", "Create", "Card", "Invalid"}
    )
    public void cardCreateTestBadParameter() throws ApiException {
        validApi.cardCreate( null);
    }

    @Test(
        enabled=true,
        expectedExceptions={ApiException.class},
        expectedExceptionsMessageRegExp=".*Your API key is not valid. Please sign up on lob.com to get a valid api key..*",
        groups={"Integration", "Create", "Card", "Invalid"}
    )
    public void cardCreateTestInvalidCredentials() throws ApiException {
        try {
            invalidApi.cardCreate(createdCardEditables.get(1));
        }
        catch(ApiException e) {
            throw e;
        }
    }

    @Test(
        enabled=true,
        groups={"Integration", "Retrieve", "Card", "Valid"}
    )
    public void cardRetrieveTest() throws ApiException {
        Card response = validApi.cardRetrieve(dummyCard.getId());
 
         Assert.assertEquals(response.getId(), dummyCard.getId());
     }


    @Test(
        enabled=true,
        groups={"Integration", "Delete", "Card", "Valid"}
    )
    public void cardDeleteTest() throws ApiException {
        CardDeletion response = validApi.cardDelete(dummyCard.getId());
 
         Assert.assertEquals(response.getId(), dummyCard.getId());
     }
}
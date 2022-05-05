package Api;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.lob.api.ApiException;
import com.lob.api.client.CardsApi;

import org.openapitools.client.model.Card;
import org.openapitools.client.model.CardDeletion;
import org.openapitools.client.model.CardEditable;
import org.openapitools.client.model.CardList;
import org.openapitools.client.model.CardUpdatable;
import org.openapitools.client.model.SortBy5;
import org.testng.Assert;
import org.testng.annotations.Test;


@Test(enabled=true, groups={"Unit", "Card"})
public class CardsApiTest {
    @Test(enabled=true, groups={"Unit", "Create", "Card", "Valid"})
    public void cardCreateTest() throws ApiException {
        CardsApi cardApiMock = mock(CardsApi.class);
        Card fakeCard = new Card();
        CardEditable CardEditable = new CardEditable();
        
        fakeCard.setId("card_fakeId");
        when(cardApiMock.cardCreate(CardEditable)).thenReturn(fakeCard);
        Card response = cardApiMock.cardCreate(CardEditable);
        
        Assert.assertEquals(fakeCard.getId(), response.getId());
    }

    @Test(enabled=true, groups={"Unit", "Create", "Card", "Invalid"}, expectedExceptions = {ApiException.class}, expectedExceptionsMessageRegExp = "error reported by API")
    public void cardsCreateTestCatchesException() throws ApiException {
        CardsApi cardApiMock = mock(CardsApi.class);
        ApiException error = new ApiException("error reported by API");

        when(cardApiMock.cardCreate(null)).thenThrow(error);
        cardApiMock.cardCreate(null);

        Assert.fail("This should not happen");
    }

    @Test(enabled=true, groups={"Unit", "Create", "Card", "Invalid"}, expectedExceptions = {ApiException.class})
    public void cardsCreateTestCatchesExceptionWithResponseBody () throws ApiException {
        CardsApi cardApiMock = mock(CardsApi.class);
        ApiException error = new ApiException("error", null, 500, null, "error reported by API");
        when(cardApiMock.cardCreate(null)).thenThrow(error);

        cardApiMock.cardCreate(null);

        Assert.fail("This should not happen");   
    }   
    
    @Test(enabled=true, groups={"Unit", "Delete", "Card", "Valid"})
    public void cardDeleteTest() throws ApiException {
        CardsApi cardApiMock = mock(CardsApi.class);
        CardDeletion fakeCard = new CardDeletion();
        fakeCard.setId("card_fakeId");
        fakeCard.setDeleted(true);
        when(cardApiMock.cardDelete("card_fakeId")).thenReturn(fakeCard);
        CardDeletion response = cardApiMock.cardDelete("card_fakeId");
        Assert.assertEquals(fakeCard.getId(), response.getId());
        Assert.assertEquals(fakeCard.getDeleted(), response.getDeleted());
    }

    @Test(enabled=true, groups={"Unit", "Delete", "Card", "Invalid"}, expectedExceptions = {ApiException.class}, expectedExceptionsMessageRegExp = "error reported by API")
    public void cardsDeleteTestCatchesException() throws ApiException {
        CardsApi cardApiMock = mock(CardsApi.class);
        ApiException error = new ApiException("error reported by API");

        when(cardApiMock.cardDelete(null)).thenThrow(error);
        cardApiMock.cardDelete(null);

        Assert.fail("This should not happen");
    }

    @Test(enabled=true, groups={"Unit", "Delete", "Card", "Invalid"}, expectedExceptions = {ApiException.class})
    public void cardsDeleteTestCatchesExceptionWithResponseBody() throws ApiException {
        CardsApi cardApiMock = mock(CardsApi.class);
        ApiException error = new ApiException("error", null, 500, null, "error reported by API");
        when(cardApiMock.cardDelete(null)).thenThrow(error);

        cardApiMock.cardDelete(null);

        Assert.fail("This should not happen");   
    }   
    
    @Test(enabled=true, groups={"Unit", "Retrieve", "Card", "Valid"})
    public void cardRetrieveTest() throws ApiException {
        CardsApi cardApiMock = mock(CardsApi.class);
        Card fakeCard = new Card();
        fakeCard.setId("card_fakeId");
        fakeCard.setDeleted(true);
        when(cardApiMock.cardRetrieve("card_fakeId")).thenReturn(fakeCard);
        Card response = cardApiMock.cardRetrieve("card_fakeId");
        Assert.assertEquals(fakeCard.getId(), response.getId());
    }

    @Test(enabled=true, groups={"Unit", "Retrieve", "Card", "Invalid"}, expectedExceptions = {ApiException.class}, expectedExceptionsMessageRegExp = "error reported by API")
    public void cardsRetrieveTestCatchesException() throws ApiException {
        CardsApi cardApiMock = mock(CardsApi.class);
        ApiException error = new ApiException("error reported by API");

        when(cardApiMock.cardRetrieve(null)).thenThrow(error);
        cardApiMock.cardRetrieve(null);

        Assert.fail("This should not happen");
    }

    @Test(enabled=true, groups={"Unit", "Retrieve", "Card", "Invalid"}, expectedExceptions = {ApiException.class})
    public void cardsRetrieveTestCatchesExceptionWithResponseBody() throws ApiException {
        CardsApi cardApiMock = mock(CardsApi.class);
        ApiException error = new ApiException("error", null, 500, null, "error reported by API");
        when(cardApiMock.cardRetrieve(null)).thenThrow(error);

        cardApiMock.cardRetrieve(null);

        Assert.fail("This should not happen");   
    }   
    
    @Test(enabled=true, groups={"Unit", "Update", "Card", "Valid"})
    public void cardUpdateTest() throws ApiException {
        CardsApi cardApiMock = mock(CardsApi.class);
        Card fakeCard = new Card();
        CardUpdatable CardUpdatable = new CardUpdatable();
        
        fakeCard.setId("card_fakeId");

        when(cardApiMock.cardUpdate("card_fakeId", CardUpdatable)).thenReturn(fakeCard);
        Card response = cardApiMock.cardUpdate("card_fakeId", CardUpdatable);
        
        Assert.assertEquals(fakeCard.getId(), response.getId());
    }
    
    @Test(enabled=true, groups={"Unit", "Update", "Card", "Invalid"}, expectedExceptions = {ApiException.class}, expectedExceptionsMessageRegExp = "error reported by API")
    public void cardsUpdateTestCatchesException() throws ApiException {
        CardsApi cardApiMock = mock(CardsApi.class);
        ApiException error = new ApiException("error reported by API");

        when(cardApiMock.cardUpdate("null",null)).thenThrow(error);
        cardApiMock.cardUpdate("null", null);

        Assert.fail("This should not happen");
    }

    @Test(enabled=true, groups={"Unit", "Update", "Card", "Invalid"},  expectedExceptions = {ApiException.class})
    public void cardsUpdateTestCatchesExceptionWithResponseBody() throws ApiException {
        CardsApi cardApiMock = mock(CardsApi.class);
        ApiException error = new ApiException("error", null, 500, null, "error reported by API");
        when(cardApiMock.cardUpdate("null", null)).thenThrow(error);

        cardApiMock.cardUpdate("null", null);

        Assert.fail("This should not happen");   
    }   
    
    @Test(enabled=true, groups={"Unit", "List", "Card", "Valid"})
    public void CardsListTest() throws ApiException {
        Integer limit = 2;
        String before = null;
        String after = null;
        SortBy5 sortBy = null;
        CardsApi cardApiMock = mock(CardsApi.class);
        CardList fakeCard = new CardList();
        Card data1 = new Card();
        Card data2 = new Card();
        List<Card> data = new ArrayList<Card>();

        data1.setId("card_Id");
        data2.setId("card_Id2");
        data.add(data1);
        data.add(data2);
        fakeCard.setData(data);
        fakeCard.setObject("list");
        fakeCard.setCount(data.size());

        when(cardApiMock.cardsList(limit, before, after, sortBy)).thenReturn(fakeCard);
        CardList response = cardApiMock.cardsList(limit, before, after, sortBy);
    
        Assert.assertEquals(fakeCard.getCount(), response.getCount());
    }

    @Test(enabled=true, groups={"Unit", "List", "Card", "Invalid"}, expectedExceptions = {ApiException.class}, expectedExceptionsMessageRegExp = "error reported by API")
    public void cardsListTestCatchesException() throws ApiException {
        CardsApi cardApiMock = mock(CardsApi.class);
        ApiException error = new ApiException("error reported by API");

        when(cardApiMock.cardsList(null, null, null, null)).thenThrow(error);
        cardApiMock.cardsList(null, null, null, null);

        Assert.fail("This should not happen");
    }

    @Test(enabled=true, groups={"Unit", "List", "Card", "Invalid"}, expectedExceptions = {ApiException.class})
    public void cardsListTestCatchesExceptionWithResponseBody() throws ApiException {
        CardsApi cardApiMock = mock(CardsApi.class);
        ApiException error = new ApiException("error", null, 500, null, "error reported by API");
        when(cardApiMock.cardsList(null, null, null, null)).thenThrow(error);

        cardApiMock.cardsList(null, null, null, null);

        Assert.fail("This should not happen");   
    }   
}

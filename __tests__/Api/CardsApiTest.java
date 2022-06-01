package Api;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.lob.api.ApiException;
import com.lob.api.client.CardsApi;

import com.lob.model.Card;
import com.lob.model.CardDeletion;
import com.lob.model.CardEditable;
import com.lob.model.CardList;
import com.lob.model.CardUpdatable;
import com.lob.model.SortBy5;
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
        when(cardApiMock.create(CardEditable)).thenReturn(fakeCard);
        Card response = cardApiMock.create(CardEditable);
        
        Assert.assertEquals(fakeCard.getId(), response.getId());
    }

    @Test(enabled=true, groups={"Unit", "Create", "Card", "Invalid"}, expectedExceptions = {ApiException.class}, expectedExceptionsMessageRegExp = "error reported by API")
    public void cardsCreateTestCatchesException() throws ApiException {
        CardsApi cardApiMock = mock(CardsApi.class);
        ApiException error = new ApiException("error reported by API");

        when(cardApiMock.create(null)).thenThrow(error);
        cardApiMock.create(null);

        Assert.fail("This should not happen");
    }

    @Test(enabled=true, groups={"Unit", "Create", "Card", "Invalid"}, expectedExceptions = {ApiException.class})
    public void cardsCreateTestCatchesExceptionWithResponseBody () throws ApiException {
        CardsApi cardApiMock = mock(CardsApi.class);
        ApiException error = new ApiException("error", null, 500, null, "error reported by API");
        when(cardApiMock.create(null)).thenThrow(error);

        cardApiMock.create(null);

        Assert.fail("This should not happen");   
    }   
    
    @Test(enabled=true, groups={"Unit", "Delete", "Card", "Valid"})
    public void cardDeleteTest() throws ApiException {
        CardsApi cardApiMock = mock(CardsApi.class);
        CardDeletion fakeCard = new CardDeletion();
        fakeCard.setId("card_fakeId");
        fakeCard.setDeleted(true);
        when(cardApiMock.delete("card_fakeId")).thenReturn(fakeCard);
        CardDeletion response = cardApiMock.delete("card_fakeId");
        Assert.assertEquals(fakeCard.getId(), response.getId());
        Assert.assertEquals(fakeCard.getDeleted(), response.getDeleted());
    }

    @Test(enabled=true, groups={"Unit", "Delete", "Card", "Invalid"}, expectedExceptions = {ApiException.class}, expectedExceptionsMessageRegExp = "error reported by API")
    public void cardsDeleteTestCatchesException() throws ApiException {
        CardsApi cardApiMock = mock(CardsApi.class);
        ApiException error = new ApiException("error reported by API");

        when(cardApiMock.delete(null)).thenThrow(error);
        cardApiMock.delete(null);

        Assert.fail("This should not happen");
    }

    @Test(enabled=true, groups={"Unit", "Delete", "Card", "Invalid"}, expectedExceptions = {ApiException.class})
    public void cardsDeleteTestCatchesExceptionWithResponseBody() throws ApiException {
        CardsApi cardApiMock = mock(CardsApi.class);
        ApiException error = new ApiException("error", null, 500, null, "error reported by API");
        when(cardApiMock.delete(null)).thenThrow(error);

        cardApiMock.delete(null);

        Assert.fail("This should not happen");   
    }   
    
    @Test(enabled=true, groups={"Unit", "Get", "Card", "Valid"})
    public void cardGetTest() throws ApiException {
        CardsApi cardApiMock = mock(CardsApi.class);
        Card fakeCard = new Card();
        fakeCard.setId("card_fakeId");
        fakeCard.setDeleted(true);
        when(cardApiMock.get("card_fakeId")).thenReturn(fakeCard);
        Card response = cardApiMock.get("card_fakeId");
        Assert.assertEquals(fakeCard.getId(), response.getId());
    }

    @Test(enabled=true, groups={"Unit", "Get", "Card", "Invalid"}, expectedExceptions = {ApiException.class}, expectedExceptionsMessageRegExp = "error reported by API")
    public void cardsGetTestCatchesException() throws ApiException {
        CardsApi cardApiMock = mock(CardsApi.class);
        ApiException error = new ApiException("error reported by API");

        when(cardApiMock.get(null)).thenThrow(error);
        cardApiMock.get(null);

        Assert.fail("This should not happen");
    }

    @Test(enabled=true, groups={"Unit", "Get", "Card", "Invalid"}, expectedExceptions = {ApiException.class})
    public void cardsGetTestCatchesExceptionWithResponseBody() throws ApiException {
        CardsApi cardApiMock = mock(CardsApi.class);
        ApiException error = new ApiException("error", null, 500, null, "error reported by API");
        when(cardApiMock.get(null)).thenThrow(error);

        cardApiMock.get(null);

        Assert.fail("This should not happen");   
    }   
    
    @Test(enabled=true, groups={"Unit", "Update", "Card", "Valid"})
    public void cardUpdateTest() throws ApiException {
        CardsApi cardApiMock = mock(CardsApi.class);
        Card fakeCard = new Card();
        CardUpdatable CardUpdatable = new CardUpdatable();
        
        fakeCard.setId("card_fakeId");

        when(cardApiMock.update("card_fakeId", CardUpdatable)).thenReturn(fakeCard);
        Card response = cardApiMock.update("card_fakeId", CardUpdatable);
        
        Assert.assertEquals(fakeCard.getId(), response.getId());
    }
    
    @Test(enabled=true, groups={"Unit", "Update", "Card", "Invalid"}, expectedExceptions = {ApiException.class}, expectedExceptionsMessageRegExp = "error reported by API")
    public void cardsUpdateTestCatchesException() throws ApiException {
        CardsApi cardApiMock = mock(CardsApi.class);
        ApiException error = new ApiException("error reported by API");

        when(cardApiMock.update("null",null)).thenThrow(error);
        cardApiMock.update("null", null);

        Assert.fail("This should not happen");
    }

    @Test(enabled=true, groups={"Unit", "Update", "Card", "Invalid"},  expectedExceptions = {ApiException.class})
    public void cardsUpdateTestCatchesExceptionWithResponseBody() throws ApiException {
        CardsApi cardApiMock = mock(CardsApi.class);
        ApiException error = new ApiException("error", null, 500, null, "error reported by API");
        when(cardApiMock.update("null", null)).thenThrow(error);

        cardApiMock.update("null", null);

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

        when(cardApiMock.list(limit, before, after, sortBy)).thenReturn(fakeCard);
        CardList response = cardApiMock.list(limit, before, after, sortBy);
    
        Assert.assertEquals(fakeCard.getCount(), response.getCount());
    }

    @Test(enabled=true, groups={"Unit", "List", "Card", "Invalid"}, expectedExceptions = {ApiException.class}, expectedExceptionsMessageRegExp = "error reported by API")
    public void cardsListTestCatchesException() throws ApiException {
        CardsApi cardApiMock = mock(CardsApi.class);
        ApiException error = new ApiException("error reported by API");

        when(cardApiMock.list(null, null, null, null)).thenThrow(error);
        cardApiMock.list(null, null, null, null);

        Assert.fail("This should not happen");
    }

    @Test(enabled=true, groups={"Unit", "List", "Card", "Invalid"}, expectedExceptions = {ApiException.class})
    public void cardsListTestCatchesExceptionWithResponseBody() throws ApiException {
        CardsApi cardApiMock = mock(CardsApi.class);
        ApiException error = new ApiException("error", null, 500, null, "error reported by API");
        when(cardApiMock.list(null, null, null, null)).thenThrow(error);

        cardApiMock.list(null, null, null, null);

        Assert.fail("This should not happen");   
    }   
}

package Api;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.lob.api.ApiException;
import com.lob.api.client.CardOrdersApi;

import org.openapitools.client.model.CardOrder;
import org.openapitools.client.model.CardOrderEditable;
import org.openapitools.client.model.CardOrderList;
import org.testng.Assert;
import org.testng.annotations.Test;


@Test(enabled=true, groups={"Unit", "Card Order"})
public class CardOrdersApiTest {
    @Test(enabled=true, groups={"Unit", "Create", "Card Order", "Valid"})
    public void cardOrderCreateTest() throws ApiException {
        CardOrdersApi CardOrderApiMock = mock(CardOrdersApi.class);
        CardOrder fakeCardOrder = new CardOrder();
        CardOrderEditable CardOrderEditable = new CardOrderEditable();

        fakeCardOrder.setId("co_fakeId");
        
        when(CardOrderApiMock.cardOrderCreate("co_fakeId", CardOrderEditable)).thenReturn(fakeCardOrder);
        CardOrder response = CardOrderApiMock.cardOrderCreate("co_fakeId", CardOrderEditable);
        
        Assert.assertEquals(fakeCardOrder.getId(), response.getId());
    }

    @Test(enabled=true, groups={"Unit", "Create", "Card Order", "Invalid"}, expectedExceptions = {ApiException.class}, expectedExceptionsMessageRegExp = "error reported by API")
    public void cardOrderCreateTestCatchesException() throws ApiException {
        CardOrdersApi cardOrderApiMock = mock(CardOrdersApi.class);
        ApiException error = new ApiException("error reported by API");
        
        when(cardOrderApiMock.cardOrderCreate("null", null)).thenThrow(error);
        cardOrderApiMock.cardOrderCreate("null", null);
        
        Assert.fail("This should not happen");
    }

    @Test(enabled=true, groups={"Unit", "Create", "Card Order", "Invalid"}, expectedExceptions = {ApiException.class})
    public void cardOrderCreateTestCatchesExceptionWithResponseBody() throws ApiException {
        CardOrdersApi cardOrderApiMock = mock(CardOrdersApi.class);
        ApiException error = new ApiException("error", null, 500, null, "error reported by API");
        
        when(cardOrderApiMock.cardOrderCreate("null", null)).thenThrow(error);
        cardOrderApiMock.cardOrderCreate("null", null);
        
        Assert.fail("This should not happen");   
    }

    @Test(enabled=true, groups={"Unit", "Retrieve", "Card Order", "Valid"})
    public void cardOrderRetrieveTest() throws ApiException {
        CardOrdersApi CardOrderApiMock = mock(CardOrdersApi.class);
        CardOrderList fakeCardOrders = new CardOrderList();
        List<CardOrder> data = new ArrayList<CardOrder>();
        CardOrder data1 = new CardOrder();

        data.add(data1); 
        fakeCardOrders.setData(data);
        fakeCardOrders.setObject("list");
        fakeCardOrders.setCount(data.size());
        
        when(CardOrderApiMock.cardOrdersRetrieve("co_fakeId")).thenReturn(fakeCardOrders);
        CardOrderList response = CardOrderApiMock.cardOrdersRetrieve("co_fakeId");

        Assert.assertEquals(fakeCardOrders.getCount(), response.getCount()); 
    }

    @Test(enabled=true, groups={"Unit", "Retrieve", "Card Order", "Invalid"}, expectedExceptions = {ApiException.class}, expectedExceptionsMessageRegExp = "error reported by API")
    public void cardOrderRetrieveTestCatchesException() throws ApiException {
        CardOrdersApi cardOrderApiMock = mock(CardOrdersApi.class);
        ApiException error = new ApiException("error reported by API");
        
        when(cardOrderApiMock.cardOrdersRetrieve(null)).thenThrow(error);
        cardOrderApiMock.cardOrdersRetrieve(null);
        
        Assert.fail("This should not happen");
    }

    @Test(enabled=true, groups={"Unit", "Retrieve", "Card Order", "Invalid"}, expectedExceptions = {ApiException.class})
    public void cardOrderRetrieveTestCatchesExceptionWithResponseBody() throws ApiException {
        CardOrdersApi cardOrderApiMock = mock(CardOrdersApi.class);
        ApiException error = new ApiException("error", null, 500, null, "error reported by API");
        
        when(cardOrderApiMock.cardOrdersRetrieve(null)).thenThrow(error);
        cardOrderApiMock.cardOrdersRetrieve(null);
        
        Assert.fail("This should not happen");   
    }

    
}
package Api;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.lob.api.ApiException;
import com.lob.api.client.AddressesApi;

import com.lob.model.Address;
import com.lob.model.AddressDeletion;
import com.lob.model.AddressEditable;
import com.lob.model.AddressList;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test(enabled=true, groups={"Unit", "PMAPI", "Address"})
public class AddressesApiTest {
    @Test(enabled=true, groups={"Unit", "Create", "Address", "Valid"})
    public void addressCreateTest() throws ApiException {
        AddressesApi addressApiMock = mock(AddressesApi.class);
        Address fakeAddress = new Address();
        AddressEditable addressEditable = new AddressEditable();
        
        fakeAddress.setId("adr_fakeId");
        
        when(addressApiMock.create(addressEditable)).thenReturn(fakeAddress);
        Address response = addressApiMock.create(addressEditable);

        Assert.assertEquals(fakeAddress.getId(), response.getId());
    }

    @Test(enabled=true, groups={"Unit", "Create", "Address", "Invalid"}, expectedExceptions = {ApiException.class}, expectedExceptionsMessageRegExp = "error reported by API")
    public void addressCreateTestCatchesException() throws ApiException {
        AddressesApi addressApiMock = mock(AddressesApi.class);
        ApiException error = new ApiException("error reported by API");

        when(addressApiMock.create(null)).thenThrow(error);
        addressApiMock.create(null);

        Assert.fail("This should not happen");
    }

    @Test(enabled=true, groups={"Unit", "Create", "Address", "Invalid"}, expectedExceptions = {ApiException.class})
    public void addressCreateTestCatchesExceptionWithResponseBody () throws ApiException {
        AddressesApi addressApiMock = mock(AddressesApi.class);
        ApiException error = new ApiException("error", null, 500, null, "error reported by API");
        when(addressApiMock.create(null)).thenThrow(error);

        addressApiMock.create(null);

        Assert.fail("This should not happen");   
    }   
    
    @Test(enabled=true, groups={"Unit", "Delete", "Address", "Valid"})
    public void addressDeleteTest() throws ApiException {
        AddressesApi addressApiMock = mock(AddressesApi.class);
        AddressDeletion fakeAddress = new AddressDeletion();

        fakeAddress.setId("adr_fakeId");
        fakeAddress.setDeleted(true);

        when(addressApiMock.delete("adr_fakeId")).thenReturn(fakeAddress);
        AddressDeletion response = addressApiMock.delete("adr_fakeId");

        Assert.assertEquals(fakeAddress.getId(), response.getId());
        Assert.assertEquals(fakeAddress.getDeleted(), response.getDeleted());
    }

    @Test(enabled=true, groups={"Unit", "Delete", "Address", "Invalid"}, expectedExceptions = {ApiException.class}, expectedExceptionsMessageRegExp = "error reported by API")
    public void addressDeleteTestCatchesException() throws ApiException {
        AddressesApi addressApiMock = mock(AddressesApi.class);
        ApiException error = new ApiException("error reported by API");

        when(addressApiMock.delete(null)).thenThrow(error);
        addressApiMock.delete(null);

        Assert.fail("This should not happen");
    }

    @Test(enabled=true,  groups={"Unit", "Delete", "Address", "Invalid"}, expectedExceptions = {ApiException.class})
    public void addressDeleteTestCatchesExceptionWithResponseBody() throws ApiException {
        AddressesApi addressApiMock = mock(AddressesApi.class);
        ApiException error = new ApiException("error", null, 500, null, "error reported by API");
        
        when(addressApiMock.delete(null)).thenThrow(error);
        addressApiMock.delete(null);

        Assert.fail("This should not happen");   
    }
    
    @Test(enabled=true, groups={"Unit", "Get", "Address", "Valid"})
    public void addressGetTest() throws ApiException {
        AddressesApi addressApiMock = mock(AddressesApi.class);
        Address fakeAddress = new Address();

        fakeAddress.setId("adr_Id");

        when(addressApiMock.get("adr_Id")).thenReturn(fakeAddress);
        Address response = addressApiMock.get("adr_Id");

        Assert.assertEquals(fakeAddress.getId(), response.getId());
    }

    @Test(enabled=true, groups={"Unit", "Get", "Address", "Invalid"}, expectedExceptions = {ApiException.class}, expectedExceptionsMessageRegExp = "error reported by API")
    public void addressGetTestCatchesException() throws ApiException {
        AddressesApi addressApiMock = mock(AddressesApi.class);
        ApiException error = new ApiException("error reported by API");

        when(addressApiMock.get(null)).thenThrow(error);
        addressApiMock.get(null);

        Assert.fail("This should not happen");
    }

    @Test(enabled=true,  groups={"Unit", "Get", "Address", "Invalid"}, expectedExceptions = {ApiException.class})
    public void addressGetTestCatchesExceptionWithResponseBody() throws ApiException {
        AddressesApi addressApiMock = mock(AddressesApi.class);
        ApiException error = new ApiException("error", null, 500, null, "error reported by API");

        when(addressApiMock.get(null)).thenThrow(error);
        addressApiMock.get(null);

        Assert.fail("This should not happen");   
    }
    
    @Test(enabled=true,  groups={"Unit", "List", "Address", "Valid"})
    public void addressesListTest() throws ApiException {
        Integer limit = 2;
        String before = null;
        String after = null;
        List<String> include = null;
        Map<String, String> dateCreated = null;
        Map<String, String> metadata = null;
        AddressesApi addressApiMock = mock(AddressesApi.class);
        AddressList fakeAddress = new AddressList();
        List<Address> data = new ArrayList<Address>();
        Address data1 = new Address();
        Address data2 = new Address();

        data1.setId("adr_Id");
        data2.setId("adr_Id2");
        data.add(data1);
        data.add(data2);
        fakeAddress.setData(data);
        fakeAddress.setObject("list");
        fakeAddress.setCount(data.size());

        when(addressApiMock.list(limit, before, after, include, dateCreated, metadata)).thenReturn(fakeAddress);
        AddressList response = addressApiMock.list(limit, before, after, include, dateCreated, metadata);

        Assert.assertEquals(fakeAddress.getCount(), response.getCount());
    }

    @Test(enabled=true, groups={"Unit", "List", "Address", "Invalid"}, expectedExceptions = {ApiException.class}, expectedExceptionsMessageRegExp = "error reported by API")
    public void addressListTestCatchesException() throws ApiException {
        AddressesApi addressApiMock = mock(AddressesApi.class);
        ApiException error = new ApiException("error reported by API");

        when(addressApiMock.list(null, null, null, null, null, null)).thenThrow(error);
        addressApiMock.list(null, null, null, null, null, null);  

        Assert.fail("This should not happen");   
    }

    @Test(enabled=true,  groups={"Unit", "List", "Address", "Invalid"}, expectedExceptions = {ApiException.class})
    public void addressListTestCatchesExceptionWithResponseBody() throws ApiException {
        AddressesApi addressApiMock = mock(AddressesApi.class);
        ApiException error = new ApiException("error", null, 500, null, "error reported by API");

        when(addressApiMock.list(null, null, null, null, null, null)).thenThrow(error);
        addressApiMock.list(null, null, null, null, null, null);

        Assert.fail("This should not happen");   
    }
   
}

package Api;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.lob.api.ApiException;
import com.lob.api.client.BankAccountsApi;

import org.openapitools.client.model.BankAccount;
import org.openapitools.client.model.BankAccountDeletion;
import org.openapitools.client.model.BankAccountList;
import org.openapitools.client.model.BankAccountVerify;
import org.openapitools.client.model.BankAccountWritable;
import org.testng.Assert;
import org.testng.annotations.Test;


@Test(enabled=true, groups={"Unit", "Billing", "Bank Account"})
public class BankAccountsApiTest {
    @Test(enabled=true, groups={"Unit", "Create", "Bank Account", "Valid"})
    public void bankAccountCreateTest() throws ApiException {
        BankAccountsApi bankAccountsApiMock = mock(BankAccountsApi.class);
        BankAccount fakeAccount = new BankAccount();
        BankAccountWritable bankAccountWritable = new BankAccountWritable();
        
        fakeAccount.setId("bank_fakeId");
        when(bankAccountsApiMock.create(bankAccountWritable)).thenReturn(fakeAccount);
        BankAccount response = bankAccountsApiMock.create(bankAccountWritable);
        
        Assert.assertEquals(fakeAccount.getId(), response.getId());
    }

    @Test(enabled=true, groups={"Unit", "Create", "Bank Account", "Invalid"}, expectedExceptions = {ApiException.class}, expectedExceptionsMessageRegExp = "error reported by API")
    public void bankAccountCreateTestCatchesException() throws ApiException {
        BankAccountsApi bankAccountsApiMock = mock(BankAccountsApi.class);
        ApiException error = new ApiException("error reported by API");
        
        when(bankAccountsApiMock.create(null)).thenThrow(error);
        bankAccountsApiMock.create(null);
        
        Assert.fail("This should not happen");
    }

    @Test(enabled=true, groups={"Unit", "Create", "Bank Account", "Invalid"}, expectedExceptions = {ApiException.class})
    public void bankAccountCreateTestCatchesExceptionWithResponseBody() throws ApiException {
        BankAccountsApi bankAccountsApiMock = mock(BankAccountsApi.class);
        ApiException error = new ApiException("error", null, 500, null, "error reported by API");
        
        when(bankAccountsApiMock.create(null)).thenThrow(error);
        bankAccountsApiMock.create(null);

        Assert.fail("This should not happen");   
    }
    
    @Test(enabled=true, groups={"Unit", "Delete", "Bank Account", "Valid"})
    public void bankAccountDeleteTest() throws ApiException {
        BankAccountsApi bankAccountsApiMock = mock(BankAccountsApi.class);
        BankAccountDeletion fakeAccount = new BankAccountDeletion();
        
        fakeAccount.setId("bank_fakeId");
        when(bankAccountsApiMock.delete("bank_fakeId")).thenReturn(fakeAccount);
        BankAccountDeletion response = bankAccountsApiMock.delete("bank_fakeId");
        
        Assert.assertEquals(fakeAccount.getId(), response.getId());
    }

    @Test(enabled=true, groups={"Unit", "Delete", "Bank Account", "Invalid"}, expectedExceptions = {ApiException.class}, expectedExceptionsMessageRegExp = "error reported by API")
    public void bankAccountDeleteTestCatchesException() throws ApiException {
        BankAccountsApi bankAccountsApiMock = mock(BankAccountsApi.class);
        ApiException error = new ApiException("error reported by API");
        
        when(bankAccountsApiMock.delete(null)).thenThrow(error);
        bankAccountsApiMock.delete(null);
        
        Assert.fail("This should not happen");
    }

    @Test(enabled=true, groups={"Unit", "Delete", "Bank Account", "Invalid"}, expectedExceptions = {ApiException.class})
    public void bankAccountDeleteTestCatchesExceptionWithResponseBody() throws ApiException {
        BankAccountsApi bankAccountsApiMock = mock(BankAccountsApi.class);
        ApiException error = new ApiException("error", null, 500, null, "error reported by API");
        
        when(bankAccountsApiMock.delete(null)).thenThrow(error);
        bankAccountsApiMock.delete(null);
        
        Assert.fail("This should not happen");   
    }
    
    @Test(enabled=true, groups={"Unit", "Get", "Bank Account", "Valid"})
    public void BankAccountGetTest() throws ApiException {
        BankAccountsApi BankAccountApiMock = mock(BankAccountsApi.class);
        BankAccount fakeBankAccount = new BankAccount();
        fakeBankAccount.setId("bank_Id");
        
        when(BankAccountApiMock.get("bank_Id")).thenReturn(fakeBankAccount);
        BankAccount response = BankAccountApiMock.get("bank_Id");
        
        Assert.assertEquals(fakeBankAccount.getId(), response.getId());
    }

    @Test(enabled=true, groups={"Unit", "Get", "Bank Account", "Invalid"}, expectedExceptions = {ApiException.class}, expectedExceptionsMessageRegExp = "error reported by API")
    public void bankAccountGetTestCatchesException() throws ApiException {
        BankAccountsApi BankAccountApiMock = mock(BankAccountsApi.class);
        ApiException error = new ApiException("error reported by API");
        
        when(BankAccountApiMock.get(null)).thenThrow(error);
        BankAccountApiMock.get(null);
       
        Assert.fail("This should not happen");
    }

    @Test(enabled=true, groups={"Unit", "Get", "Bank Account", "Invalid"}, expectedExceptions = {ApiException.class})
    public void bankAccountGetTestCatchesExceptionWithResponseBody() throws ApiException {
        BankAccountsApi BankAccountApiMock = mock(BankAccountsApi.class);
        ApiException error = new ApiException("error", null, 500, null, "error reported by API");
        
        when(BankAccountApiMock.get(null)).thenThrow(error);
        BankAccountApiMock.get(null);
        
        Assert.fail("This should not happen");   
    }
    
    @Test(enabled=false, groups={"Unit", "Verify", "Bank Account", "Valid"})
    public void bankAccountVerifyTest() throws ApiException {
        BankAccountsApi bankAccountsApiMock = mock(BankAccountsApi.class);
        BankAccount FakeBankAccount = new BankAccount(); 
        BankAccountVerify bankAccountVerify = new BankAccountVerify();
        List<Integer> amounts = new ArrayList<Integer>();
        
        FakeBankAccount.setId("bank_fakeId");
        amounts.add(1);
        amounts.add(2);
        bankAccountVerify.setAmounts(amounts);

        when(bankAccountsApiMock.verify("bank_fakeId", bankAccountVerify)).thenReturn(FakeBankAccount);
        BankAccount response = bankAccountsApiMock.verify("bank_fakeId", bankAccountVerify);
        
        Assert.assertEquals(FakeBankAccount.getId(), response.getId());
    }
    
    @Test(enabled=true, groups={"Unit", "List", "Bank Account", "Valid"})
    public void bankAccountsListTest() throws ApiException {
        Integer limit = 2;
        String before = null;
        String after = null;
        List<String> include = null;
        Map<String, String> dateCreated = null;
        Map<String, String> metadata = null;
        
        BankAccountsApi bankAccountsApiMock = mock(BankAccountsApi.class);
        BankAccountList fakeBankAccount = new BankAccountList();
        BankAccount data1 = new BankAccount();
        BankAccount data2 = new BankAccount();
        List<BankAccount> data = new ArrayList<BankAccount>();
        
        data1.setId("bank_Id");
        data2.setId("bank_Id2");
        data.add(data1);
        data.add(data2);
        fakeBankAccount.setData(data);
        fakeBankAccount.setObject("list");
        fakeBankAccount.setCount(data.size());
        
        when(bankAccountsApiMock.list(limit, before, after, include, dateCreated, metadata)).thenReturn(fakeBankAccount);
        BankAccountList response = bankAccountsApiMock.list(limit, before, after, include, dateCreated, metadata);
        
        Assert.assertEquals(fakeBankAccount.getCount(), response.getCount());
    }

    @Test(enabled=true, groups={"Unit", "List", "Bank Account", "Invalid"}, expectedExceptions = {ApiException.class}, expectedExceptionsMessageRegExp = "error reported by API")
    public void bankAccountListTestCatchesException() throws ApiException {
        BankAccountsApi bankAccountsApiMock = mock(BankAccountsApi.class);
        ApiException error = new ApiException("error reported by API");
        
        when(bankAccountsApiMock.list(null, null, null, null, null, null)).thenThrow(error);
        bankAccountsApiMock.list(null, null, null, null, null, null);  
        
        Assert.fail("This should not happen");   
    }

    @Test(enabled=true, groups={"Unit", "List", "Bank Account", "Invalid"}, expectedExceptions = {ApiException.class})
    public void bankAccountListTestCatchesExceptionWithResponseBody() throws ApiException {
        BankAccountsApi bankAccountsApiMock = mock(BankAccountsApi.class);
        ApiException error = new ApiException("error", null, 500, null, "error reported by API");
       
        when(bankAccountsApiMock.list(null, null, null, null, null, null)).thenThrow(error);
        bankAccountsApiMock.list(null, null, null, null, null, null);
       
        Assert.fail("This should not happen");   
    }
    
}

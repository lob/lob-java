package Integration;

import java.util.ArrayList;
import java.util.List;

import com.lob.api.ApiException;
import com.lob.api.Configuration;
import com.lob.api.client.BankAccountsApi;

import com.lob.model.BankAccount;
import com.lob.model.BankAccountDeletion;
import com.lob.model.BankAccountWritable;
import com.lob.model.BankAccountList;
import com.lob.model.BankAccountVerify;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Helper.*;

public class BankAccountsApiSpecTest {
    private BankAccountsApi validApi;
    private BankAccountsApi invalidApi;
    private List<BankAccountWritable> BankAccountWritableList;
    private List<BankAccount> createdBankAccounts = new ArrayList<BankAccount>();
    private String nextUrl;
    private String previousUrl;

    @BeforeClass
    public void before_class()
    {
        validApi = new BankAccountsApi(Configuration.getConfigForIntegration());
        invalidApi = new BankAccountsApi(Configuration.getBadConfigForIntegration());
        BankAccountWritableList = new TestFixtures().get_BANK_ACCOUNTS_WRITABLE();

        for (BankAccountWritable bw: BankAccountWritableList) {
            try {
                createdBankAccounts.add(validApi.create(bw));
            } catch (Exception e) {
                Assert.fail("Creating Bank Accounts before has failed");
            }
        }

        try {
            BankAccountList response = validApi.list(null, null, null, null, null, null);
            Assert.assertNotNull(response);
            Assert.assertNotNull(response.getNextUrl());
            nextUrl = response.getNextUrl().substring(response.getNextUrl().indexOf("after=") + 6);
            Assert.assertNotNull(nextUrl);
            BankAccountList responseAfter = validApi.list(10, null, nextUrl, null, null, null);
            Assert.assertNotNull(responseAfter);
            Assert.assertNotNull(responseAfter.getPreviousUrl());
            previousUrl = responseAfter.getPreviousUrl().substring(responseAfter.getPreviousUrl().indexOf("before=") + 7);
            Assert.assertNotNull(previousUrl);
        } catch (ApiException e ) {
            Assert.fail("Listing bankAccountes before has failed");
        }

    }

    @AfterClass
    public void after_class()
    {
        for (BankAccount bankAccount: createdBankAccounts) {
            try {
                validApi.delete(bankAccount.getId());
            } catch (Exception e) {
                Assert.fail("Deleting bankAccountes after has failed");
            }
        }
    }

    @Test(
        enabled=true,
        groups={"Integration", "Create", "Bank Account", "Valid"}
    )
    public void bankAccountCreateTest() throws ApiException {
        BankAccount response = validApi.create(BankAccountWritableList.get(0));

        Assert.assertNotNull(response.getId());
        Assert.assertEquals(response.getAccountNumber(),BankAccountWritableList.get(0).getAccountNumber());
        createdBankAccounts.add(response);
    }

    @Test(
        enabled=true,
        expectedExceptions={ApiException.class},
        expectedExceptionsMessageRegExp=".*Missing the required parameter 'bankAccountWritable'.*",
        groups={"Integration", "Create", "BankAccount", "Invalid"}
    )
    public void bankAccountCreateTestBadParameter() throws ApiException {
        validApi.create(null);
    }

    @Test(
        enabled=true,
        expectedExceptions={ApiException.class},
        expectedExceptionsMessageRegExp=".*Your API key is not valid. Please sign up on lob.com to get a valid api key..*",
        groups={"Integration", "Create", "BankAccount", "Invalid"}
    )
    public void bankAccountCreateTestBadUsername() throws ApiException {
        try {
            invalidApi.create(BankAccountWritableList.get(0));
        }
        catch(ApiException e) {
            throw e;
        }
    }

    @Test(
        enabled=true,
        groups={"Integration", "Verify", "Bank Account", "Valid"}
    )
    public void bankAccountVerifyTest() throws ApiException {
        List<Integer> amounts = new ArrayList<Integer>();
        BankAccountVerify bv = new BankAccountVerify();

        amounts.add(11);
        amounts.add(35);
        bv.setAmounts(amounts);

        BankAccount response = validApi.verify(createdBankAccounts.get(0).getId(), bv);

        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getVerified());
        Assert.assertEquals(response.getId(), createdBankAccounts.get(0).getId());
        createdBankAccounts.add(response);
    }

    @Test(
        enabled=true,
        expectedExceptions={ApiException.class},
        expectedExceptionsMessageRegExp=".*Missing the required parameter 'bankId'.*",
        groups={"Integration", "Verify", "BankAccount", "Invalid"}
    )
    public void bankAccountVerifyTestBadParameter() throws ApiException {
        validApi.verify(null, null);
    }

    @Test(
        enabled=true,
        expectedExceptions={ApiException.class},
        expectedExceptionsMessageRegExp=".*Your API key is not valid. Please sign up on lob.com to get a valid api key..*",
        groups={"Integration", "Verify", "BankAccount", "Invalid"}
    )
    public void bankAccountRetrieveTestBadUsername() throws ApiException {
        List<Integer> amounts = new ArrayList<Integer>();
        BankAccountVerify bv = new BankAccountVerify();

        amounts.add(11);
        amounts.add(35);
        bv.setAmounts(amounts);

        try {
            invalidApi.verify(createdBankAccounts.get(0).getId(), bv);
        }
        catch(ApiException e) {
            throw e;
        }
    }

    @Test(
        enabled=true,
        groups={"Integration", "Get", "Bank Account", "Valid"}
    )
    public void bankAccountGetTest() throws ApiException {

        BankAccount response = validApi.get(createdBankAccounts.get(0).getId());

        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getId());
        Assert.assertEquals(response.getId(), createdBankAccounts.get(0).getId());
        createdBankAccounts.add(response);
    }

    @Test(
        enabled=true,
        expectedExceptions={ApiException.class},
        expectedExceptionsMessageRegExp=".*Missing the required parameter 'bankId'.*",
        groups={"Integration", "Verify", "BankAccount", "Invalid"}
    )
    public void bankAccountGetTestBadParameter() throws ApiException {
        validApi.get(null);
    }

    @Test(
        enabled=true,
        expectedExceptions={ApiException.class},
        expectedExceptionsMessageRegExp=".*Your API key is not valid. Please sign up on lob.com to get a valid api key..*",
        groups={"Integration", "Verify", "BankAccount", "Invalid"}
    )
    public void bankAccountGetTestBadUsername() throws ApiException {
        try {
            invalidApi.get(createdBankAccounts.get(0).getId());
        }
        catch(ApiException e) {
            throw e;
        }
    }

    @Test(
        enabled=true,
        groups={"Integration", "Delete", "Bank Account", "Valid"}
    )
    public void bankAccountDeleteTest() throws ApiException {

        BankAccountDeletion response = validApi.delete(createdBankAccounts.get(0).getId());

        Assert.assertNotNull(response);
        Assert.assertTrue(response.getDeleted());
        Assert.assertEquals(response.getId(), createdBankAccounts.get(0).getId());
    }

    @Test(
        enabled=true,
        expectedExceptions={ApiException.class},
        expectedExceptionsMessageRegExp=".*Missing the required parameter 'bankId'.*",
        groups={"Integration", "Delete", "BankAccount", "Invalid"}
    )
    public void bankAccountDeleteTestBadParameter() throws ApiException {
        validApi.delete(null);
    }

    @Test(
        enabled=true,
        expectedExceptions={ApiException.class},
        expectedExceptionsMessageRegExp=".*Your API key is not valid. Please sign up on lob.com to get a valid api key..*",
        groups={"Integration", "Verify", "BankAccount", "Invalid"}
    )
    public void bankAccountDeleteTestBadUsername() throws ApiException {
        try {
            invalidApi.delete(createdBankAccounts.get(0).getId());
        }
        catch(ApiException e) {
            throw e;
        }
    }

    @Test(
        enabled=true,
        groups={"Integration", "List", "Bank Account", "Valid"}
    )
    public void bankAccountListTest() throws ApiException {
        BankAccountList response = validApi.list(null, null, null, null, null, null);

        Assert.assertNotNull(response);
        Assert.assertTrue(response.getCount() > 0);
    }
    @Test(
        enabled=true,
        groups={"Integration", "List", "Bank Account", "Valid"}
    )
    public void bankAccountListTesWithAfterParam() throws ApiException {
        BankAccountList response = validApi.list(10, null, nextUrl, null, null, null);

        Assert.assertNotNull(response);
        Assert.assertTrue(response.getCount() > 0);
    }

    @Test(
        enabled=true,
        groups={"Integration", "List", "Bank Account", "Valid"}
    )
    public void bankAccountListTesWithbeforeParam() throws ApiException {
        BankAccountList response = validApi.list(10,  previousUrl, null, null, null, null);

        Assert.assertNotNull(response);
        Assert.assertTrue(response.getCount() > 0);
    }

    @Test(
        enabled=true,
        expectedExceptions={ApiException.class},
        expectedExceptionsMessageRegExp=".*Your API key is not valid. Please sign up on lob.com to get a valid api key..*",
        groups={"Integration", "Create", "BankAccount", "Invalid"}
    )
    public void bankAccountListTestBadUsername() throws ApiException {
        try {
            invalidApi.list(10, null, null, null, null, null);
        }
        catch(ApiException e) {
            throw e;
        }
    }


}
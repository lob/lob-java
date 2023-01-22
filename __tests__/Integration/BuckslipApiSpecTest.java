package Integration;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.lob.api.ApiException;
import com.lob.api.Configuration;
import com.lob.api.client.BuckslipsApi;
import com.lob.api.client.CardsApi;
import com.lob.model.Buckslip;
import com.lob.model.BuckslipEditable;
import com.lob.model.BuckslipsList;
import com.lob.model.Card;


import com.lob.model.BuckslipEditable.SizeEnum;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Helper.TestFixtures;

public class BuckslipApiSpecTest {


    private BuckslipsApi validApi;
    private BuckslipsApi invalidApi;
    private Buckslip dummyBuck;
    private TestFixtures tf;
    private Buckslip fetchedBuckslip;

    @BeforeClass
    public void before_class()
    {
        tf = new TestFixtures();
        validApi = new BuckslipsApi(Configuration.getConfigForIntegration());
        invalidApi = new BuckslipsApi(Configuration.getBadConfigForIntegration());
    }

    @Test(
        enabled=false,
        groups={"Integration", "Create", "Buckslip", "Valid"}
    )
    public void BuckslipCreateTest() throws ApiException {
        BuckslipEditable be = new BuckslipEditable();
        be.setBack(tf.get_FILE_LOCATION_6x18());
        be.setDescription("Test Buckslip");
        be.setSize(SizeEnum._8_75X3_75);
        dummyBuck = validApi.create(be, new File("__tests__/Helper/lobster.pdf"));

        Assert.assertNotNull(dummyBuck.getId());
    }


    @Test(
        enabled=true,
        groups={"Integration", "List", "Buckslip", "Valid"}
    )
    public void bucksliListTest() throws ApiException {
        BuckslipsList response = validApi.List(10, null, null, null);

        fetchedBuckslip = response.getData().get(0);
         Assert.assertTrue(response.getCount() > 0);

         Buckslip getResponse = validApi.get(fetchedBuckslip.getId());
 
         Assert.assertEquals(getResponse.getId(), fetchedBuckslip.getId());
     }
}

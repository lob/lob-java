package Model;

import com.lob.model.IntlVerification;
import com.lob.model.IntlComponents;

import org.testng.annotations.*;
import org.testng.Assert;


public class IntlVerificationTest {
    @DataProvider (name = "intl-verification-data-provider")
    public Object[][] intlVerificationDpMethod(){
        return new Object[][] {
            {"id", "intl_ver_fakeId"},
            {"recipient", "fake recipient"},
            {"primary_line", "fake primary"},
            {"secondary_line", "fake secondary"},
            {"last_line", "fake last"},
            {"country", "fake country"},
            {"coverage", IntlVerification.CoverageEnum.SUBBUILDING},
            {"deliverability", IntlVerification.DeliverabilityEnum.DELIVERABLE},
            {
                "deliverability",
                IntlVerification.DeliverabilityEnum.DELIVERABLE_MISSING_INFO,
            },
            {"deliverability", IntlVerification.DeliverabilityEnum.NO_MATCH},
            {"deliverability", IntlVerification.DeliverabilityEnum.UNDELIVERABLE},
            {"status", IntlVerification.StatusEnum.LV4},
            {"status", IntlVerification.StatusEnum.LV3},
            {"status", IntlVerification.StatusEnum.LV2},
            {"status", IntlVerification.StatusEnum.LV1},
            {"status", IntlVerification.StatusEnum.LF4},
            {"status", IntlVerification.StatusEnum.LF3},
            {"status", IntlVerification.StatusEnum.LF2},
            {"status", IntlVerification.StatusEnum.LF1},
            {"status", IntlVerification.StatusEnum.LM4},
            {"status", IntlVerification.StatusEnum.LM3},
            {"status", IntlVerification.StatusEnum.LM2},
            {"status", IntlVerification.StatusEnum.LU1},
            {"components", new IntlComponents()},
            {"object", IntlVerification.ObjectEnum.INTL_VERIFICATION},
        };
    }

    @Test(enabled=true, dataProvider = "intl-verification-data-provider")
    public void intlVerificationTestWithProvidedValue(String prop, Object val) throws Exception {
        IntlVerification rec = new IntlVerification();

        switch (prop) {
            case "id": {
                String castedVal = (String)val;
                rec.setId(castedVal);
                Assert.assertEquals(rec.getId(), castedVal);
                break;
            }
            case "recipient": {
                String castedVal = (String)val;
                rec.setRecipient(castedVal);
                Assert.assertEquals(rec.getRecipient(), castedVal);
                break;
            }
            case "primary_line": {
                String castedVal = (String)val;
                rec.setPrimaryLine(castedVal);
                Assert.assertEquals(rec.getPrimaryLine(), castedVal);
                break;
            }
            case "secondary_line": {
                String castedVal = (String)val;
                rec.setSecondaryLine(castedVal);
                Assert.assertEquals(rec.getSecondaryLine(), castedVal);
                break;
            }
            case "last_line": {
                String castedVal = (String)val;
                rec.setLastLine(castedVal);
                Assert.assertEquals(rec.getLastLine(), castedVal);
                break;
            }
            case "country": {
                String castedVal = (String)val;
                rec.setCountry(castedVal);
                Assert.assertEquals(rec.getCountry(), castedVal);
                break;
            }
            case "coverage": {
                IntlVerification.CoverageEnum castedVal = (IntlVerification.CoverageEnum)val;
                rec.setCoverage(castedVal);
                Assert.assertEquals(rec.getCoverage(), castedVal);
                break;
            }
            case "deliverability": {
                IntlVerification.DeliverabilityEnum castedVal = (IntlVerification.DeliverabilityEnum)val;
                rec.setDeliverability(castedVal);
                Assert.assertEquals(rec.getDeliverability(), castedVal);
                break;
            }
            case "status": {
                IntlVerification.StatusEnum castedVal = (IntlVerification.StatusEnum)val;
                rec.setStatus(castedVal);
                Assert.assertEquals(rec.getStatus(), castedVal);
                break;
            }
            case "components": {
                IntlComponents castedVal = (IntlComponents)val;
                rec.setComponents(castedVal);
                Assert.assertEquals(rec.getComponents(), castedVal);
                break;
            }
            case "object": {
                IntlVerification.ObjectEnum castedVal = (IntlVerification.ObjectEnum)val;
                rec.setObject(castedVal);
                Assert.assertEquals(rec.getObject(), castedVal);
                break;
            }
            default:
                throw new Exception("Wrong prop name");
        }
    }

    @Test(enabled=true)
    public void intlVerificationTestCatchesException() {
        IntlVerification rec = new IntlVerification();
        Assert.assertNull(rec.getId());

        try {
            rec.setId("Nope");
            throw new Exception("Should Throw");
        } catch (Exception err) {
            Assert.assertEquals(err.getMessage(), "Invalid id provided");
        }
    }
}

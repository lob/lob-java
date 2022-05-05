package Model;

import org.openapitools.client.model.IntlVerificationOrError;

import org.openapitools.client.model.LobError;
import org.openapitools.client.model.IntlComponents;

import org.testng.annotations.*;
import org.testng.Assert;

public class IntlVerificationOrErrorTest {
    @DataProvider (name = "intl-verification-or-error-data-provider")
    public Object[][] intlVerificationOrErrorDpMethod(){
        return new Object[][] {
            {"id", "intl_ver_fakeId"},
            {"recipient", "fake recipient"},
            {"primary_line", "fake primary"},
            {"secondary_line", "fake secondary"},
            {"last_line", "fake last"},
            {"country", "fake country"},
            {"coverage", IntlVerificationOrError.CoverageEnum.SUBBUILDING},
            {"deliverability", IntlVerificationOrError.DeliverabilityEnum.DELIVERABLE},
            {
                "deliverability",
                IntlVerificationOrError.DeliverabilityEnum.DELIVERABLE_MISSING_INFO,
            },
            {"deliverability", IntlVerificationOrError.DeliverabilityEnum.NO_MATCH},
            {"deliverability", IntlVerificationOrError.DeliverabilityEnum.UNDELIVERABLE},
            {"status", IntlVerificationOrError.StatusEnum.LV4},
            {"status", IntlVerificationOrError.StatusEnum.LV3},
            {"status", IntlVerificationOrError.StatusEnum.LV2},
            {"status", IntlVerificationOrError.StatusEnum.LV1},
            {"status", IntlVerificationOrError.StatusEnum.LF4},
            {"status", IntlVerificationOrError.StatusEnum.LF3},
            {"status", IntlVerificationOrError.StatusEnum.LF2},
            {"status", IntlVerificationOrError.StatusEnum.LF1},
            {"status", IntlVerificationOrError.StatusEnum.LM4},
            {"status", IntlVerificationOrError.StatusEnum.LM3},
            {"status", IntlVerificationOrError.StatusEnum.LM2},
            {"status", IntlVerificationOrError.StatusEnum.LU1},
            {"components", new IntlComponents()},
            {"object", IntlVerificationOrError.ObjectEnum.INTL_VERIFICATION},
            {"message", "fake message"},
            {"status_code", 500},
            {"code", LobError.CodeEnum.ADDRESS_LENGTH_EXCEEDS_LIMIT},
        };
    }

    @Test(enabled=true, dataProvider = "intl-verification-or-error-data-provider")
    public void intlVerificationOrErrorTestWithProvidedValue(String prop, Object val) throws Exception {
        IntlVerificationOrError rec = new IntlVerificationOrError();

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
                IntlVerificationOrError.CoverageEnum castedVal = (IntlVerificationOrError.CoverageEnum)val;
                rec.setCoverage(castedVal);
                Assert.assertEquals(rec.getCoverage(), castedVal);
                break;
            }
            case "deliverability": {
                IntlVerificationOrError.DeliverabilityEnum castedVal = (IntlVerificationOrError.DeliverabilityEnum)val;
                rec.setDeliverability(castedVal);
                Assert.assertEquals(rec.getDeliverability(), castedVal);
                break;
            }
            case "status": {
                IntlVerificationOrError.StatusEnum castedVal = (IntlVerificationOrError.StatusEnum)val;
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
                IntlVerificationOrError.ObjectEnum castedVal = (IntlVerificationOrError.ObjectEnum)val;
                rec.setObject(castedVal);
                Assert.assertEquals(rec.getObject(), castedVal);
                break;
            }
            case "message": {
                String castedVal = (String)val;
                rec.setMessage(castedVal);
                Assert.assertEquals(rec.getMessage(), castedVal);
                break;
            }
            case "status_code": {
                Integer castedVal = (Integer)val;
                rec.setStatusCode(castedVal);
                Assert.assertEquals(rec.getStatusCode(), castedVal);
                break;
            }
            case "code": {
                LobError.CodeEnum castedVal = (LobError.CodeEnum)val;
                rec.setCode(castedVal);
                Assert.assertEquals(rec.getCode(), castedVal);
                break;
            }
            default:
                throw new Exception("Wrong prop name");
        }
    }

    @Test(enabled=true)
    public void intlVerificationOrErrorTestCatchesException() {
        IntlVerificationOrError rec = new IntlVerificationOrError();
        Assert.assertNull(rec.getId());

        try {
            rec.setId("Nope");
            throw new Exception("Should Throw");
        } catch (Exception err) {
            Assert.assertEquals(err.getMessage(), "Invalid id provided");
        }
    }
}

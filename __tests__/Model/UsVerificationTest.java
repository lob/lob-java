package Model;

import org.openapitools.client.model.UsVerification;
import org.openapitools.client.model.DeliverabilityAnalysis;
import org.openapitools.client.model.LobConfidenceScore;
import org.openapitools.client.model.UsComponents;

import org.testng.annotations.*;
import org.testng.Assert;

public class UsVerificationTest {
    @DataProvider (name = "us-verification-data-provider")
    public Object[][] usVerificationDpMethod(){
        return new Object[][] {
            {"id", "us_ver_fakeId"},
            {"recipient", "fake recipient"},
            {"primary_line", "fake primary"},
            {"secondary_line", "fake secondary"},
            {"urbanization", "fake urbanization"},
            {"last_line", "fake last"},
            {"deliverability", UsVerification.DeliverabilityEnum.DELIVERABLE},
            {
                "deliverability",
                UsVerification.DeliverabilityEnum.DELIVERABLE_INCORRECT_UNIT,
            },
            {
                "deliverability",
                UsVerification.DeliverabilityEnum.DELIVERABLE_MISSING_UNIT,
            },
            {
                "deliverability",
                UsVerification.DeliverabilityEnum.DELIVERABLE_UNNECESSARY_UNIT,
            },
            {"deliverability", UsVerification.DeliverabilityEnum.UNDELIVERABLE},
            {"components", new UsComponents()},
            {"deliverability_analysis", new DeliverabilityAnalysis()},
            {"lob_confidence_score", new LobConfidenceScore()},
            {"object", UsVerification.ObjectEnum.US_VERIFICATION},
        };
    }

    @Test(enabled=true, dataProvider = "us-verification-data-provider")
    public void usVerificationTestWithProvidedValue(String prop, Object val) {
        UsVerification rec = new UsVerification();

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
            case "urbanization": {
                String castedVal = (String)val;
                rec.setUrbanization(castedVal);
                Assert.assertEquals(rec.getUrbanization(), castedVal);
                break;
            }
            case "last_line": {
                String castedVal = (String)val;
                rec.setLastLine(castedVal);
                Assert.assertEquals(rec.getLastLine(), castedVal);
                break;
            }
            case "deliverability": {
                UsVerification.DeliverabilityEnum castedVal = (UsVerification.DeliverabilityEnum)val;
                rec.setDeliverability(castedVal);
                Assert.assertEquals(rec.getDeliverability(), castedVal);
                break;
            }
            case "components": {
                UsComponents castedVal = (UsComponents)val;
                rec.setComponents(castedVal);
                Assert.assertEquals(rec.getComponents(), castedVal);
                break;
            }
            case "deliverability_analysis": {
                DeliverabilityAnalysis castedVal = (DeliverabilityAnalysis)val;
                rec.setDeliverabilityAnalysis(castedVal);
                Assert.assertEquals(rec.getDeliverabilityAnalysis(), castedVal);
                break;
            }
            case "lob_confidence_score": {
                LobConfidenceScore castedVal = (LobConfidenceScore)val;
                rec.setLobConfidenceScore(castedVal);
                Assert.assertEquals(rec.getLobConfidenceScore(), castedVal);
                break;
            }
            case "object": {
                UsVerification.ObjectEnum castedVal = (UsVerification.ObjectEnum)val;
                rec.setObject(castedVal);
                Assert.assertEquals(rec.getObject(), castedVal);
                break;
            }
            default:
        }
    }

    @Test(enabled=true)
    public void usVerificationTestCatchesException() {
        UsVerification rec = new UsVerification();
        Assert.assertNull(rec.getId());

        try {
            rec.setId("Nope");
            throw new Exception("Should Throw");
        } catch (Exception err) {
            Assert.assertEquals(err.getMessage(), "Invalid id provided");
        }
    }

    @Test(enabled=true)
    public void usVerificationTestWithValueId() {
        UsVerification rec = new UsVerification();
        Assert.assertNull(rec.getId());

        String validValue = "us_ver_1234";
        rec.setId(validValue);
        Assert.assertNotNull(rec.getId());
        Assert.assertEquals(rec.getId(), validValue);
    }
}

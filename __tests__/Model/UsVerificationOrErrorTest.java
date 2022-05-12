package Model;

import org.openapitools.client.model.UsVerificationOrError;
import org.openapitools.client.model.LobError;
import org.openapitools.client.model.UsComponents;
import org.openapitools.client.model.BulkError;
import org.openapitools.client.model.DeliverabilityAnalysis;
import org.openapitools.client.model.LobConfidenceScore;

import java.util.List;
import java.util.ArrayList;

import org.testng.annotations.*;
import org.testng.Assert;

public class UsVerificationOrErrorTest {
    @DataProvider (name = "us-verification-or-error-data-provider")
    public Object[][] usVerificationOrErrorDpMethod(){
        return new Object[][] {
            {"id", "us_ver_fakeId"},
            {"recipient", "fake recipient"},
            {"primary_line", "fake primary"},
            {"secondary_line", "fake secondary"},
            {"urbanization", "fake urbanization"},
            {"last_line", "fake last"},
            {"deliverability", UsVerificationOrError.DeliverabilityEnum.DELIVERABLE},
            {
                "deliverability",
                UsVerificationOrError.DeliverabilityEnum.DELIVERABLE_INCORRECT_UNIT,
            },
            {
                "deliverability",
                UsVerificationOrError.DeliverabilityEnum.DELIVERABLE_MISSING_UNIT,
            },
            {
                "deliverability",
                UsVerificationOrError.DeliverabilityEnum.DELIVERABLE_UNNECESSARY_UNIT,
            },
            {"deliverability", UsVerificationOrError.DeliverabilityEnum.UNDELIVERABLE},
            {"components", new UsComponents()},
            {"deliverability_analysis", new DeliverabilityAnalysis()},
            {"lob_confidence_score", new LobConfidenceScore()},
            {"object", UsVerificationOrError.ObjectEnum.US_VERIFICATION},
            {"message", "fake message"},
            {"status_code", LobError.StatusCodeEnum.NUMBER_403},
            {"code", LobError.CodeEnum.ADDRESS_LENGTH_EXCEEDS_LIMIT},
        };
    }

    @Test(enabled=true, dataProvider = "us-verification-or-error-data-provider")
    public void usVerificationOrErrorTestWithProvidedValue(String prop, Object val) {
        UsVerificationOrError rec = new UsVerificationOrError();

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
                UsVerificationOrError.DeliverabilityEnum castedVal = (UsVerificationOrError.DeliverabilityEnum)val;
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
                UsVerificationOrError.ObjectEnum castedVal = (UsVerificationOrError.ObjectEnum)val;
                rec.setObject(castedVal);
                Assert.assertEquals(rec.getObject(), castedVal);
                break;
            }
            default:
        }
    }

    @Test(enabled=true)
    public void usVerificationOrErrorTestCatchesException() {
        UsVerificationOrError rec = new UsVerificationOrError();
        Assert.assertNull(rec.getId());

        try {
            rec.setId("Nope");
            throw new Exception("Should Throw");
        } catch (Exception err) {
            Assert.assertEquals(err.getMessage(), "Invalid id provided");
        }
    }
}

package Model;

import com.lob.model.DeliverabilityAnalysis;
import com.lob.model.DpvFootnote;

import org.testng.annotations.*;
import org.testng.Assert;

public class DeliverabilityAnalysisTest {
    @DataProvider (name = "deliverability-analysis-data-provider")
    public Object[][] deliverabilityAnalysisDpMethod(){
        return new Object[][] {
            {"dpv_confirmation", DeliverabilityAnalysis.DpvConfirmationEnum.N},
            {"dpv_confirmation", DeliverabilityAnalysis.DpvConfirmationEnum.S},
            {"dpv_confirmation", DeliverabilityAnalysis.DpvConfirmationEnum.Y},
            {"dpv_confirmation", DeliverabilityAnalysis.DpvConfirmationEnum.EMPTY},
            {"dpv_confirmation", DeliverabilityAnalysis.DpvConfirmationEnum.D},
            {"dpv_cmra", DeliverabilityAnalysis.DpvCmraEnum.Y},
            {"dpv_cmra", DeliverabilityAnalysis.DpvCmraEnum.N},
            {"dpv_cmra", DeliverabilityAnalysis.DpvCmraEnum.EMPTY},
            {"dpv_vacant", DeliverabilityAnalysis.DpvVacantEnum.Y},
            {"dpv_vacant", DeliverabilityAnalysis.DpvVacantEnum.N},
            {"dpv_vacant", DeliverabilityAnalysis.DpvVacantEnum.EMPTY},
            {"dpv_active", DeliverabilityAnalysis.DpvActiveEnum.Y},
            {"dpv_active", DeliverabilityAnalysis.DpvActiveEnum.N},
            {"dpv_active", DeliverabilityAnalysis.DpvActiveEnum.EMPTY},
            {"dpv_footnotes", DpvFootnote.AA},
            {"dpv_footnotes", DpvFootnote.BB},
            {"dpv_footnotes", DpvFootnote.CC},
            {"dpv_footnotes", DpvFootnote.N1},
            {"dpv_footnotes", DpvFootnote.F1},
            {"dpv_footnotes", DpvFootnote.G1},
            {"dpv_footnotes", DpvFootnote.U1},
            {"dpv_footnotes", DpvFootnote.M1},
            {"dpv_footnotes", DpvFootnote.M3},
            {"dpv_footnotes", DpvFootnote.P1},
            {"dpv_footnotes", DpvFootnote.P3},
            {"dpv_footnotes", DpvFootnote.R1},
            {"dpv_footnotes", DpvFootnote.R7},
            {"dpv_footnotes", DpvFootnote.RR},
            {"ews_match", true},
            {"ews_match", false},
            {"lacs_indicator", DeliverabilityAnalysis.LacsIndicatorEnum.Y},
            {"lacs_indicator", DeliverabilityAnalysis.LacsIndicatorEnum.N},
            {"lacs_indicator", DeliverabilityAnalysis.LacsIndicatorEnum.EMPTY},
            {"lacs_return_code", "fake return code"},
            {"suite_return_code", DeliverabilityAnalysis.SuiteReturnCodeEnum.EMPTY},
            {"suite_return_code", DeliverabilityAnalysis.SuiteReturnCodeEnum.A},
            {"suite_return_code", DeliverabilityAnalysis.SuiteReturnCodeEnum._00},
        };
    }

    @Test(enabled=true, dataProvider = "deliverability-analysis-data-provider")
    public void deliverabilityAnalysisTestWithProvidedValue(String prop, Object val) {
        DeliverabilityAnalysis rec = new DeliverabilityAnalysis();

        switch (prop) {
            case "dpv_confirmation": {
                DeliverabilityAnalysis.DpvConfirmationEnum castedVal = (DeliverabilityAnalysis.DpvConfirmationEnum)val;
                rec.setDpvConfirmation(castedVal);
                Assert.assertEquals(rec.getDpvConfirmation(), castedVal);
                break;
            }
            case "dpv_cmra": {
                DeliverabilityAnalysis.DpvCmraEnum castedVal = (DeliverabilityAnalysis.DpvCmraEnum)val;
                rec.setDpvCmra(castedVal);
                Assert.assertEquals(rec.getDpvCmra(), castedVal);
                break;
            }
            case "dpv_vacant": {
                DeliverabilityAnalysis.DpvVacantEnum castedVal = (DeliverabilityAnalysis.DpvVacantEnum)val;
                rec.setDpvVacant(castedVal);
                Assert.assertEquals(rec.getDpvVacant(), castedVal);
                break;
            }
            case "dpv_active": {
                DeliverabilityAnalysis.DpvActiveEnum castedVal = (DeliverabilityAnalysis.DpvActiveEnum)val;
                rec.setDpvActive(castedVal);
                Assert.assertEquals(rec.getDpvActive(), castedVal);
                break;
            }
            case "dpv_footnotes": {
                DpvFootnote castedVal = (DpvFootnote)val;
                rec.addDpvFootnotesItem(castedVal);
                String recAsStr = rec.toString();
                String[] arrOfStr = recAsStr.split("(    dpvFootnotes: \\[|\\]\n)", 0);
                Assert.assertEquals(arrOfStr[1], castedVal.getValue());
                break;
            }
            case "ews_match": {
                Boolean castedVal = (Boolean)val;
                rec.setEwsMatch(castedVal);
                Assert.assertEquals(rec.getEwsMatch(), castedVal);
                break;
            }
            case "lacs_indicator": {
                DeliverabilityAnalysis.LacsIndicatorEnum castedVal = (DeliverabilityAnalysis.LacsIndicatorEnum)val;
                rec.setLacsIndicator(castedVal);
                Assert.assertEquals(rec.getLacsIndicator(), castedVal);
                break;
            }
            case "lacs_return_code": {
                String castedVal = (String)val;
                rec.setLacsReturnCode(castedVal);
                Assert.assertEquals(rec.getLacsReturnCode(), castedVal);
                break;
            }
            case "suite_return_code":
                DeliverabilityAnalysis.SuiteReturnCodeEnum castedVal = (DeliverabilityAnalysis.SuiteReturnCodeEnum)val;
                rec.setSuiteReturnCode(castedVal);
                Assert.assertEquals(rec.getSuiteReturnCode(), castedVal);
                break;
            default:
        }
    }
}

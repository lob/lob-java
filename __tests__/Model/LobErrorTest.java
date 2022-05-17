package Model;

import org.openapitools.client.model.LobError;

import org.testng.annotations.*;
import org.testng.Assert;

public class LobErrorTest {
    @DataProvider (name = "lob-error-data-provider")
    public Object[][] lobErrorDpMethod(){
        return new Object[][] {
            {"message", "fake message"},
            {"status_code", LobError.StatusCodeEnum.NUMBER_401},
            {"status_code", LobError.StatusCodeEnum.NUMBER_403},
            {"status_code", LobError.StatusCodeEnum.NUMBER_404},
            {"status_code", LobError.StatusCodeEnum.NUMBER_413},
            {"status_code", LobError.StatusCodeEnum.NUMBER_422},
            {"status_code", LobError.StatusCodeEnum.NUMBER_429},
            {"status_code", LobError.StatusCodeEnum.NUMBER_500},
            {"code", LobError.CodeEnum.BAD_REQUEST},
            {"code", LobError.CodeEnum.CONFLICT},
            {"code", LobError.CodeEnum.FEATURE_LIMIT_REACHED},
            {"code", LobError.CodeEnum.INTERNAL_SERVER_ERROR},
            {"code", LobError.CodeEnum.INVALID},
            {"code", LobError.CodeEnum.NOT_DELETABLE},
            {"code", LobError.CodeEnum.NOT_FOUND},
            {"code", LobError.CodeEnum.REQUEST_TIMEOUT},
            {"code", LobError.CodeEnum.SERVICE_UNAVAILABLE},
            {"code", LobError.CodeEnum.UNRECOGNIZED_ENDPOINT},
            {"code", LobError.CodeEnum.UNSUPPORTED_LOB_VERSION},
            {"code", LobError.CodeEnum.ADDRESS_LENGTH_EXCEEDS_LIMIT},
            {"code", LobError.CodeEnum.BANK_ACCOUNT_ALREADY_VERIFIED},
            {"code", LobError.CodeEnum.BANK_ERROR},
            {"code", LobError.CodeEnum.CUSTOM_ENVELOPE_INVENTORY_DEPLETED},
            {"code", LobError.CodeEnum.DELETED_BANK_ACCOUNT},
            {"code", LobError.CodeEnum.FAILED_DELIVERABILITY_STRICTNESS},
            {"code", LobError.CodeEnum.FILE_PAGES_BELOW_MIN},
            {"code", LobError.CodeEnum.FILE_PAGES_EXCEED_MAX},
            {"code", LobError.CodeEnum.FILE_SIZE_EXCEEDS_LIMIT},
            {"code", LobError.CodeEnum.FOREIGN_RETURN_ADDRESS},
            {"code", LobError.CodeEnum.INCONSISTENT_PAGE_DIMENSIONS},
            {"code", LobError.CodeEnum.INVALID_BANK_ACCOUNT},
            {"code", LobError.CodeEnum.INVALID_BANK_ACCOUNT_VERIFICATION},
            {"code", LobError.CodeEnum.INVALID_CHECK_INTERNATIONAL},
            {"code", LobError.CodeEnum.INVALID_COUNTRY_COVID},
            {"code", LobError.CodeEnum.INVALID_FILE},
            {"code", LobError.CodeEnum.INVALID_FILE_DIMENSIONS},
            {"code", LobError.CodeEnum.INVALID_FILE_DOWNLOAD_TIME},
            {"code", LobError.CodeEnum.INVALID_FILE_URL},
            {"code", LobError.CodeEnum.INVALID_IMAGE_DPI},
            {"code", LobError.CodeEnum.INVALID_INTERNATIONAL_FEATURE},
            {"code", LobError.CodeEnum.INVALID_PERFORATION_RETURN_ENVELOPE},
            {"code", LobError.CodeEnum.INVALID_TEMPLATE_HTML},
            {"code", LobError.CodeEnum.MERGE_VARIABLE_REQUIRED},
            {"code", LobError.CodeEnum.MERGE_VARIABLE_WHITESPACE},
            {"code", LobError.CodeEnum.PAYMENT_METHOD_UNVERIFIED},
            {"code", LobError.CodeEnum.PDF_ENCRYPTED},
            {"code", LobError.CodeEnum.SPECIAL_CHARACTERS_RESTRICTED},
            {"code", LobError.CodeEnum.UNEMBEDDED_FONTS},
            {"code", LobError.CodeEnum.EMAIL_REQUIRED},
            {"code", LobError.CodeEnum.INVALID_API_KEY},
            {"code", LobError.CodeEnum.PUBLISHABLE_KEY_NOT_ALLOWED},
            {"code", LobError.CodeEnum.RATE_LIMIT_EXCEEDED},
            {"code", LobError.CodeEnum.UNAUTHORIZED},
            {"code", LobError.CodeEnum.UNAUTHORIZED_TOKEN},
        };
    }

    @Test(enabled=true, dataProvider = "lob-error-data-provider")
    public void lobErrorTestWithProvidedValue(String prop, Object val) throws Exception {
        LobError rec = new LobError();

        switch (prop) {
            case "message": {
                String castedVal = (String)val;
                rec.setMessage(castedVal);
                Assert.assertEquals(rec.getMessage(), castedVal);
                break;
            }
            case "status_code": {
                LobError.StatusCodeEnum castedVal = (LobError.StatusCodeEnum)val;
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
                throw new Exception("Wrong prop name: " + prop);
        }
    }
}

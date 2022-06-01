package Model;

import com.lob.model.LobConfidenceScore;

import org.testng.annotations.*;
import org.testng.Assert;

public class LobConfidenceScoreTest {
    @DataProvider (name = "lob-confidence-score-data-provider")
    public Object[][] lobConfidenceScoreDpMethod(){
        return new Object[][] {
            {"score", 12.0f},
            {"level", LobConfidenceScore.LevelEnum.LOW},
            {"level", LobConfidenceScore.LevelEnum.EMPTY},
            {"level", LobConfidenceScore.LevelEnum.HIGH},
            {"level", LobConfidenceScore.LevelEnum.MEDIUM},
        };
    }

    @Test(enabled=true, dataProvider = "lob-confidence-score-data-provider")
    public void lobConfidenceScoreTestWithProvidedValue(String prop, Object val) {
        LobConfidenceScore rec = new LobConfidenceScore();

        if (prop == "score") {
            Float castedVal = (Float)val;
            rec.setScore(castedVal);
            Assert.assertEquals(rec.getScore(), castedVal);
        } else {
            LobConfidenceScore.LevelEnum castedVal = (LobConfidenceScore.LevelEnum)val;
            rec.setLevel(castedVal);
            Assert.assertEquals(rec.getLevel(), castedVal);
        }
    }
}

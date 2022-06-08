package Model;

import com.lob.model.Thumbnail;

import Helper.*;

import org.testng.annotations.*;
import org.testng.Assert;

public class ThumbnailTest {
    @Test(enabled=true)
    public void thumbnailCreateTest() {
        Thumbnail rec1 = new Thumbnail();
        String validUrl = new TestFixtures().get_URL_VALID();
        rec1.setSmall(validUrl);
        Assert.assertEquals(rec1.getSmall(), validUrl);

        Thumbnail rec2 = new Thumbnail();
        rec2.setMedium(validUrl);
        Assert.assertEquals(rec2.getMedium(), validUrl);

        Thumbnail rec3 = new Thumbnail();
        rec3.setLarge(validUrl);
        Assert.assertEquals(rec3.getLarge(), validUrl);
    }

    @Test(enabled=true)
    public void thumbnailTestInvalidSmall() {
        Thumbnail rec = new Thumbnail();
        Assert.assertNull(rec.getSmall());

        try {
            rec.setSmall("Nope");
            throw new Exception("Should Throw");
        } catch (Exception err) {
            Assert.assertEquals(err.getMessage(), "Invalid small provided");
        }
    }

    @Test(enabled=true)
    public void thumbnailTestInvalidMedium() {
        Thumbnail rec = new Thumbnail();
        Assert.assertNull(rec.getMedium());

        try {
            rec.setMedium("Nope");
            throw new Exception("Should Throw");
        } catch (Exception err) {
            Assert.assertEquals(err.getMessage(), "Invalid medium provided");
        }
    }

    @Test(enabled=true)
    public void thumbnailTestInvalidLarge() {
        Thumbnail rec = new Thumbnail();
        Assert.assertNull(rec.getLarge());

        try {
            rec.setLarge("Nope");
            throw new Exception("Should Throw");
        } catch (Exception err) {
            Assert.assertEquals(err.getMessage(), "Invalid large provided");
        }
    }
}

package Model;

import com.lob.model.TemplateUpdate;

import org.testng.annotations.*;
import org.testng.Assert;

public class TemplateUpdateTest {
    @Test(enabled=true)
    public void templateUpdateTestWithProvidedValue() {
        TemplateUpdate rec1 = new TemplateUpdate();

        String description = "fake description";
        rec1.setDescription(description);
        Assert.assertEquals(rec1.getDescription(), description);

        TemplateUpdate rec2 = new TemplateUpdate();

        String published_version = "vrsn_fakeId";
        rec1.setPublishedVersion(published_version);
        Assert.assertEquals(rec1.getPublishedVersion(), published_version);
    }

    @Test(enabled=true)
    public void templateUpdateTestInvalidPubishedVersion() {
        TemplateUpdate rec = new TemplateUpdate();
        Assert.assertNull(rec.getPublishedVersion());

        try {
            rec.setPublishedVersion("Nope");
            throw new Exception("Should Throw");
        } catch (Exception err) {
            Assert.assertEquals(err.getMessage(), "Invalid published_version provided");
        }
    }
}

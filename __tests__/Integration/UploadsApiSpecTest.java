package Integration;

import com.lob.api.ApiException;
import com.lob.api.Configuration;
import com.lob.api.client.UploadsApi;
import com.lob.api.client.CampaignsApi;

import com.lob.model.RequiredAddressColumnMapping;
import com.lob.model.OptionalAddressColumnMapping;
import com.lob.model.UploadFile;
import com.lob.model.Upload;
import com.lob.model.UploadWritable;
import com.lob.model.Campaign;
import com.lob.model.CampaignWritable;
import com.lob.model.CmpScheduleType;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

public class UploadsApiSpecTest {
    private CampaignsApi campaignApi;
    private UploadsApi uploadApi;
    private String cmpId;
    private UploadWritable uploadWritable;
    private List<Upload> createdUploads = new ArrayList<Upload>();

    @BeforeClass
    public void before_class() throws Exception
    {
        campaignApi = new CampaignsApi(Configuration.getConfigForIntegration());
        CampaignWritable cmpWritable = new CampaignWritable();
        cmpWritable.setName("UPLOADINGGGGGG TEST" + OffsetDateTime.now());
        cmpWritable.setScheduleType(CmpScheduleType.IMMEDIATE);

        Campaign campaign = new Campaign();
        try {
          campaign = campaignApi.create(cmpWritable, null);
        } catch (Exception e) {
          throw new Exception("Failed to create campaign: " + e.getMessage());
        }
        cmpId = campaign.getId();

        uploadApi = new UploadsApi(Configuration.getConfigForLiveIntegration());

        uploadWritable  = new UploadWritable();
        uploadWritable.setCampaignId(cmpId);

        RequiredAddressColumnMapping colMapping = new RequiredAddressColumnMapping();
        colMapping.setName("name");
        colMapping.setAddressLine1("address_line1");
        colMapping.setAddressCity("address_city");
        colMapping.setAddressState("address_state");
        colMapping.setAddressZip("address_zip");

        OptionalAddressColumnMapping colMapping2 = new OptionalAddressColumnMapping();
        colMapping2.setAddressLine2("address_line2");

        uploadWritable.setRequiredAddressColumnMapping(colMapping);
        uploadWritable.setOptionalAddressColumnMapping(colMapping2);
    }

    @AfterClass
    public void after_class()
    {
        for (Upload upload: createdUploads) {
            try {
                uploadApi.delete(upload.getId());
            } catch (Exception e) {
                Assert.fail("Deleting uploads after has failed");
            }
        }

        try {
            campaignApi.delete(cmpId);
        } catch (Exception e) {
            System.out.println(e);
            Assert.fail("Deleting Campaign after has failed");
        }
    }

    @Test(
        enabled=true,
        groups={"Integration", "Create", "Upload", "Valid"}
    )
    public void uploadCreateTest() throws ApiException {
        Upload createdUpload = uploadApi.create(uploadWritable);

        Assert.assertNotNull(createdUpload.getId());
        createdUploads.add(createdUpload);
    }


    @Test(
        enabled=true,
        groups={"Integration", "Retrieve", "Upload", "Valid"}
    )
    public void uploadRetrieveTest() throws ApiException {
        Upload createdUpload = uploadApi.create(uploadWritable);

        createdUploads.add(createdUpload);

        Upload response = uploadApi.get(createdUpload.getId());

        Assert.assertNotNull(response.getId());
        Assert.assertEquals(response.getId(), createdUpload.getId());
    }

    @Test(
        enabled=false,
        groups={"Integration", "File", "Upload", "Valid"}
    )
    public void uploadFileTest() throws ApiException {
        Upload createdUpload = uploadApi.create(uploadWritable);
        createdUploads.add(createdUpload);

        UploadFile response = uploadApi.upload_file(createdUpload.getId(), new File("__tests__/Helper/lobster-family.csv"));

        Assert.assertTrue(response.getMessage().getValue().contains("File uploaded successfully"));
    }

    @Test(
        enabled=true,
        groups={"Integration", "Update", "Upload", "Valid"}
    )
    public void uploadUpdateTest() throws ApiException {
        Upload createdUpload = uploadApi.create(uploadWritable);
        createdUploads.add(createdUpload);

        List<Upload> response = uploadApi.list(cmpId);
        Assert.assertTrue(response.size() > 0);
    }
}
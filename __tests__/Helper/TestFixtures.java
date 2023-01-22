package Helper;

import java.util.ArrayList;
import java.util.List;

import com.lob.model.AddressEditable;
import com.lob.model.BankAccountWritable;
import com.lob.model.BankTypeEnum;
import com.lob.model.BillingGroupEditable;
import com.lob.model.CountryExtended;
import com.lob.model.TemplateWritable;

public class TestFixtures {
    public String get_URL_VALID() {
        return "https://lob-assets.com/bank-accounts/asd_asdfghjkqwertyui.pdf?version=123&expires=1234567890&signature=aksdf";
    }

    public String get_FILE_LOCATION_8X11() {
        return "https://s3-us-west-2.amazonaws.com/public.lob.com/assets/us_letter_1pg.pdf";
    }

    public String get_FILE_LOCATION_4X6() {
        return "https://s3-us-west-2.amazonaws.com/public.lob.com/assets/templates/4x6_pc_template.pdf";
    }

    public String get_FILE_LOCATION_6x18() {
        return "https://s3.us-west-2.amazonaws.com/public.lob.com/assets/templates/self_mailers/6x18_sfm_inside.pdf";
    }

    public String get_FILE_LOCATION() {
        return "https://s3-us-west-2.amazonaws.com/public.lob.com/assets/card_horizontal.pdf";
    }
    private final List<AddressEditable> ADDRESSES_EDITABLE = new ArrayList<AddressEditable>();
    private final List<BankAccountWritable> BANK_ACCOUNTS_WRITABLE = new ArrayList<BankAccountWritable>();
    private final List<BillingGroupEditable> BILLING_GROUP_EDITABLE = new ArrayList<BillingGroupEditable>();
    private final List<TemplateWritable> TEMPLATES_WRITABLE = new ArrayList<TemplateWritable>();

    public List<AddressEditable> get_ADDRESSES_EDITABLE() {
        return ADDRESSES_EDITABLE;
    }

    public List<BankAccountWritable> get_BANK_ACCOUNTS_WRITABLE() {
        return BANK_ACCOUNTS_WRITABLE ;
    }


    public List<BillingGroupEditable> get_BILLING_GROUP_EDITABLE() {
        return BILLING_GROUP_EDITABLE ;
    }

    public List<TemplateWritable> get_TEMPLATES_WRITABLE() {
        return TEMPLATES_WRITABLE ;
    }

    public TestFixtures() {
        createBankAccountsList();
        createAddressesList();
        createBillingGroupsList();
        createTemplatesList();
    }

    private AddressEditable populateAddressEditable(
        AddressEditable address,
        String name,
        String line1,
        String line2,
        String city,
        String state,
        String zip,
        CountryExtended country) {

            address.setName(name);
            address.setAddressLine1(line1);
            if(line2 != null) {
                address.setAddressLine2(line2);
            }
            address.setAddressCity(city);
            address.setAddressState(state);
            address.setAddressZip(zip);
            if(country != null) {
                address.setAddressCountry(country);
            }

            return address;
    }

    private BillingGroupEditable populateBillingGroupEditable(String name, String description, BillingGroupEditable billingGroup) {
            billingGroup.setName(name);
            billingGroup.setDescription(description);

            return billingGroup;
    }

    private void  createAddressesList() {
        AddressEditable addressEditable0 = new AddressEditable();
        AddressEditable addressEditable1 = new AddressEditable();
        AddressEditable addressEditable2 = new AddressEditable();
        AddressEditable addressEditable3 = new AddressEditable();
        AddressEditable addressEditable4 = new AddressEditable();
        AddressEditable addressEditable5 = new AddressEditable();
        AddressEditable addressEditable6 = new AddressEditable();

        addressEditable0 = populateAddressEditable(addressEditable0, "Thing T. Thing", "1313 CEMETERY LN", null, "WESTFIELD", "NJ", "07091", null);
        addressEditable1 = populateAddressEditable(addressEditable1, "FESTER", "001 CEMETERY LN", "SUITE 666", "WESTFIELD", "NJ", "07091",null);
        addressEditable2 = populateAddressEditable(addressEditable2, "MORTICIA ADDAMS", "1313 CEMETERY LN", null, "WESTFIELD", "NJ", "07091", null);
        addressEditable3 = populateAddressEditable(addressEditable3, "COUSIN ITT", "1515 CEMETERY LN", "FLOOR 0", "WESTFIELD", "NJ", "07091", null);
        addressEditable4 = populateAddressEditable(addressEditable4, "WEDNESDAY ADDAMS", "1313 CEMETERY LN", "# 000", "WESTFIELD", "NJ", "07091", CountryExtended.US);
        addressEditable5 = populateAddressEditable(addressEditable5, "GORDON CRAVEN", "155 Elm St", null, "WESTFIELD", "NJ", "07090", CountryExtended.US);
        addressEditable6 = populateAddressEditable(addressEditable6, "PUGSLEY", "155 Elm St", null, "WESTFIELD", "NJ", "07090", CountryExtended.US);

        ADDRESSES_EDITABLE.add(addressEditable0);
        ADDRESSES_EDITABLE.add(addressEditable1);
        ADDRESSES_EDITABLE.add(addressEditable2);
        ADDRESSES_EDITABLE.add(addressEditable3);
        ADDRESSES_EDITABLE.add(addressEditable4);
        ADDRESSES_EDITABLE.add(addressEditable5);
        ADDRESSES_EDITABLE.add(addressEditable6);
    }

    private void createBankAccountsList() {
        BankAccountWritable bankAccountWritable0 = new BankAccountWritable();
        BankAccountWritable bankAccountWritable1 = new BankAccountWritable();
        BankAccountWritable bankAccountWritable2 = new BankAccountWritable();
        BankTypeEnum individual = BankTypeEnum.INDIVIDUAL;
        bankAccountWritable0.setDescription("Test Bank Account");
        bankAccountWritable0.setRoutingNumber("322271627");
        bankAccountWritable0.setAccountNumber("123456789");
        bankAccountWritable0.setAccountType(individual);
        bankAccountWritable0.setSignatory("Sinead Occonor");

        bankAccountWritable1.setDescription("Test Bank Account");
        bankAccountWritable1.setRoutingNumber("322271627");
        bankAccountWritable1.setAccountNumber("123456789");
        bankAccountWritable1.setAccountType(individual);
        bankAccountWritable1.setSignatory("Juanito Lupo");

         bankAccountWritable2.setDescription("Test Bank Account");
         bankAccountWritable2.setRoutingNumber("322271627");
         bankAccountWritable2.setAccountNumber("123456789");
        bankAccountWritable2.setAccountType(individual);
        bankAccountWritable2.setSignatory("Jeanette Leloup");

        BANK_ACCOUNTS_WRITABLE.add(bankAccountWritable0);
        BANK_ACCOUNTS_WRITABLE.add(bankAccountWritable1);
        BANK_ACCOUNTS_WRITABLE.add(bankAccountWritable2);
    }

    private void  createBillingGroupsList() {
        BillingGroupEditable billingGroupEditable0 = new BillingGroupEditable();
        BillingGroupEditable billingGroupEditable1 = new BillingGroupEditable();
        BillingGroupEditable billingGroupEditable2 = new BillingGroupEditable();


        billingGroupEditable0 = populateBillingGroupEditable("TestBillingGroup1", "Billing Group 1", billingGroupEditable0);
        billingGroupEditable1 = populateBillingGroupEditable("TestBillingGroup2", "Billing Group 2", billingGroupEditable0);
        billingGroupEditable2 = populateBillingGroupEditable("TestBillingGroup3", "Billing Group 3", billingGroupEditable0);

        BILLING_GROUP_EDITABLE.add(billingGroupEditable0);
        BILLING_GROUP_EDITABLE.add(billingGroupEditable1);
        BILLING_GROUP_EDITABLE.add(billingGroupEditable2);
    }

    private void createTemplatesList () {
        TemplateWritable  templateWritable0 = new TemplateWritable();
        TemplateWritable  templateWritable1 = new TemplateWritable();
        TemplateWritable  templateWritable2 = new TemplateWritable();

        templateWritable0.setDescription("Newer Template");
        templateWritable0.setHtml( "<html>Updated HTML for Template 1/html>");
        templateWritable1.setDescription("Newer Template");
        templateWritable1.setHtml( "<html>Updated HTML for Template 2/html>");
        templateWritable2.setDescription("Newer Template");
        templateWritable2.setHtml( "<html>Updated HTML for Template 2/html>");

        TEMPLATES_WRITABLE.add(templateWritable0);
        TEMPLATES_WRITABLE.add(templateWritable1);
        TEMPLATES_WRITABLE.add(templateWritable2);
    }
}

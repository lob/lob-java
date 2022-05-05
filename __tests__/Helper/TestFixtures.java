package Helper;

import java.util.ArrayList;
import java.util.List;

import org.openapitools.client.model.AddressEditable;
import org.openapitools.client.model.BankAccountWritable;
import org.openapitools.client.model.BankTypeEnum;
import org.openapitools.client.model.CountryExtended;

public class TestFixtures {
    public String get_URL_VALID() {
        return "https://lob-assets.com/bank-accounts/asd_asdfghjkqwertyui.pdf?version=123&expires=1234567890&signature=aksdf";
    }

    private final List<AddressEditable> ADDRESSES_EDITABLE = new ArrayList<AddressEditable>();
    private final List<BankAccountWritable> BANK_ACCOUNTS_WRITABLE = new ArrayList<BankAccountWritable>();

    public List<AddressEditable> get_ADDRESSES_EDITABLE() {
        return ADDRESSES_EDITABLE;
    }

    public List<BankAccountWritable> get_BANK_ACCOUNTS_WRITABLE() {
        return BANK_ACCOUNTS_WRITABLE ;
    }

    public TestFixtures() {
        createBankAccountsList();
        createAddressesList();
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

    private void  createAddressesList() {
        AddressEditable addressEditable0 = new AddressEditable();
        AddressEditable addressEditable1 = new AddressEditable();
        AddressEditable addressEditable2 = new AddressEditable();
        AddressEditable addressEditable3 = new AddressEditable();
        AddressEditable addressEditable4 = new AddressEditable();
        AddressEditable addressEditable5 = new AddressEditable();
        AddressEditable addressEditable6 = new AddressEditable();

        addressEditable0 = populateAddressEditable(addressEditable0, "Thing T. Thing", "1313 CEMETERY LN", null, "WESTFIELD", "NJ", "07000", null);
        addressEditable1 = populateAddressEditable(addressEditable1, "FESTER", "001 CEMETERY LN", "SUITE 666", "WESTFIELD", "NJ", "07000",null);
        addressEditable2 = populateAddressEditable(addressEditable2, "MORTICIA ADDAMS", "1313 CEMETERY LN", null, "WESTFIELD", "NJ", "07000", null);
        addressEditable3 = populateAddressEditable(addressEditable3, "COUSIN ITT", "1515 CEMETERY LN", "FLOOR 0", "WESTFIELD", "NJ", "07000", null);
        addressEditable4 = populateAddressEditable(addressEditable4, "WEDNESDAY ADDAMS", "1313 CEMETERY LN", "# 000", "WESTFIELD", "NJ", "07000", CountryExtended.US);
        addressEditable5 = populateAddressEditable(addressEditable5, "GORDON CRAVEN", "1313 CEMETERY LN", null, "WESTFIELD", "NJ", "07000", CountryExtended.US);
        addressEditable6 = populateAddressEditable(addressEditable6, "PUGSLEY", "1313 CEMETERY LN", null, "WESTFIELD", "NJ", "07000", CountryExtended.US);

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
}

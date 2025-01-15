package demo.Zlabs.Lab12p2;

public class Customer {
    String CustomerID;
    String CompanyName;
    String ContactName;
    String ContactTitle;
    String Address;
    String City;
    String Region;
    String PostalCode;
    String Country;

    // Constructor for optional use
    public Customer(String customerID, String companyName, String contactName, String contactTitle,
                    String address, String city, String region, String postalCode, String country) {
        this.CustomerID = customerID;
        this.CompanyName = companyName;
        this.ContactName = contactName;
        this.ContactTitle = contactTitle;
        this.Address = address;
        this.City = city;
        this.Region = region;
        this.PostalCode = postalCode;
        this.Country = country;
    }

    // Optional: Override toString for clean printing
    @Override
    public String toString() {
        return "Customer ID: " + CustomerID + "\n" +
               "Company Name: " + CompanyName + "\n" +
               "Contact Name: " + ContactName + "\n" +
               "Contact Title: " + ContactTitle + "\n" +
               "Address: " + Address + "\n" +
               "City: " + City + "\n" +
               "Region: " + Region + "\n" +
               "Postal Code: " + PostalCode + "\n" +
               "Country: " + Country + "\n";
    }
}

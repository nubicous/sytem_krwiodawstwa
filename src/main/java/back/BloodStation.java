package back;

public class BloodStation {
    private int id;
    private String name;
    private String city;
    private String zipCode;
    private String street;
    private int buildingNumber;
    private String phoneNumber;
    private String email;
    private String website;

    public BloodStation(final int id, final String name, final String city, final String zipCode, final String street,
                        final int buildingNumber, final String phoneNumber, final String email, final String website) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.zipCode = zipCode;
        this.street = street;
        this.buildingNumber = buildingNumber;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.website = website;
    }

    public BloodStation(final String name, final String city, final String zipCode, final String street,
                        final int buildingNumber, final String phoneNumber, final String email, final String website) {
        this.name = name;
        this.city = city;
        this.zipCode = zipCode;
        this.street = street;
        this.buildingNumber = buildingNumber;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.website = website;
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(final String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(final String zipCode) {
        this.zipCode = zipCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(final String street) {
        this.street = street;
    }

    public int getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(final int buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(final String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(final String website) {
        this.website = website;
    }

    @Override
    public String toString() {
        return "back.BloodStation{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", street='" + street + '\'' +
                ", buildingNumber=" + buildingNumber +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", website='" + website + '\'' +
                '}';
    }
}

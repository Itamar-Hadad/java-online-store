package onlinestore;

public class Address {
    private String street;
    private int houseNumber;
    private String city;
    private String country;

    //Constructor
    public Address(String street, int houseNumber, String city, String country) throws StringEmptyNullException,
            IllegalArgumentException{
        setStreet(street);
        setHouseNumber(houseNumber);
        setCity(city);
        setCountry(country);

    }

    //Copy Constructor
    public Address(Address other) {
        this.street = other.street;
        this.houseNumber = other.houseNumber;
        this.city = other.city;
        this.country = other.country;

    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) throws StringEmptyNullException {
        if (street == null || street.isEmpty()) {
            throw new StringEmptyNullException("street");
        }
        this.street = street;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) throws IllegalArgumentException {
        if (houseNumber < 1) {
            throw new IllegalArgumentException("House Number cannot be less than 1");
        }
        this.houseNumber = houseNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) throws StringEmptyNullException {
        if (city == null || city.isEmpty()) {
            throw new StringEmptyNullException("city");
        }
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) throws StringEmptyNullException {
        if (country == null || country.isEmpty()) {
            throw new StringEmptyNullException("Country");
        }
        this.country = country;
    }

    @Override
    public String toString() {
        return street + ", " + houseNumber + ", " + city + ", " + country;
    }
}

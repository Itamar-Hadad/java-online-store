package onlinestore;

public class Product implements Cloneable {
    protected String name;

    protected double price;

    protected static int counter;
    protected int serialNumber;

    protected eCategory category;

    // Constructor
    public Product(String name, double price, eCategory category) throws StringEmptyNullException,
            NegativeNumException{
        setName(name);
        setPrice(price);
        this.serialNumber = ++counter;
        this.category = category;
    }

    // Copy Constructor
    public Product(Product other) {
        this.name = other.name;
        this.price = other.price;
        this.serialNumber = other.serialNumber;
        this.category = other.category;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) throws StringEmptyNullException {
        if (name == null || name.isEmpty()) {
            throw new StringEmptyNullException("name");
        }
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) throws NegativeNumException {
        if (price < 0) {
            throw new NegativeNumException("price");
        }
        this.price = price;
    }

    public eCategory getCategory() {
        return category;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public static int getCounter() {
        return counter;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Product)) {
            return false;
        }
        Product product = (Product)other;
        return product.name.equals(this.name) && product.price == this.price && product.category == this.category &&
                product.serialNumber == this.serialNumber;
    }

    @Override
    public Product clone() throws CloneNotSupportedException {
        return (Product)super.clone();
    }

    @Override
    public String toString() {
        return name + ", " + price + "$, " + "Serial Num: " + serialNumber;
    }
}

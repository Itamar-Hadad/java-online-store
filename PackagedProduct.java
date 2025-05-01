package onlinestore;

public class PackagedProduct extends Product {

    double packagedPrice;

    //constructor
    public PackagedProduct(String name, double price, eCategory category, double packagedPrice)
            throws StringEmptyNullException, NegativeNumException{
        super(name, price, category);
        setWrappedPrice(packagedPrice);
    }

    //copy constructor
    public PackagedProduct(PackagedProduct other) {
        super(other);
        this.packagedPrice = other.packagedPrice;
    }

    public double getPackagedPrice() {
        return packagedPrice;
    }

    public void setWrappedPrice(double packagedPrice) throws NegativeNumException{
        if (packagedPrice < 0) {
            throw new NegativeNumException("Package price");
        }
        this.packagedPrice = packagedPrice;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof PackagedProduct packagedProduct)) {
            return false;
        }
        return super.equals(other) && this.packagedPrice == packagedProduct.packagedPrice;
    }


    @Override
    public PackagedProduct clone() throws CloneNotSupportedException {
        return (PackagedProduct)super.clone();
    }

    @Override
    public String toString() {
        return super.toString() + ", Package price: " + packagedPrice + "$";
    }
}

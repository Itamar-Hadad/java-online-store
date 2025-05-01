package onlinestore;

public class Seller implements Comparable<Seller>{
    private User user;

    private ProductList products;

    //Constructor
    public Seller(String userName, String password) throws StringEmptyNullException{
        this.user = new User(userName, password);
        this.products = new ProductList();
    }



    //Copy Constructor
    public Seller(Seller other) {
        this.user = other.user;
        this.products = new ProductList(other.products);
    }

    public String getUserName() {
        return user.getName();
    }

    public String getPassword() {
        return user.getPassword();
    }

    public Product[] getProducts() {
        return products.getProducts();
    }

    public int getAmountProducts() {
        return products.getAmountProducts();
    }


    public void addProduct(Product product) {
        if (product instanceof PackagedProduct) {
            products.addProduct(new PackagedProduct((PackagedProduct) product));

        }else {
            products.addProduct(new Product(product));
        }

    }


    //פונקציה שבנינו סתם אין צורך לבדוק
    //this function checks if the product exists by name and price, but we don't have an id for each product
    // so you can't identify, if it's enough for you to compare with only by name and price so you can use this function.
    // in main we attach thw apart that support this code
    public boolean checkProductExist (Product product) {
        for (int i = 0; i < products.getAmountProducts(); i++) {
            if (products.getProducts()[i].getName().equals(product.getName()) &&
                    products.getProducts()[i].getPrice() == product.getPrice() ) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int compareTo(Seller s) {
        if (getAmountProducts() < s.getAmountProducts()) {return -1;}
        else if (getAmountProducts() > s.getAmountProducts()) {return +1;}
        return 0;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Seller)) {
            return false;
        }
        Seller seller = (Seller) other;
        return this.user.equals(seller.user) && this.products.equals(seller.products);
    }

    @Override
    public String toString() {
        StringBuffer res = new StringBuffer(user.getName());
        if (products.getAmountProducts() == 0) {
            res.append("\nThere are no products in this seller\n");
        }
        else {
            res.append("\nThe products of the seller:\n");
            for (int i = 0; i < products.getAmountProducts(); i++) {
                res.append("- " + products.getProducts()[i].toString() + "\n");
            }
        }
        return res.toString();
    }
}

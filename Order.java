package onlinestore;

import java.time.LocalDate;

public class Order implements Cloneable {

    private ProductList products;

    private double totalPrice;

    private LocalDate date;


    //Constructor
    public Order() {
        this.products = new ProductList();
        this.totalPrice = 0;
        this.date = LocalDate.now();
    }

    //Copy Constructor
    public Order(Order other) {
        this.products = new ProductList(other.products);
        this.totalPrice = other.totalPrice;
        this.date = other.date;
    }

    public int getAmountProducts() {
        return products.getAmountProducts();
    }

    public Product[] getProducts() {
        return products.getProducts();
    }

    public double getTotalPrice() {
        return totalPrice;
    }


    public LocalDate getDate() {
        return date;
    }


    public void addProduct(Product product) {
        products.addProduct(product);
        totalPrice += product.getPrice();
        if (product instanceof PackagedProduct) {
            totalPrice += ((PackagedProduct) product).getPackagedPrice();
        }
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Order)) {
            return false;
        }
        Order Order = (Order) other;
        return this.products.equals(Order.products) && this.totalPrice == Order.totalPrice && this.date.equals(Order.date);
    }

    @Override
    public Order clone() throws CloneNotSupportedException {
        Order temp = (Order) super.clone();
        temp.products = products.clone();
        return temp;
    }

    @Override
    public String toString() {
        StringBuffer res = new StringBuffer(
                "\nOrder summary:\n" + "\nDate Order: " + date + "\n" + "Amount of Products: "
                        + products.getAmountProducts() + "\n" + "The items in the Order:\n"
        );
        res.append(products.toString());
        res.append("Total Price Order: " + totalPrice + "$");
        return res.toString();
    }
}


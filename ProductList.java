package onlinestore;

import java.util.Arrays;

public class ProductList implements Cloneable{
    private Product[] products;
    private int amountProducts;

    //constructor
    public ProductList() {
        this.products = new Product[2];
        this.amountProducts = 0;
    }

    //copy constructor
    public ProductList(ProductList other) {
        this.amountProducts = other.amountProducts;
        this.products = new Product[other.products.length];
        for (int i = 0; i < this.amountProducts; i++) {
            products[i] = new Product(other.products[i]);
        }
    }

    public Product[] getProducts() {
        return this.products;
    }

    public int getAmountProducts() {
        return this.amountProducts;
    }

    private void largeArrayProduct() {
        if (amountProducts == products.length) {
            Product[] newProducts = new Product[products.length * 2];
            for (int i = 0; i < amountProducts; i++) {
                newProducts[i] = products[i];
            }
            this.products = newProducts;
        }
    }

    public void addProduct(Product product) {
        largeArrayProduct();
        products[amountProducts++] = product;
    }

    //פונקציה שבנינו סתם לא צריך לבדוק אותה
    //Switch between old product to a new one
    public boolean updateProduct(Product oldProduct, Product newProduct) {
        for (int i = 0; i < amountProducts; i++) {
            if (products[i].equals(oldProduct)) {
                products[i] = newProduct;
                return true;
            }
        }
        return false;
    }

    //פונקציה שבנינו סתם לא צריך לבדוק אותה
    //remove or change product from seller
    // this function checks if the product exist and if exist its remove the product.
    public boolean removeProduct(Product product) {
        for (int i = 0; i < amountProducts; i++) {
            if (products[i].equals(product)) {
                for (int j = i + 1; j < amountProducts; j++) {
                    products[j - 1] = products[j];
                }
                products[amountProducts - 1] = null;
                amountProducts--;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof ProductList)) {
            return false;
        }
        ProductList products = (ProductList) other;
        return Arrays.equals(this.products, products.products);
    }

    @Override
    public ProductList clone() throws CloneNotSupportedException {
        ProductList temp = (ProductList) super.clone();
        for (int i = 0; i < temp.amountProducts; i++) {
            temp.products[i] = this.products[i].clone();
        }
        return temp;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < amountProducts; i++) {
            sb.append("- " + products[i].toString() + "\n");
        }
        return sb.toString();
    }
}

package onlinestore;

import java.util.Arrays;

public class Buyer implements Comparable<Buyer> {
    private User user;

    private Order currentCart;
    private Order[] historyOrders;
    private int amountHistoryOrders;

    private Address address;


    //Constructor
    public Buyer(String userName, String password, Address address) throws StringEmptyNullException {
        user = new User(userName, password);
        historyOrders = new Order[2];
        amountHistoryOrders = 0;
        this.address = new Address(address);
        this.currentCart = new Order();
    }

    //copy constructor
    public Buyer(Buyer other) {
        this.user = other.user;
        this.amountHistoryOrders = other.amountHistoryOrders;
        this.address = new Address(other.address);
        this.historyOrders = new Order[other.historyOrders.length];
        for (int i = 0; i < amountHistoryOrders; i++) {
            this.historyOrders[i] = new Order(other.historyOrders[i]);
        }
        this.currentCart = new Order(other.currentCart);
    }

    public String getUserName() {
        return user.getName();
    }



    public String getPassword() {
        return user.getPassword();
    }


    public Address getAddress() {
        return address;
    }

    public Order[] getHistoryOrders() {
        return historyOrders;
    }

    public int getAmountHistoryOrders() {
        return amountHistoryOrders;
    }

    public void cloneCart(Order order) throws CloneNotSupportedException {
        this.currentCart = order.clone();

    }

    public Order getCurrentCart() {
        return currentCart;
    }


    public Order beforeCheckOut() throws EmptyCartException {
        if (currentCart.getAmountProducts() == 0) {
            throw new EmptyCartException();
        }
        return currentCart;
    }


    private void largeArrayHistory() {
        if (amountHistoryOrders == historyOrders.length) {
            Order[] newHistoryOrders = new Order[historyOrders.length * 2];
            for (int i = 0; i < amountHistoryOrders; i++) {
                newHistoryOrders[i] = historyOrders[i];
            }
            this.historyOrders = newHistoryOrders;
        }
    }

    public void checkout(){
        largeArrayHistory();
        historyOrders[amountHistoryOrders++] = this.currentCart;
        this.currentCart = new Order();
    }

    @Override
    public int compareTo(Buyer b) {
        return getUserName().compareTo(b.getUserName());
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Buyer)) {
            return false;
        }
        Buyer buyer = (Buyer) other;
        return this.user.equals(buyer.user) && this.currentCart.equals(buyer.currentCart) &&
                Arrays.equals(this.historyOrders, buyer.historyOrders) && this.amountHistoryOrders == buyer.amountHistoryOrders
                && this.address.equals(buyer.address);
    }


    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer(user.getName() + ", Address: " + address);

        if (amountHistoryOrders > 0) {
            sb.append("\n\nThe History Orders Of " + getUserName() + ":\n");
            for (int i = 0; i < amountHistoryOrders; i++) {
                sb.append("\n" + (i + 1) + ") Order number " + (i + 1) + "\n" );
                sb.append(historyOrders[i].toString() + "\n");
                sb.append("-----------------------------------\n");
            }
        } else {
            sb.append("\nThis Buyer has no history orders\n");
        }
        return sb.toString();
    }
}

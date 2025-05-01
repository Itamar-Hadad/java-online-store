package onlinestore;

import java.util.Arrays;

public class SystemManager {
    private String systemName;

    private Seller[] sellers;
    private int amountSellers;

    private Buyer[] buyers;
    private int amountBuyers;

    //Constructor
    public SystemManager(String systemName) {
        setSystemName(systemName);
        this.amountSellers = 0;
        this.amountBuyers = 0;
        this.sellers = new Seller[2];
        this.buyers = new Buyer[2];
    }


    public String getSystemName() {
        return systemName;
    }

    public boolean setSystemName(String systemName) {
        if (systemName == null || systemName.isEmpty()) {
            return false;
        }
        this.systemName = systemName;
        return true;
    }

    public boolean sellerNameExist(String sellerName) {
        for (int i = 0; i < amountSellers; i++) {
            if (sellerName.equals(sellers[i].getUserName())) {
                return true;
            }
        }
        return false;
    }


    private void largeArraySeller(){
        if (amountSellers == sellers.length){
            Seller[] newSellers = new Seller[sellers.length * 2];
            for (int i = 0; i < sellers.length; i++) {
                newSellers[i] = sellers[i];
            }
            sellers = newSellers;
        }
    }

    public boolean addSeller(Seller seller) {
        largeArraySeller();
        sellers[amountSellers++] = new Seller(seller);
        return true;
    }

    public boolean buyerNameExist(String buyerName) {
        for (int i = 0; i < amountBuyers; i++) {
            if (buyerName.equals(buyers[i].getUserName())) {
                return true;
            }
        }
        return false;
    }


    private void largeArrayBuyers(){
        if (amountBuyers == buyers.length){
            Buyer[] newBuyers = new Buyer[buyers.length * 2];
            for (int i = 0; i < buyers.length; i++) {
                newBuyers[i] = buyers[i];
            }
            buyers = newBuyers;
        }
    }

    public boolean addBuyer(Buyer buyer) {
        largeArrayBuyers();
        buyers[amountBuyers++] = new Buyer(buyer);
        return true;
    }

    public Seller[] getSellers() {
        return sellers;
    }

    public Buyer[] getBuyers() {
        return buyers;
    }

    public int getAmountSellers() {
        return amountSellers;
    }

    public int getAmountBuyers() {
        return amountBuyers;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof SystemManager)) {
            return false;
        }
        SystemManager manager = (SystemManager) other;
        return this.systemName.equals(manager.getSystemName()) && this.amountSellers == manager.getAmountSellers() &&
                this.amountBuyers == manager.getAmountBuyers() && Arrays.equals(this.sellers, manager.getSellers()) &&
                Arrays.equals(this.buyers, manager.getBuyers());
    }

    @Override
    public String toString() {
        return "Name: " + systemName + ", amountSellers: " + amountSellers + ", amountBuyers: " + amountBuyers;
    }
}

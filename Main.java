package onlinestore;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {
    static Scanner s = new Scanner(System.in);


    public static void addSeller(SystemManager systemManager){
        String nameSeller;
        String passwordSeller;
        boolean isValidInput = false;

        while (!isValidInput) {
            try {
                System.out.println("Enter seller Username (without spaces): ");
                nameSeller = s.next();

                while (systemManager.sellerNameExist(nameSeller)) {
                    System.out.println("Username " + nameSeller + " already exists.");

                    System.out.println("Enter seller Username: ");
                    nameSeller = s.next();
                }


                System.out.println("Enter seller Password: ");
                passwordSeller = s.next();

                systemManager.addSeller(new Seller(nameSeller, passwordSeller));
                System.out.println("seller: " + nameSeller + " added successfully");
                isValidInput = true;
            } catch (StringEmptyNullException e){
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Something went wrong");
            }
        }
    }

    public static void addBuyer(SystemManager systemManager){
        String nameBuyer;
        String passwordBuyer;
        String street;
        int houseNumber;
        String city;
        String country;
        boolean isValidInput = false;

        while (!isValidInput) {
            try {
                System.out.println("Enter buyer Username (without spaces): ");
                nameBuyer = s.next();

                while (systemManager.buyerNameExist(nameBuyer)) {
                    System.out.println("Username: " + nameBuyer + " already exists");

                    System.out.println("Enter buyer Username: ");
                    nameBuyer = s.next();
                }

                System.out.println("Enter Password: ");
                passwordBuyer = s.next();
                s.nextLine();

                System.out.println("Enter your street name: ");
                street = s.nextLine();

                System.out.println("Enter your house number: ");
                houseNumber = s.nextInt();


                System.out.println("Enter your city: ");
                s.nextLine();
                city = s.nextLine();

                System.out.println("Enter your country: ");
                country = s.nextLine();



                Address address = new Address(street, houseNumber, city, country);
                systemManager.addBuyer(new Buyer(nameBuyer, passwordBuyer, address));
                System.out.println("buyer: " + nameBuyer + " added successfully");
                isValidInput = true;
            } catch (StringEmptyNullException | IllegalArgumentException e){
                System.out.println(e.getMessage());
            } catch (InputMismatchException e){
                s.next();
                System.out.println("The input must be a number");
            }
            catch (Exception e) {
                System.out.println("Something went wrong");
            }
        }
    }

    //this function prints the sellers names by a number list
    public static void printSerialSellerList(SystemManager systemManager){
        for (int i = 0; i < systemManager.getAmountSellers(); i++) {
            System.out.println(i + 1 + ") " + systemManager.getSellers()[i].getUserName());
        }
    }

    public static Seller getSellerBySerialNum(SystemManager systemManager) {
        int choiceSeller;
        Seller[] sellers = systemManager.getSellers();
        Seller seller = null;

        boolean isValidInput = false;
        while (!isValidInput) {
            try {
                choiceSeller = readInt();

                seller = sellers[choiceSeller - 1];
                if (seller == null) {
                    throw new NullPointerException();
                }
                isValidInput = true;
            } catch (NullPointerException | ArrayIndexOutOfBoundsException e) {
                System.out.println("The input must be a number from the list");
            } catch (Exception e) {
                System.out.println("Something went wrong");
            }
        }
        return seller;
    }

    //this function prints the buyers names by a number list
    public static void printSerialBuyerList(SystemManager systemManager){
        for (int i = 0; i < systemManager.getAmountBuyers(); i++) {
            System.out.println(i + 1 + ") " + systemManager.getBuyers()[i].getUserName());
        }
    }

    public static Buyer getBuyerBySerialNum(SystemManager systemManager){
        int choiceBuyer;
        Buyer[] buyers = systemManager.getBuyers();
        Buyer buyer = null;
        boolean isValidBuyer = false;


        while (!isValidBuyer) {
            try {
                choiceBuyer = readInt();
                s.nextLine();

                buyer = buyers[choiceBuyer - 1];
                if (buyer == null) {
                    throw new NullPointerException();
                }
                isValidBuyer = true;
            } catch (ArrayIndexOutOfBoundsException | NullPointerException e) {
                System.out.println("The input must be a number from the list");
            } catch (Exception e) {
                System.out.println("Something went wrong");
            }
        }
        return buyer;
    }

    public static int readInt(){
        int choice = 0;
        boolean isValidInput = false;
        while (!isValidInput) {
            try {
                System.out.println("\nEnter your choice: ");
                choice = s.nextInt();
                isValidInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Input must be a number.");
                s.next();
            } catch (Exception e) {
                System.out.println("Something went wrong");
            }
        }
        return choice;
    }

    //this function prints the categories by a number list
    public static void printCategories (){
        eCategory[] allCategories = eCategory.values();
        for (int i = 0; i < allCategories.length; i++) {
            System.out.println(i + 1 + ") " + allCategories[i].name());
        }
    }


    public static String validateInputYesOrNo(String choice){
        while (!choice.toLowerCase().equals("yes") && !choice.toLowerCase().equals("no")){
            System.out.println("Invalid choice");
            System.out.println("You need to write only yes or no");
            System.out.println("\nEnter your choice: ");
            choice = s.next();
        }
        return choice;
    }



    public static void addProductSeller(SystemManager systemManager){
        if (systemManager.getAmountSellers() == 0){
            System.out.println("You don't have any sellers to add product");
            return;
        }

        String name;

        double price;

        Seller seller;

        int choiceCategory;

        eCategory category;


        System.out.println("\nChoose seller's Username to add product to him: \n");
        printSerialSellerList(systemManager);

        seller = getSellerBySerialNum(systemManager);

        boolean isValidInput = false;
        while (!isValidInput) {
            try {
                s.nextLine();
                System.out.println("Enter the name of the product: ");
                name = s.nextLine();

                System.out.println("Enter the price of the product: ");
                price = s.nextDouble();

                System.out.println("Choose the category of the product: ");

                printCategories();

                choiceCategory = readInt();

                category = eCategory.values()[choiceCategory - 1];

                System.out.println("Do you want to sell this product with a package? (Yes/No): ");
                String choice = s.next();

                choice = validateInputYesOrNo(choice);

                if (choice.toLowerCase().equals("yes")) {
                    System.out.println("Enter the price of the package: ");

                    double packagePrice = s.nextDouble();

                    System.out.println("yay so the product will be in a package \uD83D\uDCE6");

                    Product product = new PackagedProduct(name, price, category, packagePrice);
                    seller.addProduct(product);
                } else {
                    System.out.println("yay so the product will not be in a package \uD83D\uDEAB \uD83D\uDCE6");
                    seller.addProduct(new Product(name, price, category));
                }

                System.out.println("Product: " + seller.getProducts()[seller.getAmountProducts() - 1].toString() +
                        " added successfully to the seller " + seller.getUserName());
                isValidInput = true;
            } catch (InputMismatchException e){
                System.out.println("Input must be a number.");
                s.next();
            } catch (ArrayIndexOutOfBoundsException e){
                System.out.println("The input must be a number from the list");
            } catch (StringEmptyNullException | NegativeNumException e){
                System.out.println(e.getMessage());
            } catch (Exception e){
                System.out.println("Something went wrong");
            }
        }
    }


    public static void addProductBuyer(SystemManager systemManager){
        Buyer buyer;
        Seller seller;

        if (systemManager.getAmountBuyers() == 0){
            System.out.println("You don't have any buyers to add product");
            return;
        }

        System.out.println("\nChoose Seller's Username to buy from: \n");
        printSerialSellerList(systemManager);

        seller = getSellerBySerialNum(systemManager);


        if (seller.getAmountProducts() == 0){
            System.out.println("This seller does not have any products");
            return;
        }


        System.out.println("\nChoose buyer's Username to add product to him: \n");
        printSerialBuyerList(systemManager);

        buyer = getBuyerBySerialNum(systemManager);


        System.out.println("\nChoose the product you want: \n");
        Product[] products = seller.getProducts();

        for (int i = 0; i < seller.getAmountProducts(); i++) {
            System.out.println(i + 1 + ") " + products[i].toString());
        }

        boolean isValidInput = false;
        while (!isValidInput) {
            try {
                int choiceProduct = readInt();

                Product product = seller.getProducts()[choiceProduct - 1];

                buyer.getCurrentCart().addProduct(product);
                System.out.println("You added to the buyer: " + buyer.getUserName() +
                        "\nThe product: " + product.getName());
                isValidInput = true;
            } catch (ArrayIndexOutOfBoundsException | NullPointerException e){
                System.out.println("The input must be a number from the list");
            } catch (Exception e){
                System.out.println("Something went wrong");
            }
        }
    }


    public static void payCart(SystemManager systemManager){
        Buyer buyer;

        if (systemManager.getAmountBuyers() == 0){
            System.out.println("There is no buyers in the system");
            return;
        }

        System.out.println("\nChoose buyer to pay cart: \n");
        printSerialBuyerList(systemManager);

        buyer = getBuyerBySerialNum(systemManager);

        try {
            System.out.println(buyer.beforeCheckOut().toString());
        }catch (EmptyCartException e){
            System.out.println(e.getMessage());
            return;
        } catch (Exception e){
            System.out.println("Something went wrong");
            return;
        }

        System.out.println("\nDo you want to pay the cart? [Yes/No]:  ");
        String choice = s.next();

        choice = validateInputYesOrNo(choice);

        if (choice.toLowerCase().equals("yes")) {
            buyer.checkout();
            System.out.println("You payed cart successfully");
        } else {
            System.out.println("Ok search more staff that you want to add");
        }

    }

    public static void printBuyers(SystemManager systemManager){
        if (systemManager.getAmountBuyers() == 0){
            System.out.println("There is no buyers in the system");
            return;
        }
        Buyer[] buyers = systemManager.getBuyers();
        Buyer[] copyBuyers = new Buyer[systemManager.getAmountBuyers()];
        System.arraycopy(buyers, 0, copyBuyers, 0, systemManager.getAmountBuyers());
        Arrays.sort(copyBuyers);
        System.out.println("The buyers are:\n");
        for (int i = 0; i < copyBuyers.length; i++){
            System.out.println(i + 1 + ") "+ copyBuyers[i].toString());
        }
    }

    public static void printSellers(SystemManager systemManager){
        if (systemManager.getAmountSellers() == 0){
            System.out.println("There is no sellers in the system");
            return;
        }
        Seller[] sellers = systemManager.getSellers();
        Seller[] copySellers = new Seller[systemManager.getAmountSellers()];
        System.arraycopy(sellers, 0, copySellers, 0, systemManager.getAmountSellers());
        Arrays.sort(copySellers);
        System.out.println("The sellers are:\n");
        for (int i = 0; i < copySellers.length; i++){
            System.out.println(i + 1 + ") "+ copySellers[i].toString());
        }
    }

    public static void printProductsByCategory(SystemManager systemManager){
        int choiceCategory;

        System.out.println("\n Choose the category to see its products:");
        printCategories();

        boolean isValidInput = false;
        while (!isValidInput) {
            try {
                choiceCategory = readInt();

                eCategory category = eCategory.values()[choiceCategory - 1];

                System.out.println("\nThe products from the category " + category.name() + ":");

                int counter = 0;

                for (int i = 0; i < systemManager.getAmountSellers(); i++){
                    Seller seller = systemManager.getSellers()[i];
                    for (int j = 0; j < seller.getAmountProducts(); j++) {
                        if (seller.getProducts()[j].getCategory() == category) {
                            System.out.println(++counter + ") " + seller.getProducts()[j].toString() + ", being sold by: "
                                    + seller.getUserName());
                        }
                    }

                }
                if (counter == 0){System.out.println("\nThis category don't have any products");}

                isValidInput = true;
            } catch (InputMismatchException e){
                System.out.println("Input must be a number.");
            } catch (ArrayIndexOutOfBoundsException e){
                System.out.println("The input must be a number from the list");
            } catch (Exception e){
                System.out.println("Something went wrong");
            }
        }

    }

    public static void cloneCart(Buyer buyer, Order order){
        try {
            buyer.cloneCart(order);
            System.out.println("The current cart was updated successfully with the order that you chose.");
            return;
        } catch (CloneNotSupportedException e) {
            System.out.println("Something went wrong");
        } catch (Exception e){
            System.out.println("Something went wrong");
        }
    }

    public static void switchCurrCartFromHistory(SystemManager systemManager) {
        Buyer buyer;
        Order order = null;
        int choiceOrder;
        String choiceYesNo;

        if (systemManager.getAmountBuyers() == 0) {
            System.out.println("There is no buyers in the system");
            return;
        }

        System.out.println("Please choose a buyer that you want to switch his current order:");
        printSerialBuyerList(systemManager);

        buyer = getBuyerBySerialNum(systemManager);

        if (buyer.getAmountHistoryOrders() == 0){
            System.out.println("There is no orders in the system for this buyer");
            return;
        }


        System.out.println("Choose the Order from History that you want to switch: ");
        System.out.println(buyer.toString());

        boolean isValidInput = false;
        while (!isValidInput) {
            try {
                choiceOrder = readInt();
                order = buyer.getHistoryOrders()[choiceOrder - 1];
                isValidInput = true;
            } catch (ArrayIndexOutOfBoundsException | NullPointerException e) {
                System.out.println("The input must be a number from the list");
            } catch (Exception e) {
                System.out.println("Something went wrong");
            }
        }

        if (buyer.getCurrentCart().getAmountProducts() != 0){
            System.out.println(buyer.getUserName() + "current cart isn't empty");
            System.out.println("Do you want to switch your current cart? [Yes/No]:  ");
            choiceYesNo = validateInputYesOrNo(s.next());
            if (choiceYesNo.toLowerCase().equals("yes")){
                cloneCart(buyer, order);
            } else {
                System.out.println("Return to menu");
            }
        } else {
            cloneCart(buyer, order);
        }
    }




    public static void menu(SystemManager systemManager) {
        int choice;
        boolean notQuit = true;

        do {
            System.out.println("\n \uD83D\uDECD\uFE0F Welcome to " + systemManager.getSystemName()
                    + " \uD83D\uDECD\uFE0F");
            System.out.println("Thank you for choosing us, we will take care that you will get whatever you want.");
            System.out.println("We hope that you will enjoy our website.");
            System.out.println();
            System.out.println("Please choose one of the following options:");
            System.out.println("0) Exit \uD83D\uDD1A\uD83C\uDFC3\uD83D\uDEAA" );
            System.out.println("1) Add a seller");
            System.out.println("2) Add a buyer");
            System.out.println("3) Add a product for the seller");
            System.out.println("4) Add a product for the buyer");
            System.out.println("5) Pay for your products in your cart (Yay!) \uD83D\uDCB3\uD83D\uDED2\uD83D\uDCB8\uD83D\uDCB0 ");
            System.out.println("6) Show the list of buyers");
            System.out.println("7) Show the list of sellers");
            System.out.println("8) Show the list of products");
            System.out.println("9) Put order from history to current cart");


            choice = readInt();

            switch (choice) {
                case 0:
                    notQuit = false;
                    break;

                case 1:
                    addSeller(systemManager);
                    break;

                case 2:
                    addBuyer(systemManager);
                    break;

                case 3:
                    addProductSeller(systemManager);
                    break;

                case 4:
                    addProductBuyer(systemManager);
                    break;

                case 5:
                    payCart(systemManager);
                    break;

                case 6:
                    printBuyers(systemManager);
                    break;

                case 7:
                    printSellers(systemManager);
                    break;

                case 8:
                    printProductsByCategory(systemManager);
                    break;

                case 9:
                    switchCurrCartFromHistory(systemManager);
                    break;

                default:
                    System.out.println("That is not a valid option");

            }




        } while (notQuit); {
            System.out.println("\nThank you for visiting our website!");
            System.out.println("We hope that we will see you again");
        }

    }
    public static void main(String[] args) {
        SystemManager systemManager = new SystemManager("IYR");
        menu(systemManager);
    }
}

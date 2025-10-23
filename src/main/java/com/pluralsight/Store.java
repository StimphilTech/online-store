
package com.pluralsight;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class Store {

    public static void main(String[] args) {

        // Create lists for inventory and the shopping cart
        ArrayList<Product> inventory = new ArrayList<>();
        ArrayList<Product> cart = new ArrayList<>();

        // Load inventory from the data file (pipe-delimited: id|name|price)
        loadInventory("products.csv", inventory);

        // Main menu loop
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        while (choice != 3) {
            System.out.println("\nWelcome to the Online Store!");
            System.out.println("1. Show Products");
            System.out.println("2. Show Cart");
            System.out.println("3. Exit");
            System.out.print("Your choice: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Please enter 1, 2, or 3.");
                scanner.nextLine();                 // discard bad input
                continue;
            }
            choice = scanner.nextInt();
            scanner.nextLine();                     // clear newline

            switch (choice) {
                case 1 -> displayProducts(inventory, cart, scanner);
                case 2 -> displayCart(cart, scanner);
                case 3 -> System.out.println("Thank you for shopping with us!");
                default -> System.out.println("Invalid choice!");
            }
        }
        scanner.close();
    }

    /**
     * Reads product data from a file and populates the inventory list.
     * File format (pipe-delimited):
     * id|name|price
     * <p>
     * Example line:
     * A17|Wireless Mouse|19.99
     */
    public static void loadInventory(String fileName, ArrayList<Product> inventory) {
        // TODO: read each line, split on "|",
        //       create a Product object, and add it to the inventory list

        File file = new File (fileName);
//        if (!file.exists()){
//            file.createNewFile();
//        }
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String input;

            while((input = reader.readLine()) != null) {
                String[] token = input.split("\\|");
                String id = token[0];
                String name = token [1];
                double price = Double.parseDouble(token [2]);



                inventory.add (new Product(id,name,price));


            }
            reader.close();

        } catch (IOException e) {
            System.out.println("File cannot be read");
            ;

        }







        }

    /**
     * Displays all products and lets the user add one to the cart.
     * Typing X returns to the main menu.
     */
    public static void displayProducts(ArrayList<Product> inventory,
                                       ArrayList<Product> cart,
                                       Scanner scanner) {
        // TODO: show each product (id, name, price),
        //       prompt for an id, find that product, add to cart

        Scanner myscanner = null;
        try {


            myscanner = new Scanner(System.in);
//        int choice =
//        while (choice !=) {
            Product nintendo = new Product("GM1245", "Nintendo Switch Lite", 199.99);
            nintendo.setId("GM1245");
            nintendo.setName("Nintendo Switch Lite");
            nintendo.setPrice(199.99);

            System.out.println("Please provide id for the product");
            String id = myscanner.nextLine();
            System.out.println(("Please provide the name of the product"));
            String name = myscanner.nextLine();
            System.out.println("Please enter the price");
            String price = myscanner.nextLine();
            System.out.println(nintendo.getId() + "|" + nintendo.getName() + "|" + nintendo.getPrice());

            inventory.add(new Product(nintendo.getId(), nintendo.getName(), nintendo.getPrice()));
            {


//            if (!scanner.hasNextInt()) {
//                System.out.println("");
//                scanner.nextLine();                 // discard bad input
//                continue;
//            }
//            choice = scanner.nextInt();
//            scanner.nextLine();                     // clear newline

//            switch (choice) {
//                case 1 -> displayProducts(inventory, cart, scanner);
//                case 2 -> displayCart(cart, scanner);
//                case 3 -> System.out.println("Thank you for shopping with us!");
//                default -> System.out.println("Invalid choice!");
//
//


            }


        } catch (NoSuchElementException e) {
            System.out.println("Please add the price of the item listed");
        } finally {
            myscanner.close();
        }


    }





    /**
     * Shows the contents of the cart, calculates the total,
     * and offers the option to check out.
     */
    public static void displayCart(ArrayList<Product> cart, Scanner scanner) {
        // TODO:
        //   • list each product in the cart
        //   • compute the total cost
        //   • ask the user whether to check out (C) or return (X)
        //   • if C, call checkOut(cart, totalAmount, scanner)
    }

    /**
     * Handles the checkout process:
     * 1. Confirm that the user wants to buy.
     * 2. Accept payment and calculate change.
     * 3. Display a simple receipt.
     * 4. Clear the cart.
     */
    public static void checkOut(ArrayList<Product> cart,
                                double totalAmount,
                                Scanner scanner) {
        // TODO: implement steps listed above
    }

    /**
     * Searches a list for a product by its id.
     *
     * @return the matching Product, or null if not foundSearches a list for a product by its id.
     *      *
     *      * @return the matching Product, or null if not found
     */
    public static Product findProductById(String id, ArrayList<Product> inventory) {
        // TODO: loop over the list and compare ids
        return null;
    }
}





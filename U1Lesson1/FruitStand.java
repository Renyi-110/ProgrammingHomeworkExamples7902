import java.util.Scanner;
public class FruitStand { //UpperCamelCase for class name

    // Scanner for the entire class
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) { //camelCase fpr method names & variable names
        // Prices
        double[] fruitPrices = {1.0, 0.99, 1.3, 1.25, 2.0}; // Use double since the prices are decimal values
        double[] drinkPrices = {0.5, 1, 1.2, 1.25, 2.0}; 
        String[] fruitNames = {"apple", "banana", "pear", "peach", "dragonfruit"}; // Use String since the names are text
        String[] drinkNames = {"water", "lemonade", "sprite", "coke", "milk"};
        double total = 0; // Total cost of the order
        double cost = 0; // Cost of each item in the receipt
        String again; // Variable to check if the user wants to place another order

        // Quantities
        int[] fruitQuantities = new int[5];
        int[] drinkQuantities = new int[5];

        System.out.println("Welcome to Yixin's Fruit Stand!");

        while (true) {
            // Reset quantities each time for a new customer
            for (int i = 0; i < 5; i++) {
                fruitQuantities[i] = 0;
                drinkQuantities[i] = 0;
            }

            // Ask for user name
            System.out.print("\nEnter your name (or type 'exit' to quit): ");
            String name = scanner.nextLine().trim();
            if (name.equalsIgnoreCase("exit")) break;

            System.out.println("\nHi " + name + "! Here's our menu:");
            printMenu(fruitNames, fruitPrices, "Fruits");
            printMenu(drinkNames, drinkPrices, "Drinks");

            // Order fruits
            if (askYesNo("Would you like to buy fruits? (yes/no): ")) {
                orderItems("fruit", fruitNames, fruitPrices, fruitQuantities);
            }

            // Order drinks
            if (askYesNo("Would you like to buy drinks? (yes/no): ")) {
                orderItems("drink", drinkNames, drinkPrices, drinkQuantities);
            }

            // Show receipt
            total = printReceipt(fruitNames, fruitPrices, fruitQuantities, drinkNames, drinkPrices, drinkQuantities, cost, total);
            System.out.printf("Total cost: $%.2f\n", total);

            System.out.println("\nWould you like to place another order? (type 'exit' to quit or press 'Enter' to continue)");
            again = scanner.nextLine().trim();
            if (again.equalsIgnoreCase("exit")) break;
        }

        System.out.println("Thank you for visiting Yixin's Fruit Stand!");
    }

    // Prints the menu for a given category (fruits or drinks) Procedural-type method
    public static void printMenu(String[] names, double[] prices, String title) {
        System.out.println("\n--- " + title + " Menu ---");
        for (int i = 0; i < names.length; i++) {
            System.out.printf("%-12s $%.2f\n", names[i], prices[i]);
        }
    }

    // Asks a yes/no question and returns true for "yes", false for "no" Functional-type method, it returns a value
    public static boolean askYesNo(String prompt) {
        System.out.print(prompt);
        String response = scanner.nextLine().trim().toLowerCase();
        return response.equals("yes");
    }

    // Orders items for a specific category (fruits or drinks) Functional-type method, it returns a value
    public static void orderItems(String category, String[] items, double[] prices, int[] quantities) {
        while (true) {
            System.out.print("Enter a " + category + " name (or 'done' to finish): ");
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("done")) 
            break;

            int index = findItemIndex(items, input);
            if (index == -1) {
                System.out.println("Invalid " + category + ". Please try again.");
                continue;
            }

            System.out.print("Enter quantity of " + input + ": ");
            try {
                int quantity = Integer.parseInt(scanner.nextLine());
                if (quantity < 0) {
                    System.out.println("Quantity cannot be negative.");
                    continue;
                }
                quantities[index] += quantity;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    // Finds the index of an item in the menu based on its name Functional-type method, it returns a value
    public static int findItemIndex(String[] items, String name) {
        for (int i = 0; i < items.length; i++) {
            if (items[i].equalsIgnoreCase(name)) return i;
        }
        return -1; // Return -1 if the item is not found
    }

    // Prints the receipt showing purchased items, their quantities, and total cost Functional-type method, it returns a value
    public static double printReceipt(String[] fruitNames, double[] fruitPrices, int[] fruitQuantities, String[] drinkNames, double[] drinkPrices, int[] drinkQuantities, double cost, double total) {
        System.out.println("\n--- Receipt ---");
        total = 0;

        // Fruits
        for (int i = 0; i < fruitNames.length; i++) {
            if (fruitQuantities[i] > 0) {
                cost = fruitQuantities[i] * fruitPrices[i];
                System.out.printf("%-12s x%d @ $%.2f = $%.2f\n", fruitNames[i], fruitQuantities[i], fruitPrices[i], cost);
                total += cost;
            }
        }

        // Drinks
        for (int i = 0; i < drinkNames.length; i++) {
            if (drinkQuantities[i] > 0) {
                cost = drinkQuantities[i] * drinkPrices[i];
                System.out.printf("%-12s x%d @ $%.2f = $%.2f\n", drinkNames[i], drinkQuantities[i], drinkPrices[i], cost);
                total += cost;
            }
        }

        return total; // Return the total cost of the order
    }
}

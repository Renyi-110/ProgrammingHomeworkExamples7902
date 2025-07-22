import java.util.Scanner;

public class FruitStandNoArraysOrMethods {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prices
        double applePrice = 1.0;
        double bananaPrice = 0.99;
        double pearPrice = 1.3;
        double peachPrice = 1.25;
        double dragonfruitPrice = 2.0;

        double waterPrice = 0.5;
        double lemonadePrice = 1;
        double spritePrice = 1.2;
        double cokePrice = 1.25;
        double milkPrice = 2;

        // Quantities
        int appleQty, bananaQty, pearQty, peachQty, dragonfruitQty;
        int waterQty, lemonadeQty, spriteQty, cokeQty, milkQty;

        System.out.println("Welcome to Yixin's Fruit Stand!");

        while (true) {
            // Reset all quantities
            appleQty = bananaQty = pearQty = peachQty = dragonfruitQty = 0;
            waterQty = lemonadeQty = spriteQty = cokeQty = milkQty = 0;

            System.out.print("\nEnter your name (or type 'exit' to quit): ");
            String name = scanner.nextLine().trim();
            if (name.equalsIgnoreCase("exit")) {
                break;
            }

            System.out.println("\nHi " + name + "! Here's our menu:");
            System.out.println("--- Fruits ---");
            System.out.println("apple - $1.00");
            System.out.println("banana - $0.99");
            System.out.println("pear - $1.30");
            System.out.println("peach - $1.25");
            System.out.println("dragonfruit - $2.00");

            System.out.println("--- Drinks ---");
            System.out.println("water - $1.00");
            System.out.println("lemonade - $0.99");
            System.out.println("sprite - $1.30");
            System.out.println("coke - $1.25");
            System.out.println("milk - $2.00");

            System.out.print("\nWould you like to buy fruits? (yes/no): ");
            String fruitAnswer = scanner.nextLine().trim().toLowerCase();
            if (fruitAnswer.equals("yes")) {
                while (true) {
                    System.out.print("Enter fruit name (or type 'done'): ");
                    String fruit = scanner.nextLine().trim().toLowerCase();

                    if (fruit.equals("done")) break;

                    System.out.print("Enter quantity: ");
                    int qty = Integer.parseInt(scanner.nextLine());

                    if (fruit.equals("apple")) {
                        appleQty += qty;
                    } else if (fruit.equals("banana")) {
                        bananaQty += qty;
                    } else if (fruit.equals("pear")) {
                        pearQty += qty;
                    } else if (fruit.equals("peach")) {
                        peachQty += qty;
                    } else if (fruit.equals("dragonfruit")) {
                        dragonfruitQty += qty;
                    } else {
                        System.out.println("Invalid fruit name.");
                    }
                }
            }

            System.out.print("\nWould you like to buy drinks? (yes/no): ");
            String drinkAnswer = scanner.nextLine().trim().toLowerCase();
            if (drinkAnswer.equals("yes")) {
                while (true) {
                    System.out.print("Enter drink name (or type 'done'): ");
                    String drink = scanner.nextLine().trim().toLowerCase();

                    if (drink.equals("done")) break;

                    System.out.print("Enter quantity: ");
                    int qty = Integer.parseInt(scanner.nextLine());

                    if (drink.equals("water")) {
                        waterQty += qty;
                    } else if (drink.equals("lemonade")) {
                        lemonadeQty += qty;
                    } else if (drink.equals("sprite")) {
                        spriteQty += qty;
                    } else if (drink.equals("coke")) {
                        cokeQty += qty;
                    } else if (drink.equals("milk")) {
                        milkQty += qty;
                    } else {
                        System.out.println("Invalid drink name.");
                    }
                }
            }

            // Print receipt
            System.out.println("\n--- Receipt ---");
            double total = 0;

            if (appleQty > 0) {
                double cost = appleQty * applePrice;
                System.out.println("apple x" + appleQty + " = $" + cost);
                total += cost;
            }
            if (bananaQty > 0) {
                double cost = bananaQty * bananaPrice;
                System.out.println("banana x" + bananaQty + " = $" + cost);
                total += cost;
            }
            if (pearQty > 0) {
                double cost = pearQty * pearPrice;
                System.out.println("pear x" + pearQty + " = $" + cost);
                total += cost;
            }
            if (peachQty > 0) {
                double cost = peachQty * peachPrice;
                System.out.println("peach x" + peachQty + " = $" + cost);
                total += cost;
            }
            if (dragonfruitQty > 0) {
                double cost = dragonfruitQty * dragonfruitPrice;
                System.out.println("dragonfruit x" + dragonfruitQty + " = $" + cost);
                total += cost;
            }

            if (waterQty > 0) {
                double cost = waterQty * waterPrice;
                System.out.println("water x" + waterQty + " = $" + cost);
                total += cost;
            }
            if (lemonadeQty > 0) {
                double cost = lemonadeQty * lemonadePrice;
                System.out.println("lemonade x" + lemonadeQty + " = $" + cost);
                total += cost;
            }
            if (spriteQty > 0) {
                double cost = spriteQty * spritePrice;
                System.out.println("sprite x" + spriteQty + " = $" + cost);
                total += cost;
            }
            if (cokeQty > 0) {
                double cost = cokeQty * cokePrice;
                System.out.println("coke x" + cokeQty + " = $" + cost);
                total += cost;
            }
            if (milkQty > 0) {
                double cost = milkQty * milkPrice;
                System.out.println("milk x" + milkQty + " = $" + cost);
                total += cost;
            }

            System.out.println("Total: $" + total);
            System.out.println("\nNext customer? (Type 'exit' to quit or press Enter to continue)");
            String again = scanner.nextLine().trim().toLowerCase();
            if (again.equals("exit")) break;
        }

        System.out.println("Thanks for shopping with us!");
        scanner.close();
        
    }
    
}

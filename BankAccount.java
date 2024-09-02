import java.util.Scanner;

// BankAccount
public class BankAccount {
    public static void main(String[] args) {
        Scanner list = new Scanner(System.in);

        // Variables
        String name = null;
        int accountType = 0;
        int password;
        double balance = 2547;
        int choice = 0;
        int maxAttempts = 3;
        boolean accessGranted = false;

        // Inputs
        System.out.println("Type your First name: ");
        name = list.nextLine();

        // 3 attempts
        for (int attempt = 1; attempt <= maxAttempts; attempt++) {
            System.out.println("Type your Password: (Try '123456')");
            password = list.nextInt();

            if (password == 123456) {
                accessGranted = true;
                break;
            } else if (attempt < maxAttempts) {
                System.out.println("Incorrect Password! You have " + (maxAttempts - attempt) + " more chances!");
            } else {
                System.out.println("Incorrect Password! You have reached the maximum number of attempts. Exiting...");
                return; // Exits the program
            }
        }

        if (accessGranted) {
            // Account Type
            System.out.println("\nWelcome Back, " + name + "!" + "\nAccount Type: \n[1] - Current Account");
            while (accountType != 1) {
                accountType = list.nextInt();
                if (accountType != 1) {
                    System.out.println("Invalid Option! Try again...");
                }
            }
            // Account information
            System.out.println("===========================================\nWelcome, " + name + "!");
            System.out.println("Name of Costumer: " + name);
            System.out.println("Current Balance: " + balance + "\n===========================================\n");
            // Menu Choices
            String menu = ("\nOperations:\n\n[1] - Check balance\n[2] - Transfer value\n[3] - Receive value\n[4] - Exit\n===========================================");
            System.out.println("What is the desired choice? ");
            // Loop While
            while (choice != 4) {
                System.out.println(menu);
                choice = list.nextInt();
                // If Choice 01
                if (choice == 1) {
                    System.out.println("The Current balance is " + balance);
                // Else if Choice 02
                } else if (choice == 2) {
                    System.out.println("What is the amount you want to transfer: ");
                    double value = list.nextDouble();
                    if (value > balance) {
                        System.out.println("Insufficient Value!\nYour balance is: " + balance);
                    } else {
                        balance -= value;
                        System.out.println("The amount was transferred successfully!\nYour current balance is now: " + balance);
                    }
                // Else if Choice 03
                } else if (choice == 3) {
                    System.out.println("Value received: ");
                    double value = list.nextDouble();
                    balance += value;
                    System.out.println("The value has add to your balance successfully!\nYour Current balance is now: " + balance);
                // Else if Choice 04
                } else if (choice >= 4) {
                    System.out.println("Invalid Option! Try Again...");
                }
            }
        }
    }
}

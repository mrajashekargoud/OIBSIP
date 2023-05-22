import java.util.ArrayList;
import java.util.Scanner;

public class ATM {
    private static Scanner sc = new Scanner(System.in);
    private static int balance = 5000;
    private static ArrayList<String> transactions = new ArrayList<String>();

    public static void main(String[] args) {
        System.out.println("Welcome to the ATM!");
        System.out.print("Enter your user id: ");
        String userId = sc.nextLine();

        System.out.print("Enter your user pin: ");
        String userPin = sc.nextLine();

        int tries = 0;

        while (!validateUser(userId, userPin)) {
            tries++;
            if (tries == 3) {
                System.out.println("Maximum number of attempts reached.");
                return;
            }
            System.out.println("Invalid user id or pin. Please try again.");
            System.out.print("Enter your user id: ");
            userId = sc.nextLine();

            System.out.print("Enter your user pin: ");
            userPin = sc.nextLine();
        }

        System.out.println("Welcome " + userId + "!");
        showMenu();
    }

    private static boolean validateUser(String userId, String userPin) {
        // Check if user id and pin match
        if (userId.equals("1234") && userPin.equals("5678")) {
            return true;
        } else {
            return false;
        }
    }

    private static void showMenu() {
        System.out.println("ATM Menu:");
        System.out.println("1. Transactions History");
        System.out.println("2. Withdraw");
        System.out.println("3. Deposit");
        System.out.println("4. Transfer");
        System.out.println("5. Quit");

        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                showTransactions();
                break;
            case 2:
                withdraw();
                break;
            case 3:
                deposit();
                break;
            case 4:
                transfer();
                break;
            case 5:
                System.out.println("Thank you for using the ATM!");
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }
    }

    private static void showTransactions() {
        System.out.println("Transaction History:");

        if (transactions.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            for (String transaction : transactions) {
                System.out.println(transaction);
            }
        }
        showMenu();
    }

    private static void withdraw() {
        System.out.print("Enter amount to withdraw: ");
        int amount = sc.nextInt();

        if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            balance -= amount;
            String transaction = "Withdrawal of " + amount + ". Balance: " + balance;
            transactions.add(transaction);
            System.out.println(transaction);
        }
        showMenu();
    }

    private static void deposit() {
        System.out.print("Enter amount to deposit: ");
        int amount = sc.nextInt();

        balance += amount;
        String transaction = "Deposit of " + amount + ". Balance: " + balance;
        transactions.add(transaction);
        System.out.println(transaction);

        showMenu();
    }

    private static void transfer() {
        System.out.print("Enter amount to transfer: ");
        int amount = sc.nextInt();

        if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            System.out.print("Enter recipient user id: ");
            String recipientId = sc.next();

            balance -= amount;
            String transaction = "Transfer of " + amount + " to " + recipientId + ". Balance: " + balance;
            transactions.add(transaction);
            System.out.println(transaction);
        }
        showMenu();
    }
}

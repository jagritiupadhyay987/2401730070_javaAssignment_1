import java.util.Scanner;

// UserInterface class handles interaction with the user
public class UserInterface {
    // Array to store multiple accounts (up to 100 accounts)
    private static Account[] accounts = new Account[100];
    private static int accountCount = 0; // Keeps track of created accounts
    private static Scanner sc = new Scanner(System.in);

    // Helper method to find account by account number
    private static Account findAccount(int accNo) {
        for (int i = 0; i < accountCount; i++) {
            if (accounts[i].getAccountNumber() == accNo) {
                return accounts[i]; // Return account if found
            }
        }
        return null; // Return null if not found
    }

    // Create a new account
    public static void createAccount() {
        System.out.print("Enter account holder name: ");
        String name = sc.nextLine(); // Read account holder's name

        System.out.print("Enter initial deposit amount: ");
        double initialDeposit = sc.nextDouble();
        sc.nextLine(); // Consume newline character

        System.out.print("Enter email address: ");
        String email = sc.nextLine();

        System.out.print("Enter phone number: ");
        String phone = sc.nextLine();

        // Generate unique account number (1001, 1002, ...)
        int accNo = 1001 + accountCount;

        // Create new Account object and store it in the array
        accounts[accountCount] = new Account(accNo, name, initialDeposit, email, phone);
        accountCount++;

        System.out.println("Account created successfully with Account Number: " + accNo);
    }

    // Perform deposit operation
    public static void performDeposit() {
        System.out.print("Enter account number: ");
        int accNo = sc.nextInt();
        System.out.print("Enter deposit amount: ");
        double amount = sc.nextDouble();
        sc.nextLine(); // Consume newline

        // Find account by account number
        Account acc = findAccount(accNo);
        if (acc != null) {
            acc.deposit(amount); // Call deposit method
        } else {
            System.out.println("Account not found!");
        }
    }

    // Perform withdrawal operation
    public static void performWithdrawal() {
        System.out.print("Enter account number: ");
        int accNo = sc.nextInt();
        System.out.print("Enter withdrawal amount: ");
        double amount = sc.nextDouble();
        sc.nextLine();

        Account acc = findAccount(accNo);
        if (acc != null) {
            acc.withdraw(amount); // Call withdraw method
        } else {
            System.out.println("Account not found!");
        }
    }

    // Show account details
    public static void showAccountDetails() {
        System.out.print("Enter account number: ");
        int accNo = sc.nextInt();
        sc.nextLine();

        Account acc = findAccount(accNo);
        if (acc != null) {
            acc.displayAccountDetails(); // Display account details
        } else {
            System.out.println("Account not found!");
        }
    }

    // Update contact details of an account
    public static void updateContact() {
        System.out.print("Enter account number: ");
        int accNo = sc.nextInt();
        sc.nextLine();

        Account acc = findAccount(accNo);
        if (acc != null) {
            System.out.print("Enter new email: ");
            String newEmail = sc.nextLine();

            System.out.print("Enter new phone number: ");
            String newPhone = sc.nextLine();

            acc.updateContactDetails(newEmail, newPhone);
        } else {
            System.out.println("Account not found!");
        }
    }

    // Main menu method
    public static void mainMenu() {
        while (true) {
            // Display menu options
            System.out.println("\n--- Welcome to the Banking Application ---");
            System.out.println("1. Create a new account");
            System.out.println("2. Deposit money");
            System.out.println("3. Withdraw money");
            System.out.println("4. View account details");
            System.out.println("5. Update contact details");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            // Switch-case to handle user choice
            switch (choice) {
                case 1: createAccount(); break;
                case 2: performDeposit(); break;
                case 3: performWithdrawal(); break;
                case 4: showAccountDetails(); break;
                case 5: updateContact(); break;
                case 6:
                    System.out.println("Thank you for using our Banking App!");
                    return; // Exit program
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }

    // Main method (entry point of program)
    public static void main(String[] args) {
        mainMenu();
    }
}

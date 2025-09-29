import java.util.ArrayList;
import java.util.Scanner;

class Account 
	{
	private int accountId;
    	private String accountHolder;
    	private double balance;
    	private ArrayList<String> transactionHistory = new ArrayList<>();

	public Account(int accountId, String accountHolder, double initialBalance) {	    // Constructor
        this.accountId = accountId;
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
        transactionHistory.add("Account created with initial balance: " + initialBalance);
    	}

    	public void deposit(double amount) 							    // Deposit method
	{
        if (amount <= 0) {
        System.out.println("⚠ Deposit amount must be positive!");
	return;
        }
        balance += amount;
        transactionHistory.add("Deposited: " + amount + " | Balance: " + balance);
        System.out.println("Successfully deposited " + amount);
    	}

    public void withdraw(double amount) 						// Withdraw method
	{
        if (amount <= 0) 
	{
         System.out.println("Withdrawal amount must be positive!");
         return;
        }
        if (amount > balance) 
	{
        	System.out.println("⚠ Insufficient balance!");
            	return;
        }
        balance -= amount;
        transactionHistory.add("Withdrawn: " + amount + " | Balance: " + balance);
        System.out.println("Successfully withdrawn " + amount);
	}

    	public void viewBalance() 						// View balance
	{
        System.out.println("Current Balance: " + balance);
    	}

    	public void viewTransactionHistory() {			// View transaction history
        System.out.println("\n--- Transaction History ---");
        for (String record : transactionHistory) {
        System.out.println(record);
        }
    	}

    	public int getAccountId() 
	{
	 return accountId; 
	}
	public String getAccountHolder() 	
	{
	 return accountHolder; 
	}
}

class Day6
{
	private static Scanner sc = new Scanner(System.in);

    	public static void main(String[] args) 
	{
        System.out.print("Enter Account ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // consume newline
        System.out.print("Enter Account Holder Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Initial Balance: ");
        double balance = sc.nextDouble();

        Account account = new Account(id, name, balance);

        boolean running = true;

        while (running) 
	{
            System.out.println("\n=== Bank Account Simulation ===");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. View Balance");
            System.out.println("4. View Transaction History");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();

            switch (choice) 
	{
                case 1 -> 
		{
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = sc.nextDouble();
                    account.deposit(depositAmount);
                }
                case 2 -> 	
		{
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = sc.nextDouble();
                    account.withdraw(withdrawAmount);
                }
                case 3 -> account.viewBalance();
                case 4 -> account.viewTransactionHistory();
                case 5 -> 
		{
                    running = false;
                    System.out.println("👋 Exiting... Goodbye!");
                }
                default -> System.out.println("⚠ Invalid choice. Try again.");
        }
        }
    	}
}

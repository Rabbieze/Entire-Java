import java.util.Scanner;

public class AtmSimDoLoop {
    private double balance;

    public AtmSimDoLoop(double balance) {
        this.balance = balance;
    }

    public String getBalance() {
        return "your current balance is $ " + String.format("%2f", balance);
    }

    public void deposit(double amount) {
        this.balance = this.balance + amount;
    }

    public void withdraw(double amount) {
        this.balance = this.balance - amount;
    }

    public static void main(String[] args) {
        AtmSimDoLoop atmSimDoLoop = new AtmSimDoLoop(100.00);
        Scanner userInput = new Scanner(System.in);
        int option = 0;
        do {
            printMenu();
            option = userInput.nextInt();
            if (option == 1) {
                System.out.println(atmSimDoLoop.getBalance() + "\n");
            } else if (option == 2) {
                System.out.print("\nEnter the amount of the deposit: $");
                double ammount = userInput.nextDouble();
                atmSimDoLoop.deposit(ammount);
                System.out.println(atmSimDoLoop.getBalance() + "\n");
            } else if (option == 3) {
                System.out.print("\nEnter the amount of the withdrawal: $");
                double ammount = userInput.nextDouble();
                if (ammount > atmSimDoLoop.balance) {
                    System.out.println("Insufficient funds. " + atmSimDoLoop.getBalance() + "\n");
                } else {
                    atmSimDoLoop.withdraw(ammount);
                    System.out.println(atmSimDoLoop.getBalance() + "\n");
                }
            } else if (option == 4) {
                System.out.println("\nGood-bye");
                break;
            } else {
                System.out.println("\nSelect correct transaction type!\n");
            }
        }
        while (option !=4);
        userInput.close();
    }
    public static void printMenu() {
        System.out.println("Menu");
        System.out.println("1. Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdrawal");
        System.out.println("4. Quit");
        System.out.print("Chose Transaction Type: ");
    }
}

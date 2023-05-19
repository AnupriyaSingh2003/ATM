import java.util.Scanner;

public class ATM {
    private double balance;
    private int pin;

    public ATM(double balance, int pin) {
        this.balance = balance;
        this.pin = pin;
    }

    public void withdraw(double amount) {
        if(amount > balance) {
            System.out.println("Insufficient funds.");
        } else {
            balance -= amount;
            System.out.println("Successfully withdrew $" + amount + ". Current balance is $" + balance + ".");
        }
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Successfully deposited $" + amount + ". Current balance is $" + balance + ".");
    }

    public void changePin(int newPin) {
        pin = newPin;
        System.out.println("Successfully changed PIN to " + pin + ".");
    }

    public void displayBalance() {
        System.out.println("Current balance is $" + balance + ".");
    }

    public boolean validatePin(int pin) {
        return this.pin == pin;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ATM atm = new ATM(1000, 1234); // initial balance and PIN

        System.out.print("Enter your PIN: ");
        int pin = scanner.nextInt();

        if(atm.validatePin(pin)) {
            while(true) {
                System.out.println("1. Withdraw");
                System.out.println("2. Deposit");
                System.out.println("3. Change PIN");
                System.out.println("4. Check balance");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");

                int choice = scanner.nextInt();

                switch(choice) {
                    case 1:
                        System.out.print("Enter amount to withdraw: ");
                        double withdrawAmount = scanner.nextDouble();
                        atm.withdraw(withdrawAmount);
                        break;
                    case 2:
                        System.out.print("Enter amount to deposit: ");
                        double depositAmount = scanner.nextDouble();
                        atm.deposit(depositAmount);
                        break;
                    case 3:
                        System.out.print("Enter new PIN: ");
                        int newPin = scanner.nextInt();
                        atm.changePin(newPin);
                        break;
                    case 4:
                        atm.displayBalance();
                        break;
                    case 5:
                        System.out.println("Thank you for using our ATM!");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } else {
            System.out.println("Invalid PIN. Access denied.");
        }
    }
}


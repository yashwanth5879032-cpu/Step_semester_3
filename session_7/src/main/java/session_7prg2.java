class MessWallet {
    private double balance;

    MessWallet(double balance) {
        this.balance = balance;
    }

    void topUp(double amount) {
        balance += amount;
    }

    void deduct(double amount) {
        if (amount > balance)
            System.out.println("Deduct rejected: insufficient balance");
        else
            balance -= amount;
    }

    double getBalance() {
        return balance;
    }
}

public class session_7prg2 {
    public static void main(String[] args) {
        MessWallet m = new MessWallet(500);

        m.topUp(200);
        System.out.println("Balance after top-up: " + m.getBalance());

        m.deduct(1000);

        System.out.println("Final balance: " + m.getBalance());
    }
}
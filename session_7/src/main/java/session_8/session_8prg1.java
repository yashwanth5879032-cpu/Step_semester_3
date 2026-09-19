class PiggyBank {
    private int savings;
    private final String bankId;

    PiggyBank(String bankId) {
        this.bankId = bankId;
        savings = 0;
    }

    public void deposit(int amount) {
        savings += amount;
    }

    public void withdraw(int amount) {
        if (amount <= savings) {
            savings -= amount;
        } else {
            System.out.println("Withdrawal Rejected");
        }
    }

    public int getSavings() {
        return savings;
    }

    public String getBankId() {
        return bankId;
    }
}

public class session_8prg1 {
    public static void main(String[] args) {
        PiggyBank pb = new PiggyBank("PB-1");

        pb.deposit(100);
        System.out.println(pb.getSavings());

        pb.withdraw(30);
        System.out.println(pb.getSavings());

        pb.withdraw(500);
        System.out.println(pb.getSavings());
    }
}
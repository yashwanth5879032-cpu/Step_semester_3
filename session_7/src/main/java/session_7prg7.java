class PayrollAccount {
    private double basicSalary;
    private double bonus;

    PayrollAccount(double basicSalary) {
        this.basicSalary = basicSalary;
        bonus = 0;
    }

    void creditBonus(double amount) {
        if (amount > 0) {
            bonus += amount;
            System.out.println("Bonus credited: Rs " + amount);
        }
    }

    void deductTax(double percent) {
        basicSalary = basicSalary - (basicSalary * percent / 100);
        System.out.println("Tax deducted: " + percent + "%");
    }

    double getNetSalary() {
        return basicSalary + bonus;
    }
}

public class session_7prg7 {
    public static void main(String[] args) {

        PayrollAccount p = new PayrollAccount(50000);

        p.creditBonus(5000);
        p.deductTax(10);

        System.out.println("Net salary: Rs " + p.getNetSalary());
    }
}
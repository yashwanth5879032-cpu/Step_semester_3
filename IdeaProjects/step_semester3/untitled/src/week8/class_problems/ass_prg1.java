
import java.util.*;

abstract class Customer {
    double amount;

    Customer(double amount) {
        this.amount = amount;
    }

    abstract double calculate();

    String getType() {
        return getClass().getSimpleName().toUpperCase();
    }
}

class STUDENT extends Customer {
    STUDENT(double amount) {
        super(amount);
    }

    double calculate() {
        return amount * 0.90;
    }
}

class STAFF extends Customer {
    STAFF(double amount) {
        super(amount);
    }

    double calculate() {
        return amount * 0.95;
    }
}

class GUEST extends Customer {
    GUEST(double amount) {
        super(amount);
    }

    double calculate() {
        return amount + 10;
    }
}

public class ass_prg1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();

            Customer c = switch (type) {
                case "STUDENT" -> new STUDENT(amount);
                case "STAFF" -> new STAFF(amount);
                default -> new GUEST(amount);
            };

            double bill = c.calculate();
            System.out.printf("%s: %.2f%n",
                    c.getType(), bill);
            total += bill;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}

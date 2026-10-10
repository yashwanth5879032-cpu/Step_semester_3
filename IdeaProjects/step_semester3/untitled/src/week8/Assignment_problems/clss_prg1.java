
import java.util.*;

abstract class Payment {
    double amount;

    Payment(double amount) {
        this.amount = amount;
    }

    abstract double calculate();

    String type() {
        return getClass().getSimpleName().toUpperCase();
    }
}

class CARD extends Payment {
    CARD(double a) { super(a); }

    double calculate() {
        return amount * 1.02;
    }
}

class WALLET extends Payment {
    WALLET(double a) { super(a); }

    double calculate() {
        return amount * 1.01;
    }
}

class BANKTRANSFER extends Payment {
    BANKTRANSFER(double a) { super(a); }

    double calculate() {
        return amount;
    }
}

public class clss_prg1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();
            Payment p;

            switch (type) {
                case "CARD":
                    p = new CARD(amount);
                    break;
                case "WALLET":
                    p = new WALLET(amount);
                    break;
                default:
                    p = new BANKTRANSFER(amount);
            }

            double result = p.calculate();
            System.out.printf("%s: %.2f%n", p.type(), result);
            total += result;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}

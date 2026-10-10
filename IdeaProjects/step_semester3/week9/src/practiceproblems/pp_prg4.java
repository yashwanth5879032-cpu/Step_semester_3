
import java.util.*;

abstract class Connection {
    int units;

    Connection(int units) {
        this.units = units;
    }

    abstract double calculateBill();

    String type() {
        return getClass().getSimpleName();
    }
}

class HOME extends Connection {
    HOME(int u) { super(u); }

    double calculateBill() {
        if (units <= 100)
            return units * 5.0;
        return 100 * 5.0 + (units - 100) * 7.0;
    }
}

class SHOP extends Connection {
    SHOP(int u) { super(u); }

    double calculateBill() {
        return units * 8.0 + 100;
    }
}

class FACTORY extends Connection {
    FACTORY(int u) { super(u); }

    double calculateBill() {
        return Math.max(units * 6.0, 1000.0);
    }
}

public class pp_prg4{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int units = sc.nextInt();
            Connection c;

            switch (type) {
                case "HOME":
                    c = new HOME(units);
                    break;
                case "SHOP":
                    c = new SHOP(units);
                    break;
                default:
                    c = new FACTORY(units);
            }

            double bill = c.calculateBill();
            System.out.printf("%s: %.2f%n", c.type(), bill);
            total += bill;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}

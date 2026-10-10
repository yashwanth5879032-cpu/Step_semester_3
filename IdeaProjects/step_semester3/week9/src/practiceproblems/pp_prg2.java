
import java.util.*;

abstract class Staff {
    String name;

    Staff(String name) {
        this.name = name;
    }

    abstract double calculatePay();
}

class FULLTIME extends Staff {
    double salary;

    FULLTIME(String n, double s) {
        super(n);
        salary = s;
    }

    double calculatePay() {
        return salary;
    }
}

class HOURLY extends Staff {
    double hours, rate;

    HOURLY(String n, double h, double r) {
        super(n);
        hours = h;
        rate = r;
    }

    double calculatePay() {
        if (hours <= 40)
            return hours * rate;
        return 40 * rate + (hours - 40) * rate * 1.5;
    }
}

class INTERN extends Staff {
    double stipend;

    INTERN(String n, double s) {
        super(n);
        stipend = s;
    }

    double calculatePay() {
        return stipend;
    }
}

public class pp_prg2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            Staff s;

            switch (type) {
                case "FULLTIME":
                    s = new FULLTIME(name, sc.nextDouble());
                    break;
                case "HOURLY":
                    s = new HOURLY(name,
                            sc.nextDouble(), sc.nextDouble());
                    break;
                default:
                    s = new INTERN(name, sc.nextDouble());
            }

            double pay = s.calculatePay();
            System.out.printf("%s: %.2f%n", s.name, pay);
            total += pay;
        }

        System.out.printf("Total Payroll: %.2f%n", total);
        sc.close();
    }
}

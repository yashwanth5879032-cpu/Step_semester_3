
import java.util.*;

abstract class Delivery {
    double weight, distance;

    Delivery(double w, double d) {
        weight = w;
        distance = d;
    }

    abstract double calculate();

    String type() {
        return getClass().getSimpleName().toUpperCase();
    }
}

class STANDARD extends Delivery {
    STANDARD(double w, double d) {
        super(w, d);
    }

    double calculate() {
        return 5 + 0.50 * weight + 0.10 * distance;
    }
}

class EXPRESS extends Delivery {
    EXPRESS(double w, double d) {
        super(w, d);
    }

    double calculate() {
        return 15 + weight + 0.20 * distance;
    }
}

class INTERNATIONAL extends Delivery {
    double customs;

    INTERNATIONAL(double w, double d, double c) {
        super(w, d);
        customs = c;
    }

    double calculate() {
        return 25 + 2 * weight + 0.50 * distance + customs;
    }
}

public class clss_prg3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double weight = sc.nextDouble();
            double distance = sc.nextDouble();
            Delivery d;

            switch (type) {
                case "STANDARD":
                    d = new STANDARD(weight, distance);
                    break;
                case "EXPRESS":
                    d = new EXPRESS(weight, distance);
                    break;
                default:
                    double customs = sc.nextDouble();
                    d = new INTERNATIONAL(weight, distance, customs);
            }

            double fee = d.calculate();
            System.out.printf("%s: %.2f%n", d.type(), fee);
            total += fee;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}

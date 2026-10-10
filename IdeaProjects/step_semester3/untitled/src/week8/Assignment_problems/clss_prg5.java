
import java.util.*;

abstract class Transport {
    double distance;

    Transport(double distance) {
        this.distance = distance;
    }

    abstract double calculate();

    String type() {
        return getClass().getSimpleName().toUpperCase();
    }
}

class BUS extends Transport {
    BUS(double d) {
        super(d);
    }

    double calculate() {
        return Math.min(2 + 0.10 * distance, 10);
    }
}

class TRAIN extends Transport {
    TRAIN(double d) {
        super(d);
    }

    double calculate() {
        return 3 + 0.15 * distance;
    }
}

class METRO extends Transport {
    double peakFactor;

    METRO(double d, double factor) {
        super(d);
        peakFactor = factor;
    }

    double calculate() {
        return (1.50 + 0.20 * distance) * peakFactor;
    }
}

public class clss_prg5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double distance = sc.nextDouble();
            Transport t;

            switch (type) {
                case "BUS":
                    t = new BUS(distance);
                    break;
                case "TRAIN":
                    t = new TRAIN(distance);
                    break;
                default:
                    double factor = sc.nextDouble();
                    t = new METRO(distance, factor);
            }

            double fare = t.calculate();
            System.out.printf("%s: %.2f%n", t.type(), fare);
            total += fare;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}

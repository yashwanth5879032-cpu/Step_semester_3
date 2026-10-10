
import java.util.*;

abstract class Vehicle {
    int hours;

    Vehicle(int hours) {
        this.hours = hours;
    }

    abstract double calculate();

    String getType() {
        return getClass().getSimpleName().toUpperCase();
    }
}

class BIKE extends Vehicle {
    BIKE(int hours) {
        super(hours);
    }

    double calculate() {
        return hours * 10.0;
    }
}

class CAR extends Vehicle {
    CAR(int hours) {
        super(hours);
    }

    double calculate() {
        return 30 + (hours - 1) * 20.0;
    }
}

class TRUCK extends Vehicle {
    TRUCK(int hours) {
        super(hours);
    }

    double calculate() {
        return Math.max(100, hours * 50.0);
    }
}

public class ass_prg2{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int hours = sc.nextInt();

            Vehicle v = switch (type) {
                case "BIKE" -> new BIKE(hours);
                case "CAR" -> new CAR(hours);
                default -> new TRUCK(hours);
            };

            double charge = v.calculate();
            System.out.printf("%s: %.2f%n",
                    v.getType(), charge);
            total += charge;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}

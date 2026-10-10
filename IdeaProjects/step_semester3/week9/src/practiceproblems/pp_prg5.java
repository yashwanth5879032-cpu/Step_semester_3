
import java.util.*;

abstract class Booking {
    double distance;
    static final double BOOKING_FEE = 50.0;

    Booking(double distance) {
        this.distance = distance;
    }

    abstract double baseFare();

    double totalFare() {
        return baseFare() + BOOKING_FEE;
    }

    String mode() {
        return getClass().getSimpleName();
    }
}

class BUS extends Booking {
    BUS(double d) { super(d); }

    double baseFare() {
        return distance * 2.0;
    }
}

class TRAIN extends Booking {
    TRAIN(double d) { super(d); }

    double baseFare() {
        return distance * 1.5;
    }
}

class FLIGHT extends Booking {
    FLIGHT(double d) { super(d); }

    double baseFare() {
        return 2500 + distance * 4.0;
    }
}

public class pp_prg5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double distance = sc.nextDouble();
            Booking b;

            switch (type) {
                case "BUS":
                    b = new BUS(distance);
                    break;
                case "TRAIN":
                    b = new TRAIN(distance);
                    break;
                default:
                    b = new FLIGHT(distance);
            }

            System.out.printf("%s: %.2f%n",
                    b.mode(), b.totalFare());
        }

        sc.close();
    }
}

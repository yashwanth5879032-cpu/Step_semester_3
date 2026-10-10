
import java.util.*;

abstract class Room {
    int units;

    Room(int units) {
        this.units = units;
    }

    abstract double calculate();

    String getType() {
        return getClass().getSimpleName().toUpperCase();
    }
}

class SINGLE extends Room {
    SINGLE(int units) {
        super(units);
    }

    double calculate() {
        return units * 8.0;
    }
}

class SHARED extends Room {
    int occupants;

    SHARED(int units, int occupants) {
        super(units);
        this.occupants = occupants;
    }

    double calculate() {
        return (units * 6.0) / occupants;
    }
}

class AC extends Room {
    AC(int units) {
        super(units);
    }

    double calculate() {
        return units * 10.0 + 200;
    }
}

public class ass_prg3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int units = sc.nextInt();
            Room r;

            switch (type) {
                case "SINGLE":
                    r = new SINGLE(units);
                    break;
                case "SHARED":
                    int occupants = sc.nextInt();
                    r = new SHARED(units, occupants);
                    break;
                default:
                    r = new AC(units);
            }

            double bill = r.calculate();
            System.out.printf("%s: %.2f%n",
                    r.getType(), bill);
            total += bill;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}


import java.util.Scanner;

abstract class Appliance {
    double hours;

    Appliance(double hours) {
        this.hours = hours;
    }

    abstract double getPower();

    double getUnits(boolean saver) {
        double units = getPower() * hours / 1000.0;

        if (saver) {
            units *= 0.75;
        }

        return units;
    }

    double getCost(double units) {
        return units * 8.0;
    }
}

interface SaverMode {
    boolean supportsSaver();
}

class Fridge extends Appliance {
    Fridge(double h) {
        super(h);
    }

    double getPower() {
        return 150.0;
    }
}

class AC extends Appliance implements SaverMode {
    AC(double h) {
        super(h);
    }

    double getPower() {
        return 1500.0;
    }

    public boolean supportsSaver() {
        return true;
    }
}

class TV extends Appliance {
    TV(double h) {
        super(h);
    }

    double getPower() {
        return 100.0;
    }
}

class Washer extends Appliance implements SaverMode {
    Washer(double h) {
        super(h);
    }

    double getPower() {
        return 500.0;
    }

    public boolean supportsSaver() {
        return true;
    }
}

public class ass_prg5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double totalCost = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double hours = sc.nextDouble();

            boolean saver = false;

            if (sc.hasNext("SAVER")) {
                sc.next();
                saver = true;
            }

            Appliance a;

            switch (type) {
                case "FRIDGE":
                    a = new Fridge(hours);
                    break;
                case "AC":
                    a = new AC(hours);
                    break;
                case "TV":
                    a = new TV(hours);
                    break;
                case "WASHER":
                    a = new Washer(hours);
                    break;
                default:
                    throw new IllegalArgumentException(
                            "Invalid appliance type"
                    );
            }

            if (saver && !(a instanceof SaverMode)) {
                System.out.println(
                        type + ": saver mode not supported"
                );
                continue;
            }

            double units = a.getUnits(saver);
            double cost = a.getCost(units);

            System.out.printf(
                    "%s: Units=%.2f Cost=%.2f%n",
                    type, units, cost
            );

            totalCost += cost;
        }

        System.out.printf("Total Cost: %.2f%n", totalCost);
        sc.close();
    }
}

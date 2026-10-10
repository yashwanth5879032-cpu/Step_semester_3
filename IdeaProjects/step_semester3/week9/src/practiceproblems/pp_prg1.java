
import java.util.*;

abstract class Plot {
    String owner;

    Plot(String owner) {
        this.owner = owner;
    }

    abstract double area();

    String shape() {
        return getClass().getSimpleName().toUpperCase();
    }
}

class CIRCLE extends Plot {
    double radius;

    CIRCLE(String owner, double r) {
        super(owner);
        radius = r;
    }

    double area() {
        return Math.PI * radius * radius;
    }
}

class RECTANGLE extends Plot {
    double length, width;

    RECTANGLE(String owner, double l, double w) {
        super(owner);
        length = l;
        width = w;
    }

    double area() {
        return length * width;
    }
}

class TRIANGLE extends Plot {
    double base, height;

    TRIANGLE(String owner, double b, double h) {
        super(owner);
        base = b;
        height = h;
    }

    double area() {
        return 0.5 * base * height;
    }
}

public class pp_prg1{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String owner = sc.next();
            Plot p;

            switch (type) {
                case "CIRCLE":
                    p = new CIRCLE(owner, sc.nextDouble());
                    break;
                case "RECTANGLE":
                    p = new RECTANGLE(owner,
                            sc.nextDouble(), sc.nextDouble());
                    break;
                default:
                    p = new TRIANGLE(owner,
                            sc.nextDouble(), sc.nextDouble());
            }

            double a = p.area();
            System.out.printf("%s (%s): %.2f%n",
                    p.owner, p.shape(), a);
            total += a;
        }

        System.out.printf("Total Area: %.2f%n", total);
        sc.close();
    }
}

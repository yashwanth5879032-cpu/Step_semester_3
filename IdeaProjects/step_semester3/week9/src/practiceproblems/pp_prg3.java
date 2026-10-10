
import java.util.*;

abstract class LibraryItem {
    String title;
    int daysLate;

    LibraryItem(String title, int daysLate) {
        this.title = title;
        this.daysLate = daysLate;
    }

    abstract double calculateFine();
}

class BOOK extends LibraryItem {
    BOOK(String t, int d) { super(t, d); }

    double calculateFine() {
        return daysLate * 2.0;
    }
}

class DVD extends LibraryItem {
    DVD(String t, int d) { super(t, d); }

    double calculateFine() {
        return Math.min(daysLate * 5.0, 50.0);
    }
}

class MAGAZINE extends LibraryItem {
    MAGAZINE(String t, int d) { super(t, d); }

    double calculateFine() {
        return daysLate * 1.0;
    }
}

public class pp_prg3{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String title = sc.next();
            int days = sc.nextInt();
            LibraryItem item;

            switch (type) {
                case "BOOK":
                    item = new BOOK(title, days);
                    break;
                case "DVD":
                    item = new DVD(title, days);
                    break;
                default:
                    item = new MAGAZINE(title, days);
            }

            double fine = item.calculateFine();
            System.out.printf("%s: %.2f%n", item.title, fine);
            total += fine;
        }

        System.out.printf("Total Fines: %.2f%n", total);
        sc.close();
    }
}

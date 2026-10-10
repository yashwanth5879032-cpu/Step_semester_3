
import java.util.*;
import java.time.LocalDate;

abstract class LibraryItem {
    String title;
    LocalDate currentDate = LocalDate.of(2023, 10, 26);

    LibraryItem(String title) {
        this.title = title;
    }

    abstract int borrowingDays();

    LocalDate dueDate() {
        return currentDate.plusDays(borrowingDays());
    }
}

class BOOK extends LibraryItem {
    BOOK(String title) { super(title); }

    int borrowingDays() { return 14; }
}

class DVD extends LibraryItem {
    DVD(String title) { super(title); }

    int borrowingDays() { return 7; }
}

class MAGAZINE extends LibraryItem {
    MAGAZINE(String title) { super(title); }

    int borrowingDays() { return 3; }
}

public class clss_prg2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            String type = line.substring(0, line.indexOf(' '));
            String title = line.substring(line.indexOf(' ') + 1)
                    .replace("\"", "");

            LibraryItem item;

            switch (type) {
                case "BOOK":
                    item = new BOOK(title);
                    break;
                case "DVD":
                    item = new DVD(title);
                    break;
                default:
                    item = new MAGAZINE(title);
            }

            System.out.println(item.title + ": " + item.dueDate());
        }

        sc.close();
    }
}

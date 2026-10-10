
import java.util.*;
import java.time.LocalDate;

abstract class Plan {
    String name;
    LocalDate startDate;

    Plan(String name, String date) {
        this.name = name;
        this.startDate = LocalDate.parse(date);
    }

    abstract int validity();

    LocalDate renewalDate() {
        return startDate.plusDays(validity());
    }
}

class BASIC extends Plan {
    BASIC(String name, String date) {
        super(name, date);
    }

    int validity() {
        return 30;
    }
}

class STANDARD extends Plan {
    STANDARD(String name, String date) {
        super(name, date);
    }

    int validity() {
        return 90;
    }
}

class PREMIUM extends Plan {
    PREMIUM(String name, String date) {
        super(name, date);
    }

    int validity() {
        return 365;
    }
}

public class ass_prg5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            String date = sc.next();

            Plan p = switch (type) {
                case "BASIC" -> new BASIC(name, date);
                case "STANDARD" -> new STANDARD(name, date);
                default -> new PREMIUM(name, date);
            };

            System.out.println(
                    p.name + ": " + p.renewalDate()
            );
        }

        sc.close();
    }
}


import java.util.*;

abstract class Employee {
    String name;
    double salary;

    Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    abstract double calculateBonus();
}

class FULLTIME extends Employee {
    FULLTIME(String name, double salary) {
        super(name, salary);
    }

    double calculateBonus() {
        return salary * 0.10;
    }
}

class PARTTIME extends Employee {
    PARTTIME(String name, double salary) {
        super(name, salary);
    }

    double calculateBonus() {
        return salary * 0.05;
    }
}

class INTERN extends Employee {
    INTERN(String name, double salary) {
        super(name, salary);
    }

    double calculateBonus() {
        return 2000;
    }
}

public class ass_prg4{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            double salary = sc.nextDouble();

            Employee e = switch (type) {
                case "FULLTIME" ->
                        new FULLTIME(name, salary);
                case "PARTTIME" ->
                        new PARTTIME(name, salary);
                default -> new INTERN(name, salary);
            };

            double bonus = e.calculateBonus();
            System.out.printf("%s: %.2f%n",
                    e.name, bonus);
            total += bonus;
        }

        System.out.printf("Total Bonus: %.2f%n", total);
        sc.close();
    }
}

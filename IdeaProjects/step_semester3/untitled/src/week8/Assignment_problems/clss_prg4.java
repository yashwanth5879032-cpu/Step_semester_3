
import java.util.*;
import java.util.regex.*;

abstract class Question {
    String text, correct, answer;
    double points;

    Question(String t, String c, String a, double p) {
        text = t;
        correct = c;
        answer = a;
        points = p;
    }

    abstract double grade();
}

class MCQ extends Question {
    MCQ(String t, String c, String a, double p) {
        super(t, c, a, p);
    }

    double grade() {
        return answer.equals(correct) ? points : 0;
    }
}

class TF extends Question {
    TF(String t, String c, String a, double p) {
        super(t, c, a, p);
    }

    double grade() {
        return answer.equals(correct) ? points : 0;
    }
}

class ESSAY extends Question {
    ESSAY(String t, String c, String a, double p) {
        super(t, c, a, p);
    }

    double grade() {
        String[] keywords = correct.split(",");
        int count = 0;

        for (String keyword : keywords) {
            if (answer.toLowerCase().contains(
                    keyword.trim().toLowerCase())) {
                count++;
            }
        }

        if (count >= 2) return points * 0.75;
        if (count == 1) return points * 0.50;
        return 0;
    }
}

public class clss_prg4{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;

        Pattern pattern = Pattern.compile("\"([^\"]*)\"");

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String type = line.substring(0, line.indexOf(' '));
            Matcher m = pattern.matcher(line);
            List<String> fields = new ArrayList<>();

            while (m.find()) {
                fields.add(m.group(1));
            }

            double points = Double.parseDouble(
                    line.substring(line.lastIndexOf('"') + 1).trim()
            );

            Question q;
            if (type.equals("MCQ")) {
                q = new MCQ(fields.get(0), fields.get(1),
                        fields.get(2), points);
            } else if (type.equals("TF")) {
                q = new TF(fields.get(0), fields.get(1),
                        fields.get(2), points);
            } else {
                q = new ESSAY(fields.get(0), fields.get(1),
                        fields.get(2), points);
            }

            double score = q.grade();
            System.out.printf("%s: %.2f%n", type, score);
            total += score;
        }

        System.out.printf("Total Score: %.2f%n", total);
        sc.close();
    }
}

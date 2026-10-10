
import java.util.Scanner;

public class pp_prg2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.next();

        String reversed = new StringBuilder(word).reverse().toString();

        System.out.println(reversed);

        if (word.equalsIgnoreCase(reversed)) {
            System.out.println("palindrome");
        } else {
            System.out.println("not a palindrome");
        }

        sc.close();
    }
}

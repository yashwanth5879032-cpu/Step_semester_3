class PasswordChecker {
    private final String password;

    public PasswordChecker(String password) {
        this.password = password;
    }

    public String getStrength() {
        int len = password.length();

        if (len < 6) {
            return "Weak";
        } else if (len < 10) {
            return "Medium";
        } else {
            return "Strong";
        }
    }
}

public class session_8prg8 {
    public static void main(String[] args) {
        PasswordChecker p1 = new PasswordChecker("abcd");
        System.out.println(p1.getStrength());

        PasswordChecker p2 = new PasswordChecker("abcdefghij");
        System.out.println(p2.getStrength());
    }
}
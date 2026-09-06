public class session_2prg2 {

    static String reverseEachWord(String sentence) {

        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {

            StringBuilder temp = new StringBuilder(words[i]);
            result.append(temp.reverse());

            if (i < words.length - 1) {
                result.append(" ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {

        String input = "hello club";

        System.out.println(reverseEachWord(input));
    }
}
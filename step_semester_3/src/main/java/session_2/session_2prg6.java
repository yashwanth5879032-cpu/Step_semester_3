public class session_2prg6 {

    static void validateFileExtension(String filename) {

        int dotIndex = filename.lastIndexOf('.');

        if (dotIndex == -1) {
            System.out.println("Rejected — invalid file type");
            return;
        }

        String extension =
                filename.substring(dotIndex + 1);

        if (extension.equalsIgnoreCase("pdf") ||
                extension.equalsIgnoreCase("docx") ||
                extension.equalsIgnoreCase("zip")) {

            System.out.println("Accepted");
        } else {
            System.out.println("Rejected — invalid file type");
        }
    }

    public static void main(String[] args) {

        validateFileExtension("Assignment1.PDF");
        validateFileExtension("notes.txt");
    }
}
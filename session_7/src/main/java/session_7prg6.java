class BookInventory {
    String title;
    String author;
    int copiesAvailable;

    BookInventory(String title, String author, int copiesAvailable) {
        this.title = title;
        this.author = author;
        this.copiesAvailable = copiesAvailable;
    }

    void printEntry() {
        System.out.println(title + " by " + author +
                " - " + copiesAvailable + " copies available");
    }
}

public class session_7prg6 {
    public static void main(String[] args) {

        BookInventory b1 = new BookInventory(
                "Clean Code", "Robert C. Martin", 3);

        BookInventory b2 = new BookInventory(
                "Effective Java", "Joshua Bloch", 5);

        BookInventory b3 = new BookInventory(
                "Refactoring", "Martin Fowler", 0);

        b1.printEntry();
        b2.printEntry();
        b3.printEntry();
    }
}
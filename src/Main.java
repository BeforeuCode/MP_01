import java.io.*;
import java.util.Arrays;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        try {
            testAttributes();
            testClassMethod2();
            testExtention();
            testOverrideAndOverload();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void testOverrideAndOverload() {

        System.out.println("TESTING Override and Overload");

        var bookSeller = new BookSeller("Pawel Czubak");
        System.out.println("bookSeller:" + bookSeller);
        //Override
        bookSeller.changeName("Pawel");
        System.out.println("Override - changeName z interface`u Person" + bookSeller.getName());
        //Override
        System.out.println("Override - toString" + bookSeller.toString());
        //Overload
        bookSeller.changeName("Pawel", "Mr.");
        System.out.println("Overload - changeName z dodatkowym parametrem title" + bookSeller.getName());

        System.out.println("=======================================================");
    }

    private static void testAttributes() {

        System.out.println("TESTING ATTRIBUTES");

        var book1 = new Book("Lord of the Rings: The Fellowship of the Ring", "J. R. R. Tolkien", 45, new Date(), Arrays.asList("Britain's best novel of all time", "Best book 2000"));
        var book2 = new Book("50 Shades of Gray", " E. L. James", 9, new Date(), Arrays.asList("Worst book 2010"));
        book2.setDiscount(0.3f);
        var bookSeller = new BookSeller("Pawel Czubak");

        System.out.println("book1" + book1);
        System.out.println("book2" + book2);
        System.out.println("bookSeller" + bookSeller);

        System.out.println("\n");
        System.out.println("Atr. prosty (Book -> title): " + book1.getTitle());
        System.out.println("Atr. złożony (Book -> releaseDate): " + book1.getReleaseDate());
        System.out.println("Art. opcjonalny gdy nie istnieje (Book -> discount): " + book1.getDiscount());
        System.out.println("Art. opcjonalny gdy istnieje (Book -> discount): " + book2.getDiscount());
        System.out.println("Atr. powt (Book -> awards) : " + book1.getAwards());
        System.out.println("Atr. klasowy (BookSeller -> salary) : " + bookSeller.getSalary());
        System.out.println("Atr. pochodny (Book -> price (po znizce)) : " + book1.getDiscountedPrice());
        System.out.println("\n");

        System.out.println("=======================================================");
    }

    private static void testClassMethod() throws Exception {
        var book = new Book("Lord of the Rings: The Fellowship of the Ring", "J. R. R. Tolkien", 45, new Date(), Arrays.asList("Britain's best novel of all time", "Best book 2000"));

        Book.showExtent();
    }

    private static void testClassMethod2() throws Exception {
        System.out.println("TESTING CLASS METHOD");
        var bookSeller1 = new BookSeller("Pawel");
        var bookSeller2 = new BookSeller("Gaweł");


        System.out.println("Old salary for seller1: " + bookSeller1.getSalary());
        System.out.println("Old salary for seller2: " + bookSeller2.getSalary());
        BookSeller.changeSalary(2000);

        System.out.println("After class method");

        System.out.println("Old salary for seller1: " + bookSeller1.getSalary());
        System.out.println("Old salary for seller2: " + bookSeller2.getSalary());

        System.out.println("=======================================================");
    }

    private static void testExtention() throws Exception {

        System.out.println("Testing Extention");

        final String extentFilePath = "c:\\temp\\extent-objectplus.bin";   // TODO update the file name

        var book1 = new Book("Lord of the Rings: The Fellowship of the Ring", "J. R. R. Tolkien", 45, new Date(), Arrays.asList("Britain's best novel of all time", "Best book 2000"));
        var book2 = new Book("50 Shades of Gray", " E. L. James", 9, new Date(), Arrays.asList("Worst book 2010"));

        Book.showExtent();

        try {
            // Write the extent to the stream
            var out = new ObjectOutputStream(new FileOutputStream(extentFilePath));
            ObjectPlus.writeExtents(out);
            out.close();

            // Read the extent from the stream
            var in = new ObjectInputStream(new FileInputStream(extentFilePath));
            ObjectPlus.readExtents(in);
            in.close();

            // Gets the extent and show the content of it
            Iterable<Book> bookExtent = ObjectPlus.getExtent(Book.class);
            for (var book : bookExtent) {
                System.out.println(book.getTitle());
            }
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }

        Book.showExtent();

        System.out.println("=======================================================");
    }
}

import java.util.List;

public class Main{
    public static void main(String[] args){
        Library library = new Library();

        List<Book> allBooks = List.of(
                new Book("Clean Code", "Robert Martin", 45, 464),
                new Book("1984", "George Orwell", 18, 328),
                new Book("Animal Farm", "George Orwell", 12, 112),
                new Book("Java Basics", "Max Muller", 35, 520),
                new Book("The Hobbit", "J.R.R Tolkien", 28, 310)
        );

        allBooks.forEach(library::addBook);

        System.out.println("1. Orwell books: " + library.getBooksByAuthor("George Orwell"));

        System.out.println("2. Average pages (first 3): " + library.getAveragePageCount(allBooks.subList(0, 3)));

        System.out.println("3. Max 30 Euro: " + library.getBooksWithinPriceLimit(allBooks, 30));
        System.out.println("4. Most Expensive: " + library.getMostExpensiveBook(allBooks));
        System.out.println("5. Min 300 pages: " + library.getBooksWithMinimumPages(allBooks, 300));
        System.out.println("6. 55 Euro budget: " + library.getTwoBooksWithinBudget(allBooks, 55));
    }
}
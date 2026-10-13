import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Library {
    private List<Book> books;

    public Library(){
        this.books = new ArrayList<>();
    }

    public void addBook(Book book){
        this.books.add(book);
    }

    public List<Book> getBooksByAuthor(String author) {
        return books.stream()
                .filter(b -> b.getAuthor().equals(author))
                .collect(Collectors.toList());
    }

    public double getAveragePageCount(List<Book> bookList) {
        if (bookList == null || bookList.isEmpty()) return 0.0;
        return bookList.stream()
                .mapToInt(Book::getPages)
                .average()
                .orElse(0.0);
    }

    public List<Book> getBooksWithinPriceLimit(List<Book> bookList, double maxPrice) {
        if (bookList == null) return new ArrayList<>();
        return bookList.stream()
                .filter(b -> b.getPrice() <= maxPrice)
                .collect(Collectors.toList());
    }

    public Book getMostExpensiveBook(List<Book> bookList) {
        if (bookList == null) return null;
        return bookList.stream()
                .max(Comparator.comparingDouble(Book::getPrice))
                .orElse(null);
    }

    public List<Book> getBooksWithMinimumPages(List<Book> bookList, int minPages) {
        if (bookList == null) return new ArrayList<>();
        return bookList.stream()
                .filter(b -> b.getPages() >= minPages)
                .collect(Collectors.toList());
    }
}

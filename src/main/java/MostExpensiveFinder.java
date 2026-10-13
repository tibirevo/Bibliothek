import java.util.Comparator;
import java.util.List;

public class MostExpensiveFinder {
    public Book getMostExpensiveBook(List<Book> bookList) {
        if (bookList == null) return null;
        return bookList.stream()
                .max(Comparator.comparingDouble(Book::getPrice))
                .orElse(null);
    }
}

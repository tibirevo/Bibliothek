import java.util.List;

public class PageAverageCalculator {
    public double getAveragePageCount(List<Book> bookList) {
        if (bookList == null || bookList.isEmpty()) return 0.0;
        return bookList.stream()
                .mapToInt(Book::getPages)
                .average()
                .orElse(0.0);
    }
}

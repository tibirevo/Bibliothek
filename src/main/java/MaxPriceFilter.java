import java.util.List;
import java.util.stream.Collectors;

public class MaxPriceFilter {
    public List<Book> getBooksWithinPriceLimit(List<Book> bookList, double maxPrice) {
        if (bookList == null) return List.of();
        return bookList.stream()
                .filter(b -> b.getPrice() <= maxPrice)
                .collect(Collectors.toList());
    }
}

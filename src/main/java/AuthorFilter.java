import java.util.List;
import java.util.stream.Collectors;

public class AuthorFilter {
    public List<Book> getBooksByAuthor(List<Book> bookList, String author) {
        if (bookList == null) return List.of();
        return bookList.stream()
                .filter(b -> b.getAuthor().equals(author))
                .collect(Collectors.toList());
    }
}
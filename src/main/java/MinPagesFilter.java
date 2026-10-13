import java.util.List;
import java.util.stream.Collectors;

public class MinPagesFilter {
    public List<Book> getBooksWithMinimumPages(List<Book> bookList, int minPages){
        if(bookList == null) return List.of();
        return bookList.stream()
                .filter(b -> b.getPages() >= minPages)
                .collect(Collectors.toList());
    }
}

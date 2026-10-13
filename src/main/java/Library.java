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

    public List<Book> getTwoBooksWithinBudget(List<Book> bookList, double budget){
        List<Book> bestPair = new ArrayList<>();
        if(bookList == null || bookList.size() < 2) return bestPair;

        double maxPrice = -1;
        int maxPages = -1;

        for(int i = 0; i < bookList.size() - 1; i++){
            for(int j = i + 1; j < bookList.size(); j++){
                Book b1 = bookList.get(i);
                Book b2 = bookList.get(j);

                double currentPrice = b1.getPrice() + b2.getPrice();
                int currentPages = b1.getPages() + b2.getPages();

                if(currentPrice <= budget && (currentPrice > maxPrice || (currentPrice == maxPrice && currentPages > maxPages))){
                    maxPrice = currentPrice;
                    maxPages = currentPages;
                    bestPair = List.of(b1, b2);
                }
            }
        }
        return bestPair;
    }
}

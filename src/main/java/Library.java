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
        List<Book> result = new ArrayList<>();
        for(Book b : this.books){
            if(b.getAuthor().equals(author)){
                result.add(b);
            }
        }
        return result;
    }

    public double getAveragePageCount(List<Book> bookList) {
        if(bookList == null || bookList.isEmpty()){
            return 0.0;
        }

        int sum = 0;
        for(Book b : bookList){
            sum += b.getPages();
        }
        return (double) sum / bookList.size();
    }

    public List<Book> getBooksWithinPriceLimit(List<Book> bookList, double maxPrice) {
        List<Book> result = new ArrayList<>();
        if(bookList == null){
            return result;
        }

        for(Book b : bookList){
            if(b.getPrice() <= maxPrice){
                result.add(b);
            }
        }
        return result;
    }

    public Book getMostExpensiveBook(List<Book> bookList) {
        if(bookList == null || bookList.isEmpty()){
            return null;
        }

        Book mostExpensive = bookList.get(0);
        for(Book b : bookList){
            if(b.getPrice() > mostExpensive.getPrice()){
                mostExpensive = b;
            }
        }
        return mostExpensive;
    }

    public List<Book> getBooksWithMinimumPages(List<Book> bookList, int minPages) {
        List<Book> result = new ArrayList<>();
        if(bookList == null){
            return result;
        }

        for(Book b : bookList){
            if(b.getPages() >= minPages){
                result.add(b);
            }
        }
        return result;
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

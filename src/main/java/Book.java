public class Book {
    private String title;
    private String author;
    private double price;
    private int pages;

    public Book(String title, String author, double price, int pages) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.pages = pages;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public int getPages() {
        return pages;
    }

    @Override
    public String toString() {
        return title + " (" + price + " Euro, " + pages + " pages)";
    }
}
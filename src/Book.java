import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class Book extends ObjectPlus implements Serializable {

    //Atrubut prosty
    private String title;
    private String author;
    //Atrybut pochodny
    private float price;
    //Atrubut złożony
    private Date releaseDate;
    //Atrubut powtarzalny
    private List<String> awards;
    //Atrybut opcjonalny
    private Float discount = null;


    public Book(String title, String author, float price, Date releaseDate, List<String> awards) {
        super();

        this.title = title;
        this.author = author;
        this.price = price;
        this.releaseDate = releaseDate;
        this.awards = awards;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public List<String> getAwards() {
        return awards;
    }

    public void setAwards(List<String> awards) {
        this.awards = awards;
    }

    public Float getDiscount() {
        return discount;
    }

    public void setDiscount(Float discount) {
        this.discount = discount;
    }

    //Metoda liczaca atrybut pochodny
    public double getDiscountedPrice() {
        var discount =  getDiscount() != null ? getDiscount() : 1;
        return getPrice() * discount;
    }

    //Przesłonięcie
    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", releaseDate=" + releaseDate +
                '}';
    }

    //Metoda klasowa
    public static void showExtent() throws Exception {
        ObjectPlus.showExtent(Book.class);
    }
}

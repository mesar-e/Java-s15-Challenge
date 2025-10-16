package kutuphane.model;

import java.util.Objects;
import java.util.UUID;

public class Book {

// Fields
    private final String id;
    private String title;
    private String author;
    private String publisher;
    private double price;
    private boolean isAvailable;

// Constructor
    public Book (String title, String author, String publisher, double price) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.publisher = publisher;
        this.price = price;
        this.isAvailable = true;
    }

    // Getter Setter metodları
    public String getId() {
        return id;
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

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    // book bilgilerini string olarak döndürür
    @Override
    public String toString() {
        return "Kitap {" +
                "ID='" + id + '\'' +
                ", Başlık='" + title + '\'' +
                ", Yazar='" + author + '\'' +
                ", Yayınevi='" + publisher + '\'' +
                ", Fiyat=" + price +
                ", Durum=" + (isAvailable ? "Mevcut" : "Ödünç Alındı") +
                '}';
    }

    // hash kodu döndürür
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

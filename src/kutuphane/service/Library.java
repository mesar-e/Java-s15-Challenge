package kutuphane.service;

import kutuphane.model.Book;
import  kutuphane.model.Member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {

    //map çünkü id ile bulmak daha kolay
    private final Map<String, Book> books;

    private final Map<String, Member> members;

    //constructor
    public Library() {
        this.books = new HashMap<>();
        this.members = new HashMap<>();
    }

    //kütühaneye kitap ekler
    public void addBook(Book book) {
        books.put(book.getId(), book);
        System.out.println(book.getTitle() + " başlıklı kitap kütühanye eklendi");
    }

    // üye ekler
    public void addMember (Member member) {
        members.put(member.getId(), member);
        System.out.println(member.getName() + " isimli üye eklendi");

    }

    // verilen ID li kitabı bulup döndürür
    public Book findBookById(String bookId) {
        return books.get(bookId);
    }

    // bütün kitapları yazdırır
    public void displayAllBooks() {
        System.out.println("---kütüphanedeki bütün kitaplar---");
        if (books.isEmpty()) {
            System.out.println("Kütüphanede kitap yok");
        } else {
            for (Book book : books.values()) {
                System.out.println(book);
            }
        }
    }

    // kitapları başlığıyla bulur ve listeye döndürür. kitap yoksa boş döner
    public List<Book> findBooksByTitle (String titleName) {
        List<Book> foundBooks = new ArrayList<>();
        for (Book book : books.values()) {
            if (book.getTitle().equalsIgnoreCase(titleName)) {
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }

    // yazarın kitaplarını bulur ve liste olarak döner. kitap yoksa boş liste döner
    public List<Book> findBooksByAuthor (String authorName) {
        List<Book> foundBooks = new ArrayList<>();
        for (Book book : books.values()) {
            if (book.getAuthor().equalsIgnoreCase(authorName)) {
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }

    // ID ile kitap siler
    public boolean deleteBook (String bookId) {
        Book removedBook = books.remove(bookId);

        if (removedBook != null) { // nedense = null kullanamadım
            System.out.println(removedBook.getTitle() + " adlı kitap silindi");
            return true;
        } else {
            System.out.println("HATA: verilen ID li kitap yok");
            return false;
        }
    }

    //var olan bir kitabın bilgilerini günceller
    public boolean updateBook (String bookId, String newTitle, String newAuthor, double newPrice) {
        Book bookToUpdate = findBookById(bookId);

        if (bookToUpdate != null) {
            bookToUpdate.setTitle(newTitle);
            bookToUpdate.setAuthor(newAuthor);
            bookToUpdate.setPrice(newPrice);
            System.out.println(bookToUpdate.getTitle() + " başlıklı kitap güncellendi");
            return true;
        } else {
            System.out.println("HATA: kitap bulunamadı");
            return false;
        }
    }
}

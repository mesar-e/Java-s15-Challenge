package kutuphane.service;

import kutuphane.model.Book;
import  kutuphane.model.Member;

import java.util.HashMap;
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
}

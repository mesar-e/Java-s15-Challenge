package kutuphane.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Member extends Person {
    private final LocalDate membershipDate;
    private final Set<Book> borrowedBooks; //aynı kitabı iki kere almasın diye set
    public static final int max_allowed_books = 5;

    //constructor
    public Member(String name, String email) {
        super(name, email); //bu persons contructorunu çağırıyormuş
        this.membershipDate = LocalDate.now();
        this.borrowedBooks = new HashSet<>();
    }

    @Override
    public void whoAmI() {
        System.out.println("Ben bir kütüphane üyesiyim adım: " + getName());
    }

    //getter
    public Set<Book> getBorrowedBooks() {
        return borrowedBooks;
    }
    public LocalDate getMembershipDate() {
        return membershipDate;
    }

    // ödünç kitap ekler
    public void borrowBook(Book book) {
        if (borrowedBooks.size() < max_allowed_books) {
            borrowedBooks.add(book);
        } else {
            System.out.println("HATA: maksimum kitap limitine ulaştın");
        }
    }

    //kiap iade eder
    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }

    @Override
    public String toString() {
        return "Üye {" +
                super.toString() +
                ", Üyelik tarihi=" + membershipDate +
                ", Aldığı kitap sayısı=" + borrowedBooks.size() +
                '}';
    }
}

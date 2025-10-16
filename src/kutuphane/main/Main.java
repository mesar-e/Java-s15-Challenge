package kutuphane.main;

import kutuphane.model.Book;
import kutuphane.service.Library;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Library library = new Library();

        library.addBook(new Book("Yüzklerin Efendisi","Tolkien","A yayını",150.0));
        library.addBook(new Book("Kırık Hançer","Ahmet Yılmaz Boyunağa","Timaş",100.0));
        library.addBook(new Book("Sefiller","Victor Hugo","B yayını",75.0));

        System.out.println("Kütüphaneye Hoşgeldiniz");

        while (true) {
            System.out.println("---ANA MENÜ---");
            System.out.println("1. tüm kitapları listele");
            System.out.println("2. Kitap ekle");
            System.out.println("3. İsme göre kitap ara");
            System.out.println("4. Yazara göre kitap ara");
            System.out.println("5. ID'ye göre kitap sil");
            System.out.println("0. Çıkış");
            System.out.println(" ");
            System.out.println("Lütfen yapmak istediğiniz işlemi seçiniz");

            String secim = scanner.nextLine();

            switch (secim) {
                case "1":
                    library.displayAllBooks();
                    break;
                case "2":
                    handleAddNewBook(scanner, library);
                    break;
                case "3":
                    handleSearchByTitle(scanner, library);
                    break;
                case "4":
                    handleSearchByAuthor(scanner, library);
                    break;
                case "5":
                    handleDeleteBook(scanner,library);
                    break;
                case "0":
                    System.out.println("Sistemden çıkılıyor");
                    scanner.close();
                    return;
                default:
                    System.out.println("Geçersiz seçim. Numaralardan birini giriniz");
                    break;
            }
        }
    }

    //  kibın bilgilerini alır yeni kitap oluşturur be listye ekler
    private static void handleAddNewBook (Scanner scanner, Library library) {
        System.out.println("---yeni kitap ekleme---");
        System.out.println("Kitap başlığı: ");
        String title = scanner.nextLine();

        System.out.println("Yazar adı: ");
        String author = scanner.nextLine();

        System.out.println("yayınevi adı: ");
        String publisher = scanner.nextLine();

        System.out.println("fiyatı: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        Book newBook = new Book(title,author,publisher,price);
        library.addBook(newBook);
    }

    private static void handleSearchByTitle (Scanner scanner, Library library) {
        System.out.println("---Başlığa göre kitap arama---");
        System.out.println("Kitabın adı: ");
        String title = scanner.nextLine();

        List<Book> foundBooks = library.findBooksByTitle(title);

        if (foundBooks.isEmpty()) {
            System.out.println( title + " adında bir kitap bulunamadı");
        } else {
            System.out.println("bulunan kitaplar:");
            for (Book book : foundBooks) {
                System.out.println(foundBooks);
            }
        }
    }


    // kitabı yazar adına göre arıyor
    private static void handleSearchByAuthor (Scanner scanner, Library library) {
        System.out.println("---yazara göre kitap arama---");
        System.out.println("Yazarın adını giriniz: ");
        String author = scanner.nextLine();

        List<Book> foundBooks = library.findBooksByAuthor(author);

        if (foundBooks.isEmpty()) {
            System.out.println( author + " yazarına ait kitap bulunamadı");
        } else {
            System.out.println("bulunan kitaplar:");
            for (Book book : foundBooks) {
                System.out.println(foundBooks);
            }
        }
    }

    //kitabı id ye göre siliyor
    private static void handleDeleteBook (Scanner scanner, Library library) {
        System.out.println("---Id ye göre kitap silme---");
        System.out.println("kitabın ıd sini giriniz: ");
        String bookId = scanner.nextLine();
        library.deleteBook(bookId);
    }
}

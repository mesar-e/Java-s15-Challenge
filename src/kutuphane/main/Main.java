package kutuphane.main;

import kutuphane.model.Book;
import kutuphane.model.Member;
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

        library.addMember(new Member("Ali", "Ali@çakmamail.com"));
        library.addMember(new Member("veli", "Veli@çakmamail.com"));

        System.out.println("Kütüphaneye Hoşgeldiniz");

        while (true) {
            System.out.println("---ANA MENÜ---");
            System.out.println("1. tüm kitapları listele");
            System.out.println("2. tüm üyeleri listele");
            System.out.println("3. Kitap ekle");
            System.out.println("4. Kitap bilgilerini güncelle");
            System.out.println("5. İsme göre kitap ara");
            System.out.println("6. Yazara göre kitap ara");
            System.out.println("7. ID'ye göre kitap sil");
            System.out.println("8. Kitap ödünç al");
            System.out.println("9. Kitap iade et");
            System.out.println("0. Çıkış");
            System.out.println(" ");
            System.out.println("Lütfen yapmak istediğiniz işlemi seçiniz");

            String secim = scanner.nextLine();

            switch (secim) {
                case "1":
                    library.displayAllBooks();
                    break;
                case "2":
                    library.displayAllMembers();
                    break;
                case "3":
                    handleAddNewBook(scanner, library);
                    break;
                case "4":
                    handleUpdateBook(scanner, library);
                    break;
                case "5":
                    handleSearchByTitle(scanner, library);
                    break;
                case "6":
                    handleSearchByAuthor(scanner, library);
                    break;
                case "7":
                    handleDeleteBook(scanner,library);
                    break;
                case "8":
                    handleLendBook(scanner,library);
                    break;
                case "9":
                    handleTakeBackBook(scanner, library);
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

    //var olan bir kitabın bilgilerini günceller
    private static void handleUpdateBook(Scanner scanner, Library library) {
        System.out.println("--- Kitap Bilgilerini Güncelleme ---");
        System.out.print("Güncellemek istediğiniz kitabın ID'sini giriniz: ");
        String bookId = scanner.nextLine();

        System.out.println("Lütfen yeni bilgileri giriniz (değiştirmek istemiyorsanız mevcut bilgiyi tekrar girin):");

        System.out.print("Yeni Başlık: ");
        String newTitle = scanner.nextLine();

        System.out.print("Yeni Yazar: ");
        String newAuthor = scanner.nextLine();

        System.out.print("Yeni Yayınevi: ");
        String newPublisher = scanner.nextLine();

        System.out.print("Yeni Fiyat: ");
        double newPrice = scanner.nextDouble();
        scanner.nextLine();

        library.updateBook(bookId, newTitle, newAuthor, newPublisher, newPrice);
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
                System.out.println(book);
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
                System.out.println(book);
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

    // kitabı ödünç alma
    private static void handleLendBook(Scanner scanner, Library library) {
        System.out.println("--- Kitap Ödünç Alma ---");
        System.out.print("Kitabı alacak üyenin ID'sini giriniz: ");
        String memberId = scanner.nextLine();
        System.out.print("Ödünç alınacak kitabın ID'sini giriniz: ");
        String bookId = scanner.nextLine();
        library.lendBook(memberId, bookId);
    }

    //kitap iade etme
    private static void handleTakeBackBook(Scanner scanner, Library library) {
        System.out.println("--- Kitap İade Etme ---");
        System.out.print("İade edilecek kitabın ID'sini giriniz: ");
        String bookId = scanner.nextLine();
        library.takeBackBook(bookId);
    }
}

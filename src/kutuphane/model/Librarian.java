package kutuphane.model;

public class Librarian extends Person {

    private String password;

    //constuctor
    public Librarian(String name, String email, String password) {
        super(name, email);
        this.password = password;
    }

    @Override
    public void whoAmI() {
        System.out.println("Ben bir kütühaneciyim adım: " + getName());
    }

    // belki lazım olur
    public void setPassword(String password) {
        this.password = password;
    }

    //bilerek şifreyi eklemedim
    @Override
    public String toString() {
        return "Kütühaneci {" +
                super.toString() +
                '}';
    }
}

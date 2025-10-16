package kutuphane.model;

import java.util.UUID;
// soyut sınıf
public abstract class Person {
    protected final String id;
    protected String name;
    protected String email;

    //Constructor
    public Person (String name, String email) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.email = email;
    }
    //Getter Setter
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //her alt sınfın doldurması lazım. herhalde polymorphism
    public abstract void whoAmI();

    //alt sınıdlar için tostring
    @Override
    public String toString() {
        return "ID='" + id + '\'' +
                ", İsim='" + name + '\'' +
                ", Email='" + email + '\'';
    }
}

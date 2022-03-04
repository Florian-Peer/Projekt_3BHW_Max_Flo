package Person;

import java.time.LocalDate;

public abstract class Person{

    private int _id;
    private String _Vorname;
    private String _lastname;
    private LocalDate _birthdate;
    private char _geschlecht;



    public int getId() {
        return this._id;
    }

    public void setId(int id) {
        if (id >= 0) {
            this._id = id;
        }
    }

    public String getFirstname() {

        return this._Vorname;
    }

    public void setFirstname(String firstname) {
        this._Vorname = firstname;
    }

    public String getLastname() {
        return this._lastname;
    }

    public void setLastname(String lastname) {
        this._lastname = lastname;
    }

    public LocalDate getBirthdate() {
        return this._birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this._birthdate = birthdate;
    }

    public char getGeschlecht() {
        return this._geschlecht;
    }

    public void setGeschlecht(char geschlecht) {
        this._geschlecht = geschlecht;
    }


    public Person() {
        this(0, " ", " ", null, ' ');
    }

    public Person(int id, String firstname, String lastname, LocalDate birthdate, char geschlecht) {
        this.setId(id);

        this.setFirstname(firstname);
        this.setLastname(lastname);
        this.setBirthdate(birthdate);
        this.setGeschlecht(geschlecht);
    }

    @Override
    public String toString() {
        return this._id + " " + this._Vorname + " " + this._lastname + "\n" + this._birthdate + " " + this._geschlecht;
    }


}
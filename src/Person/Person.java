package Person;

import java.time.LocalDate;

public abstract class Person{

    private int _id;
    private String _firstname;
    private String _lastname;
    private LocalDate _birthdate;
    private char _gender;



    public int getId() {
        return this._id;
    }

    public void setId(int id) {
        if (id >= 0) {
            this._id = id;
        }
    }

    public String getFirstname() {

        return this._firstname;
    }

    public void setFirstname(String firstname) {
        this._firstname = firstname;
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

    public char getGender() {
        return this._gender;
    }

    public void setGender(char geschlecht) {
        this._gender = geschlecht;
    }


    public Person() {
        this(0, " ", " ", null, ' ');
    }

    public Person(int id, String firstname, String lastname, LocalDate birthdate, char geschlecht) {
        this.setId(id);

        this.setFirstname(firstname);
        this.setLastname(lastname);
        this.setBirthdate(birthdate);
        this.setGender(geschlecht);
    }

    @Override
    public String toString() {
        return this._id + " " + this._firstname + " " + this._lastname + "\n" + this._birthdate + " " + this._gender;
    }


}
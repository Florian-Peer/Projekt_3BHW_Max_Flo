package Person;

import java.time.LocalDate;
import java.util.SimpleTimeZone;

// TODO: 01.04.2022 APRIL APRIL mia miassn no die Person einbauen, nit nur username und password
// TODO: 08.04.2022 also: mir kennen bei UserData.csv no a Zahl einbauen und des isch die PersonenID
//                        die personen werden in ana eigenen Datei abgespeichert
public class Person{

    private int _id;
    private String _firstname;
    private String _lastname;
    private LocalDate _birthdate;
    private String _password;
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

    public String getPassword(){
        return this._password;
    }

    public void setPasword(String password){
        this._password=password;
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
        this(0, " ", " "," ", null, ' ');
    }

    public Person(int id, String firstname, String lastname,String password, LocalDate birthdate, char geschlecht) {
        this.setId(id);

        this.setFirstname(firstname);
        this.setLastname(lastname);
        this.setPasword(password);
        this.setBirthdate(birthdate);
        this.setGender(geschlecht);
    }

    @Override
    public String toString() {
        return this._id + " " + this._firstname + " " + this._lastname + "\n" +this._password + "\n" + this._birthdate + " " + this._gender;
    }


}
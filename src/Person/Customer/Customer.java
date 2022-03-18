package Person.Customer;

import Person.Person;

import java.time.LocalDate;

public class Customer extends Person {

    LocalDate _dateOfVisit;

    public LocalDate getDateOfVisit() {
        return this._dateOfVisit;
    }

    public void setDateOfVisit(LocalDate dateOfVisit) {
        this._dateOfVisit = dateOfVisit;
    }

    public Customer(){this(0," ", " ", null, ' ',null);}
    public Customer(int id, String firstname, String lastname, LocalDate birthdate, char gender, LocalDate dateOfVisit){
        this.setId(id);
        this.setFirstname(firstname);
        this.setLastname(lastname);
        this.setBirthdate(birthdate);
        this.setGender(gender);
        this.setDateOfVisit(dateOfVisit);
    }

    @Override
    public String toString(){
        return super.toString() + "\n" +_dateOfVisit;
    }
}

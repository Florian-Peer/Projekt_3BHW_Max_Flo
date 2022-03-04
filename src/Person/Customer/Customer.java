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

    public Customer(int id, String firstname, String lastname, LocalDate birthdate, char gender){}
}

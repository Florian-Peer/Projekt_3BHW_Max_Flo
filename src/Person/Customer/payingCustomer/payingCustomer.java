package Person.Customer.payingCustomer;

import Person.Customer.Customer;

import java.time.LocalDate;

public class payingCustomer extends Customer {
    String was;


    public payingCustomer(int id, String firstname, String lastname, LocalDate birthdate, char gender) {
        super(id, firstname, lastname, birthdate, gender);
    }
}

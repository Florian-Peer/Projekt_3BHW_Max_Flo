package Person.Customer.payingCustomer;
import Person.Customer.Customer;
import java.time.LocalDate;
import java.util.List;

public class payingCustomer extends Customer {

    private String _username;
    private String _password;
    private List<Ticket> _ticket;




    public payingCustomer(int id, String firstname, String lastname, LocalDate birthdate, char gender) {
        super(id, firstname, lastname, birthdate, gender);
    }
}

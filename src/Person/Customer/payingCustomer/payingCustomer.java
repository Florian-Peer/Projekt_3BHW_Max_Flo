package Person.Customer.payingCustomer;

import Person.Customer.Customer;

import java.time.LocalDate;
import java.util.List;

public class payingCustomer extends Customer {

    private String _username;
    private String _password;
    private List<Ticket> _ticket;

    public String getUsername() {
        return _username;
    }

    public void setUsername(String _username) {
        this._username = _username;
    }

    public String getPassword() {
        return _password;
    }

    public void setPassword(String _password) {
        this._password = _password;
    }

    public payingCustomer() {
        this(0, " ", " ", null,null, ' ', " ", " ");
    }

    public payingCustomer(int id, String firstname, String lastname, LocalDate birthdate, LocalDate dateOfVisit, char gender,
                          String username, String password) {
        super(id, firstname, lastname, birthdate, gender, dateOfVisit);
        this.setUsername(username);
        this.setPassword(password);
    }

    @Override
    public String toString() {
        String s = super.toString() + "\n" + this.getUsername() + " " + this.getPassword();

        for (Ticket t : this._ticket) {
            s += t + "\n";
        }

        return s;
    }

    public boolean addTicket(Ticket ticket) {
        if (ticket != null) {
            return this._ticket.add(ticket);
        }
        return false;
    }

    public boolean removeTicket(int ticketIdToDelete) {
        for (Ticket t : this._ticket) {
            if (t.getTicketId() == ticketIdToDelete) {
                return this._ticket.remove(t);
            }
        }
        return false;
    }
}

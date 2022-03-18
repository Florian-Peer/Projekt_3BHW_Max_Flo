package Person.Customer.payingCustomer;

import java.time.LocalDateTime;

public class Ticket {

    private int _ticketId;
    private int _typeOfTicket;
    private LocalDateTime _ticketBuyTime;
    private LocalDateTime _ticketExpireDate;

    public int getTicketId() {
        return _ticketId;
    }

    public void setTicketId(int ticketId) {
        this._ticketId = ticketId;
    }

    public int gettypeOfTicket() {
        return _typeOfTicket;
    }

    public void setTypeOfTicket(int _typeOfTicket) {
        this._typeOfTicket = _typeOfTicket;
    }

    public LocalDateTime getTicketBuyTime() {
        return _ticketBuyTime;
    }

    public void setTicketBuyTime(LocalDateTime _ticketBuyTime) {
        this._ticketBuyTime = _ticketBuyTime;
    }

    public LocalDateTime getTicketExpireDate() {
        return _ticketExpireDate;
    }

    public void setTicketExpireDate(LocalDateTime _ticketExpireDate) {
        this._ticketExpireDate = _ticketExpireDate;
    }

    public Ticket() {
        this(0, 0, null, null);
    }

    public Ticket(int _ticketId, int _typeOfTicket, LocalDateTime _ticketBuyTime, LocalDateTime _ticketExpireDate) {
        this.setTicketId(_ticketId);
        this.setTypeOfTicket(_typeOfTicket);
        this.setTicketBuyTime(_ticketBuyTime);
        this.setTicketExpireDate(_ticketExpireDate);
    }

    @Override
    public String toString() {
        return this.getTicketId() + " " + this._typeOfTicket + " " + this._ticketBuyTime + " " + this._ticketExpireDate;
    }


}

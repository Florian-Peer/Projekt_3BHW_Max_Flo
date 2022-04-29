package TICKETS;

import java.sql.Date;

public class allgemeinesTicket {
    private int _ticketID;
    private TypeOfTicket _typeofticket;
    private String _ticketName;
    private Date _datum;
    private double _price;

    public int getTicketId(){
        return _ticketID;
    }
    public void setTicketId(int ticketId){
        this._ticketID=ticketId;
    }
    public TypeOfTicket gettypeOfTicket(){
        return _typeofticket;
    }
    public void setTypeOfTicket(TypeOfTicket typeofticket){
        this._typeofticket=typeofticket;

    }
    public String getTicketName(){
        return _ticketName;
    }
    public void setTicketName(String ticketname){
        this._ticketName = ticketname;
    }
    public Date getDatum (){
        return _datum;
    }
    public void setDatum(Date datum){
        this._datum = datum;
    }
    public double getPrice(){
        return _price;
    }
    public void setPrice(double price){
        this._price=price;

    }

    public allgemeinesTicket(){
        this(0,TypeOfTicket.NichtFestgelegt,"",null,0.0);
    }
    public allgemeinesTicket(int ID,TypeOfTicket typeOf,String Name,Date date,double Price){
        this.setTicketId(ID);
        this.setTypeOfTicket(typeOf);
        this.setTicketName(Name);
        this.setDatum(date);
        this.setPrice(Price);
    }
    @Override
    public String toString(){
        return this._ticketID + " "+this._typeofticket+""+this._ticketName+" "+this._datum+" "+this._price;
    }
}

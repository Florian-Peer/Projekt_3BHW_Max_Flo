package TICKETS;

import java.util.Date;

public class tagesTicket extends allgemeinesTicket{
    private Date _beginnzeit;
    private Date _endzeit;

    public Date getBeginn(){
        return _beginnzeit;
    }
    public void setBeginn(Date beginn){
        this._beginnzeit=beginn;

    }
    public Date getEnde(){
        return _endzeit;
    }
    public void setEndzeit(Date endzeit){
        this._endzeit=endzeit;
    }
    public tagesTicket(){
        this(0,TypeOfTicket.NichtFestgelegt,"",null,0.0,null,null);
    }
    public tagesTicket(int ID, TypeOfTicket typeof, String name,Date kauf, double price, Date begin, Date end){
        super(ID,typeof,name,kauf,price);
        this.setBeginn(begin);
        this.setEndzeit(end);
    }
    @Override
    public String toString(){
        return super.toString()+" "+this._beginnzeit+ "START: "+ this._endzeit+"ENDE: ";

    }
}

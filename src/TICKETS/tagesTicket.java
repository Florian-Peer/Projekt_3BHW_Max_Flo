package TICKETS;

import java.sql.Time;
import java.time.LocalTime;
import java.util.Date;

public class tagesTicket extends allgemeinesTicket{
    private Time _beginnzeit;
    private Time _endzeit;

    public Time getBeginn(){
        return _beginnzeit;
    }
    public void setBeginn(Time beginn){
        this._beginnzeit=beginn;

    }
    public Time getEnde(){
        return _endzeit;
    }
    public void setEndzeit(Time endzeit){
        this._endzeit=endzeit;
    }
    public tagesTicket(){
        this(0,TypeOfTicket.NichtFestgelegt,"",null,0.0,null,null);
    }
    public tagesTicket(int ID, TypeOfTicket typeof, String name,Date kauf, double price, Time begin, Time end){
        super(ID,typeof,name,kauf,price);
        this.setBeginn(begin);
        this.setEndzeit(end);
    }
    @Override
    public String toString(){
        return super.toString()+"  START: "+this._beginnzeit+"  ENDE: "+ this._endzeit;

    }
}

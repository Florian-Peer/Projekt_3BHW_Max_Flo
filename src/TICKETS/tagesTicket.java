package TICKETS;

import java.time.LocalDate;
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
        this(null,null);
    }
    public tagesTicket(Date begin,Date end){
        this.setBeginn(begin);
        this.setEndzeit(end);
    }
    @Override
    public String toString(){
        return super.toString()+" "+this._beginnzeit+ "START: "+ this._endzeit+"ENDE: ";

    }
}

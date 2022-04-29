package TICKETS;

import java.util.Date;

public class saisonTicket extends allgemeinesTicket{
    private Date _endeSaison;
    private String _fname;
    private String _lname;

    public Date getendeSaison(){
        return this._endeSaison;
    }
    public void setendeSaison(Date ende){
        this._endeSaison=ende;
    }
}

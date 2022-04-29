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
    public String getfname (){
        return this._fname;
    }
    public void setfname(String fname){
        this._fname=fname;
    }
    public String getlname (){
        return this._lname;
    }
    public void setlname(String lname){
        this._lname=lname;
    }
    public saisonTicket(){
        this(0,TypeOfTicket.NichtFestgelegt,"",null,0.0,null,"","");
    }
    public saisonTicket(int ID, TypeOfTicket typeof, String name,Date kauf, double price,Date ende,String firtst, String last){
        super(ID,typeof,name,kauf,price);
        this.setendeSaison(ende);
        this.setfname(firtst);
        this.setlname(last);
    }
    @Override
    public String toString(){
        return super.toString()+" "+this._endeSaison+" "+this._fname+" "+this._lname;

    }


}

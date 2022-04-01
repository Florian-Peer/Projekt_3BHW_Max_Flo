package Schneekanone;

public class Schneekanone {
    private int _kId;
    private String _kanoneName;
    private String _brand;
    private boolean _betrieb;


    public int getKid(){
        return this._kId;
    }
    public void setKid(int kId){
        this._kId = kId;
    }

    public String getKanoneName(){
        return this._kanoneName;
    }
    public void setKanoneName(String kName){
        this._kanoneName = kName;
    }

    public String getBrand(){
        return this._brand;
    }
    public void setBrand(String Brand){
        this._brand = Brand;
    }

   public boolean getBetrieb() {
        return this._betrieb;
   }
   public void setBetrieb(boolean betrieb) {
        this._betrieb=betrieb;
   }


    public Schneekanone(){
        this(0, "", "",false);
    }
    public Schneekanone(int kid, String Kanonenname, String brand, boolean betrieb){
        this.setKid(kid);
        this.setKanoneName(Kanonenname);
        this.setBrand(brand);
        this.setBetrieb(betrieb);
    }


    @Override
    public String toString(){
        return "ID: " + this.getKid() + " SKNAME: " + this.getKanoneName() + " BRAND: " + this.getBrand() + " BETRIEB: " + this.getBetrieb();
    }

    public String toCSV(){
        return  this.getKid() + ";" + this.getKanoneName() + ";" + this.getBrand() + ";" + this.getBetrieb() + ";";
    }
}


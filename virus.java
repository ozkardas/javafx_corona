
package javaodev1;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class virus {
     private final StringProperty ulke;
    private final IntegerProperty vaka;
    private final IntegerProperty topvaka;
    private final IntegerProperty olu;
    private final IntegerProperty topolu;
    private final IntegerProperty nufus;
    private final StringProperty olumoran;
    private final StringProperty saldiri;
    
     
    public virus() {
        this(null, 0,0,0,0,0,null,null);
    }
    
    
    public virus(String Ulke,int TopVaka, int Vaka,int Topolu,int Olu,int Nufus,String Olumoran,String Saldiri) {
        this.ulke = new SimpleStringProperty(Ulke);         
        this.nufus = new SimpleIntegerProperty(Nufus);     
        this.vaka = new SimpleIntegerProperty(Vaka);     
        this.olu = new SimpleIntegerProperty(Olu);
        this.topvaka = new SimpleIntegerProperty(TopVaka);  
        this.topolu = new SimpleIntegerProperty(Topolu);   
        this.saldiri=new SimpleStringProperty(Saldiri);   
        this.olumoran = new SimpleStringProperty(Olumoran);   
        
    }
    
    public String getulke() {
        return ulke.get();
    }

    public void setulke(String Ulke) {
        this.ulke.set(Ulke);
    }
    
    public StringProperty ulkeProperty() {
        return ulke;
    }

    public String getolumoran() {
        return olumoran.get();
    }

    public void setolumoran(String Olumoran) {
        this.olumoran.set(Olumoran);
    }
    
    public StringProperty olumoranProperty() {
        return olumoran;
    }

    public String getsaldiri() {
        return saldiri.get();
    }

    public void setsaldiri(String Saldiri) {
        this.saldiri.set(Saldiri);
    }
    
    public StringProperty saldiriProperty() {
        return saldiri;
    }

    public int getvaka() {
        return vaka.get();
    }

    public void setvaka(int Vaka) {
        this.vaka.set(Vaka);
    }
    
    public IntegerProperty vakaProperty() {
        return vaka;
    }
   
    
    public int gettopvaka() {
        return topvaka.get();
    }

    public void settopvaka(int TopVaka) {
        this.topvaka.set(TopVaka);
    }
    
    public IntegerProperty topvakaProperty() {
        return topvaka;
    }
 public int gettopolu() {
        return topolu.get();
    }

    public void settopolu(int TopOlu) {
        this.topolu.set(TopOlu);
    }
    
    public IntegerProperty topoluProperty() {
        return topolu;
    }
    public int getolu() {
        return olu.get();
    }

    public void setolu(int Olu) {
        this.olu.set(Olu);
    }
    
    public IntegerProperty oluProperty() {
        return olu;
    }
     public int getnufus() {
        return nufus.get();
    }

    public void setnufus(int Nufus) {
        this.nufus.set(Nufus);
    }
    
    public IntegerProperty nufusProperty() {
        return nufus;
    }
}
        
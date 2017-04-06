package beans;

public class Auto {

    private String farbe;
    private int leistung;
    
    public void setFarbe(String farbe) {
        this.farbe = farbe;
    }
    
    public String getFarbe() {
        return farbe;
    }

    public int getLeistung() {
        return leistung;
    }

    public void setLeistung(int leistung) {
        this.leistung = leistung;
    }
    

    @Override
    public String toString() {
        return "Auto. Farbe: " + farbe + ", Leistung: " + leistung;
    }
    
}

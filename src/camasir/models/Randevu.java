package camasir.models;

import java.time.LocalDateTime;

public class Randevu {
    private String randevuID;
    private Ogrenci ogrenci; 
    private Makine makine;   
    private LocalDateTime tarihSaat;
    private boolean tamamlandi;

    public Randevu(String randevuID, Ogrenci ogrenci, Makine makine, LocalDateTime tarihSaat) {
        this.randevuID = randevuID;
        this.ogrenci = ogrenci;
        this.makine = makine;
        this.tarihSaat = tarihSaat;
        this.tamamlandi = false;
    }

    
    public String getRandevuID() { return randevuID; }
    public void setRandevuID(String randevuID) { this.randevuID = randevuID; }

    public Ogrenci getOrenci() { return ogrenci; }
    public void setOgrenci(Ogrenci ogrenci) { this.ogrenci = ogrenci; }
    
    public Makine getMakine() { return makine; }
    public void setMakine(Makine makine) { this.makine = makine; }

    public LocalDateTime getTarihSaat() { return tarihSaat; }
    public void setTarihSaat(LocalDateTime tarihSaat) { this.tarihSaat = tarihSaat; }

    public boolean isTamamlandi() { return tamamlandi; }
    public void setTamamlandi(boolean tamamlandi) { this.tamamlandi = tamamlandi; }
}
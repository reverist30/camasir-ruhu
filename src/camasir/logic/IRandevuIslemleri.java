package camasir.logic;

import camasir.models.Randevu;
import java.util.List;

public interface IRandevuIslemleri {
   
    boolean randevuAl(Randevu randevu);

   
    boolean randevuIptalEt(String randevuID);

    List<Randevu> randevulariGetir();
    
    
    boolean saatDoluMu(String saat);
}
package camasir.logic;

import java.util.List;

import camasir.models.Randevu;

public interface IRandevuIslemleri {

	boolean randevuAl(Randevu randevu);

	boolean randevuIptalEt(String randevuID);

	List<Randevu> randevulariGetir();

	boolean saatDoluMu(String saat);
}
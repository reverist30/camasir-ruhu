package camasir.logic;

import java.util.List;

public class CamasirYonetim {
	public boolean saatMusaitMi(String gun, String secilenSaat) {
		List<String> tumRandevular = DosyaYoneticisi.getInstance().verileriOku(true);
		String aranan = "| " + gun + " | " + secilenSaat + " |";
		for (String satir : tumRandevular) {
			if (satir.contains(aranan)) {
				return false;
			}
		}
		return true;
	}

	public boolean randevuHakkiVarMi(String ogrTC) {
		List<String> tumRandevular = DosyaYoneticisi.getInstance().verileriOku(true);
		int sayac = 0;
		for (String satir : tumRandevular) {
			if (satir.startsWith(ogrTC)) {
				sayac++;
			}
		}
		// Eger 3 veya daha fazlaysa izin verme
		return sayac < 3;
	}
}
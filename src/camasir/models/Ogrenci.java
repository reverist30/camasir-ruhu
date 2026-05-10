package camasir.models;

import java.awt.EventQueue;

import javax.swing.UIManager;

import camasir.ui.Ogrenci_Paneli;

public class Ogrenci extends Kullanici {
	private String odaNo;
	private int randevuHakki;

	public Ogrenci(String tC, String telNo, String tamIsim, String odaNo, int randevuHakki) {
		super(tC, telNo, tamIsim);
		this.odaNo = odaNo;
		this.randevuHakki = randevuHakki;
	}

	public Ogrenci() {

	}

	public String getOdaNo() {
		return odaNo;
	}

	public void setOdaNo(String odaNo) throws Exception {
		String[] parca = odaNo.split("-");
		String blokIsmi = parca[0].trim();
		String ogrOdasi = parca[1].trim();

		int katSayisi = 9;
		int herKatOda = 30;
		if (blokIsmi.equals("D Blok") || blokIsmi.equals("E Blok")) {
			katSayisi = 5;
			herKatOda = 4;
		}

		try {
			if (ogrOdasi.toLowerCase().startsWith("z")) {
				int sayi = Integer.parseInt(ogrOdasi.substring(1)); // oda numarasinin ilk basamagi atilarak integera
																	// cevrildi
				if (1 > sayi || sayi > herKatOda) {
					throw new Exception("Bu bloğa ait zemin kat odası bulunmamaktadır!");
				}
			} else {
				int sayi = Integer.parseInt(ogrOdasi);
				if ((sayi / 100) > katSayisi || (sayi % 100) > herKatOda || (sayi % 100) == 0) {
					throw new Exception("Bu bloğa ait oda bulunmamaktadır!");
				}
			}
		} catch (NumberFormatException ex) {
			throw new Exception("Oda numarasını doğru formatta yazınız!");
		}
	}

	public int getRandevuHakki() {
		return randevuHakki;
	}

	public void setRandevuHakki(int randevuHakki) {
		this.randevuHakki = randevuHakki;
	}

	public void ekraniCalistir() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		String aktifTC = this.getTC(); // 
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ogrenci_Paneli ranadevuSayfasi = new Ogrenci_Paneli(aktifTC); // TC burayaa
					ranadevuSayfasi.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace(); 
				}
			}
		});
	}
}
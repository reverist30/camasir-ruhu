package camasir.logic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class DosyaYoneticisi {

	private static DosyaYoneticisi instance;

	private final String RANDEVU_DOSYASI = "randevular.txt";
	private final String KULLANICI_DOSYASI = "kullanicilar.txt";
	private final String MEMUR_DOSYASI = "memurlar.txt";

	private DosyaYoneticisi() {
		dosyalariOlustur();
	}

	public static synchronized DosyaYoneticisi getInstance() {
		if (instance == null) {
			instance = new DosyaYoneticisi();
		}
		return instance;
	}

	private void dosyalariOlustur() {
		try {
			File rDosya = new File(RANDEVU_DOSYASI);
			File kDosya = new File(KULLANICI_DOSYASI);
			File mDosya = new File(MEMUR_DOSYASI);
			
			if (!rDosya.exists())
				rDosya.createNewFile();
			if (!kDosya.exists())
				kDosya.createNewFile();
			if (!mDosya.exists()) 
				mDosya.createNewFile();
		} catch (IOException e) {
			System.err.println("Dosya oluşturma hatası: " + e.getMessage());
		}
	}

	public void veriyiKaydet(String veri, boolean randevuMu) {
		String dosyaAdi = randevuMu ? RANDEVU_DOSYASI : KULLANICI_DOSYASI;
		try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(dosyaAdi, true)))) {
			out.println(veri);
		} catch (IOException e) {
			System.err.println("Yazma hatası: " + e.getMessage());
		}
	}

	public List<String> verileriOku(boolean randevuMu) {
		String dosyaAdi = randevuMu ? RANDEVU_DOSYASI : KULLANICI_DOSYASI;
		List<String> satirlar = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(dosyaAdi))) {
			String satir;
			while ((satir = br.readLine()) != null) {
				satirlar.add(satir);
			}
		} catch (IOException e) {
			System.err.println("Okuma hatası: " + e.getMessage());
		}
		return satirlar;
	}
	public String ogrenciIsmiGetir(String arananTC) {
	    java.util.List<String> satirlar = verileriOku(false);
	    for (String satir : satirlar) {
	        String[] bilgiler = satir.split(" - ");
	        if (bilgiler.length >= 2 && bilgiler[1].trim().equals(arananTC)) {
	            return bilgiler[0].trim(); // TC'yi buldu, İSMİ geri yolluyor!
	        }
	    }
	    return null; // TC yoksa boş dönüyor
	}
	public String memurIsmiGetir(String arananTC) {
	    try (java.io.BufferedReader br = new java.io.BufferedReader(new java.io.FileReader(MEMUR_DOSYASI))) {
	        String satir;
	        while ((satir = br.readLine()) != null) {
	            String[] bilgiler = satir.split(" - ");
	            if (bilgiler.length >= 2 && bilgiler[1].trim().equals(arananTC)) {
	                return bilgiler[0].trim(); // TC'yi buldu, İSMİ geri yolluyor!
	            }
	        }
	    } catch (Exception e) {}
	    return null; // TC yoksa boş dönüyor
	}
}
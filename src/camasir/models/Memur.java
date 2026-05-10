package camasir.models;

import java.awt.EventQueue;
import javax.swing.UIManager;
import camasir.ui.Memur_Paneli;

public class Memur extends Kullanici {
	private String personelID;

	public Memur(String tC, String telNo, String tamIsim, String personelID) {
		super(tC, telNo, tamIsim);
		this.personelID = personelID;
	}

	public Memur() {

	}

	public String getPersonelID() {
		return personelID;
	}

	public void setPersonelID(String personelID) {
		this.personelID = personelID;
	}

	public void ekraniCalistir() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); // ekranin modernligi icin
		} catch (Exception e) {
			e.printStackTrace();
		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Memur_Paneli kontrolSayfasi = new Memur_Paneli();
					kontrolSayfasi.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace(); // Hata cıkarsa konsola kirmizi yaziyla firlat
				}
			}
		});
	}
}
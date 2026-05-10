package camasir.ui;

import java.awt.EventQueue;

import javax.swing.UIManager;

public class MAIN_CALISTIRICI {

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); // ekranin modernligi icin
		} catch (Exception e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GirisEkrani ilkEkran = new GirisEkrani();
					ilkEkran.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace(); // Hata cikarsa konsola kirmizi yaziyla firlat
				}
			}
		});
	}
}
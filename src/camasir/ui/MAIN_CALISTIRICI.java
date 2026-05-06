package camasir.ui;

import java.awt.EventQueue;

public class MAIN_CALISTIRICI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
	        public void run() {
	            try {
	            	GirisEkrani ilkEkran = new GirisEkrani();
	            	ilkEkran.setVisible(true);
	            } catch (Exception e) {
	                e.printStackTrace(); // Hata çıkarsa konsola kırmızı yazıyla fırlat
	            }
	        }
	    });

	}

}

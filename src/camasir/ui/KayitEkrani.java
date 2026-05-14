package camasir.ui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import camasir.models.Ogrenci;

public class KayitEkrani extends JDialog {
	private static final long serialVersionUID = 1L;

	public KayitEkrani() {
		this.setTitle("Randevu Kayıt Ekranı");
		this.setSize(500, 400); // pencerenin boyutlari icin
		setLocationRelativeTo(null); // pencerenin ekranin tam ortasinda olmasi icin
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE); // kapatma tusu
		this.setModal(true); // arkada acık olan ekrani dondurur.
		this.setLayout(null); // otomatik yerlesimi iptal
		this.getContentPane().setBackground(new Color(200, 220, 255)); // arka plan rengi
		this.setResizable(false); // boyut degisimi kapali

		String[] bloklar = { "A Blok", "B Blok", "C Blok", "D Blok", "E Blok" };
		JComboBox<String> secimKutusu = new JComboBox<>(bloklar);
		secimKutusu.setBounds(125, 150, 70, 30);
		this.add(secimKutusu);

		JTextField[] txtKayit = new JTextField[4];
		
		for (int i = 0; i < txtKayit.length; i++) {
			txtKayit[i] = new JTextField();
			txtKayit[i].setBounds(125, 50 + (i * 50), 250, 30);
			this.add(txtKayit[i]);
			if (i == 2) {
				txtKayit[i].setBounds(195, 50 + (i * 50), 180, 30);
			}
		}
		
		JButton btnKayit = new JButton("Kayıt işlemini yap");
		btnKayit.setForeground(Color.BLACK);
		btnKayit.setFont(new Font("Arial", Font.BOLD, 14));
		btnKayit.setBounds(150, 280, 180, 30);
		btnKayit.setOpaque(true);
		btnKayit.setBorderPainted(false);
		btnKayit.setBackground(new Color(255, 240, 150));
		btnKayit.setFocusPainted(false);
		this.add(btnKayit);

		JLabel[] lblKayit = new JLabel[5];
		lblKayit[0] = new JLabel("İsim Soyisim:");
		lblKayit[1] = new JLabel("TC kimlik numaranız:");
		lblKayit[2] = new JLabel("Oda numaranız:");
		lblKayit[3] = new JLabel("Telefon numarası:");
		lblKayit[4] = new JLabel("");
		
		for (int i = 0; i < lblKayit.length; i++) {
			if (i == 4) {
				lblKayit[i].setFont(new Font("Tahoma", Font.BOLD, 14));
				lblKayit[i].setForeground(Color.RED);
				lblKayit[i].setBounds(125, 30 + (i * 50), 400, 20);
			} else {
				lblKayit[i].setFont(new Font("Arial", Font.PLAIN, 14));
				lblKayit[i].setBounds(125, 30 + (i * 50), 300, 20);
			}

			this.add(lblKayit[i]);
		}
		//////////////////////////////////////////////////////////////
		btnKayit.addActionListener(e -> {
			for (int i = 0; i < txtKayit.length; i++) {
				if (txtKayit[i].getText().trim().isEmpty()) {
					lblKayit[4].setText("Hatalı Giriş! Boşlukları doldurunuz.");
					return;
				}
			}
			String ogrIsim = txtKayit[0].getText().trim();
			String ogrTC = txtKayit[1].getText().trim();
			String ogrOdaNo = txtKayit[2].getText().trim();
			String ogrTelNo = txtKayit[3].getText().trim();
		//	int blokIndex = secimKutusu.getSelectedIndex();

			java.util.List<String> kayitliKullanicilar = camasir.logic.DosyaYoneticisi.getInstance().verileriOku(false);
			boolean tcKayitliMi = false;
			
			for (String satir : kayitliKullanicilar) {
				if (satir.contains(ogrTC)) {
					tcKayitliMi = true;
					break; // Buldugumuz an donguyu durdur
				}
			}
			if (tcKayitliMi) {
				lblKayit[2].setText("Hata! Bu TC numarası sistemde zaten kayıtlıdır.");
				return;
			}
			/*
			if(ogrTC.length() != 11) {
				lblKayit[4].setText("Hatalı Giriş! TC 11 haneli olmalı!"); 
				return; 
				} 
			
			int	katSayisi = 9;
			int herKatOda= 30; 
			
			if(blokIndex == 3 || blokIndex == 4) {
				katSayisi = 5; 
				herKatOda= 4;  
			}
			try{ 
				if(ogrOdaNo.toLowerCase().startsWith("z")) { 
					int sayi = Integer.parseInt(ogrOdaNo.substring(1)); // oda numarasinin ilk basamagi atilarak integera çevrildi 
						if(1 > sayi || sayi > herKatOda) {			
							lblKayit[4].setText("Bu numaraya ait oda bulunmamaktadır!"); 
							return; 
						} 
				} else { 
					int sayi = Integer.parseInt(ogrOdaNo); 
					if((sayi/100) > katSayisi || (sayi % 100) > herKatOda || (sayi % 100) == 0) {
						lblKayit[4].setText("Bu numaraya ait oda bulunmamaktadır!"); 
						return; 
					} 
				}
			} catch(NumberFormatException ex) {
				lblKayit[4].setText("Hata! Oda numarasını doğru formatta yazınız!"); 
				return;  
			} if(ogrTelNo.length() != 10) {
				lblKayit[4].setText("Hata! Telefon numaranız 10 haneli olmalı!"); 
				return; 
			}
			
			*/
			try {
				Ogrenci yeniKayit = new Ogrenci(ogrTC, ogrTelNo, ogrIsim, secimKutusu.getSelectedItem() + "-" + ogrOdaNo,
						 0);
				String kaydedilecekVeri = ogrIsim + " - " + ogrTC + " - " + secimKutusu.getSelectedItem() + " - "
						+ ogrOdaNo + " - " + ogrTelNo;
				camasir.logic.DosyaYoneticisi.getInstance().veriyiKaydet(kaydedilecekVeri, false);
				JOptionPane.showMessageDialog(this, "Kayıt başarıyla tamamlandı.");
				this.dispose();
			} catch (Exception ex) {
				lblKayit[4].setText("Hatalı Giriş!" + ex.getMessage());
				ex.printStackTrace(); // yazilimciya bildiri
				return;
			}
		});
	}
}
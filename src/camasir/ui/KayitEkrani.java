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
	public KayitEkrani(){
		 this.setTitle("Randevu Kayit Ekrani");   
		 this.setSize(500,400);                //pencerenin boyutlari için
		 setLocationRelativeTo(null);         //pencerenin ekranin tam ortasinda olmasi icin
		 this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);       //kapatma tuşu
		 this.setModal(true);               //arkada açık olan ekranı dondurur.
		 this.setLayout(null);               //otomatik yerleşimi iptal
		 this.getContentPane().setBackground(new Color(200, 220, 255));         //arka plan rengi
		 this.setResizable(false);            //boyut değişimi kapalı
		 
		 JTextField[] txtKayit = new JTextField[4];
         for(int i=0;i<txtKayit.length;i++) {
        	 txtKayit[i] = new JTextField();
        	 txtKayit[i].setBounds(125,50+(i*50), 250,30);
        	 this.add(txtKayit[i]);
         }
         String[] bloklar = {"A Blok", "B Blok", "C Blok", "D Blok", "E Blok"};
         JComboBox<String> secimKutusu = new JComboBox<>(bloklar);
         secimKutusu.setBounds(50,150,90,30);
         this.add(secimKutusu);
		 
		 JButton btnKayit = new JButton("Kayit işlemini yap");
		 btnKayit.setForeground(Color.BLACK);
		 btnKayit.setFont(new Font("Arial", Font.BOLD, 14));
		 btnKayit.setBounds(150,280,180,30);  
		 btnKayit.setOpaque(true);
		 btnKayit.setBorderPainted(false);
		 btnKayit.setBackground(new Color(255, 240, 150));
		 btnKayit.setFocusPainted(false);
		 this.add(btnKayit);
		 
		 JLabel[] lblKayit = new JLabel[5];
		 lblKayit[0]= new JLabel("İsim Soyisim:");
		 lblKayit[1]= new JLabel("TC kimlik numaranız:");
		 lblKayit[2]= new JLabel("Oda numaranız:");
		 lblKayit[3]= new JLabel("Telefon numarası:");
		 lblKayit[4]= new JLabel("");
		 for(int i=0;i<lblKayit.length;i++) { 
			 if(i==4) {
				 lblKayit[i].setFont(new Font("Tahoma", Font.BOLD, 14));
				 lblKayit[i].setForeground(Color.RED);
				 lblKayit[i].setBounds(60,30+(i*50),400,20);
			 }else {
				 lblKayit[i].setFont(new Font("Arial", Font.PLAIN, 14));
				 lblKayit[i].setBounds(125,30+(i*50),300,20);
			 }
			 
			 this.add(lblKayit[i]);
		 }
		  //////////////////////////////////////////////////////////////
		 btnKayit.addActionListener(e -> {
			 for(int i=0;i<txtKayit.length;i++) {
				 if(txtKayit[i].getText().trim().isEmpty()) {
					 lblKayit[4].setText("Hatalı Giriş! Boşlukları doldurunuz.");
					 return;			 
				 }
			 }
			 String ogrIsim = txtKayit[0].getText().trim();
			 String ogrTC = txtKayit[1].getText().trim();
			 String ogrOdaNo = txtKayit[2].getText().trim();
			 String ogrTelNo = txtKayit[3].getText().trim();
			 int blokIndex = secimKutusu.getSelectedIndex();
			 if(ogrTC.length()!=11) {
				 lblKayit[4].setText("Hatalı Giriş! TC 11 haneli olmalı!");
				 return ;
			 } if(ogrTC.equals("11111111111")) {
				 lblKayit[4].setText("Hata! Bu öğrenci sistemde kayitlidir.");
				 return ;
			 } if(blokIndex==3||blokIndex==4) {
				 try {				 
					 if(ogrOdaNo.toLowerCase().startsWith("z")) {
						 int sayi = Integer.parseInt(ogrOdaNo.substring(1));      //oda numarasının ilk basamağı atılarak integera çevrildi
						 if(1>sayi || sayi>4 ) {
							 lblKayit[4].setText("Hatalı Giriş! D ve E bloklarda bu numaraya ait oda bulunmamaktadir!");
							 return ;
						 }
					 }else {
						 int sayi = Integer.parseInt(ogrOdaNo);
						 if((sayi/100)>5 ||(sayi%100)>4 || (sayi%100)==0) {
							 lblKayit[4].setText("Hatalı Giriş! D ve E bloklarında bu numaraya ait oda bulunmamaktadir!");
							 return ;
						 }
					 }				 
			     }catch(NumberFormatException ex) {
			    	 
			     }
					 
				 return ;
			 } if(ogrTelNo.length()!=10){
				 lblKayit[4].setText("Hatalı Giriş! Telefon numaraniz 10 haneli olmalı!");
				 return ;
			 }
			    try {
					 Ogrenci yeniKayit = new Ogrenci(ogrIsim, secimKutusu.getSelectedItem() + ogrTC, ogrOdaNo, ogrTelNo, 0);
					 //Safanın kayıt fonksiyonu gelecek
					 JOptionPane.showMessageDialog(this,"Kayit başariyla tamamlandi.");
					 this.dispose();
				 }catch(Exception ex) {
					 JOptionPane.showMessageDialog(this, "Kayıt sırasında bir hata oluştu!");
					 ex.printStackTrace();            //yazılımcıya bildiri
				 }

			
			});
	}

}

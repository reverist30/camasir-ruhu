package camasir.ui;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GirisEkrani extends JFrame {
	public GirisEkrani() {
		 this.setTitle("Camasir Randevu Sistemi");   
		 this.setSize(1000,600);                //pencerenin boyutları için
		 setLocationRelativeTo(null);         //pencerenin ekranın tam ortasında olması için
		 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 this.setLayout(null);
		 this.setBackground(Color.BLUE);
		 
		 JTextField[] txtGiris = new JTextField[2];
		 txtGiris[0] = new JTextField();
		 txtGiris[1] = new JTextField();
		 txtGiris[0].setBounds(250,100, 450,50);
		 txtGiris[1].setBounds(250,170, 450,50);
		 this.add(txtGiris[0]);
		 this.add(txtGiris[1]);
		 
		 JButton btnGiris = new JButton("Giris");
		 btnGiris.setBounds(420,220, 120,45);
		 btnGiris.setBackground(Color.GREEN);
		 this.add(btnGiris);
		 
		 JLabel[] lblGiris = new JLabel[3];
		 lblGiris[0]= new JLabel("İsminizi yazınız");
		 lblGiris[1]= new JLabel("TC kimlik numaranızı yazınız");
		 lblGiris[2]= new JLabel("");
		 lblGiris[2].setForeground(Color.RED);        //yazının rengi 
		 lblGiris[0].setBounds(250,80,700,20); 
		 lblGiris[1].setBounds(250,150,700,20);
		 lblGiris[2].setBounds(380,270,700,20);
		 this.add(lblGiris[0]); 
		 this.add(lblGiris[1]);
		 this.add(lblGiris[2]);
		 btnGiris.addActionListener(e -> {
			 String ogrTC = txtGiris[1].getText();
			 if(ogrTC.equals("11111111111")) {
					MainDashboard frame = new MainDashboard();
					frame.setVisible(true);
					this.dispose();		 
			 }else if(ogrTC.equals("22222222222")) {
					CamasirApp frame = new CamasirApp();
					frame.setVisible(true);
					this.dispose();
			 }else {
				 lblGiris[2].setText("Hatalı Giriş! Bu TC sistemde kayıtlı değil.");
			 }
			});
		 
		 
		 

	}
	

}

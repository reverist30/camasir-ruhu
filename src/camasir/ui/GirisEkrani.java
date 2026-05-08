package camasir.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class GirisEkrani extends JFrame {
	public GirisEkrani() {
		 this.setTitle("Camasir Randevu Sistemi");   
		 this.setSize(1000,600);                //pencerenin boyutlari için
		 setLocationRelativeTo(null);         //pencerenin ekranin tam ortasinda olmasi icin
		 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 this.setLayout(null);
		 this.getContentPane().setBackground(new Color(200, 220, 255));
		 
		 JTextField[] txtGiris = new JTextField[2];
		 txtGiris[0] = new JTextField();
		 txtGiris[1] = new JTextField();
		 txtGiris[0].setBounds(250,100, 450,50);
		 txtGiris[1].setBounds(250,170, 450,50);
		 this.add(txtGiris[0]);
		 this.add(txtGiris[1]);
		 
		 JButton btnGiris = new JButton("Giris");
		 btnGiris.setForeground(Color.BLACK);
		 btnGiris.setFont(new Font("Arial", Font.BOLD, 14));
		 btnGiris.setBounds(420,250, 120,45);
		 btnGiris.setOpaque(true);
		 btnGiris.setBorderPainted(false);
		 btnGiris.setBackground(new Color(100, 200, 120));
		 btnGiris.setFocusPainted(false);
		 this.add(btnGiris);
		 
		 JLabel[] lblGiris = new JLabel[3];
		 lblGiris[0]= new JLabel("İsminizi yazınız");
		 lblGiris[1]= new JLabel("TC kimlik numaranızı yazınız");
		 lblGiris[2]= new JLabel("");
		 lblGiris[0].setBounds(250,80,700,20); 
		 lblGiris[1].setBounds(250,150,700,20);
		 lblGiris[2].setBounds(290,330,700,50);
		 for(int i=0;i<lblGiris.length;i++) {
			 if(i==0||i==1) {
				 lblGiris[i].setFont(new Font("Arial", Font.PLAIN, 14));				 
			 }else {
				 lblGiris[i].setFont(new Font("Tahoma", Font.BOLD, 24));
				 lblGiris[i].setForeground(Color.RED);
			 }
			 this.add(lblGiris[i]);
		 }
		 
		 
		 
		 
	/*	 lblGiris[2].setForeground(Color.RED);        //yazının rengi 
		 lblGiris[3].setForeground(Color.RED);
		 lblGiris[0].setFont(new Font("Arial", Font.PLAIN, 14));
		 lblGiris[1].setFont(new Font("Arial", Font.PLAIN, 14));
		 lblGiris[0].setBounds(250,80,700,20); 
		 lblGiris[1].setBounds(250,150,700,20);
		 lblGiris[2].setBounds(380,330,700,20);
		 lblGiris[3].setBounds(380,330,700,20);
		 this.add(lblGiris[0]); 
		 this.add(lblGiris[1]);
		 this.add(lblGiris[2]);
		 this.add(lblGiris[3]);
	*/	 
		 btnGiris.addActionListener(e -> {
			 String ogrIsim = txtGiris[0].getText().trim();
			 String ogrTC = txtGiris[1].getText().trim();
			 if(ogrIsim.isEmpty() || ogrTC.isEmpty()) {
				 lblGiris[2].setText("Hatalı Giriş! Boşlukları doldurunuz.");
				 return;
			 
			 }if(ogrTC.length()!=11) {
				 lblGiris[2].setText("Hatalı Giriş! TC 11 haneli olmalı!");
				 return ;
			 }else if(ogrTC.equals("11111111111")) {
				   if(!ogrIsim.equalsIgnoreCase("Merve")) {
					 lblGiris[2].setText("Hatalı Giriş! TC ile isim uyuşmamaktadır.");	
					 return ;
			     }else {
						MainDashboard frame = new MainDashboard();
						frame.setVisible(true);
						this.dispose();	
						return ;
			     }
	 
			 }else if(ogrTC.equals("22222222222")) {
				 if(!ogrIsim.equalsIgnoreCase("Belkıs")) {
					 lblGiris[2].setText("Hatalı Giriş! TC ile isim uyuşmamaktadır.");		
					 return ;
				 }else {
						CamasirApp frame = new CamasirApp();
						frame.setVisible(true);
						this.dispose();
						return ;
				 }

			 }else {
				 lblGiris[2].setText("Hatalı Giriş! Önce kayıt olunuz.");
				 return ;
			 }
			});
		 
		 
		 

	}
	

}

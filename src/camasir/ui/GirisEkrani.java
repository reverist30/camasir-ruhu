package camasir.ui;
import javax.swing.*;

public class GirisEkrani extends JFrame {
	public GirisEkrani() {
		 this.setTitle("Camasir Randevu Sistemi");   
		 this.setSize(1000,600);                //pencerenin boyutlari için
		 setLocationRelativeTo(null);         //pencerenin ekranin tam ortasinda olmasi icin
		 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 this.setLayout(null);
		 JTextField[] txtGiris = new JTextField[2];
		 txtGiris[0] = new JTextField();
		 txtGiris[1] = new JTextField();
		 txtGiris[0].setBounds(250,100, 450,50);
		 txtGiris[1].setBounds(250,150, 450,50);
		 this.add(txtGiris[0]);
		 this.add(txtGiris[1]);
		 JButton btnGiris = new JButton("Giris");
		 btnGiris.setBounds(400,220, 120,45);
		 this.add(btnGiris);
		 JLabel lblGiris = new JLabel("İsminizi ve Tc kimlik numaranızı giriniz:");
		 lblGiris.setBounds(300,50,700,50);
		 this.add(lblGiris);
		 
		 
		 

	}
	

}

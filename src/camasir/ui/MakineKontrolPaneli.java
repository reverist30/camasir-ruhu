package camasir.ui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import camasir.models.YikamaMakinesi;

	public class MakineKontrolPaneli extends JFrame {

	    // Arka plan verileri burayaa
	    private YikamaMakinesi makine;

	    // Arayuz Elemanlari
	    private JComboBox<Integer> cbSicaklik;
	    private JComboBox<Integer> cbDevir;
	    private JComboBox<String> cbMod;
	    private JButton btnHizliAyar;
	    private JButton btnBaslat;

	    public MakineKontrolPaneli() {
	        // Varsayilan degerlerle modeli baslat
	        makine = new YikamaMakinesi();

	        // Pencere Ayarlari
	        setTitle("Çamaşır Ruhu - Kontrol Paneli");
	        setSize(450, 400);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setLayout(new GridLayout(6, 2, 10, 10)); // Duzenli bir gorunum icin Grid
	        setLocationRelativeTo(null);

	        // Bilesenleri olusturma ve JComboBox entegrasyonu
	        add(new JLabel(" Yıkama Modu:"));
	        String[] modlar = {"Pamuklu", "Sentetik", "Narin", "Eko 40-60"};
	        cbMod = new JComboBox<>(modlar);
	        add(cbMod);

	        add(new JLabel(" Sıcaklık (°C):"));
	        Integer[] sicakliklar = {20, 30, 40, 60, 90};
	        cbSicaklik = new JComboBox<>(sicakliklar);
	        add(cbSicaklik);

	        add(new JLabel(" Sıkma Devri (RPM):"));
	        Integer[] devirler = {600, 800, 1000, 1200};
	        cbDevir = new JComboBox<>(devirler);
	        add(cbDevir);

	        // Butonlar
	        btnHizliAyar = new JButton("Hızlı Ayar (Standart)");
	        btnHizliAyar.setBackground(Color.LIGHT_GRAY);
	        
	        btnBaslat = new JButton("PROGRAMI BAŞLAT");
	        btnBaslat.setBackground(new Color(144, 238, 144)); // Açık yeşil

	        add(btnHizliAyar);
	        add(btnBaslat);

	        // ActionListener Yapılari (Veri Akısini Saglayan Kisim)
	        
	        // HIZLI AYAR BUTONU MANTIGI
	        btnHizliAyar.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                // Parametre almayan ayarla()
	                // burada JComboBox'lari standart degerlere ayarliyor
	                cbSicaklik.setSelectedItem(40);
	                cbDevir.setSelectedItem(800);
	                cbMod.setSelectedItem("Pamuklu");
	                
	                JOptionPane.showMessageDialog(null, "Hızlı Ayar Uygulandı: 40°C, 800 Devir");
	            }
	        });

	        // Baslat dugmesi
	        btnBaslat.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                // Secilen verileri modele aktar
	                int secilenSicaklik = (Integer) cbSicaklik.getSelectedItem();
	                int secilenDevir = (Integer) cbDevir.getSelectedItem();
	                String secilenMod = (String) cbMod.getSelectedItem();

	                // Modeldeki degişkenleri guncelle
	                makine.setSicaklik(secilenSicaklik);
	                makine.setDevir(secilenDevir);
	                makine.setMod(secilenMod);

	                // Ekrana çikti ver (Simdilik konsola veriyor)
	                System.out.println("Makine Çalışıyor: " + makine.getMod() + " modunda...");
	                JOptionPane.showMessageDialog(null, "Yıkama Başladı!\nSüre: " + makine.getSure() + " dakika.");
	            }
	        });
	    }

	    public static void main(String[] args) {
	        // Arayuzu çalistir
	        SwingUtilities.invokeLater(() -> {
	            new MakineKontrolPaneli().setVisible(true);
	        });
	    }
	}


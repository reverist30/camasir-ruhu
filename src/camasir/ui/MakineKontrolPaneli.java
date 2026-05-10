package camasir.ui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import camasir.models.KurutmaMakinesi;
import camasir.models.YikamaMakinesi;
import camasir.ui.Ogrenci_Paneli;
import camasir.ui.Memur_Paneli;

public class MakineKontrolPaneli extends javax.swing.JDialog {
	private static final long serialVersionUID = 1L;
	// Modeller
	private YikamaMakinesi yikamaModel = new YikamaMakinesi();
	private KurutmaMakinesi kurutmaModel = new KurutmaMakinesi(40, 30, 5, 0, "Standart", "Beyaz", "Dolap Kurulugu",
			"Isi Pompali");

	// Ortak Bilesenler
	private JComboBox<String> cbMakineTuru, cbMod;
	private JComboBox<Integer> cbSicaklik;
	private CardLayout cardLayout = new CardLayout();
	private JPanel dinamikPanel;

	// Yikamaya Ozel
	private JComboBox<Integer> cbDevir;

	// Kurutmaya Ozel
	private JComboBox<String> cbKurutmaDerecesi;

	public MakineKontrolPaneli(java.awt.Frame parent) {
		super(parent, true);
		UIManager.put("Label.foreground", Color.BLACK);
        UIManager.put("Button.foreground", Color.BLACK);
        this.setTitle("Makine Ayarları");
        this.setLocationRelativeTo(parent);
        
        this.setTitle("Makine Ayarları");
        this.setLocationRelativeTo(parent);
		setTitle("Makineyi Ayarla");
		setSize(400, 500);
		this.setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout(10, 10));

		// --- UST ALAN (Secimler) ---
		JPanel ustPanel = new JPanel(new GridLayout(3, 2, 5, 5));
		ustPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

		ustPanel.add(new JLabel("Makine Türü:"));
		cbMakineTuru = new JComboBox<>(new String[] { "Yıkama Makinesi", "Kurutma Makinesi" });
		ustPanel.add(cbMakineTuru);

		ustPanel.add(new JLabel("Program Modu:"));
		cbMod = new JComboBox<>(new String[] { "Pamuklu", "Sentetik", "Hızlı", "Eko" });
		ustPanel.add(cbMod);

		ustPanel.add(new JLabel("Sıcaklık (°C):"));
		cbSicaklik = new JComboBox<>(new Integer[] { 30, 40, 60, 90 });
		ustPanel.add(cbSicaklik);

		add(ustPanel, BorderLayout.NORTH);

		// --- ORTA ALAN (Dinamik Degisen Kisim) ---
		dinamikPanel = new JPanel(cardLayout);

		// Yikama Sayfasi
		JPanel pYikama = new JPanel(new FlowLayout());
		pYikama.setBorder(new TitledBorder("Yıkama Ayarları"));
		pYikama.add(new JLabel("Sıkma Devri:"));
		cbDevir = new JComboBox<>(new Integer[] { 600, 800, 1000, 1200 });
		pYikama.add(cbDevir);

		// Kurutma Sayfasi
		JPanel pKurutma = new JPanel(new FlowLayout());
		pKurutma.setBorder(new TitledBorder("Kurutma Ayarları"));
		pKurutma.add(new JLabel("Kuruluk Seviyesi:"));
		cbKurutmaDerecesi = new JComboBox<>(new String[] { "Ütü Kuruluğu", "Dolap Kuruluğu", "Ekstra Kuru" });
		pKurutma.add(cbKurutmaDerecesi);

		dinamikPanel.add(pYikama, "Yıkama");
		dinamikPanel.add(pKurutma, "Kurutma");
		add(dinamikPanel, BorderLayout.CENTER);

		// --- ALT ALAN (Butonlar) ---
		JPanel altPanel = new JPanel(new GridLayout(2, 1, 5, 5));
		altPanel.setBorder(new EmptyBorder(0, 10, 10, 10));

		JButton btnHizliAyar = new JButton("Hızlı Ayar (Varsayılan)");
		JButton btnBaslat = new JButton("SİSTEMİ BAŞLAT");
		btnBaslat.setBackground(new Color(144, 238, 144));

		altPanel.add(btnHizliAyar);
		altPanel.add(btnBaslat);
		add(altPanel, BorderLayout.SOUTH);

		// --- OLAYLAR (Listeners) ---

		// Makine turu degisince paneli degistir
		cbMakineTuru.addActionListener(e -> {
			if (cbMakineTuru.getSelectedIndex() == 0)
				cardLayout.show(dinamikPanel, "Yıkama");
			else
				cardLayout.show(dinamikPanel, "Kurutma");
		});

		// Hizli Ayar Butonu
		btnHizliAyar.addActionListener(e -> {
			cbSicaklik.setSelectedItem(40);
			cbMod.setSelectedIndex(0);
			if (cbMakineTuru.getSelectedIndex() == 0)
				cbDevir.setSelectedItem(800);
			JOptionPane.showMessageDialog(this, "Varsayılan ayarlar yüklendi.");
		});

		btnBaslat.addActionListener(e -> {
			int sicaklik = (int) cbSicaklik.getSelectedItem();
			String mod = (String) cbMod.getSelectedItem();

			if (cbMakineTuru.getSelectedIndex() == 0) { // Yikama
				int devir = (int) cbDevir.getSelectedItem();
				yikamaModel.setSicaklik(sicaklik);
				yikamaModel.setMod(mod);
				yikamaModel.setDevir(devir);
				JOptionPane.showMessageDialog(this, "Yıkama işlemi " + sicaklik + " derecede başlatıldı!");
			} else { // Kurutma
				kurutmaModel.setSicaklik(sicaklik);
				kurutmaModel.setMod(mod);
				JOptionPane.showMessageDialog(this, "Kurutma işlemi başlatıldı!");
			}
		});
	}

	// 1. Parametresiz (Hizli Ayar)
	public void ayarla() {
		cbSicaklik.setSelectedItem(40);
		cbMod.setSelectedIndex(0);
		if (cbMakineTuru.getSelectedIndex() == 0) {
			cbDevir.setSelectedItem(800);
		}
		JOptionPane.showMessageDialog(this, "Hızlı Ayar Uygulandı.");
	}

	// 2. Parametreli (Ozel Ayar)
	public void ayarla(int sicaklik, String mod, int devir) {
		cbSicaklik.setSelectedItem(sicaklik);
		cbMod.setSelectedItem(mod);
		if (cbMakineTuru.getSelectedIndex() == 0) {
			cbDevir.setSelectedItem(devir);
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new MakineKontrolPaneli().setVisible(true));
	}
}
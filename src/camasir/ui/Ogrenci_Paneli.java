package camasir.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.time.LocalDateTime;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import camasir.logic.CamasirYonetim;
import camasir.logic.DosyaYoneticisi;

public class Ogrenci_Paneli extends JFrame {
	private static final long serialVersionUID = 1L;
	private String aktifOgrenciTC;
	private JComboBox<String> cbGunler;
	private JButton[] saatButonlari; // Butonlari hafizada tutmak icin dizi

	public Ogrenci_Paneli(String aktifOgrenciTC) {
		this.aktifOgrenciTC = aktifOgrenciTC; // Giris yapanin gercek TC'si
		this.setTitle("Öğrenci Randevu Sistemi - TC: " + aktifOgrenciTC);
		this.setSize(1000, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		// --- UST PANEL (Gun Secimi) ---
		JPanel headerPanel = new JPanel();
		headerPanel.add(new JLabel("Randevu Günü Seçiniz: "));
		String[] gunler = { "Pazartesi", "Salı", "Çarşamba", "Perşembe", "Cuma", "Cumartesi", "Pazar" };
		cbGunler = new JComboBox<>(gunler);
		headerPanel.add(cbGunler);
		this.add(headerPanel, BorderLayout.NORTH);
		JButton btnCikis = new JButton("Çıkış Yap");
		btnCikis.setBackground(new Color(231, 76, 60)); // Kırmizimsi bir renk
		btnCikis.setForeground(Color.WHITE);

		btnCikis.addActionListener(e -> {
			this.dispose(); // Mevcut paneli kapat
			new GirisEkrani().setVisible(true); // Giris ekranini yeniden ac
		});
		headerPanel.add(btnCikis);

		// --- ORTA PANEL (Saat Butonlari) ---
		JPanel buttonPanel = new JPanel(new GridLayout(4, 4, 15, 15));
		buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		saatButonlari = new JButton[12]; // 09:00'dan 20:00'a kadar 12 buton

		for (int i = 0; i < 12; i++) {
			String saat = String.format("%02d:00", i + 9);
			saatButonlari[i] = new JButton(saat);
			saatButonlari[i].setFont(new Font("Tahoma", Font.BOLD, 14));

			saatButonlari[i].addActionListener(e -> {
				JButton basilanButon = (JButton) e.getSource();
				String secilenSaat = basilanButon.getText();
				String secilenGun = (String) cbGunler.getSelectedItem();
				CamasirYonetim yonetim = new CamasirYonetim();

				// Iptal kontrolu:
				// Eger buton kirmiziysa (saatMusaitMi = false) ve bu randevu bu ogrenciye aitse
				if (!yonetim.saatMusaitMi(secilenGun, secilenSaat)) {
					int iptalOnay = JOptionPane.showConfirmDialog(this,
							secilenGun + " " + secilenSaat + " randevunuzu iptal etmek istiyor musunuz?",
							"Randevu İptali", JOptionPane.YES_NO_OPTION);

					if (iptalOnay == JOptionPane.YES_OPTION) {
						DosyaYoneticisi.getInstance().randevuIptalEt(aktifOgrenciTC, secilenSaat);
						JOptionPane.showMessageDialog(this, "Randevunuz iptal edildi.");
						butonlariGuncelle(); // Butonlari tekrar yesil yapar
					}
					return;
				}

				// Yeni randevu oncesi makine ekrani
				// Haftalik sinir kontrolu
				if (!yonetim.randevuHakkiVarMi(aktifOgrenciTC)) {
					JOptionPane.showMessageDialog(this, "Hata: Haftalık 3 randevu sınırına ulaştınız!");
					return;
				}

				// Makine secim ekranini ac
				JOptionPane.showMessageDialog(this, "Randevu öncesi makine ayarlarınızı yapın.");
				MakineKontrolPaneli makineEkrani = new MakineKontrolPaneli();
				makineEkrani.setVisible(true);

				// Onay ve kayit
				int onay = JOptionPane.showConfirmDialog(this,
						secilenGun + " günü " + secilenSaat + " için randevuyu onaylıyor musunuz?", "Randevu Onayı",
						JOptionPane.YES_NO_OPTION);

				if (onay == JOptionPane.YES_OPTION) {
					String kayitVerisi = aktifOgrenciTC + " | " + secilenGun + " | " + secilenSaat + " | "
							+ LocalDateTime.now();
					DosyaYoneticisi.getInstance().veriyiKaydet(kayitVerisi, true);
					butonlariGuncelle();
					JOptionPane.showMessageDialog(this, "Randevunuz başarıyla oluşturuldu.");
				}
			});
			buttonPanel.add(saatButonlari[i]);
		}
		this.add(buttonPanel, BorderLayout.CENTER);

		// Gun degistiginde butonlari yeniden renklendir
		cbGunler.addActionListener(e -> butonlariGuncelle());

		// Ekran ilk acildiğinda butonlari renklendir
		butonlariGuncelle();
	}

	// Dolu saatleri Kirmizi, bos saatleri Yesil yapan metot
	private void butonlariGuncelle() {
		CamasirYonetim yonetim = new CamasirYonetim();
		String secilenGun = (String) cbGunler.getSelectedItem();

		for (JButton btn : saatButonlari) {
			String saat = btn.getText();
			if (!yonetim.saatMusaitMi(secilenGun, saat)) {
				btn.setBackground(Color.RED); // Doluysa kirmizi ve tiklanamaz
				btn.setForeground(Color.WHITE);
			} else {
				btn.setBackground(new Color(46, 204, 113)); // Bossa yesil ve tiklanabilir
				btn.setForeground(Color.WHITE);
				btn.setEnabled(true);
			}
		}
	}
}
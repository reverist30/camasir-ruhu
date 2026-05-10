package camasir.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime; //  Tarih ve saat islemleri icin

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import camasir.logic.CamasirYonetim;
import camasir.logic.DosyaYoneticisi;

public class Ogrenci_Paneli extends JFrame {
	private static final long serialVersionUID = 1L;

	public Ogrenci_Paneli() {
		this.setTitle("Öğrenci Randevu Sistemi");
		this.setSize(1000, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JPanel headerPanel = new JPanel();
		headerPanel.add(new JLabel("Lütfen uygun bir saat seçerek randevunuzu oluşturun."));
		this.add(headerPanel, BorderLayout.NORTH);

		JPanel buttonPanel = new JPanel(new GridLayout(4, 4, 15, 15));
		buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

		for (int i = 9; i <= 20; i++) {
			String saat = String.format("%02d:00", i);
			JButton btn = new JButton(saat);

			btn.setBackground(new Color(46, 204, 113));
			btn.setForeground(Color.WHITE);
			btn.setFont(new Font("Tahoma", Font.BOLD, 14));

			btn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					CamasirYonetim yonetim = new CamasirYonetim();
					String aktifOgrenciTC = "12345678901"; // Burasi giris yapan ogrenciden gelecek
					
					// Haftalik sinir kontrolu
					if (!yonetim.randevuHakkiVarMi(aktifOgrenciTC)) {
						JOptionPane.showMessageDialog(null, "Hata: Haftalık maksimum 3 randevu sınırına ulaştınız!");
						return;
					}
					
					// Saat çakismasi kontrolu
					if (!yonetim.saatMusaitMi(saat)) {
						JOptionPane.showMessageDialog(null, "Hata: Bu saat başka bir öğrenci tarafından alınmış!");
						btn.setBackground(Color.RED); // Butonu kirmizi yap
						btn.setEnabled(false);
						return;
					}
					
					int onay = JOptionPane.showConfirmDialog(null, saat + " için randevu onaylıyor musunuz?",
							"Randevu Onayı", JOptionPane.YES_NO_OPTION);
					if (onay == JOptionPane.YES_OPTION) {
						String kayitVerisi = aktifOgrenciTC + " | " + saat + " | " + LocalDateTime.now();
						DosyaYoneticisi.getInstance().veriyiKaydet(kayitVerisi, true);
						btn.setBackground(Color.RED);
						btn.setEnabled(false);
						JOptionPane.showMessageDialog(null, "Randevunuz başarıyla oluşturuldu.");
					}
				}
			});
			buttonPanel.add(btn);
		}

		this.add(buttonPanel, BorderLayout.CENTER);
	}
}
package camasir.ui;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import camasir.logic.DosyaYoneticisi;

public class Memur_Paneli extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTable randevuTablosu;
	private DefaultTableModel model;

	public Memur_Paneli() {
		this.setTitle("Memur Kontrol Paneli - Yönetim");
		this.setSize(1000, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		String[] kolonlar = { "Randevu ID", "Öğrenci Bilgisi", "Saat", "Durum" };
		model = new DefaultTableModel(kolonlar, 0);
		randevuTablosu = new JTable(model);
		JScrollPane scrollPane = new JScrollPane(randevuTablosu);

		JPanel altPanel = new JPanel();
		JButton btnGuncelle = new JButton("Listeyi Yenile");
		JButton btnIptal = new JButton("Seçili Randevuyu İptal Et");

		btnGuncelle.addActionListener(e -> listeyiYenile());

		altPanel.add(btnGuncelle);
		altPanel.add(btnIptal);

		this.add(new JLabel("Sistemdeki Aktif Randevular", SwingConstants.CENTER), BorderLayout.NORTH);
		this.add(scrollPane, BorderLayout.CENTER);
		this.add(altPanel, BorderLayout.SOUTH);

		listeyiYenile();
	}

	private void listeyiYenile() {
		model.setRowCount(0);
		List<String> veriler = DosyaYoneticisi.getInstance().verileriOku(true);
		for (String satir : veriler) {
			model.addRow(new Object[] { satir, "Öğrenci", "Belirtilmedi", "Onaylı" });
		}
	}
}
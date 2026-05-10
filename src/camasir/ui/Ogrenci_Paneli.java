package camasir.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
                    int cevap = JOptionPane.showConfirmDialog(null, 
                        saat + " saati için randevu onaylıyor musunuz?", 
                        "Randevu Onayı", JOptionPane.YES_NO_OPTION);
                    
                    if (cevap == JOptionPane.YES_OPTION) {
                        btn.setBackground(new Color(231, 76, 60)); 
                        btn.setEnabled(false); 
                        
                        
                        DosyaYoneticisi.getInstance().veriyiKaydet("Randevu: " + saat, true);
                        JOptionPane.showMessageDialog(null, "Randevunuz başarıyla kaydedildi!");
                    }
                }
            });
            buttonPanel.add(btn);
        }

        this.add(buttonPanel, BorderLayout.CENTER);
    }
}
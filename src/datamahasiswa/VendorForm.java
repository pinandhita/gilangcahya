// Gilang Cahya Pinandhita - 50421565

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VendorForm extends JFrame {
    // Komponen-komponen GUI
    private JLabel jLabel2;
    private JTextField TFVendor;
    private JButton simpan;
    private JTable jTable1;
    private DefaultTableModel tableModel;

    public VendorForm() {
        // Menginisialisasi JFrame dan komponen-komponen GUI
        setTitle("Aplikasi Vendor");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Label untuk input vendor
        jLabel2 = new JLabel("Input Vendor:");
        jLabel2.setBounds(20, 20, 100, 25);
        add(jLabel2);

        // TextField untuk memasukkan nama vendor
        TFVendor = new JTextField();
        TFVendor.setBounds(120, 20, 150, 25);
        add(TFVendor);

        // Button untuk menyimpan vendor
        simpan = new JButton("Simpan");
        simpan.setBounds(280, 20, 80, 25);
        add(simpan);

        // Tabel untuk menampilkan daftar vendor
        tableModel = new DefaultTableModel(new Object[]{"Nama Vendor", "ID Vendor"}, 0);
        jTable1 = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(jTable1);
        scrollPane.setBounds(20, 60, 340, 180);
        add(scrollPane);

        // Action Listener untuk button "Simpan"
        simpan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String vendorName = TFVendor.getText().trim();
                if (!vendorName.isEmpty()) {
                    String vendorID = "ID-" + (tableModel.getRowCount() + 1);  // ID vendor otomatis
                    tableModel.addRow(new Object[]{vendorName, vendorID});
                    TFVendor.setText(""); // Clear input field
                } else {
                    JOptionPane.showMessageDialog(null, "Nama vendor tidak boleh kosong.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public static void main(String[] args) {
        // Membuat dan menampilkan form
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VendorForm().setVisible(true);
            }
        });
    }
}

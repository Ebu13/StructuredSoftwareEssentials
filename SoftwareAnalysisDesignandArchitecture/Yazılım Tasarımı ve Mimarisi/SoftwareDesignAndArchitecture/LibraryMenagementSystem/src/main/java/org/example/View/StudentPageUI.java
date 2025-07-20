package org.example.View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Arrays;

public class StudentPageUI extends JFrame {
    private JPanel container;
    private JPanel pnlLeft;
    private JPanel pnlRight;
    private JLabel lblBookDetails;
    private JTextArea txtBookInfo;
    private JTable tblBooks;
    private JTextField txtSearch;
    private JButton btnSearch;
    private JButton btnMyBooks;
    private JButton btnMyFines;
    private DefaultTableModel bookTableModel;

    private String[][] bookData = {
            {"684279801", "Devlet", "Platon", "700"},
            {"612226589321", "Zamanı Geriye Al", "İmkan Yokluk", "1524"},
            {"457666441277", "Yalnızlık Mutluluktur", "İlmi Cisim", "333"},
            {"786698754129", "Aşk Koca Bir Yalan", "Emir Yılmaz", "400"},
            {"333214587", "Vergiler", "Recin Tayyok", "128"},
            {"359248963784", "Denemeler", "Erman Yavuz", "256"}
    };

    private String[][] finesData = {
            {"684279801", "Devlet", "10 TL"},
            {"612226589321", "Zamanı Geriye Al", "5 TL"}
    };

    public StudentPageUI() {
        // Ana paneli oluştur ve yerleşim düzenini ayarla
        container = new JPanel();
        container.setLayout(new GridLayout(1, 2)); // İkiye böl

        // Sol panel (Kitap Bilgileri)
        pnlLeft = new JPanel();
        pnlLeft.setLayout(new BoxLayout(pnlLeft, BoxLayout.Y_AXIS)); // Dikey hizalama

        lblBookDetails = new JLabel("Seçilen Kitap Bilgileri");
        lblBookDetails.setFont(new Font("Arial", Font.BOLD, 18));

        // Kitap bilgilerini gösteren alan
        txtBookInfo = new JTextArea(10, 20);
        txtBookInfo.setEditable(false);
        txtBookInfo.setBorder(BorderFactory.createTitledBorder("Kitap Bilgileri"));

        pnlLeft.add(lblBookDetails);
        pnlLeft.add(txtBookInfo);

        container.add(pnlLeft);

        // Sağ panel (Kitaplar Tablosu ve Arama)
        pnlRight = new JPanel();
        pnlRight.setLayout(new BorderLayout());

        // Arama kısmı
        JPanel pnlSearch = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        txtSearch = new JTextField(20);
        txtSearch.setFont(new Font("Arial", Font.PLAIN, 14));
        txtSearch.setBorder(BorderFactory.createTitledBorder("Barkod Numarası ile Ara"));
        btnSearch = new JButton("Ara");
        btnSearch.setFont(new Font("Arial", Font.BOLD, 14));

        // Kitaplarım butonu
        btnMyBooks = new JButton("Kitaplarım");
        btnMyBooks.setFont(new Font("Arial", Font.BOLD, 14));

        // Cezalarım butonu
        btnMyFines = new JButton("Cezalarım");
        btnMyFines.setFont(new Font("Arial", Font.BOLD, 14));

        pnlSearch.add(txtSearch);
        pnlSearch.add(btnSearch);
        pnlSearch.add(btnMyBooks);
        pnlSearch.add(btnMyFines);
        pnlRight.add(pnlSearch, BorderLayout.NORTH);

        // Kitaplar tablosu
        String[] columnNames = {"Barkod No", "Kitap Adı", "Yazar Adı", "Sayfa No"};
        bookTableModel = new DefaultTableModel(bookData, columnNames);
        tblBooks = new JTable(bookTableModel);
        JScrollPane scrollPane = new JScrollPane(tblBooks);
        pnlRight.add(scrollPane, BorderLayout.CENTER);

        container.add(pnlRight);

        // Çerçeve ayarları
        this.add(container);
        this.setResizable(true);
        this.setTitle("Öğrenci Kitap Yönetimi");
        this.setSize(800, 600);

        // Ekranın ortasına yerleştirme
        int screenX = (int) ((Toolkit.getDefaultToolkit().getScreenSize().getWidth() - this.getSize().getWidth()) / 2);
        int screenY = (int) ((Toolkit.getDefaultToolkit().getScreenSize().getHeight() - this.getSize().getHeight()) / 2);
        this.setLocation(screenX, screenY);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);

        // Tablo seçim dinleyicisi (kitap bilgilerini göstermek için)
        tblBooks.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int selectedRow = tblBooks.getSelectedRow();
                if (selectedRow != -1) {
                    // Sol paneldeki bilgileri güncelle
                    txtBookInfo.setText(
                            "Barkod No: " + bookTableModel.getValueAt(selectedRow, 0) + "\n" +
                                    "Kitap Adı: " + bookTableModel.getValueAt(selectedRow, 1) + "\n" +
                                    "Yazar Adı: " + bookTableModel.getValueAt(selectedRow, 2) + "\n" +
                                    "Sayfa No: " + bookTableModel.getValueAt(selectedRow, 3) + "\n" +
                                    "Müsaitlik: " + (selectedRow % 2 == 0 ? "Ödünçte" : "Müsait") // Örnek Müsaitlik durumu
                    );
                }
            }
        });

        // Butonlar için aksiyon dinleyicileri
        btnMyBooks.addActionListener(e -> updateTable("books"));
        btnMyFines.addActionListener(e -> updateTable("fines"));

        // Arama butonu dinleyicisi
        btnSearch.addActionListener(e -> {
            String barcode = txtSearch.getText().trim();
            searchBookByBarcode(barcode);
        });
    }

    // Kitaplar ve Cezalar tablosunu değiştiren metod
    private void updateTable(String type) {
        if (type.equals("books")) {
            bookTableModel.setDataVector(bookData, new String[]{"Barkod No", "Kitap Adı", "Yazar Adı", "Sayfa No"});
        } else if (type.equals("fines")) {
            bookTableModel.setDataVector(finesData, new String[]{"Barkod No", "Kitap Adı", "Ceza"});
        }
    }

    // Barkod numarasına göre kitap arama metodu
    private void searchBookByBarcode(String barcode) {
        for (int i = 0; i < bookData.length; i++) {
            if (bookData[i][0].equals(barcode)) {
                txtBookInfo.setText(
                        "Barkod No: " + bookData[i][0] + "\n" +
                                "Kitap Adı: " + bookData[i][1] + "\n" +
                                "Yazar Adı: " + bookData[i][2] + "\n" +
                                "Sayfa No: " + bookData[i][3] + "\n" +
                                "Müsaitlik: " + (i % 2 == 0 ? "Ödünçte" : "Müsait")
                );
                return;
            }
        }
        JOptionPane.showMessageDialog(this, "Barkod numarasıyla ilgili kitap bulunamadı.", "Hata", JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(StudentPageUI::new);
    }
}

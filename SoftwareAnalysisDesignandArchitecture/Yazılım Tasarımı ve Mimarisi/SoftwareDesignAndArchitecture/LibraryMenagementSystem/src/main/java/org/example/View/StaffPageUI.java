package org.example.View;

import org.example.Business.BorrowService;
import org.example.Business.LibraryItemService;
import org.example.Business.StudentService;
import org.example.Business.BorrowStrategy;
import org.example.Business.DefaultBorrowStrategy;
import org.example.DAO.BorrowDAO;
import org.example.Entity.LibraryItemDto;
import org.example.Entity.Student;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class StaffPageUI extends JFrame {
    private JPanel container;
    private JPanel pnlLeft;
    private JPanel pnlRight;
    private JPanel pnlTop;
    private JPanel pnlBottom;
    private JTextField txtStudentName, txtStudentEmail, txtStudentPassword, txtSearch, txtDeleteStudentId, txtLendStudentId, txtLendBookBarcode;
    private JButton btnSearch, btnAddStudent, btnDeleteStudent, btnLendBook;
    private JTable tblBooks;

    private StudentService studentService;
    private BorrowService borrowService;
    private LibraryItemService libraryItemService;
    private BorrowStrategy borrowStrategy; // Strateji sınıfı eklendi

    public StaffPageUI() {
        studentService = new StudentService();
        libraryItemService = new LibraryItemService();

        // DefaultBorrowStrategy ile BorrowService başlatılıyor
        borrowStrategy = new DefaultBorrowStrategy();
        // BorrowDAO nesnesini oluşturuyoruz (Gerçek uygulamada, DAO sınıfı üzerinden bu nesne oluşturulmalıdır)
        BorrowDAO borrowDAO = new BorrowDAO();

// BorrowStrategy'yi belirliyoruz
        borrowStrategy = new DefaultBorrowStrategy();

        borrowService = new BorrowService(borrowDAO, borrowStrategy);
        // BorrowService'e strateji ekleniyor

        container = new JPanel();
        container.setLayout(new BorderLayout());

        pnlLeft = new JPanel();
        CardLayout cardLayout = new CardLayout();
        pnlLeft.setLayout(cardLayout);
        pnlLeft.setPreferredSize(new Dimension(400, 0));
        pnlLeft.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel pnlStudentInfo = createStudentInfoPanel();
        JPanel pnlDeleteStudent = createDeleteStudentPanel();
        JPanel pnlLendBook = createLendBookPanel();

        pnlLeft.add(pnlStudentInfo, "Öğrenci Kaydı");
        pnlLeft.add(pnlDeleteStudent, "Öğrenci Sil");
        pnlLeft.add(pnlLendBook, "Ödünç Ver");

        pnlRight = new JPanel();
        pnlRight.setLayout(new BorderLayout());

        pnlTop = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));
        pnlTop.setPreferredSize(new Dimension(0, 100));

        txtSearch = new JTextField(15);
        txtSearch.setFont(new Font("Arial", Font.PLAIN, 14));
        txtSearch.setBorder(BorderFactory.createTitledBorder("Barkod Numarası ile Ara"));
        btnSearch = createButton("Ara");
        btnSearch.addActionListener(e -> searchLibraryItemByBarcode());

        btnAddStudent = createButton("Öğrenci Ekle");
        btnDeleteStudent = createButton("Öğrenci Sil");
        btnLendBook = createButton("Ödünç Ver");

        btnAddStudent.addActionListener(e -> cardLayout.show(pnlLeft, "Öğrenci Kaydı"));
        btnDeleteStudent.addActionListener(e -> cardLayout.show(pnlLeft, "Öğrenci Sil"));
        btnLendBook.addActionListener(e -> cardLayout.show(pnlLeft, "Ödünç Ver"));

        pnlTop.add(txtSearch);
        pnlTop.add(btnSearch);
        pnlTop.add(btnAddStudent);
        pnlTop.add(btnDeleteStudent);
        pnlTop.add(btnLendBook);
        pnlRight.add(pnlTop, BorderLayout.NORTH);

        pnlBottom = new JPanel(new BorderLayout());
        pnlBottom.setBorder(BorderFactory.createTitledBorder("Kitap Listesi"));

        String[] columnNames = {"Barkod No", "Kitap Adı", "Yazar Adı", "Sayfa No", "Durum"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        tblBooks = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(tblBooks);
        pnlBottom.add(scrollPane, BorderLayout.CENTER);
        pnlRight.add(pnlBottom, BorderLayout.CENTER);

        container.add(pnlLeft, BorderLayout.WEST);
        container.add(pnlRight, BorderLayout.CENTER);

        loadLibraryItems();

        this.add(container);
        this.setResizable(true);
        this.setTitle("Yetkili Kitap Yönetimi");
        this.setSize(900, 700);

        int screenX = (int) ((Toolkit.getDefaultToolkit().getScreenSize().getWidth() - this.getSize().getWidth()) / 2);
        int screenY = (int) ((Toolkit.getDefaultToolkit().getScreenSize().getHeight() - this.getSize().getHeight()) / 2);
        this.setLocation(screenX, screenY);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private JPanel createStudentInfoPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createTitledBorder("Öğrenci Kaydı"));

        JLabel lblName = new JLabel("Öğrenci Adı:");
        txtStudentName = createTextField();
        JLabel lblEmail = new JLabel("E-posta:");
        txtStudentEmail = createTextField();
        JLabel lblPassword = new JLabel("Şifre:");
        txtStudentPassword = createTextField();

        JButton btnAdd = createButton("Ekle");
        btnAdd.addActionListener(e -> {
            String name = txtStudentName.getText();
            String email = txtStudentEmail.getText();
            String password = txtStudentPassword.getText();

            if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Lütfen tüm alanları doldurun!", "Hata", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Student student = new Student(null, name, email, password, null);
            studentService.addStudent(student);
            JOptionPane.showMessageDialog(this, "Öğrenci başarıyla eklendi!", "Bilgi", JOptionPane.INFORMATION_MESSAGE);
        });

        panel.add(lblName);
        panel.add(txtStudentName);
        panel.add(lblEmail);
        panel.add(txtStudentEmail);
        panel.add(lblPassword);
        panel.add(txtStudentPassword);
        panel.add(Box.createVerticalStrut(20));
        panel.add(btnAdd);

        return panel;
    }

    private JPanel createDeleteStudentPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createTitledBorder("Öğrenci Sil"));

        JLabel lblStudentId = new JLabel("Öğrenci ID:");
        txtDeleteStudentId = createTextField();

        JButton btnDelete = createButton("Sil");
        btnDelete.addActionListener(e -> {
            String studentId = txtDeleteStudentId.getText();

            if (studentId.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Lütfen bir öğrenci ID girin!", "Hata", JOptionPane.ERROR_MESSAGE);
                return;
            }

            studentService.deleteStudent(studentId);
            JOptionPane.showMessageDialog(this, "Öğrenci başarıyla silindi!", "Bilgi", JOptionPane.INFORMATION_MESSAGE);
        });

        panel.add(lblStudentId);
        panel.add(txtDeleteStudentId);
        panel.add(Box.createVerticalStrut(20));
        panel.add(btnDelete);

        return panel;
    }

    private JPanel createLendBookPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createTitledBorder("Ödünç Ver"));

        JLabel lblStudentId = new JLabel("Öğrenci ID:");
        txtLendStudentId = createTextField();
        JLabel lblBookBarcode = new JLabel("Kitap Barkod No:");
        txtLendBookBarcode = createTextField();

        JButton btnLend = createButton("Ödünç Ver");
        btnLend.addActionListener(e -> {
            String studentId = txtLendStudentId.getText();
            String bookBarcode = txtLendBookBarcode.getText();

            if (studentId.isEmpty() || bookBarcode.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Lütfen tüm alanları doldurun!", "Hata", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Student student = studentService.getStudentById(studentId);
            LibraryItemDto item = libraryItemService.getLibraryItemByBarcode(bookBarcode);

            if (student == null || item == null) {
                JOptionPane.showMessageDialog(this, "Geçersiz öğrenci ID veya kitap barkodu!", "Hata", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (borrowService.borrowItem(student, item)) {
                JOptionPane.showMessageDialog(this, "Kitap başarıyla ödünç verildi!", "Bilgi", JOptionPane.INFORMATION_MESSAGE);
                loadLibraryItems();
            } else {
                JOptionPane.showMessageDialog(this, "Kitap ödünç verilemedi!", "Hata", JOptionPane.ERROR_MESSAGE);
            }
        });

        panel.add(lblStudentId);
        panel.add(txtLendStudentId);
        panel.add(lblBookBarcode);
        panel.add(txtLendBookBarcode);
        panel.add(Box.createVerticalStrut(20));
        panel.add(btnLend);

        return panel;
    }

    private void searchLibraryItemByBarcode() {
        String barcode = txtSearch.getText().trim();

        if (barcode.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Lütfen bir barkod numarası giriniz.", "Hata", JOptionPane.ERROR_MESSAGE);
            return;
        }

        LibraryItemDto item = libraryItemService.getLibraryItemByBarcode(barcode);

        if (item == null) {
            JOptionPane.showMessageDialog(this, "Girilen barkod numarasıyla eşleşen kitap bulunamadı.", "Bilgi", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        DefaultTableModel model = (DefaultTableModel) tblBooks.getModel();
        model.setRowCount(0);

        String status = item.isAvailable() ? "Boşta" : "Ödünçte";
        model.addRow(new Object[] {
                item.getBarcode(),
                item.getTitle(),
                item.getSpecialAttribute(),
                item.getPageCount(),
                status
        });
    }

    private void loadLibraryItems() {
        List<LibraryItemDto> items = libraryItemService.getLibraryItems();
        DefaultTableModel model = (DefaultTableModel) tblBooks.getModel();
        model.setRowCount(0);

        for (LibraryItemDto item : items) {
            String status = item.isAvailable() ? "Boşta" : "Ödünçte";
            model.addRow(new Object[] {
                    item.getBarcode(),
                    item.getTitle(),
                    item.getSpecialAttribute(),
                    item.getPageCount(),
                    status
            });
        }
    }

    private JTextField createTextField() {
        JTextField textField = new JTextField(20);
        textField.setFont(new Font("Arial", Font.PLAIN, 14));
        textField.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        return textField;
    }

    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setBackground(new Color(70, 130, 180));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setPreferredSize(new Dimension(150, 40));
        return button;
    }
}

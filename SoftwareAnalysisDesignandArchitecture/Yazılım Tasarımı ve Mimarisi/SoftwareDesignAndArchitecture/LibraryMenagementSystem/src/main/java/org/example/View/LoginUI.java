package org.example.View;

import org.example.Business.LoginService;
import org.example.Entity.User;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class LoginUI extends JFrame {
    private JPanel container;
    private JPanel pnlTop;
    private JPanel pnlBottom;
    private JLabel lblInfo;
    private JPanel pnlStudent;
    private JPanel pnlAdmin;
    private JTextField txtStudentEmail;
    private JPasswordField txtStudentPassword;
    private JButton btnStudentLogin;
    private JTextField txtAdminEmail;
    private JPasswordField txtAdminPassword;
    private JButton btnAdminLogin;
    private LoginService loginService;

    public LoginUI() {
        // LoginService'i başlat
        loginService = new LoginService();

        // Ana paneli oluştur ve yerleşim düzenini ayarla
        container = new JPanel();
        container.setLayout(new BorderLayout());

        // Üst panel
        pnlTop = new JPanel();
        lblInfo = new JLabel("GİRİŞ", SwingConstants.CENTER);
        lblInfo.setFont(new Font("Arial", Font.BOLD, 24));
        lblInfo.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        pnlTop.add(lblInfo);
        container.add(pnlTop, BorderLayout.NORTH);

        // Alt panel
        pnlBottom = new JPanel(new GridLayout(1, 2, 20, 20));
        pnlBottom.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Yönetici giriş paneli (solda olacak)
        pnlAdmin = createLoginPanel("Yetkili Girişi");
        txtAdminEmail = createCustomTextField();
        txtAdminPassword = createCustomPasswordField();
        btnAdminLogin = createCustomButton("Giriş Yap");
        addLoginFields(pnlAdmin, txtAdminEmail, txtAdminPassword, btnAdminLogin);

        // Öğrenci giriş paneli (sağda olacak)
        pnlStudent = createLoginPanel("ÖĞRENCİ GİRİŞİ");
        txtStudentEmail = createCustomTextField();
        txtStudentPassword = createCustomPasswordField();
        btnStudentLogin = createCustomButton("Giriş Yap");
        addLoginFields(pnlStudent, txtStudentEmail, txtStudentPassword, btnStudentLogin);

        // Alt panelde yetkili ve öğrenci panellerini ekle
        pnlBottom.add(pnlAdmin); // Solda
        pnlBottom.add(pnlStudent); // Sağda
        container.add(pnlBottom, BorderLayout.CENTER);

        // Çerçeve ayarları
        this.add(container);
        this.setResizable(true); // Pencerenin boyutlandırılabilir olmasını sağlar
        this.setTitle("Giriş Paneli");
        this.setSize(800, 600); // Başlangıç boyutu

        // Ekranın ortasına yerleştirme
        int screenX = (int) ((Toolkit.getDefaultToolkit().getScreenSize().getWidth() - this.getSize().getWidth()) / 2);
        int screenY = (int) ((Toolkit.getDefaultToolkit().getScreenSize().getHeight() - this.getSize().getHeight()) / 2);
        this.setLocation(screenX, screenY);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);

        // Login butonları için aksiyon ekle
        btnAdminLogin.addActionListener(e -> handleLogin(txtAdminEmail.getText(), new String(txtAdminPassword.getPassword()), "admin"));
        btnStudentLogin.addActionListener(e -> handleLogin(txtStudentEmail.getText(), new String(txtStudentPassword.getPassword()), "student"));
    }

    private JPanel createLoginPanel(String title) {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createTitledBorder(title));
        return panel;
    }

    private void addLoginFields(JPanel panel, JTextField txtEmail, JPasswordField txtPassword, JButton btnLogin) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // E-posta etiketi ve giriş alanı
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("E-POSTA:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(txtEmail, gbc);

        // Şifre etiketi ve giriş alanı
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("ŞİFRE:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(txtPassword, gbc);

        // Giriş butonu
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        panel.add(btnLogin, gbc);
    }

    private JTextField createCustomTextField() {
        JTextField textField = new JTextField(20);
        textField.setFont(new Font("Arial", Font.PLAIN, 14));
        return textField;
    }

    private JPasswordField createCustomPasswordField() {
        JPasswordField passwordField = new JPasswordField(20);
        passwordField.setFont(new Font("Arial", Font.PLAIN, 14));
        return passwordField;
    }

    private JButton createCustomButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        return button;
    }

    private void handleLogin(String email, String password, String userType) {
        // Kullanıcı girişini kontrol et
        User user = loginService.login(email, password);

        if (user != null) {
            if (userType.equals("admin") && user.getPersonType().equals("Staff")) {
                JOptionPane.showMessageDialog(this, "Giriş başarılı! Yönetici olarak giriş yaptınız.", "Başarı", JOptionPane.INFORMATION_MESSAGE);
                // Mevcut pencereyi kapatıp StaffPageUI aç
                this.dispose(); // Mevcut pencereyi kapat
                new StaffPageUI(); // Yönetici sayfasını aç
            } else if (userType.equals("student") && user.getPersonType().equals("Student")) {
                JOptionPane.showMessageDialog(this, "Giriş başarılı! Öğrenci olarak giriş yaptınız.", "Başarı", JOptionPane.INFORMATION_MESSAGE);
                // Mevcut pencereyi kapatıp StudentPageUI aç
                this.dispose(); // Mevcut pencereyi kapat
                new StudentPageUI(); // Öğrenci sayfasını aç
            } else {
                JOptionPane.showMessageDialog(this, "Yanlış kullanıcı tipi!", "Hata", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "E-posta veya şifre hatalı!", "Hata", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginUI());
    }
}

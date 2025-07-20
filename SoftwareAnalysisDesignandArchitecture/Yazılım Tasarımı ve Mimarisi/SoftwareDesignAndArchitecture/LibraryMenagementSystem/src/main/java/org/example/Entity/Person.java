package org.example.Entity;

public abstract class Person implements IUser {
    private String userId;
    private String name;
    private String email;
    private String password;

    public Person(String userId, String name, String email, String password) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean borrow() {
        // Ödünç alma işleminin başarılı olduğunu varsayalım
        System.out.println(getName() + " bir materyal ödünç aldı.");
        return true; // İşlemin başarılı olduğunu belirtmek için true döndürülür
    }
}

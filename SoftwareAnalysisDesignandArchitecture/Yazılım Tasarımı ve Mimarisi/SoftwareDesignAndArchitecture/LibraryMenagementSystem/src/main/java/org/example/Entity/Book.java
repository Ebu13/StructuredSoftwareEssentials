package org.example.Entity;

public class Book extends LibraryItem {
    private String author;

    public Book(String id, String title, boolean available, String barcode, int pageCount, String author) {
        super(id, title, available, barcode, pageCount); // Pass barcode and pageCount to the super constructor
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}

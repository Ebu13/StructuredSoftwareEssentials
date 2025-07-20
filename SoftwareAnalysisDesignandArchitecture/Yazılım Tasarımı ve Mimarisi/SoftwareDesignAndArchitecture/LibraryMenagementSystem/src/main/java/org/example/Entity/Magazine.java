package org.example.Entity;

public class Magazine extends LibraryItem {
    private String publisher;

    public Magazine(String id, String title, boolean available, String barcode, int pageCount, String publisher) {
        super(id, title, available, barcode, pageCount); // Pass barcode and pageCount to the super constructor
        this.publisher = publisher;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}

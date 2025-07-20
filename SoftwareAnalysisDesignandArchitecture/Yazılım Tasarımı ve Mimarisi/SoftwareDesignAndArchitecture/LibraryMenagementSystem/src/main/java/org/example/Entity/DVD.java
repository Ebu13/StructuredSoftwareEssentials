package org.example.Entity;

public class DVD extends LibraryItem {
    private String director;

    public DVD(String id, String title, boolean available, String barcode, int pageCount, String director) {
        super(id, title, available, barcode, pageCount); // Pass barcode and pageCount to the super constructor
        this.director = director;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }
}

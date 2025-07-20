package org.example.Entity;

public abstract class LibraryItem {
    private String id;
    private String title;
    private boolean available;
    private String barcode;  // Barkod özelliği
    private int pageCount;   // Sayfa sayısı

    public LibraryItem(String id, String title, boolean available, String barcode, int pageCount) {
        this.id = id;
        this.title = title;
        this.available = available;
        this.barcode = barcode;
        this.pageCount = pageCount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
}

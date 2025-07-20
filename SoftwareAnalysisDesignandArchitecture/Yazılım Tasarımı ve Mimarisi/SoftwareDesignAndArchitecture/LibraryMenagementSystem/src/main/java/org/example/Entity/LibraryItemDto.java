package org.example.Entity;

public class LibraryItemDto {
    private String id;
    private String title;
    private boolean available;
    private String itemType;  // Öğenin türü (örneğin: kitap, dergi, vb.)
    private String barcode;   // Barkod özelliği
    private int pageCount;    // Sayfa sayısı
    private String specialAttribute;  // Özel özellik (örneğin: yazar adı, yayınevi, vb.)

    public LibraryItemDto(String id, String title, boolean available, String itemType, String barcode, int pageCount, String specialAttribute) {
        this.id = id;
        this.title = title;
        this.available = available;
        this.itemType = itemType;
        this.barcode = barcode;
        this.pageCount = pageCount;
        this.specialAttribute = specialAttribute;
    }

    // Getter ve Setter metodları
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

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
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

    public String getSpecialAttribute() {
        return specialAttribute;
    }

    public void setSpecialAttribute(String specialAttribute) {
        this.specialAttribute = specialAttribute;
    }
}

package org.example.Entity;

public interface ILibraryItem {
    String getId();
    String getTitle();
    boolean isAvailable();
    void setAvailable(boolean available);
}

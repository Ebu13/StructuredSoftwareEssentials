package org.example.Entity;

public interface IUser {
    String getUserId();
    String getName();
    String getEmail();
    boolean borrow();
    boolean returnItem(LibraryItem item);
}

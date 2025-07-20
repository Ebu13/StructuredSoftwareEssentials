package org.example.Entity;

import java.util.List;

public class Library {
    private List<LibraryItem> items;
    private List<IUser> users;

    public void addItem(LibraryItem item) {
        items.add(item);
    }

    public void addUser(IUser user) {
        users.add(user);
    }

    public LibraryItem findItem(String id) {
        return items.stream().filter(item -> item.getId().equals(id)).findFirst().orElse(null);
    }

    public IUser findUser(String userId) {
        return users.stream().filter(user -> user.getUserId().equals(userId)).findFirst().orElse(null);
    }

    public boolean borrow(IUser user, LibraryItem item) {
        if (item.isAvailable()) {
            item.setAvailable(false);
            return true;
        }
        return false;
    }

    public boolean returnItem(IUser user, LibraryItem item) {
        item.setAvailable(true);
        return true;
    }
}

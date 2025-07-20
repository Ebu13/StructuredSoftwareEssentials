package org.example;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;

    public Library() {
        books = new ArrayList<>();
    }
    public List<Book> getBooks() {
        return books;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public void editBook(Book book, String authorName) {
        if (book.getAuthor() != null) {
            book.getAuthor().setName(authorName);
        }
    }

    public Book findBookByName(String bookName) {
        for (Book book : books) {
            if (book.getBookName().equals(bookName)) {
                return book;
            }
        }
        return null;
    }

    public boolean mesgulmu(Book book) {
        return book.getReservation() == null;
    }

    public void reserveBook(Book book, Member member) {
        if (mesgulmu(book)) {
            book.setReservation(member);
        } else {
            System.out.println("Kitap halihazırda başka kullanıcı tarafından kullanılıyor.");
        }
    }
}

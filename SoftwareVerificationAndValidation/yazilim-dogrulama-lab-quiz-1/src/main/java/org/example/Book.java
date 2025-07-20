package org.example;

public class Book {
    private String bookName;
    private Author author;
    private String publishYear;
    private PublishPlace publishPlace;
    private int pageSize;
    private Member reservation;

    public Member getReservation() {
        return reservation;
    }

    public void setReservation(Member reservation) {
        this.reservation = reservation;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(String publishYear) {
        this.publishYear = publishYear;
    }

    public PublishPlace getPublishPlace() {
        return publishPlace;
    }

    public void setPublishPlace(PublishPlace publishPlace) {
        this.publishPlace = publishPlace;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}

package ru.itpark.domain;

public class SearchBook {
    private int id;
    private String author;
    private String isbn;
    private String[] genre;

    public SearchBook(int id, String author, String isbn, String[] genre) {
        this.id = id;
        this.author = author;
        this.isbn = isbn;
        this.genre = genre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String[] getGenre() {
        return genre;
    }

    public void setGenre(String[] genre) {
        this.genre = genre;
    }
}



package ru.itpark.repository;

import ru.itpark.domain.SearchBook;

public class BookRepository {
    private SearchBook[] books = new SearchBook[50];
    private int index = 0;

    public void addBooks(SearchBook book) {//добавь книги из массива SearchBook,
        //элемент массива-book
        books[index] = book;
        index++;
    }

    public SearchBook[] getAll() {
        return books;
    }
}



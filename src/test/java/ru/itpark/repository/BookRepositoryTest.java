package ru.itpark.repository;

import org.junit.jupiter.api.Test;
import ru.itpark.domain.SearchBook;

import static org.junit.jupiter.api.Assertions.*;

class BookRepositoryTest {

    @Test
    void addOneBook() {
        BookRepository repository = new BookRepository();
        String[] genre = {"drama", "fiction", "poetry"};
        SearchBook book = new SearchBook(1, "Гайдар", "0", genre);
        repository.addBooks(book);
        SearchBook[] books = repository.getAll();
        assertEquals(book, books[0]);
    }

    @Test
    void addTwoBooks() {
        BookRepository repository = new BookRepository();
        String[] genre = {"drama", "fiction", "poetry"};
        SearchBook book1 = new SearchBook(1, "Гайдар", "0", genre);
        SearchBook book2 = new SearchBook(2, "Булгаков", "2345", genre);
        repository.addBooks(book1);
        repository.addBooks(book2);
        SearchBook[] books = repository.getAll();
        assertEquals(book1, books[0]);
        assertEquals(book2, books[1]);
    }
}
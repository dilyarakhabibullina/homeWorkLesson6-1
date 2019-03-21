package ru.itpark.service;

import org.junit.jupiter.api.Test;
import ru.itpark.domain.SearchBook;
import ru.itpark.repository.BookRepository;

import static org.junit.jupiter.api.Assertions.*;

class BookServiceTest {

    @Test
    void create() {
        BookRepository repository = new BookRepository();
        BookService service = new BookService(repository);
        String[] genre = {"drama", "fiction"};
        //int index = 0;

        service.create("Гайдар", "1-234-567-8910", genre);
        service.create("Гайдар", "1-234-567-8910", genre);
        //service.create ("А. Гайдар", "1-098-765-4000", genre);
        //service.create ("Агата Кристи", "1-000-765-4321", genre);

        SearchBook[] books = repository.getAll();
        //index++;

        assertNotEquals(0, books[0].getId());
        assertNotEquals(0, books[1].getId());
        assertNotEquals(books[0].getId(), books[1].getId());

    }

    @Test
    public void searchByAuthor() {
        BookRepository repository = new BookRepository();
        BookService service = new BookService (repository);
        String[] genre = {"drama", "fiction"};
        service.create ("Гайдар", "1-234-567-8910", genre);
        service.create ("Гайдар", "1-098-765-4321", genre);
        service.create ("А. Гайдар", "1-098-765-4000", genre);
        service.create ("Агата Кристи", "1-000-765-4321", genre);

        SearchBook[] books = service.searchByAuthor("Гайдар");
        //SearchBook [] author = service.searchByAuthor("Гайдар");
        assertEquals("Гайдар", books[0].getAuthor());
        assertEquals("Гайдар", books[1].getAuthor());
        assertEquals("А. Гайдар", books[2].getAuthor());
    }

    //TO DO -еще 2 сервиса-поиски по исбну и жанрам+ тесты на эти поиски
    @Test
    public void searchByIsbn() {
        BookRepository repository = new BookRepository();
        BookService service = new BookService (repository);
        String[] genre = {"drama", "fiction"};
        service.create ("Гайдар", "1-234-567-8910", genre);
        service.create ("Гайдар", "1-098-765-4321", genre);
        service.create ("А. Гайдар", "1-098-765-4000", genre);
        service.create ("Агата Кристи", "1-000-765-4321", genre);

        SearchBook[] books = service.searchByIsbn("1-234-567-891");

        assertEquals("1-234-567-8910", books[0].getIsbn());

    }
}

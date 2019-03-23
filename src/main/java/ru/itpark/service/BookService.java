package ru.itpark.service;

import ru.itpark.domain.SearchBook;
import ru.itpark.repository.BookRepository;

public class BookService {
    private BookRepository repository;//создаем переменную репозиторий
    int index = 0;
    private int nextId = 1;//задаем поле для хранения следующего идентификатора

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public void create(String author, String isbn, String[] genre) {
//сюда пишем, какие нам нужны поля для создания строчки массива, id не пишем, так как он присваивается программой
// по принципу плюс 1 к предыдущему зарегистрировавшемуся
        SearchBook book = new SearchBook(nextId, author, isbn, genre);
        repository.addBooks(book);
        nextId++;//прибавляет один иднетификатор
    }

    public SearchBook[] searchByAuthor(String author) {
        SearchBook[] result = new SearchBook[10];
        int resultIndex = 0;
        SearchBook[] books = repository.getAll();
        for (SearchBook book : books) {
            if (book == null) {
                continue;
            }
            if (!book.getAuthor().contains(author)) {
                continue;
            }
            result[resultIndex] = book;
            resultIndex++;
        }
        return result;
    }

    public SearchBook[] searchByIsbn(String isbn) {
        SearchBook[] result = new SearchBook[10];
        int resultIndex = 0;
        SearchBook[] books = repository.getAll();
        for (SearchBook book : books) {
            if (book == null) {
                continue;
            }
            if (!book.getIsbn().contains(isbn)) {//??? как сделать здесь строгое соответствие????
                continue;
            }

            result[resultIndex] = book;
            resultIndex++;

        }
        return result;
    }
    public SearchBook [] searchByGenre(String text) {
        SearchBook[] result = new SearchBook[10];
        int resultIndex = 0;

        SearchBook[] books = repository.getAll();
        for (SearchBook book : books) {
            if (book == null) {
                continue;
            }
            String[] genres = book.getGenre();
            for (String genre : genres) {
                if (genre.equals(text)) {
                    result[resultIndex] = book;
                    resultIndex++;
                    break;
                }
            }
        }
        return result;
    }}


/*
   String[] tags = post.getTags(); в статье есть тэги. мы их храним как массив.
            for (String tag : tags) { // перебираем все теги поста
                if (tag.equals(text)) { // если тег соответствует
                    result[resultIndex] = post; // кладём пост в результаты поиска
                    resultIndex++;
                    break; // следующие теги перебирать смысла нет (т.к. наш уже подошёл)
 */








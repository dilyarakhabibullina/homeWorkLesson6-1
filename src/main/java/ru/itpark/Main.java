package ru.itpark;

import ru.itpark.repository.BookRepository;
import ru.itpark.service.BookService;

public class Main {
    public static void main(String[] args) {
        BookRepository repository = new BookRepository();
        BookService service = new BookService(repository);
        /*String[] genre = {"drama", "fiction"};
        service.create("Хемингуэй", "1-234-567-8910",genre);
        System.out.println ("sss");

        repository.getAll();
        System.out.println ("eee");

    }*/
        // BookService bookService = new BookService(repository);

        service.searchByAuthor("Гайдар");
        System.out.println("не знаю как вывести массив на печать!");
          /*  SearchBook[] result = new SearchBook[10];
            int resultIndex = 0;
            SearchBook[] books = repository.getAll();
            for (SearchBook book : books) {
                if (book == null) {
                    continue;
                }
                if (book.getAuthor().contains(author)) {
                    continue;
                }
                result[resultIndex] = book;
                resultIndex++;
            }
            return result;
        }
    }
    */
    }
}
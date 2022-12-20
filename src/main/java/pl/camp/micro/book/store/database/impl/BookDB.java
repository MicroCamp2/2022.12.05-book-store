package pl.camp.micro.book.store.database.impl;

import org.springframework.stereotype.Repository;
import pl.camp.micro.book.store.database.IBookDB;
import pl.camp.micro.book.store.model.Book;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookDB implements IBookDB {

    private final List<Book> books = new ArrayList<>();

    public BookDB() {
        books.add(new Book(1, "Tytul 1", "Autor 1", 34.34, 10));
        books.add(new Book(2, "Tytul 2", "Autor 2", 12.45, 10));
        books.add(new Book(3, "Tytul 3", "Autor 3", 54.43, 10));
        books.add(new Book(4, "Tytul 4", "Autor 4", 23.67, 10));
        books.add(new Book(5, "Tytul 5", "Autor 5", 39.43, 10));
        books.add(new Book(6, "Tytul 6", "Autor 6", 56.66, 10));
    }

    @Override
    public List<Book> getBooks() {
        return this.books;
    }
}

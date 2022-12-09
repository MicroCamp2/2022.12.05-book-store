package pl.camp.micro.book.store.services;

import pl.camp.micro.book.store.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> getBooks();
}

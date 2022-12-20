package pl.camp.micro.book.store.services.impl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import pl.camp.micro.book.store.controllers.rest.dto.BookDto;
import pl.camp.micro.book.store.database.repositories.IBookRepository;
import pl.camp.micro.book.store.model.Book;
import pl.camp.micro.book.store.services.IBookService;
import pl.camp.micro.book.store.services.mappers.BookMapper;

import java.util.ArrayList;
import java.util.List;

class BookServiceTest {

    IBookService bookService;

    @Mock
    IBookRepository bookDB;
    private AutoCloseable autoCloseable;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        bookService = new BookService(Mappers.getMapper(BookMapper.class), bookDB);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void getAllBooksTest() {
        Mockito
                .when(bookDB.findAll())
                .thenReturn(generateTestBooks());
        int expectedListSize = 3;

        List<BookDto> result = this.bookService.getBooks();

        Assertions.assertEquals(expectedListSize, result.size());
        for (int i = 0; i < result.size(); i++) {
            Assertions.assertEquals(i + 1, result.get(i).getId());
        }

        Mockito.verify(this.bookDB, Mockito.times(1)).findAll();
    }

    private List<Book> generateTestBooks() {
        List<Book> books = new ArrayList<>();
        books.add(new Book(1, "T1", "A1", 10.10, 10));
        books.add(new Book(2, "T2", "A2", 20.20, 20));
        books.add(new Book(3, "T3", "A3", 30.30, 30));
        return books;
    }
}

package pl.camp.micro.book.store.services.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pl.camp.micro.book.store.configuration.TestConfiguration;
import pl.camp.micro.book.store.database.IBookDB;
import pl.camp.micro.book.store.database.IUserDB;
import pl.camp.micro.book.store.model.Book;
import pl.camp.micro.book.store.services.IBookService;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { TestConfiguration.class })
public class BookServiceTest {

    @Autowired
    IBookService bookService;

    @MockBean
    IUserDB userDB;

    @MockBean
    IBookDB bookDB;

    @Test
    public void getAllBooksTest() {
        Mockito
                .when(bookDB.getBooks())
                .thenReturn(generateTestBooks());
        int expectedListSize = 3;

        List<Book> result = this.bookService.getBooks();

        Assertions.assertEquals(expectedListSize, result.size());
        for(int i = 0; i < result.size(); i++) {
            Assertions.assertEquals(i+1, result.get(i).getId());
        }

        Mockito.verify(this.bookDB, Mockito.times(1)).getBooks();
    }

    private List<Book> generateTestBooks() {
        List<Book> books = new ArrayList<>();
        books.add(new Book(1, "T1", "A1", 10.10, 10));
        books.add(new Book(2, "T2", "A2", 20.20, 20));
        books.add(new Book(3, "T3", "A3", 30.30, 30));
        return books;
    }
}

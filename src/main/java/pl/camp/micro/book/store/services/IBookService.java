package pl.camp.micro.book.store.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pl.camp.micro.book.store.controllers.rest.dto.BookDto;

import java.util.List;
import java.util.Optional;

public interface IBookService {
    List<BookDto> getBooks();

    BookDto createOrUpdate(BookDto book);


    Optional<BookDto> findById(Integer id);

    Page<BookDto> getBooks(Pageable pageable);

    List<BookDto> findAllBookWithLowPrice();
}

package pl.camp.micro.book.store.services.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.camp.micro.book.store.controllers.rest.dto.BookDto;
import pl.camp.micro.book.store.database.repositories.IBookRepository;
import pl.camp.micro.book.store.model.Book;
import pl.camp.micro.book.store.services.IBookService;
import pl.camp.micro.book.store.services.mappers.BookMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService implements IBookService {
    public final BookMapper bookMapper;
    private final IBookRepository bookRepository;

    public BookService(BookMapper bookMapper, IBookRepository bookRepository) {
        this.bookMapper = bookMapper;
        this.bookRepository = bookRepository;
    }

    @Override
    public List<BookDto> getBooks() {
        return this.bookRepository.findAll().stream()
                .map(bookMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public BookDto create(BookDto book) {
        Book savedBook = bookRepository.save(bookMapper.toEntity(book));
        return bookMapper.toDto(savedBook);
    }

    @Override
    public BookDto update(BookDto book) {
        Book savedBook =  bookRepository.save(bookMapper.toEntity(book));
        return bookMapper.toDto(savedBook);
    }

    @Override
    public Optional<BookDto> findById(Integer id) {
        Optional<Book> book = bookRepository.findById(id);
        return book.map(bookMapper::toDto);
    }

    @Override
    public Page<BookDto> getBooks(Pageable pageable) {
        return bookRepository.findAll(pageable)
                .map(bookMapper::toDto);
    }
}

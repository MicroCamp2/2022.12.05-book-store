package pl.camp.micro.book.store.services.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import pl.camp.micro.book.store.controllers.rest.dto.BookDto;
import pl.camp.micro.book.store.database.repositories.IBookRepository;
import pl.camp.micro.book.store.model.Book;
import pl.camp.micro.book.store.model.Book_;
import pl.camp.micro.book.store.model.Transaction;
import pl.camp.micro.book.store.services.IBookService;
import pl.camp.micro.book.store.services.mappers.BookMapper;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BookService implements IBookService {
    public final BookMapper bookMapper;
    private final IBookRepository bookRepository;

    public BookService(BookMapper bookMapper, IBookRepository bookRepository) {
        this.bookMapper = bookMapper;
        this.bookRepository = bookRepository;
    }

    private static Specification<Book> premiumLevel() {
        return createSpecificationLowPrice().or(createSpecificationHighPrice());
    }

    private static Specification<Book> createSpecificationLowPrice() {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.lessThan(root.get(Book_.price), 15.0);
    }

    private static Specification<Book> createSpecificationHighPrice() {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.greaterThan(root.get(Book_.price), 100.0);
    }

    @Override
    public List<BookDto> getBooks() {
        bookRepository.findAvailableBooks();
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
        Book savedBook = bookRepository.save(bookMapper.toEntity(book));
        return bookMapper.toDto(savedBook);
    }

    @Override
    public Optional<BookDto> findById(Integer id) {
        Optional<Book> book = bookRepository.findById(id);
        return book.map(bookMapper::toDto);
    }

    @Override
    @Transactional
    public Page<BookDto> getBooks(Pageable pageable) {
        return bookRepository.findAllWitTransaction(pageable)
                .map(b -> {
                    Set<Transaction> transactions = b.getTransactions();
                    return bookMapper.toDto(b);
                });
    }

    @Override
    public List<BookDto> findAllBookWithLowPrice() {

        return bookRepository.findAll(premiumLevel())
                .stream().map(bookMapper::toDto).collect(Collectors.toList());
    }


}

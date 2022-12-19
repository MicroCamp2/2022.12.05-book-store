package pl.camp.micro.book.store.services.impl;

import org.springframework.stereotype.Service;
import pl.camp.micro.book.store.controllers.rest.dto.BookDto;
import pl.camp.micro.book.store.controllers.rest.dto.TransactionDto;
import pl.camp.micro.book.store.database.repositories.IBookRepository;
import pl.camp.micro.book.store.database.repositories.TransactionRepository;
import pl.camp.micro.book.store.model.Book;
import pl.camp.micro.book.store.model.Transaction;
import pl.camp.micro.book.store.services.mappers.BookMapper;
import pl.camp.micro.book.store.services.mappers.TransactionMapper;

import javax.imageio.ImageTranscoder;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TransactionService  {
    public final TransactionMapper mapper;
    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionMapper mapper, TransactionRepository transactionRepository) {
        this.mapper = mapper;
        this.transactionRepository = transactionRepository;
    }

    public List<TransactionDto> getBooks() {
        return this.transactionRepository.findAll().stream()
                .map(mapper::toDto).collect(Collectors.toList());
    }

    public TransactionDto create(TransactionDto book) {
        Transaction savedBook = transactionRepository.save(mapper.toEntity(book));
        return mapper.toDto(savedBook);
    }

    public TransactionDto update(TransactionDto book) {
        Transaction saved =  transactionRepository.save(mapper.toEntity(book));
        return mapper.toDto(saved);
    }

    public Optional<TransactionDto> findById(Long id) {
        Optional<Transaction> book = transactionRepository.findById(id);
        return book.map(mapper::toDto);
    }
}

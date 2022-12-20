package pl.camp.micro.book.store.services.impl;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.camp.micro.book.store.controllers.rest.dto.TransactionDto;
import pl.camp.micro.book.store.database.repositories.TransactionRepository;
import pl.camp.micro.book.store.model.Transaction;
import pl.camp.micro.book.store.services.mappers.TransactionMapper;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class TransactionService {
    public final TransactionMapper mapper;
    private final TransactionRepository transactionRepository;

    private final ApplicationEventPublisher applicationEventPublisher;

    public TransactionService(TransactionMapper mapper, TransactionRepository transactionRepository, ApplicationEventPublisher applicationEventPublisher) {
        this.mapper = mapper;
        this.transactionRepository = transactionRepository;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public Page<TransactionDto> findTransaction(Pageable pageable) {
        return this.transactionRepository.findAll(pageable)
                .map(mapper::toDto);
    }

    public TransactionDto create(TransactionDto book) {
        Transaction savedBook = transactionRepository.save(mapper.toEntity(book));
        return mapper.toDto(savedBook);
    }

    public Page<TransactionDto> findByComment(String comment, Pageable pageable) {
        return transactionRepository.findByComment(comment, pageable).map(mapper::toDto);
    }

    @Transactional
    public TransactionDto update(TransactionDto transactionDto) {
        Transaction saved = transactionRepository.save(mapper.toEntity(transactionDto));
        applicationEventPublisher.publishEvent(new TransactionUpdatedEvent(this, transactionDto));
        return mapper.toDto(saved);
    }

    public Optional<TransactionDto> findById(Long id) {
        Optional<Transaction> book = transactionRepository.findById(id);
        return book.map(mapper::toDto);
    }
}

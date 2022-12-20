package pl.camp.micro.book.store.services.impl;

import lombok.Getter;
import pl.camp.micro.book.store.controllers.rest.dto.TransactionDto;

@Getter
public class TransactionUpdatedEvent {
    private final Object source;
    private final TransactionDto transactionDto;

    public TransactionUpdatedEvent(Object source, TransactionDto transactionDto) {
        this.source = source;
        this.transactionDto = transactionDto;
    }
}

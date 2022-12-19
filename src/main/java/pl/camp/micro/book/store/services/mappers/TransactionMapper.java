package pl.camp.micro.book.store.services.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.camp.micro.book.store.controllers.rest.dto.TransactionDto;
import pl.camp.micro.book.store.model.Transaction;

@Mapper(componentModel = "spring")
public interface TransactionMapper {

    @Mapping(source = "book.id", target = "bookId")
    TransactionDto toDto(Transaction source);

    @Mapping(target = "book.id", source = "bookId")
    Transaction toEntity(TransactionDto source);

    default Transaction fromId(Long id) {

        if (id == null) {
            return null;
        }
        Transaction transaction = new Transaction();
        transaction.setId(id);
        return transaction;
    }

}

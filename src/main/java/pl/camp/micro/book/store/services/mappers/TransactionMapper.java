package pl.camp.micro.book.store.services.mappers;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.camp.micro.book.store.controllers.rest.dto.TransactionDto;
import pl.camp.micro.book.store.model.Transaction;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface TransactionMapper {

    @Mapping(source = "book.id", target = "bookId")
    TransactionDto toDto(Transaction source);

    @Mapping(target = "book.id", source = "bookId")
    Transaction toEntity(TransactionDto source);

}

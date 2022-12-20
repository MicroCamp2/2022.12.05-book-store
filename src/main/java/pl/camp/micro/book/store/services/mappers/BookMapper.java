package pl.camp.micro.book.store.services.mappers;

import org.mapstruct.Mapper;
import pl.camp.micro.book.store.controllers.rest.dto.BookDto;
import pl.camp.micro.book.store.model.Book;

@Mapper(componentModel = "spring")
public interface BookMapper {
    BookDto toDto(Book source);

    Book toEntity(BookDto source);
}

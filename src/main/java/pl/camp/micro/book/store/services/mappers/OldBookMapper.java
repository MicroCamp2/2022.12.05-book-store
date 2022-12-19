package pl.camp.micro.book.store.services.mappers;

import org.springframework.stereotype.Component;
import pl.camp.micro.book.store.controllers.rest.dto.BookDto;
import pl.camp.micro.book.store.model.Book;

@Component
public class OldBookMapper {
    public BookDto toDto(Book source) {

        BookDto bookDto = new BookDto();
        bookDto.setId(source.getId());
        bookDto.setAuthor(source.getAuthor());
        bookDto.setPrice(source.getPrice());
        bookDto.setTitle(source.getTitle());
        bookDto.setQuantity(source.getQuantity());
        return bookDto;
    }

    public Book toEntity(BookDto source) {
        return new Book(source.getId(),
                source.getTitle(),
                source.getAuthor(),
                source.getPrice(),
                source.getQuantity()
        );
    }
}

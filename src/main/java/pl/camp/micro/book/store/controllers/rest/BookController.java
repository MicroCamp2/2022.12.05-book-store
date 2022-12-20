package pl.camp.micro.book.store.controllers.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.camp.micro.book.store.controllers.rest.dto.BookDto;
import pl.camp.micro.book.store.services.IBookService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private final IBookService iBookService;

    public BookController(IBookService iBookService) {
        this.iBookService = iBookService;
    }

    @GetMapping()
    public ResponseEntity<List<BookDto>> list() {
        return ResponseEntity.ok(iBookService.findAllBookWithLowPrice());
    }

    @PostMapping
    public ResponseEntity<BookDto> create(@Valid @RequestBody BookDto book) {
        return ResponseEntity.ok(iBookService.createOrUpdate(book));
    }

    @PostMapping("/{id}")
    public ResponseEntity<BookDto> update(@PathVariable Integer id, @RequestBody BookDto book) {

        book.setId(id);

        return ResponseEntity.ok(iBookService.createOrUpdate(book));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDto> getById(@PathVariable Integer id) {
        BookDto bookDto = iBookService.findById(id).orElseThrow(ResourceNotFond::new);
        return ResponseEntity.ok(bookDto);
    }

}

package pl.camp.micro.book.store.controllers.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.camp.micro.book.store.controllers.rest.dto.TransactionDto;
import pl.camp.micro.book.store.services.IBookService;
import pl.camp.micro.book.store.services.impl.TransactionService;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping()
    public ResponseEntity<List<TransactionDto>> list() {
        return ResponseEntity.ok(transactionService.getBooks());
    }

    @PostMapping
    public ResponseEntity<TransactionDto> create(@RequestBody TransactionDto book) {
        return ResponseEntity.ok(transactionService.create(book));
    }

    @PostMapping("/{id}")
    public ResponseEntity<TransactionDto> update(@PathVariable Long id, @RequestBody TransactionDto transactionDto) {

        transactionDto.setId(id);

        return ResponseEntity.ok(transactionService.update(transactionDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransactionDto> getById(@PathVariable Long id) {
        TransactionDto TransactionDto = transactionService.findById(id).orElseThrow(ResourceNotFond::new);
        return ResponseEntity.ok(TransactionDto);
    }

}

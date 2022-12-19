package pl.camp.micro.book.store.database.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.camp.micro.book.store.model.Book;
import pl.camp.micro.book.store.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long >  {
}

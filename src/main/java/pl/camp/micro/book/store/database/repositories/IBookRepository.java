package pl.camp.micro.book.store.database.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import pl.camp.micro.book.store.model.Book;

import java.util.List;

public interface IBookRepository extends JpaRepository<Book, Integer>, JpaSpecificationExecutor<Book> {

    Page<Book> findByTitle(String title, Pageable pageable);

    @Query(value = "SELECT b FROM Book b where b.quantity > 0")
    List<Book> findAvailableBooks();

    @Query(value = "SELECT b, t FROM Book b LEFT join fetch b.transactions t", countQuery = "SELECT count(b) FROM Book b")
    Page<Book> findAllWitTransaction(Pageable pageable);
}

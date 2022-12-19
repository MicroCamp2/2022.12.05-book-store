package pl.camp.micro.book.store.database.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.camp.micro.book.store.model.Book;

public interface IBookRepository extends JpaRepository<Book, Integer > {

}
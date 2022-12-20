package pl.camp.micro.book.store.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import pl.camp.micro.book.store.database.repositories.IBookRepository;
import pl.camp.micro.book.store.model.Book;

import javax.annotation.PostConstruct;

@Configuration
@Profile("dev")
public class InitDatabaseConfiguration {

    @Autowired
    IBookRepository iBookRepository;

    @PostConstruct
    public void init() {
        if (iBookRepository.count() == 0) {
            iBookRepository.save(new Book(null, "Tytul 1", "Autor 1", 34.34, 10));
            iBookRepository.save(new Book(null, "Tytul 2", "Autor 2", 12.45, 10));
            iBookRepository.save(new Book(null, "Tytul 3", "Autor 3", 54.43, 10));
            iBookRepository.save(new Book(null, "Tytul 4", "Autor 4", 23.67, 10));
            iBookRepository.save(new Book(null, "Tytul 5", "Autor 5", 39.43, 10));
            iBookRepository.save(new Book(null, "Tytul 6", "Autor 6", 56.66, 10));
        }
    }
}

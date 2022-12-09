package pl.camp.micro.book.store.configuration;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import pl.camp.micro.book.store.database.IBookDB;
import pl.camp.micro.book.store.database.IUserDB;
import pl.camp.micro.book.store.database.impl.BookDB;
import pl.camp.micro.book.store.database.impl.UserDBStub;

@Configuration
@ComponentScan({
        "pl.camp.micro.book.store.controllers",
        "pl.camp.micro.book.store.services",
        "pl.camp.micro.book.store.session"
})
public class TestConfiguration {

    /*@Bean
    public IUserDB userDB() {
        return Mockito.mock(IUserDB.class);
    }

    @Bean
    public IBookDB bookDB() {
        return new BookDB();
    }*/
}

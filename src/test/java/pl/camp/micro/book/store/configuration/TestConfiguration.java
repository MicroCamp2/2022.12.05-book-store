package pl.camp.micro.book.store.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan({
        "pl.camp.micro.book.store.controllers",
        "pl.camp.micro.book.store.services",
        "pl.camp.micro.book.store.session"
})
@EnableJpaRepositories("pl.camp.micro.book.store.database.repositories")
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

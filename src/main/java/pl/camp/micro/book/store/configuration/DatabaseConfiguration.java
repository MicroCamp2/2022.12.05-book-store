package pl.camp.micro.book.store.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Optional;

@Configuration
@EnableJpaRepositories("pl.camp.micro.book.store.database.repositories")
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class DatabaseConfiguration {


    @Bean
    public AuditorAware<String> auditorProvider() {
        return () -> Optional.ofNullable("Krzysztof");
    }
}

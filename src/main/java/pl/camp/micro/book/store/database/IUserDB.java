package pl.camp.micro.book.store.database;

import pl.camp.micro.book.store.model.User;

import java.util.Optional;

public interface IUserDB {
    Optional<User> getUserByLogin(String login);
}

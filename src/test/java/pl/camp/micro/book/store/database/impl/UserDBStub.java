package pl.camp.micro.book.store.database.impl;

import pl.camp.micro.book.store.database.IUserDB;
import pl.camp.micro.book.store.model.User;

import java.util.Optional;

public class UserDBStub implements IUserDB {
    @Override
    public Optional<User> getUserByLogin(String login) {
        if (login.equals("admin")) {
            return Optional.of(new User(1, "admin",
                    "21232f297a57a5a743894a0e4a801fc3"));
        } else if (login.equals("janusz")) {
            return Optional.empty();
        }

        return Optional.empty();
    }
}

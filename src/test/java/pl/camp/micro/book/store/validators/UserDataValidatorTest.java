package pl.camp.micro.book.store.validators;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.camp.micro.book.store.exceptions.UserValidationException;

class UserDataValidatorTest {

    @Test
    void correctLoginValidationTest() {
        String login = "mateusz";

        UserDataValidator.validateLogin(login);
    }

    @Test
    void incorrectLoginValidationTest() {
        String login = "abc";

        Assertions.assertThrows(UserValidationException.class,
                () -> UserDataValidator.validateLogin(login));
    }

    @Test
    void correctPasswordValidationTest() {
        String password = "haslo";

        UserDataValidator.validatePassword(password);
    }

    @Test
    void incorrectPasswordValidationTest() {
        String password = "abc";

        Assertions.assertThrows(UserValidationException.class,
                () -> UserDataValidator.validatePassword(password));
    }
}

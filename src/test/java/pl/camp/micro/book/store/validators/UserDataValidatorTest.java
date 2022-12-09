package pl.camp.micro.book.store.validators;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import pl.camp.micro.book.store.exceptions.UserValidationException;

public class UserDataValidatorTest {

    @Test
    public void correctLoginValidationTest() {
        String login = "mateusz";

        UserDataValidator.validateLogin(login);
    }

    @Test
    public void incorrectLoginValidationTest() {
        String login = "abc";

        Assertions.assertThrows(UserValidationException.class,
                () -> UserDataValidator.validateLogin(login));
    }

    @Test
    public void correctPasswordValidationTest() {
        String password = "haslo";

        UserDataValidator.validatePassword(password);
    }

    @Test
    public void incorrectPasswordValidationTest() {
        String password = "abc";

        Assertions.assertThrows(UserValidationException.class,
                () -> UserDataValidator.validatePassword(password));
    }
}

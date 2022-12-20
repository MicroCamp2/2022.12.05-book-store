package pl.camp.micro.book.store.validators;

import pl.camp.micro.book.store.exceptions.UserValidationException;

public class UserDataValidator {
    private UserDataValidator() {
    }

    public static void validateLogin(String login) {
        String regex = "^.{5,}$";
        if (!login.matches(regex)) {
            throw new UserValidationException("Login incorrect");
        }
    }

    public static void validatePassword(String password) {
        String regex = "^.{5,}$";
        if (!password.matches(regex)) {
            throw new UserValidationException("Password incorrect");
        }
    }
}

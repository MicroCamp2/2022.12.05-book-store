package pl.camp.micro.book.store.services.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import pl.camp.micro.book.store.App;
import pl.camp.micro.book.store.configuration.TestConfiguration;
import pl.camp.micro.book.store.database.IBookDB;
import pl.camp.micro.book.store.database.IUserDB;
import pl.camp.micro.book.store.model.User;
import pl.camp.micro.book.store.services.IAuthenticationService;
import pl.camp.micro.book.store.session.SessionObject;

import javax.annotation.Resource;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {App.class, TestConfiguration.class})
@WebAppConfiguration
class AuthenticationServiceTest {

    @Autowired
    IAuthenticationService authenticationService;

    @Resource
    SessionObject sessionObject;

    @MockBean
    IUserDB userDB;

    @MockBean
    IBookDB bookDB;

    @Test
    void correctAuthenticationTest() {
        Mockito
                .when(this.userDB.getUserByLogin(Mockito.any()))
                .thenReturn(Optional.of(new User(1, "admin",
                        "21232f297a57a5a743894a0e4a801fc3")));
        String login = "admin";
        String password = "admin";
        this.sessionObject.setLogged(false);

        this.authenticationService.authenticate(login, password);

        Assertions.assertTrue(this.sessionObject.isLogged());
    }

    @Test
    void incorrectAuthenticationTest() {
        Mockito
                .when(this.userDB.getUserByLogin(Mockito.any()))
                .thenReturn(Optional.empty());
        String login = "janusz";
        String password = "janusz";
        this.sessionObject.setLogged(false);

        this.authenticationService.authenticate(login, password);

        Assertions.assertFalse(this.sessionObject.isLogged());
    }

    @Test
    void logoutTest() {
        this.sessionObject.setLogged(true);

        this.authenticationService.logout();

        Assertions.assertFalse(this.sessionObject.isLogged());
    }
}

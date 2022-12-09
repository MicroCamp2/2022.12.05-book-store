package pl.camp.micro.book.store.services.impl;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.camp.micro.book.store.database.IUserDB;
import pl.camp.micro.book.store.model.User;
import pl.camp.micro.book.store.services.IAuthenticationService;
import pl.camp.micro.book.store.session.SessionObject;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class AuthenticationService implements IAuthenticationService {

    @Autowired
    IUserDB userDB;

    @Resource
    SessionObject sessionObject;

    @Override
    public void authenticate(String login, String password) {
        Optional<User> userFromDb = this.userDB.getUserByLogin(login);
        if(userFromDb.isPresent() &&
                userFromDb.get().getPassword()
                        .equals(DigestUtils.md5Hex(password))) {
            this.sessionObject.setLogged(true);
        }
    }

    @Override
    public void logout() {
        this.sessionObject.setLogged(false);
    }
}

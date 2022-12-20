package pl.camp.micro.book.store.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.camp.micro.book.store.exceptions.UserValidationException;
import pl.camp.micro.book.store.model.User;
import pl.camp.micro.book.store.services.IAuthenticationService;
import pl.camp.micro.book.store.session.SessionObject;
import pl.camp.micro.book.store.validators.UserDataValidator;

import javax.annotation.Resource;

@Controller
@Slf4j
public class AuthenticationController {

    @Autowired
    private IAuthenticationService authenticationService;

    @Resource
    private SessionObject sessionObject;

    @GetMapping(path = "/login")
    public String login(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("logged", this.sessionObject.isLogged());
        return "login";
    }

    @PostMapping(path = "/login")
    public String login(@ModelAttribute User user) {
        try {
            UserDataValidator.validateLogin(user.getLogin());
            UserDataValidator.validatePassword(user.getPassword());
        } catch (UserValidationException e) {
            log.warn("User validation " + e.getMessage(), e);
            return "redirect:/login";
        }
        this.authenticationService.authenticate(user.getLogin(), user.getPassword());
        if (this.sessionObject.isLogged()) {
            return "redirect:/main";
        }
        return "redirect:/login";
    }

    @GetMapping(path = "/logout")
    public String logout() {
        this.authenticationService.logout();
        return "redirect:/login";
    }
}

package pl.camp.micro.book.store.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.camp.micro.book.store.exceptions.UserValidationException;
import pl.camp.micro.book.store.model.User;
import pl.camp.micro.book.store.services.IAuthenticationService;
import pl.camp.micro.book.store.session.SessionObject;
import pl.camp.micro.book.store.validators.UserDataValidator;

import javax.annotation.Resource;

@Controller
public class AuthenticationController {

    @Autowired
    private IAuthenticationService authenticationService;

    @Resource
    private SessionObject sessionObject;

    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public String login(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("logged", this.sessionObject.isLogged());
        return "login";
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute User user) {
        try {
            UserDataValidator.validateLogin(user.getLogin());
            UserDataValidator.validatePassword(user.getPassword());
        } catch (UserValidationException e) {
            System.out.println(e.getMessage());
            return "redirect:/login";
        }
        this.authenticationService.authenticate(user.getLogin(), user.getPassword());
        if(this.sessionObject.isLogged()) {
            return "redirect:/main";
        }
        return "redirect:/login";
    }

    @RequestMapping(path = "/logout", method = RequestMethod.GET)
    public String logout() {
        this.authenticationService.logout();
        return "redirect:/login";
    }
}

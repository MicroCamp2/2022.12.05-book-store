package pl.camp.micro.book.store.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.camp.micro.book.store.services.IBookService;
import pl.camp.micro.book.store.session.SessionObject;

import javax.annotation.Resource;

@Controller
public class CommonController {

    private final IBookService bookService;

    @Resource
    private SessionObject sessionObject;

    public CommonController(IBookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(path = "/")
    public String main(Model model) {
        model.addAttribute("books", this.bookService.getBooks());
        model.addAttribute("logged", this.sessionObject.isLogged());
        return "main";
    }

    @GetMapping(path = "/main")
    public String main() {
        return "redirect:/";
    }

    @GetMapping(path = "/contact")
    public String contact(Model model) {
        model.addAttribute("logged", this.sessionObject.isLogged());
        return "contact";
    }
}

package pl.camp.micro.book.store.controllers.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.camp.micro.book.store.model.User;

@RestController
public class SimpleRestController {

    @RequestMapping(path = "/user", method = RequestMethod.GET)
    public User getUser() {
        return new User(1, "admin", "admin");
    }

    @RequestMapping(path = "/user", method = RequestMethod.POST)
    public User user(@RequestBody User user) {
        System.out.println(user.getId());
        System.out.println(user.getLogin());
        System.out.println(user.getPassword());

        return new User(1234, "asdfasdf", "askjhdg324");
    }

    @RequestMapping(path = "/user/{id}/{login}", method = RequestMethod.PUT)
    public User user(@RequestBody(required = false) User user,
                     @PathVariable int id,
                     @PathVariable String login,
                     @RequestParam(required = false) Integer param1,
                     @RequestParam(required = false) String param2,
                     @RequestHeader(required = false) String header1,
                     @RequestHeader(required = false) String header2) {
        System.out.println(user.getId());
        System.out.println(user.getLogin());
        System.out.println(user.getPassword());
        System.out.println(id);
        System.out.println(login);
        System.out.println(param1);
        System.out.println(param2);
        System.out.println(header1);
        System.out.println(header2);

        return new User(345, "asdfasdrfa324234", "23423sdfw34safed");
    }

    @RequestMapping(path = "/user2", method = RequestMethod.GET)
    public ResponseEntity<User> user2() {
        return ResponseEntity
                .status(HttpStatus.NOT_ACCEPTABLE)
                .header("h1", "value1")
                .header("h2", "value2")
                .body(new User(1, "jan", "kowalski"));
    }
}

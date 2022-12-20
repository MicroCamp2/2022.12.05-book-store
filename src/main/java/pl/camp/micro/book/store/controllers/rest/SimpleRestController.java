package pl.camp.micro.book.store.controllers.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.camp.micro.book.store.model.User;

@RestController
@Slf4j
public class SimpleRestController {

    @GetMapping(path = "/user")
    public User getUser() {
        return new User(1, "admin", "admin");
    }

    @PostMapping(path = "/user")
    public User user(@RequestBody User user) {
        log.info("/user request {} {} {}", user.getId(), user.getLogin(), user.getPassword());

        return new User(1234, "asdfasdf", "askjhdg324");
    }

    @PutMapping(path = "/user/{id}/{login}")
    public User user(@RequestBody(required = false) User user,
                     @PathVariable int id,
                     @PathVariable String login,
                     @RequestParam(required = false) Integer param1,
                     @RequestParam(required = false) String param2,
                     @RequestHeader(required = false) String header1,
                     @RequestHeader(required = false) String header2) {

        log.info("/user/{id}/{login} request {} {} {}", user.getId(), user.getLogin(), user.getPassword());
        log.info("/user/{id}/{login} request {} {} {} {} {} {}", id, login, param1, param2, header1, header2);


        return new User(345, "asdfasdrfa324234", "23423sdfw34safed");
    }

    @GetMapping(path = "/user2")
    public ResponseEntity<User> user2() {
        return ResponseEntity
                .status(HttpStatus.NOT_ACCEPTABLE)
                .header("h1", "value1")
                .header("h2", "value2")
                .body(new User(1, "jan", "kowalski"));
    }
}

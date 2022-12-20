package pl.camp.micro.book.store.database;

import org.springframework.jdbc.core.JdbcTemplate;
import pl.camp.micro.book.store.model.Book;

import javax.annotation.PostConstruct;
import java.util.List;

public class BookDbJDBC implements IBookDB {
    private final JdbcTemplate jdbcTemplate;

    public BookDbJDBC(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostConstruct
    public void init() {
        jdbcTemplate.execute("CREATE TABLE BOOK (id Integer, title varchar2(255), author varchar2(255), price number, quantity number )");
        this.create(new Book(1, "Tytul 1", "Autor 1", 34.34, 10));
        this.create(new Book(2, "Tytul 2", "Autor 2", 12.45, 10));
        this.create(new Book(3, "Tytul 3", "Autor 3", 54.43, 10));
        this.create(new Book(4, "Tytul 4", "Autor 4", 23.67, 10));
        this.create(new Book(5, "Tytul 5", "Autor 5", 39.43, 10));
        this.create(new Book(6, "Tytul 6", "Autor 6", 56.66, 10));
    }

    @Override
    public List<Book> getBooks() {
        return jdbcTemplate.query("SELECT * FROM BOOK", (rs, rowNum) ->
                new Book(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getDouble("price"),
                        rs.getInt("quantity")
                ));
    }

    public Book create(Book book) {
        jdbcTemplate.update("INSERT INTO BOOK(id, title, author, price, quantity) values ( ?, ?, ?, ?, ? )",
                book.getId(), book.getTitle(), book.getAuthor(), book.getPrice(), book.getQuantity());

        return book;
    }
}

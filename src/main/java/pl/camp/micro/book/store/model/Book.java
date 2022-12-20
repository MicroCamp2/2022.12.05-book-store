package pl.camp.micro.book.store.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.Instant;
import java.util.Set;

@Data
@Table(name = "BOOK")
@Entity
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String author;
    private double price;
    private int quantity;

    @OneToMany(mappedBy = "book", fetch = FetchType.EAGER)
    private Set<Transaction> transactions;

    @LastModifiedDate
    private Instant lastModifiedDate;

    @CreatedDate
    @Column(updatable = false)
    private Instant createdDate;

    @LastModifiedBy
    private String lastModifiedBy;

    @CreatedBy
    @Column(updatable = false)
    private String createdBy;

    @Version
    private int version;

    public Book(Integer id, String title, String author, double price, int quantity) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
        this.quantity = quantity;
    }

}

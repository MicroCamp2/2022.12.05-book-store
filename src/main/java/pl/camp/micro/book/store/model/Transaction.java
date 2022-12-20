package pl.camp.micro.book.store.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@Data
@Entity
@Table
@NoArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Instant transactionDate;
    @Column(nullable = false)
    private BigDecimal price;
    private BigDecimal discount;
    @Lob
    private String comment;
    @ManyToOne()
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

}

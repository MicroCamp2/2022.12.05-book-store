package pl.camp.micro.patterns;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@Builder
@ToString
public class Position {
    private Book book;
    private int quantity;

}

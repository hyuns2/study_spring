package study.kyh.mvc2.domain.item;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Item {

    private Long id;
    private String itemName;
    private Integer price;
    private Integer quantity;

}

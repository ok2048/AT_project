package dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class CartDto {
    private String name;
    private String category;
    private Float price;
    private Integer discount;
    private Integer quantity;
}
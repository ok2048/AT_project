package dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ProductDto {
    private Integer id;
    private String name;
    private String category;
    private Float price;
    private Float discount;
}
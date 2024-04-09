package dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class CartItemDto {
    @JsonProperty("product_id")
    private Integer productId;
    private Integer quantity;
}

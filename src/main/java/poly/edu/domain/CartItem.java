package poly.edu.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItem {
	private Long productId;
    private String name;
    private double unitPrice;
    private double discount;
    private String image;
    private int qty=1;
    
    
}

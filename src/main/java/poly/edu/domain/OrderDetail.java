package poly.edu.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orderdetails")
public class OrderDetail implements Serializable{
	@Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long orderDetailId;


	@Column(nullable = false)
  private int quantity;
	@Column(nullable = false)
  private double initPrice;
	
//	@Column(nullable = false)
//	  private Long orderId;
//	@Column(nullable = false)
//	  private Long productId;
	
	
	
	
	
	
	@ManyToOne
	@JoinColumn(name = "productId")
	private Product product;
	
	
	@ManyToOne
	@JoinColumn(name="orderId")
	private Order order;
}

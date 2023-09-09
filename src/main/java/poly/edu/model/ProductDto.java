package poly.edu.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
	
   private Long productId;
	
   private String name;
	
   private int quantity;
	
   private double unitPrice;
	
   private String image;
   private MultipartFile imageFile;
	
   private String description;
	
   private double discount;
	
	private Date enteredDate;
	
   private short status;
	private Long categoryId;
	
	private Boolean isEdit;
}

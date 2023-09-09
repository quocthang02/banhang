package poly.edu.model;

import java.io.Serializable;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto implements Serializable {
	
	private Long categoryId;
   @NotEmpty
   @Length(min=2)
   private String name;
   
   private Boolean isEdit = false;
}

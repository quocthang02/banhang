package poly.edu.model;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import poly.edu.domain.Account;
import poly.edu.domain.AccountRole;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto implements Serializable{
	@NotEmpty
	@Length(min=2)
     private String username;
	@Length(min=2)
	@NotEmpty
     private String password;
	
	
	
	private String fullname;
	private Boolean isEdit = false;
	private AccountRole role;
	private String currentPassword;
	private String newPassword;
	
//	@NotEmpty
//	@Length(min= 4)
//	private String username;
//	@NotEmpty
//	@Length(min= 4)
//	private String password;
//	private String fullname;
//	private Boolean isEdit = false;
//	private AccountRole role;
//	private String currentPassword;
//	private String newPassword;
}
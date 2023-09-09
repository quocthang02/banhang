package poly.edu.controller.admin;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionIdListener;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import poly.edu.domain.Account;
import poly.edu.model.AccountDto;
import poly.edu.model.AdminLoginDto;
import poly.edu.sevice.AccountService;

@Controller
public class LoginController {
     @Autowired
     private AccountService accountService;
     
     @Autowired
     private HttpSession session;
     
     @GetMapping("login")
     public String login(Model model) {
    	 model.addAttribute("account", new AdminLoginDto() );
    	
    	 return "admin/accounts/login";
     }
     
   
    
     
     @PostMapping("login")
     public ModelAndView ulogin(ModelMap model,
    		        @Valid  @ModelAttribute("account") AdminLoginDto dto,
    		        BindingResult result) {
    	 if (result.hasErrors()) {
			return new ModelAndView("admin/accounts/login", model);
		}
    	 Account account = accountService.login(dto.getUsername(), dto.getPassword());
    	 
    	 if(account == null) {
    		 model.addAttribute("message", "INvalid username or password");
    		 return new ModelAndView("admin/accounts/login", model);
    	 }
    	 session.setAttribute("username", account.getUsername());
    	 session.setAttribute("fullname", account.getFullname());
      	session.setAttribute("role", account.getRole());
//    	 Object ruri = session.getAttribute("redirect-uri");//Kiểm tra đăng nhập chưa
//    	 if (ruri != null) {
//    		 session.removeAttribute("redirect-uri");
//    		 
//			return new ModelAndView("redirect: " + ruri);
//		}
    	 
    	 
    	 
    	 
 //   	 return new ModelAndView("admin/products/homesite", model);
    	 return new ModelAndView("forward:/home", model);
     }
     
//     @PostMapping("alogin")
//     public ModelAndView login(ModelMap model, 
//     		@Valid @ModelAttribute("account") AdminLoginDto dto,
//     		BindingResult result) {
//     	if(result.hasErrors()) {
//     		return new ModelAndView("/admin/accounts/login2", model);
//     		
//     	}
//     	Account account = accountService.login(dto.getUsername(), dto.getPassword());
//     	if(account == null) {
//     		model.addAttribute("message", "Vui long kiem tra lai TK va MK");
//     		return new ModelAndView("/admin/accounts/login2", model);
//     	}
//     	session.setAttribute("username", account.getUsername());
//     	session.setAttribute("fullname", account.getFullname());
//     	session.setAttribute("role", account.getRole());
////     	Object ruri = session.getAttribute("redirect-uri");
////     	if(ruri !=null) {
////     		session.removeAttribute("redirect-uri");
////     		return new ModelAndView("redirect:" +ruri);
////     		
////     	}
//     	
//     	return new ModelAndView("forward:/home/", model);
//     	
//     }
     @GetMapping("dangky")
     public String add(Model model) {
  	   model.addAttribute("account", new AccountDto());
  	   return "admin/accounts/addOrEdit";
     }
     
     @GetMapping("admin/login")
     public String adminlogin(Model model) {
  	   model.addAttribute("account", new AccountDto());
  	   return "admin/accounts/adminlogin";
     }
     
     
     @PostMapping("admin/login")
     public ModelAndView adminlogin(ModelMap model,
    		        @Valid  @ModelAttribute("account") AdminLoginDto dto,
    		        BindingResult result) {
    	 if (result.hasErrors()) {
			return new ModelAndView("admin/accounts/adminlogin", model);
		}
    	 Account account = accountService.login(dto.getUsername(), dto.getPassword());
    	 
    	 if(account == null) {
    		 model.addAttribute("message", "INvalid username or password");
    		 return new ModelAndView("admin/accounts/adminlogin", model);
    	 }
    	 session.setAttribute("username", account.getUsername());
    	 Object ruri = session.getAttribute("redirect-uri");//Kiểm tra đăng nhập chưa
    	 if (ruri != null) {
    		 session.removeAttribute("redirect-uri");
			return new ModelAndView("redirect: " + ruri);
		}
    	 
    	 
    	// return new ModelAndView("admin/products/homeadmin", model);
    	 return new ModelAndView("forward:/admin/home", model);
     }
     @PostMapping("/logout")
     public String logout(HttpSession session) {
         // Xóa các thuộc tính liên quan đến đăng nhập khỏi session
         session.removeAttribute("username");
         session.removeAttribute("fullname");
         session.removeAttribute("role");
         
         // Chuyển hướng về trang đăng nhập
         return "redirect:/home";
     }
}

package poly.edu.controller.site;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import poly.edu.domain.Account;
import poly.edu.model.AccountDto;
import poly.edu.model.AccountDto;
import poly.edu.sevice.AccountService;


@Controller
@RequestMapping("user")
public class UserController {
	@Autowired
	AccountService accountService;
   @GetMapping("add")
   public String add(Model model) {
	   model.addAttribute("account", new AccountDto());
	   return "admin/accounts/addOrEdit";
   }
   
   
   
   
   
   
   
 
   @PostMapping("saveAccount")
   public ModelAndView saveAccount(ModelMap model,@Valid @ModelAttribute("account") AccountDto dto, BindingResult result ) {
	   if (result.hasErrors()) {
		
		   return new ModelAndView("admin/accounts/addOrEdit");
	}
	   
	   Account entity = new Account();
	   BeanUtils.copyProperties(dto, entity);
	   
	   accountService.save(entity); 
	   model.addAttribute("message", "Account is saved");
	   return new ModelAndView("redirect:/login", model) ;
   }
   
  
}

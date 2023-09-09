package poly.edu.controller.admin;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import poly.edu.domain.Account;
import poly.edu.domain.Product;
import poly.edu.model.AdminLoginDto;
import poly.edu.sevice.ProductService;

@Controller

public class HomeController {
	
	@Autowired
	ProductService  productService;
	@GetMapping("home")
	   public String search(ModelMap model, 
			   @RequestParam(name= "name", required = false) String name, 
			   @RequestParam(name= "category", required = false) String category,
			   @RequestParam("page") Optional<Integer> page,
			   @RequestParam("size") Optional<Integer> size) {
		   int currentPage= page.orElse(0);
		   int pageSize = size.orElse(16);
		   
		   Pageable pageable = PageRequest.of(currentPage, pageSize, Sort.by("name"));
		   Page<Product> resultPage = null;
		   
		   if(StringUtils.hasText(name)) {
			   resultPage = productService.findByNameContaining(name, pageable);
		   }else {
			resultPage = productService.findAll(pageable);
		}

		   int totalPages =resultPage.getTotalPages();
		   if(totalPages > 0) {
			   int start = Math.max(1, currentPage - 1);
			   int end = Math.min(currentPage + 1, totalPages);
		     if(totalPages > 5) {
		    	 if(end == totalPages) start = end - 5;
		    	 else if(start == 1) end = start + 5;
		     }
		     List<Integer> pageNumbers = IntStream.rangeClosed(start, end)
		    		                               .boxed().collect(Collectors.toList());
		    model.addAttribute("pageNumbers", pageNumbers);
		   }
		   
		   model.addAttribute("productPage", resultPage );
		   
		   return "/admin/products/home";
	   }
	
	
	@RequestMapping("user/home")
	   public String site(ModelMap model, 
			   @RequestParam(name= "name", required = false) String name, 
			   @RequestParam(name= "category", required = false) String category,
			   @RequestParam("page") Optional<Integer> page,
			   @RequestParam("size") Optional<Integer> size) {
		   int currentPage= page.orElse(0);
		   int pageSize = size.orElse(16);
		   
		   Pageable pageable = PageRequest.of(currentPage, pageSize, Sort.by("name"));
		   Page<Product> resultPage = null;
		   
		   if(StringUtils.hasText(name)) {
			   resultPage = productService.findByNameContaining(name, pageable);
		   }else {
			resultPage = productService.findAll(pageable);
		}

		   int totalPages =resultPage.getTotalPages();
		   if(totalPages > 0) {
			   int start = Math.max(1, currentPage - 1);
			   int end = Math.min(currentPage + 1, totalPages);
		     if(totalPages > 5) {
		    	 if(end == totalPages) start = end - 5;
		    	 else if(start == 1) end = start + 5;
		     }
		     List<Integer> pageNumbers = IntStream.rangeClosed(start, end)
		    		                               .boxed().collect(Collectors.toList());
		    model.addAttribute("pageNumbers", pageNumbers);
		   }
		   
		   model.addAttribute("productPage", resultPage );
		   
		   return "/admin/products/homesite";
	   }
	
	 
	@GetMapping("admin/home")
	   public String admin(ModelMap model, 
			   @RequestParam(name= "name", required = false) String name, 
			   @RequestParam(name= "category", required = false) String category,
			   @RequestParam("page") Optional<Integer> page,
			   @RequestParam("size") Optional<Integer> size) {
		   int currentPage= page.orElse(0);
		   int pageSize = size.orElse(16);
		   
		   Pageable pageable = PageRequest.of(currentPage, pageSize, Sort.by("name"));
		   Page<Product> resultPage = null;
		   
		   if(StringUtils.hasText(name)) {//tìm theo tên 
			   resultPage = productService.findByNameContaining(name, pageable);
		   }else {
			resultPage = productService.findAll(pageable);
		}

		   int totalPages =resultPage.getTotalPages();
		   if(totalPages > 0) {
			   int start = Math.max(1, currentPage - 1);
			   int end = Math.min(currentPage + 1, totalPages);
		     if(totalPages > 5) {
		    	 if(end == totalPages) start = end - 5;
		    	 else if(start == 1) end = start + 5;
		     }
		     List<Integer> pageNumbers = IntStream.rangeClosed(start, end)
		    		                               .boxed().collect(Collectors.toList());
		    model.addAttribute("pageNumbers", pageNumbers);
		   }
		   
		   model.addAttribute("productPage", resultPage );
		   
		   return "/admin/products/homeadmin";
	   }
}

package poly.edu.controller.site;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import poly.edu.domain.CartItem;

import poly.edu.domain.Product;
import poly.edu.sevice.ProductService;
import poly.edu.sevice.ShoppingCartService;

@Controller
@RequestMapping("shopping-cart")
public class ShoppingCartController {
	@Autowired
	ProductService productService;
	@Autowired
	ShoppingCartService cartService;
	@GetMapping("views")
   public String viewCarts(Model model) {
		model.addAttribute("CART_ITEMS", cartService.getAllItem());
		model.addAttribute("TOTAL", cartService.getAmount());
		
		return "admin/shop/cart-item";
	   
   }
	@GetMapping("thanhtoan")
	   public String viewThanhtoan(Model model) {
			model.addAttribute("CART_ITEMS", cartService.getAllItem());
			model.addAttribute("TOTAL", cartService.getAmount());
			
			return "admin/shop/thanhtoan";
		   
	   }
	@GetMapping("add/{productId}")
	public String addCart(ModelMap model, @PathVariable("productId") Long productId) {
		
		Optional<Product> opt = productService.findById(productId);
           //System.out.println("San Pham ------" +opt.get());
		   if(opt !=null) {
			   CartItem item = new CartItem();
			   BeanUtils.copyProperties(opt.get(), item);
			   item.setQty(1);
			   cartService.add(item);
			  
			   
		   }
		   return "redirect:/shopping-cart/views";
	}
	@GetMapping("clear")
	public String clearCart() {
		cartService.clear();
		return "redirect:/shopping-cart/views";
	}
	
	@GetMapping("del/{productId}")
	public String removeCart(@PathVariable("productId") Long productId) {
		cartService.remoce(productId);
		return "redirect:/shopping-cart/views";
	}
	
	@PostMapping("update")
	public String update(@RequestParam("id") Long id, @RequestParam("qty") Integer qty) {
		cartService.update(id, qty);
		return "redirect:/shopping-cart/views";
	}
}

package poly.edu.sevice.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import poly.edu.domain.CartItem;
import poly.edu.sevice.ShoppingCartService;



@SessionScope
@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
   Map<Long, CartItem> maps = new HashMap<>();
   @Override
   public void add(CartItem item) {
	   CartItem cartItem = maps.get(item.getProductId());
	   if(cartItem == null) {
		   maps.put(item.getProductId(), item);
	   }else {
		cartItem.setQty(cartItem.getQty()+1);
	}
   }
   @Override
public void remoce(Long productId) {
	   maps.remove(productId);
   }
   @Override
public CartItem update(Long productId, int qty) {
	   CartItem cartItem = maps.get(productId);
	   cartItem.setQty(qty);
	  
	   return cartItem;
	   
   }
   @Override
public void clear() {
	   maps.clear();
   }
   
   
   @Override
public Collection<CartItem> getAllItem(){
	   return maps.values();
   }
   
   @Override
public int getCount() {
	   return maps.values().size();
   }
   
   @Override
public double getAmount() {
	return maps.values().stream()
			.mapToDouble(item -> item.getQty() * item.getUnitPrice() - item.getDiscount()*item.getQty() )
					.sum();
	   
   }
}

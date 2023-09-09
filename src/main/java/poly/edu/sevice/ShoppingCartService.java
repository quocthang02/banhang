package poly.edu.sevice;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import poly.edu.domain.CartItem;
import poly.edu.domain.OrderDetail;
import poly.edu.model.CartItemDto;





public interface ShoppingCartService {

	double getAmount();

	int getCount();

	Collection<CartItem> getAllItem();

	void clear();

	CartItem update(Long productId, int qty);

	void remoce(Long productId);

	void add(CartItem item);


	
	
    


}

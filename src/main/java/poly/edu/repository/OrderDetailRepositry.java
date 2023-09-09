package poly.edu.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import poly.edu.domain.Category;
import poly.edu.domain.OrderDetail;

@Repository
public interface OrderDetailRepositry extends JpaRepository<OrderDetail, Long>{
		
	}


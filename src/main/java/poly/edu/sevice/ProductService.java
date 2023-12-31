package poly.edu.sevice;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import poly.edu.domain.Category;
import poly.edu.domain.Product;

public interface ProductService {

	<S extends Product> List<S> findAll(Example<S> example, Sort sort);

	<S extends Product> List<S> findAll(Example<S> example);

	void deleteAll();

	Product getReferenceById(Long id);

	void deleteAll(Iterable<? extends Product> entities);

	void deleteAllById(Iterable<? extends Long> ids);

	Product getById(Long id);

	void delete(Product entity);

	Product getOne(Long id);

	void deleteById(Long id);

	void deleteAllInBatch();

	long count();

	<S extends Product, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction);

	void deleteAllByIdInBatch(Iterable<Long> ids);

	<S extends Product> boolean exists(Example<S> example);

	void deleteAllInBatch(Iterable<Product> entities);

	<S extends Product> long count(Example<S> example);

	boolean existsById(Long id);

	void deleteInBatch(List<Product> entities);

	Optional<Product> findById(Long id);

	<S extends Product> Page<S> findAll(Example<S> example, Pageable pageable);

	List<Product> saveAllAndFlush(List<Product> entities);

	Product saveAndFlush(Product entity);

	void flush();

	List<Product> saveAll(List<Product> entities);

	List<Product> findAllById(List<Long> ids);

	List<Product> findAll(Sort sort);

	Page<Product> findAll(Pageable pageable);

	List<Product> findAll();

	<S extends Product> Optional<S> findOne(Example<S> example);

	Product save(Product entity);

	Page<Product> findByNameContaining(String name, Pageable pageable);

	Page<Product> findByNameContaining(Category category, Pageable pageable);

}

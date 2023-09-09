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

public interface CategoryService {

	<S extends Category> List<S> findAll(Example<S> example, Sort sort);

	<S extends Category> List<S> findAll(Example<S> example);

	void deleteAll();

	Category getReferenceById(Long id);

	void deleteAll(Iterable<? extends Category> entities);

	void deleteAllById(Iterable<? extends Long> ids);

	Category getById(Long id);

	void delete(Category entity);

	Category getOne(Long id);

	void deleteById(Long id);

	void deleteAllInBatch();

	long count();

	<S extends Category, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction);

	void deleteAllByIdInBatch(Iterable<Long> ids);

	<S extends Category> boolean exists(Example<S> example);

	void deleteAllInBatch(List<Category> entities);

	<S extends Category> long count(Example<S> example);

	boolean existsById(Long id);

	void deleteInBatch(Iterable<Category> entities);

	Optional<Category> findById(Long id);

	<S extends Category> Page<S> findAll(Example<S> example, Pageable pageable);

	<S extends Category> List<S> saveAllAndFlush(Iterable<S> entities);

	Category saveAndFlush(Category entity);

	void flush();

	List<Category> saveAll(List<Category> entities);

	List<Category> findAllById(List<Long> ids);

	List<Category> findAll(Sort sort);

	Page<Category> findAll(Pageable pageable);

	List<Category> findAll();

	<S extends Category> Optional<S> findOne(Example<S> example);

	Category save(Category entity);

	Page<Category> findByNameContaining(String name, Pageable pageable);

	

}

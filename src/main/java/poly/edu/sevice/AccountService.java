package poly.edu.sevice;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import poly.edu.domain.Account;

public interface AccountService {

	<S extends Account> List<S> findAll(Example<S> example, Sort sort);

	<S extends Account> List<S> findAll(Example<S> example);

	void deleteAll();

	Account getReferenceById(String id);

	void deleteAll(Iterable<? extends Account> entities);

	void deleteAllById(Iterable<? extends String> ids);

	Account getById(String id);

	void delete(Account entity);

	Account getOne(String id);

	void deleteById(String id);

	void deleteAllInBatch();

	long count();

	<S extends Account, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction);

	void deleteAllByIdInBatch(Iterable<String> ids);

	<S extends Account> boolean exists(Example<S> example);

	void deleteAllInBatch(Iterable<Account> entities);

	<S extends Account> long count(Example<S> example);

	boolean existsById(String id);

	void deleteInBatch(List<Account> entities);

	Optional<Account> findById(String id);

	Page<Account> findAll(Example<Account> example, Pageable pageable);

	List<Account> saveAllAndFlush(List<Account> entities);

	Account saveAndFlush(Account entity);

	void flush();

	List<Account> saveAll(List<Account> entities);

	List<Account> findAllById(List<String> ids);

	List<Account> findAll(Sort sort);

	Page<Account> findAll(Pageable pageable);

	List<Account> findAll();

	<S extends Account> Optional<S> findOne(Example<S> example);

	Account save(Account entity);

	Account login(String username, String password);

	Account findByUsernameAndPassword(String username, String password);

	Account findByUsername(String username);

}

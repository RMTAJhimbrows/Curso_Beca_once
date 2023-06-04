package once.curso.proyectotienda.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import lombok.Data;
import once.curso.proyectotienda.entities.User;
import once.curso.proyectotienda.repositories.UserRepository;

@Data
@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User save(User entity) {

		return getUserRepository().save(entity);
	}

	public Iterable<User> saveAll(Iterable<User> entities) {

		return getUserRepository().saveAll(entities);
	}

	public Optional<User> findById(Integer id) {

		return getUserRepository().findById(id);
	}

	public boolean existsById(Integer id) {

		return getUserRepository().existsById(id);
	}

	public Iterable<User> findAll() {

		return getUserRepository().findAll();
	}

	public Iterable<User> findAllById(Iterable<Integer> ids) {

		return getUserRepository().findAllById(ids);
	}

	public Iterable<User> findAll(Sort sort) {

		return getUserRepository().findAll(sort);
	}

	public Page<User> findAll(Pageable pageable) {

		return getUserRepository().findAll(pageable);
	}

	public long count() {

		return getUserRepository().count();
	}

	public void deleteById(Integer id) {
		getUserRepository().deleteById(id);
	}

	public void delete(User entity) {
		getUserRepository().delete(entity);
	}

	public void deleteAllById(Iterable<? extends Integer> ids) {
		getUserRepository().deleteAllById(ids);
	}

	public void deleteAll(Iterable<? extends User> entities) {
		getUserRepository().deleteAll(entities);
	}

	public void deleteAll() {
		getUserRepository().deleteAll();
	}
}

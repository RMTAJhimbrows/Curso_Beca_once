package once.curso.proyectotienda.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import lombok.Data;
import once.curso.proyectotienda.entities.Rol;
import once.curso.proyectotienda.repositories.RolRepository;

@Data
@Service
public class RolService {

	@Autowired
	private RolRepository rolRepository;

	public Rol save(Rol entity) {

		return getRolRepository().save(entity);
	}

	public Iterable<Rol> saveAll(Iterable<Rol> entities) {

		return getRolRepository().saveAll(entities);
	}

	public Optional<Rol> findById(Integer id) {

		return getRolRepository().findById(id);
	}

	public boolean existsById(Integer id) {

		return getRolRepository().existsById(id);
	}

	public Iterable<Rol> findAll() {

		return getRolRepository().findAll();
	}

	public Iterable<Rol> findAllById(Iterable<Integer> ids) {

		return getRolRepository().findAllById(ids);
	}

	public Iterable<Rol> findAll(Sort sort) {

		return getRolRepository().findAll(sort);
	}

	public Page<Rol> findAll(Pageable pageable) {

		return getRolRepository().findAll(pageable);
	}

	public long count() {

		return getRolRepository().count();
	}

	public void deleteById(Integer id) {
		getRolRepository().deleteById(id);
	}

	public void delete(Rol entity) {
		getRolRepository().delete(entity);
	}

	public void deleteAllById(Iterable<? extends Integer> ids) {
		getRolRepository().deleteAllById(ids);
	}

	public void deleteAll(Iterable<? extends Rol> entities) {
		getRolRepository().deleteAll(entities);
	}

	public void deleteAll() {
		getRolRepository().deleteAll();
	}
}

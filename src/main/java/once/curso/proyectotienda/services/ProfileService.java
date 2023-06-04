package once.curso.proyectotienda.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import lombok.Data;
import once.curso.proyectotienda.entities.Profile;
import once.curso.proyectotienda.repositories.ProfileRepository;

@Data
@Service
public class ProfileService {

	@Autowired
	private ProfileRepository profileRepository;

	public Profile save(Profile entity) {

		return getProfileRepository().save(entity);
	}

	public Iterable<Profile> saveAll(Iterable<Profile> entities) {

		return getProfileRepository().saveAll(entities);
	}

	public Optional<Profile> findById(Integer id) {

		return getProfileRepository().findById(id);
	}

	public boolean existsById(Integer id) {

		return getProfileRepository().existsById(id);
	}

	public Iterable<Profile> findAll() {

		return getProfileRepository().findAll();
	}

	public Iterable<Profile> findAllById(Iterable<Integer> ids) {

		return getProfileRepository().findAllById(ids);
	}

	public Iterable<Profile> findAll(Sort sort) {

		return getProfileRepository().findAll(sort);
	}

	public Page<Profile> findAll(Pageable pageable) {

		return getProfileRepository().findAll(pageable);
	}

	public long count() {

		return getProfileRepository().count();
	}

	public void deleteById(Integer id) {
		getProfileRepository().deleteById(id);
	}

	public void delete(Profile entity) {
		getProfileRepository().delete(entity);
	}

	public void deleteAllById(Iterable<? extends Integer> ids) {
		getProfileRepository().deleteAllById(ids);
	}

	public void deleteAll(Iterable<? extends Profile> entities) {
		getProfileRepository().deleteAll(entities);
	}

	public void deleteAll() {
		getProfileRepository().deleteAll();
	}
}

package once.curso.proyectotienda.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import lombok.Data;
import once.curso.proyectotienda.entities.Configuration;
import once.curso.proyectotienda.repositories.ConfigurationRepository;

@Data
@Service
public class ConfigurationService {

	@Autowired
	private ConfigurationRepository configurationRepository;

	public Configuration save(Configuration entity) {

		return getConfigurationRepository().save(entity);
	}

	public Iterable<Configuration> saveAll(Iterable<Configuration> entities) {

		return getConfigurationRepository().saveAll(entities);
	}

	public Optional<Configuration> findById(Integer id) {

		return getConfigurationRepository().findById(id);
	}

	public boolean existsById(Integer id) {

		return getConfigurationRepository().existsById(id);
	}

	public Iterable<Configuration> findAll() {

		return getConfigurationRepository().findAll();
	}

	public Iterable<Configuration> findAllById(Iterable<Integer> ids) {

		return getConfigurationRepository().findAllById(ids);

	}

	public Iterable<Configuration> findAll(Sort sort) {

		return getConfigurationRepository().findAll(sort);
	}

	public Page<Configuration> findAll(Pageable pageable) {

		return getConfigurationRepository().findAll(pageable);
	}

	public long count() {

		return getConfigurationRepository().count();
	}

	public void deleteById(Integer id) {
		getConfigurationRepository().deleteById(id);
	}

	public void delete(Configuration entity) {
		getConfigurationRepository().delete(entity);
	}

	public void deleteAllById(Iterable<? extends Integer> ids) {
		getConfigurationRepository().deleteAllById(ids);
	}

	public void deleteAll(Iterable<? extends Configuration> entities) {
		getConfigurationRepository().deleteAll(entities);
	}

	public void deleteAll() {
		getConfigurationRepository().deleteAll();
	}
}

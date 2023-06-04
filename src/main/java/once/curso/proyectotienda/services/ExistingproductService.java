package once.curso.proyectotienda.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import lombok.Data;
import once.curso.proyectotienda.entities.ExistingProduct;
import once.curso.proyectotienda.repositories.ExistingProductRepository;

@Data
@Service
public class ExistingproductService {

	@Autowired
	private ExistingProductRepository existingProductRepository;

	public ExistingProduct save(ExistingProduct entity) {

		return getExistingProductRepository().save(entity);
	}

	public Iterable<ExistingProduct> saveAll(Iterable<ExistingProduct> entities) {

		return getExistingProductRepository().saveAll(entities);
	}

	public Optional<ExistingProduct> findById(Integer id) {

		return getExistingProductRepository().findById(id);
	}

	public boolean existsById(Integer id) {

		return getExistingProductRepository().existsById(id);
	}

	public Iterable<ExistingProduct> findAll() {

		return getExistingProductRepository().findAll();
	}

	public Iterable<ExistingProduct> findAllById(Iterable<Integer> ids) {

		return getExistingProductRepository().findAllById(ids);
	}

	public Iterable<ExistingProduct> findAll(Sort sort) {

		return getExistingProductRepository().findAll(sort);
	}

	public Page<ExistingProduct> findAll(Pageable pageable) {

		return getExistingProductRepository().findAll(pageable);
	}

	public long count() {

		return getExistingProductRepository().count();
	}

	public void deleteById(Integer id) {
		getExistingProductRepository().deleteById(id);
	}

	public void delete(ExistingProduct entity) {
		getExistingProductRepository().delete(entity);
	}

	public void deleteAllById(Iterable<? extends Integer> ids) {
		getExistingProductRepository().deleteAllById(ids);
	}

	public void deleteAll(Iterable<? extends ExistingProduct> entities) {
		getExistingProductRepository().deleteAll(entities);
	}

	public void deleteAll() {
		getExistingProductRepository().deleteAll();
	}
}

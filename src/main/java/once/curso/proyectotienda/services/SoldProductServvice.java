package once.curso.proyectotienda.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import lombok.Data;
import once.curso.proyectotienda.entities.SoldProduct;
import once.curso.proyectotienda.repositories.SoldProductRepository;

@Data
@Service
public class SoldProductServvice {

	@Autowired
	private SoldProductRepository soldProductRepository;

	public SoldProduct save(SoldProduct entity) {

		return getSoldProductRepository().save(entity);
	}

	public Iterable<SoldProduct> saveAll(Iterable<SoldProduct> entities) {

		return getSoldProductRepository().saveAll(entities);
	}

	public Optional<SoldProduct> findById(Integer id) {

		return getSoldProductRepository().findById(id);
	}

	public boolean existsById(Integer id) {

		return getSoldProductRepository().existsById(id);
	}

	public Iterable<SoldProduct> findAll() {

		return getSoldProductRepository().findAll();
	}

	public Iterable<SoldProduct> findAllById(Iterable<Integer> ids) {

		return getSoldProductRepository().findAllById(ids);
	}

	public Iterable<SoldProduct> findAll(Sort sort) {

		return getSoldProductRepository().findAll(sort);
	}

	public Page<SoldProduct> findAll(Pageable pageable) {

		return getSoldProductRepository().findAll(pageable);
	}

	public long count() {

		return getSoldProductRepository().count();
	}

	public void deleteById(Integer id) {
		getSoldProductRepository().deleteById(id);

	}

	public void delete(SoldProduct entity) {
		getSoldProductRepository().delete(entity);

	}

	public void deleteAllById(Iterable<? extends Integer> ids) {
		getSoldProductRepository().deleteAllById(ids);

	}

	public void deleteAll(Iterable<? extends SoldProduct> entities) {
		getSoldProductRepository().deleteAll(entities);

	}

	public void deleteAll() {
		getSoldProductRepository().deleteAll();

	}
}

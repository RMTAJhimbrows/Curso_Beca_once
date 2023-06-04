package once.curso.proyectotienda.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import lombok.Data;
import once.curso.proyectotienda.entities.DocumentType;
import once.curso.proyectotienda.repositories.DocumentTypeRepository;

@Data
@Service
public class DocumentTypeService {

	@Autowired
	private DocumentTypeRepository documentTypeRepository;

	public DocumentType save(DocumentType entity) {

		return getDocumentTypeRepository().save(entity);
	}

	public Iterable<DocumentType> saveAll(Iterable<DocumentType> entities) {

		return getDocumentTypeRepository().saveAll(entities);
	}

	public Optional<DocumentType> findById(Integer id) {

		return getDocumentTypeRepository().findById(id);
	}

	public boolean existsById(Integer id) {

		return getDocumentTypeRepository().existsById(id);
	}

	public Iterable<DocumentType> findAll() {

		return getDocumentTypeRepository().findAll();
	}

	public Iterable<DocumentType> findAllById(Iterable<Integer> ids) {

		return getDocumentTypeRepository().findAllById(ids);
	}

	public Iterable<DocumentType> findAll(Sort sort) {

		return getDocumentTypeRepository().findAll(sort);
	}

	public Page<DocumentType> findAll(Pageable pageable) {

		return getDocumentTypeRepository().findAll(pageable);
	}

	public long count() {

		return getDocumentTypeRepository().count();
	}

	public void deleteById(Integer id) {
		getDocumentTypeRepository().deleteById(id);
	}

	public void delete(DocumentType entity) {
		getDocumentTypeRepository().delete(entity);
	}

	public void deleteAllById(Iterable<? extends Integer> ids) {
		getDocumentTypeRepository().deleteAllById(ids);
	}

	public void deleteAll(Iterable<? extends DocumentType> entities) {
		getDocumentTypeRepository().deleteAll(entities);
	}

	public void deleteAll() {
		getDocumentTypeRepository().deleteAll();
	}
}

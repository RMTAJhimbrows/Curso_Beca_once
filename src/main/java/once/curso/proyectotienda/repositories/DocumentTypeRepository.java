package once.curso.proyectotienda.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import once.curso.proyectotienda.entities.DocumentType;

@Repository
public interface DocumentTypeRepository extends PagingAndSortingRepository<DocumentType, Integer> {

}

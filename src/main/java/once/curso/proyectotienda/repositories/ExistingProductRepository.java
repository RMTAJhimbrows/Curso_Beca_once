package once.curso.proyectotienda.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import once.curso.proyectotienda.entities.ExistingProduct;

@Repository
public interface ExistingProductRepository extends PagingAndSortingRepository<ExistingProduct, Integer> {

}

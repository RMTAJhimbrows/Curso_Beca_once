package once.curso.proyectotienda.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import once.curso.proyectotienda.entities.SoldProduct;

@Repository
public interface SoldProductRepository extends PagingAndSortingRepository<SoldProduct, Integer> {

}

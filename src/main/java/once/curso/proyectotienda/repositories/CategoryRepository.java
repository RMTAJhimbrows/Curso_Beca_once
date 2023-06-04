package once.curso.proyectotienda.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import once.curso.proyectotienda.entities.Category;

@Repository
public interface CategoryRepository extends PagingAndSortingRepository<Category, Integer> {

}

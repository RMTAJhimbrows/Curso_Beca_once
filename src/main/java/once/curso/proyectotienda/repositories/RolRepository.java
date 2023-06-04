package once.curso.proyectotienda.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import once.curso.proyectotienda.entities.Rol;

@Repository
public interface RolRepository extends PagingAndSortingRepository<Rol, Integer> {

}

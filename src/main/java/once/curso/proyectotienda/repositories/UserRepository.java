package once.curso.proyectotienda.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import once.curso.proyectotienda.entities.User;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Integer> {

}

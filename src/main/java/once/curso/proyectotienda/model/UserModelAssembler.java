package once.curso.proyectotienda.model;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.SimpleRepresentationModelAssembler;

import once.curso.proyectotienda.entities.User;

public class UserModelAssembler implements SimpleRepresentationModelAssembler<User> {

	@Override
	public void addLinks(EntityModel<User> user) {
		
	}

	@Override
	public void addLinks(CollectionModel<EntityModel<User>> user) {
		
	}

}

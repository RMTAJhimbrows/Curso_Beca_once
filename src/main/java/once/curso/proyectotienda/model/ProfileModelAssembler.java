package once.curso.proyectotienda.model;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.SimpleRepresentationModelAssembler;

import once.curso.proyectotienda.entities.Profile;

public class ProfileModelAssembler implements SimpleRepresentationModelAssembler<Profile> {

	@Override
	public void addLinks(EntityModel<Profile> profile) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addLinks(CollectionModel<EntityModel<Profile>> profile) {
		// TODO Auto-generated method stub
		
	}

}

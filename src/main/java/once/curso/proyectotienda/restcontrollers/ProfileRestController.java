package once.curso.proyectotienda.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;
import once.curso.proyectotienda.entities.Profile;
import once.curso.proyectotienda.model.ProfileModelAssembler;
import once.curso.proyectotienda.services.ProfileService;

@Data
@RestController
@RequestMapping("/profiles")
public class ProfileRestController {
	
	@Autowired
	private ProfileService profileService;
	
	@Autowired
	private PagedResourcesAssembler<Profile> pagedResourcesAssembler;
	
	@Autowired
	private ProfileModelAssembler profileModelAssembler;
	
	@PostMapping("/profiles")
	public Profile save (@RequestBody Profile profile) {
		return getProfileService().save(profile);
	}
	
	public EntityModel<Profile> findById(@PathVariable int id){
		
		Profile profile = getProfileService().findById(id).get();
		
		profile.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ProfileRestController.class)
				.findById(profile.getUsers())));
		profile.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ProfileRestController.class)
				.findById(profile.getDocumentsTypes())).withSelfRel());
		profile.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ProfileRestController.class)
				.findById(profile.getId())).withSelfRel());
		
		return EntityModel.of(profile);
	}
	
	@GetMapping("/profiles")
	public Iterable<Profile> findAll(){
		return getProfileService().findAll();
	}
	
	@DeleteMapping("/profiles")
	public void deleteById (@PathVariable int id) {
		getProfileService().deleteById(id);
	}

}

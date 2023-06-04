package once.curso.proyectotienda.restcontrollers;

import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;
import once.curso.proyectotienda.entities.Rol;
import once.curso.proyectotienda.model.RolModelAssembler;
import once.curso.proyectotienda.services.RolService;

@Data
@RequestMapping("/roles")
@RestController
public class RolRestController {

	@Autowired
	private RolService rolService;
	
	@Autowired
	private PagedResourcesAssembler<Rol> pagedResourcesAssembler;
	
	@Autowired
	private RolModelAssembler rolModelAssembler;
	
	@PostMapping("/roles")
	public Rol save(@RequestBody Rol rol) {
		return getRolService().save(rol);
	}
	
	public EntityModel<Rol> findById(@PathVariable int id){
		
		Rol rol = getRolService().findById(id).get();
		rol.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(RolRestController.class)
				.findById(rol.getId())).withSelfRel());
		return EntityModel.of(rol);
	}
	
	@GetMapping("/roles")
	public CollectionModel<Rol> finAll(){
		
		Iterable<Rol> rol = getRolService().findAll();
		rol.forEach(r->{
			r.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(RolRestController.class)
					.findById(r.getId())).withSelfRel());
		});
		return CollectionModel.of(rol);
	}
	
	public PagedModel<EntityModel<Rol>> findAllpaginado(@RequestParam int size,
			@RequestParam int page, @RequestParam String sort){
		
		StringTokenizer stringTokenizer = new StringTokenizer(sort, ",");
		
		Sort orden = Sort.by("a");
		String campo = stringTokenizer.nextToken();
		String tipoOrden = stringTokenizer.nextToken();
		
		if (tipoOrden.equals("asc")) 
			orden = Sort.by(campo).ascending();
		else 
			orden = Sort.by(campo).descending();
		
		Pageable pageable = PageRequest.of(page, size, orden);
		Page<Rol> rol = getRolService().findAll(pageable);
		
		return getPagedResourcesAssembler().toModel(rol, getRolModelAssembler());
	}
	
	@DeleteMapping("/roles{id}")
	public void deleteById(@PathVariable int id) {
		getRolService().deleteById(id);
	}
}

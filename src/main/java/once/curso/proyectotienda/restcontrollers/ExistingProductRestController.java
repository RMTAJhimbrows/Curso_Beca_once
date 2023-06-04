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
import once.curso.proyectotienda.entities.ExistingProduct;
import once.curso.proyectotienda.model.ExistingProductModelAssembler;
import once.curso.proyectotienda.services.ExistingproductService;

@RestController
@Data
@RequestMapping("/existingProducts")
public class ExistingProductRestController {
	
	@Autowired
	private ExistingproductService existingproductService;
	
	@Autowired
	private PagedResourcesAssembler<ExistingProduct> pagedResourcesAssembler;
	
	@Autowired
	private ExistingProductModelAssembler existingProductModelAssembler;
	
	@PostMapping("/existingProducts")
	public ExistingProduct save(@RequestBody ExistingProduct existingProduct) {
		return getExistingproductService().save(existingProduct);
	}
	
	public EntityModel<ExistingProduct> findById(@PathVariable int id){
		
		ExistingProduct existingProduct = getExistingproductService().findById(id).get();
		
		existingProduct.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ExistingProductRestController.class)
				.findById(existingProduct.getId())).withSelfRel());
		return EntityModel.of(existingProduct);
	}
	
	@GetMapping("/existingProducts")
	public CollectionModel<ExistingProduct> findAll(){
		
		Iterable<ExistingProduct> existingProduct = getExistingproductService().findAll();
		
		existingProduct.forEach(e->{
			e.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ExistingProductRestController.class)
					.findById(e.getId())).withSelfRel());
		});
		return CollectionModel.of(existingProduct);
	}
	
	public PagedModel<EntityModel<ExistingProduct>> findAllPaginado(@RequestParam int size, 
			@RequestParam int page, @RequestParam String sort ){
		
		StringTokenizer stringTokenizer = new StringTokenizer(sort, ",");
		Sort orden = Sort.by("a");
		String campo = stringTokenizer.nextToken();
		String tipoOrden = stringTokenizer.nextToken();
		
		if (tipoOrden.equals("asc")) {
			orden = Sort.by(campo).ascending();
		} else {
			orden = Sort.by(campo).descending();
		}
		
		Pageable pageable = PageRequest.of(page, size, orden);
		Page<ExistingProduct> existingProduct = getExistingproductService().findAll(pageable);
		
		return getPagedResourcesAssembler().toModel(existingProduct, getExistingProductModelAssembler());
	}
	
	@DeleteMapping("/existingProducts")
	public void deleteById(@PathVariable int id) {
		getExistingproductService().deleteById(id);
	}

}

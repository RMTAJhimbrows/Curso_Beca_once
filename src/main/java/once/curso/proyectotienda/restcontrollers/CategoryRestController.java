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
import once.curso.proyectotienda.entities.Category;
import once.curso.proyectotienda.model.CategoryModelAssembler;
import once.curso.proyectotienda.services.CategoryService;

@Data
@RequestMapping("/categories")
@RestController
public class CategoryRestController {

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private CategoryModelAssembler cardTypeModelAssembler;

	@Autowired
	private PagedResourcesAssembler<Category> pagedResourcesAssembler;

	@PostMapping("/categories")
	public Category save(@RequestBody Category category) {
		return getCategoryService().save(category);
	}

	public EntityModel<Category> findById(@PathVariable int id) {
		Category category = getCategoryService().findById(id).get();

		category.add(WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder.methodOn(CategoryRestController.class).findById(category.getId()))
				.withSelfRel());
		return EntityModel.of(category);
	}

	@GetMapping("/categories")
	public CollectionModel<Category> findAll() {

		Iterable<Category> category = getCategoryService().findAll();
		category.forEach(c -> {
			c.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(CategoryRestController.class).findById(c.getId()))
					.withSelfRel());
		});
		return CollectionModel.of(category);
	}

	@DeleteMapping("/categories/{id}")
	public void deleteById(@PathVariable int id) {
		getCategoryService().deleteById(id);
	}
	
	@GetMapping("/categoryPaginado")
	public PagedModel<EntityModel<Category>> findAllPaginado(@RequestParam int size, @RequestParam int page,
			@RequestParam String sort) {

		StringTokenizer stringTokenizer = new StringTokenizer(sort, ",");
		Sort orden = Sort.by("a");
		String campo = stringTokenizer.nextToken();
		String tipoOrden = stringTokenizer.nextToken();

		if (tipoOrden.equals("asc"))
			orden = Sort.by(campo).ascending();
		else
			orden = Sort.by(campo).descending();
		
		Pageable pageable = PageRequest.of(page, size, orden);
		Page<Category> category = getCategoryService().findAll(pageable);

		return getPagedResourcesAssembler().toModel(category, getCardTypeModelAssembler());
	}

}

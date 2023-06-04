package once.curso.proyectotienda.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;
import once.curso.proyectotienda.entities.SubCategory;
import once.curso.proyectotienda.services.SubCategoryService;

@Data
@RequestMapping("/once")
@RestController
public class SubCategoryRestController {
	
	@Autowired
	private SubCategoryService subCategoryService;
	
	@PostMapping("/subCategories")
	public SubCategory save(@RequestBody SubCategory subCategory) {
		return getSubCategoryService().save(subCategory);
	}
	
	@GetMapping("/subCategories")
	public Iterable<SubCategory> findAll(){
		return getSubCategoryService().findAll();
	}
	
	@DeleteMapping("/subCategories/{id}")
	public void deleteById(@PathVariable int id) {
		getSubCategoryService().deleteById(id);
	}
}

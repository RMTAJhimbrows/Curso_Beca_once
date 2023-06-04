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
import once.curso.proyectotienda.entities.SoldProduct;
import once.curso.proyectotienda.services.SoldProductServvice;

@Data
@RequestMapping("/soldProducts")
@RestController
public class SoldProductRestController {
	
	@Autowired
	private SoldProductServvice soldProductServvice;
	
	@PostMapping("/soldProducts")
	public SoldProduct save(@RequestBody SoldProduct soldProduct) {
		return getSoldProductServvice().save(soldProduct);
	}
	
	@GetMapping("/soldProducts")
	public Iterable<SoldProduct> findAll(){
		return getSoldProductServvice().findAll();
	}
	
	@DeleteMapping("/soldProducts{id}")
	public void deleteById(@PathVariable int id) {
		getSoldProductServvice().deleteById(id);
	}
}

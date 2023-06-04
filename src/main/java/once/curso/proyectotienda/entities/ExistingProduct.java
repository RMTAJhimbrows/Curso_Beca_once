package once.curso.proyectotienda.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.hateoas.RepresentationModel;

import lombok.Data;

@Data
@Entity
@Table(name = "EXISTING_PRODUCTS")
public class ExistingProduct extends RepresentationModel<ExistingProduct> {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String description;
	
	private double price;
	
	private byte image;
	
	private int stock;
	
	private int subCategoryId;
}

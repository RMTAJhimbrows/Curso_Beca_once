package once.curso.proyectotienda.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.hateoas.RepresentationModel;

import lombok.Data;

@Entity
@Data
@Table(name = "USER")
public class User extends RepresentationModel<User> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String user;
	
	private String password;
	
	private boolean[] enable;
	
	@ManyToOne
	@JoinColumn(name="roles_id")
	private Rol rol;
}

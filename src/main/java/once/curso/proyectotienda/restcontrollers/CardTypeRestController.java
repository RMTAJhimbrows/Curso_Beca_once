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
import once.curso.proyectotienda.entities.CardType;
import once.curso.proyectotienda.model.CardTypeModelAssembler;
import once.curso.proyectotienda.services.CardTypeService;

@RestController
@Data
@RequestMapping
public class CardTypeRestController {

	@Autowired
	private CardTypeService cardTypeService;

	@Autowired
	private CardTypeModelAssembler cardTypeModelAssembler;

	@Autowired
	private PagedResourcesAssembler<CardType> pagedResourcesAssembler;

	@PostMapping("/cardTypes")
	public CardType save(@RequestBody CardType cardType) {
		return getCardTypeService().save(cardType);
	}

	@GetMapping("/cardTypes")
	public CollectionModel<CardType> finAll() {

		Iterable<CardType> cardType = getCardTypeService().findAll();

		cardType.forEach(c -> {
			c.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(CardTypeRestController.class).findById(c.getId()))
					.withSelfRel());
		});

		return CollectionModel.of(cardType);
	}

	@DeleteMapping("/cardTypes/{id}")
	public void deleteById(@PathVariable int id) {
		getCardTypeService().deleteById(id);
	}

	@GetMapping("/cardTypes/{id}")
	public EntityModel<CardType> findById(@PathVariable int id) {

		CardType cardType = getCardTypeService().findById(id).get();

		cardType.add(WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder.methodOn(CardTypeRestController.class).findById(cardType.getId()))
				.withSelfRel());

		return EntityModel.of(cardType);
	}

	@GetMapping("/cardTypePaginado")
	public PagedModel<EntityModel<CardType>> findAllPaginado(@RequestParam int page, @RequestParam int size,
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
		Page<CardType> cardtype = getCardTypeService().findAll(pageable);
		return getPagedResourcesAssembler().toModel(cardtype, getCardTypeModelAssembler());
	}

}

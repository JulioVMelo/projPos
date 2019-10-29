package br.com.storeApi.cart.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.storeApi.Item.Item;
import br.com.storeApi.cart.Cart;
import br.com.storeApi.cart.service.CartService;

@RestController
@RequestMapping("/carts")
public class CartResouce {

	@Autowired
	private CartService cartService;

	@PostMapping
	public ResponseEntity<?> salvar(@RequestBody Cart cart) {
		this.cartService.salvar(cart);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@PostMapping("/item")
	public void adiciona(Item item) {
		
	}

	@PutMapping
	public ResponseEntity<?> atualizar(@RequestBody Cart cart) {
		this.cartService.salvar(cart);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@GetMapping
	public ResponseEntity<List<Cart>> listar() {
		List<Cart> carts = this.cartService.listar();
		return ResponseEntity.ok(carts);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Cart> buscarPorId(@PathVariable final long id) {
		Optional<Cart> cart = this.cartService.buscarPorId(id);
		return ResponseEntity.ok(cart.get());
	}

	@DeleteMapping("/{id}")
	public void remover(@PathVariable final long id) {
		this.cartService.remover(id);
	}

}

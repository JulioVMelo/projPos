package br.com.storeApi.product.resource;

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

import br.com.storeApi.product.Product;
import br.com.storeApi.product.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductResource {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping 
	public ResponseEntity<?> salvar(@RequestBody Product product){
		this.productService.salvar(product);	
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@PutMapping
	public ResponseEntity<?> atualizar(@RequestBody Product product){
		this.productService.salvar(product);		
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@GetMapping
	public ResponseEntity<List<Product>> listar() { 
		List<Product> products = this.productService.listar();
		return ResponseEntity.ok(products);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Product> buscarPorId(@PathVariable final long id){
		Optional<Product> product = this.productService.buscarPorId(id);
		return ResponseEntity.ok(product.get());
	}
	
	@DeleteMapping("/{id}")
	public void remover(@PathVariable final long id) {
		this.productService.remover(id);
	}
}

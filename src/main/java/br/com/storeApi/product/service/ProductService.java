package br.com.storeApi.product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.storeApi.product.Product;
import br.com.storeApi.product.infraestructure.ProductRepository;
import br.com.storeApi.service.ServicoGenerico;

@Service
public class ProductService  extends ServicoGenerico<Product, Long>{
	
	private ProductRepository productRepository;
	
	@Autowired
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

}

package br.com.storeApi.product.infraestructure;

import org.springframework.stereotype.Repository;

import br.com.storeApi.infraestructure.GenericRepository;
import br.com.storeApi.product.Product;

@Repository
public interface ProductRepository extends GenericRepository<Product, Long>{

}

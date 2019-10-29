package br.com.storeApi.cart.infraestructure;

import org.springframework.stereotype.Repository;

import br.com.storeApi.cart.Cart;
import br.com.storeApi.infraestructure.GenericRepository;

@Repository
public interface CartRepository  extends GenericRepository<Cart, Long>{

}

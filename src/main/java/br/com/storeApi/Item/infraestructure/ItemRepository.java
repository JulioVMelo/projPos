package br.com.storeApi.Item.infraestructure;

import org.springframework.stereotype.Repository;

import br.com.storeApi.Item.Item;
import br.com.storeApi.infraestructure.GenericRepository;

@Repository
public interface ItemRepository  extends GenericRepository<Item, Long>{

}

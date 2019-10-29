package br.com.storeApi.cart;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import br.com.storeApi.Item.Item;

@Entity
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@OneToMany()
	@JoinColumn(name = "id_cart")
	private List<Item> itens;
	
	@Column
	private Double total;
	
	
	public void adicionar(final Item item) {
		itens.add(item);
		this.total += item.getProduct().getPrice()* item.getAmount();
	}
	
	public void remove(int id) {
		Item itemRemovido = itens.remove(id);
		total -= itemRemovido.getProduct().getPrice() * itemRemovido.getAmount();	
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}

	public Integer getTotalItens() {
		return this.itens.size();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cart other = (Cart) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}

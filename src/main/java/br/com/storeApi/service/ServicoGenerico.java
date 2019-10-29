package br.com.storeApi.service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.storeApi.infraestructure.GenericRepository;

@Service
public abstract class ServicoGenerico<T, ID extends Serializable> {

	@Autowired
	private GenericRepository<T, ID> repository;
	
//	public ServicoGenerico(GenericRepository<T, ID> repository) {
//		this.repository = repository;
//	}

	@Transactional
	public void salvar(final T entidade) {
		System.out.println();
		this.repository.save(entidade);
	}

	@Transactional()
	public void remover(final ID id) {
		this.repository.deleteById(id);
	}

	@Transactional(readOnly = true)
	public Optional<T> buscarPorId(final ID id) {
		Optional<T> entidade = this.repository.findById(id);
		entidade.orElseThrow(() -> new RuntimeException("A entidade de identificador " + id + " Não foi encontrada"));

		return entidade;
	}

	@Transactional(readOnly = true)
	public List<T> listar() {
		return this.repository.findAll();
	}
}

package br.com.springboot.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import br.com.springboot.model.Cliente;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class ClienteDAO implements CRUD<Cliente, Long>{

	@PersistenceContext
	private EntityManager entityMenager;
	
	@Override
	public Cliente pesquisaPeloid(Long id) {
		return entityMenager.find(Cliente.class, id);
	}

	@Override
	public List<Cliente> lista() {
		Query query = entityMenager.createQuery("Select c from Cliente c");
		return (List<Cliente>) query.getResultList();
	}

	@Override
	public void insere(Cliente cliente) {
		entityMenager.persist(cliente);
	}
	@Override
	public void atualizar(Cliente cliente) {
		entityMenager.merge(cliente);
	}

	@Override
	public void remove(Cliente cliente) {
		entityMenager.remove(cliente);
		
	}

}

package br.ccom.springboot.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.springboot.dao.CRUD;
import br.com.springboot.dao.ClienteDAO;
import br.com.springboot.model.Cliente;

@Service
public class clienteBO implements CRUD<Cliente, Long>{
	@Autowired
	private ClienteDAO dao;

	@Override
	public Cliente pesquisaPeloid(Long id) {
		return dao.pesquisaPeloid(id);
	}

	@Override
	public List<Cliente> lista() {
		return dao.lista();
	}

	@Override
	public void insere(Cliente cliente) {
		 insere(cliente);
	}

	@Override
	public void atualizar(Cliente cliente) {
		dao.atualizar(cliente);
		
	}

	@Override
	public void remove(Cliente cliente) {
		dao.remove(cliente);
	} 
	
	public void inativa(Cliente cliente) {
		cliente.setAtivo(false);
		dao.atualizar(cliente);
	}

	public void ativa(Cliente cliente) {
		cliente.setAtivo(true);
		dao.atualizar(cliente);
	}
}

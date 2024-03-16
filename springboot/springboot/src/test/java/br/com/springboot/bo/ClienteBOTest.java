package br.com.springboot.bo;

import java.time.LocalDate;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.ccom.springboot.bo.clienteBO;
import br.com.springboot.model.Cliente;
import br.com.springboot.model.Sexo;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ClienteBOTest {

	@Autowired 
	private clienteBO bo;

	@Test
	@Order(1)
	public void insere() {
		Cliente cliente = new Cliente();
		cliente.setNome("José daa Silva");
		cliente.setCpf("0123456789");
		cliente.setDataDeNascimento(LocalDate.of(2000, 1, 8));
		cliente.setSexo(Sexo.MASCULINO);
		cliente.setTelefone("012345678");
		cliente.setCelular("0123456780");
		cliente.setEmail("rafael@email.com.br");
		cliente.setAtivo(true);
		bo.insere(cliente);
	}
	
	@Test
	@Order(1)
	public void pesquisaPeloId() {
		Cliente cliente = bo.pesquisaPeloid(1L);
		System.out.println(cliente);
	}
	
	@Test
	@Order(1)
	public void atualizar() {
		Cliente cliente = bo.pesquisaPeloid(1L);
		cliente.setCpf("98765432100");
		bo.atualizar(cliente);
	}
}

package br.unifor.pin.saa.dao;

import junit.framework.Assert;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.unifor.pin.saa.entity.Professores;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/test-context.xml")
@Transactional(propagation=Propagation.REQUIRED)
public class ProfessoresDAOTest {
	@Autowired
	private ProfessoresDAO professoresDAO;
	
	@Test
	public void testSalvar() {
		final String nome = "Mendes";
		
		Professores professores = new Professores();
		professores.setNome(nome);
		
		professoresDAO.salvar(professores);
		
		professores = professoresDAO.buscaPorId(professores.getId());
		
		Assert.assertNotNull(professores);
		
		professoresDAO.excluir(professores);
		
	}
	
	@Test
	public void testAtualizar(){
		final String nome = "Mendes";
		final String nomeAlterado = "Matheus";
		
		Professores professores = new Professores();
		professores.setNome(nome);
		professoresDAO.salvar(professores);
		
		professores.setNome(nomeAlterado);
		professoresDAO.atualizar(professores);
		
		Assert.assertEquals(nomeAlterado, professores.getNome());
		
		professoresDAO.excluir(professores);
		
	}
	@Test
	public void testBuscarPorId(){
		final String nome = "Mendes";
		
		Professores professores = new Professores();
		professores.setNome(nome);
		professoresDAO.salvar(professores);
		
		Professores professoresAlterado = new Professores();
		professoresAlterado = professoresDAO.buscaPorId(professores.getId());
		
		Assert.assertNotNull(professoresAlterado);
		
		professoresDAO.excluir(professoresAlterado);
		
	}
	@Ignore
	public void testBuscarPorNome(){
		final String nome = "Mendes";
		
		Professores professores = new Professores();
		professores.setNome(nome);
		professoresDAO.salvar(professores);
		
		Professores professoresAlterado = new Professores();
		professoresAlterado = professoresDAO.buscarPorNome(professores.getNome());
		
		Assert.assertEquals(nome,professoresAlterado);
		
		professoresDAO.excluir(professoresAlterado);
		
	}
}

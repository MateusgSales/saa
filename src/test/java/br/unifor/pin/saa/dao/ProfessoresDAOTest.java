package br.unifor.pin.saa.dao;
import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.unifor.pin.saa.entity.Professores;;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/test-context.xml")
@Transactional(propagation=Propagation.REQUIRED)
public class ProfessoresDAOTest {
	

	@Autowired
	private ProfessoresDAO professorDAO;
	
	@Test
	public void testSalvar() {
		final String nome = "Rafael";
		Professores professor = new Professores();
		professor.setNome(nome);
		
		
		professorDAO.salvar(professor);
		Professores professorRetorno = professorDAO.buscarPorNome(nome);
		Assert.assertNotNull(professorRetorno);
		
		professorDAO.excluir(professorRetorno);
		
	}
	@Test
	public void testAtualizar(){
		final String nome = "Rafael";
		final String nomeAlterado = "Alice";
		Professores professor = new Professores();
		professor.setNome(nome);
		
		professorDAO.salvar(professor);
		Professores professorRetorno = professorDAO.buscarPorNome(nome);
		
		professorRetorno.setNome(nomeAlterado);
		professorDAO.atualizar(professorRetorno);
		
		Professores professorNovo = professorDAO.buscarPorNome(nomeAlterado);
		Assert.assertNotNull(professorNovo);
		
		professorDAO.excluir(professorRetorno);
	}
	
	@Test
	public void testBuscarPorId(){
		final String nome = "Rafael";
		Professores professor = new Professores();
		professor.setNome(nome);
		
		professorDAO.salvar(professor);
		Professores professorRetorno = professorDAO.buscarPorNome(nome);
		Long id = professorRetorno.getId();
		Professores professorNovo = professorDAO.buscaPorId(id);
		
		Assert.assertNotNull(professorNovo);
		
		professorDAO.excluir(professorNovo);
	}
}

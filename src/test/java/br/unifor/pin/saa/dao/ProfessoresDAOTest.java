package br.unifor.pin.saa.dao;
import junit.framework.Assert;

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
		
		Professores professor = new Professores();
		professor.setNome(nome);
		
		professoresDAO.salvar(professor);
		
		professor = professoresDAO.buscarPorNome(professor.getNome());
		Assert.assertNotNull(professor);
		
		professoresDAO.excluir(professor);
		
	}
	
	@Test
	public void testAtualizar(){
		final String nome = "Mendes";
		final String nomeAlterado = "Matheus";
		
		Professores professor = new Professores();
		professor.setNome(nome);
		
		professoresDAO.salvar(professor);
		professor.setNome(nomeAlterado);
		professoresDAO.atualizar(professor);
		
		professor = professoresDAO.buscarPorId(professor.getId());
		Assert.assertEquals(nomeAlterado, professor.getNome());
		
		professoresDAO.excluir(professor);
	}
	@Test
	public void testBuscarPorId(){
		final String nome = "Mendes";
		
		Professores professor = new Professores();
		professor.setNome(nome);
		
		professoresDAO.salvar(professor);
							
		Professores professorRetorno = professoresDAO.buscarPorNome(professor.getNome());
		Long id = professorRetorno.getId();
		Professores professorNovo= professoresDAO.buscarPorId(id);
		
		Assert.assertNotNull(professorNovo);
		
		professoresDAO.excluir(professorRetorno);
		
	}
	
	public void testBuscarPorNome(){
		final String nome = "Mendes";
		
		Professores professor = new Professores();
		professor.setNome(nome);
		
		professoresDAO.salvar(professor);
							
		professor = professoresDAO.buscarPorNome(professor.getNome());
		
		Assert.assertNotNull(professor);
		
		professoresDAO.excluir(professor);
		
	}
}

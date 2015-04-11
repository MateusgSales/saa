package br.unifor.pin.saa.dao;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.unifor.pin.saa.entity.Professores;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/test-contxt.xml")
public class TurmasDAOTest {

	@Autowired
	private ProfessoresDAO professorDAO;
	
	@Test
	public void testSalvar() {
		final String nome = "Rafael";
		Professores professor = new Professores();
		professor.setNome(nome);
		
		
		professorDAO.salvar(professor);
		Professores professoresRetorno = professorDAO.buscarPorNome(nome);
		Assert.assertNull(professoresRetorno);
		
		//professorDAO.excluir(professoresRetorno);
		
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
		
		//professorDAO.excluir(professorRetorno);
	}
	
	@Test
	public void testBuscarPorId(){
		final String nome = "Rafael";
		Professores aluno = new Professores();
		aluno.setNome(nome);
		
		professorDAO.salvar(aluno);
		Professores alunoRetorno = professorDAO.buscarPorNome(nome);
		Long id = alunoRetorno.getId();
		Professores alunoNovo = professorDAO.buscaPorId(id);
		
		Assert.assertNotNull(alunoNovo);
		
		//professorDAO.excluir(alunoRetorno);
	}

}

package br.unifor.pin.saa.dao;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.unifor.pin.saa.entity.Alunos;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/test-context.xml")
@Transactional(propagation=Propagation.REQUIRED)
public class AlunosDAOTest {

	@Autowired
	private AlunosDAO alunoDAO;
	
	@Test
	public void testSalvar() {
		final String nome = "Rafael";
		Alunos aluno = new Alunos();
		aluno.setNome(nome);
		
		
		alunoDAO.salvar(aluno);
		Alunos alunoRetorno = alunoDAO.buscarPorNome(nome);
		Assert.assertNotNull(alunoRetorno);
		alunoDAO.excluir(alunoRetorno);
		
	}
	@Test
	public void testAtualizar(){
		final String nome = "Rafael";
		final String nomeAlterado = "Alice";
		Alunos aluno = new Alunos();
		aluno.setNome(nome);
		
		alunoDAO.salvar(aluno);
		Alunos alunoRetorno = alunoDAO.buscarPorNome(nome);
		
		alunoRetorno.setNome(nomeAlterado);
		alunoDAO.atualizar(alunoRetorno);
		
		Alunos alunoNovo = alunoDAO.buscarPorNome(nomeAlterado);
		Assert.assertNotNull(alunoNovo);
		
		alunoDAO.excluir(alunoRetorno);
	}
	
	@Test
	public void testBuscarPorId(){
		final String nome = "Rafael";
		Alunos aluno = new Alunos();
		aluno.setNome(nome);
		
		alunoDAO.salvar(aluno);
		Alunos alunoRetorno = alunoDAO.buscarPorNome(nome);
		Long id = alunoRetorno.getId();
		Alunos alunoNovo = alunoDAO.buscaPorId(id);
		
		Assert.assertNotNull(alunoNovo);
		
		alunoDAO.excluir(alunoRetorno);
	}
	
}

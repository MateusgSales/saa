package br.unifor.pin.saa.dao;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.unifor.pin.saa.entity.Cursa;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/test-context.xml")
@Transactional(propagation=Propagation.REQUIRES_NEW)
@TransactionConfiguration(defaultRollback=false)

public class CursaDaoTest {
	
	@Autowired
	private CursaDAO cursaDAO;

	@Test
	public void testSalvar() {
		
		final String turma = "A";		
		final String aluno = "Matheus";
		Cursa cursa = new Cursa();
		
		cursa.setAluno(aluno);
		cursa.setTurma(turma);
		cursaDAO.salvar(cursa);
		
		Cursa cursaRetorno = cursaDAO.buscarPorId(cursa.getID());
		Assert.assertNotNull(cursaRetorno);
		cursaDAO.excluir(cursaRetorno);
		
	}

	@Test
	public void testAtualizar() {
		
		final String turma = "A";
		final String turmaNova = "B";
		final String aluno = "Matheus";
		Cursa cursa = new Cursa();
		
		cursa.setAluno(aluno);
		cursa.setTurma(turma);
		cursaDAO.salvar(cursa);
		
		cursa.setTurma(turmaNova);
		cursaDAO.atualizar(cursa);
		cursa = cursaDAO.buscarPorId(cursa.getID());
		
		Assert.assertEquals(turmaNova, cursa.getTurma());
		cursaDAO.excluir(cursa);
		
	}

	@Test
	public void testBuscarPorNome() {
		final String turma = "A";		
		final String aluno = "Matheus";
		Cursa cursa = new Cursa();
		
		cursa.setAluno(aluno);
		cursa.setTurma(turma);
		cursaDAO.salvar(cursa);
		
		cursa = cursaDAO.buscarPorAlumo(cursa.getAluno());
		Assert.assertNotNull(cursa);
		
		cursaDAO.excluir(cursa);
		
	}
	
	

	@Test
	public void testBuscarPorId() {
		
		final String turma = "A";		
		final String aluno = "Matheus";
		Cursa cursa = new Cursa();
		
		cursa.setAluno(aluno);
		cursa.setTurma(turma);
		cursaDAO.salvar(cursa);
		
		Long id = cursa.getID();
		Cursa cursaNovo= cursaDAO.buscarPorId(id);
		Assert.assertNotNull(cursaNovo.getID());
		
		cursaDAO.excluir(cursaNovo);
		
		
		
		
		
		
		
		
	}

}


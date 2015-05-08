package br.unifor.pin.saa.dao;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.unifor.pin.saa.entity.Turmas;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/test-context.xml")
@Transactional(propagation=Propagation.REQUIRED)
public class TurmasDAOTest {
	
	@Autowired
	private TurmasDAO turmaDAO;

	
	@Test
	public void testSalvar() {
		final String disciplina = "POO";
		final Integer semestre = 2;
		
		Turmas turma = new Turmas();
		turma.setDisciplina(disciplina);
		turma.setSemestre(semestre);
		
		turmaDAO.salvar(turma);
		
		Turmas turmaRetorno = turmaDAO.buscaPorId(turma.getId());
		Assert.assertNotNull(turmaRetorno);
		
		turmaDAO.excluir(turmaRetorno);
		
	}
	@Test
	public void testAtualizar(){
		final String disciplina = "PO";
		final String disciplina_alterada = "POO";
		final Integer semestre = 2;
		
		Turmas turma = new Turmas();
		turma.setDisciplina(disciplina);
		turma.setSemestre(semestre);
		turmaDAO.salvar(turma);
		
		turma.setDisciplina(disciplina_alterada);
		turmaDAO.atualizar(turma);
		
		Assert.assertEquals(disciplina_alterada, turma.getDisciplina());
		
		turmaDAO.excluir(turma);
		
	}
	
	@Test
	public void testBuscarPorId(){
		final String disciplina = "POO";
		final Integer semestre = 2;
		
		Turmas turma = new Turmas();
		turma.setDisciplina(disciplina);
		turma.setSemestre(semestre);
		
		turmaDAO.salvar(turma);
		
		Turmas turmaRetorno = turmaDAO.buscaPorId(turma.getId());
		
		Assert.assertNotNull(turmaRetorno);
		
		turmaDAO.excluir(turmaRetorno);

	}

}

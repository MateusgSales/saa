package br.unifor.pin.saa.dao;

import static junit.framework.Assert.*;


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
@Transactional(propagation = Propagation.REQUIRED)
public class AlunosDAOTest {

	@Autowired
	private AlunosDAO alunoDAO;

	@Test
	public void testSalvar() {
		final String nome = "Rafael";
		Alunos aluno = new Alunos();
		aluno.setNome(nome);

		//Persistindo aluno
		alunoDAO.salvar(aluno);
		Alunos alunoRetorno = alunoDAO.buscarPorNome(nome);
		// esse metodo verifica se a variavel que esta estornando não esta nula
		assertNotNull(alunoRetorno);
		// exclui o objeto que foi incluido, retornando
		alunoDAO.excluir(alunoRetorno);

	}

	@Test
	public void testAtualizar() {
		final String nome = "Rafael";
		final String nomeAlterado = "Alice";
		Alunos aluno = new Alunos();
		aluno.setNome(nome);

		alunoDAO.salvar(aluno);
		Alunos alunoNovoNome = alunoDAO.buscarPorNome(nome);

		alunoNovoNome.setNome(nomeAlterado);
		alunoDAO.atualizar(alunoNovoNome);

		Alunos alunoNovo = alunoDAO.buscarPorNome(nomeAlterado);
		assertNotNull(alunoNovo);

		alunoDAO.excluir(alunoNovoNome);
	}

	@Test
	public void testBuscarPorId() {
		final String nome = "Rafael";
		Alunos aluno = new Alunos();
		aluno.setNome(nome);

		alunoDAO.salvar(aluno);
		Alunos alunoRetorno = alunoDAO.buscarPorNome(nome);
		Long id = alunoRetorno.getId();
		Alunos alunoNovo = alunoDAO.buscaPorId(id);

		assertNotNull(alunoNovo);

		alunoDAO.excluir(alunoRetorno);
	}

	@Test
	public void testBuscarPorNome() {
		final String nome = "Matheus";

		Alunos aluno = new Alunos();
		aluno.setNome(nome);

		alunoDAO.salvar(aluno);
		aluno = alunoDAO.buscarPorNome(aluno.getNome());

		assertEquals(nome, aluno.getNome());

		alunoDAO.excluir(aluno);

	}

}

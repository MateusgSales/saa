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

import br.unifor.pin.saa.entity.Alunos;
import br.unifor.pin.saa.entity.Avaliacoes;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/test-context.xml")
@Transactional(propagation = Propagation.REQUIRES_NEW)
@TransactionConfiguration(defaultRollback = false)
public class AvaliacoesDAOTest {

	@Autowired
	private AvaliacoesDAO avaliacoesDAO;
	@Autowired
	private AlunosDAO alunoDAO;

	@Test
	public void testSalvar() {
		final Double nota = 8.1;
		final String situacaoAprovacao = "Aprovado";

		Avaliacoes avaliacao = new Avaliacoes();
		Alunos aluno = new Alunos();
		aluno.setNome("X");
		alunoDAO.salvar(aluno);

		avaliacao.setAluno(aluno);
		avaliacao.setSituacaoAprovacao(situacaoAprovacao);
		avaliacao.setNota(nota);

		avaliacao.getAluno().setNome("Y");
		avaliacoesDAO.salvar(avaliacao);

		Avaliacoes novaAvaliacao = avaliacoesDAO.buscarPorId(avaliacao.getId());

		Assert.assertEquals("Y", novaAvaliacao.getAluno().getNome());
		Assert.assertNotNull(avaliacao.getNota());
		Assert.assertEquals(situacaoAprovacao,avaliacao.getSituacaoAprovacao());

		avaliacoesDAO.excluir(avaliacao);
		alunoDAO.excluir(aluno);

	}

	public void testAtualizar() {
		final Double nota = 9.8;
		final String situacaoAprovacao_01= "Aprovado";
		final Double nota_alterada = 4.5;
		final String situacaoAprovacao_02= "Reprovado";
		

		Avaliacoes avaliacoes = new Avaliacoes();
		
		avaliacoes.setNota(nota);
		avaliacoes.setSituacaoAprovacao(situacaoAprovacao_01);
		avaliacoesDAO.salvar(avaliacoes);
		

		avaliacoes.setNota(nota_alterada);
		avaliacoes.setSituacaoAprovacao(situacaoAprovacao_02);
		avaliacoesDAO.atualizar(avaliacoes);

		Assert.assertEquals(nota_alterada, avaliacoes.getNota());
		Assert.assertEquals(situacaoAprovacao_02, avaliacoes.getSituacaoAprovacao());
		avaliacoesDAO.excluir(avaliacoes);

	}

	@Test
	public void testBuscarPorId() {
		final Double nota = 9.8;
		final String situacaoAprovacao = "Aprovado";

		Avaliacoes avaliacoes = new Avaliacoes();

		avaliacoes.setSituacaoAprovacao(situacaoAprovacao);
		avaliacoes.setNota(nota);
		avaliacoesDAO.salvar(avaliacoes);

		Avaliacoes avaliacoesRetorno = avaliacoesDAO.buscarPorId(avaliacoes
				.getId());

		Assert.assertNotNull(avaliacoesRetorno);

		avaliacoesDAO.excluir(avaliacoesRetorno);

	}

}

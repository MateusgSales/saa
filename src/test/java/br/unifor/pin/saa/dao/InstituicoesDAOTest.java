package br.unifor.pin.saa.dao;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;






import br.unifor.pin.saa.entity.Instituicoes;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/test-context.xml")
@Transactional(propagation=Propagation.REQUIRED)
public class InstituicoesDAOTest {
	
	@Autowired
	private InstituicoesDAO instituicoesDAO;

	@Test
	public void testSalvar() {
		final String nome = "Universidade de Fortaleza";
		final String sigla = "Unifor";
				
		Instituicoes instituicao = new Instituicoes();
		instituicao.setNome(nome);
		instituicao.setSigla(sigla);
		
		
		instituicoesDAO.salvar(instituicao);
		
		instituicao = instituicoesDAO.buscarPorNome(instituicao.getNome());
		Assert.assertNotNull(instituicao); 
		
		instituicoesDAO.excluir(instituicao);		
		
		
	}

	
	@Test
	public void testAtualizar() {
		
		final String nome = "Universidade de Fortaleza";
		final String sigla = "UniBor";
		final String siglaAlterada = "UNIFOR";
	
		
		Instituicoes instituicao = new Instituicoes();
		instituicao.setNome(nome);
		instituicao.setSigla(sigla);
		instituicoesDAO.salvar(instituicao);
		
		
		instituicao.setSigla(siglaAlterada);
		instituicoesDAO.atualizar(instituicao);
		instituicao = instituicoesDAO.buscarPorId(instituicao.getId());
		
		Assert.assertEquals(siglaAlterada, instituicao.getSigla());
		
		instituicoesDAO.excluir(instituicao);
		
	}

	@Test
	public void testBuscarPorNome() {
		
		final String nome = "Universidade de Fortaleza";
		final String sigla = "Unifor";
		
		
		Instituicoes instituicao = new Instituicoes();
		instituicao.setNome(nome);
		instituicao.setSigla(sigla);			
		instituicoesDAO.salvar(instituicao);
		
		
		instituicao = instituicoesDAO.buscarPorNome(instituicao.getNome());
		Assert.assertNotNull(instituicao);
		
		instituicoesDAO.excluir(instituicao);
		
	}

	@Test
	public void testBuscarPorId() {
		
		final String nome = "Universidade de Fortaleza";
		final String sigla = "Unifor";
		
		
		Instituicoes instituicao = new Instituicoes();
		instituicao.setNome(nome);
		instituicao.setSigla(sigla);
		instituicoesDAO.salvar(instituicao);
		
		Instituicoes instituicaoRetorno = instituicoesDAO.buscarPorNome(instituicao.getNome());
		Long id = instituicaoRetorno.getId();
		Instituicoes instituicaoNovo= instituicoesDAO.buscarPorId(id);
		
		Assert.assertNotNull(instituicaoNovo);
		
		instituicoesDAO.excluir(instituicaoRetorno);
		
	}

}

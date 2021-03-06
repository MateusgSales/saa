package br.unifor.pin.saa.dao;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.unifor.pin.saa.entity.Usuarios;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/test-context.xml")
@Transactional(propagation=Propagation.REQUIRED)
public class UsuarioDAOTest {
	
	@Autowired
	private UsuarioDAO usuarioDAO;


	public void testSalvar() throws Exception {
		
		Usuarios usuario = new Usuarios();
		usuario.setNome("Mendes");
		usuario.setSenha("123456");
		usuario.setEmail("mendes@gmail.com");
		usuario.setPrimeiroAcesso(true);
		usuario.setAtivo(false);
		usuarioDAO.salvar(usuario);
		
		Assert.assertNotNull(usuario.getId());
		System.out.println(usuario.getId());
		
	}
	
	@Test
	public void testAtualizar() throws Exception  {
		final String nome = "Mendes";
		final String nomeAlterado = "PROFESSOR Mendes";
		final String email = "mendes@gmail.com";
		final String senha = "123456";
		final boolean primeiroAcesso = (true);
		final boolean ativo = (true);
		
		Usuarios usuario = new Usuarios();
		
		usuario.setNome(nome);
		usuario.setSenha(senha);
		usuario.setEmail(email);
		usuario.setPrimeiroAcesso(primeiroAcesso);
		usuario.setAtivo(ativo);
		
		usuarioDAO.salvar(usuario);
		usuario.setNome(nomeAlterado);
		usuarioDAO.atualizar(usuario);
		
		Assert.assertEquals(nomeAlterado, usuario.getNome());
		
		usuarioDAO.excluir(usuario);
		
	}
	@Test
	public void testBuscarPorId() throws Exception {
		
		final String nome = "Mendes";
		final String email = "Mendes@gmail.com";
		final String senha = "123456";
		final boolean primeiroAcesso = (true);
		final boolean ativo = (true);
		
		Usuarios usuario = new Usuarios();
		
		usuario.setNome(nome);
		usuario.setEmail(email);
		usuario.setSenha(senha);
		usuario.setPrimeiroAcesso(primeiroAcesso);
		usuario.setAtivo(ativo);
		
		usuarioDAO.salvar(usuario);
		
		Usuarios usuariosRetorno = usuarioDAO.buscaPorId(usuario.getId());
		
		Assert.assertNotNull(usuariosRetorno);
		
		usuarioDAO.excluir(usuariosRetorno);
		
	}
	
}

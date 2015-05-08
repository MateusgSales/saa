package br.unifor.pin.saa.bussines;

import javax.persistence.Id;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;

import antlr.collections.List;
import br.unifor.pin.saa.aspectj.Loggable;
import br.unifor.pin.saa.dao.AvaliacoesDAO;
import br.unifor.pin.saa.dao.UsuarioDAO;
import br.unifor.pin.saa.entity.Avaliacoes;
import br.unifor.pin.saa.entity.Usuarios;
import br.unifor.pin.saa.exceptions.DAOException;

public class AvaliacoesBO {
	
	@Autowired
	private AvaliacoesDAO avaliacoesDAO;

	public void salvar(Avaliacoes avaliacoes) {
		
		avaliacoes.setNota(10.0);
		avaliacoes.setSituacaoAprovacao("");
		avaliacoesDAO.salvar(avaliacoes);
		
	}
	
	
	public void atualizar (Avaliacoes avaliacoes) {
		
		avaliacoesDAO.atualizar(avaliacoes);
		
	}
	
	@Loggable(enable=false)
	public List<Avaliacoes> listaAvaliacao (Double nota) {
		List<Avaliacoes> avaliacoes = avaliacoesDAO.listarAvaliacao(nota);
				return avaliacoes;
				
	}
	
	public Avaliacoes buscarPorId (Double nota) {
		
		try {
			return avaliacoesDAO.buscarPorId(id);
		}catch(DAOException e) {
			e.printStackTrace();
			
		}
		return null;
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void excluir(Avaliacoes avaliacoes) {
		try {
			avaliacoes = avaliacoesDAO.buscarPorId(avaliacoes.getId());
		} catch (DAOException e) {
			e.printStackTrace();
		}
		
		avaliacoesDAO.excluir(avaliacoes);
	}
}

package br.unifor.pin.saa.bussines;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.unifor.pin.saa.aspectj.Loggable;
import br.unifor.pin.saa.dao.AulasDAO;
import br.unifor.pin.saa.entity.Aulas;
import br.unifor.pin.saa.exceptions.DAOException;
/**
 * @author rafael.mendes
 * 
 */
@Loggable
@Component
public class AulasBO {

	@Autowired
	private AulasDAO aulasDAO;
	
	public void salvar(Aulas aulas) {
		aulas.setTurma("1700");
		aulas.setDescrição("Turma Inicial");
		aulasDAO.salvar(aulas);
	}
	
	public void atualizar(Aulas aulas){
		aulasDAO.atualizar(aulas);
		
	}

	@Loggable(enable=false)
	public List<Aulas> listaPorTurna(String turma) {
		List<Aulas> aulas = aulasDAO.listarPorTurma(turma);
		return aulas;
	}
	
	public Aulas buscarPorId(Long id){
		try {
			return aulasDAO.buscarPorId(id);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void excluir(Aulas aulas) {
		try {
			aulas = aulasDAO.buscarPorId(aulas.getId());
		} catch (DAOException e) {
			e.printStackTrace();
		}
		aulasDAO.excluir(aulas);
	}

}

package br.unifor.pin.saa.bussines;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.unifor.pin.saa.aspectj.Loggable;
import br.unifor.pin.saa.dao.ProfessoresDAO;
import br.unifor.pin.saa.entity.Aulas;
import br.unifor.pin.saa.entity.Professores;
import br.unifor.pin.saa.exceptions.DAOException;
/**
 * @author rafael.mendes
 * 
 */
@Loggable
@Component
public class ProfessoresBO {

	@Autowired
	private ProfessoresDAO professoresDAO;
	
	public void salvar(Professores professores) {
		professores.setNome("Rafael");
		professoresDAO.salvar(professores);
	}
	
	public void atualizar(Professores professores){
		professoresDAO.atualizar(professores);
		
	}

	@Loggable(enable=false)
	public List<Professores> listaPorNome(String nome) {
		List<Professores> nome = professoresDAO.listarPorNome(nome);
		return nome;
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

package br.unifor.pin.saa.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.unifor.pin.saa.entity.Cursa;

@Repository
@Transactional(propagation=Propagation.REQUIRED)
public class CursaDAO {

	@PersistenceContext//O "@PersistenceContext" é responsável por injetar um objeto dentro do entityManager
	private EntityManager entityManager;
		
	public void salvar(Cursa cursa) {//Incluido metodo salvar.
		entityManager.persist(cursa);
	}
	public void atualizar(Cursa cursa) {//Incluido metodo atualizar.
		entityManager.merge(cursa);
	}	

	public void excluir(Cursa cursa) {//Incluido metodo excluir.
		entityManager.remove(cursa);
	}
	
	public Cursa buscarPorId(Long id){//Incluido metodo buscar.
		return entityManager.find(Cursa.class, id);
	
    }
	
	public Cursa buscarPorAlumo(String aluno){//Incluido metodo buscar.
		return entityManager.find(Cursa.class, aluno); 
		
	} 
}
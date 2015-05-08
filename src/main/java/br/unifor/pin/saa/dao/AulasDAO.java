package br.unifor.pin.saa.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.unifor.pin.saa.entity.Aulas;

@Repository
@Transactional(propagation=Propagation.REQUIRED) 
public class AulasDAO {

	@PersistenceContext//O "@PersistenceContext" é responsável por injetar um objeto dentro do entityManager
	private static EntityManager entityManager;
		
	public static void salvar(Aulas aulas) {//Incluido metodo salvar.
		entityManager.persist(aulas);
	}
	public void atualizar(Aulas aulas) {//Incluido metodo atualizar.
		entityManager.merge(aulas);
	}	

	public void excluir(Aulas aulas) {//Incluido metodo excluir.
		entityManager.remove(aulas);
	}
	
	public Aulas buscarPorId(Long id){//Incluido metodo buscar.
		return entityManager.find(Aulas.class, id);
		
		
		
		
		
	} 
}
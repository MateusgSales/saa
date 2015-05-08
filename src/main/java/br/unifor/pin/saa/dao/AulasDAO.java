package br.unifor.pin.saa.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.unifor.pin.saa.entity.Aulas;

@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class AulasDAO {

	@PersistenceContext
	// O "@PersistenceContext" é responsável por injetar um objeto dentro do
	// entityManager
	private EntityManager entityManager;

	public void salvar(Aulas aula) {
		entityManager.persist(aula);
	}

	public void atualizar(Aulas aula){
		entityManager.merge(aula);
	}

	public void excluir(Aulas aula){
		entityManager.remove(aula);
	}
	
	public Aulas buscarPorId(Long id){
		return entityManager.find(Aulas.class, id);
	}
	
}

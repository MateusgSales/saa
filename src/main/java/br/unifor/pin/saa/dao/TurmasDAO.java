package br.unifor.pin.saa.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.unifor.pin.saa.entity.Turmas;

@Repository
@Transactional(propagation=Propagation.REQUIRED)

public class TurmasDAO {
	@PersistenceContext
	private EntityManager entityManager;;
	
	public void salvar(Turmas turma) {
		entityManager.persist(turma);
	}
	
	public void atualizar(Turmas turma){
		entityManager.merge(turma);
	}
	
	
	public Turmas buscaPorId(Long id) {
		
		return entityManager.find(Turmas.class, id);
	}
	
	public void excluir(Turmas turma) {
		entityManager.remove(turma);
	}
}

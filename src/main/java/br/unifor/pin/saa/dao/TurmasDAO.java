package br.unifor.pin.saa.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import br.unifor.pin.saa.entity.Turmas;

public class TurmasDAO {
	@PersistenceContext
	private EntityManager entityManager;
	
	public void salvar(Turmas turma) {
		entityManager.persist(turma);
	}
	
	public void atualizar(Turmas turma){
		entityManager.merge(turma);
	}
	
	
	public Turmas buscaPorId(Integer id) {
		
		return (Turmas) entityManager.find(Turmas.class, id);
	}
	public void excluir(Turmas turma) {
		entityManager.remove(turma);
	}
}

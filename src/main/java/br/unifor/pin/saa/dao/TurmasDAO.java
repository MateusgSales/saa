package br.unifor.pin.saa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

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

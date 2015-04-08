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
	@SuppressWarnings("unchecked")
	public List<Turmas> listarPorNome(String nome) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Turmas> criteriaQuery = criteriaBuilder.createQuery(Turmas.class);
		Root<Turmas> turma = criteriaQuery.from(Turmas.class);
		criteriaQuery.where(criteriaBuilder.like(turma.<String>get("nome"), "%"+nome+"%"));
		
		Query query = entityManager.createQuery(criteriaQuery);
		return query.getResultList();
	}
	
	public Turmas buscaPorId(Integer id) {
		String jpql = "select u from Professores u where u.id = :id";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("id", id);
		
		return (Turmas) query.getSingleResult();
	}
	
	public void excluir(Turmas turma) {
		entityManager.remove(turma);
	}
}

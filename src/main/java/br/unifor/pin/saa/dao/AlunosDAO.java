package br.unifor.pin.saa.dao;

import java.util.List;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.unifor.pin.saa.entity.Alunos;

@Repository
@Transactional(propagation=Propagation.REQUIRED)
public class AlunosDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	public void salvar(Alunos professores) {
		entityManager.persist(professores);
	}
	
	public void atualizar(Alunos professores){
		entityManager.merge(professores);
	}
	@SuppressWarnings("unchecked")
	public List<Alunos> listarPorNome(String nome) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Alunos> criteriaQuery = criteriaBuilder.createQuery(Alunos.class);
		Root<Alunos> alunos = criteriaQuery.from(Alunos.class);
		criteriaQuery.where(criteriaBuilder.like(alunos.<String>get("nome"), "%"+nome+"%"));
		
		Query query = entityManager.createQuery(criteriaQuery);
		return query.getResultList();
	}
	
	public Alunos buscaPorId(Long id) {
		String jpql = "select u from Alunos u where u.id = :id";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("id", id);
		
		return (Alunos) query.getSingleResult();
	}
	
	public Alunos buscarPorNome(String nome){
		String jpql = "select u from Alunos u where u.nome = :nome";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("nome", nome);
		
		return (Alunos) query.getSingleResult();
	}
	
	public void excluir(Alunos alunos) {
		entityManager.remove(alunos);
	}
}

package br.unifor.pin.saa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.unifor.pin.saa.entity.Aulas;
import br.unifor.pin.saa.entity.Usuarios;

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
	
	@SuppressWarnings("unchecked")
	public List<Aulas> listarPorTurma(String turma) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Aulas> criteriaQuery = criteriaBuilder.createQuery(Aulas.class);
		Root<Aulas> aulas = criteriaQuery.from(Aulas.class);
		criteriaQuery.where(criteriaBuilder.like(aulas.<String>get("turma"), "%"+turma+"%"));
		
		Query query = entityManager.createQuery(criteriaQuery);
		return query.getResultList();
	}
	
	public Aulas buscarPorId(Long id){//Incluido metodo buscar.
		return entityManager.find(Aulas.class, id);
		
	} 
}
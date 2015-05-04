package br.unifor.pin.saa.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.unifor.pin.saa.entity.Alunos;

@Repository
@Transactional(propagation=Propagation.REQUIRED)
public class AlunosDAO {

	@PersistenceContext //injetar o objeto dentro do entitymanager
	//permite operações como alvar, atualizar e excluir no entitymanager
	private EntityManager entityManager;
	
	public void salvar(Alunos alunos) {
		entityManager.persist(alunos);
		//persistir um aluno.
	}
	
	public void atualizar(Alunos alunos){
		entityManager.merge(alunos);
	}
	
	public void excluir(Alunos alunos) {
		entityManager.remove(alunos);
	}
	
	public Alunos buscaPorId(Long id) {
		
		return (Alunos) entityManager.find(Alunos.class, id);
	}
	
	public Alunos buscarPorNome(String nome){
		String jpql = "select u from Alunos u where u.nome = :nome";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("nome", nome);
		
		return (Alunos) query.getSingleResult();
	}
	
}

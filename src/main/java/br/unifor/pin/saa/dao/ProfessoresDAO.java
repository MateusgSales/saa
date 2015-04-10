package br.unifor.pin.saa.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.unifor.pin.saa.entity.Professores;


@Repository
@Transactional(propagation=Propagation.REQUIRED)
public class ProfessoresDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	public void salvar(Professores professores){
		entityManager.persist(professores);
	}
	
	public void atualizar(Professores professores){
		entityManager.merge(professores);
	}

	public void excluir(Professores professores) {
		entityManager.remove(professores);
	}
	
	public Professores buscaPorId(Long id) {
		return (Professores) entityManager.find(Professores.class, id);
	}
	
	public Professores buscarPorNome(String nome){
		String jpql = "select r from Professores r where r.nome = :nome";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("nome", nome);
		
		return (Professores) query.getSingleResult();
	}
	
}

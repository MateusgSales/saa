package br.unifor.pin.saa.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.unifor.pin.saa.entity.Avaliacoes;

@Repository
@Transactional(propagation=Propagation.REQUIRED)
public class AvaliacoesDAO {
	
	@PersistenceContext//O "@PersistenceContext" é responsável por injetar um objeto dentro do entityManager
	private EntityManager entityManager;
		
	public void salvar(Avaliacoes avaliacoes) {//Incluido metodo salvar.
		entityManager.persist(avaliacoes);
	}
	public void atualizar(Avaliacoes avaliacoes) {//Incluido metodo atualizar.
		entityManager.merge(avaliacoes);
	}	

	public void excluir(Avaliacoes avaliacoes) {//Incluido metodo excluir.
		entityManager.remove(avaliacoes);
	}
	
	public Avaliacoes buscarPorId(Long id){//Incluido metodo buscar.
		return entityManager.find(Avaliacoes.class, id);
		
	}

}

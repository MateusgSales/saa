package br.unifor.pin.saa.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.unifor.pin.saa.entity.Instituicoes;

@Repository
@Transactional(propagation=Propagation.REQUIRED) 
public class InstituicoesDAO {
		
	@PersistenceContext//O "@PersistenceContext" é responsável por injetar um objeto dentro do entityManager
	private EntityManager entityManager;
		
	public void salvar(Instituicoes instituicao) {//Incluido metodo salvar.
		entityManager.persist(instituicao);
	}
	public void atualizar(Instituicoes instituicao) {//Incluido metodo atualizar.
		entityManager.merge(instituicao);
	}	

	public void excluir(Instituicoes instituicao) {//Incluido metodo excluir.
		entityManager.remove(instituicao);
	}
	
	public Instituicoes buscarPorNome(String nome){//Incluido metodo buscar.
		return entityManager.find(Instituicoes.class, nome); 
		
	} 
	
	public Instituicoes buscarPorId(Long id){//Incluido metodo buscar.
		return entityManager.find(Instituicoes.class, id);
		
	} 
		
}
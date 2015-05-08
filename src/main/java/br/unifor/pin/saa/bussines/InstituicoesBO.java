package br.unifor.pin.saa.bussines;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.unifor.pin.saa.aspectj.Loggable;
import br.unifor.pin.saa.dao.InstituicoesDAO;
import br.unifor.pin.saa.entity.Instituicoes;

@Loggable
	@Component
	public class InstituicoesBO {

		@Autowired
		private InstituicoesDAO instituicoesDAO;
		
		public void salvar(Instituicoes instituicoes) {
			instituicoes.setNome("Unifor");
			instituicoes.setSigla("UF");
			instituicoesDAO.salvar(instituicoes);
		}
		
		public void atualizar(Instituicoes instituicoes){
			instituicoesDAO.atualizar(instituicoes);
			
		}

		@Loggable(enable=false)
		public List<Instituicoes> listaInstituicoesPorNome(String nome) {
			@SuppressWarnings("unchecked")
			List<Instituicoes> instituicoes = (List<Instituicoes>) instituicoesDAO.buscarPorNome(nome);
			return instituicoes;
		}
		
		public Instituicoes buscarPorId(Long id){
			return instituicoesDAO.buscarPorId(id);
		}
		
		@Transactional(propagation=Propagation.REQUIRES_NEW)
		public void excluir(Instituicoes instituicoes) {
			instituicoes = instituicoesDAO.buscarPorId(instituicoes.getId());
			instituicoesDAO.excluir(instituicoes);
		}

	}



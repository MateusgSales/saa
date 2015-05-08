package br.unifor.pin.saa.dao;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AlunosDAOTest.class, AulasDAOTest.class,
		AvaliacoesDAOTest.class, CursaDaoTest.class, InstituicoesDAOTest.class,
		ProfessoresDAOTest.class, TurmasDAOTest.class, UsuarioDAOTest.class })
public class Suit_testes_DAO {

}

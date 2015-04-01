package br.unifor.pin.saa.entity;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

public class Turma implements Serializable {

	private static final long serialVersionUID = 1L;

	
	@Id
	@SequenceGenerator(name="turma_seq", sequenceName="turma_seq", allocationSize=1)
	@GeneratedValue(generator="turma_seq", strategy=GenerationType.SEQUENCE)
	public Long id;
	
	
	
}

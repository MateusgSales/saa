package br.unifor.pin.saa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="professores")
public class Turmas implements Serializable {

	private static final long serialVersionUID =  3L;
	
	@Id
	@SequenceGenerator(name="turma_seq", sequenceName="turma_seq", allocationSize=1)
	@GeneratedValue(generator="turma_seq", strategy=GenerationType.SEQUENCE)
	private Long id;
	
	@Column(nullable=false)
	private String semestre;
	
	@Column(nullable=false)
	private String disciplina;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSemestre() {
		return semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}	

}

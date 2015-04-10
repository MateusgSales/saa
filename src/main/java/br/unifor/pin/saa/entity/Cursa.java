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
@Table(name="Cursa")
public class Cursa implements Serializable {

	private static final long serialVersionUID = -3119315998498423071L;
		
	@Id
	@SequenceGenerator(name="cursa_seq", sequenceName="cursa_seq", allocationSize=1)
	@GeneratedValue(generator="cursa_seq", strategy=GenerationType.SEQUENCE)
	private Long ID;
		
	@Column(nullable=false)
	private String turma;

	@Column
	private String aluno;

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public String getTurma() {
		return turma;
	}

	public void setTurma(String turma) {
		this.turma = turma;
	}

	public String getAluno() {
		return aluno;
	}

	public void setAluno(String aluno) {
		this.aluno = aluno;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}
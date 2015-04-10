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
@Table(name="Avaliacoes")
public class Avaliacoes implements Serializable {

	
	private static final long serialVersionUID = -7295837088686452760L;

	@Id
	@SequenceGenerator(name="Avaliacoes_seq", sequenceName="Avaliacoes_seq", allocationSize=1)
	@GeneratedValue(generator="Avaliacoes_seq", strategy=GenerationType.SEQUENCE)
	
	private Long id;
	
	@Column(nullable=false)
	private String aulas;

	@Column
	private String aluno;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAulas() {
		return aulas;
	}

	public void setAulas(String aulas) {
		this.aulas = aulas;
	}

	public String getAluno() {
		return aluno;
	}

	public void setAluno(String aluno) {
		this.aluno = aluno;
	}

	public String getNota() {
		return nota;
	}

	public void setNota(String nota) {
		this.nota = nota;
	}

	public String getAprovado() {
		return aprovado;
	}

	public void setAprovado(String aprovado) {
		this.aprovado = aprovado;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Column
	private String nota;
	
	@Column
	private String aprovado;
	
}

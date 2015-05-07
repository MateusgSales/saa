package br.unifor.pin.saa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Avaliacoes")
public class Avaliacoes implements Serializable {

	private static final long serialVersionUID = -7295837088686452760L;

	@Id
	@SequenceGenerator(name = "Avaliacoes_seq", sequenceName = "Avaliacoes_seq", allocationSize = 1)
	@GeneratedValue(generator = "Avaliacoes_seq", strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column(nullable = false)
	private String aulas;

	@ManyToOne
	@JoinColumn(name="aluno_id")
	private Alunos aluno;
	
	@Column
	private Double nota;

	@Column
	private String situacaoAprovacao;

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

	public Alunos getAluno() {
		return aluno;
	}

	public void setAluno(Alunos aluno) {
		this.aluno = aluno;
	}

	public Double getNota() {
		return nota;
	}

	public void setNota(Double nota) {
		this.nota = nota;
	}

	

	/**
	 * @deprecated Use {@link #getSituacaoAprovacao()} instead
	 */
	public String getSituacaoAluno() {
		return getSituacaoAprovacao();
	}

	public String getSituacaoAprovacao() {
		return situacaoAprovacao;
	}

	

	/**
	 * @deprecated Use {@link #setSituacaoAprovacao(String)} instead
	 */
	public void setSituacaoAluno(String aprovado) {
		setSituacaoAprovacao(aprovado);
	}

	public void setSituacaoAprovacao(String aprovado) {
		this.situacaoAprovacao = aprovado;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
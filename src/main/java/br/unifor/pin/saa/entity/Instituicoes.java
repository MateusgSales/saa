package br.unifor.pin.saa.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="instituicoes")
public class Instituicoes implements Serializable {

	
	
	private static final long serialVersionUID = 6257788326354568154L;

	@Id
	@SequenceGenerator(name="instituicoes_seq", sequenceName="instituicoes_seq", allocationSize=1)
	@GeneratedValue(generator="instituicoes_seq", strategy=GenerationType.SEQUENCE)
	
	private Long id;
	
	@Column(nullable=false)
	private String nome;

	@Column
	private String sigla;

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	
}
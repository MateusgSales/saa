package br.unifor.pin.saa.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="professores")
public class Professores implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="professores_seq", sequenceName="professores_seq", allocationSize=1)
	@GeneratedValue(generator="professores_seq", strategy=GenerationType.SEQUENCE)
	public Long id;
	
	@Column(nullable=false)
	private String nome;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
		
}

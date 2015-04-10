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
@Table(name="Aulas")
public class Aulas implements Serializable {
	 
	private static final long serialVersionUID = -8968550263647022569L;

	@Id
	@SequenceGenerator(name="aulas_seq", sequenceName="aulas_seq", allocationSize=1)
	@GeneratedValue(generator="aulas_seq", strategy=GenerationType.SEQUENCE)
	
	private Long id;
	
	@Column(nullable=false)
	private String turma;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTurma() {
		return turma;
	}

	public void setTurma(String turma) {
		this.turma = turma;
	}

	public String getDescrição() {
		return descrição;
	}

	public void setDescrição(String descrição) {
		this.descrição = descrição;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Column
	private String descrição;
	
	
	


}

package com.seedshare.entity;

import static javax.persistence.GenerationType.SEQUENCE;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.util.List;

/**
 * Classe de persistência para a tabela Clima.
 * @author joao.silva
 */
@Entity
@Table(name = "CLIMA")
public class Clima implements Serializable {
	private static final long serialVersionUID = 1L;

	private static final String SEQUENCE_NAME = "SQ_CLIMA";
	
	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = SEQUENCE_NAME)
    @SequenceGenerator(name = SEQUENCE_NAME, sequenceName = SEQUENCE_NAME)
    @Basic(optional = false)
	@NotNull
    @Column(name = "ID_CLIMA")
	private Long id;

	@Basic(optional = false)
	@NotNull
	@Size(max = 2500)
	@Column(name = "DESCRICAO", columnDefinition="TEXT")
	private String descricao;

	@Basic(optional = false)
	@NotNull
	@Size(max = 50)
	@Column(name = "NOME")
	private String nome;

	//Associação Many to Many com Especie
	@ManyToMany(mappedBy="climas")
	private List<Especie> especies;

	protected Clima() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Especie> getEspecies() {
		return this.especies;
	}

	public void setEspecies(List<Especie> especies) {
		this.especies = especies;
	}

}
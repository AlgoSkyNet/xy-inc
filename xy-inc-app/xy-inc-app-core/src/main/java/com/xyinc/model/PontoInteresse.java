package com.xyinc.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "T_PONTO_INTERESSE")
@NamedQueries({
	@NamedQuery(name = PontoInteresseNamedQuery.LISTAR_TODOS, 
		query = "select p from PontoInteresse p order by p.nome"),
	@NamedQuery(name = PontoInteresseNamedQuery.LISTAR_POR_APROXIMACAO, 
		query = "select p from PontoInteresse p where p.coordenadaX <= :coordenadaX and p.coordenadaY <= :coordenadaY order by p.nome"),
})
public class PontoInteresse implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	@Column
	private String nome;

	@Column(name = "COORDENADA_X")
	private Integer coordenadaX;

	@Column(name = "COORDENADA_Y")
	private Integer coordenadaY;

	public PontoInteresse() {

	}

	public PontoInteresse(Long id) {
		this.id = id;
	}

	public PontoInteresse(String nome, Integer coordenadaX, Integer coordenadaY) {
		this.nome = nome;
		this.coordenadaX = coordenadaX;
		this.coordenadaY = coordenadaY;
	}

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

	public Integer getCoordenadaX() {
		return coordenadaX;
	}

	public void setCoordenadaX(Integer coordenadaX) {
		this.coordenadaX = coordenadaX;
	}

	public Integer getCoordenadaY() {
		return coordenadaY;
	}

	public void setCoordenadaY(Integer coordenadaY) {
		this.coordenadaY = coordenadaY;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Nome: " + this.nome);
		sb.append(" - Coord. X: " + this.coordenadaX);
		sb.append(" - Coord. Y: " + this.coordenadaY);
		return sb.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (!PontoInteresse.class.isInstance(obj)) {
			return false;
		}
		return PontoInteresse.class.cast(obj).id.equals(this.id);
	}
}

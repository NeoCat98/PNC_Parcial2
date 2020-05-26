package com.uca.capas.domain;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(schema="public",name="cat_categoria")
public class Categoria {
	@Id
	@Column(name="c_categoria")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigoCategoria;
	
	@Column(name="s_categoria")
	@Size(max = 50, message = "El campo nombre de la categoria no debe de ser mayor a 50 caracteres")
	@NotEmpty(message = "No puede estar vacio")
	private String s_categoria;

	@OneToMany(mappedBy = "categoria",fetch = FetchType.EAGER)
	private List<Libros> libros;

	public Categoria() {
		
	}
	
	public Integer getCodigoCategoria() {
		return codigoCategoria;
	}

	public void setCodigoCategoria(Integer codigoCategoria) {
		this.codigoCategoria = codigoCategoria;
	}

	public String getS_categoria() {
		return s_categoria;
	}

	public void setS_categoria(String s_categoria) {
		this.s_categoria = s_categoria;
	}

	public List<Libros> getLibros() {
		return libros;
	}

	public void setLibros(List<Libros> libros) {
		this.libros = libros;
	}
	
}

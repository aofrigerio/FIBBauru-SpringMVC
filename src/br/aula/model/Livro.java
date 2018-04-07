package br.aula.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "CAD_LIVRO")
public class Livro {

	@Id
	@GeneratedValue
	private int id;
	
	@Column(name = "LIV_TITULO")
	private String titulo;
	
	@Column(name = "LIV_FOTO")
	private String foto;
	
	@Column(name = "AUT_QUANTIDADE")
	private int quantidade;
	
	@ManyToOne
	@Cascade(CascadeType.SAVE_UPDATE) //Insere um autor se estiver preenchido
	private Autor autor;
	
	@OneToMany(mappedBy="livro")
	private List<Review> review = new ArrayList<>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public Autor getAutor() {
		return autor;
	}
	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	
	
	
}

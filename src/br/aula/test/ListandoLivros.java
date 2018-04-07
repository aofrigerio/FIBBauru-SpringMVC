package br.aula.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.aula.db.HibernateFactory;
import br.aula.model.Livro;

public class ListandoLivros {

	public static void main(String[] args) {

		Session s = HibernateFactory.configureSessionFactory().openSession();
		
		Livro livro = (Livro) s.get(Livro.class, 1);
		
		System.out.println( livro.getTitulo() +  " - "  +   livro.getAutor().getNome());
		
		
		Query query = s.createQuery("from Livro l where l.autor.id = :id");
		query.setLong("id",2l);
		
		
		List<Livro> livros = query.list();
		
		for (Livro livro1 : livros) {
			System.out.println(livro1.getTitulo() + " - " + livro1.getAutor().getNome());
			
		}

	}

}

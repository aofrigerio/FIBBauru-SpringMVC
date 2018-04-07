package br.aula.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.aula.db.HibernateFactory;
import br.aula.model.Autor;
import br.aula.model.Livro;

public class IncluindoLivro {

	public static void main(String[] args) {		
//		Configuration configuration = new Configuration();
//	    configuration.configure("hibernate.cfg.xml");
//	    ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();        
//	    SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
//      Session s = sessionFactory.openSession();
	
		Session s = HibernateFactory.configureSessionFactory().openSession();

		
		//incluir o livro
		Livro livro = new Livro();
		livro.setFoto("livro1.jpg");
		livro.setQuantidade(10);
		livro.setTitulo("Redes de computadores");
		
		
		//para incluir o ID do autor no Livro
		Autor autor = (Autor) s.get(Autor.class, 1);
		livro.setAutor(autor);
		
		Transaction t = s.beginTransaction();
		s.save(livro);
		t.commit();
	}
}
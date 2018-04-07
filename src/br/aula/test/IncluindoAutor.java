package br.aula.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.aula.db.HibernateFactory;
import br.aula.model.Autor;

public class IncluindoAutor {

	public static void main(String[] args) {		
//		Configuration configuration = new Configuration();
//	    configuration.configure("hibernate.cfg.xml");
//	    ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();        
//	    SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
//      Session s = sessionFactory.openSession();
	
		Session s = HibernateFactory.configureSessionFactory().openSession();

		Autor autor = new Autor();
		//autor.setNome("Deitel Pearson");
		//autor.setNome("Tanenbaum");
		autor.setNome("JJ Benetis");

		Transaction t = s.beginTransaction();
		s.save(autor);
		t.commit();
	}
}
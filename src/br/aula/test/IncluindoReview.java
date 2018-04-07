package br.aula.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.aula.db.HibernateFactory;
import br.aula.model.Usuario;

public class IncluindoReview {

	public static void main(String[] args) {		
//		Configuration configuration = new Configuration();
//	    configuration.configure("hibernate.cfg.xml");
//	    ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();        
//	    SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
//      Session s = sessionFactory.openSession();
	
		Session s = HibernateFactory.configureSessionFactory().openSession();

		Usuario usuario = new Usuario();
		usuario.setEmail("teste@teste.com.br");
		usuario.setPassword("123");
		usuario.setUsername("Teste");
		
		Transaction t = s.beginTransaction();
		s.save(usuario);
		t.commit();
	}
}
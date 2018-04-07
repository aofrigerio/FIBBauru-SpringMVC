package br.aula.test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.aula.db.HibernateFactory;
import br.aula.model.Emprestimo;

public class IncluindoEmprestimo {

	public static void main(String[] args) {		
//		Configuration configuration = new Configuration();
//	    configuration.configure("hibernate.cfg.xml");
//	    ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();        
//	    SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
//      Session s = sessionFactory.openSession();
	
		Session s = HibernateFactory.configureSessionFactory().openSession();

		Emprestimo emprestimo = new Emprestimo();
		emprestimo.setDataemprestimo(new Date());
		
		emprestimo.setDatadevolucao(new Date());
		
		Transaction t = s.beginTransaction();
		s.save(emprestimo);
		t.commit();
	}
}
package br.aula.test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import br.aula.db.HibernateFactory;
import br.aula.model.Cliente;

public class IncluindoCliente {

	public static void main(String[] args) {
		
		//novo c�digo
		Session s = HibernateFactory
							.configureSessionFactory()
							.openSession();
					
		
		/*
		//sem f�brica de conex�o
		Configuration configuration = new Configuration();
	    configuration.configure("hibernate.cfg.xml"); //Impl�cito, por�m, pode fazer com mais conex�es.
	    ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();        
	    SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);

		Session s = sessionFactory.openSession();
		 */
		
		
		Cliente cliente = new Cliente();
		cliente.setNome("napoleao bonaparte");
		cliente.setDataNascimento(new Date());
		cliente.setEndereco("bauru");
		cliente.setEmail("teste@teste.com.br");

		Transaction t = s.beginTransaction();
		s.save(cliente);
		t.commit();
		
		
		
	}
}
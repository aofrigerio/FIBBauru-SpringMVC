package br.aula.db;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.jboss.logging.Logger;

public class HibernateFactory {
	private static SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry;
	private static Logger logger = Logger.getLogger(HibernateFactory.class);
	
	public static SessionFactory configureSessionFactory() throws HibernateException {
		logger.info("abrindo nova sessao");
	    Configuration configuration = new Configuration();
	    configuration.configure("hibernate.cfg.xml");
	    serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();        
	    sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	    return sessionFactory;
	}
}
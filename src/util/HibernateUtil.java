package util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil {
	
	private static SessionFactory sessionFactory=null;
	private static StandardServiceRegistryBuilder serviceBuilder;

	public static SessionFactory getSessionFactory(){
		
		if(sessionFactory == null){
			try{
				Configuration conf = new Configuration();
				conf.configure("hibernate.cfg.xml");
				serviceBuilder = new ServiceRegistryBuilder().
						applySettings(conf.getProperties());
				sessionFactory =  conf.buildSessionFactory(serviceBuilder.build());
			}
			catch(Throwable ex){
				System.err.println("Initial SessionFactory creation failed." + ex);
				throw new ExceptionInInitializerError(ex);
			}
		}
				return sessionFactory;
	
}
}
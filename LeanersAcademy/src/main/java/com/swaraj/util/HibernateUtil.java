package com.swaraj.util;


import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.swaraj.model.Classes;
import com.swaraj.model.Student;
import com.swaraj.model.Subject;
import com.swaraj.model.Teacher;
import com.swaraj.model.User;


/**
 * Java based configuration
 * @author Swathi
 *
 */
public class HibernateUtil {
	private static SessionFactory sessionFactory;
	private static ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();
	

	 static {
		if (sessionFactory == null) {
			try {
				
				System.out.println("Hibernate Java Config started");
				Configuration configuration = new Configuration();

				// Hibernate settings equivalent to hibernate.cfg.xml's properties
				Properties settings = new Properties();
				settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
				settings.put(Environment.URL, "jdbc:mysql://localhost:3306/project?useSSL=false");
				settings.put(Environment.USER, "root");
				settings.put(Environment.PASS, "Napier@123");
				settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");

				settings.put(Environment.SHOW_SQL, "true");

				settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

				settings.put(Environment.HBM2DDL_AUTO, "update");

				configuration.setProperties(settings);
				configuration.addAnnotatedClass(User.class);
				
				configuration.addAnnotatedClass(Teacher.class);
				configuration.addAnnotatedClass(Subject.class);
				configuration.addAnnotatedClass(Classes.class);
				configuration.addAnnotatedClass(Student.class);
				
				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
						.applySettings(configuration.getProperties()).build();
				System.out.println("Hibernate Java Config serviceRegistry created");
				sessionFactory = configuration.buildSessionFactory(serviceRegistry);
				

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static Session getSession() {

        Session session = null;
        if (threadLocal.get() == null) {
            // Create Session object
            session = sessionFactory.openSession();
            threadLocal.set(session);
        } else {
            session = threadLocal.get();
        }
        return session;
    }

    public static void closeSession() {
        Session session = null;
        if (threadLocal.get() != null) {
            session = threadLocal.get();
            session.close();
            threadLocal.remove();
        }
    }

    public static void closeSessionFactory() {
        sessionFactory.close();
    }
}

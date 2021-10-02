package com.swaraj.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.swaraj.model.Classes;
import com.swaraj.util.HibernateUtil;

public class ClassesDao {
	
	/**
	 * Save Classes
	 * @param classes
	 */
	public void saveClasses(Classes classes) {
		Transaction transaction = null;
		try {
			Session session = HibernateUtil.getSession();
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			session.save(classes);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	/**
	 * Update Classes
	 * @param classes
	 */
	public void updateClasses(Classes classes) {
		Transaction transaction = null;
		try {
			Session session = HibernateUtil.getSession();
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			session.update(classes);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	/**
	 * Delete Classes
	 * @param id
	 */
	public void deleteClasses(int id) {

		Transaction transaction = null;
		try {
			Session session = HibernateUtil.getSession();
			// start a transaction
			transaction = session.beginTransaction();

			// Delete a classes object
			Classes classes = (Classes) session.get(Classes.class, id);
			if (classes != null) {
				session.delete(classes);
				System.out.println("classes is deleted");
			}

			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	/**
	 * Get Classes By ID
	 * @param id
	 * @return
	 */
	public Classes getClasses(int id) {

		Transaction transaction = null;
		Classes classes = null;
		try {
			Session session = HibernateUtil.getSession();
			// start a transaction
			transaction = session.beginTransaction();
			// get an classes object
			classes = (Classes) session.get(Classes.class, id);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return classes;
	}
	
	/**
	 * Get all Classess
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Classes> getAllClasses() {

		Transaction transaction = null;
		List<Classes> listOfClasses = null;
		try {
			Session session = HibernateUtil.getSession();
			// start a transaction
			transaction = session.beginTransaction();
			// get an classes object
			
			listOfClasses = session.createQuery("from Classes").getResultList();
			
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return listOfClasses;
	}


}

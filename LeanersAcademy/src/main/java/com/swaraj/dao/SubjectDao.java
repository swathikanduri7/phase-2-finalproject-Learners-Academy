package com.swaraj.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.swaraj.model.Subject;
import com.swaraj.util.HibernateUtil;

public class SubjectDao {
	
	/**
	 * Save Subject
	 * @param subject
	 */
	public void saveSubject(Subject subject) {
		Transaction transaction = null;
		try {
			Session session = HibernateUtil.getSession();
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			session.save(subject);
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
	 * Update Subject
	 * @param subject
	 */
	public void updateSubject(Subject subject) {
		Transaction transaction = null;
		try {
			Session session = HibernateUtil.getSession();
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			session.update(subject);
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
	 * Delete Subject
	 * @param id
	 */
	public void deleteSubject(int id) {

		Transaction transaction = null;
		try {
			Session session = HibernateUtil.getSession();
			// start a transaction
			transaction = session.beginTransaction();

			// Delete a subject object
			Subject subject = session.get(Subject.class, id);
			if (subject != null) {
				session.delete(subject);
				System.out.println("subject is deleted");
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
	 * Get Subject By ID
	 * @param id
	 * @return
	 */
	public Subject getSubject(int id) {

		Transaction transaction = null;
		Subject subject = null;
		try {
			Session session = HibernateUtil.getSession();
			// start a transaction
			transaction = session.beginTransaction();
			// get an subject object
			subject = session.get(Subject.class, id);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return subject;
	}
	
	/**
	 * Get all Subjects
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Subject> getAllSubject() {

		Transaction transaction = null;
		List<Subject> listOfSubject = null;
		try {
			Session session = HibernateUtil.getSession();
			// start a transaction
			transaction = session.beginTransaction();
			// get an subject object
			
			listOfSubject = session.createQuery("from Subject").getResultList();
			
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return listOfSubject;
	}


}

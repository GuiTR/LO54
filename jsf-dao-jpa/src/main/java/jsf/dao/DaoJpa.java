package jsf.dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

import jsf.jpa.Client;
import jsf.jpa.Course;


import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DaoJpa implements IDao{
	@PersistenceContext 
	private DataSource datasource;
	
	public DaoJpa(){
		super();
		Context namingContext;
		try {
			namingContext = new InitialContext();
			datasource = (DataSource)namingContext.lookup ("java:comp/env/jdbc/testDatasource");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public List<Client> getAllClients() {
		List<Client> clients = new ArrayList<Client>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Query q = session.createQuery("from lo54_client");
			clients = q.list();
			transaction.commit();
		} catch (HibernateException he) {
			he.printStackTrace();
			if(transaction != null) {
				try { transaction.rollback(); } catch(HibernateException he2) {
					he2.printStackTrace(); }
				}
			}
			finally {
				if(session != null) {
					try { session.close(); } catch(HibernateException he) {
						he.printStackTrace(); }
					}
			}
		return clients;
	}
	@Override
	public List<Course> getAllCourses() {
		List<Course> courses = new ArrayList<Course>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Query q = session.createQuery("from lo54_course");
			courses = q.list();
			transaction.commit();
		} catch (HibernateException he) {
			he.printStackTrace();
			if(transaction != null) {
				try { transaction.rollback(); } catch(HibernateException he2) {
					he2.printStackTrace(); }
				}
			}
			finally {
				if(session != null) {
					try { session.close(); } catch(HibernateException he) {
						he.printStackTrace(); }
					}
			}
		return courses;
	}
	@Override
	public List<jsf.jpa.Session> getAllSessions() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		List<jsf.jpa.Session> sessions= new ArrayList<jsf.jpa.Session>();
		try {
			transaction = session.beginTransaction();
			Query q = session.createQuery("from lo54_session");
			sessions = q.list();
			transaction.commit();
		} catch (HibernateException he) {
			he.printStackTrace();
			if(transaction != null) {
				try { transaction.rollback(); } catch(HibernateException he2) {
					he2.printStackTrace(); }
				}
			}
			finally {
				if(session != null) {
					try { session.close(); } catch(HibernateException he) {
						he.printStackTrace(); }
					}
			}
		return sessions;
	}
	@Override
	public Client CreateClient(Client client) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.persist(client);
			transaction.commit();
		} catch (HibernateException he) {
			he.printStackTrace();
			if(transaction != null) {
				try { transaction.rollback(); } catch(HibernateException he2) {
					he2.printStackTrace(); }
				}
			}
			finally {
				if(session != null) {
					try { session.close(); } catch(HibernateException he) {
						he.printStackTrace(); }
					}
			}
		return client;
	}
	@Override
	public jsf.jpa.Session getSessionById(Integer id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		jsf.jpa.Session s = null;
		try {
			transaction = session.beginTransaction();
			 s = (jsf.jpa.Session) session.get(jsf.jpa.Session.class, id);
			transaction.commit();
		} catch (HibernateException he) {
			he.printStackTrace();
			if(transaction != null) {
				try { transaction.rollback(); } catch(HibernateException he2) {
					he2.printStackTrace(); }
				}
			}
			finally {
				if(session != null) {
					try { session.close(); } catch(HibernateException he) {
						he.printStackTrace(); }
					}
			}
		return s;
	}
	@Override
	public void DeleteClient(Client client) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.delete(client);
			transaction.commit();
		} catch (HibernateException he) {
			he.printStackTrace();
			if(transaction != null) {
				try { transaction.rollback(); } catch(HibernateException he2) {
					he2.printStackTrace(); }
				}
			}
			finally {
				if(session != null) {
					try { session.close(); } catch(HibernateException he) {
						he.printStackTrace(); }
					}
			}
		
	}
}

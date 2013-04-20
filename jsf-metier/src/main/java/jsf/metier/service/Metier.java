package jsf.metier.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import jsf.dao.IDao;
import jsf.jpa.Client;
import jsf.jpa.Course;
import jsf.jpa.Session;
import jsf.metier.entites.SessionsCourse;

@Transactional
public class Metier implements IMetier, Serializable {

	private IDao dao;
	
	public List<Course> getAllCourses() {
		return dao.getAllCourses();
	}

	/* Permet de retrouver toutes les sessions pour une formation passée en paramètre */
	public SessionsCourse getSessionsCourse(Course course) {
		ArrayList<Session> sessions = (ArrayList<Session>) dao.getAllSessions();
		SessionsCourse sc = new SessionsCourse(course);
		
		for(Session s : sessions) {
			if(s.getCourseCode() == course.getCode())
				sc.addSession(s);
		}
		
		return sc;
	}

	public Client CreateClient(Client client) {
		return dao.CreateClient(client);
	}

	public Session getSessionById(long id) {
		return dao.getSessionById(id);
	}

	public void DeleteClient(Client client) {
		dao.DeleteClient(client);
	}

	public IDao getDao() {
		return dao;
	}

	public void setDao(IDao dao) {
		this.dao = dao;
	}

}

package jsf.metier.entites;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jsf.jpa.Course;
import jsf.jpa.Session;

public class SessionsCourse implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private List<Session> sessions;
	private Course course;
	
	public SessionsCourse() {
		
	}

	public SessionsCourse(List<Session> sessions, Course course) {
		this.sessions = sessions;
		this.course = course;
	}
	
	public SessionsCourse(Course course) {
		this.sessions = new ArrayList<Session>();
		this.course = course;
	}

	public List<Session> getSessions() {
		return sessions;
	}

	public void setSessions(List<Session> sessions) {
		this.sessions = sessions;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
	
	public void addSession(Session s){
		sessions.add(s);
	}
}

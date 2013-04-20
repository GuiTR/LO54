package jsf.dao;

import java.util.List;

import jsf.jpa.Client;
import jsf.jpa.Course;
import jsf.jpa.Session;

public interface IDao {
	
	/* Je n'ai mis que les méthodes utilisés dans la couche metier je te laisse creer les autres ^^ */
	public List<Course> getAllCourses();
	
	public List<Session> getAllSessions();
	
	public Client CreateClient(Client client);
	
	public Session getSessionById(long id);
	
	public void DeleteClient(Client client);
}

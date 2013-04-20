package jsf.metier.service;

import java.util.List;

import jsf.jpa.Client;
import jsf.jpa.Course;
import jsf.jpa.Location;
import jsf.jpa.Session;
import jsf.metier.entites.SessionsCourse;

public interface IMetier {
	
	/* Fonction utilisé pour afficher la page présentant toutes les formations disponibles */
	public List<Course> getAllCourses();
	
	/* Fonction utilisé pour afficher toutes les sessions pour une formation */
	public SessionsCourse getSessionsCourse(Course course);
	
	/* Fonction utilisé après validation du formulaire d'inscription à une formation */
	public Client CreateClient(Client client);
	
	/* Fonction utilisé pour affecter un client à une session */
	public Session getSessionById(long id);
	
	/* Facultative à utiliser pour les tests de la couche metier */
	public void DeleteClient(Client client);
	
}

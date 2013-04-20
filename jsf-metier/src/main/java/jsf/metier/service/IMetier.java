package jsf.metier.service;

import java.util.List;

import jsf.jpa.Client;
import jsf.jpa.Course;
import jsf.jpa.Location;
import jsf.jpa.Session;
import jsf.metier.entites.SessionsCourse;

public interface IMetier {
	
	/* Fonction utilis� pour afficher la page pr�sentant toutes les formations disponibles */
	public List<Course> getAllCourses();
	
	/* Fonction utilis� pour afficher toutes les sessions pour une formation */
	public SessionsCourse getSessionsCourse(Course course);
	
	/* Fonction utilis� apr�s validation du formulaire d'inscription � une formation */
	public Client CreateClient(Client client);
	
	/* Fonction utilis� pour affecter un client � une session */
	public Session getSessionById(long id);
	
	/* Facultative � utiliser pour les tests de la couche metier */
	public void DeleteClient(Client client);
	
}

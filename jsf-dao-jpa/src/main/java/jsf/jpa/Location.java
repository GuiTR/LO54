package jsf.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the lo54_location database table.
 * 
 */
@Entity
@Table(name="lo54_location")
public class Location implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String city;

	public Location() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
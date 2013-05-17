package jsf.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the lo54_course database table.
 * 
 */
@Entity
@Table(name="lo54_course")
public class Course implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String code;

	private String city;

	public Course() {
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
package com.vbkongari.dramaflix.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
@NamedQueries({ 
	@NamedQuery(name = "Drama.findAllDramas", query = "SELECT d FROM Drama d ORDER BY d.title ASC"),
	@NamedQuery(name = "Drama.findDramaByTitle", query = "SELECT d FROM Drama d WHERE d.title=:pTitle") 
})
public class Drama {
	
	@Id
	@GenericGenerator(name = "customUUID", strategy = "uuid2")
	@GeneratedValue(generator = "customUUID")
	private String id;
	
	@Column(unique = true)
	private String title;
	
	private int year;
//	private String rated;
//	private String initialRelease;
//	private int runtime;
//	private String[] genre;
//	private String[] director;
//	private String[] writer;
//	private String[] actor;
//	private String plot;
//	private String language;
//	private String country;
//	private String awards;
//	private String poster;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
	@Override
	public String toString() {
		return "Drama [id=" + id + ", title=" + title + ", year=" + year + "]";
	}	
}

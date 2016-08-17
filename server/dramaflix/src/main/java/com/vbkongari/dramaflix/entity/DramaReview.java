package com.vbkongari.dramaflix.entity;

import java.util.Date;
//import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
//import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table
@NamedQueries({ 
	@NamedQuery(name = "DramaReview.findAllComments", query = "SELECT dr FROM DramaReview dr ORDER BY dr.timestamp DESC"),
	@NamedQuery(name = "DramaReview.avgRating", query = "SELECT AVG(dr.rating + 0.0) FROM DramaReview dr WHERE dr.drama.id=:pDramaId")
})
public class DramaReview {
	
	@Id
	@GenericGenerator(name = "customUUID", strategy = "uuid2")
	@GeneratedValue(generator="customUUID")
	private String id;

	@OneToOne(cascade = CascadeType.REMOVE)
	@LazyCollection(LazyCollectionOption.FALSE)	
	private User user;
	

	//@JoinColumn(name = "userId")
	//private List<User> user;
	
	@OneToOne(cascade = CascadeType.REMOVE)
	@LazyCollection(LazyCollectionOption.FALSE)
	private Drama drama;
	
	//private List<Drama> drama;
	
	private int rating = 0;
	private String comment;

	@Temporal(TemporalType.TIMESTAMP)
	private Date timestamp;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

//	public List<User> getUser() {
//		return user;
//	}
//
//	public void setUser(List<User> user) {
//		this.user = user;
//	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	

	
	public Drama getDrama() {
		return drama;
	}

	public void setDrama(Drama drama) {
		this.drama = drama;
	}
	
	
	

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	
	@Override
	public String toString() {
		return "DramaReview [id=" + id + ", user=" + user + ", drama=" + drama + ", rating=" + rating + ", comment="
				+ comment + ", timestamp=" + timestamp + "]";
	}
}

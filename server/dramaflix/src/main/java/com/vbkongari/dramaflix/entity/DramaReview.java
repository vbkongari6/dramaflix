package com.vbkongari.dramaflix.entity;

import java.util.Date;
//import java.util.List;

//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
//import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
@NamedQueries({ 
	@NamedQuery(name = "DramaReview.findAllComments", query = "SELECT dr FROM DramaReview dr ORDER BY dr.timestamp DESC")
})
public class DramaReview {
	
	@Id
	@GenericGenerator(name = "customUUID", strategy = "uuid2")
	@GeneratedValue(generator="customUUID")
	private String id;

//	@ManyToMany
//	@Column(nullable = false)
//	private List<User> user;
//	
//	@ManyToMany
//	@Column(nullable = false)
//	private List<Drama> drama;
	
	private int rating;
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
//
//	public List<Drama> getDrama() {
//		return drama;
//	}
//
//	public void setDrama(List<Drama> drama) {
//		this.drama = drama;
//	}

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
		timestamp = new Date();
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "DramaReview [id=" + id + ", rating=" + rating + ", comment="
				+ comment + ", timestamp=" + timestamp + "]";
	}
	
//	@Override
//	public String toString() {
//		return "DramaReview [id=" + id + ", user=" + user + ", drama=" + drama + ", rating=" + rating + ", comment="
//				+ comment + ", timestamp=" + timestamp + "]";
//	}
}

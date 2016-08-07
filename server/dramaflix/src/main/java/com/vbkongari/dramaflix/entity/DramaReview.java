package com.vbkongari.dramaflix.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
@NamedQueries({ 
	@NamedQuery(name = "DramaReview.findAllReviews", query = "SELECT dr FROM DramaReview dr ORDER BY d.title ASC")
})
public class DramaReview {
	
	@Id
	@GenericGenerator(name = "customUUID", strategy = "uuid2")
	@GeneratedValue(generator="customUUID")
	private String id;

	@ManyToMany
	private User user;
	
	@ManyToMany
	private Drama drama;
	
	private float rating;
	private String review;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	@Override
	public String toString() {
		return "DramaReview [id=" + id + ", user=" + user + ", drama=" + drama + ", rating=" + rating + ", review="
				+ review + ", dateTime=" + dateTime + "]";
	}

}

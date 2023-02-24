package com.project.questapp.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	
	@Column(name="userName")
	private String userName;
	
	
	@Column(name="password")
	private String password;
	
	@JsonIgnore
	@OneToMany(mappedBy = "user")
	private List<Comment> comments;
	
	@JsonIgnore
	@OneToMany(mappedBy = "user")
	private List<Post> posts;
	
	@JsonIgnore
	@OneToMany(mappedBy = "user")
	private List<Like> likes;
	

	
}

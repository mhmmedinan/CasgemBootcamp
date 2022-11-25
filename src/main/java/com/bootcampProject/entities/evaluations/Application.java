package com.bootcampProject.entities.evaluations;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.bootcampProject.entities.applications.Bootcamp;
import com.bootcampProject.entities.users.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Table(name="applications")
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class Application {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="bootcamp_id")
	private Bootcamp bootcamp;
	
	@Column(name="state")
	private int state;
}

package com.bootcampProject.entities.applications;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.bootcampProject.entities.evaluations.Application;
import com.bootcampProject.entities.users.Instructor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="bootcamps")
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class Bootcamp {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@ManyToOne
	@JoinColumn(name="instructor_id")
	private Instructor instructor;
	
	@Column(name="startDate")
	private LocalDate startDate;
	
	@Column(name="endDate")
	private LocalDate endDate;
	
	@Column(name="state")
	private int state;
	
	@OneToMany(mappedBy = "bootcamp")
	private List<Application> applications;
}

package com.bootcampProject.entities.users;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.bootcampProject.entities.applications.Blacklist;
import com.bootcampProject.entities.evaluations.Application;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name="applicants")
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@PrimaryKeyJoinColumn(name = "user_id")
public class Applicant extends User {

	@Column(name="about")
	private String about;
	
	@OneToMany(mappedBy = "applicant")
	private List<Application> applications;
	
	@OneToMany(mappedBy = "applicant")
	private List<Blacklist> blacklists;
	
}

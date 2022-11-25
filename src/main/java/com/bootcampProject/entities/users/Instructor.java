package com.bootcampProject.entities.users;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.bootcampProject.entities.applications.Bootcamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name="instructors")
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@PrimaryKeyJoinColumn(name = "user_id")
public class Instructor extends User {

	@Column(name="companyName")
	private String companyName;
	
	@OneToMany(mappedBy = "instructor")
	private List<Bootcamp> bootcamps;
}

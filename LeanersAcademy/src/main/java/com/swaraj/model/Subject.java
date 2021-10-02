package com.swaraj.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Subject")
public class Subject {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	protected int id;
	
	@Column(name="subject")
	protected String subjectName;
	
	@ManyToMany(mappedBy = "subjects")
    private Set<Classes> classes = new HashSet<Classes>();
	
	@ManyToMany(mappedBy = "subjects")
    private Set<Teacher> teachers = new HashSet<Teacher>();

	public Subject() {
		super();
	}
	
	

	public Subject(int id, String subjectName) {
		super();
		this.id = id;
		this.subjectName = subjectName;
	}



	public Subject(String subjectName) {
		super();
		this.subjectName = subjectName;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}



	public Set<Classes> getClasses() {
		return classes;
	}



	public void setClasses(Set<Classes> classes) {
		this.classes = classes;
	}



	public Subject(int id, String subjectName, Set<Classes> classes) {
		super();
		this.id = id;
		this.subjectName = subjectName;
		this.classes = classes;
	}



	public Subject(String subjectName, Set<Classes> classes) {
		super();
		this.subjectName = subjectName;
		this.classes = classes;
	}



	public Set<Teacher> getTeachers() {
		return teachers;
	}



	public void setTeachers(Set<Teacher> teachers) {
		this.teachers = teachers;
	}



	@Override
	public String toString() {
		return "Subject [id=" + id + ", subjectName=" + subjectName + ", classes=" + classes + ", teachers=" + teachers
				+ "]";
	}
	
	
	
	
	

}

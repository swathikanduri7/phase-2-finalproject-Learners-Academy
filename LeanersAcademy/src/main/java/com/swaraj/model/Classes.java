package com.swaraj.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="Classes")
public class Classes {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="class_id")
	protected int classId;
	
	@Column(name="class_name")
	protected String className;
	
	@Column(name="class_section")
	protected String classSection;
	
	@ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "classes_subject", 
        joinColumns = { @JoinColumn(name = "class_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "subject_id") }
    )
    Set<Subject> subjects = new HashSet<Subject>();
	
	@ManyToMany(mappedBy = "classes")
    private Set<Teacher> teachers = new HashSet<Teacher>();
	
	@OneToMany(mappedBy="grade")
	private Set<Student> students = new HashSet<Student>();
	

	public Classes() {
		super();
	}
	
	

	public Classes(int classId, String className, String classSection) {
		super();
		this.classId = classId;
		this.className = className;
		this.classSection = classSection;
	}



	public Classes(String className, String classSection) {
		super();
		this.className = className;
		this.classSection = classSection;
	}



	public Classes(String className, String classSection, Set<Subject> subjects) {
		super();
		this.className = className;
		this.classSection = classSection;
		this.subjects = subjects;
	}



	public Classes(int classId, String className, String classSection, Set<Subject> subjects) {
		super();
		this.classId = classId;
		this.className = className;
		this.classSection = classSection;
		this.subjects = subjects;
	}



	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getClassSection() {
		return classSection;
	}

	public void setClassSection(String classSection) {
		this.classSection = classSection;
	}



	public Set<Subject> getSubjects() {
		return subjects;
	}



	public void setSubjects(Set<Subject> subjects) {
		this.subjects = subjects;
	}



	public Set<Teacher> getTeachers() {
		return teachers;
	}



	public void setTeachers(Set<Teacher> teachers) {
		this.teachers = teachers;
	}



	public Set<Student> getStudents() {
		return students;
	}



	public void setStudents(Set<Student> students) {
		this.students = students;
	}



	@Override
	public String toString() {
		return "Classes [classId=" + classId + ", className=" + className + ", classSection=" + classSection
				+ ", subjects=" + subjects + ", teachers=" + teachers + ", students=" + students + "]";
	}
	
	

}

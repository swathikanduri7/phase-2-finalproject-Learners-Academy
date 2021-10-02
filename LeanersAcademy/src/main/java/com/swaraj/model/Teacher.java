package com.swaraj.model;

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
import javax.persistence.Table;

@Entity
@Table(name="Teacher")
public class Teacher {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	protected int id;
	
	@Column(name="teacher_name")
	protected String teacherName;
	
	@Column(name="teacher_pwd")
	protected String qualification;
	
	@Column(name="teacher_email")
	protected String teacherEmail;
	
	@ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "teacher_subject", 
        joinColumns = { @JoinColumn(name = "teacher_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "subject_id") }
    )
    Set<Subject> subjects = new HashSet<Subject>();
	
	@ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "teacher_class", 
        joinColumns = { @JoinColumn(name = "teacher_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "class_id") }
    )
    Set<Classes> classes = new HashSet<Classes>();
	

	public Teacher() {
		super();
	}

	public Teacher(int id, String teacherName, String qualification, String teacherEmail) {
		super();
		this.id = id;
		this.teacherName = teacherName;
		this.qualification = qualification;
		this.teacherEmail = teacherEmail;
	}

	
	public Teacher(String teacherName, String qualification, String teacherEmail) {
		super();
		this.teacherName = teacherName;
		this.qualification = qualification;
		this.teacherEmail = teacherEmail;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getTeacherEmail() {
		return teacherEmail;
	}

	public void setTeacherEmail(String teacherEmail) {
		this.teacherEmail = teacherEmail;
	}

	public Set<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(Set<Subject> subjects) {
		this.subjects = subjects;
	}

	public Set<Classes> getClasses() {
		return classes;
	}

	public void setClasses(Set<Classes> classes) {
		this.classes = classes;
	}

	@Override
	public String toString() {
		return "Teacher [id=" + id + ", teacherName=" + teacherName + ", qualification=" + qualification
				+ ", teacherEmail=" + teacherEmail + ", subjects=" + subjects + ", classes=" + classes + "]";
	}

	
}

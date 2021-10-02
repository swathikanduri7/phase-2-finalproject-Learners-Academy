package com.swaraj.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="Student")
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="student_id")
	protected int studentId;
	
	@Column(name="student_name")
	private String studentName;
	
	@Column(name="student_mobile_number")
	private String mobileNumber;
	
	@Column(name="student_email")
	private String studentEmail;
	
	
	@ManyToOne
	@JoinColumn(columnDefinition="integer", name="class_id")
	private Classes grade;

	
	public Student() {
		super();
	}


	public Student(int studentId, String studentName, String mobileNumber,
			String studentEmail) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.mobileNumber = mobileNumber;
		this.studentEmail = studentEmail;
		
	}


	public Student(String studentName, String mobileNumber, String studentEmail) {
		super();
		this.studentName = studentName;
		this.mobileNumber = mobileNumber;
		this.studentEmail = studentEmail;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getStudentEmail() {
		return studentEmail;
	}

	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}

	public Classes getGrade() {
		return grade;
	}

	public void setGrade(Classes grade) {
		this.grade = grade;
	}


	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", mobileNumber=" + mobileNumber
				+ ", studentEmail=" + studentEmail + ", grade=" + grade + "]";
	}


	
	

}

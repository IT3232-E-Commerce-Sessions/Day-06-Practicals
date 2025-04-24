package com.system.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Student {
	@Id
	private String StudentID;
	@Column(name="student_name")
	private String Name;
	private int Age;
	private double GPA;
	private String Degree;
	
	public Student() {
		
	}

	public Student(String studentID, String name, int age, double gPA, String degree) {
		super();
		StudentID = studentID;
		Name = name;
		Age = age;
		GPA = gPA;
		Degree = degree;
	}

	public String getStudentID() {
		return StudentID;
	}

	public void setStudentID(String studentID) {
		StudentID = studentID;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getAge() {
		return Age;
	}

	public void setAge(int age) {
		Age = age;
	}

	public double getGPA() {
		return GPA;
	}

	public void setGPA(double gPA) {
		GPA = gPA;
	}

	public String getDegree() {
		return Degree;
	}

	public void setDegree(String degree) {
		Degree = degree;
	}
	
	
}

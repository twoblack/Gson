package com.gson.vo;

public class Student extends Person {

	private final String occupation = "student";
	
	@Override
	public String getOccupation() {
		// TODO Auto-generated method stub
		return occupation;
	}
	
	private String schoolName;
	private int studentId;

	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	
	
}

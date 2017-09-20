package com.gson.vo;

public class Teacher extends Person{
private final String occupation = "teacher";
	
	@Override
	public String getOccupation() {
		// TODO Auto-generated method stub
		return occupation;
	}
	
	private String schoolName;
	private int teacherId;

	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

}

package com.CourseMonitor.BinClasses;

public class Course {
	
	private int CourseId;
	private String CourseName;
	private int Fee;
	private String CourseDescription;
	
	

    

	
	public Course(int courseId, String courseName, int fee, String courseDescription) {
		this.CourseId = courseId;
		this.CourseName = courseName;
		this.Fee = fee;
		this.CourseDescription = courseDescription;
	}

	public Course() {
		// TODO Auto-generated constructor stub
	}

	public Course(String cn, int cf, String du) {
		// TODO Auto-generated constructor stub
	}

	public int getCourseId() {
		return CourseId;
	}

	public void setCourseId(int courseId) {
		CourseId = courseId;
	}

	public String getCourseName() {
		return CourseName;
	}

	public void setCourseName(String courseName) {
		CourseName = courseName;
	}

	public int getFee() {
		return Fee;
	}

	public void setFee(int fee) {
		Fee = fee;
	}

	public String getCourseDescription() {
		return CourseDescription;
	}

	public void setCourseDescription(String courseDescription) {
		CourseDescription = courseDescription;
	}

	@Override
	public String toString() {
		return "Course [CourseId=" + CourseId + ", CourseName=" + CourseName + ", Fee=" + Fee + ", CourseDescription="
				+ CourseDescription + "]";
	}
	
	

}

package com.CourseMonitor.BinClasses;

public class Course {
	
	private int CourseId;
	private String CourseName;
	private int Fee;
	private String CourseDescription;
	
	public Course(int courseId, String courseName, int fee, String courseDescription) {
		super();
		CourseId = courseId;
		CourseName = courseName;
		Fee = fee;
		CourseDescription = courseDescription;
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

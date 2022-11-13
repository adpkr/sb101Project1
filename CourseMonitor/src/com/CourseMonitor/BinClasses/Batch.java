package com.CourseMonitor.BinClasses;

public class Batch {
	
	private int BatchId;
	private int CourseId;
	private int FacultyId;
	private int NumberOfStudent;
	private String BatchStartDate;
	private String Duration;
	
	
	public Batch(int batchId, int courseId, int facultyId, int numberOfStudent, String batchStartDate,
			String duration) {
		super();
		BatchId = batchId;
		this.CourseId = courseId;
		this.FacultyId = facultyId;
		this.NumberOfStudent = numberOfStudent;
		this.BatchStartDate = batchStartDate;
		this.Duration = duration;
	}


	public Batch() {
		// TODO Auto-generated constructor stub
	}


	


	public int getBatchId() {
		return BatchId;
	}


	public void setBatchId(int batchId) {
		BatchId = batchId;
	}


	public int getCourseId() {
		return CourseId;
	}


	public void setCourseId(int courseId) {
		CourseId = courseId;
	}


	public int getFacultyId() {
		return FacultyId;
	}


	public void setFacultyId(int facultyId) {
		FacultyId = facultyId;
	}


	public int getNumberOfStudent() {
		return NumberOfStudent;
	}


	public void setNumberOfStudent(int numberOfStudent) {
		NumberOfStudent = numberOfStudent;
	}


	public String getBatchStartDate() {
		return BatchStartDate;
	}


	public void setBatchStartDate(String batchStartDate) {
		BatchStartDate = batchStartDate;
	}


	public String getDuration() {
		return Duration;
	}


	public void setDuration(String duration) {
		Duration = duration;
	}


	@Override
	public String toString() {
		return "Batch [BatchId=" + BatchId + ", CourseId=" + CourseId + ", FacultyId=" + FacultyId
				+ ", NumberOfStudent=" + NumberOfStudent + ", BatchStartDate=" + BatchStartDate + ", Duration="
				+ Duration + "]";
	}
	
	
	

}

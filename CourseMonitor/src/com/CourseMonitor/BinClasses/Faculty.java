package com.CourseMonitor.BinClasses;

public class Faculty {
	
	private int FacultyId;
	private String FacultyName;
	private String FacultyAddress;
	private int Mobile;
	private String email;
	private String username;
	private String password;
	
	
	public Faculty(int facultyId, String facultyName, String facultyAddress, int mobile, String email, String username,
			String password) {
		super();
		FacultyId = facultyId;
		FacultyName = facultyName;
		FacultyAddress = facultyAddress;
		Mobile = mobile;
		this.email = email;
		this.username = username;
		this.password = password;
	}


	public Faculty() {
		// TODO Auto-generated constructor stub
	}


	public int getFacultyId() {
		return FacultyId;
	}


	public void setFacultyId(int facultyId) {
		FacultyId = facultyId;
	}


	public String getFacultyName() {
		return FacultyName;
	}


	public void setFacultyName(String facultyName) {
		FacultyName = facultyName;
	}


	public String getFacultyAddress() {
		return FacultyAddress;
	}


	public void setFacultyAddress(String facultyAddress) {
		FacultyAddress = facultyAddress;
	}


	public int getMobile() {
		return Mobile;
	}


	public void setMobile(int mobile) {
		Mobile = mobile;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "Faculty [FacultyId=" + FacultyId + ", FacultyName=" + FacultyName + ", FacultyAddress=" + FacultyAddress
				+ ", Mobile=" + Mobile + ", email=" + email + ", username=" + username + ", password=" + password + "]";
	}
	
	
	
	

}

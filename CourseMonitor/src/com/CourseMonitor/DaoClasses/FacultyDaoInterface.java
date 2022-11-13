package com.CourseMonitor.DaoClasses;

import java.util.List;

import com.CourseMonitor.BinClasses.CoursPlan;
import com.CourseMonitor.BinClasses.Faculty;
import com.CourseMonitor.ExceptionClasses.CoursPlanException;
import com.CourseMonitor.ExceptionClasses.FacultyException;

public interface FacultyDaoInterface {
	
	public String RegistorFaculty(Faculty f1)throws FacultyException;
	
	public String LoginFaculty(String username,String password) throws FacultyException;
	
	public List<CoursPlan> ViewCoursPlan()throws CoursPlanException;

}

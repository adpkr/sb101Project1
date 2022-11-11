package com.CourseMonitor.DaoClasses;

import java.util.List;


import com.CourseMonitor.BinClasses.Admin;
import com.CourseMonitor.BinClasses.Course;
import com.CourseMonitor.ExceptionClasses.AdminException;
import com.CourseMonitor.ExceptionClasses.BatchException;
import com.CourseMonitor.ExceptionClasses.CoursPlanException;
import com.CourseMonitor.ExceptionClasses.CourseException;
import com.CourseMonitor.ExceptionClasses.FacultyException;

public interface DaoInterface {
	
	public String RegistorAdmin(Admin admin)throws AdminException;
	
	public String LogInAdmin(String username,String password)throws AdminException;
	
	public String CourseUpdate(Course c)throws CourseException;
	
	public List<Course> ViewCourseAdmin()throws CourseException;

}

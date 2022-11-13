package com.CourseMonitor.DaoClasses;

import java.util.List;


import com.CourseMonitor.BinClasses.Admin;
import com.CourseMonitor.BinClasses.Batch;
import com.CourseMonitor.BinClasses.CoursPlan;
import com.CourseMonitor.BinClasses.Course;
import com.CourseMonitor.BinClasses.Faculty;
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
	
	public String BatchUpdate(Batch b)throws BatchException;
	
	public List<Batch> viewBatchAdmin() throws BatchException;
	
	public Course BatchIdToCourse(int BatchId)throws CourseException;
	
	public String FacultyUpdate(Faculty f)throws FacultyException;
	
	public List<Faculty> ViewFacultyAdmin()throws FacultyException;
	
	public Batch FacultyToBatch(int FacultyId)throws BatchException;
	
	public String UpdateCoursPlan(CoursPlan cp) throws CoursPlanException;
	
	public List<CoursPlan> ViewCoursPlan()throws CoursPlanException;
	

}

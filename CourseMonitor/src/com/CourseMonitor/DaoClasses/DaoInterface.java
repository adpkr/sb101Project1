package com.CourseMonitor.DaoClasses;

import com.CourseMonitor.BinClasses.Admin;
import com.CourseMonitor.ExceptionClasses.AdminException;

public interface DaoInterface {
	
	public String RegistorAdmin(Admin admin)throws AdminException;

}

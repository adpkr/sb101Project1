package com.CourseMonitor.MainClasses;

import java.util.List;
import java.util.Scanner;

import com.CourseMonitor.BinClasses.Admin;
import com.CourseMonitor.BinClasses.Course;
import com.CourseMonitor.DaoClasses.DaoImplement;
import com.CourseMonitor.DaoClasses.DaoInterface;
import com.CourseMonitor.ExceptionClasses.AdminException;
import com.CourseMonitor.ExceptionClasses.BatchException;
import com.CourseMonitor.ExceptionClasses.CoursPlanException;
import com.CourseMonitor.ExceptionClasses.CourseException;
import com.CourseMonitor.ExceptionClasses.FacultyException;


public class AdminLoginMain {
	
	private static char[] c1;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter your name:");
		String n = sc.next();
		
		System.out.println("Enter password:");
		String p = sc.next();
		
		Admin ad = new Admin(n, p);
		
		DaoInterface db = new DaoImplement();
		try {
			String ans = db.LogInAdmin(n, p);
			System.out.println();
			System.out.println("Welcome "+n);
			System.out.println("---------------------");
			
			
			System.out.println("Enter 1 for Course Update.");
			System.out.println("Enter 2 for Course View.");
			
			int q = sc.nextInt();
			
			switch(q) {
			
              case 1: {
				
				System.out.println("Enter Course Id:");
				int id = sc.nextInt();
				
				System.out.println("Enter Course Name:");
				String name = sc.next();
				
				System.out.println("Enter Course Fee:");
				int fee = sc.nextInt();
				
				System.out.println("Enter Course description:");
				String desc = sc.next();
				
				Course c1 = new Course(id, name, fee, desc);
				
				DaoInterface dao = new DaoImplement();
				
				try {
					String result = dao.CourseUpdate(c1);
					
				} catch (CourseException e) {
					
					e.printStackTrace();
				}
				break;
			  }
              case 2:{
            	 
            	 DaoInterface dao1 = new DaoImplement();
            	 try {
            		 List<Course> ls = dao1.ViewCourseAdmin();
            		 
            		 System.out.println("===================================");
            		 ls.forEach(s1 -> System.out.println(s1));
            		 System.out.println("===================================");
				   
				} catch (CourseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            	 break;
            	  
              }
             
              
              default:{
            	  System.out.println("Admin Logout...");
              }
			
		}
			
		
			
			
			
			
		} catch (AdminException e) {
			System.out.println(e.getMessage());
		}
		
		
	}

	private static void ViewCourseAdmin() {
		// TODO Auto-generated method stub
		
	}

}

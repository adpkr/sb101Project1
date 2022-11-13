package com.CourseMonitor.MainClasses;

import java.util.List;
import java.util.Scanner;

import com.CourseMonitor.BinClasses.CoursPlan;
import com.CourseMonitor.BinClasses.Faculty;
import com.CourseMonitor.DaoClasses.DaoImplement;
import com.CourseMonitor.DaoClasses.DaoInterface;
import com.CourseMonitor.DaoClasses.FacultyDaoImpl;
import com.CourseMonitor.DaoClasses.FacultyDaoInterface;
import com.CourseMonitor.ExceptionClasses.CoursPlanException;
import com.CourseMonitor.ExceptionClasses.FacultyException;

public class LoginFacultyMain {
	
	public static void main(String[] args) {
		
        Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter your username:");
		String n = sc.next();
		
		System.out.println("Enter password:");
		String p = sc.next();
		
		Faculty f1 = new Faculty();
		f1.setUsername(n);
		f1.setPassword(p);
		
		FacultyDaoInterface db = new FacultyDaoImpl();
		
			try {
				String ans = db.LoginFaculty(n, p);
				
				
				System.out.println();
			    System.out.println("Welcome "+n);
			    System.out.println("---------------------");
			    
			    
			    
			    System.out.println("Enter 1 Views Course plan.");
			    System.out.println("Enter 2 For Logout");
			    
			    System.out.println("---------------------");
			    
			    
			    
			    int q = sc.nextInt();
			    
			    switch (q) {
				case 1: {
					
					  DaoInterface dao = new DaoImplement();
	            	  
	            	  try {
						List<CoursPlan> ls = dao.ViewCoursPlan();
						
						ls.forEach(s -> System.out.println(s));
						
						
						
					} catch (CoursPlanException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	            	  
	            	  
	            	  break;
					
				}
				
				case 2:{
					
					System.out.println("Logout Sucessfull...");
					
					break;
				}
				
				
				default:
					System.out.println("Invalid Number...");;
				}
			    
			    
			    
			    
			    
				
			} catch (FacultyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
				System.out.println(e.getMessage());
			}
			
			
		
		
	}

}

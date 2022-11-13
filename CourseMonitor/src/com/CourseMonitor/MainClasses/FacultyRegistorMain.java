package com.CourseMonitor.MainClasses;

import java.util.Scanner;

import com.CourseMonitor.BinClasses.Faculty;
import com.CourseMonitor.DaoClasses.DaoImplement;
import com.CourseMonitor.DaoClasses.DaoInterface;
import com.CourseMonitor.ExceptionClasses.FacultyException;

public class FacultyRegistorMain {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		  
  	  System.out.println("Enter Faculty Id:");
  	  int fi = sc.nextInt();
  	  
  	  System.out.println("Enter Faculty Name:");
  	  String fn = sc.next();
  	  
  	  System.out.println("Enter Faculty Address:");
  	  String fad = sc.next();
  	  
  	  System.out.println("Enter Mobile Number:");
  	  int fm = sc.nextInt();
  	  
  	  System.out.println("Enter Email:");
  	  String fe = sc.next();
  	  
  	  System.out.println("Enter Username:");
  	  String fun = sc.next();
  	  
  	  System.out.println("Enter Password:");
  	  String fp = sc.next();
  	  
  	  Faculty f= new Faculty(fi, fn, fad, fm, fe, fun, fp);
  	  
  	  DaoInterface dao = new DaoImplement();
  	  
  	  try {
			String result = dao.FacultyUpdate(f);
			
			
			
		} catch (FacultyException e) {
			
			e.printStackTrace();
			
		}
		
	}

}

package com.CourseMonitor.MainClasses;

import java.util.List;
import java.util.Scanner;

import com.CourseMonitor.BinClasses.Admin;
import com.CourseMonitor.BinClasses.Batch;
import com.CourseMonitor.BinClasses.CoursPlan;
import com.CourseMonitor.BinClasses.Course;
import com.CourseMonitor.BinClasses.Faculty;
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
			System.out.println("Enter 2 for Course Views.");
			System.out.println("Enter 3 for Batch Update.");
			System.out.println("Enter 4 for Batch Views.");
			System.out.println("Enter 5 for BatchId to Course Views.");
			System.out.println("Enter 6 for Faculty Upadate.");
			System.out.println("Enter 7 for Faculty Views.");
			System.out.println("Enter 8 for Faculty id to Batch views.");
			System.out.println("Enter 9 for CoursePlan Update.");
			System.out.println("Enter 10 for CoursePlan Views.");
			
			System.out.println("----------------------");
			
			
			
			
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
              
              
              
              
              
              case 3:{
            	  
            	  System.out.println("Enter Batch Id:");
            	  int bid = sc.nextInt();
            	  
            	  System.out.println("Enter Course Id:");
            	  int cid = sc.nextInt();
            	  
            	  System.out.println("Enter Faculty Id:");
            	  int fid = sc.nextInt();
            	  
            	  System.out.println("Enter Number of Student:");
            	  int sno = sc.nextInt();
            	  
            	  System.out.println("Enter Batch start date by this formate yyyy-mm-dd  :");
            	  String bdate = sc.next();
            	  
            	  System.out.println("Enter Duration:");
            	  String dur = sc.next();
            	  
            	  Batch b1 = new Batch(bid, cid, fid, sno, bdate, dur);
            	  DaoInterface dao = new DaoImplement();
            	  
            	  
            	  try {
					String result = dao.BatchUpdate(b1);
		
				} catch (BatchException e) {
					
					e.printStackTrace();
				}
            	  
            	  
            	  break;
              }
              
              
              
              case 4:{
            	  
            	  DaoInterface dao = new DaoImplement();
            	  
            	  try {
					List<Batch> ls = dao.viewBatchAdmin();
					
					ls.forEach(s -> System.out.println(s));
					
				} catch (BatchException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            	  
            	  
            	  break;
            	  
              }
              
              
              
              case 5:{
            	  
            	  System.out.println("Enter BatchId");
            	  int id = sc.nextInt();
            	  
            	  DaoInterface dao = new DaoImplement();
            	  
            	  try {
					Course c1 = dao.BatchIdToCourse(id);
					
					if(c1 != null) {
						
						System.out.println(c1);
					}
					else {
						throw new CourseException("Batch Id Not Valid....");
					}
					
					
				} catch (CourseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            	  
            	  break;
            	  
              }
              
              
              
              
              
              
              case 6:{
            	  
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
            	  
            	  
            	  
            	break;  
              }
              
              
              
              case 7:{
            	  
            	  DaoInterface dao = new DaoImplement();
            	  
            	  try {
					List<Faculty> ls = dao.ViewFacultyAdmin();
					
					ls.forEach(s -> System.out.println(s));
					
					
				} catch (FacultyException e) {
					
					e.printStackTrace();
				}
            	  
            	  break;
            	  
              }
              
              
              case 8:{
            	  
            	  System.out.println("Enter Faculty Id:");
            	  int fid = sc.nextInt();
            	  
                  DaoInterface dao = new DaoImplement();
                  
                  try {
					Batch b1 = dao.FacultyToBatch(fid);
					
					if(b1 != null) {
						
						System.out.println(b1);
						
					}
					else {
						throw new BatchException("Faculty Id Not Found...");
					}
					
					
					
				} catch (BatchException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

            	  
            	
            	  break;
              }
              
              
              
              
              
              
              case 9:{
            	  
            	  System.out.println("Enter Plan Id :");
            	  int pid = sc.nextInt();
            	  
            	  System.out.println("Enter Batch Id :");
            	  int bid = sc.nextInt();
            	  
            	  System.out.println("Enter Day Number :");
            	  int dn = sc.nextInt();
            	  
            	  System.out.println("Enter Topic :");
            	  String t = sc.next();
            	  
            	  System.out.println("Enter Status :");
            	  String s = sc.next();
            	  
            	  CoursPlan cp = new CoursPlan(pid, bid, dn, t, s);
            	  
            	  DaoInterface dao = new DaoImplement();
            	  
            	  try {
					String result = dao.UpdateCoursPlan(cp);
					
				} catch (CoursPlanException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            	  
            	  break;
              }
              
              
              
              
              
              case 10:{
            	  
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
              
              
              
              
              
              
           
              
              
              
              default:{
            	  System.out.println("Admin Logout...");
              }
			
		}
			
		
			
			
			
			
			
			
			
		} catch (AdminException e) {
			System.out.println(e.getMessage());
		}
		
		
	}

	

}

package com.CourseMonitor.MainClasses;

import java.util.Scanner;

import com.CourseMonitor.BinClasses.Admin;
import com.CourseMonitor.DaoClasses.DaoImplement;
import com.CourseMonitor.DaoClasses.DaoInterface;
import com.CourseMonitor.ExceptionClasses.AdminException;



public class AdminRegistorMain {
	
    public static void main(String[] args) {
		
    	Scanner sc = new Scanner(System.in);
    	
    	System.out.println("Enter Username...");
    	String u = sc.next();
    	
    	System.out.println("Enter password...");
    	String p = sc.next();
    	
    	Admin ad = new Admin(u, p);
    	
    	DaoInterface da = new DaoImplement();
    	
    	try {
			String result = da.RegistorAdmin(ad);
			System.out.println(result);
		} catch (AdminException e) {
			
			e.printStackTrace();
		}
    	
	}
}

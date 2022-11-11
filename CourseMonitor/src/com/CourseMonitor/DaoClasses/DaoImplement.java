package com.CourseMonitor.DaoClasses;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.CourseMonitor.BinClasses.Admin;
import com.CourseMonitor.BinClasses.Course;
import com.CourseMonitor.ExceptionClasses.AdminException;
import com.CourseMonitor.ExceptionClasses.BatchException;
import com.CourseMonitor.ExceptionClasses.CoursPlanException;
import com.CourseMonitor.ExceptionClasses.CourseException;
import com.CourseMonitor.ExceptionClasses.FacultyException;
import com.CourseMonitor.Utility.DbUtil;

public class DaoImplement implements DaoInterface{

	@Override
	public String RegistorAdmin(Admin admin) throws AdminException {
		
		String massage = "Not Inserted...";
		
		try (Connection conn =  DbUtil.ProvideConnection()){
			
		    PreparedStatement ps= conn.prepareStatement("insert into Admin values (?,?)");
			ps.setString(1,admin.getUsername());
			ps.setString(2, admin.getPassword());
			
			int x = ps.executeUpdate();
			
			if(x>0)
				massage = ("Registor Admin Sucessfully...");
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		return massage;
		
	}

	@Override
	public String LogInAdmin(String username, String password)
			throws AdminException{
		
		String massage = "null";
		
		try (Connection conn =  DbUtil.ProvideConnection()){
			
			PreparedStatement ps =  conn.prepareStatement("select * from Admin where username = ? And password = ?");
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				String n = rs.getString("username");
				String p = rs.getString("password");
				Admin ad = new Admin(n, p);
			}
			else {
				throw new AdminException("Invalid Username or Password...");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		    throw new AdminException(e.getMessage());
		}
		
		
		return massage;
	}

	@Override
	public String CourseUpdate(Course c) throws CourseException {
		
		String massage = "Not Inserted...";
		
		try(Connection conn = DbUtil.ProvideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("insert into course values(?,?,?,?)");
			
			ps.setInt(1, c.getCourseId());
			ps.setString(2, c.getCourseName());
			ps.setInt(3, c.getFee());
			ps.setString(4, c.getCourseDescription());
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				System.out.println("Course Inserted Sucessfully....");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		
		return massage;
		
	}

	@Override
	public List<Course> ViewCourseAdmin() throws CourseException {
		
		List<Course> ls = new ArrayList<>();
		
		try(Connection conn = DbUtil.ProvideConnection()) {
			PreparedStatement ps = conn.prepareStatement("select * from course");
		    ResultSet rs =  ps.executeQuery();
		    
		    while(rs.next()) {
		    	
		    	Course c1 = new Course();
		    	c1.setCourseId(rs.getInt("CourseId"));
		    	c1.setCourseName(rs.getString("CourseName"));
		    	c1.setFee(rs.getInt("Fee"));
		    	c1.setCourseDescription(rs.getString("CourseDescription"));
		    	
		    	ls.add(c1);
		    	
		    	
		    	
		    }
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return ls;
		
	}

}

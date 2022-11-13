package com.CourseMonitor.DaoClasses;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.CourseMonitor.BinClasses.CoursPlan;
import com.CourseMonitor.BinClasses.Faculty;
import com.CourseMonitor.ExceptionClasses.CoursPlanException;
import com.CourseMonitor.ExceptionClasses.FacultyException;
import com.CourseMonitor.Utility.DbUtil;

public class FacultyDaoImpl implements FacultyDaoInterface{

	@Override
	public String RegistorFaculty(Faculty f1) throws FacultyException {
		
		String massage = "Not Registor...";
		
		try (Connection conn = DbUtil.ProvideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("Insert into Faculty Values(?,?,?,?,?,?,?)");
			
			ps.setInt(1, f1.getFacultyId());
			ps.setString(2, f1.getFacultyName());
			ps.setString(3, f1.getFacultyAddress());
			ps.setInt(4, f1.getMobile());
			ps.setString(5, f1.getEmail());
			ps.setString(6, f1.getUsername());
			ps.setString(7, f1.getPassword());
			
			int x =  ps.executeUpdate();
			
			if(x>0) {
				
				System.out.println("Registor Faculty Sucessfully...");
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		
		
		return massage;
	}
	
	
	
	
	
	
	
	

	@Override
	public String LoginFaculty(String username, String password) throws FacultyException {
		
		String massage = null;
		
		try(Connection conn = DbUtil.ProvideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("Select * from Faculty where username = ? and password = ?");
			
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs =  ps.executeQuery();
			
			if(rs.next()) {
				
				String un = rs.getString("username");
				String p = rs.getString("password");
				
				Faculty f1 = new Faculty();
				f1.setUsername(un);
				f1.setPassword(p);
				
			}
			else {
				throw new FacultyException("Invalid Username or Password...");
			}
			
			
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new FacultyException(e.getMessage());
		}
		
		
		return massage;
	}









	@Override
	public List<CoursPlan> ViewCoursPlan() throws CoursPlanException {
		
		
	List<CoursPlan> ls = new ArrayList<>();
		
		try (Connection conn = DbUtil.ProvideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("Select * from CoursPlan");
		 	ResultSet rs =  ps.executeQuery();
			
		 	while(rs.next()) {
		 		
		 		CoursPlan cp = new CoursPlan();
		 		
		 		cp.setPlanId(rs.getInt("PlanId"));
		 		cp.setBatchId(rs.getInt("BatchId"));
		 		cp.setDayNumber(rs.getInt("DayNumber"));
		 		cp.setTopic(rs.getString("Topic"));
		 		cp.setStatus(rs.getString("Status"));
		 		
		 		ls.add(cp);
		 		
		 		
		 		
		 	}
		 	
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		
		
		
		
		
		
		return ls;
		
		
	}

}

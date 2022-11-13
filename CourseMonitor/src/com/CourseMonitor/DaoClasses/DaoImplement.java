package com.CourseMonitor.DaoClasses;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
	
	
	
	
	
	
	

	@Override
	public String BatchUpdate(Batch b) throws BatchException {
		
		String massage = "Not Inserted...";
		
		try(Connection conn = DbUtil.ProvideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("insert into Batch values (?,?,?,?,?,?)");
			
			ps.setInt(1, b.getBatchId());
			ps.setInt(2, b.getCourseId());
			ps.setInt(3, b.getFacultyId());
			ps.setInt(4, b.getNumberOfStudent());
			ps.setString(5, b.getBatchStartDate());
			ps.setString(6, b.getDuration());
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				System.out.println("Batch Inserted Sucessfully...");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		
		return massage;
		
	}




	


	@Override
	public List<Batch> viewBatchAdmin() throws BatchException {
		
		List<Batch> ls = new ArrayList<>();
		
		try(Connection conn = DbUtil.ProvideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select * from batch");
			ResultSet rs =  ps.executeQuery();
			
			while(rs.next()) {
				
				Batch b1 = new Batch();
				b1.setBatchId(rs.getInt("BatchId"));
				b1.setCourseId(rs.getInt("CourseId"));
				b1.setFacultyId(rs.getInt("FacultyId"));
				b1.setNumberOfStudent(rs.getInt("NumberOfStudent"));
				b1.setBatchStartDate(rs.getString("BatchStartDate"));
				b1.setDuration(rs.getString("Duration"));
				
				ls.add(b1);
				
			}
			
			
			
		} catch (SQLException e) {
			e.getMessage();
			
		}
		
		
		return ls;
	}
	
	
	
	
	
	
	@Override
	public Course BatchIdToCourse(int BatchId) throws CourseException {
		Course c1 = null;
		
		try (Connection conn = DbUtil.ProvideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("Select * from Course where CourseId = ?");
			
			ps.setInt(1, BatchId);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
				int CId = rs.getInt("CourseId");
				String cn = rs.getString("CourseName");
				int cf = rs.getInt("Fee");
				String du = rs.getString("CourseDescription");
				
				c1 = new Course(CId, cn, cf, du);
				
				
				
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		
		
		
		return c1;
	}
	
	
	






	@Override
	public String FacultyUpdate(Faculty f) throws FacultyException {
		
		String massage = "Not Inserted...";
		
		
		try(Connection conn = DbUtil.ProvideConnection()) {
			
		   PreparedStatement ps = 	conn.prepareStatement("insert into Faculty values(?,?,?,?,?,?,?)");
			
		   ps.setInt(1, f.getFacultyId());
		   ps.setString(2, f.getFacultyName());
		   ps.setString(3, f.getFacultyAddress());
		   ps.setInt(4, f.getMobile());
		   ps.setString(5, f.getEmail());
		   ps.setString(6, f.getUsername());
		   ps.setString(7, f.getPassword());
		   
		   int x = ps.executeUpdate();
		   
		   if(x>0) {
			   System.out.println("Faculty Inserted Sucessfully...");
		   }
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		
		
		
		return massage;
		
	}






	@Override
	public List<Faculty> ViewFacultyAdmin() throws FacultyException {
		
		List<Faculty> ls = new ArrayList<>();
		
		try(Connection conn = DbUtil.ProvideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("Select * from Faculty");
			ResultSet rs =  ps.executeQuery();
			
			while(rs.next()) {
				
				Faculty fu = new Faculty();
				
				fu.setFacultyId(rs.getInt("FacultyId"));
				fu.setFacultyName(rs.getString("FacultyName"));
				fu.setFacultyAddress(rs.getString("FacultyAddress"));
				fu.setMobile(rs.getInt("Mobile"));
				fu.setEmail(rs.getString("email"));
				fu.setUsername(rs.getString("username"));
				fu.setPassword(rs.getString("password"));
				
				ls.add(fu);
				
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		
		
		
		
		return ls;
		
	}






	@Override
	public Batch FacultyToBatch(int FacultyId) throws BatchException {
		
		Batch b1 =null;
		
		try (Connection conn = DbUtil.ProvideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from Batch where FacultyId = ?");
			ps.setInt(1, FacultyId);
			
			ResultSet rs =  ps.executeQuery();
			
			if(rs.next()) {
				
				int bid = rs.getInt("BatchId");
				int cid = rs.getInt("CourseId");
				int fid = rs.getInt("FacultyId");
				int ns = rs.getInt("NumberOfStudent");
				String bsdt = rs.getString("BatchStartDate");
				String d = rs.getString("Duration");
				
				b1 = new Batch(bid,cid,fid,ns,bsdt,d);
				
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		
		
		
		
		
		return b1;
		
	}






	@Override
	public String UpdateCoursPlan(CoursPlan cp) throws CoursPlanException {
		
		String massage = "Not Inserted....";
		
		try (Connection conn = DbUtil.ProvideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("insert into CoursPlan values (?,?,?,?,?)");
			
			ps.setInt(1, cp.getPlanId());
			ps.setInt(2, cp.getBatchId());
			ps.setInt(3, cp.getDayNumber());
			ps.setString(4, cp.getTopic());
			ps.setString(5, cp.getStatus());
			
		    int x = ps.executeUpdate();
		    
		    if(x>0) {
		    	
		    	System.out.println("CoursePlan Inserted Sucessfully....");
		    	
		    }
			
			
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
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

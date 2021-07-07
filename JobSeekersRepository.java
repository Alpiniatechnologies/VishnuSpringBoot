package org.jobSeekers.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import org.springframework.stereotype.Repository;

@Repository
public class JobSeekersRepository {
	
	public void saveRegisterDetails(String fName,String mName,String lName,String email,String mobile) {
		Connection con=null;
		PreparedStatement stmt=null;
		
		try {
			
			String query="insert into jobseekers(firstname,middlename,lastname,email,mobile) values(?,?,?,?,?) ";
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "root", "6594shiva");
			stmt=con.prepareStatement(query);
			stmt.setString(1, fName);
			stmt.setString(2, mName);
			stmt.setString(3, lName);
			stmt.setString(4, email);
			stmt.setString(5, mobile);
			stmt.execute();
			con.close();
			stmt.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	public JobSeekersModel search(String search) {
		Connection con=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		JobSeekersModel js=null;
		try {
			
			String query="select * from jobseekers where firstname='"+search+"'";
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "root", "6594shiva");
			stmt=con.prepareStatement(query);
			//stmt.setString(1, search);
			rs=stmt.executeQuery(query);
			while(rs.next()) {
				js=new JobSeekersModel(rs.getString("firstname"),rs.getString("middlename"),rs.getString("lastname"),rs.getString("email"),rs.getString("mobile"));
				System.out.println(rs.getString("firstname"));
				System.out.println(rs.getString("middlename"));
				System.out.println(rs.getString("lastname"));
				System.out.println(rs.getString("email"));
				System.out.println(rs.getString("mobile"));
								
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		return js;
		
		
	}	
	
	public String checkLoginDetails(String username,String password) {
		Connection con=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		String status=null;
		try {
			String query="select * from jobseekerSignIn where username='"+username+"' and password='"+password+"'";
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "root", "6594shiva");
			stmt=con.prepareStatement(query);
			rs=stmt.executeQuery(query);
			if(rs.next()) {
				status="validUser";
			}else {
				status="notValidUser";
			}
			con.close();
			stmt.close();
			rs.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return status;
		
	}
	
	
	
	
	public void saveSignInDetailsToDb(String userName,String password,String recoveryEmail) {
		Connection con=null;
		PreparedStatement stmt=null;
		try {
			String query="insert into jobseekersignin(username,password,recoveryEmail) values(?,?,?)";
			Class.forName("com.mysql.cj.jdbc.Driver");	
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "root", "6594shiva");
			stmt=con.prepareStatement(query);
			stmt.setString(1, userName);
			stmt.setString(2, password);
			stmt.setString(3, recoveryEmail);
			stmt.execute();
			
			con.close();
			stmt.close();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}

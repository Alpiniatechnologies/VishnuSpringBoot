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

}

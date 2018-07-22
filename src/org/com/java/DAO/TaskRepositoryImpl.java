package org.com.java.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.com.java.model.Task;

public class TaskRepositoryImpl implements TaskRepository {
	
	public Connection conn;
	
	public TaskRepositoryImpl() {
		// TODO Auto-generated constructor stub
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
			if(conn != null)
				System.out.println("connected to MySql Database");
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void save(Task task) {
		System.out.println("first save using JDBC");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
			if(conn != null)
				System.out.println("connected to MySql Database");
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void add(Task task) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO Task (Task_name, Start_date, End_date, created_by, created_on) VALUES (?, ?, ?, ?,?)";
		 
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, task.getTaskName());
			statement.setDate(2, (Date) task.getStartDate());
			statement.setDate(3, (Date) task.getEndDate());
			statement.setString(4, task.getCreatedBy());
			statement.setDate(5, (Date) task.getCreatedOn());
			
			int resultCode = statement.executeUpdate();
			if(resultCode > 0)
				System.out.println("task inserted successfully !!");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(Task task) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int taskId) {
		// TODO Auto-generated method stub
		
	}

}

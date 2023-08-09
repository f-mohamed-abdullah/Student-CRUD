package com.college.departments;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.Scanner;

import com.college.database.DatabaseConnection;
import com.college.history.DatabaseHistory;

public class ElectricalandElectronicsEngineering {
	
	Scanner in = new Scanner(System.in);
	
	
	
	Statement EEEStatement = DatabaseConnection.getConnection();
	
	DatabaseHistory historyEEE = new DatabaseHistory();
	
	String stdName;
	
	public void insertEEEStudentData() throws SQLException {
		
		System.out.println("Enter the Student Name:");
		String name=in.nextLine();
		this.stdName=name;
		System.out.println("Enter the email:");
		String email = in.nextLine();
		
		String dept="EEE";
		
		System.out.println("Enter the Student Phone Number:");
		String phoneNo = in.nextLine();
		
		String query = "INSERT INTO EEE VALUES('"+name+"','"+email+"','"+phoneNo+"','"+dept+"');";
		EEEStatement.executeUpdate(query);
		
		historyEEE.insertEEEhistory(name);
		
		System.out.println("*************Detials was inserted successfully!!!*************");
		System.out.println();
		
		}
	
	public void updateEEEStudentData() throws SQLException {
		
		System.out.println("1.update Name");
		System.out.println("2.Update email");
		System.out.println("3.Update Phone Number");
		System.out.println("Enter Your choice:");
		int choice = in.nextInt();
		switch (choice) {
		case 1: {
			String txt="name";
			System.out.println("Enter the old name:");
			in.nextLine();
			String oldname=in.nextLine();
			
			System.out.println("Enter the new name:");
			
			String newName = in.nextLine();
			
			String query = "UPDATE EEE SET name=" + "'" + newName + "'" + "WHERE name='" + oldname + "';";
			EEEStatement.executeUpdate(query);
			
			historyEEE.updateEEEhistory(txt, oldname);
			
			System.out.println("*************Name was updated successfully!!!*************");
			System.out.println();
		}
			break;
		
		case 2:{
			
			String txt="mail";
			System.out.println("Enter the old email:");
			in.nextLine();
			String oldmail=in.nextLine();
			
			System.out.println("Enter the new email:");
			
			String newmail = in.nextLine();
			
			String query = "UPDATE EEE SET email=" + "'" + newmail + "'" + "WHERE email='" + oldmail + "';";
			EEEStatement.executeUpdate(query);
			
			historyEEE.updateEEEhistory(txt, stdName);
			
			
			System.out.println("*************email was updated successfully!!!*************");
			System.out.println();
		}
		break;
		case 3:{
			
			String txt="phone";
			System.out.println("Enter the old phone no:");
			in.nextLine();
			String old_no=in.nextLine();
			
			System.out.println("Enter the new phone no:");
			
			String new_no = in.nextLine();
			
			String query = "UPDATE EEE SET phoneNo='" + new_no + "'" + "WHERE phoneNo='" + old_no + "';";
			EEEStatement.executeUpdate(query);
			
			historyEEE.updateEEEhistory(txt, stdName);
			
			System.out.println("*************Phone Number was updated successfully!!!*************");
			System.out.println();
		}
		break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + choice);
		}
		
		
		
	}
	
public void deleteEEEStudentData() throws SQLException {
		
		System.out.println("Enter the Student name to delete:");
		String name=in.nextLine();
		
		String query="DELETE FROM EEE WHERE name='"+name+"';";
		EEEStatement.executeUpdate(query);
		
		historyEEE.deleteEEEhistory(name);
		
		System.out.println("*************Data was Deleted successfully!!!*************");
		System.out.println();
		
	}

	public void readEEEStudentData() throws SQLException {
		
		String query ="SELECT * FROM EEE ORDER BY name;";
		
		ResultSet rs = EEEStatement.executeQuery(query);
		
		System.out.println("name"
                +"          "+"email"
                +"          "+"phoneNo"
                +"          "+"dept");
		
		while (rs.next()){
            System.out.println(rs.getString("name")
                    +"          "+rs.getString("email")
                    +"          "+rs.getString("phoneNo")
                    +"          "+rs.getString("dept"));
        }
		
	}
	
	

}
	
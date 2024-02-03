package com.banking.onlineBanking.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.mysql.jdbc.Connection;
//import com.mysql.jdbc.PreparedStatement;
//import com.mysql.jdbc.Statement;

@WebServlet("/register")
public class RegistrationController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	//create the query
	private static final String INSERT_QUERY = "INSERT INTO USER(FIRSTNAME, LASTNAME, EMAIL, PASSWORD, CONFIRMPASSWORD) VALUES(?,?,?,?,?)";
	//@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		//get PrintWriter
		PrintWriter pw = res.getWriter();
		//set content type
		res.setContentType("text/html");
		
		//read the form values
		String FirstName = req.getParameter("Firstname");
		String LastName = req.getParameter("Lastname");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String confirmPassword = req.getParameter("confirm_password");
		
		//Load the jdbc driver
		//try {
			//Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		//}catch (ClassNotFoundException e) {
			
			//e.printStackTrace();
		//}
		//create the connection
		//Connection conn= null;
		//Statement stmt = null;
		//PrepareStatement prepareStatement 
		try (
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank?createDatabaseIfNotExist=true&useUnicode=true", "root", "Chemeli1707@");
							
				PreparedStatement ps = conn.prepareStatement(INSERT_QUERY);){
			//set the values
			
			ps.setString(1, FirstName);
			ps.setString(2, LastName);
			ps.setString(3, email);
			ps.setString(4, password);
			ps.setString(5, confirmPassword);
			
			//execute the query
			int count= ps.executeUpdate();
			
			if(count ==0) {
				pw.println("Record not stored into Database");
		}
			else {
				pw.println("Record stored into Database");
			}
		}
		catch(SQLException se) {
			pw.println(se.getMessage());
			se.printStackTrace();
		}
		catch(Exception e) {
			pw.println(e.getMessage());
			e.printStackTrace();
			
		}
		
		//close the stream
		pw.close();

	}
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		
		doGet(req, res);
	}
}

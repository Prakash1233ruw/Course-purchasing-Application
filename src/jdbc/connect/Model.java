package jdbc.connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.protocol.Resultset;

public class Model {
private String  userName;
private String  gender;
private String city;
private String password;

private Connection connect=null;
private PreparedStatement stmt=null;

private int row;

private ResultSet rs;

public ResultSet getRs() {
	return rs;
}
public int getRow() {
	return row;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}


public void register() {
	try {
		System.out.println("control entered");
		connect=JDBCUtility.getDBConnection();
		String sql="insert into ninja(username,gender,city,password) values(?,?,?,?)";
		if(connect!=null) {
			stmt=connect.prepareStatement(sql);
			
			stmt.setString(1, userName);
			stmt.setString(2, gender);
			stmt.setString(3, city);
			stmt.setString(4, password);
		row=stmt.executeUpdate();
			System.out.println("checking row "+row);
		}
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
catch (Exception e) {
		
		e.printStackTrace();
	}
	finally {
	 try {
		JDBCUtility.closeResource(connect, stmt);
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	}
}

public void login() {
	try {
		System.out.println("enterd jdbc login connection");
	connect=JDBCUtility.getDBConnection();
	if(connect!=null) {
		stmt=connect.prepareStatement("select username,password from ninja where username=?");
		System.out.println("query  executed");
	}
	if(stmt!=null) {
		System.out.println("stmt in");
		stmt.setString(1, userName);
		rs = stmt.executeQuery();
		System.out.println("stmt out");
		
		 
		if(rs.next()) {
			System.out.println("rs in");
			userName=rs.getString(1);
			password=rs.getString(2);
			System.out.println("rs out");
		}else {
			userName=null;
			password=null;
		}
		
	}
	
		
	} catch (SQLException e) {
		
		e.printStackTrace();
		
	}catch (Exception e) {
		
		e.printStackTrace();
	}
	finally {
		try {
			JDBCUtility.closeResource(connect, stmt);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	
}

public void purchase() {
	
}
//public void fetchDetails() {
//	try {
//		connect=JDBCUtility.getDBConnection();
//		if(connect!=null) {
//			stmt=connect.prepareStatement("select*from ninja where username=?");
//		}
//		if(stmt!=null) {
//			stmt.setString(1, userName);
//			rs=stmt.executeQuery();
//			
//			
//		}
//		while(rs.next()) {
//			userName=rs.getString("username");
//			System.out.println(userName);
//			gender=rs.getString("gender");
//			city=rs.getString("city");
//		}
//	
//		
//	} catch (SQLException e) {
//		
//		e.printStackTrace();
//	}
//}
}

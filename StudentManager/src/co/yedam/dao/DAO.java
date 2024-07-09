package co.yedam.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// DB connection 기능

public class DAO {
	
	Connection connection = null;
	Statement statement;
	PreparedStatement psmt;
	ResultSet resultSet;
	
	public Connection getConnection() {
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		String user = "jsp";
		String password = "jsp";
		
		
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("오라클 드라이버 없음");
			e.printStackTrace();
		}
		
		return connection;
	}
}

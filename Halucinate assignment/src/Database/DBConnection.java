package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	public static Connection getConnection() throws SQLException,ClassNotFoundException
	{
		String dbname="jdbc:mysql://localhost:3306/Halucinatedb";
		String user="root";
		String pass="admin";
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection(dbname,user,pass);
		
		return con;
	}
}

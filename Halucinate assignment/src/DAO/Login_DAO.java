package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Database.DBConnection;
import Model.Login_Model;

public class Login_DAO {

	public boolean login(Login_Model lm) throws SQLException,ClassNotFoundException
	{
		Connection con=DBConnection.getConnection();
		PreparedStatement st=con.prepareStatement("select * from table1 where username=? and password=?");
		
		boolean status=false;
		try
		{
			st.setString(1, lm.getUsername());
			st.setString(2, lm.getPassword());
			
			ResultSet rs=st.executeQuery();
			status=rs.next();
			
			return status;
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
		
		return status;
		
	}
}

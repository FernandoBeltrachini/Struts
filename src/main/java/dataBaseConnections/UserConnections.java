package dataBaseConnections;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.User;

public class UserConnections {
	
	
	public boolean validUser(User user){
		try {
			if (ConnectionSingleton.getInstance() != null) {
				PreparedStatement p = ConnectionSingleton.getInstance().con.prepareStatement("SELECT COUNT(*) FROM USER where username=? AND password=?");
				p.setString(1, user.getUserName());
				p.setString(2, user.getPassword());
				ResultSet rs = p.executeQuery();
				rs.next();
				if (rs.getInt(1) > 0)
					return true;
				}
		}
		
		catch (SQLException e){
			return false;
		}
		
		return false;
	}

}

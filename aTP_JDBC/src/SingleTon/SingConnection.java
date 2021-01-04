package SingleTon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingConnection {
private static Connection connection;
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url ="jdbc:mysql://localhost/app_spring?serverTimezone=UTC";
			 connection = DriverManager.getConnection(url,"root","karmila@2");
			
			
		}catch(ClassNotFoundException | SQLException e) {
					e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		return connection;
	}
}

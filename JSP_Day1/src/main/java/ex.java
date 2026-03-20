import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {

			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root","1234");
			System.out.println("success");
			Statement stmt = conn.createStatement();

		} catch (SQLException e) {
			System.out.println("SQLException" + e);
		}
	}
}
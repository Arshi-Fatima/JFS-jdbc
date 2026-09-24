import java.sql.*;
public class Callable2 {
	public static void main(String args[]) {
		try {
			Connection con=DBConn.getConn();
			CallableStatement cs= con.prepareCall("{call GetEmployees()}");
			ResultSet rs=cs.executeQuery();
			
		}
	}
}

import java.sql.*;
public class Callable {
	public static void main(String args[]) {
		int count=0;
		try {
			Connection con=DBConn.getConn();
			CallableStatement cs=con.prepareCall("{call GetEmployees()}");
			ResultSet rs=cs.executeQuery();
			while(rs.next()) {
				System.out.println("emp_id: "+ rs.getString("id"));
				System.out.println("emp_name: "+ rs.getString("name"));
				System.out.println("dept "+ rs.getString("department"));
				System.out.println("sal: "+ rs.getInt("salary"));
				count++;
			}
			System.out.println("Total Employees: "+count);
			rs.close();
			cs.close();
			con.close();
		}catch (Exception e) {
			System.out.println("Database error:");
			e.printStackTrace();
		}
		
	}
}

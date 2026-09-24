import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

public class JDBCSelect {
	public static void main(String args[]) throws Exception{
		Connection con =DBConn.getConn();
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery("select * from emp1");
		System.out.println("ID\tName\t\tDepartment\tSalary");
		System.out.println("---------------------------------");
		while(rs.next()) {
			String id=rs.getString("id");
			String name=rs.getString("name");
			String dept=rs.getString("department");
			double salary=rs.getDouble("Salary");
			System.out.println(id+"\t"+name+"\t\t"+dept+"\t\t"+salary);
		}
		stmt.close();
		con.close();
		rs.close();
	}
}

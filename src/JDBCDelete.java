/*
import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.*;
public class JDBCDelete {
	Connection con =DBConn.getConn();
	Statement stmt=con.createStatement();
	Scanner sc=new Scanner(System.in);
	//get empid and new salary from users
	System.out.println("Enter empid to delete:");
	String empid=sc.nextLine();
	
	//Build and execute update query
	int rowsAffected=stmt.executeUpadated("DELETE from emp1 where id='""+newSalary+
			"WHERE id= '"+empid+"'");
	//Show result
	if(rowsAffected>0)
		System.out.println("Record deleted successfully.");
	else
		System.out.println("Employee ID not found. delete failed.");
	stmt.close();
	con.close();
	sc.close();
}
*/
import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCDelete {

    public static void main(String[] args) throws Exception {

        Connection con = DBConn.getConn();
        Statement stmt = con.createStatement();
        Scanner sc = new Scanner(System.in);

        // Get empid from user
        System.out.println("Enter empid to delete:");
        String empid = sc.nextLine();

        // Build and execute delete query
        String query = "DELETE FROM emp1 WHERE id='" + empid + "'";

        int rowsAffected = stmt.executeUpdate(query);

        // Show result
        if (rowsAffected > 0)
            System.out.println("Record deleted successfully.");
        else
            System.out.println("Employee ID not found. Delete failed.");

        // Close resources
        stmt.close();
        con.close();
        sc.close();
    }
}

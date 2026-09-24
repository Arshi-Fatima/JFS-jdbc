/*import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.*;
class JDBCUpdate {
	Scanner sc=new Scanner(System.in);
	//get empid and new salary from users
	System.out.println("Enter empid to udate:");
	String empid=sc.nextLine();
	System.out.println("Enter new salary:");
	double newSalary=sc.nextDouble();
	//Build and execute update query
	int rowsAffected=stmt.executeUpadated("UPDATE emp1 SET salary ="+newSalary+
			"WHERE id='"+empid+"'");
	//Show result
	if(rowsAffected>0)
		System.out.println("Record updated successfully.");
	else
		System.out.println("Employee ID not found. Update failed.");
	stmt.close();
	con.close();
	sc.close();
}
*/
import java.sql.*;
import java.util.Scanner;

class JDBCUpdate {

    public static void main(String[] args) throws Exception {

        // Get database connection
        Connection con = DBConn.getConn();

        // Create statement
        Statement stmt = con.createStatement();

        // Create Scanner
        Scanner sc = new Scanner(System.in);

        // Get empid and new salary from user
        System.out.println("Enter empid to update:");
        String empid = sc.nextLine();

        System.out.println("Enter new salary:");
        double newSalary = sc.nextDouble();

        // Build and execute update query
        String query = "UPDATE emp1 SET salary = " + newSalary +
                       " WHERE id = '" + empid + "'";

        int rowsAffected = stmt.executeUpdate(query);

        // Show result
        if (rowsAffected > 0)
            System.out.println("Record updated successfully.");
        else
            System.out.println("Employee ID not found. Update failed.");

        // Close resources
        stmt.close();
        con.close();
        sc.close();
    }
}
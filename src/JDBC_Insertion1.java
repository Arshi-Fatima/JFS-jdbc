import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

class Employee {
    String id;
    String name;
    String dept;
    double salary;

    public Employee(String id, String name, String dept, double salary) 
    {   this.id = id;
        this.name = name;
        this.dept = dept;
        this.salary = salary;
    }
}

public class JDBC_Insertion1{
    public static void main(String[] args) throws Exception {
        Connection con = DBConn.getConn();
        String sql = "INSERT INTO emp1 (id, name, department, salary) VALUES (?, ?, ?, ?)";
        PreparedStatement pstmt = con.prepareStatement(sql);

        // Employee list
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("16", "rama1", "HR", 50000));
        employees.add(new Employee("17", "Krishna", "IT", 60000));
        employees.add(new Employee("18", "Govinda", "Finance", 70000));

        for (Employee emp : employees) {
            // Check if ID already exists
            PreparedStatement checkStmt = con.prepareStatement("SELECT COUNT(*) FROM emp1 WHERE id = ?");
            checkStmt.setString(1, emp.id);
            ResultSet rs = checkStmt.executeQuery();
            rs.next();
            int count = rs.getInt(1);
            rs.close();
            checkStmt.close();

            if (count == 0) { // Only add if not exists
                pstmt.setString(1, emp.id);
                pstmt.setString(2, emp.name);
                pstmt.setString(3, emp.dept);

                pstmt.setDouble(4, emp.salary);
                pstmt.addBatch();
            } else {
                System.out.println(" Employee " + emp.name + " already exists. Skipping insert.");
            }
        }

        // Execute batch
        int[] results = pstmt.executeBatch();
        for (int i = 0; i < results.length; i++) {
            if (results[i] >= 0)
                System.out.println(" Employee " + employees.get(i).name + " inserted successfully.");
        }

        pstmt.close();
        con.close();
    }
}






String delsql = "delete from employee WHERE empid  = ?";
PreparedStatement psdel = con.prepareStatement(delsql);
psdel.setInt(1, 27);
if(psdel.executeUpdate()>0) {
 System.out.println("Record deleted successfully.");
}
else {
 System.out.println("Record deletion failed.");
}
String updatesql = "update  employee  set sal = ? WHERE empid  = ?";
PreparedStatement psup = con.prepareStatement(updatesql);
psup.setDouble(1, 75200.0);
psup.setInt(2, 126);

if(psup.executeUpdate()>0) {
 System.out.println("Record updated successfully.");
}
else {
 System.out.println("Record updation failed.");
}
package finalproject;
import java.sql.*;   // Needed for JDBC classes

/**
  This program creates a Student
  table in the CoffeeDB database.
*/

public class CreateStudentTable
{
   public static void main(String[] args)
   {
	  final String DB_URL = "jdbc:derby:CoffeeDB";

      try
      {
         // Connect to database
         Connection conn = DriverManager.getConnection(DB_URL);

         // Create statement
         Statement stmt = conn.createStatement();

         // Create Student table
         String sql = "CREATE TABLE Student" +
            "( StudentID INT NOT NULL PRIMARY KEY, " +
            "  Name CHAR(25), " +
            "  Major CHAR(25), " +
            "  GPA DOUBLE, " +
            "  StudyHoursPerWeek INT, " +
            "  CreditHoursCompleted INT )";

         stmt.execute(sql);

         // Insert student data
         sql = "INSERT INTO Student VALUES " +
               "(1001234, 'Alicia Gomez', 'Computer Science', 3.7, 18, 45)";
         stmt.executeUpdate(sql);

         sql = "INSERT INTO Student VALUES " +
               "(1002345, 'Marcus Johnson', 'Sociology', 3.2, 12, 40)";
         stmt.executeUpdate(sql);

         sql = "INSERT INTO Student VALUES " +
               "(1003456, 'Daniel Kim', 'Biology', 3.5, 16, 50)";
         stmt.executeUpdate(sql);

         sql = "INSERT INTO Student VALUES " +
               "(1004567, 'Brianna Carter', 'Psychology', 3.8, 20, 55)";
         stmt.executeUpdate(sql);

         sql = "INSERT INTO Student VALUES " +
               "(1005678, 'Jamal Thompson', 'Finance', 3.1, 10, 38)";
         stmt.executeUpdate(sql);

         sql = "INSERT INTO Student VALUES " +
               "(1006789, 'Sophia Martinez', 'Business', 3.6, 15, 48)";
         stmt.executeUpdate(sql);

         // Close connection
         conn.close();
      }
      catch (Exception ex)
      {
         System.out.println("ERROR: " + ex.getMessage());
      }
   }
}
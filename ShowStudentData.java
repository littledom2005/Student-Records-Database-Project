package finalproject;

import java.sql.*;

/**
  This program displays all of the columns in the
  Student table of the CoffeeDB database.
*/

public class ShowStudentData
{
   public static void main(String[] args)
   {
      final String DB_URL = "jdbc:derby:CoffeeDB";
      
      try
      {
         Connection conn = DriverManager.getConnection(DB_URL);
         Statement stmt = conn.createStatement();
         
         String sqlStatement = "SELECT * FROM Student";
         
         ResultSet result = stmt.executeQuery(sqlStatement);
         
         // Display all student data
         while (result.next())
         {
            System.out.printf("%10d %-20s %-20s %4.2f %5d %5d\n",
               result.getInt("StudentID"),
               result.getString("Name"),
               result.getString("Major"),
               result.getDouble("GPA"),
               result.getInt("StudyHoursPerWeek"),
               result.getInt("CreditHoursCompleted"));
         }
         
         conn.close();
      }
      catch(Exception ex)
      {
         System.out.println("ERROR: " + ex.getMessage());
      }
   }
}
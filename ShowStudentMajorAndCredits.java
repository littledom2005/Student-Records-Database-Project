package finalproject;

import java.sql.*;

/**
  This program displays student names, majors,
  and completed credit hours.
*/

public class ShowStudentMajorAndCredits
{
   public static void main(String[] args)
   {
      final String DB_URL = "jdbc:derby:CoffeeDB";
      
      try
      {
         Connection conn = DriverManager.getConnection(DB_URL);
         Statement stmt = conn.createStatement();
         
         String sqlStatement = 
            "SELECT Name, Major, CreditHoursCompleted FROM Student";
         
         ResultSet result = stmt.executeQuery(sqlStatement);
         
         // Display results
         while (result.next())
         {
            System.out.printf("%-20s %-20s %5d\n",
               result.getString("Name"),
               result.getString("Major"),
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
package finalproject;

import java.sql.*;

public class StudentCount
{
   public static void main(String[] args)
   {
      final String DB_URL = "jdbc:derby:CoffeeDB";

      try
      {
         Connection conn = DriverManager.getConnection(DB_URL);
         Statement stmt = conn.createStatement();

         String sql = "SELECT COUNT(*) AS TotalStudents FROM Student";

         ResultSet result = stmt.executeQuery(sql);

         if (result.next())
         {
            System.out.println("Total number of students: " + result.getInt("TotalStudents"));
         }

         conn.close();
      }
      catch(Exception ex)
      {
         System.out.println("ERROR: " + ex.getMessage());
      }
   }
}

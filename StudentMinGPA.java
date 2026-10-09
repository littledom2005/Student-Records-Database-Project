package finalproject;

import java.sql.*;

public class StudentMinGPA
{
   public static void main(String[] args)
   {
      final String DB_URL = "jdbc:derby:CoffeeDB";

      try
      {
         Connection conn = DriverManager.getConnection(DB_URL);
         Statement stmt = conn.createStatement();

         String sql = "SELECT MIN(GPA) AS MinGPA FROM Student";

         ResultSet result = stmt.executeQuery(sql);

         if (result.next())
         {
            System.out.println("Minimum GPA: " + result.getDouble("MinGPA"));
         }

         conn.close();
      }
      catch(Exception ex)
      {
         System.out.println("ERROR: " + ex.getMessage());
      }
   }
}
package finalproject;

import java.sql.*;

public class StudentMaxGPA
{
   public static void main(String[] args)
   {
      final String DB_URL = "jdbc:derby:CoffeeDB";

      try
      {
         Connection conn = DriverManager.getConnection(DB_URL);
         Statement stmt = conn.createStatement();

         String sql = "SELECT MAX(GPA) AS MaxGPA FROM Student";

         ResultSet result = stmt.executeQuery(sql);

         if (result.next())
         {
            System.out.println("Maximum GPA: " + result.getDouble("MaxGPA"));
         }

         conn.close();
      }
      catch(Exception ex)
      {
         System.out.println("ERROR: " + ex.getMessage());
      }
   }
}
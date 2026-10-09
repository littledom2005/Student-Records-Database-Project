package finalproject;

import java.sql.*;

public class StudentAvgGPA
{
   public static void main(String[] args)
   {
      final String DB_URL = "jdbc:derby:CoffeeDB";

      try
      {
         Connection conn = DriverManager.getConnection(DB_URL);
         Statement stmt = conn.createStatement();

         String sql = "SELECT AVG(GPA) AS AvgGPA FROM Student";

         ResultSet result = stmt.executeQuery(sql);

         if (result.next())
         {
            System.out.println("Average GPA: " + result.getDouble("AvgGPA"));
         }

         conn.close();
      }
      catch(Exception ex)
      {
         System.out.println("ERROR: " + ex.getMessage());
      }
   }
}

package finalproject;

import java.sql.*;

public class DropStudentTable
{
   public static void main(String[] args)
   {
      final String DB_URL = "jdbc:derby:CoffeeDB";

      try
      {
         Connection conn = DriverManager.getConnection(DB_URL);
         Statement stmt = conn.createStatement();

         String sql = "DROP TABLE Student";

         stmt.executeUpdate(sql);

         System.out.println("Student table dropped successfully.");

         conn.close();
      }
      catch(Exception ex)
      {
         System.out.println("ERROR: " + ex.getMessage());
      }
   }
}

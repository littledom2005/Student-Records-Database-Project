package finalproject;

import java.sql.*;

public class StudentSumCredits
{
   public static void main(String[] args)
   {
      final String DB_URL = "jdbc:derby:CoffeeDB";

      try
      {
         Connection conn = DriverManager.getConnection(DB_URL);
         Statement stmt = conn.createStatement();

         String sql = "SELECT SUM(CreditHoursCompleted) AS TotalCredits FROM Student";

         ResultSet result = stmt.executeQuery(sql);

         if (result.next())
         {
            System.out.println("Total credits completed by all students: " +
                               result.getInt("TotalCredits"));
         }

         conn.close();
      }
      catch(Exception ex)
      {
         System.out.println("ERROR: " + ex.getMessage());
      }
   }
}

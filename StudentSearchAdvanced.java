package finalproject;

import java.sql.*;

public class StudentSearchAdvanced
{
   public static void main(String[] args)
   {
      final String DB_URL = "jdbc:derby:CoffeeDB";

      try
      {
         Connection conn = DriverManager.getConnection(DB_URL);
         Statement stmt = conn.createStatement();

         // AND + OR in one query
         String sql = "SELECT * FROM Student " +
                      "WHERE (GPA > 3.5 AND CreditHoursCompleted > 40) " +
                      "OR Major = 'Computer Science'";

         ResultSet result = stmt.executeQuery(sql);

         int count = 0;

         while (result.next())
         {
            System.out.printf("%10d %-20s %-20s %4.2f %5d %5d\n",
               result.getInt("StudentID"),
               result.getString("Name"),
               result.getString("Major"),
               result.getDouble("GPA"),
               result.getInt("StudyHoursPerWeek"),
               result.getInt("CreditHoursCompleted"));

            count++;
         }

         System.out.println(count + " student(s) matched the criteria.");

         conn.close();
      }
      catch(Exception ex)
      {
         System.out.println("ERROR: " + ex.getMessage());
      }
   }
}
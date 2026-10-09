package finalproject;

import java.util.Scanner;
import java.sql.*;

/**
  This program lets the user search for students
  with a minimum number of completed credits.
*/

public class StudentMinCredits
{
   public static void main(String[] args)
   {
      int minCredits;
      int studentCount = 0;

      final String DB_URL = "jdbc:derby:CoffeeDB";

      Scanner keyboard = new Scanner(System.in);

      // Get minimum credits from user
      System.out.print("Enter the minimum credit hours completed: ");
      minCredits = keyboard.nextInt();

      try
      {
         Connection conn = DriverManager.getConnection(DB_URL);
         Statement stmt = conn.createStatement();

         String sqlStatement =
            "SELECT * FROM Student WHERE CreditHoursCompleted >= " +
            minCredits;

         ResultSet result = stmt.executeQuery(sqlStatement);

         // Display results
         while (result.next())
         {
            System.out.printf("%10d %-20s %-20s %4.2f %5d %5d\n",
               result.getInt("StudentID"),
               result.getString("Name"),
               result.getString("Major"),
               result.getDouble("GPA"),
               result.getInt("StudyHoursPerWeek"),
               result.getInt("CreditHoursCompleted"));

            studentCount++;
         }

         System.out.println(studentCount + " student(s) found.");

         conn.close();
      }
      catch(Exception ex)
      {
         System.out.println("ERROR: " + ex.getMessage());
      }
   }
}
package finalproject;

import java.util.Scanner;
import java.sql.*;

/**
  This program lets the user delete a student
  from the CoffeeDB database's Student table.
*/

public class StudentDeleter
{
   public static void main(String[] args)
   {
      int studentID;
      String sure;

      final String DB_URL = "jdbc:derby:CoffeeDB";

      Scanner keyboard = new Scanner(System.in);

      try
      {
         Connection conn = DriverManager.getConnection(DB_URL);
         Statement stmt = conn.createStatement();

         // Get Student ID
         System.out.print("Enter the Student ID: ");
         studentID = keyboard.nextInt();
         keyboard.nextLine(); // clear buffer

         // Display student info
         if (findAndDisplayStudent(stmt, studentID))
         {
            System.out.print("Are you sure you want to delete this student? (y/n): ");
            sure = keyboard.nextLine();

            if (Character.toUpperCase(sure.charAt(0)) == 'Y')
            {
               deleteStudent(stmt, studentID);
            }
            else
            {
               System.out.println("The student was not deleted.");
            }
         }
         else
         {
            System.out.println("That student was not found.");
         }

         conn.close();
      }
      catch(Exception ex)
      {
         System.out.println("ERROR: " + ex.getMessage());
      }
   }

   /**
     Finds and displays a student
   */
   public static boolean findAndDisplayStudent(Statement stmt,
                                               int studentID)
                                               throws SQLException
   {
      boolean found;

      String sqlStatement =
         "SELECT * FROM Student WHERE StudentID = " + studentID;

      ResultSet result = stmt.executeQuery(sqlStatement);

      if (result.next())
      {
         System.out.println("Name: " +
            result.getString("Name"));
         System.out.println("Major: " +
            result.getString("Major"));
         System.out.println("GPA: " +
            result.getDouble("GPA"));
         System.out.println("Study Hours/Week: " +
            result.getInt("StudyHoursPerWeek"));
         System.out.println("Credits Completed: " +
            result.getInt("CreditHoursCompleted"));

         found = true;
      }
      else
      {
         found = false;
      }

      return found;
   }

   /**
     Deletes a student
   */
   public static void deleteStudent(Statement stmt, int studentID)
                                   throws SQLException
   {
      String sqlStatement = "DELETE FROM Student " +
                            "WHERE StudentID = " + studentID;

      int rows = stmt.executeUpdate(sqlStatement);

      System.out.println(rows + " row(s) deleted.");
   }
}
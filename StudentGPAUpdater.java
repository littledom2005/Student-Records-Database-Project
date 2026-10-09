package finalproject;

import java.util.Scanner;
import java.sql.*;

/**
  This program lets the user change the GPA of a
  student in the CoffeeDB database's Student table.
*/

public class StudentGPAUpdater
{
   public static void main(String[] args)
   {
      int studentID;
      double gpa;

      final String DB_URL = "jdbc:derby:CoffeeDB";

      Scanner keyboard = new Scanner(System.in);

      try
      {
         Connection conn = DriverManager.getConnection(DB_URL);
         Statement stmt = conn.createStatement();

         // Get the student ID
         System.out.print("Enter the Student ID: ");
         studentID = keyboard.nextInt();

         // Display current student data
         if (findAndDisplayStudent(stmt, studentID))
         {
            System.out.print("Enter the new GPA: ");
            gpa = keyboard.nextDouble();

            updateGPA(stmt, studentID, gpa);
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
     Finds and displays a student's data
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
     Updates a student's GPA
   */
   public static void updateGPA(Statement stmt, int studentID,
                               double gpa) throws SQLException
   {
      String sqlStatement = "UPDATE Student " +
            "SET GPA = " + gpa +
            " WHERE StudentID = " + studentID;

      int rows = stmt.executeUpdate(sqlStatement);

      System.out.println(rows + " row(s) updated.");
   }
}
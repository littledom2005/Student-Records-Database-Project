package finalproject;

import java.util.Scanner;
import java.sql.*;

public class StudentInserter {
   public static void main(String[] args)
   {
      int studentID;
      String name;
      String major;
      double gpa;
      int studyHours;
      int credits;

      final String DB_URL = "jdbc:derby:CoffeeDB";

      Scanner keyboard = new Scanner(System.in);

      try
      {
         Connection conn = DriverManager.getConnection(DB_URL);

         // Get student data from user
         System.out.print("Enter Student ID: ");
         studentID = keyboard.nextInt();
         keyboard.nextLine(); // clear buffer

         System.out.print("Enter Name: ");
         name = keyboard.nextLine();

         System.out.print("Enter Major: ");
         major = keyboard.nextLine();

         System.out.print("Enter GPA: ");
         gpa = keyboard.nextDouble();

         System.out.print("Enter Study Hours Per Week: ");
         studyHours = keyboard.nextInt();

         System.out.print("Enter Credit Hours Completed: ");
         credits = keyboard.nextInt();

         Statement stmt = conn.createStatement();

         // Build SQL INSERT statement
         String sqlStatement = "INSERT INTO Student " +
               "(StudentID, Name, Major, GPA, StudyHoursPerWeek, CreditHoursCompleted) " +
               "VALUES (" +
               studentID + ", '" +
               name + "', '" +
               major + "', " +
               gpa + ", " +
               studyHours + ", " +
               credits + ")";

         int rows = stmt.executeUpdate(sqlStatement);

         System.out.println(rows + " row(s) added to the table.");

         conn.close();
      }
      catch(Exception ex)
      {
         System.out.println("ERROR: " + ex.getMessage());
      }
   }
}
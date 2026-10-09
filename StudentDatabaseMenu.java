package finalproject;

import java.util.Scanner;

public class StudentDatabaseMenu
{
   public static void main(String[] args)
   {
      Scanner keyboard = new Scanner(System.in);
      int choice;

      do
      {
         System.out.println("\n=== Student Database Menu ===");
         System.out.println("1. Create Student Table");
         System.out.println("2. Insert Student");
         System.out.println("3. Show All Students");
         System.out.println("4. Update Student GPA");
         System.out.println("5. Delete Student");
         System.out.println("6. Search Students (AND/OR)");
         System.out.println("7. Minimum GPA");
         System.out.println("8. Maximum GPA");
         System.out.println("9. Average GPA");
         System.out.println("10. Count Students");
         System.out.println("11. Sum of Credits");
         System.out.println("12. Drop Student Table");
         System.out.println("0. Exit");
         System.out.print("Enter your choice: ");

         choice = keyboard.nextInt();
         keyboard.nextLine(); // clear buffer

         switch(choice)
         {
            case 1:
               CreateStudentTable.main(null);
               break;
            case 2:
               StudentInserter.main(null);
               break;
            case 3:
               ShowStudentData.main(null);
               break;
            case 4:
               StudentGPAUpdater.main(null);
               break;
            case 5:
               StudentDeleter.main(null);
               break;
            case 6:
               StudentSearchAdvanced.main(null);
               break;
            case 7:
               StudentMinGPA.main(null);
               break;
            case 8:
               StudentMaxGPA.main(null);
               break;
            case 9:
               StudentAvgGPA.main(null);
               break;
            case 10:
               StudentCount.main(null);
               break;
            case 11:
               StudentSumCredits.main(null);
               break;
            case 12:
               DropStudentTable.main(null);
               break;
            case 0:
               System.out.println("Exiting program.");
               break;
            default:
               System.out.println("Invalid choice.");
         }

      } while(choice != 0);

      keyboard.close();
   }
}

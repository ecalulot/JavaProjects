import java.util.Scanner;
import java.text.DecimalFormat;


/**
   GradeBookDemo2 program
   This program tests the GradeBook class by
   with user keyboard input.
*/

public class GradeBookDemo2
{
	
   public static void main(String[] args) 
   {
		// Create a DecimalFormat object.
  		 DecimalFormat formatter = new DecimalFormat("#0%");

      // Create a GradeBook object.
      GradeBook gb = new GradeBook();

      // Get the data from the user.
      getData(gb);
      
      // Display the student data.
      System.out.println("STUDENT DATA");
      for (int i = 1; i <= 5; i++)
      {
			System.out.printf("Name : " + gb.getName(i));
			System.out.print("\tAverage score: ");
			System.out.printf("%.2f", gb.getAverage(i));
			System.out.print("\tGrade: " + gb.getLetterGrade(i));
			System.out.println();	
      }
   }

   /**
      The getData method gets student data from the user
      and populates a GradeBook object.
      @param gb The GradeBook object.
   */
   
   public static void getData(GradeBook gb) 
   {
      String name;                        // To hold a name
      double[] scores = new double[4];    // An array of scores

      // Create a Scanner object for keyboard input.
      Scanner keyboard = new Scanner(System.in);
      
      // Get info for each student.
      for (int student = 1; student <= 5; student++)
      {
         // Get the name.
         System.out.print("Enter student " + student +
                            "'s name: ");
         name = keyboard.nextLine();
         gb.setName(student, name);
         
         // Read the 4 test scores.
         System.out.println("Now enter student " + student +
                            "'s four test scores.");
                                                                
         for (int i = 0; i < 4; i++)
         {
            System.out.print("Test score #" + (i + 1) + ": ");
             // Verify user input for scores. Value >0 and <100. 
            while (scores[i] < 0 && scores[i] > 100)
            {
               System.out.print("Invalid entry. Scores must be >0 or <100");
               scores[i] = keyboard.nextDouble();
               //gb.setScores(student, scores);
            }

            scores[i] = keyboard.nextDouble();
            gb.setScores(student, scores);
            
         }
			
			// Consume the remaining newline.
			keyboard.nextLine();
      }
      
      System.out.println();
   }
}

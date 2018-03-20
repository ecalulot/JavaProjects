/** 
   Efren Calulot
   Professor James Deherrera
   CSC 160, Section 1N1
   6 March 2017
   Project #2
   
   The program will ask the user to input any number of years. 
   After which it shall inquire the user for the amount of rain 
   fall per year per month.  Upon completion the program will
   calculate the average rain fall for the time given.
*/

import java.util.Scanner; // Required for Scanner class. 
import java.io.*;         // Required for I/O class.  

public class AverageRainfall
{
   public static void main(String [] args) throws IOException
   {
      final int NUM_MONTHS = 12;  // Declare constant value and initialize to 12
                
      int years;  // Declare years variable to hold initial number of year(s)
            
      double monthRain,      // Declare variable to hold rain accumulation per month
             totRain = 0.0,  // Declare and initalize accumulator
             avRain;         // Declare variable to hold average rain calculation
                   
      // Create class type variable 'keyboard' to hold 
      // user-inputted year and rainfall values
      Scanner keyboard = new Scanner(System.in);
            
      // Get year(s) input from user
      System.out.print("Enter the number of year(s): ");
      years = keyboard.nextInt();
            
      // Validate user input for years value
      while (years < 1)
      {
         System.out.print("Invalid entry.  Entry must be one (1) or greater: ");
         years = keyboard.nextInt();
      }
            
      // Begin nested 'for' loop (loop for each year and then each month)
            
      // 'for' loop to iterate for each year
      for (int y = 1; y <= years; y++)
      {   
         System.out.println("------------------------------");
         // System.out.println("Enter rainfall amount for each month:");
         // System.out.println("-------------------------------------");
              
         // 'for' loop to iterate for each month
         for (int m = 1; m <= NUM_MONTHS; m++) 
         {
            // switch statemtents for aesthetic appeal (p.154)
            switch(m)
            {
				case 1:
					System.out.print("Year " + y + " January: ");
					break;
				case 2:
					System.out.print("Year " + y + " February: ");
					break;
				case 3:
					System.out.print("Year " + y + " March: ");
					break;
				case 4: 
					System.out.print("Year " + y + " April: ");
					break;
				case 5:
					System.out.print("Year " + y + " May: ");
					break;
				case 6:
					System.out.print("Year " + y + " June: ");
					break;
				case 7:
					System.out.print("Year " + y + " July: ");
					break;
				case 8:
					System.out.print("Year " + y + " August: ");
					break;
				case 9:
					System.out.print("Year " + y + " September: ");
					break;
				case 10:
					System.out.print("Year " + y + " October: ");
					break;
				case 11:
					System.out.print("Year " + y + " November: ");
					break;
				case 12:
					System.out.print("Year " + y + " December: ");
            }
            // Get rainfall data from user for each month
            monthRain = keyboard.nextDouble();
                  
            // Verify user input of rainfall
            while(monthRain < 0)
            {
               System.out.print("Invalid input; rainfall must be 0 or greater: ");
               monthRain = keyboard.nextDouble();
            }
                  
            // Tally or sum rainfall amounts over given months and years
            totRain += monthRain;
         }
      }          
      
      // Calculate average rainfall
      avRain = totRain / (years * NUM_MONTHS); 
            
      // Display statistics for readability (p.164)
      System.out.println("\nTotal number of years/months: " 
                        + years + "/" + (years * NUM_MONTHS));
      System.out.printf("Total rainfall accumulated: %,.2f inches. \n", totRain);
      System.out.printf("Average monthly rainfall: %,.2f inches.", avRain);
   }
}

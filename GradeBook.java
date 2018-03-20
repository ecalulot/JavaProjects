/**
   Efren Calulot
   Professor James Deherra
   CSC 160, Section 1N1
   10 April 2017
   Project #3
   
   This program is the creatation of the GradeBook class. 
   The GradeBook class will contain nine methods. Some of which will find the average
   test score, find the lowest test score, and assign a letter grade. 
    
   These methods will then be called by the GradeBookDemo2 program when executed.  
   The GradeBookDemo2 program has already been supplied.    
*/

public class GradeBook
{
   private final int NUM_STUDENTS = 5;                 // constant for number of students
   private final int NUM_TESTS = 4;                    // number of tests
   private String[] names = new String[NUM_STUDENTS];  // an array called String to hold student names
   private char[] grades = new char[NUM_STUDENTS];     // an array called char to hold test grades
   
   // creating arrays to hold student test scores
   private double[] scores1 = new double[NUM_TESTS];
   private double[] scores2 = new double[NUM_TESTS];
   private double[] scores3 = new double[NUM_TESTS];
   private double[] scores4 = new double[NUM_TESTS];
   private double[] scores5 = new double[NUM_TESTS];
   
   // Begin the creation of the numerous methods to help the GradeBook class. 
   
   /**
      METHOD #1 
      The setName method assigns a student's name.
      @param studentNum The student's number.
      @param name The student's name. 
   */
   
   public void setName(int studentNum, String name)
   {
      names[studentNum - 1] = name;
   }
   
   /** 
      METHOD #2
      The setScores method copies the array of test scores to a student's array of scores.
      @param studentNum The student's number.
      @param scores An array of test scores.
   */

   public void setScores(int studentNum, double[] scores)
   {
      if (studentNum == 1)
         copyArray(scores1, scores);
         
      else if (studentNum == 2)
         copyArray(scores2, scores);
         
      else if (studentNum == 3)
         copyArray(scores3, scores);
      
      else if (studentNum == 4)
         copyArray(scores4, scores);
         
      else if (studentNum == 5)
         copyArray(scores5, scores);
         
      assignGrade(studentNum);
   }
   
   /** 
      METHOD #3
      The getName method returns a student's name.
      @param studentNum The specified student's number.
      @return The student's name.
   */
   
   public String getName(int studentNum)
   {
      return names[studentNum - 1];
   }
   
   /** 
      METHOD #4
      The getAverage method returns a student's average test score.
      @param studentNumber The specified student's number
      @return The student's average test score
   */
      
   public double getAverage(int studentNum)
   {
      double average;
      
      if (studentNum == 1)
         average = calcAverage(scores1);
         
      else if (studentNum == 2)
         average = calcAverage(scores2);
         
      else if (studentNum == 3)
         average = calcAverage(scores3);
      
      else if (studentNum == 4)
         average = calcAverage(scores4);
         
      else if (studentNum == 5)
         average = calcAverage(scores5);
         
      else 
         average = 0.0;
         
      return average;
   }
      
   /**
      METHOD #5
      The getLetterGrade method returns a student's letter grade
      @param studentNum The specified student's number.
      @return The student's letter grade.
   */
   
   public char getLetterGrade(int studentNum)
   {
      return grades[studentNum - 1];
   }
   
   /**
      METHOD #6
      The copyArray is a private method that copies the contents of one array to another.
      @param to The array to copy to (destination)
      @param from The array to copy from (source)
   */
   
   private void copyArray(double[] to, double[] from)
   {
      for (int i = 0; i < to.length; i++)
         to[i] = from[i];
   }
   
   /**
      METHOD #7
      The calcAverage method is a private method that calculates the average
      of the values in an array of test scores. 
      @param scores The array with the test scores.
   */
   
   private double calcAverage(double[] scores)
   {
      double total = 0.0, average, lowest;
      
      // Finding the lowest score.
      lowest = scores[0];  //set initial lowest score at index 0 (first element) of the array
      for (int i = 1; i < scores.length; i++)
         
         if (scores[i] < lowest)
            lowest = scores[i];
            
      // Calculate the sum total of scores. (p.437 line 74)
      for (int i = 0; i < scores.length; i++)
         total += scores[i];
         
      // Drop lowest score. (p.437 line 81)
      total -= lowest;
      
      // Calculate average score (minus lowest score)
      average = total / (scores.length - 1);
      
      return average;
   }
   
   /**
      METHOD #8
      The assignGrade method is a private method that determines 
      and assigns a letter grade to a specific student.
      @param studentNum The specified student's number. 
   */
   
   private void assignGrade(int studentNum)
   {
      double average = getAverage(studentNum);
      grades[studentNum - 1] = determineGrade(average);
   }
   
   /** 
      METHOD #9
      The determineGrade method is a private method that 
      determines the letter grade from the average score.
      @param average The test average.
      @return grade The letter grade. 
   */
   
   private char determineGrade(double average)
   {
      char grade;
      
      if (average >= 90 && average <= 100)
         grade = 'A';
         
      else if (average >= 80 && average < 90)
         grade = 'B';
         
      else if (average >=70 && average < 80)
         grade = 'C';
         
      else if (average >=60 && average < 70)
         grade = 'D';
         
      else if (average >=0 && average < 60)
         grade = 'F';
         
      else 
         grade = '?'; 
     
      return grade;
   }
}
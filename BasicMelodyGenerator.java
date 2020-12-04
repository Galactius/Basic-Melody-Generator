//Author: Daniel Perez
//Date: 11/29/20
//Objective: Generate a basic melody using random notes within a selected scale, with user-defined length. 
import java.util.Scanner; 
import java.util.Random;  

public class BasicMelodyGenerator
{
   public static void main(String[] args) 
   {        
      System.out.println("---------------------Basic Melody Generator---------------------"); 
         
      Scanner in = new Scanner(System.in);
      System.out.print("Enter the number of random notes in your melody to generate: ");
      String preNum = in.nextLine();
      int numNotes = Integer.parseInt(preNum);

      //Note: Because of certain errors involving the using scanner nextLine after nextInt, the
      //number of notes to be printed is entered as a string, then parsed into an int and
      //used in the for loop further below.

      System.out.print("Enter Scale to confine melody notes: ");
      String input = in.nextLine();

      String[] notes = scaleNotes(input).split(",");
         
      System.out.println("Generating random notes... ");



      for(int i = 0; i < numNotes; i++)
      {
         System.out.print(randNote(notes) + " ");
      }
   } 
   
   public static String randNote(String[] notes) 
   {
      Random gen = new Random(); 
      int randIndex = gen.nextInt(notes.length);
      
      return notes[randIndex]; 
   }

   public static String scaleNotes(String scale)
   {
      String fixedScale = scale.toLowerCase();
      String resp;
      switch(fixedScale) 
      {
         case "c": 
         resp =  "C,C#,D,D#,E,F,F#,G,G#,A,A#";
         break;
         
         case "c major": 
         resp = "C,D,E,F,G,A";
         break;
         
         case "c minor": 
         resp = "C,D,D#,F,G,G#,A#,C";
         break;
         
         default:
         resp = "Scale not available";
         break;
      }

      return resp;
   }
}
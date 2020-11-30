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
      int numNotes = in.nextInt();
      
      System.out.println("Enter Scale to confine melody notes: "); 
      String input = in.nextLine();     
         
      System.out.println("Generating random notes... ");
      
      for(int i = 0; i < numNotes; i++) 
      { 
         //System.out.print(randNote(scaleNotes(input)) + " ");
      }
      
      in.close(); 
   } 
   
   public static String randNote(String[] notes) 
   {
      Random gen = new Random(); 
      int randIndex = gen.nextInt(notes.length);
      
      return notes[randIndex]; 
   }

   //Current issue: 11/29/20 -> scaleNotes is not functional.
   //Desc: scaleNotes is meant to return a String[] with the notes in the user-entered scale,
   //however, the switch case statement may be fundamentally incompatible for this specific task.
   //alternative approaches involve nested-if-else statements, a HashMap, or a List/ArrayList.

   /*public static String[] scaleNotes(String scale) 
   {  
      String fixedScale = scale.toLowerCase();   
      switch(fixedScale) 
      {
         case "c": 
         return String[] cNotes = {"C","C#","D","D#","E","F","F#","G","G#","A","A#"};
         break; 
         
         case "c major": 
         return String[] cMajNotes = {"C","D","E","F","G","A"};
         break;  w
         
         case "c minor": 
         return String[] cMinNotes = {"C","D","D#","F","G","G#","A#","C"}; 
         break; 
         
         default:
         return String[] naS = {"Scale not available"}; //n.a.S. means not a scale
         break; 
      }*/
      
   //}
}
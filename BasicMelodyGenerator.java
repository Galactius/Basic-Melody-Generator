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

      //prompt user for number of notes to generate
      Scanner in = new Scanner(System.in);
      System.out.print("Enter the number of random notes in your melody to generate: ");
      String preNum = in.nextLine();
      int numNotes = Integer.parseInt(preNum);

      //Due to error using nextLine after nextInt, scanned tokens are taken in as strings,
      //unexpected behavior explained here: https://stackoverflow.com/questions/13102045/scanner-is-skipping-nextline-after-using-next-or-nextfoo

      //prompt user for scale to consider random notes for
      System.out.print("Enter Scale to confine melody notes: ");
      String input = in.nextLine();

      //input validation for scale, will be replaced with do loop in next iteration
      while(scaleNotes(input).equalsIgnoreCase("Scale not available"))
      {
         //prompt user for new scale if scale is invalid until valid scale found
         System.out.println("Entered scale is invalid, please enter a valid scale: ");
         input = in.nextLine();
      }

      //notes will be used by randNotes(), which selects random indexes and prints them out
      //scaleNotes returns a string and is converted into a string array here, due to issues involving the switch
      //statement and returns
      String[] notes = scaleNotes(input).split(",");
         
      System.out.print("Generating random notes... ");

      //for loop allows program to generate multiple notes or a singular note
      for(int i = 0; i < numNotes; i++)
      {
         System.out.print(randNote(notes) + " ");
      }

      in.close();
   } 

   //randNotes takes in string array, and returns a random index within the passed in array
   public static String randNote(String[] notes) 
   {
      Random gen = new Random(); 
      int randIndex = gen.nextInt(notes.length);
      
      return notes[randIndex]; 
   }

   //scaleNotes takes in a string, and returns another string that contains the notes in a specific scale,
   //valid scales correspond to the correct notes
   public static String scaleNotes(String scale)
   {
      //Next 2 lines process the entered string to account for user mistakes when entering the name of the scale
      String strLwr = scale.toLowerCase();
      String fixedScale = strLwr.replaceAll("\\s","");

      //System.out.println("strLwr: "+strLwr+", fixedScale: "+fixedScale);

      String resp;
      switch(fixedScale)
      {
         case "c":
         resp =  "C,C#,D,D#,E,F,F#,G,G#,A,A#";
         break;

         case "cmajor":
         resp = "C,D,E,F,G,A";
         break;

         case "cminor":
         resp = "C,D,D#,F,G,G#,A#,C";
         break;

         default:
         resp = "Scale not available";
         break;
      }

      return resp;
   }
}
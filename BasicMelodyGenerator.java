//Author: Daniel Perez
//Date: 12/4/20
//Objective: Generate a basic melody using random notes within a selected scale, with user-defined length. 
import java.util.Scanner; 
import java.util.Random;  

public class BasicMelodyGenerator
{
   public static void main(String[] args) 
   {        
      System.out.println("---------------------Basic Melody Generator---------------------"); 
      System.out.println("Note: # is sharp, f is flat.");
      System.out.println("Example scales: C Major, df major, cminor...");

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
         
      System.out.println("Generating random notes... ");

      //for loop allows program to generate multiple notes or a singular note
      System.out.print("Generated Melody: ");
      for(int i = 0; i < numNotes; i++)
      {
         System.out.print(randNote(notes) + " ");
      }

      in.close();

      //General program flow:
      //IN: numNotes, input (this is the name of the entered scale)
      //numNotes (info stays in main) -> output
      //input -> scaleNotes -> (converted into string containing notes in scale) main ->
      // (converted into string array) randNotes -> output
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

      String resp; //resp is a placeholder variable, used only for the switch and return
      switch(fixedScale)
      {
         case "cmajor":
            resp = "C,D,E,F,G,A";
         break;

         case "gmajor":
            resp = "G,A,B,C,D,E,F#";
         break;

         case "dmajor":
            resp = "D,E,F#,G,A,B,C#";
         break;

         case "amajor":
            resp = "A,B,C#,D,E,F#,G#";
         break;

         case "emajor":
            resp = "E,F#,G#,A,B,C#,D#";
         break;

         case "bmajor":
            resp = "B,C#,D#,E,F#,A#";
         break;

         case "f#major":
            resp = "F#,G#,A#,B,C#,D#,E#";
         break;

         case "dfmajor":
            resp = "Df,Ef,F,Gf,Af,Bf,C";
         break;

         case "afmajor":
            resp = "Af,Bf,C,Df,Ef,F,G";
         break;

         case "bfmajor":
            resp = "Bf,C,D,Ef,F,G,A";
         break;

         case "fmajor":
            resp = "F,G,A,Bf,C,D,E";
         break;

         case "aminor":
            resp = "A,B,C,E,F,G,A";
         break;

         case "dminor":
            resp = "D,E,F,G,A,Bf,C,D";
         break;

         case "gminor":
            resp = "G,A,Bf,C,D,Ef,F,G";
         break;

         case "cminor":
            resp = "C,D,Ef,F,G,Af,Bf,C";
         break;

         case "fminor":
            resp = "F,G,Af,Bf,C,Df,Ef,F";
         break;

         case "afminor":
            resp = "Af,Bf,Cf,Df,Ef,Gf,Af";
         break;

         case "efminor":
            resp = "Ef,F,Gf,Af,Bf,Cf,Df,Ef";
         break;

         case "bfminor":
            resp = "Bf,C,Df,Ef,F,Gf,Af,Bf";
         break;

         case "eminor":
            resp = "E,F#,G,A,B,C,D,E";
         break;

         case "bminor":
            resp = "B,C#,D,E,F#,G,A,B";
         break;

         case "f#minor":
            resp = "F#,G#,A,B,C#,D,E,F#";
         break;

         case "c#minor":
            resp = "C#,D#,E,F#,G#,A,B,C#";
         break;

         case "g#minor":
            resp = "G#,A#,B,C#,D#,E,F#,G#";
         break;

         case "d#minor":
            resp = "D#,E#,F#,G#,A#,B,C#,D#";
         break;

         case "a#minor":
            resp = "A#,B#,C#,D#,E#,F#,G#,A#";
         break;

         default:
            resp = "Scale not available";
         break;
      }

      return resp;
   }
}
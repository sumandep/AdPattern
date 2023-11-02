import java.util.Scanner;
import java.io.*;
import java.text.NumberFormat;

class AdPatternFinder
{
   public static void main(String[] args) throws FileNotFoundException
   {
      Scanner scan = new Scanner(new File("asgn5data.txt"));
      String pattern = scan.nextLine();
      String strOfEvents = scan.nextLine();
      int patternLength, strOfEventsLength, patternPointer, strOfEventsPointer;
      boolean found;
      int count = 0, nbFound = 0;
      patternLength = pattern.length();
      
      while (!strOfEvents.equals("#"))
      {
         count = count + 1;
         strOfEventsLength = strOfEvents.length();
         patternPointer = 0;
         strOfEventsPointer = 0;
         found = false;
         
         while (!found && (strOfEventsPointer < strOfEventsLength) 
                        && (patternPointer < patternLength))
         {
            if (strOfEvents.charAt(strOfEventsPointer) == pattern.charAt(patternPointer))
            {
               patternPointer = patternPointer + 1;
               if (patternPointer == patternLength) 
                  found = true;
            }
            strOfEventsPointer = strOfEventsPointer + 1;
         }

         if (found)
         {
            nbFound = nbFound + 1;
            System.out.println("yes");
         }
         else
         {
            System.out.println("no");
         }

         strOfEvents = scan.nextLine();
      }
      
      double percent = (double) nbFound/count;
      NumberFormat fmt = NumberFormat.getPercentInstance();
      System.out.println(nbFound + " out of " + count + ", so "
                     + fmt.format(percent));
   }
}


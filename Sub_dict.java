import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Sub_dict {

    public static void main(String[] args) throws FileNotFoundException{

        /**
         * @author Anis Zellagui
         * Comp 249, Assignement #4, return before 15/04/2022
         * This software have purpose to transform a txt file to a sub-dict alphabetically ordered.
         * The main learning is file and array-list manipulation.
         * It's perfectly working with the constraints of the project.
         * @version 1.0
         */

        //Get path name
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the file path");
        String file_input =  sc.nextLine();

        ArrayList<String> list = new ArrayList<>(); //the list where all the word will be stored
        ArrayList<String> newlist = new ArrayList<>(); //the list where all the word will be stored

        try (Scanner s = new Scanner(new File(file_input))) {
            while (s.hasNext()) {
               String word =  s.next().replaceAll("[^a-zA-Z0-9_-]", "").toUpperCase(); //Replacing by all special char by blanc
                list.add(word); // add to list
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
      for (String str : list){  //delete all repeated world
          if(!newlist.contains(str)){ //Adding items without repetition
              newlist.add(str);
          }
          if(str.length() < 2){ //if items length less than 2
              newlist.remove(str);
          }
          if(isInteger(str)){  //is item is an integer
              newlist.remove(str);
          }
      }
        sort(newlist); //Using the method sort list created bellow
        System.out.println(newlist);

        try {
            char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray(); // the alphabet as an array.
            File sub = new File("SubDictionary.txt"); //Creating the txt file
            PrintWriter writer = new PrintWriter(sub); //Creating the writer object

            writer.write("The document produced this sub-dictionary, which includes " + newlist.size() +" entries." + "\n"); //the first sentence

            //loop through the alphabet and assign each world with the corresponding first letter.
            for(char ch: alphabet) {
                writer.println("\n" + ch + "\n" + "==" );
                for (String str : newlist) {
                    if(str.startsWith(String.valueOf(ch))){
                        writer.println(str);
                    }
                }
            }
            writer.close();
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    //Method to sort list
    public static void sort(ArrayList<String> x) {
        String temp;
        for (int i = 0; i < x.size() - 1; i++) {
            for (int j = i + 1; j < x.size(); j++) {
                if (x.get(i).compareToIgnoreCase(x.get(j)) > 0) {
                    temp = x.get(i);
                    x.set(i,x.get(j));
                    x.set(j,temp);
                }
            }
        }
    }
    // method to know if the items is an integer.
    public static boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        }
        catch( Exception e ) {
            return false;
        }
    }
}


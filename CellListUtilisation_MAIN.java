import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Anis Zellagui
 * Comp 249, Assignement #4, return before 15/04/2022
 * This software have purpose to work with linked list.
 * @version 1.0
 */

public class CellListUtilisation_MAIN {

    public static void main(String[] args) throws FileNotFoundException {

        CellList list = new CellList();


//    Enter the file path to open CELL TEXT LIST
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the file path");
        String file_input =  sc.nextLine();
        // ArrayList<String> cells = new ArrayList<>();

        try (Scanner s = new Scanner(new File(file_input))) {  //Reading file
            while(s.hasNextLine()){ //Loop through each line
                String[] cells= s.nextLine().split("\\s+"); // create array to store each token

                //System.out.println(Arrays.toString(cells));

//              Create new Node Each time
                Cellphone cell = new Cellphone(Long.parseLong(cells[0]), cells[1], (int) Double.parseDouble(cells[2]), Integer.parseInt(cells[3]));
                list.addToStart(cell); //ADD NODE TO LIST
            }
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        list.display(); //Display Method
        System.out.println("\n" + "+-+-+-+-+-+-+-+-+-+-+-+");

        Cellphone phone = new Cellphone(123,"gojo",2022,999);

        list.insertAtIndex(list,phone,1);

        list.display();

        System.out.println("\n" + "+-+-+-+-+-+-+-+-+-+-+-+");

        list.deleteFromIndex(list,1);

        list.display();

        System.out.println("\n" + "+-+-+-+-+-+-+-+-+-+-+-+");

        list.deleteFromStart();

        list.display();

        System.out.println("\n" + "+-+-+-+-+-+-+-+-+-+-+-+");

        list.find(8888902);

        System.out.println("+-+-+-+-+-+-+-+-+-+-+-+");

        System.out.println(list.contains(2389076));

        System.out.println("+-+-+-+-+-+-+-+-+-+-+-+");


//        +_+_+_+_+ Creating new list to compare the element

        Cellphone phone1 = new Cellphone(123,"a",2000, 10);
        Cellphone phone2 = new Cellphone(234,"b",2001,20);
        Cellphone phone3 = new Cellphone(345,"c", 2002,30);
        Cellphone phone4 = new Cellphone(456,"d",2003,40);
        Cellphone phone5 = new Cellphone(567,"e",2004,50);
        Cellphone phone6 = new Cellphone(678,"f",2005,60);
        Cellphone phone7 = new Cellphone(789,"g", 2006, 70);
        Cellphone phone8 = new Cellphone(890,"h",2007,80);
        Cellphone phone9 = new Cellphone(901,"i",2008,90);
        Cellphone phone10 = new Cellphone(012,"j",2009,100);

        list.addToStart(phone1);
        list.addToStart(phone2);
        list.addToStart(phone3);
        list.addToStart(phone4);
        list.addToStart(phone5);
        list.addToStart(phone6);
        list.addToStart(phone7);
        list.addToStart(phone8);
        list.addToStart(phone9);
        list.addToStart(phone10);


    }
}

///Users/zela/Documents/Webapp/ASI4-comp249/src/Cell_Info.txt
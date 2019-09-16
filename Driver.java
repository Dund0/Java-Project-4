//Daniel Sanandaj
//YoungJin Seo
//Tony Tong

import java.util.*;
import java.io.*;

public class Driver{
   
   
   public static void main (String[] args) throws IOException{
      Scanner scan = new Scanner(System.in);
      GroupData list = new GroupData();
   
      //reads in the data file
      File inFile = new File("data.txt");
      Scanner inputFile = null;
      
      //check if data file is found
      try {
         long id = 0;
         String name = "";
         boolean inGroup[] = null;
         String fileLine = "";
         
       //check if data file is found
         inputFile = new Scanner(inFile);

         //read from data file
         while (inputFile.hasNext()){
            fileLine = inputFile.nextLine();
            StringTokenizer items = new StringTokenizer(fileLine, ",", false);
         
            //uses loop to identify each part of student
            for (int i = 0; i < 3; i++){
               String token;
            
            //gets student id
               if (i == 0){
                  token = items.nextToken();
                  id = Integer.valueOf(token);
               }
            
            //gets student name
               if (i==1){
                  token = items.nextToken();
                  name = token;
               }
            
            //gets students group
               if  (i==2){
                  token = items.nextToken();
                  inGroup = new boolean[token.length()-1];
                  for (int k = 1; k < token.length(); k++){
                     switch(token.charAt(k)){
                        case 'T':
                           inGroup[k-1] = true;
                           break;
                        case 'F':
                           inGroup[k-1] = false;
                           break;
                        default:
                     }
                  }
               }
            }
            	//create Student object and add into array list
            	Student student = new Student(id, name, inGroup);
            	list.insert(student);
         }
            
         
      } catch (FileNotFoundException e) {
         //display error message
         System.out.println("Data file not found!");
         System.exit(0);
      }
      inputFile.close();
      
      //menu: checks for wrong inputs
      String choice = "";
      while(choice != "quit"){
         boolean check = false;
    	 System.out.print("What would you like to do? \n>");
         choice = scan.nextLine();
         switch (choice){
         case "help":
            System.out.println("Your options are: ");
            System.out.println("add \t (adds a student)");
            System.out.println("drop \t (drops a student)");
            System.out.println("find \t (finds a student)");
            System.out.println("size \t (outputs the size of the group)");
            System.out.println("members (outputs the members of a group)");
            System.out.println("largest (outputs the largest size of any group)");
            System.out.println("smallest (outputs the smallest size of any group)");
            System.out.println("cover (outputs the minimum number of groups which cover all students)");
            System.out.println("quit \t (ends the program)\n");
            break;
            
         case "add":
            String name = null;
            String inputString = null;
            Long id = (long) 0;
            
            //name input
            while(!check) {
            	System.out.print("Name?\n>");
                name = scan.nextLine();
                
                for (int i = 0; i < name.length(); i++) {
                    char c = name.charAt(i);
                    // Check whether c is a digit
                    if (Character.isDigit(c)) {
                        System.out.println("Do not use digits!\n");
                        break;
                    }
                    check = true;
                }
            }
            
            //id input
            check = false;
            while(!check) {
            	try {
            		System.out.print("ID Number?\n>");
            		id = scan.nextLong();
            		check = true;
            	
            	} catch(Exception  e) {
            		System.out.println("Please enter a number.\n");
            		scan.nextLine();
            	}
            }
            scan.nextLine();
            check = false;
            
            //group input
            while(!check) {
            	System.out.print("Groups?\n>");
                inputString = scan.nextLine();
                if (inputString.length() == list.groups.length)
                	check = true;
                else
                	System.out.println("\nPlease enter " + list.groups.length + " groups.\n");
            }
            
            System.out.println();
            
            //create boolean array for student object
            boolean[] inGroup = initialize(inputString);
            Student s = new Student(id, name, inGroup);
            list.insert(s);
            break;
            
         case "drop":
            long dId = 0;
            check = false;
            while(!check) {
            	try {
            		System.out.print("ID Number?\n>");
            		dId = scan.nextLong();
            		check = true;
            	
            	} catch(Exception  e) {
            		System.out.println("Please enter a number.\n");
            		scan.nextLine();
            	}
            }
            scan.nextLine();
            Student sd = list.find(dId);
            list.delete(sd);
            System.out.println("Removing: " + sd + "\n");
            break;
         
         case "find":
        	long fId = 0;
        	check = false;
            while(!check) {
            	try {
            		System.out.print("ID Number?\n>");
            		dId = scan.nextLong();
             		check = true;
             	
             	} catch(Exception  e) {
             		System.out.println("Please enter a number.\n");
             		scan.nextLine();
             	}
            }
            scan.nextLine();
            System.out.println(list.find(fId)+"\n");
            break;
            
         case "size":
            int groupNum = 0;
            check = false;
            while(!check) {
            	try {
                    System.out.print("Group?\n>");
                    groupNum = scan.nextInt();
             		check = true;
             	
             	} catch(Exception  e) {
             		System.out.println("Please enter a number.\n");
             		scan.nextLine();
             	}
            }
            scan.nextLine();
            System.out.println("Size of Group " + groupNum + ": " + list.numInGroup(groupNum) + "\n");
            break;
            
         case "members":
        	 int groupNum2 = 0;
        	check = false;
            while(!check) {
             	try {
                     System.out.print("Group?\n>");
                     groupNum2 = scan.nextInt();
              		check = true;
              	
              	} catch(Exception  e) {
              		System.out.println("Please enter a number.\n");
              		scan.nextLine();
              	}
            }
            scan.nextLine();
            System.out.println(list.members(groupNum2));
            break;
         
         case "largest":
            System.out.println(list.sizeLargest() + "\n");
            break;
            
         case "smallest":
            System.out.println(list.sizeSmallest() + "\n");
            break;
            
         case "cover":
        	System.out.println("Minimum # of groups to cover all members: " + list.numToReachAll() + "\n");
            break;
            
         case "quit":
         case "exit":
         case "stop":
            System.out.println("quitting");
            System.exit(0);
            
         default:
            System.out.println("not a correct command\n");
         }
      }
   }
   
   //initialize boolean array to hold group membership
   public static boolean[] initialize(String s){
      boolean[] inGroup = new boolean[s.length()];
      for (int k = 0; k < inGroup.length; k++){
         switch(s.charAt(k)){
            case 'T':
               inGroup[k] = true;
               break;
            case 'F':
               inGroup[k] = false;
               break;
            default:
         }
      }
      return inGroup;
   }
}
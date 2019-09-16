//Daniel Sanandaj
//YoungJin Seo
import java.util.*;

public class GroupData implements DataStructOfItemsInGroups<Student>{
   public LinkedList<Student> data; //linked list of students
   public int size; //number of students
   public int[] groups; // holds number of people in each group
   
   public GroupData(){
      data = new LinkedList<Student>();
   }
    
   //insert student into arraylist
   public void insert(Student newStudent){
      if (groups == null)
         groups = new int[newStudent.getGroups().length];  
      data.add(newStudent);
      size++;
      
      for(int i = 0; i < groups.length; i++){
         if(newStudent.getGroups()[i])
            groups[i] = groups[i]+1;
      }
   }
   
   //delete student from arraylist
   public void delete(Student remStudent){
      for(int i = 0; i < groups.length; i++){
         if(remStudent.getGroups()[i])
            groups[i]--;
      }
      
      data.remove(remStudent);
      size--;
   } 
   
   //find student with the id
   public Student find(long id){
      Student findId = new Student(id);
      for(int i = 0; i < size; i++){
         if(data.get(i).getId()- findId.getId() == 0)
            return data.get(i);
      }
      System.out.println("Student does not exist!");
      return null;
   }
   
   //number of people in a group
   public int numInGroup(int num){
      return groups[num];
   }
   
   //size of largest group
   public int sizeLargest(){
      int max = groups[0];
      for(int i = 1; i < groups.length; i++){    
         if (groups[i] > max)
            max = groups[i];
      }
      return max;    
   }
   
   
   //size of smallest group
   public int sizeSmallest(){
      int min = groups[0];
      for (int i = 1; i < groups.length; i++){
         if (groups[i] < min)
            min = groups[i];
      }
      return min;
   }
   
   //print the members of a group
   public String members(int num){
      String fullString = "";
      if(num > groups.length-1) {
         return "No members are in this group\n";
      }
      for(Student s: data){
         if(s.getGroups()[num])
            fullString = fullString + s.toString() + "\n";
      }
      return fullString;
   }
   
   //find how many groups cover all students
   public int numToReachAll(){
      int counter = size;
      int groupCounter = 0;
      int falseCounter;
      
      //create list of groups in size order
      GroupList list = new GroupList();
      list.createGroupList(groups);
      list.largestGroupOrder();
      
      //if no one is in a group return 0;
      for(Student s: data) {
    	  falseCounter = 0;
    	  for(int i = 0; i < groups.length; i++) {
        	  if(s.getGroups()[i] == false)
        		  falseCounter++;
          }
    	  if (falseCounter == groups.length){
         	 return 0;
          }
      }

      
      for(int i = 0; i < list.getSize() && counter != 0 ; i++) {
          boolean groupCheck = false;
    	  for(Student s: data) {
            if(s.getChecked()) {
               
            }
            else if(s.getGroups()[list.get(i).getNumber()]){
               s.setChecked(true);
               counter--;
               groupCheck = true;
            }
         }
         if(groupCheck)
        	 groupCounter++;
      }
      
      //reset students
      for(Student s: data) {
         if(s.getChecked()) {
            s.setChecked(false);
         }
      }
      return groupCounter;
   }
   
   
}
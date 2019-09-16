//Daniel Sanandaj
//YoungJin Seo
public class Student implements DataItem<Student>{
   public long id;
   public String name;
   public boolean[] inGroup;
   public boolean checked;
  
   //student constructor
   public Student(Long setId, String setName, boolean[] setGroup){
      id = setId;
      name = setName;
      inGroup = setGroup;
      checked = false;
   }
   
   //student constructor for just an id
   public Student(long setId){
      id = setId;
      name = "";
      inGroup = null;
   }
   
   public long getId(){
      return this.id;
   }
   
   public String getName(){
      return this.name;
   }
   
   public boolean[] getGroups(){
      return this.inGroup;
   }
   
   public boolean getChecked() {
	   return this.checked;
   }
   
   public void setChecked(boolean b) {
	   checked = b; 
   }
   
   public boolean memberOfGroup(int groupNumber){
      if(this.getGroups()[groupNumber-1])
         return true;
      else return false;
   }
   
   //compare ids
   public int compareTo(Student s){
      Integer studentId = (int)(long)s.getId();
      Integer id2 = (int)(long)this.id;
      Integer result = id2.compareTo(studentId);
      if (result < 0)
         return -1;
      else if(result == 0)
         return 0;
      else
         return 1;
   }
   
   //allows printing of students
   public String toString(){
      String fullString = this.getId() + "," + this.getName() + ", ";
      boolean booleanArray[] = this.getGroups();
      for (int i = 0; i < booleanArray.length; i++){
         if(booleanArray[i]){
            fullString = fullString+"T";
         }
         else{
            fullString = fullString+"F";
         }
      }
      return fullString;
   }
}



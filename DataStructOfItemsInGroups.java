//Daniel Sanandaj
//YoungJin Seo
public interface DataStructOfItemsInGroups <E extends DataItem<E>> {

   public void insert(E item);
   public void delete(E item);
   public E find(long id);
   public int numInGroup(int num); // numebr of people in the group
   //largest group
   public int sizeLargest();
   //size smallest
   public int sizeSmallest();
   public String members(int num); //prints all the members in the group
   public int numToReachAll(); //cover

}

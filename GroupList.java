//Daniel Sanandaj
//YoungJin Seo
import java.util.*;

public class GroupList {
	public LinkedList<Group> groupsList;
	public int size;
	
	public GroupList() {
		groupsList = new LinkedList<Group>();
	}
	
	//create array of largest groups in order
	public void largestGroupOrder(){
		   
		Collections.sort(groupsList, new Comparator<Group>() {
			@Override
			public int compare(Group o1, Group o2) {
				return o2.getSize() - o1.getSize();
			}
		});};
		
	public void createGroupList(int[] groups) {
		for(int i = 0; i < groups.length; i++) {
			int size2 = groups[i];
			Group g = new Group(size2, i);
			groupsList.add(g);
			size++;
		}
	}

	public int getSize() {
		return size;
	}
	
	public Group get(int i) {
		return groupsList.get(i);
	}
}

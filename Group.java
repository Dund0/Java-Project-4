//Daniel Sanandaj
//YoungJin Seo
public class Group {
	private Integer size;
	private int number;
	
	public Group (int setSize, int setNumber) {
		size = setSize;
		number = setNumber;
	}
	
	public void setSize(int setSize) {
		size = setSize;
	}
	
	public void setNumber(int setNumber) {
		number = setNumber;
	}
	
	public int getSize(){
		return size;
	}
	
	public int getNumber() {
		return number;
	}
	
	public int compareTo(Group g) {
		Integer g1 = g.getSize();
		Integer result = this.size.compareTo(g1);
		if (result < 0)
	         return -1;
	      else if(result == 0)
	         return 0;
	      else
	         return 1;
	}
}

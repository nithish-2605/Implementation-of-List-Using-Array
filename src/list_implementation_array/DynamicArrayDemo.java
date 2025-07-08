package list_implementation_array;
import java.util.*;


class DynamicArray{
	
	private static final int initialArraySize = 3;
	private int[] arr;
	private int size,capacity;

	
	DynamicArray(){
		arr = new int[initialArraySize];
		size = 0;
		capacity = initialArraySize;
	}
	
	public void add(int data) {
		if(size == capacity) {
			expandArraySize();
		}
		arr[size++] = data;
	}
	
	public void display() {
		System.out.println("Elements in the List:");
		for(int i=0;i<size;i++){
			System.out.print(arr[i]+" ");
		}
		
	}
	
	void insertData(int pos, int data) {
		if(size == capacity){
			expandArraySize();
		}
		for(int i = size-1; i>=pos;i--){
			arr[i+1] = arr[i];
		}

		arr[pos] = data;
		size++;

}
	
	void delete(int pos) {
		for(int i=pos+1;i<size;i++){
			if(pos+1 <= 0){
				System.out.println("Enter +ve values");
			}
				arr[i-1] = arr[i];
		}
		size--;
	}

	public void addFirst(int data){
		insertData(0,data);
	}

	public void addLast(int data){
		add(data);
	}

	public void deleteFirst(){
		delete(0);
	}

	public void deleteLast(){
		delete(size-1);
	}


	private void expandArraySize() {
		capacity *= 2;
		arr = java.util.Arrays.copyOf(arr,capacity);
	}
	
}


public class DynamicArrayDemo {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int choice,data,pos;
		
		DynamicArray list = new DynamicArray();
		
		
		while(true) {
			System.out.println("------------Menu--------------\n");
			System.out.println("1.add Data at end\n");
			System.out.println("2.Display the list\n");
			System.out.println("3.Insert Data at specified position\n");
			System.out.println("4.Delete from the specified position\n");
			System.out.println("5.Add first\n");
			System.out.println("6.Add Last\n");
			System.out.println("7.delete first\n");
			System.out.println("8.delete Last\n");
			System.out.println("9.Exit\n");
			System.out.println("--------------------------------\n");
			
			
			System.out.print("Enter the choice:");
			choice = scan.nextInt();
			
			switch(choice) {
			case 1: System.out.println("Enter the Data");
			data = scan.nextInt();
			list.add(data);
			break;
			
			case 2:  list.display();
			break;
			
			case 3: System.out.println("Enter Position");
			pos = scan.nextInt();
			System.out.println("Enter the Data");
			data = scan.nextInt();
			list.insertData(pos,data);
			break;
			
			case 4: System.out.println("Enter position of the element to be deleted");
			pos = scan.nextInt();
			System.out.println("Enter the Data");
			list.delete(pos);
			break;

			case 5: System.out.println("Enter the element to be added in first of the list");
			data = scan.nextInt();
			list.addFirst(data);
			break;

			case 6: System.out.println("Enter the element to be added in last of the list");
			data = scan.nextInt();
			list.addLast(data);
			break;

			case 7: list.deleteFirst();
			System.out.println("Element Deleted");
			break;

			case 8: list.deleteLast();
			System.out.println("Element Deleted");
			break;
			
			case 9: System.exit(0);
			break;
			default: System.out.println("Invalid input");
			
			
			}
		}
		
	}
}

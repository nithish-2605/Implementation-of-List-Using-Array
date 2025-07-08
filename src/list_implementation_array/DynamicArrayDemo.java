package list_implementation_array;
import java.util.*;


class DynamicArray{
	
	private static final int initialArraySize = 3;
	private int[] arr;
	private int size;
	private int capacity;
	
	DynamicArray(){
		arr = new int[initialArraySize];
		size = 0;
		capacity = initialArraySize;
	}
	
	public void add(int data) {
		if(size == capacity) {
			doubleArraySize();
		}
		arr[size++] = data;
	}
	
	public void display() {
		System.out.println("The Elements are:");
		for(int i:arr) {
			System.out.print(i+" ");
		}
		
	}
	
	void insertData(int pos, int data) {
		
		
		if(capacity == size) {
			doubleArraySize();
		}
		
		
		
		for(int i=size-1;i>pos+1;i--) {
			arr[i+1] = arr[i];
		}
		
		arr[pos] = data;
		size++;
	
}
	
	void delete(int pos) {
		for(int i=pos; i<size-1; i++) {
			arr[i] = arr[i+1];
			arr[i+1] = 0;
		}
		
		size--;
	}
	
	private void doubleArraySize() {
		capacity = capacity * 2;
		arr = java.util.Arrays.copyOf(arr, capacity);
	}
	
}


public class DynamicArrayDemo {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int choice,data,pos;
		
		DynamicArray list = new DynamicArray();
		
		
		while(true) {
			System.out.println("------------Menu--------------");
			System.out.println("1.add Data at end\n");
			System.out.println("2.Display the list\n");
			System.out.println("3.Insert Data at specified position");
			System.out.println("4.Delete from the specified position\n");
			System.out.println("5.Exit\n");
			System.out.println("--------------------------------");
			
			
			System.out.print("Enter the choice");
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
			
			case 5: System.exit(0);
			
			default: System.out.println("Invalid input");
			
			
			}
		}
		
	}
}

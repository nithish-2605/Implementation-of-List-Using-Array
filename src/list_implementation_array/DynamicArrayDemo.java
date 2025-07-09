package list_implementation_array;
import java.util.*;


class DynamicArray<T>{
	
	private static final int initialArraySize = 3;
	private T[] arr;
	private int size,capacity;

	
	DynamicArray(){
		arr = (T[]) new Object[initialArraySize];
		size = 0;
		capacity = initialArraySize;
	}
	
	public void add(T data) {
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
	
	public void insertData(int pos, T data) {
		if(size == capacity){
			expandArraySize();
		}
		for(int i = size-1; i>=pos;i--){
			arr[i+1] = arr[i];
		}

		arr[pos] = data;
		size++;

}
	
	public void delete(int pos) {
		for(int i=pos+1;i<size;i++){
			if(pos+1 <= 0){
				System.out.println("Enter +ve values");
			}
				arr[i-1] = arr[i];
		}
		size--;

		if(capacity > initialArraySize && capacity > 3 * size){
			shrinkArray();
		}
	}

	public void addFirst(T data){
		insertData(0,data);
	}

	public void addLast(T data){
		add(data);
	}

	public void deleteFirst(){
		delete(0);
	}

	public void deleteLast(){
		delete(size-1);
	}


	public boolean contains(T data){
		for (int i = 0; i < size; i++) {
			if(arr[i] == data){
				return   true;
			}
		}
		return false;
	}

	public int searchElement(T data){
		for(int i = 0;i<size;i++){
			if(arr[i] == data){
				return i+1;
			}
		}

		System.out.println("Element not found");
		return -1;
	}

	public void updateData(int pos, T data){
		arr[pos] = data;
	}

	private void expandArraySize() {
		capacity *= 2;
		arr = java.util.Arrays.copyOf(arr,capacity);
	}

	private  void shrinkArray(){
		capacity /= 2;
		arr = java.util.Arrays.copyOf(arr,capacity);
	}
	
}


public class DynamicArrayDemo {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int choice,pos;
		String data;

		DynamicArray<String> list = new DynamicArray<>();
		
		
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
			System.out.println("9.contains\n");
			System.out.println("10.Search Element\n");
			System.out.println("11.Update\n");
			System.out.println("12.Exit\n");
			System.out.println("--------------------------------\n");
			
			
			System.out.print("Enter the choice:");
			choice = scan.nextInt();
			
			switch(choice) {
			case 1: System.out.println("Enter the Data");
			data = scan.next();
			list.add(data);
			break;
			
			case 2:  list.display();
			break;
			
			case 3: System.out.println("Enter Position");
			pos = scan.nextInt();
			System.out.println("Enter the Data");
			data = scan.next();
			list.insertData(pos,data);
			break;
			
			case 4: System.out.println("Enter position of the element to be deleted");
			pos = scan.nextInt();
			System.out.println("Enter the Data");
			list.delete(pos);
			break;

			case 5: System.out.println("Enter the element to be added in first of the list");
			data = scan.next();
			list.addFirst(data);
			break;

			case 6: System.out.println("Enter the element to be added in last of the list");
			data = scan.next();
			list.addLast(data);
			break;

			case 7: list.deleteFirst();
			System.out.println("Element Deleted");
			break;

			case 8: list.deleteLast();
			System.out.println("Element Deleted");
			break;

			case 9: System.out.println("Enter Element to check wheather it is present or not");
			data = scan.next();
			System.out.println(list.contains(data));
			break;

			case 10: System.out.println("Enter Element to search the position");
			data = scan.next();
			System.out.println(list.searchElement(data));
			break;

			case 11:System.out.println("Enter Position");
			pos = scan.nextInt();
			System.out.println("Enter the Data");
			data = scan.next();
			list.updateData(pos,data);
			break;
			
			case 12: System.exit(0);
			break;
			default: System.out.println("Invalid input");

			}
		}
		
	}
}

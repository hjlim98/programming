package Sort;

import java.util.Scanner;

public class BubbleSort {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arr[] = new int[10];
		
		for(int k=0; k<arr.length; k++) {
			arr[k] = sc.nextInt();
		}
		
		int i, j, temp;
		
		for(i=0; i<arr.length; i++) {
			for(j=0; j<9-i; j++) {
				if(arr[j] > arr[j+1]) {
					temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
		for(i=0; i<10; i++) {
			System.out.print(arr[i] + " ");		
		}		
	}
}

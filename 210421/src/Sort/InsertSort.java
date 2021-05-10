package Sort;

import java.util.Scanner;

public class InsertSort {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int arr[] = new int[10];
		
		for(int k=0; k<10; k++) {
			arr[k] = sc.nextInt();
		}
		
		int i, j, temp;
		for(i=0; i<9; i++) {
			j=i;
			while(j>0 && arr[j-1] > arr[j+1]) {
				temp=arr[j-1];
				arr[j-1]=arr[j+1];
				arr[j+1]=temp;
				j--;
			}
		}		
		for(i=0; i<10; i++) {
			System.out.print(arr[i] + " ");		
		}
	}
}

package Sort;

import java.util.Scanner;

public class SelectSort {
	public static void main(String[] args) {
		int arr[] = new int[10];
		Scanner sc = new Scanner(System.in);
		
		for(int k=0; k<10; k++) {
			arr[k] = sc.nextInt();
		}
		
		int i, j, min, index, temp;
		
		for(i=0; i<10; i++) {
			min=9999;
			index=0;
			for(j=i; j<10; j++) {
				if(min>arr[j]) {
					min=arr[j];
					index=j;
				}				
			}
			temp=arr[i];
			arr[i]=arr[index];
			arr[index]=temp;
		}
		
		for(i=0; i<10; i++) {
			System.out.print(arr[i] + " ");		}
	}
}

package Sort;

public class QuickSort {
	private static int data[]= {1,10,5,8,7,6,4,3,2,9};
	private static int number=10;
	
	public static void quickSort(int[] data, int start, int end) {
		if(start>=end) {
			return;
		}
		int pivot=start;
		int i=start+1;
		int j=end;
		int temp;
		
		while(i<=j) { //엇갈릴 때까지 반목 j가 i보다 크거나 같으면  while문 종료
			while(i<=end&& data[i]<data[pivot]) { //피봇값보다 큰 값을 만날 때 까지
				i++;
			}
			while(j>start && data[j]>=data[pivot]) { //피봇값보다 작은 값을 만날 때 가지
				j--;
			}
			if(i>j) { //현재 엇갈린 상태라면
				temp=data[j];
				data[j]=data[pivot];
				data[pivot]=temp;
			}else {
				temp=data[i];
				data[i]=data[j];
				data[j]=temp;
			}
		}
		quickSort(data, start, j-1);
		quickSort(data, j+1, end);
	}
		public static void show() {
			for(int i=0; i<data.length;i++) {
				System.out.print(data[i]+"  ");
			}
		}	

	public static void main(String[] args) {
		quickSort(data, 0, number-1);
		show();
	}
}

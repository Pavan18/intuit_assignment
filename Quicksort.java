
public class Quicksort {

	private int array[];
	private int length;
	
	public void sort(int [] input)
	{
		if(input == null || input.length == 0)
		{
			return;
		}
		array=input;
		length=input.length;
		quicksort(0,length-1);
		
	}
	
	public void quicksort(int low, int high){
		int i=low;
		int j=high;
		
		int pivot=array[low+(high-low)/2];
		while(i<=j){
			while(array[i]<pivot)
			{
				i++;
			}
			while(array[j]>pivot)
			{
				j--;
			}
			if(i<=j)
			{
				swap(i,j);
				i++;
				j--;
			}
		}
		if(low<j)
		{
			quicksort(low,j);
		}
		if(i<high)
		{
			quicksort(i,high);
		}
	}
	
	
	public void swap(int i,int j)
	{
		int temp=array[i];
		array[i]=array[j];
		array[j]=temp;
	}
	
	public static void main(String[] args) {
		
		Quicksort obj= new Quicksort();
		int[] input={1,10,5,63,29,71,10,12,44,29,10,-1};
		obj.sort(input);
		for(int i:input){
			System.out.print(i + " ");
		}
		
	}

}

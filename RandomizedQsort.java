import java.util.*; 

class RandomizedQsort 
{	 
	static void random(int arr[],int low,int high) 
	{ 
	
		Random rand= new Random(); 
		int pivot = rand.nextInt(high-low)+low; 
		
		int temp1=arr[pivot]; 
		arr[pivot]=arr[high]; 
		arr[high]=temp1; 
	} 
	
	/* This function takes last element as pivot, 
	places the pivot element at its correct 
	position in sorted array, and places all 
	smaller (smaller than pivot) to left of 
	pivot and all greater elements to right 
	of pivot */
	static int partition(int arr[], int low, int high) 
	{ 
		// pivot is chosen randomly 
		random(arr,low,high);
		int pivot = arr[high]; 
	

		int i = (low-1); 
		for (int j = low; j < high; j++) 
		{ 
			if (arr[j] < pivot) 
			{ 
				i++; 

				// swap arr[i] and arr[j] 
				int temp = arr[i]; 
				arr[i] = arr[j]; 
				arr[j] = temp; 
			} 
		} 

		// swap arr[i+1] and arr[high] (or pivot) 
		int temp = arr[i+1]; 
		arr[i+1] = arr[high]; 
		arr[high] = temp; 

		return i+1; 
	} 


	arr[] --> Array to be sorted, 
	low --> Starting index, 
	high --> Ending index */
	static void sort(int arr[], int low, int high) 
	{ 
		if (low < high) 
		{ 
			int pi = partition(arr, low, high); 

			sort(arr, low, pi-1); 
			sort(arr, pi+1, high); 
		} 
	} 

	static void printArray(int arr[]) 
	{ 
		int n = arr.length; 
		for (int i = 0; i < n; ++i) 
			System.out.print(arr[i]+" "); 
		System.out.println(); 
	} 

	public static void main(String args[]) 
	{ 
		int arr[] = {10, 7, 8, 9, 1, 5}; 
		int n = arr.length; 

		sort(arr, 0, n-1); 

		System.out.println("Sorted array"); 
		printArray(arr); 
	} 
} 


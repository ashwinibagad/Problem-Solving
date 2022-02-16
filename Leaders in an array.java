/* Write a program to print all the LEADERS in the array. 
An element is leader if it is greater than all the elements to its right side. 
And the rightmost element is always a leader. For example int the array {16, 17, 4, 3, 5, 2}, leaders are 17, 5 and 2. 
Let the input array be arr[] and size of the array be size. */

// Method 1
class LeadersInArray
{
	void printLeaders(int arr[], int size)
	{
		for (int i = 0; i < size; i++)
		{
			int j;
			for (j = i + 1; j < size; j++)
			{
				if (arr[i] <=arr[j])
					break;
			}
			if (j == size) // the loop didn't break
				System.out.print(arr[i] + " ");
		}
	}

	public static void main(String[] args)
	{
		LeadersInArray lead = new LeadersInArray();
		int arr[] = new int[]{16, 17, 4, 3, 5, 2};
		int n = arr.length;
		lead.printLeaders(arr, n);
	}
}

/* Time Complexity: O(n*n)
*/

// Method 2
/* (Scan from right) Scan all the elements from right to left in an array and keep track of maximum till now. When maximum changes its value, print it.*/

class LeadersInArray
{
	void printLeaders(int arr[], int size)
	{
		int max_from_right = arr[size-1];

		/* Rightmost element is always leader */
		System.out.print(max_from_right + " ");
	
		for (int i = size-2; i >= 0; i--)
		{
			if (max_from_right < arr[i])
			{		
			max_from_right = arr[i];
			System.out.print(max_from_right + " ");
			}
		}
	}

	public static void main(String[] args)
	{
		LeadersInArray lead = new LeadersInArray();
		int arr[] = new int[]{16, 17, 4, 3, 5, 2};
		int n = arr.length;
		lead.printLeaders(arr, n);
	}
}

/* Time Complexity: O(n)
*/

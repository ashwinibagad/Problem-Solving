/*
You are given a list of n-1 integers and these integers are in the range of 1 to n. There are no duplicates in the list. One of the integers is missing in the list. Write an efficient code to find the missing integer.
Example: 

Input: arr[] = {1, 2, 4, 6, 3, 7, 8}
Output: 5
Explanation: The missing number from 1 to 8 is 5

Input: arr[] = {1, 2, 3, 5}
Output: 4
Explanation: The missing number from 1 to 5 is 4
*/

// Method 1
class Main {
	public static int
	findDisappearedNumbers(int[] nums)
	{
		int n=nums.length;
		int sum=((n+1)*(n+2))/2;
		for(int i=0;i<n;i++)
		sum-=nums[i];
		return sum;
	}
	public static void main(String[] args)
	{
		int[] a = { 1, 2, 4, 5, 6 };
		System.out.println(findDisappearedNumbers(a));
	}
}

/*
Time Complexity: O(n). 
Only one traversal of the array is needed.
Space Complexity: O(1). 
No extra space is needed
*/

// Method 2
/* Approach: The approach remains the same but there can be overflow if n is large. 
In order to avoid integer overflow, pick one number from known numbers and subtract one number from given numbers. 
This way there won’t have Integer Overflow ever.
*/

class Main
{

	static int getMissingNo(int a[], int n)
	{
		int total = 1;
		for (int i = 2; i <= (n + 1); i++)
		{
			total += i;
			total -= a[i - 2];
		}
		return total;
	}

	public static void main(String[] args)
	{
		int[] arr = { 1, 2, 3, 5 };
		System.out.println(getMissingNo(arr, arr.length));
	}
}

/* Time Complexity: O(n). 
Only one traversal of the array is needed.
Space Complexity:O(1). 
No extra space is needed
*/

// Method 3
/* This method uses the technique of XOR to solve the problem.  
Approach: 
XOR has certain properties 
Assume a1 ^ a2 ^ a3 ^ …^ an = a and a1 ^ a2 ^ a3 ^ …^ an-1 = b
Then a ^ b = an
*/

class Main {
	// Function to find missing number
	static int getMissingNumber(int a[], int n)
	{
		int x1 = a[0];
		int x2 = 1;

		/* For xor of all the elements in array */
		for (int i = 1; i < n; i++)
			x1 = x1 ^ a[i];

		/* For xor of all the elements from 1 to n+1 */
		for (int i = 2; i <= n + 1; i++)
			x2 = x2 ^ i;

		return (x1 ^ x2);
	}

	public static void main(String args[])
	{
		int a[] = { 1, 2, 4, 5, 6 };
		int missing_number = getMissingNumber(a, a.length);
		System.out.println(missing_number);
	}
}

/*
Time Complexity: O(n). 
Only one traversal of the array is needed.
Space Complexity: O(1). 
No extra space is needed.
*/

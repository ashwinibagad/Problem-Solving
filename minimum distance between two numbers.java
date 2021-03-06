/*
Given an unsorted array arr[] and two numbers x and y, find the minimum distance between x and y in arr[]. The array might also contain duplicates. You may assume that both x and y are different and present in arr[].

Examples: 

Input: arr[] = {1, 2}, x = 1, y = 2
Output: Minimum distance between 1 
and 2 is 1.
Explanation: 1 is at index 0 and 2 is at 
index 1, so the distance is 1

Input: arr[] = {3, 4, 5}, x = 3, y = 5
Output: Minimum distance between 3 
and 5 is 2.
Explanation:3 is at index 0 and 5 is at 
index 2, so the distance is 2

Input: 
arr[] = {3, 5, 4, 2, 6, 5, 6, 6, 5, 4, 8, 3},  
x = 3, y = 6
Output: Minimum distance between 3 
and 6 is 4.
Explanation:3 is at index 0 and 6 is at 
index 5, so the distance is 4

Input: arr[] = {2, 5, 3, 5, 4, 4, 2, 3}, 
x = 3, y = 2
Output: Minimum distance between 3 
and 2 is 1.
Explanation:3 is at index 7 and 2 is at 
index 6, so the distance is 1
*/

// Method 1
class MinimumDistance {
	int minDist(int arr[], int n, int x, int y)
	{
		int i, j;
		int min_dist = Integer.MAX_VALUE;
		for (i = 0; i < n; i++) {
			for (j = i + 1; j < n; j++) {
				if ((x == arr[i] && y == arr[j] || y == arr[i] && x == arr[j]) && min_dist > Math.abs(i - j))
					min_dist = Math.abs(i - j);
			}
		}
		if (min_dist > n) {
			return -1;
		}
		return min_dist;
	}

	public static void main(String[] args)
	{
		MinimumDistance min = new MinimumDistance();
		int arr[] = { 3, 5, 4, 2, 6, 5, 6, 6, 5, 4, 8, 3 };
		int n = arr.length;
		int x = 3;
		int y = 6;

		System.out.println("Minimum distance between " + x
						+ " and " + y + " is "
						+ min.minDist(arr, n, x, y));
	}
}

/*
Time Complexity: O(n^2), Nested loop is used to traverse the array.
Space Complexity: O(1), no extra space is required.
*/

// Method 2

/*
Approach: So the basic approach is to check only consecutive pairs of x and y. 
For every element x or y, check the index of the previous occurrence of x or y and 
if the previous occurring element is not similar to current element update the minimum distance. 
But a question arises what if an x is preceded by another x and that is preceded by a y, then how to get the minimum distance between pairs.
By analyzing closely it can be seen that every x followed by a y or vice versa can only be the closest pair (minimum distance) so ignore all other pairs.
*/

class MinimumDistance
{
	int minDist(int arr[], int n, int x, int y)
	{
		
	//previous index and min distance
	int i=0,p=-1, min_dist=Integer.MAX_VALUE;
	
	for(i=0 ; i<n ; i++)
	{
		if(arr[i] ==x || arr[i] == y)
		{
			//we will check if p is not equal to -1 and
			//If the element at current index matches with
			//the element at index p , If yes then update
			//the minimum distance if needed
			if(p != -1 && arr[i] != arr[p])
				min_dist = Math.min(min_dist,i-p);
			
			//update the previous index
			p=i;
		}
	}
	//If distance is equal to int max
	if(min_dist==Integer.MAX_VALUE)
	return -1;
	return min_dist;
}

	public static void main(String[] args) {
		MinimumDistance min = new MinimumDistance();
		int arr[] = {3, 5, 4, 2, 6, 3, 0, 0, 5, 4, 8, 3};
		int n = arr.length;
		int x = 3;
		int y = 6;

		System.out.println("Minimum distance between " + x + " and " + y
				+ " is " + min.minDist(arr, n, x, y));
	}
}

/*
Time Complexity: O(n). 
Only one traversal of the array is needed.
Space Complexity: O(1). 
As no extra space is required.
*/

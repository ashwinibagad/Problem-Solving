/* Longest Span with same Sum in two Binary arrays

Given two binary arrays, arr1[] and arr2[] of the same size n. Find the length of the longest common span (i, j) where j >= i such that arr1[i] + arr1[i+1] + …. + arr1[j] = arr2[i] + arr2[i+1] + …. + arr2[j].
The expected time complexity is Θ(n).

Examples:  

Input: arr1[] = {0, 1, 0, 0, 0, 0};
       arr2[] = {1, 0, 1, 0, 0, 1};
Output: 4
The longest span with same sum is from index 1 to 4.

Input: arr1[] = {0, 1, 0, 1, 1, 1, 1};
       arr2[] = {1, 1, 1, 1, 1, 0, 1};
Output: 6
The longest span with same sum is from index 1 to 6.

Input: arr1[] = {0, 0, 0};
       arr2[] = {1, 1, 1};
Output: 0

Input: arr1[] = {0, 0, 1, 0};
       arr2[] = {1, 1, 1, 1};
Output: 1 */

// Method 1

class Test
{
	static int arr1[] = new int[]{0, 1, 0, 1, 1, 1, 1};
	static int arr2[] = new int[]{1, 1, 1, 1, 1, 0, 1};
  static int index1=0, index2=0;
	
	// Returns length of the longest common sum in arr1[] and arr2[]. Both are of same size n.
	static int longestCommonSum(int n)
	{
		// Initialize result
		int maxLen = 0;
	
		// One by one pick all possible starting points of subarrays
		for (int i=0; i<n; i++)
		{
		// Initialize sums of current subarrays
      int sum1 = 0, sum2 = 0;

      for (int j=i; j<n; j++)
      {
        // Update sums
        sum1 += arr1[j];
        sum2 += arr2[j];

        // If sums are same and current length is more than maxLen, update maxLen
        if (sum1 == sum2)
        {
          int len = j-i+1;
          if (len > maxLen)
            maxLen = len;
        }
      }
		}
		return maxLen;
	}
	
	public static void main(String[] args)
	{
		System.out.print("Length of the longest common span with same sum is ");
		System.out.println(longestCommonSum(arr1.length));
    System.out.println("The longest span with same sum is from index "+ index1 +" to "+ index2);
	}
}

/* Time Complexity : O(n2) 
Auxiliary Space : O(1) */

// Method 2

class Test
{
	static int arr1[] = new int[]{0, 1, 0, 1, 1, 1, 1};
	static int arr2[] = new int[]{1, 1, 1, 1, 1, 0, 1};
	
	// Returns length of the longest common sum in arr1[] and arr2[]. Both are of same size n.
	static int longestCommonSum(int n)
	{
		// Initialize result
		int maxLen = 0;
	
		// Initialize prefix sums of two arrays
		int preSum1 = 0, preSum2 = 0;
	
		// Create an array to store staring and ending indexes of all possible diff values. 
    // diff[i] would store starting and ending points for difference "i-n"
		int diff[] = new int[2*n+1];
	
		// Initialize all starting and ending values as -1.
		for (int i = 0; i < diff.length; i++) {
			diff[i] = -1;
		}
	
		// Traverse both arrays
		for (int i=0; i<n; i++)
		{
			// Update prefix sums
			preSum1 += arr1[i];
			preSum2 += arr2[i];
	
			// Comput current diff and index to be used in diff array. 
      // Note that diff can be negative and can have minimum value as -1.
			int curr_diff = preSum1 - preSum2;
			int diffIndex = n + curr_diff;
	
			// If current diff is 0, then there are same number
			// of 1's so far in both arrays, i.e., (i+1) is
			// maximum length.
			if (curr_diff == 0)
				maxLen = i+1;
	
			// If current diff is seen first time, then update
			// starting index of diff.
			else if ( diff[diffIndex] == -1)
				diff[diffIndex] = i;
	
			// Current diff is already seen
			else
			{
				// Find length of this same sum common span
				int len = i - diff[diffIndex];
	
				// Update max len if needed
				if (len > maxLen)
					maxLen = len;
			}
		}
		return maxLen;
	}
	
	public static void main(String[] args)
	{
		System.out.print("Length of the longest common span with same sum is ");
		System.out.println(longestCommonSum(arr1.length));
	}
}

/* Time Complexity: Θ(n) 
Auxiliary Space: Θ(n) */

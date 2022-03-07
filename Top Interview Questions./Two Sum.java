class Solution {
    public int[] twoSum(int[] nums, int target) {
        int index1=0, index2=0;
        for(int i=0;i<nums.length;i++)
        {
            for(int j=i+1;j<nums.length;j++)
            {
                if(nums[i]+nums[j]==target)
                {
                    index1=i;
                    index2=j;
                    break;
                }
            }
            
        }
        int [] arr = {index1,index2};
        return arr;
    }
}

/*Best Soltion
public int[] twoSum(int[] numbers, int target) {
    int[] result = new int[2];
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    for (int i = 0; i < numbers.length; i++) {
        if (map.containsKey(target - numbers[i])) {
            result[1] = i;
            result[0] = map.get(target - numbers[i]);
            return result;
        }
        map.put(numbers[i], i);
    }
    return result;
}
*/

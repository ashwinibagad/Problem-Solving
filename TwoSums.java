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
}s